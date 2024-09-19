/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD


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
    private Product productId;
=======
package Entity;

/**
 *
 * @author Dokkuhai
 */
public class Laptop {
    private String LaptopID;
    private int ProductID;
    private String LapName;
    private String genre;
    private String CPU;
    private String Ram;
    private String Graphic_Card;
    private String Hard_Drive;
    private String Monitor;
    private String LAN;
    private String WIFI;
    private String Bluetooth;
    private String Webcam;
    private String Operating_System;
    private String Pin;
    private String Lap_Weight;
    private String Lap_colour;
    private String Size;
    private String img;
    private String description;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11

    public Laptop() {
    }

<<<<<<< HEAD
    public Laptop(String laptopId, int price, String lapName, String genre, String cpu, String ram, String graphicCard, String hard_drive, String monitor, String lan, String wifi, String blueTooth, String webCam, String operatingSystem, String pin, String lapWeight, String lapColor, String size, String img, String description, Product productId) {
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
        this.productId = productId;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public int getPrice() {
        return price;
    }

    public String getLapName() {
        return lapName;
=======
    public Laptop(String LaptopID, int ProductID, String LapName, String genre, String CPU, String Ram, String Graphic_Card, String Hard_Drive, String Monitor, String LAN, String WIFI, String Bluetooth, String Webcam, String Operating_System, String Pin, String Lap_Weight, String Lap_colour, String Size, String img, String description) {
        this.LaptopID = LaptopID;
        this.ProductID = ProductID;
        this.LapName = LapName;
        this.genre = genre;
        this.CPU = CPU;
        this.Ram = Ram;
        this.Graphic_Card = Graphic_Card;
        this.Hard_Drive = Hard_Drive;
        this.Monitor = Monitor;
        this.LAN = LAN;
        this.WIFI = WIFI;
        this.Bluetooth = Bluetooth;
        this.Webcam = Webcam;
        this.Operating_System = Operating_System;
        this.Pin = Pin;
        this.Lap_Weight = Lap_Weight;
        this.Lap_colour = Lap_colour;
        this.Size = Size;
        this.img = img;
        this.description = description;
    }

    public String getLaptopID() {
        return LaptopID;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getLapName() {
        return LapName;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    }

    public String getGenre() {
        return genre;
    }

<<<<<<< HEAD
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
=======
    public String getCPU() {
        return CPU;
    }

    public String getRam() {
        return Ram;
    }

    public String getGraphic_Card() {
        return Graphic_Card;
    }

    public String getHard_Drive() {
        return Hard_Drive;
    }

    public String getMonitor() {
        return Monitor;
    }

    public String getLAN() {
        return LAN;
    }

    public String getWIFI() {
        return WIFI;
    }

    public String getBluetooth() {
        return Bluetooth;
    }

    public String getWebcam() {
        return Webcam;
    }

    public String getOperating_System() {
        return Operating_System;
    }

    public String getPin() {
        return Pin;
    }

    public String getLap_Weight() {
        return Lap_Weight;
    }

    public String getLap_colour() {
        return Lap_colour;
    }

    public String getSize() {
        return Size;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

<<<<<<< HEAD
    public Product getProductId() {
        return productId;
    }
    
    
    



=======
    public void setLaptopID(String LaptopID) {
        this.LaptopID = LaptopID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setLapName(String LapName) {
        this.LapName = LapName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public void setGraphic_Card(String Graphic_Card) {
        this.Graphic_Card = Graphic_Card;
    }

    public void setHard_Drive(String Hard_Drive) {
        this.Hard_Drive = Hard_Drive;
    }

    public void setMonitor(String Monitor) {
        this.Monitor = Monitor;
    }

    public void setLAN(String LAN) {
        this.LAN = LAN;
    }

    public void setWIFI(String WIFI) {
        this.WIFI = WIFI;
    }

    public void setBluetooth(String Bluetooth) {
        this.Bluetooth = Bluetooth;
    }

    public void setWebcam(String Webcam) {
        this.Webcam = Webcam;
    }

    public void setOperating_System(String Operating_System) {
        this.Operating_System = Operating_System;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public void setLap_Weight(String Lap_Weight) {
        this.Lap_Weight = Lap_Weight;
    }

    public void setLap_colour(String Lap_colour) {
        this.Lap_colour = Lap_colour;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
}
