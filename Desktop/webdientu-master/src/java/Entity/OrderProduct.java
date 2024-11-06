/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class OrderProduct {
    private String odID;
    private String img;
    private String name;
    private String category;
    private double unitprice;
    private int quantity;
    private double totalCost;

    public OrderProduct() {
    }

    public OrderProduct(String odID, String img, String name, String category, double unitprice, int quantity, double totalCost) {
        this.odID = odID;
        this.img = img;
        this.name = name;
        this.category = category;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public OrderProduct(String odID, String img, String name, double unitprice, int quantity, double totalCost) {
        this.odID = odID;
        this.img = img;
        this.name = name;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }
    

    public String getOdID() {
        return odID;
    }

    public void setOdID(String odID) {
        this.odID = odID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "OrderProduct{" + "odID=" + odID + ", img=" + img + ", name=" + name + ", category=" + category + ", unitprice=" + unitprice + ", quantity=" + quantity + ", totalCost=" + totalCost + '}';
    }
    
}

    
