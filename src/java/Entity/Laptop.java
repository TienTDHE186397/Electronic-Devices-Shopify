/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;







public class Laptop {
    
    /*
     LaptopID nvarchar(100) not null primary key,
   ProductID int not null,
   price int not null,
   LapName nvarchar(150) not null,
   genre nvarchar(255) not null,
   CPU nvarchar(150) not null,
   Ram nvarchar(150) not null,
   Graphic_Card nvarchar(150) not null,
   Hard_Drive nvarchar(150) not null,
   Monitor nvarchar(300) not null,
   LAN nvarchar(100) not null,
   WIFI nvarchar(100) not null,
   Bluetooth nvarchar(200) not null,
   Webcam nvarchar(200) not null,
   Operating_System nvarchar(100) not null,
   Pin nvarchar(100) not null,
   Lap_Weight nvarchar(100) not null,
   Lap_colour nvarchar(100) not null,
   Size nvarchar(100) not null,
   img NVARCHAR(MAX) NULL,
   [description] nvarchar(MAX) null,
   FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
    */
    
    
    private String laptopId;
    private int price;
    private String lapName;
    private String genre;
    private String cpu;
    private String ram;
    private String graphicCard;
    private String hard_drive;
    private String monitor;
    private String lan;
    private String wifi;
    private String blueTooth;
    private String webCam;
    private String operatingSystem;
    private String pin;
    private String lapWeight;
    private String lapColor;
    private String size;
    private String img;
    private String description;
    private Product product;

    public Laptop() {
    }

    public Laptop(String laptopId, int price, String lapName, String genre, String cpu, String ram, String graphicCard, String hard_drive, String monitor, String lan, String wifi, String blueTooth, String webCam, String operatingSystem, String pin, String lapWeight, String lapColor, String size, String img, String description, Product product) {
        this.laptopId = laptopId;
        this.price = price;
        this.lapName = lapName;
        this.genre = genre;
        this.cpu = cpu;
        this.ram = ram;
        this.graphicCard = graphicCard;
        this.hard_drive = hard_drive;
        this.monitor = monitor;
        this.lan = lan;
        this.wifi = wifi;
        this.blueTooth = blueTooth;
        this.webCam = webCam;
        this.operatingSystem = operatingSystem;
        this.pin = pin;
        this.lapWeight = lapWeight;
        this.lapColor = lapColor;
        this.size = size;
        this.img = img;
        this.description = description;
        this.product = product;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public int getPrice() {
        return price;
    }

    public String getLapName() {
        return lapName;
    }

    public String getGenre() {
        return genre;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public String getHard_drive() {
        return hard_drive;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getLan() {
        return lan;
    }

    public String getWifi() {
        return wifi;
    }

    public String getBlueTooth() {
        return blueTooth;
    }

    public String getWebCam() {
        return webCam;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getPin() {
        return pin;
    }

    public String getLapWeight() {
        return lapWeight;
    }

    public String getLapColor() {
        return lapColor;
    }

    public String getSize() {
        return size;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public void setHard_drive(String hard_drive) {
        this.hard_drive = hard_drive;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public void setBlueTooth(String blueTooth) {
        this.blueTooth = blueTooth;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setLapWeight(String lapWeight) {
        this.lapWeight = lapWeight;
    }

    public void setLapColor(String lapColor) {
        this.lapColor = lapColor;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Laptop{" + "laptopId=" + laptopId + ", price=" + price + ", lapName=" + lapName + ", genre=" + genre + ", cpu=" + cpu + ", ram=" + ram + ", graphicCard=" + graphicCard + ", hard_drive=" + hard_drive + ", monitor=" + monitor + ", lan=" + lan + ", wifi=" + wifi + ", blueTooth=" + blueTooth + ", webCam=" + webCam + ", operatingSystem=" + operatingSystem + ", pin=" + pin + ", lapWeight=" + lapWeight + ", lapColor=" + lapColor + ", size=" + size + ", img=" + img + ", description=" + description + ", product=" + product + '}';
    }

   
    
    
}
