/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Laptop;
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

    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "Select * from Products";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);//
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("ProductID"));
                p.setViews(rs.getInt("Views"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setQuantitySold(rs.getInt("QuantitySold"));
                p.setCategoryId(rs.getInt("CategoryID"));
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
                Laptop l = new Laptop();
                l.setProductID(rs.getInt("ProductID"));
                l.setLaptopID(rs.getNString(""));
                listLaptops.add(l);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProducts;
    }

    public static void main(String[] args) {
        //TEST Function getAllProduct
        ProductDAO pDAO = new ProductDAO();
        List<Product> list = pDAO.getAllProducts();
        for (Product p : list) {
            System.out.println(p.toString());
        }
        
        //Test function getAllLaptop
    }
}
