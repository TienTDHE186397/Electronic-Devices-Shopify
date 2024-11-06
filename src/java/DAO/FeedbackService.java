/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author admin
 */
public class FeedbackService {
    private static final Logger logger = Logger.getLogger(FeedbackService.class.getName());
    private FeedbackDAO fbdao;
    private String uploadPath;
    private DBContext dBContext;

    public FeedbackService(String uploadPath, DBContext dBContext) {
        this.fbdao = new FeedbackDAO();
        this.uploadPath = uploadPath;
        this.dBContext = dBContext;
        validateUploadPath(uploadPath);
    }

    private void validateUploadPath(String path) {
        File directory = new File(path);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IllegalStateException("Could not create upload directory: " + path);
        }
        if (!directory.canWrite()) {
            throw new IllegalStateException("Upload directory is not writable: " + path);
        }
    }

   public void processFeedback(Feedback feedback) throws Exception {
    logger.info("Starting feedback processing");
    try {
        // Bắt đầu transaction
        dBContext.connection.setAutoCommit(false);
        logger.info("Transaction started");

        // Tạo bản ghi feedback
        int feedbackId = fbdao.createFeedback(feedback);
        logger.info("Feedback created with ID: " + feedbackId);

        // Kiểm tra lại giá trị feedbackId trước khi tạo thư mục
        if (feedbackId == 0) {
            throw new IllegalStateException("Invalid feedback ID: " + feedbackId);
        }

        // Tạo thư mục cho feedback này
        String feedbackDir = uploadPath + File.separator + "feedback_" + feedbackId;
        File directory = new File(feedbackDir);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IllegalStateException("Could not create feedback directory: " + feedbackDir);
        } else {
            logger.info("Feedback directory created: " + feedbackDir);
        }

        // Xử lý ảnh
        if (feedback.getImages() != null && !feedback.getImages().isEmpty()) {
            logger.info("Processing " + feedback.getImages().size() + " images");
            processFiles(feedback.getImages(), feedbackId, feedbackDir, "image");
        }

        // Xử lý video
        if (feedback.getVideos() != null && !feedback.getVideos().isEmpty()) {
            logger.info("Processing " + feedback.getVideos().size() + " videos");
            processFiles(feedback.getVideos(), feedbackId, feedbackDir, "video");
        }

        // Commit transaction
        dBContext.connection.commit();
        logger.info("Transaction committed successfully");
    } catch (Exception e) {
        // Rollback trong trường hợp có lỗi
        logger.severe("Error in processFeedback: " + e.getMessage());
        if (dBContext.connection != null) {
            try {
                dBContext.connection.rollback();
                logger.info("Transaction rolled back");
            } catch (SQLException ex) {
                logger.severe("Error rolling back transaction: " + ex.getMessage());
            }
        }
        throw e;
    } finally {
        // Reset auto-commit
        if (dBContext.connection != null) {
            try {
                dBContext.connection.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new Exception("Error resetting auto-commit", ex);
            }
        }
    }
}



   private void processFiles(Collection<Part> files, int feedbackId, String directory, String fileType) throws Exception {
    for (Part file : files) {
        try {
            String originalFileName = getFileName(file);
            logger.info("Processing file: " + originalFileName);
            if (originalFileName == null || originalFileName.isEmpty()) {
                logger.warning("Skipping file with no name");
                continue;
            }
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
            String storedFileName = UUID.randomUUID().toString() + fileExtension;
            String filePath = directory + File.separator + storedFileName;

            // Lưu tệp vào đĩa
            logger.info("Saving file to: " + filePath);
            file.write(filePath);

            // Lưu thông tin tệp vào cơ sở dữ liệu
            fbdao.saveFeedbackDetails(feedbackId, storedFileName, originalFileName, filePath, fileType);
            logger.info("File details saved to database");
        } catch (Exception e) {
            logger.severe("Error processing file: " + e.getMessage());
            throw e;
        }
    }
}


    private String getFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    logger.info("Content-Disposition: " + contentDisp); // Log nội dung header để kiểm tra
    String[] tokens = contentDisp.split(";");
    for (String token : tokens) {
        if (token.trim().startsWith("filename")) {
            String filename = token.substring(token.indexOf("=") + 2, token.length() - 1);
            logger.info("Extracted filename: " + filename); // Log tên tệp để kiểm tra
            return filename;
        }
    }
    return "";
}

}

