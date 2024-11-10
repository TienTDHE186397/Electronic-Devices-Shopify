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
            String sql = "UPDATE [dbo].[Person] SET [Password] = ? WHERE [Email] = ?";
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
        String query = "SELECT \n"
                + "    p.PersonID,\n"
                + "    p.Name,\n"
                + "    p.Gender,\n"
                + "    p.DateOfBirth,\n"
                + "    p.StartDate,\n" 
                + "    p.Email,\n"  
                + "    p.RoleID,\n"
                + "    p.Password,\n"
                + "    \n"
                + "    -- Retrieve primary address\n"
                + "    pa.Address AS PrimaryAddress,\n"
                + "    \n" 
                + "    -- Retrieve primary phone\n"
                + "    pp.Phone AS PrimaryPhone,\n"
                + "    -- Retrieve primary images\n"
                + "    pim.image_url As PrimaryImage\n"
                + "FROM \n"
                + "    Person p\n"
                + "LEFT JOIN \n"
                + "    PersonAddress pa ON p.PersonID = pa.PersonID AND pa.IsPrimary = 1\n"
                + "LEFT JOIN \n"
                + "    PersonPhone pp ON p.PersonID = pp.PersonID AND pp.IsPrimary = 1\n"
                + "LEFT JOIN \n"
                + "    PersonImages pim ON p.PersonID = pim.PersonID AND pim.IsPrimary = 1\n"
                + "WHERE \n"
                + "    p.Email = ?\n"
                + "    AND p.Password = ?";     
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
                int roleID = rs.getInt("RoleID");
                String passwordFromDB = rs.getString("Password");
                String address = rs.getString("PrimaryAddress");
                String phone = rs.getString("PrimaryPhone");
                String image = rs.getString("PrimaryImage");
                //int PersonID,String Name, String Gender, String DateOfBirth, LocalDate StartDate,
                //String Address, String Email, String Phone, int RoleID, String Password
                // Tạo đối tượng Person từ dữ liệu lấy được
                return new Person(personID, name, gender, age, localDate, address, email, phone, roleID, password,image);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Nếu không tìm thấy kết quả
    }

    public boolean addPerson(Person person) {
        // Đảm bảo giá trị roleID là hợp lệ
        boolean check = true;
        String sql = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Email, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getGender());
            stmt.setObject(3, person.getDateOfBirth());
            stmt.setObject(4, person.getStartDate());
            stmt.setString(6, person.getEmail());
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

    public int registerPerson(String name, String gender, String dateOfBirth, String email, String password, LocalDate startDate) {
        int personId = -1; // Default value if not successful
        try {
            // Ensure you have exactly 7 placeholders in your SQL statement
            String sql = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Email, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Setting the parameters correctly
            stmt.setString(1, name);         // 1st parameter: Name
            stmt.setString(2, gender);       // 2nd parameter: Gender
            stmt.setString(3, dateOfBirth);  // 3rd parameter: DateOfBirth
            stmt.setObject(4, startDate);    // 4th parameter: StartDate
            stmt.setString(5, email);        // 5th parameter: Email
            stmt.setString(6, password);     // 6th parameter: Password
            stmt.setInt(7, 1);               // 7th parameter: RoleID (assuming it's 1)

            // Execute the update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                // Get the generated PersonID
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        personId = rs.getInt(1); // Retrieve the generated ID
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
        }

        return personId; // Return PersonID
    }
    // Phương thức chèn địa chỉ

    public boolean insertAddress(int personId, String address, boolean isPrimary) {
        boolean check = true;
        try {
            String sql = "INSERT INTO PersonAddress (PersonID, Address, IsPrimary) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, personId);
            stmt.setString(2, address);
            stmt.setBoolean(3, isPrimary);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }
    // Phương thức chèn số điện thoại

    public boolean insertPhone(int personId, String phone, boolean isPrimary) {
        boolean check = true;
        try {
            String sql = "INSERT INTO PersonPhone (PersonID, Phone, IsPrimary) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, personId);
            stmt.setString(2, phone);
            stmt.setBoolean(3, isPrimary);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    // Phương thức chèn hình ảnh người dùng
    public boolean insertImage(int personId, String imageUrl, String altText) {
        boolean check = true;
        try {
            String sql = "INSERT INTO PersonImages (PersonID, image_url, alt_text) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, personId);
            pstmt.setString(2, imageUrl);
            pstmt.setString(3, altText);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    public boolean insertVideo(int personId, String videoUrl, String altText) {
        boolean check = true;
        try {
            String sql = "INSERT INTO PersonVideo (PersonID, Video_url, alt_text) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, personId);
            pstmt.setString(2, videoUrl);
            pstmt.setString(3, altText);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    public static void main(String[] args) {

        String name = "John Doe";
        String gender = "Male";
        String dateOfBirth = "1990-01-01"; // Make sure the format is correct
        String email = "aaaa";
        String password = "securePassword123";
        LocalDate startDate = LocalDate.now();

        PersonDAO personDAO = new PersonDAO();
        int newPersonId = personDAO.registerPerson(name, dateOfBirth, gender, email, password, startDate);

        if (newPersonId != -1) {
            System.out.println("New person registered with ID: " + newPersonId);
        } else {
            System.out.println("Failed to register new person.");
        }
        personDAO.insertAddress(newPersonId, "addressPErson", true);
        personDAO.insertPhone(newPersonId, "0123123", true);
        personDAO.insertImage(newPersonId, "image", "ImageText");
    }

}
