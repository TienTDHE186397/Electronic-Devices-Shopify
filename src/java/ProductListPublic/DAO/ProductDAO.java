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
    public int getTotalProduct(){
        String sql = "Select COUNT(*) from Products";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
        return 0;
    }
    
    /**************************************************************************/
     public int getTotalProductByCatetory(int cate){
        String sql = "Select COUNT(*) from Products WHERE CategoryID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
        return 0;
    }

//==============================================================================
    public List<Product> pagingProduct(int index){
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Products ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index-1)*8);
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
                        list.add(p);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
        return list;
    }

//------------------------------------------------------------------------------
    
    
     public List<Product> pagingProductByCategory(int index, int cat, int quantity_product){
        String sql = "";
        if(cat == 0){
            sql = "Select * from Products ORDER BY ProductID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        }else{
            sql = "Select * from Products WHERE CategoryID = ? ORDER BY ProductID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        }
        List<Product> list = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            if(cat != 0){
                st.setInt(1, cat);
                st.setInt(2, (index-1)*8);
                st.setInt(3, quantity_product);
            }else{
                st.setInt(1, (index-1)*8);
                st.setInt(2, quantity_product);
            }
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
                        list.add(p);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
        return list;
    }
    
    
    
//==============================================================================
    public List<Product> getTop4Product(){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 4 * \n" +
"FROM products \n" +
"ORDER BY Sale DESC;";
        try{
            PreparedStatement st = connection.prepareStatement(sql);  
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
                        list.add(p);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            
        }
        return list;
    }
//==============================================================================   

    public static void main(String[] args) {
        //TEST Function getAllProduct
        ProductDAO pDAO = new ProductDAO();
//        List<Product> list = pDAO.pagingProductByCategory(1, 0,8);
////        int count = pDAO.getTotalProduct();
////        Product p1 = pDAO.getProductsById(3);
////        List<String> list = pDAO.getBrandByCategory(2);
//        for(Product p: list){
//            System.out.println(p);
//        }
            List<Product> listP = pDAO.getTop4Product();
            for(Product p: listP){
                System.out.println(p);
            }
    }
}
