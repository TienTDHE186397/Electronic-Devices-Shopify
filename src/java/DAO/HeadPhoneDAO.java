/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;


import Entity.HeadPhone;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.*;








public class HeadPhoneDAO extends DBContext {

    
     ProductListDAO pLDAO = new ProductListDAO();

    public List<HeadPhone> getAllHeadPhone() {

        List<HeadPhone> list = new ArrayList<>();

        String sql = "Select * from HeadPhones";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Product product = pLDAO.getProductById(rs.getInt("ProductID"));
                
                HeadPhone headphone = new HeadPhone
        (rs.getString("Headphoneid"),
                rs.getString("HeadphoneName"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getString("Features"),
                rs.getString("connection"),
                rs.getString("battery_life"),
                rs.getString("noise_cancel"),
                rs.getInt("price"),
                rs.getString("img"),
                rs.getString("description"),
                product);
             

                list.add(headphone);
            }

        } catch (Exception e) {
        }

        return list;
    }
    
    
     public static void main(String[] args) {

         HeadPhoneDAO l = new  HeadPhoneDAO();

        List<HeadPhone> listP = l.getAllHeadPhone();

        for (HeadPhone m : listP) {

            System.out.println(m.getHeadPhoneId());
        }

    }
    
    



}
