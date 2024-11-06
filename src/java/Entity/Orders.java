/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nghie
 */
public class Orders {
    private int OrderID;
    private String OrderDate;
    private int PersonID, ShowroomID;
    private double TotalMoney;
    private String Method, Status;

    public Orders() {
    }

    public Orders(int OrderID, String OrderDate, int PersonID, int ShowroomID, double TotalMoney, String Method, String Status) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.PersonID = PersonID;
        this.ShowroomID = ShowroomID;
        this.TotalMoney = TotalMoney;
        this.Method = Method;
        this.Status = Status;
    }
    

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public int getShowroomID() {
        return ShowroomID;
    }

    public void setShowroomID(int ShowroomID) {
        this.ShowroomID = ShowroomID;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Orders{" + "OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", PersonID=" + PersonID + ", ShowroomID=" + ShowroomID + ", TotalMoney=" + TotalMoney + ", Method=" + Method + ", Status=" + Status + '}';
    }
    
    
}
