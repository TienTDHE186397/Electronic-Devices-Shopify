/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Phone;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.*;

/*
 private String phoneID;
    private String phoneName;
    private int price;   
    private double screenSize;
    private String displayTech;
    private String rearCamera;
    private String frontCamera;
    private String chipSet;
    private int ramCapicity;
    private int internalMemory;
    private String battery;
    private String screenResolution;
    private Product product;
    private String img;
 */
public class PhoneDAO extends DBContext {

    ProductListDAO pLDAO = new ProductListDAO();

    public List<Phone> getAllPhone() {

        List<Phone> list = new ArrayList<>();

        String sql = "Select * from Phone";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Product product = pLDAO.getProductById(rs.getInt("ProductID"));

                Phone p = new Phone(
                        rs.getString("PhoneID"),
                        rs.getString("PhoneName"),
                        rs.getInt("Price"),
                        rs.getDouble("ScreenSize"),
                        rs.getString("DisplayTech"),
                        rs.getString("RearCamera"),
                        rs.getString("FrontCamera"),
                        rs.getString("Chipset"),
                        rs.getInt("RAMCapicity"),
                        rs.getInt("InternalMemory"),
                        rs.getString("Battery"),
                        rs.getString("OperatingSystem"),
                        rs.getString("ScreenResolution"),
                        product,
                        rs.getString("img"));

                list.add(p);
            }

        } catch (Exception e) {
        }

        return list;
    }

    public Phone getPhoneByProductId(int id) {
        String sql = "select * "
                + "from Phone where ProductID = ? ";

        try {

            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = pLDAO.getProductById(rs.getInt("ProductID"));

                Phone p = new Phone(
                        rs.getString("PhoneID"),
                        rs.getString("PhoneName"),
                        rs.getInt("Price"),
                        rs.getDouble("ScreenSize"),
                        rs.getString("DisplayTech"),
                        rs.getString("RearCamera"),
                        rs.getString("FrontCamera"),
                        rs.getString("Chipset"),
                        rs.getInt("RAMCapicity"),
                        rs.getInt("InternalMemory"),
                        rs.getString("Battery"),
                        rs.getString("OperatingSystem"),
                        rs.getString("ScreenResolution"),
                        product,
                        rs.getString("img"));

                return p;
            }

        } catch (Exception e) {

        }

        return null;

    }

    public static void main(String[] args) {

        PhoneDAO p = new PhoneDAO();

        List<Phone> listP = p.getAllPhone();

        for (Phone m : listP) {

            System.out.println(m.getImg());
        }
        
        System.out.println(p.getPhoneByProductId(1));

    }

}
