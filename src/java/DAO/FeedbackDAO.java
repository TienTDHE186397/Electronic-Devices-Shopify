/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class FeedbackDAO extends DBContext {

    public List<Feedback> getFeedbackList(String status, int rating) {
    List<Feedback> feedbackList = new ArrayList<>();
    String sql = "SELECT F.FeedbackID, P.ProductName, Pe.Name AS CustomerName, F.RatedStar, F.CreatedDate, F.Status FROM Feedback F JOIN Person Pe ON F.PersonID = Pe.PersonID JOIN Products P ON F.ProductID = P.ProductID WHERE 1=1";

    // Append filters if they are provided
    if (status != null && !status.isEmpty()) {
        sql+=" AND F.Status = ?";
    }
    if (rating > 0) {
        sql+=" AND F.RatedStar = ?";
    }

    try {
        PreparedStatement st = connection.prepareStatement(sql);

        int paramIndex = 1;
        if (status != null && !status.isEmpty()) {
            st.setString(paramIndex++, status);
        }
        if (rating > 0) {
            st.setInt(paramIndex++, rating);
        }

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Feedback feedback = new Feedback(rs.getString("FeedbackID"), rs.getString("ProductName"), rs.getString("CustomerName"), rs.getInt("RatedStar"), rs.getDate("CreatedDate"), rs.getString("Status"));
            feedbackList.add(feedback);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return feedbackList;
}
    

//    public static void main(String[] args) {
//        Connection connection = null;
//
//        // Create an instance of the class containing getFeedbackList and pass the connection
//        FeedbackDAO feedbackDAO = new FeedbackDAO();
//
//        // Call the getFeedbackList method
//        List<Feedback> feedbackList = feedbackDAO.getFeedbackList();
//
//        // Print the feedback list
//        for (Feedback feedback : feedbackList) {
//            System.out.println(feedback);
//        }
//
//    }
}
