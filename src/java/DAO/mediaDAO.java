/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.media;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class mediaDAO extends DBContext {
    
    
    public List<media> getALl(String feedbackID) {
         List<media> imageList = new ArrayList<>();
         String sql = "SELECT * FROM FeedbackDetails Where FeedbackID = ?";

        try {
           PreparedStatement stmt = connection.prepareStatement(sql);
             if (feedbackID != null) {
                stmt.setString(1, feedbackID);
            }
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                media image = new media(
                    rs.getInt("FeedbackDetailID"),
                    rs.getInt("FeedbackID"),
                    rs.getString("StoredFileName"),
                    rs.getString("OriginalFileName"),
                    rs.getString("FilePath"),
                    rs.getString("FileType"),
                           rs.getString("ContentType")
                );
                imageList.add(image);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return imageList;
    }
    
    
      public static void main(String[] args) {
        mediaDAO dao = new mediaDAO();
        
        String OrderID = "33";
        List<media> list = dao.getALl("33");
        for (media o : list) {
            System.out.println(o);
        }
    }
}
