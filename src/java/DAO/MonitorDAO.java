/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;


import Entity.Monitor;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.*;







public class MonitorDAO extends DBContext {
    
    ProductListDAO pLDAO = new ProductListDAO();

    public List<Monitor> getAllMonitor() {

        List<Monitor> list = new ArrayList<>();

        String sql = "Select * from Monitor";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            
            /*
            
               private String monitorId;
    private String monitorImage;
    private String monitorName;
    private String monitorBranch;
    private double monitorPrice;
    private int monitorFpsRate;
    private int monitorResponseTime;
    private double monitorAspectRatio;
    private String monitorPortConnect;
    private String monitorPanelType;
    private String monitorSize;
    private String monitorWeight;
    private String monitorResolution;
    private String monitorFeature;
    private String monitorType;
    private Product product;
            
            */

            while (rs.next()) {

                Product product = pLDAO.getProductById(rs.getInt("ProductID"));

                Monitor monitor = new Monitor(
                        rs.getString("monitorId"),
                        rs.getString("monitorImage"),
                        rs.getString("monitorName"),
                        rs.getString("monitorBranch"),
                        rs.getInt("monitorPrice"),
                        rs.getInt("monitorFpsRate"),
                        rs.getInt("monitorResponseTime"),
                        rs.getString("monitorAspectRatio"),
                        rs.getString("monitorPortConnect"),
                        rs.getString("monitorPanelType"),
                        rs.getString("monitorSize"),
                        rs.getString("monitorWeight"),
                        rs.getString("monitorResolution"),
                        rs.getString("monitorFeature"),
                        rs.getString("monitorType"),
                        product);
               

                list.add(monitor);
            }

        } catch (Exception e) {
            
            
        }

        return list;
    }
    
    
     public static void main(String[] args) {

        MonitorDAO pl = new MonitorDAO();
        
        List<Monitor> ls = pl.getAllMonitor();

        for(Monitor c : ls) {
            System.out.println(c.getMonitorId());
        }

    }


    



}
