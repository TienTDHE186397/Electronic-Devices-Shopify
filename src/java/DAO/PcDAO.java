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

    
     public List<PC> getAllPC() {

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
                        rs.getString("pcId"),
                        rs.getString("pcImage"),
                        rs.getString("pcName"),
                        rs.getString("pcBranch"),
                        rs.getInt("pcPrice"), 
                        rs.getString("pcCPU"),
                        rs.getString("pcMemory"),
                        rs.getString("pcDiskMemory"),
                        rs.getString("pcVga"),
                        rs.getString("pcNetworkLan"),
                        rs.getInt("pcPower"), 
                        rs.getString("pcSize"),
                        rs.getDouble("pcWeight"),
                        rs.getString("pcFrontPort"),
                        rs.getString("pcBackPort"),
                        rs.getInt("pcGuarantee"),
                        product);
               

                list.add(pc);
            }

        } catch (Exception e) {
            
            
        }

        return list;
    }
     
     
       public static void main(String[] args) {

           PcDAO pl = new PcDAO();
           
        List<PC> ls = pl.getAllPC();

        for(PC c : ls) {
            System.out.println(c.getPcId());
        }

    }



}
