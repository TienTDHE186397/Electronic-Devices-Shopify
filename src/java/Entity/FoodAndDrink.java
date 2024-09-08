/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class FoodAndDrink {
    private int fadid;
    private String fadname;
    private int price;

    public FoodAndDrink() {
    }

    public FoodAndDrink(int fadid, String fadname, int price) {
        this.fadid = fadid;
        this.fadname = fadname;
        this.price = price;
    }

    public int getFadid() {
        return fadid;
    }

    public void setFadid(int fadid) {
        this.fadid = fadid;
    }

    public String getFadname() {
        return fadname;
    }

    public void setFadname(String fadname) {
        this.fadname = fadname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodAndDrink{" + "fadid=" + fadid + ", fadname=" + fadname + ", price=" + price + '}';
    }
    
    
}
