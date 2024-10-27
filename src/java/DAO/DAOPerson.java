/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import java.sql.Statement;
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
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Check for null

                Person p = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("Image"),
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
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = sqlDate.toLocalDate();
                Person p = new Person(rs.getInt("PersonID"),
                        rs.getString("Image"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate, // This can now be null if startdate is null
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
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID"
                + " where 1=1 ";
        if (search != null && !search.isEmpty()) {
            sql += "and (p.Name like N'%" + search + "%'" + " or p.Email like N'%" + search + "%'" + " or pp.Phone like N'%" + search + "%')";
        }
        if (role != null && !role.isEmpty()) {
            sql += "and p.RoleID = " + role;
        }
        if (gender != null && !gender.isEmpty()) {
            sql += "and p.Gender like N'%" + gender + "%'";
        }
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Check for null
                Person p = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("Image"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate, // This can now be null if startdate is null
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
        // SQL cho các bảng Person, PersonAddress và PersonPhone
        String sqlPerson = "INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Email, Password, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlPersonAddress = "INSERT INTO PersonAddress (PersonID, Address, IsPrimary) VALUES (?, ?, ?)";
        String sqlPersonPhone = "INSERT INTO PersonPhone (PersonID, Phone, IsPrimary) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // 1. Chèn vào bảng Person
            PreparedStatement stmtPerson = connection.prepareStatement(sqlPerson, Statement.RETURN_GENERATED_KEYS);
            stmtPerson.setString(1, person.getName());
            stmtPerson.setString(2, person.getGender());
            stmtPerson.setString(3, person.getDateOfBirth());  // Giả sử định dạng đúng kiểu
            stmtPerson.setObject(4, person.getStartDate());
            stmtPerson.setString(5, person.getEmail());
            stmtPerson.setString(6, person.getPasword());
            stmtPerson.setInt(7, person.getRoleID());

            int rowsAffectedPerson = stmtPerson.executeUpdate();

            if (rowsAffectedPerson == 0) {
                throw new SQLException("Failed to insert into Person table");
            }

            // Lấy PersonID vừa được tạo
            ResultSet generatedKeys = stmtPerson.getGeneratedKeys();
            int personID = 0;
            if (generatedKeys.next()) {
                personID = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve PersonID");
            }

            // 2. Chèn vào bảng PersonAddress
            PreparedStatement stmtAddress = connection.prepareStatement(sqlPersonAddress);
            stmtAddress.setInt(1, personID);  // Sử dụng PersonID đã lấy
            stmtAddress.setString(2, person.getAddress());
            stmtAddress.setBoolean(3, true);  // IsPrimary là true (giả sử luôn là địa chỉ chính)

            int rowsAffectedAddress = stmtAddress.executeUpdate();
            if (rowsAffectedAddress == 0) {
                throw new SQLException("Failed to insert into PersonAddress table");
            }

            // 3. Chèn vào bảng PersonPhone
            PreparedStatement stmtPhone = connection.prepareStatement(sqlPersonPhone);
            stmtPhone.setInt(1, personID);  // Sử dụng PersonID đã lấy
            stmtPhone.setString(2, person.getPhone());
            stmtPhone.setBoolean(3, true);  // IsPrimary là true (giả sử luôn là số điện thoại chính)

            int rowsAffectedPhone = stmtPhone.executeUpdate();
            if (rowsAffectedPhone == 0) {
                throw new SQLException("Failed to insert into PersonPhone table");
            }

            // Commit nếu mọi thứ thành công
            connection.commit();
            return true;

        } catch (SQLException e) {
            // Rollback lại nếu có lỗi
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            // Đặt lại chế độ tự động commit
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateUser(String name, String gender, String email, String roleid, String password, String id) {
        String sql = "UPDATE [dbo].[Person]\n"
                + "   SET [Name] = ?"
                + "      ,[Gender] = ?"
                + "      ,[Email] = ?"
                + "      ,[RoleID] = ?"
                + "      ,[Password] = ?"
                + " WHERE PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, roleid);
            ps.setString(5, password);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(String name, String phone, String password, String id) {
        String sql = "UPDATE [dbo].[Person]\n"
                + "   SET [Name] = ?"
                + "      ,[Password] = ?"
                + " WHERE PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(2, password);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(String id) {
        String sql = "DELETE FROM [dbo].[Person] \n"
                + "      WHERE PersonID = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person getPersonById(String id) {
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID where p.PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                Person p = new Person(rs.getInt("PersonID"),
                        rs.getString("Image"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        localDate, // This can now be null if startdate is null
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
        pd.updateUser("duc", "Nam", "qwer@gmail.com", "2", "1234", "1");

    }

    public int getTotalPerson() {
        int n = 0;
        String sql = "select count(*) \n"
                + "from Person";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Person> pagingPerson(int index) {
        List<Person> list = new ArrayList<>();
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + " FROM Person p\n"
                + " LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + " LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + " left join PersonImages pimg on p.PersonID = pimg.PersonID \n"
                + "order by ID \n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt("PersonID"),
                        rs.getString("Image"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getString("DateOfBirth"),
                        LocalDate.MAX, // This can now be null if startdate is null
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("RoleID"),
                        rs.getString("Password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
