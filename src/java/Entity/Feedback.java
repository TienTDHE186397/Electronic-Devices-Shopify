package Entity;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author admin
 */
public class Feedback {
    private String feedbackID;
    private String cusName;
    private String proName;
    private int rate;
    private Date createDate;
    private String status;
    private String feedContent;
    private Date updatedDate;
    

    public Feedback() {
    }

    public Feedback(String feedbackID, String proName, String cusName, int rate, Date createDate, String status) {
        this.feedbackID = feedbackID;
        this.cusName = cusName;
        this.proName = proName;
        this.rate = rate;
        this.createDate = createDate;
        this.status = status;
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

    @Override
    public String toString() {
        return "Feedback{" + "feedbackID=" + feedbackID + ", cusName=" + cusName + ", proName=" + proName + ", rate=" + rate + ", createDate=" + createDate + ", status=" + status + ", updatedDate=" + updatedDate + '}';
    }
    
}
