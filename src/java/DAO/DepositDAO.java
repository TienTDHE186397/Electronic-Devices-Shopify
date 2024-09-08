/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Deposit;
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
public class DepositDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void depositCreate(int id, int money) {
        String deleteCalendarQuery = "INSERT INTO Deposit (UserId, Money,[Status]) VALUES (?, ?, 0);";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(deleteCalendarQuery);
            ps.setInt(1, id);
            ps.setInt(2, money);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void depositAccept(int id) {
        String updateQuery = "UPDATE Deposit\n"
                + "SET \n"
                + "	[Status] = 1\n"
                + "WHERE \n"
                + "	[DeId] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(updateQuery);
            ps.setInt(1, id); // This is the deposit ID
            ps.executeUpdate(); // Use executeUpdate for update operations
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void depositUpdateMoney(int id, int money) {
        String updateQuery = "UPDATE Wallets\n"
                + "SET \n"
                + "	[Balance] = [Balance] + ?\n"
                + "WHERE\n"
                + "	[UserID] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(updateQuery);
            ps.setInt(1, money); // This is the amount to add
            ps.setInt(2, id); // This is the deposit ID

            ps.executeUpdate(); // Use executeUpdate for update operations
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void depositReject(int id) {
        String deleteCalendarQuery = "UPDATE Deposit\n"
                + "SET \n"
                + "	[Status] = 2\n"
                + "WHERE \n"
                + "	[DeId] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(deleteCalendarQuery);
            ps.setInt(1, id);

            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<Deposit> getAllDeposit() {
        List<Deposit> list = new ArrayList<>();
        String query = "SELECT d.DeId, d.UserId,a.UserName, d.[Money], d.[Status] FROM Deposit d\n"
                + "INNER JOIN Account a ON d.UserId = a.UserID";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Deposit(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
