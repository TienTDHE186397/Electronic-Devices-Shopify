/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import Entity.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Long
 */
public class CardDAO extends DBContext {

    public Cart getCartByPersonId(int personId) {
        String sql = "SELECT * FROM Cart WHERE PersonID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, personId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart cart = new Cart();
                cart.setCartID(rs.getInt("CartID"));
                cart.setPersonID(rs.getInt("PersonID"));
                cart.setTotalPrice(rs.getDouble("TotalPrice"));
                return cart;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm sản phẩm vào giỏ hàng
    public void createCart(Cart cart) {
        String sql = "INSERT INTO Cart (PersonID) VALUES (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cart.getPersonID());
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                cart.setCartID(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateTotalPrice(int cartId, double totalPrice) {
        boolean check;
        String sql = "UPDATE Cart SET TotalPrice = ? WHERE CartID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, totalPrice);
            st.setInt(2, cartId);
            st.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    public void addItem(int cartId, int productId, int quantity, double price) {
        String sql = "INSERT INTO CartItem (CartID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cartId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, price);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CartItem> getCartItems(int cartId) {
        List<CartItem> items = new ArrayList<>();
        String query = "SELECT * FROM CartItem WHERE CartID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem();
                item.setCartItemID(rs.getInt("CartItemID"));
                item.setCartID(rs.getInt("CartID"));
                item.setProductID(rs.getInt("ProductID"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setPrice(rs.getDouble("Price"));
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public double calculateTotalPrice(int cartId) {
        double totalPrice = 0;
        String query = "SELECT SUM(Quantity * Price) AS TotalPrice FROM CartItem WHERE CartID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalPrice = rs.getDouble("TotalPrice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        CardDAO c = new CardDAO();
//        if (c.checkExistCard(20)) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }

    }

}
