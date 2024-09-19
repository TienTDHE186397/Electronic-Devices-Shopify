/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductListDAO extends DBContext {

    CategoryDAO cDAO = new CategoryDAO();

    public List<Product> getAllProduct() {

        List<Product> listP = new ArrayList<>();

        String sql = "SELECT [ProductID]\n"
                + "      ,[Views]\n"
                + "      ,[releaseDate]\n"
                + "      ,[QuantitySold]\n"
                + "      ,[CategoryID]\n"
                + "      ,[Quantity]\n"
                + "      ,[Sale]\n"
                + "  FROM [dbo].[Products]";
        
        

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getInt("Views"),
                        rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"));

                listP.add(p);
            }

        } catch (Exception e) {

        }

        return listP;

    }

    public static void main(String[] args) {

        ProductListDAO p = new ProductListDAO();
        List<Product> pl = p.getAllProduct();

        for (Product p1 : pl) {

            System.out.println(p1.getCategory().getCategoryID());
        }

    }

}
