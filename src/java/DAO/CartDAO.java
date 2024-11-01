package DAO;

import Entity.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO extends DBContext {
    
    // Tạo giỏ hàng cho người dùng
    public int createCart(int personId) {
        String query = "INSERT INTO Cart (PersonID) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, personId);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Trả về CartID mới tạo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Nếu có lỗi xảy ra hoặc không tạo được giỏ hàng
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addCartItem(int cartId, int productId, int quantity) {
        String query = "INSERT INTO CartItem (CartID, ProductID, Quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) { // Đảm bảo sử dụng 'connection' từ DBContext
            stmt.setInt(1, cartId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách sản phẩm trong giỏ hàng
    public List<CartItem> getCartItemsByCartId(int cartId) {
        List<CartItem> items = new ArrayList<>();
        String query = "SELECT * FROM CartItem WHERE CartID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                items.add(new CartItem(productId, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items; // Trả về danh sách các sản phẩm trong giỏ hàng
    }
}
