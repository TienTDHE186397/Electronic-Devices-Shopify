/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import Entity.Reader;
import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Duc Long
 */
public class PersonDAO extends DBContext {

    public List<Reader> getAllPerson() {
        List<Reader> listReader = new ArrayList<>();
        try {
            String sql = "select * from Person";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Reader r = new Reader();
                r.setPersonID(rs.getInt("PersonID"));
                r.setName(rs.getString("Name"));
                r.setGender(rs.getString("Gender"));
                r.setDateOfBirth(rs.getString("DateOfBirth"));
                r.setStartDate(rs.getString("StartDate"));
                r.setAddress(rs.getString("Address"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                listReader.add(r);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listReader;
    }

    public boolean addPerson(String name, String gender, String dateOfBirth, String startDate, String address, String email, String phone, int roleId, String password) {
        // Câu lệnh SQL để thêm dữ liệu vào bảng Person
        String sql = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Address, Email, Phone, RoleID, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, name);            // Tên người dùng
            st.setString(2, gender);          // Giới tính
            st.setString(3, dateOfBirth);     // Ngày sinh
            st.setString(4, startDate);       // Ngày bắt đầu (có thể là ngày hiện tại hoặc ngày cụ thể khi đăng ký)
            st.setString(5, address);         // Địa chỉ
            st.setString(6, email);           // Email
            st.setString(7, phone);           // Số điện thoại
            st.setInt(8, roleId);             // Vai trò người dùng
            st.setString(9, password);        // Mật khẩu (nên được mã hóa trước khi lưu vào cơ sở dữ liệu)

            return st.executeUpdate() > 0;    // Trả về true nếu thêm thành công, false nếu không
        } catch (Exception e) {
            e.printStackTrace();
            return false;                     // Trả về false nếu có lỗi xảy ra
        }
    }

    public Reader getPersonByUser(String user) {
        try {
            String sql = "select * from Person p\n"
                    + "join Users u on p.PersonID = u.PersonID\n"
                    + "where u.Username = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reader r = new Reader();
                r.setPersonID(rs.getInt("PersonID"));
                r.setName(rs.getString("Name"));
                r.setGender(rs.getString("Gender"));
                r.setDateOfBirth(rs.getString("DateOfBirth"));
                r.setStartDate(rs.getString("StartDate"));
                r.setAddress(rs.getString("Address"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                return r;
            }
            rs.close();
            st.close();
            return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Reader getPersonByCard(int cardid) {
        try {
            String sql = "  select * from Person p\n"
                    + "  join Card c on p.PersonID = c.PersonID\n"
                    + "  where c.CardID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cardid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reader r = new Reader();
                r.setPersonID(rs.getInt("PersonID"));
                r.setName(rs.getString("Name"));
                r.setGender(rs.getString("Gender"));
                r.setDateOfBirth(rs.getString("DateOfBirth"));
                r.setStartDate(rs.getString("StartDate"));
                r.setAddress(rs.getString("Address"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                return r;
            }
            rs.close();
            st.close();
            return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int getLastInsertedBorrowID() {
        String sql = "SELECT MAX(BorrowID) AS BorrowID FROM Borrow";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("BorrowID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Indicate failure
    }

    public boolean updatePerson(int pid, String name, String gender, String date, String startdate, String address, String email, String phone) {
        try {
            String sql = "update Person set Name = ?, Gender = ?, DateOfBirth = ?, StartDate = ?, Address = ?, Email = ?, Phone = ? where PersonID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, gender);
            st.setString(3, date);
            st.setString(4, startdate);
            st.setString(5, address);
            st.setString(6, email);
            st.setString(7, phone);
            st.setInt(8, pid);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean isEmailExists(String email) {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM Person WHERE Email = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    exists = (count > 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return exists;
    }

    public static void main(String[] args) {

    }

}
