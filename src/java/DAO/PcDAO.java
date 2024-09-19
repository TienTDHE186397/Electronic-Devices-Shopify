/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;


import Entity.PC;
import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;







public class PcDAO extends DBContext {
    
        ProductListDAO pLDAO = new ProductListDAO();

    
     public List<PC> getAllMonitor() {

        List<PC> list = new ArrayList<>();

        String sql = "Select * from PC";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            
            /*
            private String pcId;
    private String pcImage;
    private String pcName;
    private String pcBranch;
    private int pcPrice;
    private String pcCPU;
    private String pcMemory;
    private String pcDiskMemory;
    private String pcVga;
    private String pcNetworkLan;
    private int pcPower;
    private String pcSize;
    private Double pcWeight;
    private String pcFrontPort;
    private String pcBackPort;
    private int pcGuarantee;
    private Product product;
            
            */

            while (rs.next()) {

                Product product = pLDAO.getProductById(rs.getInt("ProductID"));

                
                PC pc = new PC(
                        sql,
                        sql,
                        sql,
                        sql,
                        0, 
                        sql,
                        sql,
                        sql,
                        sql,
                        sql,
                        0, 
                        sql,
                        Double.NaN,
                        sql,
                        sql,
                        sql,
                        product);
               

                list.add(pc);
            }

        } catch (Exception e) {
            
            
        }

        return list;
    }



}
