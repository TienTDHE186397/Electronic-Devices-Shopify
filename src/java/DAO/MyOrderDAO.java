/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Cart;
import Entity.CartItem;
import Entity.Feedback;
import Entity.MyOrder;
import Entity.OrderInformation;
import Entity.Person;
import Entity.SaleOrderL;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class MyOrderDAO extends DBContext {
//    phương thức để select ra tất cả đơn hàng dựa vào ID của người dùng

    public List<MyOrder> getOrderByPersonID(String PersonID) {
        List<MyOrder> Order = new ArrayList<>();
        String sql = "SELECT \n"
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
                + "WHERE \n"
                + "    o.PersonID = ?\n"
                + "Order by o.OrderID DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, PersonID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(
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
              
                + "WHERE \n"
                + "   o.OrderID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, OrderID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MyOrder s = new MyOrder(
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
        String query = """
                       SELECT pi.image_url 
                        FROM PersonImages pi 
                       JOIN Person p ON pi.PersonID = p.PersonID 
                       WHERE pi.PersonID = ? and IsPrimary = 1
                       """;

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
                     SELECT p.Name, pa.Address, pp.Phone, p.PersonID
                     FROM Person p
                     JOIN PersonAddress pa ON p.PersonID = pa.PersonID AND pa.IsPrimary = 1
                     JOIN PersonPhone pp ON p.PersonID = pp.PersonID and pp.IsPrimary = 1
                     JOIN Orders o ON p.PersonID = o.PersonID
                     WHERE o.OrderID = ?;
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
//        String OrderID = "1";
//        List<MyOrder> list = dao.getMyOrderInfo(OrderID);
//        for (MyOrder o : list) {
//            System.out.println(o);
//        }
        OrderInformation oi = dao.getOrderInfo(1);
        System.out.println(oi);
//        dao.createUpdateOrderDetailsProcedure();
//        dao.updateOrderDetails(1, "Nguyen Van Nam", "Ha Noi", "013456789", "Chuyen khoan", "Complete");
    }

    public int addOrder(MyOrder order, Cart cart) {
        String sqlOrder = "INSERT INTO Orders (OrderDate, PersonID, ShowRoomID, TotalMoney, Method, SaleID, Status, SaleNote, ShipStatus) \"\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlOrderDetail = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice, TotalCost) VALUES (?, ?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            double totalMoney = 0;
            for (CartItem item : cart.getItems()) {
                totalMoney += item.getPrice() * item.getQuantity();
            }

            PreparedStatement psOrder = connection.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setDate(1, java.sql.Date.valueOf(LocalDate.now()));  // Use today's date
            psOrder.setString(2, order.getPersonID()); // PersonID from session
            psOrder.setString(3, order.getShowroomID()); // ShowRoomID
            psOrder.setDouble(4, totalMoney); // TotalMoney
            psOrder.setString(5, order.getMethod()); // Payment method
            psOrder.setString(6, order.getSaleID()); // SaleID
            psOrder.setString(7, order.getStatus()); // Status
            psOrder.setString(8, "Must be complete fast"); // Sale Note
            psOrder.setString(9, "OrderNotComplete"); // ShipStatus
            psOrder.executeUpdate();

            ResultSet rs = psOrder.getGeneratedKeys();
            int newOrderID = 0;
            if (rs.next()) {
                newOrderID = rs.getInt(1); // Retrieve the new OrderID
            }
            PreparedStatement psOrderDetail = connection.prepareStatement(sqlOrderDetail);
            for (CartItem item : cart.getItems()) {
                psOrderDetail.setInt(1, newOrderID);  // Set the new OrderID
                psOrderDetail.setInt(2, item.getProduct().getProductID());  // ProductID
                psOrderDetail.setInt(3, item.getQuantity());  // Quantity
                psOrderDetail.setDouble(4, item.getPrice());  // UnitPrice
                psOrderDetail.setDouble(5, item.getPrice() * item.getQuantity());  // TotalCost
                psOrderDetail.addBatch();  // Add batch for bulk insert
            }
            psOrderDetail.executeBatch();

            connection.commit();

            return newOrderID;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void createUpdateOrderDetailsProcedure() {
        //drop procedure if exist
        String dropSql = "IF OBJECT_ID('UpdateOrderDetails', 'P') IS NOT NULL "
                + "DROP PROCEDURE UpdateOrderDetails";
        String sql = "CREATE PROCEDURE UpdateOrderDetails\n"
                + "    @PersonID INT,\n"
                + "    @NewName NVARCHAR(255),\n"
                + "    @NewAddress NVARCHAR(255),\n"
                + "    @NewPhone NVARCHAR(50),\n"
                + "    @NewMethod NVARCHAR(50),\n"
                + "    @NewStatus NVARCHAR(50)\n"
                + "AS\n"
                + "BEGIN\n"
                + "    -- Start a transaction to ensure atomicity\n"
                + "    BEGIN TRANSACTION;\n"
                + "\n"
                + "    BEGIN TRY\n"
                + "        -- Update the name in the Person table\n"
                + "        UPDATE Person\n"
                + "        SET Name = @NewName\n"
                + "        WHERE PersonID = @PersonID;\n"
                + "\n"
                + "        -- Update the address in the PersonAddress table\n"
                + "        -- Assuming we only want to update the primary address\n"
                + "        UPDATE PersonAddress\n"
                + "        SET Address = @NewAddress\n"
                + "        WHERE PersonID = @PersonID\n"
                + "          AND IsPrimary = 1;\n"
                + "\n"
                + "        -- Update the phone number in the PersonPhone table\n"
                + "        -- Assuming we only want to update the primary phone\n"
                + "        UPDATE PersonPhone\n"
                + "        SET Phone = @NewPhone\n"
                + "        WHERE PersonID = @PersonID\n"
                + "          AND IsPrimary = 1;\n"
                + "\n"
                + "        -- Update the payment method and status in the Orders table\n"
                + "        -- Assuming you want to update all orders associated with this person\n"
                + "        UPDATE Orders\n"
                + "        SET Method = @NewMethod,\n"
                + "            Status = @NewStatus\n"
                + "        WHERE PersonID = @PersonID;\n"
                + "\n"
                + "        -- Commit the transaction if all updates succeed\n"
                + "        COMMIT TRANSACTION;\n"
                + "    END TRY\n"
                + "    BEGIN CATCH\n"
                + "        -- Rollback transaction if any error occurs\n"
                + "        ROLLBACK TRANSACTION;\n"
                + "\n"
                + "       \n"
                + "    END CATCH\n"
                + "END;";
        try {
            Statement s = connection.createStatement();
            s.execute(dropSql);
            System.out.println("procedure dropped");
            s.execute(sql);
            System.out.println("procedure created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrderDetails(int personID, String name, String address, String phone, String method, String status) {
        String sql = "{CALL UpdateOrderDetails(?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, personID);
            cs.setString(2, name);
            cs.setString(3, address);
            cs.setString(4, phone);
            cs.setString(5, method);
            cs.setString(6, status);
            cs.execute();
            System.out.println("Execute successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OrderInformation getOrderInfo(int id) {
        String sql = "  select o.OrderID, p.Name, p.Email, pp.Phone, pa.Address, o.Method, o.Status\n"
                + "  from Person p\n"
                + "  join Orders o on p.PersonID = o.PersonID\n"
                + "  join PersonAddress pa on p.PersonID = pa.PersonID\n"
                + "  join PersonPhone pp on p.PersonID = pp.PersonID\n"
                + " \n"
                + "  where  pa.IsPrimary = pp.IsPrimary and pp.IsPrimary = 1 and p.PersonID = " + id;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                OrderInformation oi = new OrderInformation(rs.getInt("OrderID"),
                        rs.getString("Name"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("Method"),
                        rs.getString("Status"));
                return oi;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean addOrder(int personID, int showroom, double totalMoney, String method, String status, String saleNote, String ShipStatus) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([PersonID]\n"
                + "           ,[ShowRoomID]\n"
                + "           ,[TotalMoney]\n"
                + "           ,[Method]\n"
                + "           ,[Status]\n"
                + "           ,[SaleNote]\n"
                + "           ,[ShipStatus]) \n"
                + "     VALUES \n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, personID);
            ps.setInt(2, showroom);
            ps.setDouble(3, totalMoney);
            ps.setString(4, method);
            ps.setString(5, status);
            ps.setString(6, saleNote);
            ps.setString(7, ShipStatus);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addOrderDetail(int OrderID, int productID, int giftID, int quantity, double price, double total) {
        String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[GiftID]\n"
                + "           ,[Quantity]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[TotalCost])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, OrderID);
            ps.setInt(2, productID);
            ps.setInt(3, giftID);
            ps.setInt(4, quantity);
            ps.setDouble(5, price);
            ps.setDouble(6, total);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
