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
    private int orderID;
    private Date orderDate;
    private String cusName;
    private String showRoomName;
    private double total;
    private String method;
    private String saleName;
    private String status;

    public SaleOrderL() {
    }

    public SaleOrderL(int orderID, Date orderDate, String cusName, String showRoomName, double total, String method, String saleName, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.cusName = cusName;
        this.showRoomName = showRoomName;
        this.total = total;
        this.method = method;
        this.saleName = saleName;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
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

    @Override
    public String toString() {
        return "SaleOrderList{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", cusName=" + cusName + ", showRoomName=" + showRoomName + ", total=" + total + ", method=" + method + ", saleName=" + saleName + ", status=" + status + '}';
    }
    
    
    
}
