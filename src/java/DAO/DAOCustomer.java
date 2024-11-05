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
                + "WHERE p.RoleID = 1";
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
    
    public Person getPersonById(int id){
        Person p = new Person();
        String sql = "select p.PersonID,pimg.image_url Image, p.Name, p.Gender, p.DateOfBirth, p.StartDate, coalesce(pa.Address,'không có thông tin') Address, p.Email,coalesce(pp.Phone,'không có thông tin') Phone, p.RoleID, p.Password\n"
                + "FROM Person p\n"
                + "LEFT JOIN PersonAddress pa ON p.PersonID = pa.PersonID\n"
                + "LEFT JOIN PersonPhone pp ON p.PersonID = pp.PersonID\n"
                + "left join PersonImages pimg on p.PersonID = pimg.PersonID\n"
                + "WHERE p.RoleID = 1 AND p.PersonID = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
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
            }
        }catch(Exception e){
            
        }
        return p;
    }
    
    public List<PersonImage> getPersonImageByPersonId(int personId){
        List<PersonImage> listImage = new ArrayList<>();
        String sql = "";
        return listImage;
    }

    public static void main(String[] args) {
        DAOCustomer cusDAO = new DAOCustomer();
        List<Person> list = cusDAO.getAllCustomer();
        for (Person p : list) {
            System.out.println(p);
        }
//        Person p1 = cusDAO.getPersonById(8);
//        System.out.println(p1);
    }
}
