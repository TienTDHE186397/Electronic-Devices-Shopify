/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.*;
import java.lang.*;

public class Product {

    private String title;
    private int productID;
    private String productName;
    private int views;
    private Date releaseDate;
    private int quantitySold;
    private Categories category;
    private int quantity;
    private int sale;
    private String img;
    private double price;
    private String publisher;
    private String sortDescription;
    private String description;
    private String status;
    

    public Product() {
    }

    public Product(String title, int productID, String productName, int views, Date releaseDate,
                   int quantitySold, Categories category, int quantity, int sale,
                   String img, double price, String publisher, String sortDescription,
                   String description, String status) {
        this.title = title;
        this.productID = productID;
        this.productName = productName;
        this.views = views;
        this.releaseDate = releaseDate;
        this.quantitySold = quantitySold;
        this.category = category;
        this.quantity = quantity;
        this.sale = sale;
        this.img = img;
        this.price = price;
        this.publisher = publisher;
        this.sortDescription = sortDescription;
        this.description = description;
        this.status = status;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Product{" + "title=" + title + ", productID=" + productID + ", productName=" + productName + ", views=" + views + ", releaseDate=" + releaseDate + ", quantitySold=" + quantitySold + ", category=" + category + ", quantity=" + quantity + ", sale=" + sale + ", img=" + img + ", price=" + price + ", publisher=" + publisher + ", sortDescription=" + sortDescription + ", Description=" + description + ", status=" + status + ", attributes=" + '}';
    }

    

    

}
