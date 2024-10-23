/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Duc Long
 */
public class PersonDAO extends DBContext {

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

    public boolean updatePassword(String email, String newPassword) {
        try {
            String sql = "UPDATE [DBGR2].[dbo].[Person] SET [Password] = ? WHERE [Email] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPassword);
            st.setString(2, email);
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

    public Person login(String email, String password) {
        String query = "SELECT * FROM Person WHERE Email = ? AND Password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int personID = rs.getInt("PersonID");
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                String age = rs.getString("DateOfbirth");
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = sqlDate.toLocalDate();
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                int roleID = rs.getInt("RoleID");
                String passwordFromDB = rs.getString("Password");

                // Tạo đối tượng Person từ dữ liệu lấy được
                return new Person(personID , name, gender, age, localDate, address, email, phone, roleID, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Nếu không tìm thấy kết quả
    }

    public boolean addPerson(Person person) {
        // Đảm bảo giá trị roleID là hợp lệ
        boolean check = true;
        String sql = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Address, Email, Phone, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getGender());
            stmt.setObject(3, person.getDateOfBirth());
            stmt.setObject(4, person.getStartDate());
            stmt.setString(5, person.getAddress());
            stmt.setString(6, person.getEmail());
            stmt.setString(7, person.getPhone());
            stmt.setString(8, person.getPasword());
            stmt.setInt(9, person.getRoleID()); // Thêm vai trò vào câu lệnh SQL
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
             check = false;
        }
        return check;
    }



    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Giả định các thông tin đăng nhập (email và password)
        String email = "user";  // Bạn cần thay bằng email thực tế trong database
        String password = "234";   // Bạn cần thay bằng password thực tế

        // Thực hiện login
        Person person = personDAO.login(email, password);

        // Kiểm tra kết quả login
        if (person != null) {
            System.out.println("Login thành công!");
            System.out.println("Xin chào, " + person.getName());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Role ID: " + person.getRoleID());
        } else {
            System.out.println("Đăng nhập thất bại! Email hoặc mật khẩu không chính xác.");
        }
    }

}
