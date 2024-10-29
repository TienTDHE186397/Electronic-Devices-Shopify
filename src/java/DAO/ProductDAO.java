/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.Product;
import Entity.ProductAttribute;
import Entity.ProductImage;
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
    public List<Product> getProductByBrand(int cateid, String brand) {
        List<Product> listP = new ArrayList<>();
        String sql = "SELECT * FROM Products Where CategoryID = ? AND brand = ?;";
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateid);
            st.setString(2, brand);
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
    
//==============================================================================
    public List<ProductImage> getAllProductImageById(int id){
        List<ProductImage> listImage = new ArrayList<>();
        String sql = "select * from ProductImages where ProductID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = getProductsById(rs.getInt("ProductID"));
                ProductImage pImage = new ProductImage(
                        rs.getInt("image_id"),
                        rs.getString("image_url"),
                        rs.getString("alt_text"),
                        p
                );
                listImage.add(pImage);
            }
        }catch(Exception e){
            
        }
        return listImage;
    } 
//==============================================================================
    public List<ProductAttribute> getAllProductAttributeById(int id) {
            List<ProductAttribute> listAttribute = new ArrayList<>();
            String sql = "select * from ProductAttributes where ProductID = ?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Product p = getProductsById(rs.getInt("ProductID"));
                    ProductAttribute pAttribute = new ProductAttribute(
                            rs.getInt("AttributeID"),
                            rs.getString("AttributeName"),
                            rs.getString("AttributeValue"),
                            p
                    );
                    listAttribute.add(pAttribute);
                }
            } catch (Exception e) {
                
            }
            return listAttribute;
        }
//==============================================================================
    public static void main(String[] args) {
        //TEST Function getAllProduct
        ProductDAO pDAO = new ProductDAO();
          List<ProductAttribute> list = pDAO.getAllProductAttributeById(1);
//        Product p1 = pDAO.getProductsById(3);
//        List<String> list = pDAO.getBrandByCategory(2);
        for(ProductAttribute p: list){
            System.out.println(p);
        }
    }
}
