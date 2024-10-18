/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.CartItem;
import Entity.Categories;
import Entity.Product;
import Entity.ProductAttribute;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class CartDAO extends DBContext {
//Son
    //int CartItemID, int CartID, int ProductID, int Quantity, double Price, double TotalPrice

    public boolean getCartByID(int personID) {
        CartItem cart = new CartItem();
        String sql = "SELECT c.CartID,ci.ProductID,  p.ProductName, ci.Quantity,ci.Price,ci.TotalPrice,"
                + "c.TotalPrice AS TotalCartPrice\n"
                + "FROM Cart c\n"
                + "JOIN CartItem ci ON c.CartID = ci.CartID\n"
                + "JOIN Products p ON ci.ProductID = p.ProductID\n"
                + "WHERE c.PersonID = ?            \n"
                + "AND c.CartID = ?;  ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, personID);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                cart = new CartItem(rs.getInt("CartItemID"),
                        rs.getInt(ProductID),
                        rs.getInt(ProductID),
                        rs.getInt(ProductID),
                        rs.getInt(ProductID),
                        rs.getInt(ProductID));
            
         );

                // Giả sử bạn có một phương thức trong lớp Product để thiết lập các thuộc tính
            }
        } catch (Exception e) {
            e.printStackTrace();  // Ghi log hoặc in lỗi để hiểu vấn đề
        }

        return attributeList; // Return the list of attributes
    }

    public static void main(String[] args) {

    }
}
