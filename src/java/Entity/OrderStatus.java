/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class OrderStatus {

    private String status;
    private int count;

    // Constructor
    public OrderStatus(String status, int count) {
        this.status = status;
        this.count = count;
    }

    // Getter và Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderStatus{"
                + "status='" + status + '\''
                + ", count=" + count
                + '}';
    }
}
