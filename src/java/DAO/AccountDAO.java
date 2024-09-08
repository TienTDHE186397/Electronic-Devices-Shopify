package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import Entity.Account;
import Entity.Product;
import Entity.Wallet;
import context.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author dutpr
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "select * from Account where UserName = ? and [Password] = ?";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from Account where UserName = ?";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void SignUp(String user, String pass) {
        String query = "insert into Account values(?,?,20,0,0)";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public List<Account> getAccountById(String id) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public Wallet getWalletByAid(int aid) {
        String query = "SELECT * FROM Wallets WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); // mở kết nối với sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Wallet(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void editAccount(String id, String user, String pass, int roleId, String isSell) {
        String query = "UPDATE Account\n"
                + "SET \n"
                + "	[UserName] = ?,\n"
                + "	[Password] = ?,\n"
                + "	[RoleID] = ?,\n"
                + "	[isSell] = ?\n"
                + "WHERE \n"
                + "	[UserID] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, roleId);
            ps.setString(4, isSell);
            ps.setString(5, id);
            ps.executeUpdate();

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

    public void deleteAccount(String aid) {
        String deleteCalendarQuery = "DELETE FROM Account WHERE UserID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(deleteCalendarQuery);
            ps.setString(1, aid);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Account a = dao.login("user3", "123");
        if (a != null) {
            System.out.println(a.getID());
        } else {
            System.out.println("Wallet not found.");
        }
    }
}
