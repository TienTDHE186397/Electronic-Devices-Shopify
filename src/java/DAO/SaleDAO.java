/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.OrderByDay;
import Entity.OrderProduct;
import Entity.OrderStatus;
import Entity.Person;
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
                + "o.OrderID DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"), rs.getDate("OrderDate"), rs.getString("CustomerName"), rs.getString("ShowRoomName"), rs.getInt("TotalMoney"), rs.getString("Method"), rs.getString("SaleName"), rs.getString("Status"));
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

    public List<SaleOrderL> getDetails(String orderID) {
        List<SaleOrderL> detail = new ArrayList<>();
        String sql = "SELECT \n"
                + "    o.OrderID,\n"
                + "    p.Name AS cusName,\n"
                + "    p.Email,\n"
                + "    -- Get primary phone number from PersonPhone table\n"
                + "    (SELECT TOP 1 pp.Phone \n"
                + "     FROM PersonPhone pp \n"
                + "     WHERE pp.PersonID = p.PersonID \n"
                + "     ORDER BY pp.IsPrimary DESC) AS mobile,\n"
                + "    o.OrderDate,\n"
                + "    o.TotalMoney AS totalCost,\n"
                + "    s.Name AS saleName,\n"
                + "    o.Status,\n"
                + "    p.Gender,\n"
                + "    -- Get primary address from PersonAddress table\n"
                + "    (SELECT TOP 1 pa.Address \n"
                + "     FROM PersonAddress pa \n"
                + "     WHERE pa.PersonID = p.PersonID \n"
                + "     ORDER BY pa.IsPrimary DESC) AS Address,\n"
                + "    o.SaleNote\n"
                + "FROM \n"
                + "    Orders o\n"
                + "JOIN \n"
                + "    Person p ON o.PersonID = p.PersonID  -- Customer details\n"
                + "LEFT JOIN \n"
                + "    Person s ON o.SaleID = s.PersonID    -- Sales employee details (optional)\n"
                + "WHERE \n"
                + "    o.OrderID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"),
                        rs.getString("cusName"),
                        rs.getString("Email"),
                        rs.getString("mobile"),
                        rs.getDate("OrderDate"),
                        rs.getInt("totalCost"),
                        rs.getString("saleName"),
                        rs.getString("Status"),
                        rs.getString("Gender"),
                        rs.getString("Address"),
                        rs.getString("SaleNote")
                );
                detail.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return detail;
    }

    public List<OrderProduct> getProDetails(String orderID) {
        List<OrderProduct> op = new ArrayList<>();
        String sql = " SELECT  \n"
                + "    OD.OrderDetailID, \n"
                + "    P.img,\n"
                + "    P.ProductName,\n"
                + "    C.CategoryName AS Category,\n"
                + "    P.price AS UnitPrice,\n"
                + "    OD.Quantity,\n"
                + "    (P.price * OD.Quantity) AS TotalCost \n"
                + " FROM \n"
                + "    Products P\n"
                + "    INNER JOIN Categories C ON P.CategoryID = C.CategoryID \n"
                + "    INNER JOIN OrderDetails OD ON P.ProductID = OD.ProductID \n"
                + " Where OrderID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderProduct s = new OrderProduct(
                        rs.getString("OrderDetailID"),
                        rs.getString("img"),
                        rs.getString("ProductName"),
                        rs.getString("Category"),
                        rs.getDouble("UnitPrice"),
                        rs.getInt("Quantity"),
                        rs.getDouble("TotalCost")
                );

                op.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return op;
    }

    public List<SaleOrderL> getUpdate(String orderID) {
        List<SaleOrderL> so = new ArrayList<>();
        String sql = "SELECT \n"
                + "    O.OrderID,\n"
                + "    O.Status,\n"
                + "    O.SaleNote,\n"
                + "    CASE \n"
                + "        WHEN O.SaleID IS NULL THEN NULL\n"
                + "        ELSE P.Name\n"
                + "    END AS saleName\n"
                + "FROM \n"
                + "    Orders O\n"
                + "LEFT JOIN \n"
                + "    Person P ON O.SaleID = P.PersonID\n"
                + "Where OrderID = ?\n";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SaleOrderL s = new SaleOrderL(rs.getString("OrderID"), rs.getString("SaleNote"), rs.getString("saleName"), rs.getString("Status"));
                so.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return so;
    }

    public List<Person> getAllSale() {
        List<Person> salePersons = new ArrayList<>();
        String sql = "SELECT PersonID, Name, RoleID \n"
                + "FROM Person \n"
                + "WHERE RoleID IN (3, 4)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getInt("PersonID"), rs.getString("Name"), rs.getInt("RoleID"));
                salePersons.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return salePersons;
    }

    public void Update(SaleOrderL s) {
        String sql = "UPDATE Orders SET Status = ?, SaleNote = ?, SaleID = ? WHERE OrderID = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, s.getOrderID());
            st.setString(2, s.getSaleNotes());
            st.setString(3, s.getSaleID());
            st.setString(4, s.getStatus());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating order failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating order: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getTotalOrders() {

        String sql = "SELECT COUNT(*) FROM Orders";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<SaleOrderL> pagingOrder(int index) {
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
                + " ORDER BY\n"
                + "    o.OrderID DESC"
                + " OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * 5);
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

//    public static void main(String[] args) {
//        SaleDAO dao = new SaleDAO();
//        List<SaleOrderL> list = dao.pagingOrder(2);
//        for(SaleOrderL o : list){
//            System.out.println(o);
//        }
//    }
//public static void main(String[] args) {
//        // Create a SaleDAO instance (assuming your SaleDAO class is already defined)
//        SaleDAO saleDAO = new SaleDAO();
//
//        // Create a SaleOrderL object with test data (assuming the constructor is defined correctly)
//        String testOrderID = "5";  // Use an existing OrderID for testing
//        String testStatus = "In Progress";  // New status to update
//        String testSaleNotes = "must be Complete";  // New sale notes
//        String testSaleID = "7";  // Salesperson ID for assignment (ensure this exists in your DB)
//
//        SaleOrderL saleOrder = new SaleOrderL(testStatus, testSaleNotes, testSaleID, testOrderID);
//        saleOrder.setSaleID(testSaleID);  // If you have a setter for SaleID
//
//        // Call the Update method to update the order in the database
//        saleDAO.Update(saleOrder);
//
//        // If no exceptions are thrown, print success message
//        System.out.println("Order update method executed. Please check the database for changes.");
//    }
//    public static void main(String[] args) {
////
//        SaleDAO saleDAO = new SaleDAO();
//        String status = "Complete";
//        List<Details> l = saleDAO.getDetails();
////        List<OrderStatus> orderStatusList = saleDAO.getOrderCountByStatus();
////        List<SaleOrder> orderSale = saleDAO.getOrder();
//        System.out.println(l.get(0).getTotal());
//
//        
//        if (Details.isEmpty()) {
//            System.out.println("Không có dữ liệu trả về hoặc kết nối không thành công.");
//        } else {
//            System.out.println("Dữ liệu trạng thái đơn hàng:");
//            for (OrderStatus orderStatus : Details) {
//                System.out.println("Trạng thái: " + orderStatus.getStatus() + " - Tổng số đơn hàng: " + orderStatus.getCount());
//            }
//        }
//      public static void main(String[] args) {
//        // Assuming 'DetailsDAO' is the class where getDetails() is implemented
//        SaleDAO saleDAO = new SaleDAO();
//        String orderID = "1";
//        // Get the details
//        List<SaleOrderL> detailsList = saleDAO.getUpdate(orderID);
//
//        // Check if details are retrieved and print them
//        if(detailsList.isEmpty()){
//                System.out.println("trong");
//        }else{
//        for (SaleOrderL detail : detailsList) {
//            System.out.println(detail);
//            
//            System.out.println("----------------------------");
//        }
//}
//      }
}
