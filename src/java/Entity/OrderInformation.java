/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nghie
 */
public class OrderInformation {
    private int OrderID;
    private String Name;
    private String Phone;
    private String Address;
    private String payment;
    private double TotalCost;
    private String OrderStatus;

    public OrderInformation() {
    }

    public OrderInformation(int OrderID, String Name, String Phone, String Address, String payment, String OrderStatus) {
        this.OrderID = OrderID;
        this.Name = Name;
        this.Phone = Phone;
        this.Address = Address;
        this.payment = payment;
        this.OrderStatus = OrderStatus;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double TotalCost) {
        this.TotalCost = TotalCost;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    @Override
    public String toString() {
        return "OrderInformation{" + "OrderID=" + OrderID + ", Name=" + Name + ", Phone=" + Phone + ", Address=" + Address + ", payment=" + payment + ", TotalCost=" + TotalCost + ", OrderStatus=" + OrderStatus + '}';
    }

    
}
