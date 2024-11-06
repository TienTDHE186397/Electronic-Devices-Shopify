/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import Entity.MyOrder;
import Entity.SaleOrderL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class MyOrderDAO extends DBContext {
//    phương thức để select ra tất cả đơn hàng dựa vào ID của người dùng

    public List<MyOrder> getOrderByPersonID(String PersonID) {
        List<MyOrder> Order = new ArrayList<>();
        String sql = "SELECT \n"
                + "    pi.image_url,\n"
                + "    o.OrderID,\n"
                + "    o.OrderDate,\n"
                + "    o.PersonID,\n"
                + "    o.ShowRoomID,\n"
                + "    o.TotalMoney,\n"
                + "    o.Method,\n"
                + "    o.SaleID,\n"
                + "    o.[Status],\n"
                + "    o.ShipStatus,\n"
                + "    o.CompleteDate,\n"
                + "    o.ExprotedDate,\n"
                + "    o.InDeliveryDate,\n"
                + "    o.DeliveredDate,\n"
                + "    o.receivedDate\n"
                + "FROM \n"
                + "    Orders o\n"
                + "JOIN PersonImages pi ON o.PersonID = pi.PersonID\n"
                + "WHERE \n"
                + "    o.PersonID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, PersonID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(rs.getString("image_url"),
                        rs.getString("OrderID"),
                        rs.getDate("OrderDate"),
                        rs.getString("PersonID"),
                        rs.getString("ShowRoomID"),
                        rs.getDouble("TotalMoney"),
                        rs.getString("Method"),
                        rs.getString("SaleID"),
                        rs.getString("Status"),
                        rs.getString("ShipStatus"),
                        rs.getDate("CompleteDate"),
                        rs.getDate("ExprotedDate"),
                        rs.getDate("InDeliveryDate"),
                        rs.getDate("DeliveredDate"),
                        rs.getDate("receivedDate")
                );
                Order.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return Order;
    }
    public List<MyOrder> getMyOrderInfo(String OrderID) {
        List<MyOrder> Order = new ArrayList<>();
        String sql = "SELECT \n"
                + "    pi.image_url,\n"
                + "    o.OrderID,\n"
                + "    o.OrderDate,\n"
                + "    o.PersonID,\n"
                + "    o.ShowRoomID,\n"
                + "    o.TotalMoney,\n"
                + "    o.Method,\n"
                + "    o.SaleID,\n"
                + "    o.[Status],\n"
                + "    o.ShipStatus,\n"
                + "    o.CompleteDate,\n"
                + "    o.ExprotedDate,\n"
                + "    o.InDeliveryDate,\n"
                + "    o.DeliveredDate,\n"
                + "    o.receivedDate\n"
                + "FROM \n"
                + "    Orders o\n"
                + "JOIN PersonImages pi ON o.PersonID = pi.PersonID\n"
                + "WHERE \n"
                + "   o.OrderID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, OrderID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(rs.getString("image_url"),
                        rs.getString("OrderID"),
                        rs.getTimestamp("OrderDate"),
                        rs.getString("PersonID"),
                        rs.getString("ShowRoomID"),
                        rs.getDouble("TotalMoney"),
                        rs.getString("Method"),
                        rs.getString("SaleID"),
                        rs.getString("Status"),
                        rs.getString("ShipStatus"),
                        rs.getTimestamp("CompleteDate"),
                        rs.getTimestamp("ExprotedDate"),
                        rs.getTimestamp("InDeliveryDate"),
                        rs.getTimestamp("DeliveredDate"),
                        rs.getTimestamp("receivedDate")
                );
                Order.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return Order;
    }
//   Phương thức để lấy OrderID thông qua PersonID

    public String getOrderIDPersonID(String personID) {
        String OrderID = null;
        String query = "SELECT OrderID FROM Person WHERE PersonID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(query);

            st.setString(1, personID);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                OrderID = rs.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OrderID;
    }

    public String getImgByPersonID(String personID) {
        String img = null;
        String query = "SELECT pi.image_url \n"
                + "FROM PersonImages pi \n"
                + "JOIN Person p ON pi.PersonID = p.PersonID \n"
                + "WHERE pi.PersonID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(query);

            st.setString(1, personID);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                img = rs.getString("image_url");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return img;
    }
//   Phương thức để selcet ra tổng các sản phẩm trong một đơn hàng thông qua OrderID và PersonID

    public List<MyOrder> getProductListByOrderID(String PersonID, String orderID) {
        List<MyOrder> productList = new ArrayList<>();
        String query = """
        SELECT o.OrderID, p.ProductID, p.ProductName, p.img, od.Quantity, od.UnitPrice, od.TotalCost
        FROM Orders o
        JOIN OrderDetails od ON o.OrderID = od.OrderID
        JOIN Products p ON od.ProductID = p.ProductID
        WHERE o.PersonID = ? AND o.OrderID = ?
    """;
        try {
            PreparedStatement st = connection.prepareStatement(query);

            st.setString(1, PersonID);
            st.setString(2, orderID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(rs.getString("OrderID"),
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("img"),
                        rs.getInt("Quantity"),
                        rs.getDouble("UnitPrice"),
                        rs.getDouble("TotalCost")
                );
                productList.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return productList;
    }
    
    public List<MyOrder> getProductListInfoByOrderID(String orderID) {
        List<MyOrder> productList = new ArrayList<>();
        String query = """
        SELECT o.OrderID, p.ProductID, p.ProductName, p.img, od.Quantity, od.UnitPrice, od.TotalCost
        FROM Orders o
        JOIN OrderDetails od ON o.OrderID = od.OrderID
        JOIN Products p ON od.ProductID = p.ProductID
        WHERE o.OrderID = ?
    """;
        try {
            PreparedStatement st = connection.prepareStatement(query);

            
            st.setString(1, orderID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(rs.getString("OrderID"),
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("img"),
                        rs.getInt("Quantity"),
                        rs.getDouble("UnitPrice"),
                        rs.getDouble("TotalCost")
                );
                productList.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return productList;
    }
    
    public List<MyOrder> getReceiver(String orderID) {
        List<MyOrder> receiver = new ArrayList<>();
        String query = """
                     select p.Name, pa.Address, pp.Phone
                     from Person p
                     Join PersonAddress pa on p.PersonID = pa.PersonID
                     join PersonPhone pp on p.PersonID = pp.PersonID
                     join Orders o on p.PersonID =  o.PersonID
                     where o.OrderID = ?
                     """;
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               MyOrder s = new MyOrder(rs.getString("Name"), 
                        rs.getString("Address"), 
                        rs.getString("Phone"));
                receiver.add(s);
                
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return receiver;
    }
     public void Received(SaleOrderL s) {
        String sql = "UPDATE Orders SET ShipStatus = 'received', receivedDate = GETDATE() WHERE OrderID = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, s.getOrderID());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating Order failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating feedback: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    

    public static void main(String[] args) {
        MyOrderDAO dao = new MyOrderDAO();
        
        String OrderID = "1";
        List<MyOrder> list = dao.getMyOrderInfo(OrderID);
        for (MyOrder o : list) {
            System.out.println(o);
        }
    }

}
