/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.Laptop;
import Entity.PC;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: Sep 18, 2024
 *
 * @author Vu Duc Hai This file using to get the data from SQL Server, init data
 * function
 */
public class ProductDAO extends DBContext {
    
    public Product getProductsById(int id) {

        String sql = "SELECT * FROM Products WHERE ProductID = ?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setViews(rs.getInt("Views"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setQuantitySold(rs.getInt("QuantitySold"));
                p.setCategory(cate);
                p.setQuantity(rs.getInt("Quantity"));
                p.setSale(rs.getInt("Sale"));
                return p;
            }

        } catch (Exception e) {
        }

        return null;
    }
    
    CategoryDAO cDAO = new CategoryDAO();
    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "Select * from Products";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);//
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setViews(rs.getInt("Views"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setQuantitySold(rs.getInt("QuantitySold"));
                p.setCategory(cate);
                p.setQuantity(rs.getInt("Quantity"));
                p.setSale(rs.getInt("Sale"));
                listProducts.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProducts;
    }
    
    public List<Laptop> getAllLaptops() {
        List<Laptop> listLaptops = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products INNER JOIN Laptop ON Laptop.ProductID = Products.ProductID";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);//
            while (rs.next()) {
                Product lap = getProductsById(rs.getInt("ProductID"));
                Laptop l = new Laptop();
                l.setLaptopId(rs.getNString("LaptopID"));
                l.setProduct(lap);
                l.setPrice(rs.getInt("price"));
                l.setLapName(rs.getNString("LapName"));
                l.setGenre(rs.getNString("genre"));
                l.setCpu(rs.getNString("CPU"));
                l.setRam(rs.getNString("Ram"));
                l.setGraphicCard(rs.getNString("Graphic_Card"));
                l.setHard_drive(rs.getNString("Hard_Drive"));
                l.setMonitor(rs.getNString("Monitor"));
                l.setLan(rs.getNString("LAN"));
                l.setWifi(rs.getNString("WIFI"));
                l.setBlueTooth(rs.getNString("Bluetooth"));
                l.setWebCam(rs.getNString("Webcam"));
                l.setOperatingSystem(rs.getNString("Operating_System"));
                l.setPin(rs.getNString("Pin"));
                l.setLapWeight(rs.getString("Lap_Weight"));
                l.setLapColor(rs.getString("Lap_colour"));
                l.setSize(rs.getNString("Size"));
                l.setImg(rs.getNString("img"));
                l.setDescription(rs.getNString("description"));
                listLaptops.add(l);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listLaptops;
    }
    
    public List<PC> getAllPCs() {
        List<PC> listPCs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Products INNER JOIN PC ON PC.ProductID = Products.ProductID";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);//
            while (rs.next()) {
                Product p = getProductsById(rs.getInt("ProductID"));
                PC pc = new PC();
                pc.setPcId(rs.getNString("pcId"));
                pc.setPcImage(rs.getNString("pcImage"));
                pc.setPcName(rs.getNString("pcName"));
                pc.setPcBranch(rs.getString("pcBranch"));
                pc.setPcPrice(rs.getInt("pcPrice"));
                pc.setPcCPU(rs.getNString("pcCPU"));
                pc.setPcMemory(rs.getNString("pcMemory"));
                pc.setPcDiskMemory("pcDiskMemory");
                pc.setPcVga(rs.getNString("pcVga"));
                pc.setPcNetworkLan(rs.getNString("pcNetworkLan"));
                pc.setPcPower(rs.getInt("pcPower"));
                pc.setPcSize(rs.getNString("pcSize"));
                pc.setPcWeight(rs.getDouble("pcWeight"));
                pc.setPcFrontPort(rs.getNString("pcFrontPort"));
                pc.setPcBackPort(rs.getNString("pcBackPort"));
                pc.setPcGuarantee(rs.getString("pcGuarantee"));
                pc.setProduct(p);
                listPCs.add(pc);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listPCs;
    }
    
    
    
    
    

    public static void main(String[] args) {
        //TEST Function getAllProduct
        ProductDAO pDAO = new ProductDAO();
        List<PC> list = pDAO.getAllPCs();
        for (PC l : list) {
            System.out.println(l.getProduct().getSale());
        }
        //Test function getAllLaptop
    }
}
