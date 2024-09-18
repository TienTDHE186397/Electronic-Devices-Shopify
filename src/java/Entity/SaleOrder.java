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
public class SaleOrder {
    private int orderID;
    private Date orderDate;
    private String cusName;
    private double total;
    private String status;

    public SaleOrder() {
    }

    public SaleOrder(int orderID, Date orderDate, String cusName, double total, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.cusName = cusName;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SaleOrder{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", cusName=" + cusName + ", total=" + total + ", status=" + status + '}';
    }
    
}
