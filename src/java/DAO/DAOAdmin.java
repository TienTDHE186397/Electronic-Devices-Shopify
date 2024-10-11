/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Orders;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author nghie
 */
public class DAOAdmin extends DBContext {

    public void getAdmin() {
        String sql = "select * from Person where ";
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
        String sql = "Select count(*) from orders where Status = 'Hoàn thành' ";
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
        String sql = "Select count(*) from orders where Status = 'Đã hủy' ";
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
        String sql = "Select count(*) from orders where Status = 'Đã ship' ";
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
List<Orders> list = da.searchOrders("T", "", "", "");
        for(Orders o:list){
        System.out.println(o);
        }
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
        String sql = "select count(PersonID) from Orders where OrderID not in (1) ";
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
        String sql = "select AVG(CAST(Rate AS decimal(10, 1))) from Comment";
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
        String sql = "select sum(o.TotalMoney) \n"
                + "from Orders o \n"
                + "join OrderDetails od on o.OrderID = od.OrderID \n"
                + "join Products p on p.ProductID = od.ProductID \n"
                + "where p.CategoryID = \n" + CateID
                + " group by p.CategoryID";
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
        String sql = "select AVG(CAST(Rate AS decimal(10, 1))) \n"
                + " from Comment c \n"
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
        String sql = "Select count(*) from Comment where Rate = " + Rate;
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
}

    
