package DAO;

import Entity.CartItem;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAO extends DBContext {

    // Thêm sản phẩm vào giỏ hàng
    public boolean addCartItem(int cartId, Product product, int quantity, int price) {
        String query = "INSERT INTO CartItem (CartID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            stmt.setInt(2, product.getProductID());
            stmt.setInt(3, quantity);
            stmt.setInt(4, price);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách sản phẩm trong giỏ hàng theo CartID
    public List<CartItem> getCartItemsByCartId(int cartId) {
        List<CartItem> items = new ArrayList<>();
        String query = "SELECT ci.CartItemID, ci.ProductID, ci.Quantity, p.Price " +
                       "FROM CartItem ci JOIN Products p ON ci.ProductID = p.ProductID " +
                       "WHERE ci.CartID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Price");

                // Tạo đối tượng Product để truyền vào CartItem
                Product product = new Product(); // Giả sử bạn đã có phương thức lấy thông tin sản phẩm
                product.setProductID(productId);
                product.setPrice(price); // Gán giá sản phẩm từ cơ sở dữ liệu

                // Tạo và thêm CartItem vào danh sách
                CartItem item = new CartItem();
                item.setProduct(product);
                item.setQuantity(quantity);
                item.setPrice(price);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    public void updateCartItemQuantity(int cartItemId, int quantity) {
        String query = "UPDATE CartItem SET Quantity = ? WHERE CartItemID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, cartItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void deleteCartItem(int cartItemId) {
        String query = "DELETE FROM CartItem WHERE CartItemID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, cartItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CartItemDAO cid = new CartItemDAO();
        ProductDAO pd = new ProductDAO();
        Product product = pd.getProductsById(1);
        if(cid.addCartItem(1, product, 0, 0)){
            System.out.println("success");
        }
    }
}
