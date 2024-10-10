/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.OrderByDay;
import Entity.OrderStatus;
import Entity.SaleHomeOrder;
import Entity.SaleOrderL;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SaleDAO {

    private Connection connection;

    public SaleDAO() {
        DBContext dbContext = new DBContext();
        this.connection = dbContext.connection;
    }

    public List<OrderStatus> getOrderCountByStatus() {
        List<OrderStatus> orderStatusList = new ArrayList<>();

        String query = "SELECT [Status], COUNT(*) AS total_orders FROM Orders GROUP BY [Status]";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String status = rs.getString("status");
                int totalOrders = rs.getInt("total_orders");

                OrderStatus orderStatus = new OrderStatus(status, totalOrders);
                orderStatusList.add(orderStatus);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderStatusList;
    }

    public List<SaleHomeOrder> getOrder() {
        List<SaleHomeOrder> saleOrder = new ArrayList<>();
        String sql = "Select o.OrderID, o.OrderDate, p.Name as CustomerName, o.TotalMoney, o.[Status]\n"
                + "From Orders o\n"
                + "JOIN Person p ON o.PersonID = p.PersonID\n"
                + "ORDER BY o.OrderID";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleHomeOrder s = new SaleHomeOrder(rs.getInt("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getInt("TotalMoney"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
    }

    public List<SaleOrderL> getOrderL() {
        List<SaleOrderL> saleOrder = new ArrayList<>();
        String sql = "SELECT \n"
                + "    o.OrderID, \n"
                + "    o.OrderDate, \n"
                + "    c.Name AS CustomerName, \n"
                + "    sr.ShowRoomName, \n"
                + "    o.TotalMoney, \n"
                + "    o.Method, \n"
                + "    s.Name AS SaleName, \n"
                + "    o.Status\n"
                + "FROM \n"
                + "    Orders o\n"
                + "JOIN \n"
                + "    Person c ON o.PersonID = c.PersonID  \n"
                + "JOIN \n"
                + "    ShowRoom sr ON o.ShowRoomID = sr.ShowRoomID  \n"
                + "LEFT JOIN \n"
                + "    Person s ON o.SaleID = s.PersonID\n"
                + "ORDER BY\n"
                + "o.OrderDate DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getInt("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
    }

    public List<SaleOrderL> getOrderLByStatus(String status) {
        List<SaleOrderL> saleOrder = new ArrayList<>();
        String sql = "SELECT o.OrderID, o.OrderDate, p.Name AS CustomerName, r.ShowRoomName, o.TotalMoney, o.Method, s.Name AS SaleName, o.Status "
                + "FROM Orders o "
                + "JOIN Person p ON o.PersonID = p.PersonID "
                + "LEFT JOIN Person s ON o.SaleID = s.PersonID "
                + "JOIN ShowRoom r ON o.ShowRoomID = r.ShowRoomID "
                + "WHERE o.Status = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getInt("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
    }

    public List<SaleOrderL> searchOrders(String searchQuery) {
        List<SaleOrderL> orders = new ArrayList<>();
        String sql = "SELECT o.OrderID, o.OrderDate, p.Name AS CustomerName, r.ShowRoomName, o.TotalMoney, o.Method, s.Name AS SaleName, o.Status "
                + "FROM Orders o "
                + "JOIN Person p ON o.PersonID = p.PersonID "
                + "LEFT JOIN Person s ON o.SaleID = s.PersonID "
                + "JOIN ShowRoom r ON o.ShowRoomID = r.ShowRoomID "
                + "WHERE o.OrderID LIKE ? OR p.Name LIKE ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {

            String query = "%" + searchQuery + "%";
            st.setString(1, query);
            st.setString(2, query);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    SaleOrderL order = new SaleOrderL(
                            rs.getInt("OrderID"),
                            rs.getDate("OrderDate"),
                            rs.getString("CustomerName"),
                            rs.getString("ShowRoomName"),
                            rs.getDouble("TotalMoney"),
                            rs.getString("Method"),
                            rs.getString("SaleName"),
                            rs.getString("Status")
                    );
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return orders;
    }

    public List<OrderByDay> getCompletedOrdersByDayOfWeek() {
        List<OrderByDay> ordersByDay = new ArrayList<>();
        String sql = "SELECT \n"
                + "    DATENAME(WEEKDAY, OrderDate) AS DayOfWeek,\n"
                + "    COUNT(*) AS CompletedOrders\n"
                + "FROM \n"
                + "    Orders\n"
                + "WHERE \n"
                + "    [Status] = 'Complete' -- Assume 'Completed' is the status for successful orders\n"
                + "    AND OrderDate >= DATEADD(DAY, -7, GETDATE()) -- Only consider the last 7 days\n"
                + "GROUP BY \n"
                + "    DATENAME(WEEKDAY, OrderDate),\n"
                + "    DATEPART(WEEKDAY, OrderDate)\n"
                + "ORDER BY \n"
                + "    DATEPART(WEEKDAY, OrderDate)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String dayOfWeek = rs.getString("DayOfWeek");
                int completedOrders = rs.getInt("CompletedOrders");
                ordersByDay.add(new OrderByDay(dayOfWeek, completedOrders));
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return ordersByDay;

    }

    public int getTotalOrderCount() {
        int totalCount = 0;
        String query = "SELECT COUNT(*) AS total FROM Orders";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            {

                while (rs.next()) {
                    totalCount = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return totalCount;
    }

//    public static void main(String[] args) {
////
//        SaleDAO saleDAO = new SaleDAO();
//        String status = "Complete";
//        List<SaleOrderL> l = saleDAO.getOrderLByStatus(status);
////        List<OrderStatus> orderStatusList = saleDAO.getOrderCountByStatus();
////        List<SaleOrder> orderSale = saleDAO.getOrder();
//        System.out.println(l.get(0).getTotal());
//
//        
//        if (orderStatusList.isEmpty()) {
//            System.out.println("Không có dữ liệu trả về hoặc kết nối không thành công.");
//        } else {
//            System.out.println("Dữ liệu trạng thái đơn hàng:");
//            for (OrderStatus orderStatus : orderStatusList) {
//                System.out.println("Trạng thái: " + orderStatus.getStatus() + " - Tổng số đơn hàng: " + orderStatus.getCount());
//            }
//        }
}
//}
