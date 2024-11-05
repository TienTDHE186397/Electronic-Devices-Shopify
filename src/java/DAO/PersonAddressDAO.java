/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.*;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Dokkuhai
 */
public class PersonAddressDAO extends DBContext {

    public PersonAddress getAddressById(String id) {
        String sql = "select Address from PersonAddress where PersonID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PersonAddress pa = new PersonAddress();
                pa.setAddress(rs.getString("Address"));
                return pa;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        PersonAddressDAO pad = new PersonAddressDAO();
        PersonAddress pa = pad.getAddressById("2");
        System.out.println(pa);
    }
}
