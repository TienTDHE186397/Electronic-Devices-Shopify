/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.List;

/**
 *
 * @author admin
 */
public class Cart {

    private int cartID;
    private Person person;
    private List<CartItem> items;
    private int status;

    // Constructors, getters and setters

    public Cart() {
        this.status = 0;
    }

    public Cart(int cartID, Person person, List<CartItem> items, int status) {
        this.cartID = cartID;
        this.person = person;
        this.items = items;
        this.status = status;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartID=" + cartID + ", person=" + person + ", items=" + items + ", status=" + status + '}';
    }
    

   
}
