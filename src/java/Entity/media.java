/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class media {
    private int feedbackDetailID;
    private int feedbackID;
    private String storedFileName;
    private String originalFileName;
    private String filePath;
    private String fileType;
    private String contentType; 

    public media() {
    }

   public media(int feedbackDetailID, int feedbackID, String storedFileName, String originalFileName, String filePath, String fileType, String contentType) {
        this.feedbackDetailID = feedbackDetailID;
        this.feedbackID = feedbackID;
        this.storedFileName = storedFileName;
        this.originalFileName = originalFileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.contentType = contentType;
    }


    public int getFeedbackDetailID() {
        return feedbackDetailID;
    }

    public void setFeedbackDetailID(int feedbackDetailID) {
        this.feedbackDetailID = feedbackDetailID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getStoredFileName() {
        return storedFileName;
    }

    public void setStoredFileName(String storedFileName) {
        this.storedFileName = storedFileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "media{" + "feedbackDetailID=" + feedbackDetailID + ", feedbackID=" + feedbackID + ", storedFileName=" + storedFileName + ", originalFileName=" + originalFileName + ", filePath=" + filePath + ", fileType=" + fileType + '}';
    }
    
}
