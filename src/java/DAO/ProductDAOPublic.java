/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


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
public class ProductDAOPublic extends DBContext {
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

   
    
    /**************************************************************************/
    public int getTotalProduct(int cate, String search_product) {
    StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM Products");
    
    List<Object> parameters = new ArrayList<>();

    if (cate != 0) {
        sql.append(" WHERE CategoryID = ?");
        parameters.add(cate);
    }

    if (search_product != null && !search_product.isEmpty()) {
        // Append AND only if there is already a WHERE clause
        if (parameters.isEmpty()) {
            sql.append(" WHERE ProductName LIKE ?");
        } else {
            sql.append(" AND ProductName LIKE ?");
        }
        parameters.add("%" + search_product + "%");
    }

    int total = 0;

    try (PreparedStatement st = connection.prepareStatement(sql.toString())) {
        for (int i = 0; i < parameters.size(); i++) {
            st.setObject(i + 1, parameters.get(i));
        }

        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception or handle it as needed
    }

    return total;
}

//==============================================================================

//------------------------------------------------------------------------------

    
    public List<Product> pagingProductByCategory1(int index, int cat, int quantity_product, String sort, String searchProduct) {
    String sql;

    // Xây dựng câu truy vấn dựa trên việc có tìm kiếm hoặc danh mục không
    if (cat == 0) {
        sql = "SELECT * FROM Products ";
        if (searchProduct != null && !searchProduct.trim().isEmpty()) {
            sql += "WHERE ProductName LIKE ? ";
        }
        sql += "ORDER BY " + sort + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    } else {
        sql = "SELECT * FROM Products WHERE CategoryID = ? ";
        if (searchProduct != null && !searchProduct.trim().isEmpty()) {
            sql += "AND ProductName LIKE ? ";
        }
        sql += "ORDER BY " + sort + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    }

    List<Product> list = new ArrayList<>();
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        
        int paramIndex = 1;
        if (cat != 0) {
            st.setInt(paramIndex++, cat); // Set CategoryID
        }
        if (searchProduct != null && !searchProduct.trim().isEmpty()) {
            st.setString(paramIndex++, "%" + searchProduct + "%"); // Set điều kiện tìm kiếm
        }
        
        // Set offset và limit cho phân trang
        st.setInt(paramIndex++, (index - 1) * quantity_product);
        st.setInt(paramIndex, quantity_product);

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
                    rs.getString("brand")
            );
            list.add(p);
        }
        
        rs.close();
        st.close();
    } catch (Exception e) {
        e.printStackTrace(); // Xử lý ngoại lệ nếu cần
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
        ProductDAOPublic pDAO = new ProductDAOPublic();
//        List<Product> list = pDAO.pagingProductByCategory(1, 0,8);
////        int count = pDAO.getTotalProduct();
////        Product p1 = pDAO.getProductsById(3);
////        List<String> list = pDAO.getBrandByCategory(2);
//        for(Product p: list){
//            System.out.println(p);
//        }
//            List<Product> listP = pDAO.getTop4Product();
//            for(Product p: listP){
//                System.out.println(p);
//            }
        
        
    }
}
