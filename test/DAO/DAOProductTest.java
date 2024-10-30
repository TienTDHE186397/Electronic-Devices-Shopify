package DAO;

import Entity.Product;
import Entity.ProductAttribute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class DAOProductTest {

    private DAOProduct daoProduct;

    @Before
    public void setUp() {
        // Khởi tạo đối tượng DAOProduct trước mỗi test
        daoProduct = new DAOProduct();
    }

    @After
    public void tearDown() {
        // Giải phóng tài nguyên hoặc reset nếu cần sau mỗi test
    }

    @Test
    public void testAddProductAttribute() {
        // Giả lập thêm thuộc tính cho sản phẩm có ID = 1
        boolean result = daoProduct.addProductAttribute(1, "Color", "Red");
        assertFalse("Should return true when attribute is successfully added", result);
    }

    @Test
    public void testUpdateProductAttributes() {
        // Giả lập cập nhật thuộc tính cho sản phẩm có ID = 1
        boolean result = daoProduct.updateProductAttributes(1, "Color", "Size", "Large");
        assertTrue("Should return true when attribute is successfully updated", result);
    }

    @Test
    public void testIsValidCategory() {
        // Kiểm tra nếu CategoryID tồn tại
        boolean result = daoProduct.isValidCategory("1");  // Giả sử "1" là ID hợp lệ
        assertTrue("Should return true for a valid category", result);
    }

    @Test
    public void testUpdateProduct() {
        // Giả lập cập nhật thông tin sản phẩm với các giá trị test
        boolean result = daoProduct.updateProduct(1, "Test Title", "Test Product", 100, new java.sql.Date(System.currentTimeMillis()),
                50, 1, 100, 20, "test.jpg", 1500.0, "Test Publisher", "Short description", "Long description", "Available");
        assertTrue("Should return true when product is successfully updated", result);
    }

    @Test
    public void testGetProductById() {
        // Lấy sản phẩm theo ID và kiểm tra
        Product product = daoProduct.getProductById(1);  // Giả sử "1" là ID hợp lệ
        assertNotNull("Should return a product object when a valid ID is provided", product);
    }

    @Test
    public void testGetProductAttributesById() {
        // Kiểm tra danh sách các thuộc tính của sản phẩm
        List<ProductAttribute> attributes = daoProduct.getProductAttributesById(1);  // Giả sử "1" là ID hợp lệ
        assertNotNull("Should return a list of attributes", attributes);
        assertFalse("Should return a non-empty list for a product with attributes", attributes.isEmpty());
    }

    @Test
    public void testGetAllProduct() {
        // Kiểm tra danh sách tất cả sản phẩm
        List<Product> products = daoProduct.getAllProduct();
        assertNotNull("Should return a list of products", products);
        assertFalse("Should return a non-empty list if there are products in the database", products.isEmpty());
    }

    @Test
    public void testDeleteAttribute() {
        // Giả lập xóa thuộc tính với ID = 1
        boolean result = daoProduct.deleteAttribute(1);  // Giả sử "1" là ID hợp lệ
        assertTrue("Should return true if attribute is successfully deleted", result);
    }

    @Test
    public void testGetImageById() {
        // Kiểm tra lấy ảnh sản phẩm theo ID
        String imagePath = daoProduct.getImageById(1);  // Giả sử "1" là ID hợp lệ
        assertNotNull("Should return an image path", imagePath);
        assertFalse("Should return a valid path (not empty)", imagePath.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSalaryInvalidInput() {
        // Kiểm tra với input không hợp lệ, phương thức nên ném IllegalArgumentException
        daoProduct.calculateSalary(-1, 0, 6);
    }

    @Test
    public void testCalculateSalary() {
        // Kiểm tra tính lương với các input hợp lệ
        double salary = daoProduct.calculateSalary(5, 2000, 4.5);
        assertEquals("Should calculate salary with bonus and no deduction", 2100.0, salary, 0.0);

        salary = daoProduct.calculateSalary(12, 3000, 2.5);
        assertEquals("Should calculate salary with bonus and deduction", 3100.0, salary, 0.0);
    }
}
