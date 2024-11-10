/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.OrderProduct;
import Entity.Orders;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author nghie
 */
public class DAOAdmin extends DBContext {

    public Person getPersonById(String id) {
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID where p.PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                Person p = new Person(rs.getInt("PersonID"),
                        rs.getString("Image"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate,
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("RoleID"),
                        rs.getString("Password"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAllCustomers() {
        String sql = "select count(*) from Person where RoleID = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Orders> searchOrders(String search, String status, String startDate, String endDate) {
        List<Orders> list = new ArrayList<>();
        String sql = "Select * from Orders where 1=1";
        if (search != null && !search.isEmpty()) {
            sql += " and Method like N'%" + search + "%'";
        }
        if (status != null && !status.isEmpty()) {
            sql += " and Status = '" + status + "'";
        }
        if (startDate != null && !startDate.isEmpty()) {
            if (endDate != null && !endDate.isEmpty()) {
                sql += " and OrderDate between '" + startDate + "' and '" + endDate + "'";
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt("OrderID"),
                        rs.getString("OrderDate"),
                        rs.getInt("PersonID"),
                        rs.getInt("ShowroomID"),
                        rs.getInt("TotalMoney"),
                        rs.getString("Method"),
                        rs.getString("Status"));
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getAllOrder() {
        String sql = "select count(*) from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Orders> getOrder() {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt("OrderID"),
                        rs.getString("OrderDate"),
                        rs.getInt("PersonID"),
                        rs.getInt("ShowroomID"),
                        rs.getInt("TotalMoney"),
                        rs.getString("Method"),
                        rs.getString("Status"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getSuccessOrder() {
        String sql = "Select count(*) from orders where Status = 'Complete' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCancelOrder() {
        String sql = "Select count(*) from orders where Status = 'In Line' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getShipOrder() {
        String sql = "Select count(*) from orders where Status = 'In Progress' ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int TotalRevenue() {
        String sql = "select sum(TotalMoney) from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int TotalComment() {
        String sql = "select count(*) from Comment";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        DAOAdmin da = new DAOAdmin();
//        int n = da.getSuccessOrder();
//        System.out.println(n);
//        List<Orders> list = da.searchOrders("T", "", "", "");
//        for (Orders o : list) {
//            System.out.println(o);
//        }
        OrderProduct op = da.getOrderById("1");
        System.out.println(op);
    }

    public int NewRegister() {
        String sql = "select count(*) from Person where RoleID = 1 and PersonID not in(1,2,3,4,5)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int NewPurchaser() {
        String sql = "select count(PersonID) from Orders where OrderID not in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double Rate() {
        String sql = "select AVG(CAST(RatedStar AS decimal(10, 1))) from Feedback";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public int getRevenueByCategory(int CateID) {
        String sql = "SELECT SUM(od.TotalCost) AS TotalRevenue \n"
                + "FROM OrderDetails od \n"
                + "JOIN Products p ON od.ProductID = p.ProductID \n"
                + "JOIN Categories c ON p.CategoryID = c.CategoryID \n"
                + "where p.CategoryID = " + CateID
                + "GROUP BY c.CategoryID, c.CategoryName;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getRateByCategory(int CateID) {
        String sql = "select AVG(CAST(RatedStar AS decimal(10, 1))) \n"
                + " from Feedback c \n"
                + " join Products p on p.ProductID = c.ProductID \n"
                + " where p.CategoryID = \n" + CateID
                + " group by p.ProductID";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public int RateCount(double Rate) {
        String sql = "Select count(*) from Feedback where RatedStar = " + Rate;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public OrderProduct getOrderById(String id) {
        String sql = "SELECT p.ProductID, p.ProductName, p.img, od.Quantity, od.UnitPrice, od.TotalCost \n"
                + "        FROM Orders o \n"
                + "        JOIN OrderDetails od ON o.OrderID = od.OrderID \n"
                + "        JOIN Products p ON od.ProductID = p.ProductID \n"
                + "        WHERE o.OrderID = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderProduct op = new OrderProduct(rs.getString("ProductID"),
                        rs.getString("img"),
                        rs.getString("ProductName"),
                        rs.getInt("UnitPrice"),
                        rs.getInt("Quantity"),
                        rs.getInt("TotalCost"));
                return op;
            }
        } catch (Exception e) {

        }

        return null;
    }
    public int getNewestOrderID(){
        String sql = "SELECT IDENT_CURRENT('Orders')+1 AS NewIdentityValue;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            
        }
        return -1;
    }
}
