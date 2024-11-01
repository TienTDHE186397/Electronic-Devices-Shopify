package DAO;

import Entity.Cart;
import Entity.CartItem;
import Entity.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDAO extends DBContext {

    private DAOPerson personDAO = new DAOPerson(); // Khởi tạo PersonDAO

    // Tạo giỏ hàng mới
    public int createCart(int personId) {
        String query = "INSERT INTO Cart (PersonID) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, personId);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Trả về CartID mới tạo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Thất bại trong việc tạo giỏ hàng
    }

    // Lấy giỏ hàng theo PersonID
    public Cart getCartByPersonId(String personId) {
        Cart cart = null;
        String query = "SELECT * FROM Cart WHERE PersonID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, personId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cart = new Cart();
                cart.setCartID(rs.getInt("CartID"));
                cart.setPerson(personDAO.getPersonById(personId)); // Gọi phương thức để lấy Person
                cart.setStatus(rs.getInt("Status")); // Giả sử có thuộc tính Status trong bảng Cart
                
                // Lấy danh sách các mục trong giỏ hàng
                CartItemDAO cartItemDAO = new CartItemDAO();
                List<CartItem> items = cartItemDAO.getCartItemsByCartId(cart.getCartID());
                cart.setItems(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    // Xóa giỏ hàng
    public void deleteCart(int cartId) {
        String query = "DELETE FROM Cart WHERE CartID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật trạng thái giỏ hàng
    public void updateCartStatus(int cartId, int status) {
        String query = "UPDATE Cart SET Status = ? WHERE CartID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, status);
            stmt.setInt(2, cartId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
