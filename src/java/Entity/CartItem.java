/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class CartItem {
    private int CartItemID;
    private int CartID;
    private int ProductID;
    private int Quantity;
    private double Price;
    private double TotalPrice;

    public CartItem() {
    }

    public CartItem(int CartItemID, int CartID, int ProductID, int Quantity, double Price, double TotalPrice) {
        this.CartItemID = CartItemID;
        this.CartID = CartID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Price = Price;
        this.TotalPrice = TotalPrice;
    }

    public int getCartItemID() {
        return CartItemID;
    }

    public void setCartItemID(int CartItemID) {
        this.CartItemID = CartItemID;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" + "CartItemID=" + CartItemID + ", CartID=" + CartID + ", ProductID=" + ProductID + ", Quantity=" + Quantity + ", Price=" + Price + ", TotalPrice=" + TotalPrice + '}';
    }
    
}
