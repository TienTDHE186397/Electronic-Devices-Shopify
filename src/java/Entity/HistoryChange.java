/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

/**
 *
 * @author Dokkuhai
 */
public class HistoryChange {
    private int historyID;
    private int personID;
    private String email;
    private String fullName;
    private String gender;
    private String mobile;
    private String address;
    private String updatedBy;
    private Timestamp updatedDate;

    public HistoryChange() {
    }

    public HistoryChange(int historyID, int personID, String email, String fullName, String gender, String mobile, String address, String updatedBy, Timestamp updatedDate) {
        this.historyID = historyID;
        this.personID = personID;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.mobile = mobile;
        this.address = address;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public HistoryChange(int personID, String email, String fullName, String gender, String mobile, String address, String updatedBy) {
        this.personID = personID;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.mobile = mobile;
        this.address = address;
        this.updatedBy = updatedBy;
    }

    
    
    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "HistoryChange{" + "personID=" + personID + ", email=" + email + ", fullName=" + fullName + ", gender=" + gender + ", mobile=" + mobile + ", address=" + address + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + '}';
    }
    
    
}
