/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class OrderByDay {

    private String dayOfWeek;
    private int completedOrders;

    public OrderByDay() {
    }

    public OrderByDay(String dayOfWeek, int completedOrders) {
        this.dayOfWeek = dayOfWeek;
        this.completedOrders = completedOrders;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(int completedOrders) {
        this.completedOrders = completedOrders;
    }

    @Override
    public String toString() {
        return "OrderByDay{" + "dayOfWeek=" + dayOfWeek + ", completedOrders=" + completedOrders + '}';
    }

}
