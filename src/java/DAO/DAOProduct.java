/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.Product;
import Entity.Product2;
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

    public Product getProductById(int productId) {
        Product product = null;

        String sql = "SELECT p.ProductID, p.Views, p.ProductName, p.releaseDate, p.QuantitySold, p.CategoryID, "
                + "p.Quantity, p.Sale, p.img, p.price, p.publisher, p.sortDescription, p.description, p.status, "
                + "pa.AttributeID, pa.AttributeName, pa.AttributeValue "
                + "FROM Products p "
                + "LEFT JOIN ProductAttributes pa ON p.ProductID = pa.ProductID "
                + "WHERE p.ProductID = ?;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                CategoryDAO cDao = new CategoryDAO();
                Categories cate = cDao.getCategoriesById(rs.getInt("CategoryID"));
                // Tạo một đối tượng Product mới và thiết lập tất cả các trường
                product = new Product(
                        rs.getString("ProductName"),
                        rs.getInt("ProductID"),
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
                        rs.getString("status")
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
                ProductAttribute proAttribute = new ProductAttribute(
                        rs.getInt("AttributeID"),
                        rs.getString("AttributeName"),
                        rs.getString("AttributeValue")
                );
                // Add each attribute to the list
                attributeList.add(proAttribute);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attributeList; // Return the list of attributes
    }

    public List<Product> getAllProduct() {
        List<Product> listP = new ArrayList<>();
        String sql = "SELECT \n"
                + "    p.ProductID, p.Views, p.ProductName, p.releaseDate, p.QuantitySold, p.CategoryID,  p.Quantity, \n"
                + "    p.Sale,  p.img, p.price, p.publisher, p.sortDescription, p.description, p.status, \n"
                + "    STRING_AGG(CONCAT(pa.AttributeName, ': ', pa.AttributeValue), ', ') AS Attributes\n"
                + "    FROM Products p\n"
                + "    JOIN ProductAttributes pa ON p.ProductID = pa.ProductID\n"
                + "    GROUP BY \n"
                + "    p.ProductID, p.Views, p.ProductName, p.releaseDate, p.QuantitySold, p.CategoryID, \n"
                + "    p.Quantity, p.Sale, p.img, p.price, p.publisher, p.sortDescription, p.description, p.status;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                CategoryDAO cDao = new CategoryDAO();
                Categories cate = cDao.getCategoriesById(rs.getInt("CategoryID"));

                // Create the Product object with aggregated attributes
                Product p = new Product(
                        rs.getString("ProductName"),
                        rs.getInt("ProductID"),
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
                        rs.getString("status")
                );
                listP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listP;
    }

    public static void main(String[] args) {
        DAOProduct p = new DAOProduct();
//        List<Product> list = p.getAllProduct();
//
//        if (list != null && !list.isEmpty()) {
//            System.out.println("There are products in the list.");
//            for (Product o : list) {
//                System.out.println("Product: " + o);
//            }
//        } else {
//            System.out.println("No products found.");
//        }
//        List<ProductAttribute> attributeList = p.getProductAttributesById(1);
//
//        if (attributeList != null && !attributeList.isEmpty()) {
//            System.out.println("Attributes for Product ID 1:");
//            for (ProductAttribute attr : attributeList) {
//                System.out.println(attr);
//            }
//        } else {
//            System.out.println("No attributes found for Product ID 1.");
//        }
//        int productId = 2; // Thay đổi theo ID sản phẩm bạn muốn thử nghiệm
//        String[] oldAttributeNames = {"RAM Updated", "Screen Size", "Battery Capacity"};
//        String[] newAttributeNames = {"RAM Updated2", "Screen Size2", "Battery Capacity2"};
//        String[] attributeValues = {"12", "12 inches", "12Amh"};
//        for (int i = 0; i < oldAttributeNames.length; i++) {
//            String newName = newAttributeNames[i]; // Tên thuộc tính mới từ input
//            String value = attributeValues[i]; // Giá trị thuộc tính mới từ input
//            String oldName = oldAttributeNames[i];
//            Boolean check = p.updateProductAttributes(productId, oldName, newName, value);
//            if (check) {
//                System.out.println("Cập nhật thuộc tính thành công!");
//            } else {
//                System.out.println("Cập nhật thuộc tính thất bại!");
//            }
//        }
        int productId = 1; // Change this to an actual product ID
//        String attributeName = "Color"; // Example attribute name
//        String attributeValue = "Red"; // Example attribute value
        String[] attributeName = {"RED", "RED"};
        String[] attributeValue = {"Blue", "Blue"};
        for (int i = 0; i < attributeName.length; i++) {
            String newName = attributeName[i]; // Tên thuộc tính mới từ input
            String value = attributeValue[i]; // Giá trị thuộc tính mới từ input

            Boolean check = p.addProductAttribute(productId, newName, value);
            if (check) {
                System.out.println("Cập nhật thuộc tính thành công!");
            } else {
                System.out.println("Cập nhật thuộc tính thất bại!");
            }
        }
    }
}
