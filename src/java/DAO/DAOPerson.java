/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nghie
 */
public class DAOPerson extends DBContext {

    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM Person";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Check for null

                Person p = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate, // This can now be null if startdate is null
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("RoleID"),
                        rs.getString("Password")
                );

                list.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Person> getPerson() {
        List<Person> list = new ArrayList<>();
        String sql = "Select * from Person";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = sqlDate.toLocalDate();
                Person p = new Person(rs.getInt("PersonID"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate,
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("RoleID"),
                        rs.getString("Password"));

                list.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Person> searchPerson(String search, String role, String gender) {
        List<Person> list = new ArrayList<>();
        String sql = "Select * from Person where 1=1";
        if (search != null && !search.isEmpty()) {
            sql += "and (Name like N'%" + search + "%'" + "or Email like '%" + search + "%'" + "or Phone like '%" + search + "%')";
        }
        if (role != null && !role.isEmpty()) {
            sql += "and RoleID = " + role;
        }
        if (gender != null && !gender.isEmpty()) {
            sql += "and Gender like N'%" + gender + "%'";
        }
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Check for null
                Person p = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate,
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("RoleID"),
                        rs.getString("Password"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addPerson(Person person) {
        // Đảm bảo giá trị roleID là hợp lệ
        String sql = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Address, Email, Phone, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getGender());
            stmt.setString(3, person.getDateOfBirth());
            stmt.setObject(4, (LocalDate) person.getStartDate());
            stmt.setString(5, person.getAddress());
            stmt.setString(6, person.getEmail());
            stmt.setString(7, person.getPhone());
            stmt.setString(8, person.getPasword());
            stmt.setInt(9, person.getRoleID()); // Thêm vai trò vào câu lệnh SQL
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateUser(String name, String gender, String address, String email, String phone, String roleid, String password, String id) {
        String sql = "UPDATE [dbo].[Person]\n"
                + "   SET [Name] = ?"
                + "      ,[Gender] = ?"
                + "      ,[Address] = ?"
                + "      ,[Email] = ?"
                + "      ,[Phone] = ?"
                + "      ,[RoleID] = ?"
                + "      ,[Password] = ?"
                + " WHERE PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, roleid);
            ps.setString(7, password);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(String name, String phone, String password, String id) {
        String sql = "UPDATE [dbo].[Person]\n"
                + "   SET [Name] = ?"
                + "      ,[Phone] = ?"
                + "      ,[Password] = ?"
                + " WHERE PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, password);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getPersonById(String id) {
        String sql = "select * from Person where PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                Person p = new Person(rs.getInt("PersonID"),
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

    public List<String> getDistinctGender() {

        List<String> list = new ArrayList<>();

        String sql = "select distinct Gender \n"
                + "	from Person";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                String gender = rs.getString("Gender");

                list.add(gender);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void editPassById(String id, String pass) {
        String sql = "UPDATE Person "
                + "set Password = ? "
                + "where PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        DAOPerson pd = new DAOPerson();
        //List<Person> lp = pd.getPersonByRole("1");
        //System.out.println(lp.get(0));
//        int n = pd.addPerson(new Person(6, "Duc", "Name", "2004-11-03", "2024-09-17", "Ha Noi", "duqweqwecdsfsdf@gmail.com", "0985407026", 5, "123"));
//        if(n>0){
//            System.out.println("inserted");
//        }

        //pd.addPerson(new Person(6         "Duc", "Name", "2004-11-03", "2024-09-17", "Ha Noi", "duqweqwecdsfsdf@gmail.com", "0985407026", 5, "123"));
        pd.updateUser("duc", "Nam", "Ha noi", "qwer@gmail.com", "0113458752", "2", "1234", "1");

    }

}
