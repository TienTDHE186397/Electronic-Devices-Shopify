/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;







public class PC {
    
    
    /*
    
    pcId NVARCHAR(10) PRIMARY KEY NOT NULL, -- Mã d?nh danh cho m?i lo?i máy tính
	pcImage NVARCHAR(255) NOT NULL, -- ?nh s?n ph?m
	pcName NVARCHAR(255) NOT NULL, -- Tên s?n ph?m máy tính
	pcBranch NVARCHAR(50) NOT NULL, -- Tên thuong hi?u máy tính
	pcPrice INT, --Giá c?a s?n ph?m
	pcCPU NVARCHAR(255) NOT NULL, -- Thông tin v? vi x? lý
	pcMemory NVARCHAR(255) NOT NULL, --Thông tin v? b? nh? ram(GB)
	pcDiskMemory NVARCHAR(255) NOT NULL, -- Thông tin v? ? c?ng(GB)
	pcVga NVARCHAR(255) NOT NULL, -- Thông tin v? vi x? lý d? ho?
	pcNetworkLan NVARCHAR(255) NOT NULL, -- Thông tin v? card m?ng 
	pcPower INT, -- Thông tin v? công su?t di?n (W)
	pcSize NVARCHAR(255) NOT NULL, -- Thông tin v? kích c?(L x W x H) mm ho?c cm
	pcWeight DECIMAL(4,2), -- Thông tin v? kh?i lu?ng(kg)
	pcFrontPort NVARCHAR(255) NOT NULL, -- Thông tin v? c?ng tru?c
	pcBackPort NVARCHAR(255) NOT NULL, --Thông tin v? c?ng sau 
	pcGuarantee INT NOT NULL, -- Thông tin b?o hành(Tháng,month)
	ProductID int not null,
	FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
    
    */
    
    private String pcId;
    private String pcImage;
    private String pcName;
    private String pcBranch;
    private int pcPrice;
    private String pcCPU;
    private String pcMemory;
    private String pcDiskMemory;
    private String pcVga;
    private String pcNetworkLan;
    private int pcPower;
    private String pcSize;
    private Double pcWeight;
    private String pcFrontPort;
    private String pcBackPort;
    private String pcGuarantee;
    private Product product;

    public PC() {
    }

    public PC(String pcId, String pcImage, String pcName, String pcBranch, int pcPrice, String pcCPU, String pcMemory, String pcDiskMemory, String pcVga, String pcNetworkLan, int pcPower, String pcSize, Double pcWeight, String pcFrontPort, String pcBackPort, String pcGuarantee, Product product) {
        this.pcId = pcId;
        this.pcImage = pcImage;
        this.pcName = pcName;
        this.pcBranch = pcBranch;
        this.pcPrice = pcPrice;
        this.pcCPU = pcCPU;
        this.pcMemory = pcMemory;
        this.pcDiskMemory = pcDiskMemory;
        this.pcVga = pcVga;
        this.pcNetworkLan = pcNetworkLan;
        this.pcPower = pcPower;
        this.pcSize = pcSize;
        this.pcWeight = pcWeight;
        this.pcFrontPort = pcFrontPort;
        this.pcBackPort = pcBackPort;
        this.pcGuarantee = pcGuarantee;
        this.product = product;
    }

    public String getPcId() {
        return pcId;
    }

    public String getPcImage() {
        return pcImage;
    }

    public String getPcName() {
        return pcName;
    }

    public String getPcBranch() {
        return pcBranch;
    }

    public int getPcPrice() {
        return pcPrice;
    }

    public String getPcCPU() {
        return pcCPU;
    }

    public String getPcMemory() {
        return pcMemory;
    }

    public String getPcDiskMemory() {
        return pcDiskMemory;
    }

    public String getPcVga() {
        return pcVga;
    }

    public String getPcNetworkLan() {
        return pcNetworkLan;
    }

    public int getPcPower() {
        return pcPower;
    }

    public String getPcSize() {
        return pcSize;
    }

    public Double getPcWeight() {
        return pcWeight;
    }

    public String getPcFrontPort() {
        return pcFrontPort;
    }

    public String getPcBackPort() {
        return pcBackPort;
    }

    public String getPcGuarantee() {
        return pcGuarantee;
    }

    public Product getProduct() {
        return product;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public void setPcImage(String pcImage) {
        this.pcImage = pcImage;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public void setPcBranch(String pcBranch) {
        this.pcBranch = pcBranch;
    }

    public void setPcPrice(int pcPrice) {
        this.pcPrice = pcPrice;
    }

    public void setPcCPU(String pcCPU) {
        this.pcCPU = pcCPU;
    }

    public void setPcMemory(String pcMemory) {
        this.pcMemory = pcMemory;
    }

    public void setPcDiskMemory(String pcDiskMemory) {
        this.pcDiskMemory = pcDiskMemory;
    }

    public void setPcVga(String pcVga) {
        this.pcVga = pcVga;
    }

    public void setPcNetworkLan(String pcNetworkLan) {
        this.pcNetworkLan = pcNetworkLan;
    }

    public void setPcPower(int pcPower) {
        this.pcPower = pcPower;
    }

    public void setPcSize(String pcSize) {
        this.pcSize = pcSize;
    }

    public void setPcWeight(Double pcWeight) {
        this.pcWeight = pcWeight;
    }

    public void setPcFrontPort(String pcFrontPort) {
        this.pcFrontPort = pcFrontPort;
    }

    public void setPcBackPort(String pcBackPort) {
        this.pcBackPort = pcBackPort;
    }

    public void setPcGuarantee(String pcGuarantee) {
        this.pcGuarantee = pcGuarantee;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   
    
    
    

    


}
