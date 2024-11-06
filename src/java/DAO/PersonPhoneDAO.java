/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.Person;
import java.sql.*;
import Entity.PersonPhone;
import java.time.LocalDate;

/**
 *
 * @author Dokkuhai
 */
public class PersonPhoneDAO extends DBContext{
    public PersonPhone getPhoneById(String id){
        String sql = "select Phone from PersonPhone where PersonID = "+id;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
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
                PersonPhone pp = new PersonPhone(p, rs.getString("Phone"), rs.getInt("IsPrimary"));
                return pp;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
