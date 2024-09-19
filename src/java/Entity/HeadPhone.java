/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;







public class HeadPhone {
    

    private String headPhoneId;
    private String headPhoneName;
    private String brand;
    private String model;
    private String features;
    private String connection;
    private String batteryLife;
    private String noiseCancel;
    private int price;
    private String img;
    private String description;
    private Product productId;

    public HeadPhone() {
    }

    public HeadPhone(String headPhoneId, String headPhoneName, String brand, String model, String features, String connection, String batteryLife, String noiseCancel, int price, String img, String description, Product productId) {
        this.headPhoneId = headPhoneId;
        this.headPhoneName = headPhoneName;
        this.brand = brand;
        this.model = model;
        this.features = features;
        this.connection = connection;
        this.batteryLife = batteryLife;
        this.noiseCancel = noiseCancel;
        this.price = price;
        this.img = img;
        this.description = description;
        this.productId = productId;
    }

    public String getHeadPhoneId() {
        return headPhoneId;
    }

    public String getHeadPhoneName() {
        return headPhoneName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFeatures() {
        return features;
    }

    public String getConnection() {
        return connection;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public String getNoiseCancel() {
        return noiseCancel;
    }

    public int getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public Product getProductId() {
        return productId;
    }

    public void setHeadPhoneId(String headPhoneId) {
        this.headPhoneId = headPhoneId;
    }

    public void setHeadPhoneName(String headPhoneName) {
        this.headPhoneName = headPhoneName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setNoiseCancel(String noiseCancel) {
        this.noiseCancel = noiseCancel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
    
    
    
    
    
    



}
