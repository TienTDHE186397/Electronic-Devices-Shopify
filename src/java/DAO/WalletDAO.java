/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class WalletDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void onlinePayment(int id, int money) {
        String updateQuery = "UPDATE Wallets\n"
                + "SET \n"
                + "	[Balance] = [Balance] - ?\n"
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
}
