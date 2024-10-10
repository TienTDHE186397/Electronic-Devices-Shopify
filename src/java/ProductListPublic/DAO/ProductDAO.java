/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductListPublic.DAO;

import DAO.*;
import Entity.Categories;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//Hai
/**
 * Date: Sep 18, 2024
 * @author Vu Duc Hai 
 * This file using to get the data from SQL Server, init data
 * function
 */
public class ProductDAO extends DBContext {
CategoryDAO cDAO = new CategoryDAO();

//==============================================================================    
    public Product getProductsById(int id) {
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), 
                        rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                return p;
            }
        } catch (Exception e) {
            
        }
        return null;
    }
//==============================================================================    
    
    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        try {
            String sql = "Select * from Products";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById
                (rs.getInt("CategoryID"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), 
                        rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                        listProducts.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProducts;
    }
    
//==============================================================================    
    public List<Product> getProductByCategory(int id) {
        List<Product> listP = new ArrayList<>();
        String sql = "Select * from Products WHERE CategoryID = ?";
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), 
                        rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                        listP.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listP;
    }
//============================================================================== 
    public List<String> getBrandByCategory(int cateId){
        List<String> listBrand = new ArrayList<>();
        String sql = "SELECT DISTINCT brand FROM Products WHERE CategoryID = ?";
         try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listBrand.add(rs.getString("brand"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return listBrand;
    }
    
//==============================================================================    

    public static void main(String[] args) {
        //TEST Function getAllProduct
        ProductDAO pDAO = new ProductDAO();
        List<Product> list = pDAO.getProductByCategory(4);
//        Product p1 = pDAO.getProductsById(3);
//        List<String> list = pDAO.getBrandByCategory(2);
        for(Product p: list){
            System.out.println(p);
        }
       
        
    }
}
