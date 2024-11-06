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
public class SaleEmpDAO {

    private Connection connection;

    public SaleEmpDAO() {
        DBContext dbContext = new DBContext();
        this.connection = dbContext.connection;
    }

    public List<OrderStatus> getOrderCountByStatusS(Integer SaleID) {
        List<OrderStatus> orderStatusList = new ArrayList<>();

        String query = "SELECT [Status], COUNT(*) AS total_orders FROM Orders WHERE SaleID = ? GROUP BY [Status]";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (SaleID != null) {
                preparedStatement.setInt(1, SaleID);
            }
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

    public List<SaleHomeOrder> getOrderS(Integer SaleID) {
        List<SaleHomeOrder> saleOrder = new ArrayList<>();
        String sql = "Select o.OrderID, o.OrderDate, p.Name as CustomerName, o.TotalMoney, o.[Status]\n"
                + "From Orders o\n"
                + "JOIN Person p ON o.PersonID = p.PersonID\n"
                + "WHERE\n"
                + "o.SaleID = ?\n"
                + "ORDER BY o.OrderID";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (SaleID != null) {
                st.setInt(1, SaleID);
            }
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

    public List<SaleOrderL> getOrderLS(Integer SaleID) {
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
                + "WHERE \n"
                + "o.SaleID = ? \n"
                + "ORDER BY\n"
                + "o.OrderDate DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (SaleID != null) {
                st.setInt(1, SaleID);
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
    }

    public List<SaleOrderL> pagingOrder(int index, Integer SaleID) {
        List<SaleOrderL> list = new ArrayList<>();
        String sql = " SELECT \n"
                + "    o.OrderID, \n"
                + "    o.OrderDate, \n"
                + "    c.Name AS CustomerName, \n"
                + "    sr.ShowRoomName, \n"
                + "    o.TotalMoney, \n"
                + "    o.Method, \n"
                + "    s.Name AS SaleName, \n"
                + "    o.Status\n"
                + " FROM \n"
                + "    Orders o\n"
                + " JOIN \n"
                + "    Person c ON o.PersonID = c.PersonID  \n"
                + " JOIN \n"
                + "    ShowRoom sr ON o.ShowRoomID = sr.ShowRoomID  \n"
                + " LEFT JOIN \n"
                + "    Person s ON o.SaleID = s.PersonID\n"
                + " WHERE \n"
                + " o.SaleID = ? \n"
                + " ORDER BY\n"
                + " o.OrderDate DESC\n"
                + " OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, SaleID);
            st.setInt(2, (index - 1) * 5);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SaleOrderL> getOrderLByStatusS(String status, Integer SaleID) {
        List<SaleOrderL> saleOrder = new ArrayList<>();
        String sql = "SELECT o.OrderID, o.OrderDate, p.Name AS CustomerName, r.ShowRoomName, o.TotalMoney, o.Method, s.Name AS SaleName, o.Status "
                + "FROM Orders o "
                + "JOIN Person p ON o.PersonID = p.PersonID "
                + "LEFT JOIN Person s ON o.SaleID = s.PersonID "
                + "JOIN ShowRoom r ON o.ShowRoomID = r.ShowRoomID "
                + "WHERE o.Status = ?\n"
                + "AND(o.SaleID is null or o.SaleID = ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            if (SaleID != null) {
                st.setInt(2, SaleID);
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
                saleOrder.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return saleOrder;
    }

    public List<SaleOrderL> searchOrdersS(String searchQuery, Integer SaleID) {
        List<SaleOrderL> orders = new ArrayList<>();
        String sql = "SELECT o.OrderID, o.OrderDate, p.Name AS CustomerName, r.ShowRoomName, o.TotalMoney, o.Method, s.Name AS SaleName, o.Status \n"
                + "FROM Orders o \n"
                + "JOIN Person p ON o.PersonID = p.PersonID \n"
                + "LEFT JOIN Person s ON o.SaleID = s.PersonID \n"
                + "JOIN ShowRoom r ON o.ShowRoomID = r.ShowRoomID \n"
                + " WHERE (o.OrderID LIKE ? OR p.Name LIKE ?)\n"
                + " AND o.SaleID = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {

            String query = "%" + searchQuery + "%";
            st.setString(1, query);
            st.setString(2, query);
            if (SaleID != null) {
                st.setInt(3, SaleID);
            }
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    SaleOrderL order = new SaleOrderL(
                            rs.getString("OrderID"),
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
            e.printStackTrace();
        }

        return orders;
    }

//    public List<OrderByDay> getCompletedOrdersByDayOfWeekS(int SaleID) {
//    List<OrderByDay> ordersByDay = new ArrayList<>();
//    String sql = "SELECT \n"
//        + " DATENAME(WEEKDAY, OrderDate) AS DayOfWeek,\n"
//        + " COUNT(*) AS CompletedOrders\n"
//        + "FROM \n"
//        + " Orders\n"
//        + "WHERE \n"
//        + " [Status] = 'Complete'\n"
//        + " AND OrderDate >= DATEADD(DAY, -7, GETDATE())\n"
//        + " AND SaleID = ?\n"
//        + "GROUP BY \n"
//        + " DATENAME(WEEKDAY, OrderDate),\n"
//        + " DATEPART(WEEKDAY, OrderDate)\n"
//        + "ORDER BY \n"
//        + " DATEPART(WEEKDAY, OrderDate)";
//    
//    try (PreparedStatement st = connection.prepareStatement(sql)) {
//        st.setInt(1, SaleID);
//        
//        System.out.println("Executing query for SaleID: " + SaleID);
//        
//        try (ResultSet rs = st.executeQuery()) {
//            while (rs.next()) {
//                String dayOfWeek = rs.getString("DayOfWeek");
//                int completedOrders = rs.getInt("CompletedOrders");
//                ordersByDay.add(new OrderByDay(dayOfWeek, completedOrders));
//                
//                System.out.println("Day: " + dayOfWeek + ", Completed Orders: " + completedOrders);
//            }
//        }
//        
//        if (ordersByDay.isEmpty()) {
//            System.out.println("No data found for the given criteria.");
//        }
//    } catch (SQLException e) {
//        System.out.println("Error executing query: " + e.getMessage());
//        e.printStackTrace();
//    }
//    
//    return ordersByDay;
//}
    public List<OrderByDay> getCompletedOrdersByDayOfWeekS(Integer SaleID) {
        List<OrderByDay> ordersByDay = new ArrayList<>();
        String sql = "SELECT \n"
                + "    DATENAME(WEEKDAY, OrderDate) AS DayOfWeek,\n"
                + "    COUNT(*) AS CompletedOrders\n"
                + "FROM \n"
                + "    Orders\n"
                + "WHERE \n"
                + "    [Status] = 'Complete'\n"
                + "    AND OrderDate >= DATEADD(DAY, -7, GETDATE())\n"
                + "    AND SaleID = ?\n"
                + "GROUP BY \n"
                + "    DATENAME(WEEKDAY, OrderDate),\n"
                + "    DATEPART(WEEKDAY, OrderDate)\n"
                + "ORDER BY \n"
                + "    DATEPART(WEEKDAY, OrderDate)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (SaleID != null) {
                st.setInt(1, SaleID);
            }
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

    public int getTotalOrderCount(Integer SaleID) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) AS total FROM Orders Where SaleID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(query);
            if (SaleID != null) {
                st.setInt(1, SaleID);
            }
            ResultSet rs = st.executeQuery();
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

      public String getSaleIDByOrder(String orderID) {
        String query = "SELECT SaleID FROM [DBGR2Final].[dbo].[Orders] WHERE OrderID = ?";
        String saleID = "";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                saleID = resultSet.getString("SaleID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saleID;
    }

//     public static void main(String[] args){
//         SaleEmpDAO dao = new SaleEmpDAO();
//         String orderID = "1";
//         String saleID = dao.getSaleIDByOrder(orderID);
//         System.out.println(saleID);
//     }
//    public static void main(String[] args) {
//        SaleEmpDAO dao = new SaleEmpDAO();
//        List<SaleOrderL> list = dao.pagingOrder(2,6);
//        for(SaleOrderL o : list){
//            System.out.println(o);
//        }
//    }
}
//    public static void main(String[] args) {
//
//        SaleDAO saleDAO = new SaleDAO();
//        String status = "Complete";
//        List<SaleOrderL> l = saleDAO.getOrderLByStatus(status);
//        List<OrderStatus> orderStatusList = saleDAO.getOrderCountByStatus();
//        List<SaleOrder> orderSale = saleDAO.getOrder();
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
//}
//}
//public static void main(String[] args) {
//        SaleEmpDAO saleEmpDAO = new SaleEmpDAO();
//        int testSaleID = 6; // Thay đổi giá trị này theo SaleID bạn muốn test
//
//        // Test getCompletedOrdersByDayOfWeekS
//        List<OrderByDay> ordersByDay = saleEmpDAO.getCompletedOrdersByDayOfWeekS(testSaleID);
//        System.out.println("Orders by Day of Week:");
//        if (ordersByDay.isEmpty()) {
//            System.out.println("No data found for completed orders by day of week.");
//        } else {
//            for (OrderByDay order : ordersByDay) {
//                System.out.println(order.getDayOfWeek() + ": " + order.getCompletedOrders());
//            }
//        }
//}
//}
