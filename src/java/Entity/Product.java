/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;


public class Product {

    
    private int productID;
    private int views;
    private Date releaseDate;
    private int quantitySold;
    private Categories category;
    private int quantity;
    private int sale;

    public Product() {
    }

    public Product(int productID, int views, Date releaseDate, int quantitySold, Categories category, int quantity, int sale) {
        this.productID = productID;
        this.views = views;
        this.releaseDate = releaseDate;
        this.quantitySold = quantitySold;
        this.category = category;
        this.quantity = quantity;
        this.sale = sale;
    }

    public int getProductID() {
        return productID;
    }

    public int getViews() {
        return views;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public Categories getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSale() {
        return sale;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
    
    
    
    


}
