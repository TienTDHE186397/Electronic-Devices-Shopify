/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.OrderByDay;
import Entity.OrderStatus;
import Entity.SaleOrder;
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

    public List<SaleOrder> getOrder() {
        List<SaleOrder> saleOrder = new ArrayList<>();
        String sql = "Select o.OrderID, o.OrderDate, p.Name as CustomerName, o.TotalMoney, o.[Status]\n"
                + "From Orders o\n"
                + "JOIN Person p ON o.PersonID = p.PersonID\n"
                + "ORDER BY o.OrderID";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrder s = new SaleOrder(rs.getInt("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getInt("TotalMoney"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
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

//    public static void main(String[] args) {
//
//        SaleDAO saleDAO = new SaleDAO();
//
//        
//        List<OrderStatus> orderStatusList = saleDAO.getOrderCountByStatus();
//        List<SaleOrder> orderSale = saleDAO.getOrder();
//        System.out.println(orderSale.get(0).getCusName());
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
//    }
}
