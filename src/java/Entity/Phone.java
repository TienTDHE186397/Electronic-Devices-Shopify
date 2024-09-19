/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;

import java.util.*;
import java.lang.*;


public class Phone {
    
    
    /*
     PhoneID nvarchar(50) not null primary key,--Mã d?nh danh duy nh?t cho m?i di?n tho?i
       PhoneName nvarchar(255) not null,--Tên s?n ph?m
       Price int not null,--Giá c?a s?n ph?m
       ScreenSize decimal(10,2) not null,--Kích thu?c màn hình c?a s?n ph?m
       DisplayTech nvarchar(255) not null,--Công ngh? màn hình c?a s?n ph?m
       RearCamera nvarchar(255) not null,--Camera sau c?a s?n ph?m
       FrontCamera nvarchar(255) not  null,--Camera tru?c c?a s?n ph?m
       Chipset nvarchar(255) not null,--Chip c?a m?i s?n ph?m
       RAMCapicity int not null,--Dung lu?ng RAM c?a s?n ph?m
       InternalMemory int not null,--B? nh? trong c?a s?n ph?m
       Battery nvarchar(255) not null,--Pin c?a s?n ph?m
       OperatingSystem nvarchar(255) not null,--H? di?u hành c?a s?n ph?m
       ScreenResolution nvarchar(255) not null,--Ð? phân gi?i màn hình c?a s?n ph?m
	   ProductID int not null,
	   img nvarchar(255) not null,
	   FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
    */
    
    private String phoneID;
    private String phoneName;
    private int price;   
    private double screenSize;
    private String displayTech;
    private String rearCamera;
    private String frontCamera;
    private String chipSet;
    private int ramCapicity;
    private int internalMemory;
    private String battery;
    private String screenResolution;
    private Product product;
    private String img;

    public Phone() {
    }

    public Phone(String phoneID, String phoneName, int price, double screenSize, String displayTech, String rearCamera, String frontCamera, String chipSet, int ramCapicity, int internalMemory, String battery, String screenResolution, Product product, String img) {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.price = price;
        this.screenSize = screenSize;
        this.displayTech = displayTech;
        this.rearCamera = rearCamera;
        this.frontCamera = frontCamera;
        this.chipSet = chipSet;
        this.ramCapicity = ramCapicity;
        this.internalMemory = internalMemory;
        this.battery = battery;
        this.screenResolution = screenResolution;
        this.product = product;
        this.img = img;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public int getPrice() {
        return price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getDisplayTech() {
        return displayTech;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public String getChipSet() {
        return chipSet;
    }

    public int getRamCapicity() {
        return ramCapicity;
    }

    public int getInternalMemory() {
        return internalMemory;
    }

    public String getBattery() {
        return battery;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public Product getProduct() {
        return product;
    }

    public String getImg() {
        return img;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setDisplayTech(String displayTech) {
        this.displayTech = displayTech;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public void setRamCapicity(int ramCapicity) {
        this.ramCapicity = ramCapicity;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    
    
    
    
    


}
