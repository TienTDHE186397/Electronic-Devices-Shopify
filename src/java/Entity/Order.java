/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Order {

    private int orderid;
    private String date;
    private int userid;
    private String username;
    private String productname;
    private String roomid;
    private int quantityproduct;
    private int quantityfood;
    private int quantitydrink;

    private String cinemaname;
    private int totalmoney;
    private String method;

    public Order() {
    }

    public Order(int orderid, String date, int userid, String username, String productname, String roomid, int quantityproduct, int quantityfood, int quantitydrink, String cinemaname, int totalmoney, String method) {
        this.orderid = orderid;
        this.date = date;
        this.userid = userid;
        this.username = username;
        this.productname = productname;
        this.roomid = roomid;
        this.quantityproduct = quantityproduct;
        this.quantityfood = quantityfood;
        this.quantitydrink = quantitydrink;
        this.cinemaname = cinemaname;
        this.totalmoney = totalmoney;
        this.method = method;
    }



    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantityproduct() {
        return quantityproduct;
    }

    public void setQuantityproduct(int quantityproduct) {
        this.quantityproduct = quantityproduct;
    }

    public int getQuantityfood() {
        return quantityfood;
    }

    public void setQuantityfood(int quantityfood) {
        this.quantityfood = quantityfood;
    }

    public int getQuantitydrink() {
        return quantitydrink;
    }

    public void setQuantitydrink(int quantitydrink) {
        this.quantitydrink = quantitydrink;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
