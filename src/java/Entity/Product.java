/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Product {

    private int productId;
    private String productName;
    private String genre;
    private String director;
    private String performer;
    private String price;
    private String age;
    private String image;
    private String imageBanner;
    private String description;
    private String view;
    private String time;
    private String releaseDate;
    private int quantitySold;
    private int categoryId;
    private int cinemaID;
    private int status;

    public Product() {
    }

    public Product(int productId, String productName, String genre, String director, String performer, String price, String age, String image, String imageBanner, String description, String view, String time, String releaseDate, int quantitySold, int categoryId, int cinemaID, int status) {
        this.productId = productId;
        this.productName = productName;
        this.genre = genre;
        this.director = director;
        this.performer = performer;
        this.price = price;
        this.age = age;
        this.image = image;
        this.imageBanner = imageBanner;
        this.description = description;
        this.view = view;
        this.time = time;
        this.releaseDate = releaseDate;
        this.quantitySold = quantitySold;
        this.categoryId = categoryId;
        this.cinemaID = cinemaID;
        this.status = status;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageBanner() {
        return imageBanner;
    }

    public void setImageBanner(String imageBanner) {
        this.imageBanner = imageBanner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
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

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", genre=" + genre + ", director=" + director + ", performer=" + performer + ", price=" + price + ", age=" + age + ", image=" + image + ", imageBanner=" + imageBanner + ", description=" + description + ", view=" + view + ", time=" + time + ", releaseDate=" + releaseDate + ", quantitySold=" + quantitySold + ", categoryId=" + categoryId + ", cinemaID=" + cinemaID + ", status=" + status + '}';
    }

}
