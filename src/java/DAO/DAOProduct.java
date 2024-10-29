/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class DAOProduct extends DBContext {
//Son

    public boolean addProductAttribute(int productId, String attributeName, String attributeValue) {
        String sql = "INSERT INTO ProductAttributes (productId, attributeName, attributeValue) VALUES (?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, productId);
            st.setString(2, attributeName);
            st.setString(3, attributeValue);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }

    public boolean updateProductAttributes(int productId, String oldAttributeName, String newAttributeName, String attributeValue) {
        boolean isUpdated = true;
        String sql = "UPDATE [dbo].[ProductAttributes] SET [AttributeName] = ?, [AttributeValue] = ? WHERE [AttributeName] = ? AND ProductID = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, newAttributeName);
            st.setString(2, attributeValue);
            st.setString(3, oldAttributeName);
            st.setInt(4, productId);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isUpdated = false;
        }
        return isUpdated; // Trả về trạng thái cập nhật
    }

    public boolean isValidCategory(String categoryId) {
        String sql = "SELECT * FROM Categories WHERE CategoryID = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, categoryId);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();  // Trả về true nếu CategoryID tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(int productId, String title, String ProductName, int view, Date releaseDate, int QuantitySold, int category,
            int Quantity, int Sale, String img, double price, String publisher, String sortDescription, String description, String status) {

        // Kiểm tra nếu CategoryID hợp lệ
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [title] = ?\n" //1
                + "      ,[ProductName] = ?\n" //2
                + "      ,[Views] = ?\n" //3
                + "      ,[releaseDate] = ?\n" //4
                + "      ,[QuantitySold] = ?\n" //5
                + "      ,[CategoryID] = ? \n" //6
                + "      ,[Quantity] = ?\n" //7
                + "      ,[Sale] = ?\n" //8
                + "      ,[img] = ?\n" //9
                + "      ,[price] = ?\n" // 10
                + "      ,[publisher] = ?\n"//11
                + "      ,[sortDescription] = ?\n" //12
                + "      ,[description] = ?\n" //13
                + "      ,[status] = ?\n" //14
                + " WHERE Products.ProductID = ?";  //15

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, title);
            st.setString(2, ProductName);
            st.setInt(3, view);
            st.setDate(4, (java.sql.Date) releaseDate);
            st.setInt(5, QuantitySold);
            st.setInt(6, category);
            st.setInt(7, Quantity);
            st.setInt(8, Sale);
            st.setString(9, img);
            st.setDouble(10, price);
            st.setString(11, publisher);
            st.setString(12, sortDescription);
            st.setString(13, description);
            st.setString(14, status);
            st.setInt(15, productId);
            int rowsAffected = st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return true; // Trả về trạng thái cập nhật
    }

    public Product getProductById(int productId) {
        Product product = null;

        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                CategoryDAO cDao = new CategoryDAO();
                Categories cate = cDao.getCategoriesById(rs.getInt("CategoryID"));
                // Tạo một đối tượng Product mới và thiết lập tất cả các trường
                product = new Product(
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

                // Giả sử bạn có một phương thức trong lớp Product để thiết lập các thuộc tính
            }
        } catch (Exception e) {
            e.printStackTrace();  // Ghi log hoặc in lỗi để hiểu vấn đề
        }

        return product;
    }

    public List<ProductAttribute> getProductAttributesById(int productId) {

        List<ProductAttribute> attributeList = new ArrayList<>();

        String sql = "SELECT pa.AttributeID, pa.AttributeName, pa.AttributeValue "
                + "FROM ProductAttributes pa "
                + "WHERE pa.ProductID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            // Iterate through all the results in the result set
            while (rs.next()) {
                Product p = getProductById(productId);
                ProductAttribute proAttribute = new ProductAttribute(
                        rs.getInt("AttributeID"),
                        rs.getString("AttributeName"),
                        rs.getString("AttributeValue"),
                        p
                );
                // Add each attribute to the list
                attributeList.add(proAttribute);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attributeList; // Return the list of attributes
    }

//int productID, String title, String productName,
//            int views, Date releaseDate, int quantitySold, Categories category, int quantity, 
//            int sale, String img, double price, String publisher, String sortDescription,
//            String description, String status, String brand
    public List<Product> getAllProduct() {
        List<Product> listP = new ArrayList<>();
        String sql = "SELECT  p.ProductID,p.title, p.Views, p.ProductName, p.releaseDate, p.QuantitySold, p.CategoryID,  p.Quantity, \n"
                + "                p.Sale,  p.img, p.price, p.publisher, p.sortDescription, p.description, p.status,p.brand\n"
                + "                FROM Products p\n"
                + "                JOIN ProductAttributes pa ON p.ProductID = pa.ProductID\n"
                + "                GROUP BY\n"
                + "                p.ProductID, p.Views, p.ProductName, p.releaseDate, p.QuantitySold, p.CategoryID, \n"
                + "                p.Quantity, p.Sale, p.img, p.price, p.publisher, p.sortDescription, p.description, p.status , p.title,p.brand;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                CategoryDAO cDao = new CategoryDAO();
                Categories cate = cDao.getCategoriesById(rs.getInt("CategoryID"));

                // Create the Product object with aggregated attributes
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


                listP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listP;
    }

    public boolean deleteAttribute(int attributeID) {
        String sql = "DELETE FROM [dbo].[ProductAttributes] \n"
                + "      WHERE AttributeID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, attributeID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        } catch (Exception e) {
            e.printStackTrace(); // Ghi log lỗi
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

    public String getImageById(int productId) {
        String image = "img/default-phone.jpg"; // Đường dẫn ảnh mặc định
        String sql = "SELECT img \n"
                + "FROM Products \n"
                + "WHERE ProductID = ?"; // Thay bằng tên bảng của bạn
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                image = rs.getString("img");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public static void main(String[] args) {
        DAOProduct p = new DAOProduct();
        Product d = p.getProductById(2);
        System.out.println(d.getImg());
        System.out.println(d != null ? d : "Product with ID not found"); // Kiểm tra sản phẩm
        String a = p.getImageById(2);
        System.out.println(a);
      
    }
}
