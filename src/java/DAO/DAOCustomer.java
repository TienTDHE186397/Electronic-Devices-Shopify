/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import Entity.PersonImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dokkuhai
 */
public class DAOCustomer extends DBContext {

    public List<Person> getAllCustomer() {
        List<Person> list = new ArrayList<>();
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + "FROM Person p\n"
                + "LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + "LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + "left join PersonImages pimg on p.PersonID = pimg.PersonID\n"
                + "WHERE p.RoleID = 1 and pp.IsPrimary = 1 and pa.IsPrimary =1 and pimg.IsPrimary = 1";
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

    public Person getPersonById(int id) {
        Person p = new Person();
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + "FROM Person p\n"
                + "LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + "LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + "left join PersonImages pimg on p.PersonID = pimg.PersonID\n"
                + "WHERE p.RoleID = 1 and p.PersonID = ? and pp.IsPrimary = 1 and pa.IsPrimary =1 and pimg.IsPrimary = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("startdate");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Check for null              
                p.setPersonID(rs.getInt("PersonID"));
                p.setName(rs.getString("Name"));
                p.setGender(rs.getString("Gender"));
                p.setDateOfBirth(rs.getString("DateOfBirth"));
                p.setStartDate(localDate);
                p.setAddress(rs.getString("Address"));
                p.setEmail(rs.getString("Email"));
                p.setPhone(rs.getString("Phone"));
                p.setRoleID(rs.getInt("RoleID"));
                p.setImage(rs.getString("Image"));
            }
        } catch (Exception e) {

        }
        return p;
    }

    public List<PersonImage> getPersonImageByPersonId(int personId) {
        List<PersonImage> listImage = new ArrayList<>();
        Person p = getPersonById(personId);
        String sql = "select * from PersonImages\n"
                + "where PersonID = ? and isPrimary = 0";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, personId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PersonImage image = new PersonImage();
                image.setImage_id(rs.getInt("image_id"));
                image.setPerson(p);
                image.setImage_url(rs.getString("image_url"));
                image.setAlt_text(rs.getString("alt_text"));
                listImage.add(image);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listImage;
    }
    
    public PersonImage getPersonImageByImageId(int Id) {
        String sql = "select * from PersonImages\n"
                + "where image_id = ?";
        PersonImage image = new PersonImage();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                image.setImage_id(rs.getInt("image_id"));
                image.setPerson(getPersonById(rs.getInt("PersonID")));
                image.setImage_url(rs.getString("image_url"));
                image.setAlt_text(rs.getString("alt_text"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }
//==============================================================================================================
    public boolean updateCustomer(int id, String name, String gender, Date dob, String email) {
        String sql = "UPDATE Person SET [Name] = ?, Gender = ?, DateOfBirth = ?, Email = ? WHERE PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setDate(3, dob);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePersonAddress(int id, String address) {
        String updateSql = "UPDATE PersonAddress SET IsPrimary = 0 WHERE PersonID = ? AND IsPrimary = 1";
        String insertSql = "INSERT INTO PersonAddress (PersonID, Address, IsPrimary) VALUES (?, ?, ?)";

        try {
            // Thực hiện câu lệnh UPDATE để đặt IsPrimary = 0 cho các địa chỉ hiện tại
            PreparedStatement psUpdate = connection.prepareStatement(updateSql);
            psUpdate.setInt(1, id);
            psUpdate.executeUpdate();

            // Thực hiện câu lệnh INSERT để thêm địa chỉ mới với IsPrimary = 1
            PreparedStatement psInsert = connection.prepareStatement(insertSql);
            psInsert.setInt(1, id);
            psInsert.setString(2, address);
            psInsert.setInt(3, 1);

            int rowsInserted = psInsert.executeUpdate();

            // Kiểm tra nếu thêm địa chỉ mới thành công
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePersonPhone(int id, String phone) {
        String updateSql = "UPDATE PersonPhone SET IsPrimary = 0 WHERE PersonID = ? AND IsPrimary = 1";
        String insertSql = "INSERT INTO PersonPhone (PersonID, Phone, IsPrimary) VALUES (?, ?, ?)";

        try {
            // Thực hiện câu lệnh UPDATE để đặt IsPrimary = 0 cho các địa chỉ hiện tại
            PreparedStatement psUpdate = connection.prepareStatement(updateSql);
            psUpdate.setInt(1, id);
            psUpdate.executeUpdate();

            // Thực hiện câu lệnh INSERT để thêm địa chỉ mới với IsPrimary = 1
            PreparedStatement psInsert = connection.prepareStatement(insertSql);
            psInsert.setInt(1, id);
            psInsert.setString(2, phone);
            psInsert.setInt(3, 1);

            int rowsInserted = psInsert.executeUpdate();

            // Kiểm tra nếu thêm số điện thoại mới thành công
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePersonImage(int id, int image_id) {
        String updateSql = "UPDATE PersonImages SET IsPrimary = 0 WHERE IsPrimary = 1";
        String insertSql = "UPDATE PersonImages SET IsPrimary = 1 WHERE PersonID = ? AND image_id = ?";

        try {
            // Thực hiện câu lệnh UPDATE để đặt IsPrimary = 0 cho các địa chỉ hiện tại
            PreparedStatement psUpdate = connection.prepareStatement(updateSql);
            psUpdate.executeUpdate();

            // Thực hiện câu lệnh INSERT để thêm địa chỉ mới với IsPrimary = 1
            PreparedStatement psInsert = connection.prepareStatement(insertSql);
            psInsert.setInt(1, id);
            psInsert.setInt(2, image_id);
            

            int rowsInserted = psInsert.executeUpdate();

            // Kiểm tra nếu thêm số điện thoại mới thành công
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean addImgPerson(int personId, String img_video_url, String alt_text) {

        String sql = "INSERT INTO [PersonImages] (PersonID, [image_url],[alt_text],[isPrimary])\n"
                + " VALUES (?,?,?,?);";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, personId);
            st.setString(2, img_video_url);
            st.setString(3, alt_text);
            st.setInt(4, 0);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }
    
    public boolean addVideoPerson(int personId, String video_url, String alt_text) {

        String sql = "INSERT INTO [PersonVideo] (PersonID, [Video_url],[alt_text])\n"
                + " VALUES (?,?,?,?);";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, personId);
            st.setString(2, video_url);
            st.setString(3, alt_text);
            st.setInt(4, 0);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }

    public static void main(String[] args) {
        DAOCustomer cusDAO = new DAOCustomer();
        Person p1 = cusDAO.getPersonById(1);
//        System.out.println(p1);
//        List<PersonImage> image = cusDAO.getPersonImageByPersonId(1);
//        for (PersonImage p: image) {
//            System.out.println(p);
//        }
        PersonImage images = cusDAO.getPersonImageByImageId(3);
        System.out.println(images);

////        
//        // Thông tin cần để cập nhật địa chỉ
//        int personId = 8;  // ID của ngư�?i muốn cập nhật địa chỉ
//        String newAddress = "456 New Street, New City";
//
//        // G�?i phương thức `updatePersonAddress` và kiểm tra kết quả
//        boolean isUpdated = cusDAO.updatePersonAddress(personId, newAddress);
//
//        // In kết quả
//        if (isUpdated) {
//            System.out.println("Địa chỉ đã được cập nhật thành công!");
//        } else {
//            System.out.println("Cập nhật địa chỉ thất bại.");
//        }
    }
}
