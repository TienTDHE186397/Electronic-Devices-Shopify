/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Product {

    private int productId;
    private String productName;
    private int views;
    private Date releaseDate;
    private int quantitySold;
    private int categoryId;
    private int quantity;
    private int sale;
    

    public Product() {
    }

    public Product(int productId, String productName, int views, Date releaseDate, int quantitySold, int categoryId, int quantity, int sale) {
        this.productId = productId;
        this.productName = productName;
        this.views = views;
        this.releaseDate = releaseDate;
        this.quantitySold = quantitySold;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.sale = sale;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", views=" + views + ", releaseDate=" + releaseDate + ", quantitySold=" + quantitySold + ", categoryId=" + categoryId + ", quantity=" + quantity + ", sale=" + sale + '}';
    }

    

}
