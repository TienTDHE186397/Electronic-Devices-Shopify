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
public class SaleOrderL {
    private String orderID;
    private Date orderDate;
    private String cusName;
    private String mobile;
    private String Email;
    private String showRoomName;
    private double total;
    private String method;
    private String saleName;
    private String status;
    private String gender;
    private String address;
    private String saleNotes;
    private String saleID;
    private String shipstatus;
    

    public SaleOrderL() {
    }
      public SaleOrderL(String orderID, String cusName, String Email, String mobile, Date orderDate, int total, String saleName, String status, String gender, String address, String shipstatus , String saleNotes) {
        this.orderID = orderID;
        this.cusName = cusName;
        this.Email = Email;
        this.mobile = mobile;
        this.orderDate = orderDate;
        this.total = total;
        this.saleName = saleName;
        this.status = status;
        this.gender = gender;
        this.address = address;
        this.shipstatus = shipstatus;
        this.saleNotes = saleNotes;
       
      }

    public SaleOrderL(String orderID, Date orderDate, String cusName, String showRoomName, double total, String method, String saleName, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.cusName = cusName;
        this.showRoomName = showRoomName;
        this.total = total;
        this.method = method;
        this.saleName = saleName;
        this.status = status;
    }
    public SaleOrderL(String orderID, String saleNotes, String saleID, String status, String shipstatus){
        this.status = status;
        this.saleNotes = saleNotes;
        this.saleID = saleID;
        this.orderID = orderID;
        this.shipstatus = shipstatus;
        
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getShowRoomID() {
        return showRoomName;
    }

    public void setShowRoomID(String showRoomName) {
        this.showRoomName = showRoomName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getShowRoomName() {
        return showRoomName;
    }

    public void setShowRoomName(String showRoomName) {
        this.showRoomName = showRoomName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSaleNotes() {
        return saleNotes;
    }

    public void setSaleNotes(String saleNotes) {
        this.saleNotes = saleNotes;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }

    @Override
    public String toString() {
        return "SaleOrderL{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", cusName=" + cusName + ", mobile=" + mobile + ", Email=" + Email + ", showRoomName=" + showRoomName + ", total=" + total + ", method=" + method + ", saleName=" + saleName + ", status=" + status + ", gender=" + gender + ", address=" + address + ", saleNotes=" + saleNotes + ", saleID=" + saleID + ", shipstatus=" + shipstatus + '}';
    }
    

 
    
    
    
    
}
