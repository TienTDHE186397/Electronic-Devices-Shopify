/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.ImageVideo;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAOimgVideo extends DBContext {

    public List<ImageVideo> getImByProductID(int productID) {
        List<ImageVideo> listP = new ArrayList<>();

        String sql = "Select pim.image_id, pim.image_url, pim.alt_text\n"
                + "                from ProductImages pim \n"
                + "                LEFT JOIN Products p ON p.ProductID = pim.ProductID \n"
                + "                where p.ProductID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();

            // Sử dụng while để lấy tất cả các bản ghi
            while (rs.next()) {
                ImageVideo proImgVi = new ImageVideo(productID,
                        rs.getInt("image_id"),
                        rs.getString("image_url"),
                        rs.getString("alt_text"));
                listP.add(proImgVi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listP;
    }
     public List<ImageVideo> getVidByProductID(int productID) {
        List<ImageVideo> listP = new ArrayList<>();

        String sql = "Select pim.[video_id], pim.[video_url], pim.[alt_text]\n" +
"                              from ProductVideo pim \n" +
"                              LEFT JOIN Products p ON p.ProductID = pim.ProductID \n" +
"                              where p.ProductID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productID);
            ResultSet rs = st.executeQuery();

            // Sử dụng while để lấy tất cả các bản ghi
            while (rs.next()) {
                ImageVideo proImgVi = new ImageVideo(productID,
                        rs.getInt("video_id"),
                        rs.getString("video_url"),
                        rs.getString("alt_text"));
                listP.add(proImgVi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listP;
    }
    
     public boolean addVideo(int productId, String vid_url, String alt_text) {
       
        String sql = "INSERT INTO [ProductVideo] (ProductID, [video_url],[alt_text])\n"
                + " VALUES (?,?,?);";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, productId);
            st.setString(2, vid_url);
            st.setString(3, alt_text);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }
    public boolean addImage(int productId, String img_url, String alt_text) {
       
        String sql = "INSERT INTO [ProductImages] (ProductID, [image_url],[alt_text])\n"
                + " VALUES (?,?,?);";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, productId);
            st.setString(2, img_url);
            st.setString(3, alt_text);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }
    public boolean addImgViPerson(int personId, String img_video_url, String alt_text) {
       
        String sql = "INSERT INTO [PersonImages] (PersonID, [image_url],[alt_text])\n"
                + " VALUES (?,?,?);";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, personId);
            st.setString(2, img_video_url);
            st.setString(3, alt_text);
            return st.executeUpdate() > 0;// Trả về true nếu việc chèn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Xử lý ngoại lệ
        }
    }

    public static void main(String[] args) {
        DAOimgVideo d = new DAOimgVideo();
        List pa = d.getVidByProductID(3);
        for (Object ob : pa) {
            System.out.println(ob);
        }
       List pa2 = d.getImByProductID(3);
        for (Object ob : pa2) {
            System.out.println(ob);
        }
        
         
    }
}
