/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Laptop;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LaptopDAO extends DBContext {

    ProductListDAO pLDAO = new ProductListDAO();

    public List<Laptop> getAllLaptop() {

        List<Laptop> list = new ArrayList<>();

        String sql = "Select * from Laptop";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Product product = pLDAO.getProductById(rs.getInt("ProductID"));

             
                Laptop lap = new Laptop(
                        rs.getString("LaptopID"),
                        rs.getInt("price"),
                        rs.getString("LapName"),
                        rs.getString("genre"),
                        rs.getString("CPU"),
                        rs.getString("Ram"),
                        rs.getString("Graphic_Card"),
                        rs.getString("Hard_Drive"),
                        rs.getString("Monitor"),
                        rs.getString("LAN"),
                        rs.getString("WIFI"),
                        rs.getString("Bluetooth"),
                        rs.getString("Webcam"),
                        rs.getString("Operating_System"),
                        rs.getString("Pin"),
                        rs.getString("Lap_Weight"),
                        rs.getString("Lap_colour"),
                        rs.getString("Size"),
                        rs.getString("img"),
                        rs.getString("description"),
                        product);

                list.add(lap);
            }

        } catch (Exception e) {
        }

        return list;
    }

    public static void main(String[] args) {

            LaptopDAO l = new LaptopDAO();

        List<Laptop> listP = l.getAllLaptop();

        for (Laptop m : listP) {

            System.out.println(m.getLapColor());
        }

    }
    
}
