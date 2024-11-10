/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class MyOrder {
    private String orderID;
    private Date orderDate;
    private String personID;
    private String showroomID;
    private double totalMoney;
    private int quatity;
    private String method;
    private String saleID;
    private String status;
    private String shipStatus;
    private Date completeDate;
    private Date exportedDate;
    private Date inDeliveryDate;
    private Date receivedDate;
    private String productID;
    private String img;
    private String productName;
    private double price;
    private double totalCost;
    private String pimg;
    private Date deliveredDate;
    private String receivedName;
    private String receivedPhone;
    private String receivedAddress;
    

    public MyOrder() {
    }
    
    public MyOrder(String receivedName, String receivedPhone, String receivedAddress){
        this.receivedName = receivedName;
        this.receivedPhone = receivedPhone;
        this.receivedAddress = receivedAddress;
    }

    public MyOrder(Date orderDate, String personID, String showroomID, double totalMoney, int quatity, String method, String saleID, String status, String shipStatus) {
        this.orderDate = orderDate;
        this.personID = personID;
        this.showroomID = showroomID;
        this.totalMoney = totalMoney;
        this.quatity = quatity;
        this.method = method;
        this.saleID = saleID;
        this.status = status;
        this.shipStatus = shipStatus;
    }
    
    
   
    public MyOrder(String orderID, Date orderDate, String personID, String showroomID, double totalMoney, String method, String saleID, String status, String shipStatus, Date completeDate, Date exportedDate, Date inDeliveryDate, Date receivedDate, String productID, String img, String ProductName, double price) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.personID = personID;
        this.showroomID = showroomID;
        this.totalMoney = totalMoney;
        this.method = method;
        this.saleID = saleID;
        this.status = status;
        this.shipStatus = shipStatus;
        this.completeDate = completeDate;
        this.exportedDate = exportedDate;
        this.inDeliveryDate = inDeliveryDate;
        this.receivedDate = receivedDate;
        this.productID = productID;
        this.img = img;
        this.productName = ProductName;
        this.price = price;
    }
    public MyOrder(String orderID, String productID, String productName, String img, int quantity, double price, double totalCost) {
        this.orderID = orderID;       
        this.productID = productID;
        this.productName = productName;
        this.img = img;
        this.price = price;
        this.quatity = quantity;
        this.totalCost = totalCost;
      
    }
    public MyOrder(String orderID, Date orderDate, String personID, String showroomID, double totalMoney, String method, String saleID, String status, String shipStatus, Date completeDate, Date exportedDate, Date inDeliveryDate, Date DeliveredDate, Date receivedDate) {
        
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.personID = personID;
        this.showroomID = showroomID;
        this.totalMoney = totalMoney;
        this.method = method;
        this.saleID = saleID;
        this.status = status;
        this.shipStatus = shipStatus;
        this.completeDate = completeDate;
        this.exportedDate = exportedDate;
        this.inDeliveryDate = inDeliveryDate;
        this.deliveredDate = DeliveredDate;
        this.receivedDate = receivedDate;
      
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

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getShowroomID() {
        return showroomID;
    }

    public void setShowroomID(String showroomID) {
        this.showroomID = showroomID;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Date getExportedDate() {
        return exportedDate;
    }

    public void setExportedDate(Date exportedDate) {
        this.exportedDate = exportedDate;
    }

    public Date getInDeliveryDate() {
        return inDeliveryDate;
    }

    public void setInDeliveryDate(Date inDeliveryDate) {
        this.inDeliveryDate = inDeliveryDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedPhone() {
        return receivedPhone;
    }

    public void setReceivedPhone(String receivedPhone) {
        this.receivedPhone = receivedPhone;
    }

    public String getReceivedAddress() {
        return receivedAddress;
    }

    public void setReceivedAddress(String receivedAddress) {
        this.receivedAddress = receivedAddress;
    }
    public String getFormattedOrderDate() {
        if (orderDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(orderDate);
        }
        return "";
    }

    public String getFormattedCompleteDate() {
        if (completeDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(completeDate);
        }
        return "";
    }

    public String getFormattedExprotedDate() {
        if (exportedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(exportedDate);
        }
        return "";
    }

    public String getFormattedInDeliveryDate() {
        if (inDeliveryDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(inDeliveryDate);
        }
        return "";
    }

    public String getFormattedDeliveredDate() {
        if (deliveredDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(deliveredDate);
        }
        return "";
    }

    public String getFormattedReceivedDate() {
        if (receivedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
            return sdf.format(receivedDate);
        }
        return "";
    }

    
    @Override
    public String toString() {
        return "MyOrder{" + "CompleteDate=" + completeDate + ", ExprotedDate=" + exportedDate + ", Address=" + inDeliveryDate + '}';
    }
    
}
