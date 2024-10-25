/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Feedback {
    private String feedbackID;
    private String cusName;
    private String email;
    private String phoneNumber;
    private String proName;
    private int rate;
    private String feedContent;
    private String feedReply;
    private String mktEmp;
    private String status;
    private Date createDate;
    private Date updatedDate;
    private String cusID;
    private String proID;
    private String fbDetail;
    private String storeFileName;
    private String originalFileName;
    private String filePath;
    private String fileType;
    

    public Feedback() {
    }

    public Feedback(String feedbackID, String cusName, String email, String phoneNumber, String proName, int rate, String feedContent, String feedReply, String mktEmp, String status) {
        this.feedbackID = feedbackID;
        this.cusName = cusName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.proName = proName;
        this.rate = rate;
        this.feedContent = feedContent;
        this.feedReply = feedReply;
        this.mktEmp = mktEmp;
        this.status = status;
    }
    public Feedback(String cusID, String proID, int rate, String feedContent, String status, Date createDate){
        this.cusID = cusID;
        this.proID = proID;
        this.rate = rate;
        this.feedContent = feedContent;
        this.status = status;
        this.createDate = createDate;
    }
    public Feedback(String fbDetail, String feedbackID, String storeFileName, String originalFileName, String filePath, String fileType){
        this.fbDetail = fbDetail;
        this.feedbackID = feedbackID;
        this.storeFileName = storeFileName;
        this.originalFileName = originalFileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }
    
   

   
   
    public Feedback(String feedbackID, String proName, String cusName, int rate, Date createDate, String status) {
        this.feedbackID = feedbackID;
        this.cusName = cusName;
        this.proName = proName;
        this.rate = rate;
        this.createDate = createDate;
        this.status = status;
    }
    public Feedback(String feedReply, String status, String mktEmp, String feedbackID){
        this.feedbackID = feedbackID;
        this.feedReply = feedReply;
        this.status = status;
        this.mktEmp = mktEmp;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String fID) {
        this.feedbackID = fID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedContent() {
        return feedContent;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getFeedReply() {
        return feedReply;
    }

    public void setFeedReply(String feedReply) {
        this.feedReply = feedReply;
    }

    public String getMktEmp() {
        return mktEmp;
    }

    public void setMktEmp(String mktEmp) {
        this.mktEmp = mktEmp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getFbDetail() {
        return fbDetail;
    }

    public void setFbDetail(String fbDetail) {
        this.fbDetail = fbDetail;
    }

    public String getStoreFileName() {
        return storeFileName;
    }

    public void setStoreFileName(String storeFileName) {
        this.storeFileName = storeFileName;
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
      

    @Override
    public String toString() {
        return "Feedback{" + "feedbackID=" + feedbackID + ", cusName=" + cusName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", proName=" + proName + ", rate=" + rate + ", feedContent=" + feedContent + ", feedReply=" + feedReply + ", mktEmp=" + mktEmp + ", status=" + status + '}';
    }
   
    

    
    
    
    
    
}
