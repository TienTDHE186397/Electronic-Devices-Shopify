/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DBContext;
import DAO.FeedbackService;
import Entity.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@WebServlet(name="DetailMediaServlet", urlPatterns={"/DetailMedia"})
//xác định dung lượng cho phếp để lưu trữ file
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1 MB
    maxFileSize = 1024 * 1024 * 20,  // 20 MB
    maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class DetailMediaServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FeedbackformServlet.class.getName());
    private FeedbackService feedbackService; //Đối tượng dịch vụ xử lý phản hồi
    private static final String UPLOAD_DIRECTORY = "E:\\PEPRJ301P\\webdientu\\web\\uploadfeedback"; // Thư mục lưu trữ tệp tải lên (đường dẫn tuyệt đối trong hệ thống).

    @Override
    public void init() throws ServletException {
        try {
            File uploadDir = new File(UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                logger.info("Upload directory created: " + created);
            }
            DBContext dBContext = new DBContext();
            feedbackService = new FeedbackService(UPLOAD_DIRECTORY, dBContext);
            logger.info("FeedbackController initialized successfully");
        } catch (Exception e) {
            logger.severe("Error initializing FeedbackController: " + e.getMessage());
            throw new ServletException(e);
        }
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetailMediaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailMediaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    // xử lý chức năng thêm file media cho một feedback
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String feedbackID = request.getParameter("feedbackID");  
       String desvid = request.getParameter("descriptionvid");
       String desimg = request.getParameter("descriptionimg");
       
       try {
            Feedback feedback = new Feedback();           
//                    xử lý file ảnh và video
            Collection<Part> parts = request.getParts();
            logger.info("Number of parts received: " + parts.size());

            Collection<Part> imageParts = new ArrayList<>();
            Collection<Part> videoParts = new ArrayList<>();
            for (Part part : parts) {
                String contentType = part.getContentType();
                String name = part.getName();
                logger.info("Processing part - Name: " + name + ", ContentType: " + contentType);
                if (contentType != null) {
                    if (contentType.startsWith("image/") && "images".equals(name)) {
                        imageParts.add(part);
                    } else if (contentType.equals("video/mp4") && "videos".equals(name)) {
                        videoParts.add(part);
                    }
                }
            }
            logger.info("Number of images found: " + imageParts.size());
            logger.info("Number of videos found: " + videoParts.size());
//                 điều kiện số lượng file ảnh và video
            if (imageParts.size() > 5) {
                throw new IllegalArgumentException("Maximum 5 images allowed");
            }
            if (videoParts.size() > 3) {
                throw new IllegalArgumentException("Maximum 3 videos allowed");
            }
            
            feedback.setImages(imageParts);
            feedback.setVideos(videoParts);
            if (feedbackID != null && !feedbackID.isEmpty()) {
                feedbackService.addMediaFilesToFeedback(feedback,Integer.parseInt(feedbackID), desimg, desvid);
            } else {
                throw new IllegalArgumentException("fID ID is invalid");
            }

            

            logger.info("Feedback processed successfully");

            request.setAttribute("message", "Feedback submitted successfully!");
            response.sendRedirect("FeedbackDetail?feedbackID=" + feedbackID + "&statusUpdate=success");
            return;

        } catch (Exception e) {
            logger.severe("Error processing feedback: " + e.getMessage());
            e.printStackTrace();

            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
    }  
     

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
