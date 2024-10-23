package DAO;

import Entity.Product;
import Entity.ProductAttribute;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOProductTest {

    // Initialize DAOProduct to be used in the tests
    DAOProduct daoProduct = new DAOProduct();

    @Test
    public void testAddProductAttribute() {
        int productId = 1;
        String attributeName = "Color";
        String attributeValue = "Red";

        boolean result = daoProduct.addProductAttribute(productId, attributeName, attributeValue);
        assertTrue(result); // Check if the addition was successful
    }

    @Test
    public void testUpdateProductAttributes() {
        int productId = 1;
        String oldAttributeName = "Color";
        String newAttributeName = "Shade";
        String attributeValue = "Dark Red";

        boolean result = daoProduct.updateProductAttributes(productId, oldAttributeName, newAttributeName, attributeValue);
        assertTrue(result); // Check if the update was successful
    }

    @Test
    public void testIsValidCategory() {
        String categoryId = "1";

        boolean result = daoProduct.isValidCategory(categoryId);
        assertTrue(result); // Ensure the category ID is valid
    }

    
    @Test
    public void testGetProductById() {
        int productId = 1;
        Product product = daoProduct.getProductById(productId);
        assertNotNull(product); // Ensure a product is returned
        assertEquals(productId, product.getProductID()); // Check the ID matches
    }

    @Test
    public void testGetProductAttributesById() {
        int productId = 1;
        List<ProductAttribute> attributes = daoProduct.getProductAttributesById(productId);
        assertNotNull(attributes); // Ensure the list is not null
        assertTrue(attributes.size() > 0); // Check that attributes were returned
    }

    @Test
    public void testGetAllProduct() {
        List<Product> products = daoProduct.getAllProduct();
        assertNotNull(products); // Ensure the list is not null
        assertTrue(products.size() > 0); // Check that products were returned
    }

   @Test
    public void testGetImageById() {
        int productId = 1;
        String image = daoProduct.getImageById(productId);
        assertNotNull(image); // Ensure the image is returned
        assertFalse(image.isEmpty()); // Check that the image string is not empty
    }

    @Test
    public void testMain() {
        // You can mock or simplify this for unit testing purposes.
        DAOProduct daoProduct = new DAOProduct();
        Product product = daoProduct.getProductById(2);
        assertNotNull(product); // Ensure product is not null
        System.out.println("Product: " + product.getProductName());
    }
}
