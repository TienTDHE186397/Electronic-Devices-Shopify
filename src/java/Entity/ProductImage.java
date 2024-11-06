/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dokkuhai
 */
public class ProductImage {
    private int image_id;
    private String image_url;
    private String alt_text;
    private Product product;

    public ProductImage(int image_id, String image_url, String alt_text, Product product) {
        this.image_id = image_id;
        this.image_url = image_url;
        this.alt_text = alt_text;
        this.product = product;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" + "image_id=" + image_id + ", image_url=" + image_url + ", alt_text=" + alt_text + ", product=" + product + '}';
    }
    
    
    
}
