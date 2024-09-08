/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Cinema;
import Entity.Order;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Order> getAllCinemaForAdmin() {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM Orders";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Order> getAllCinemaForUser(int uid) {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertOrder(String date, int userId, String userName, String productName, int roomId,
            int quantityProduct, int quantityFood, int quantityDrink,
            String cinemaName, int totalMoney, String method) {
        String Query = "INSERT INTO [dbo].[Orders] \n"
                + "    ([Date], [UserID], [UserName], [ProductName], [RoomId], [QuantityProduct], [QuantityFood], [QuantityDrink], [CinemaName], [TotalMoney], [Method]) \n"
                + "VALUES \n"
                + "    (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(Query);
            ps.setString(1, date);
            ps.setInt(2, userId);
            ps.setString(3, userName);
            ps.setString(4, productName);
            ps.setInt(5, roomId);
            ps.setInt(6, quantityProduct);
            ps.setInt(7, quantityFood);
            ps.setInt(8, quantityDrink);
            ps.setString(9, cinemaName);
            ps.setInt(10, totalMoney);
            ps.setString(11, method);

            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.getAllCinemaForUser(4);
        for (Order o : list) {
            System.out.println(o);
        }
    }
}
