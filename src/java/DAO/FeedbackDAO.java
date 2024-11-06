/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import Entity.Person;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author admin
 */
public class FeedbackDAO extends DBContext {

    public List<Feedback> getFeedbackList(String status, int rating) {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT F.FeedbackID, P.ProductName, Pe.Name AS CustomerName, F.RatedStar, F.CreatedDate, F.Status FROM Feedback F JOIN Person Pe ON F.CustomerID = Pe.PersonID JOIN Products P ON F.ProductID = P.ProductID WHERE 1=1";

        // Append filters if they are provided
        if (status != null && !status.isEmpty()) {
            sql += " AND F.Status = ?";
        }
        if (rating > 0) {
            sql += " AND F.RatedStar = ?";
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

    public List<Feedback> getDetails(String feedbackID) {
        List<Feedback> detail = new ArrayList<>();
        String sql = "SELECT \n"
                + "    f.FeedbackID,\n"
                + "    p.Name AS CustomerName,\n"
                + "    p.Email,\n"
                + "    pp.Phone AS PhoneNumber,\n"
                + "    pa.Address AS CustomerAddress,\n"
                + "    pr.ProductName,\n"
                + "    f.RatedStar AS RateStar,\n"
                + "    f.FeedbackContent,\n"
                + "    s.Name As ProcessedByMkt,\n"
                + "    f.ProcessedBy,\n"
                + "    f.Status\n"
                + "FROM \n"
                + "    Feedback f\n"
                + "JOIN \n"
                + "    Person p ON f.CustomerID = p.PersonID\n"
                + "LEFT JOIN\n"
                + "    PersonPhone pp ON p.PersonID = pp.PersonID AND pp.IsPrimary = 1\n"
                + "LEFT JOIN\n"
                + "    PersonAddress pa ON p.PersonID = pa.PersonID AND pa.IsPrimary = 1\n"
                + "JOIN \n"
                + "    Products pr ON f.ProductID = pr.ProductID\n"
                + "LEFT JOIN \n"
                + "    Person s ON f.ProcessedBy = s.PersonID\n"
                + "WHERE\n"
                + "    FeedbackID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, feedbackID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback s = new Feedback(rs.getString("FeedbackID"),
                        rs.getString("CustomerName"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber"),
                        rs.getString("ProductName"),
                        rs.getInt("RateStar"),
                        rs.getString("FeedbackContent"),
                        rs.getString("ProcessedByMkt"),
                        rs.getString("ProcessedBy"),
                        rs.getString("Status"));
                detail.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return detail;
    }

    public List<Person> getAllMkt() {
        List<Person> mktPersons = new ArrayList<>();
        String sql = "SELECT PersonID, Name, RoleID \n"
                + "FROM Person \n"
                + "WHERE RoleID = 2";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getInt("PersonID"), rs.getString("Name"), rs.getInt("RoleID"));
                mktPersons.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return mktPersons;
    }

    public void Update(Feedback s) {
        String sql = "UPDATE Feedback SET Status = ?, ProcessedBy = ?, ProcessedDate = GETDATE() WHERE FeedbackID = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, s.getStatus());
            st.setString(2, s.getMktEmp());
            st.setString(3, s.getFeedbackID());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating feedback failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating feedback: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public int createFeedback(Feedback feedback) throws SQLException {
    String insertSql = "INSERT INTO Feedback (CustomerID, ProductID, RatedStar, " +
                       "FeedbackContent, Status, CreatedDate) " +
                       "VALUES (?, ?, ?, ?, 'New', GETDATE())";
                       
    try (PreparedStatement insertStmt = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
        insertStmt.setString(1, feedback.getCusID());
        insertStmt.setString(2, feedback.getProID());
        insertStmt.setInt(3, feedback.getRate());
        insertStmt.setString(4, feedback.getFeedContent());
        
        int rowsInserted = insertStmt.executeUpdate();
        if (rowsInserted == 0) {
            throw new SQLException("Creating feedback failed, no rows affected.");
        }
        
        try (ResultSet rs = insertStmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
    }
    return -1;
}

public void saveFeedbackDetails(int feedbackId, String storedFileName,
                                String originalFileName, String filePath,
                                String fileType) throws SQLException {
    String contentType; 
    if (storedFileName.toLowerCase().endsWith(".mp4")) { 
        contentType = "video/mp4";
    } else if (storedFileName.toLowerCase().endsWith(".webm")) { 
        contentType = "video/webm";
     } else if (storedFileName.toLowerCase().endsWith(".jpg") || storedFileName.toLowerCase().endsWith(".jpeg")) { 
         contentType = "image/jpeg";
     } else if (storedFileName.toLowerCase().endsWith(".png")) { 
         contentType = "image/png";
     } else { 
         contentType = "application/octet-stream";// Giá trị mặc định nếu không xác định được loại tệp 
     }
    String sql = "INSERT INTO FeedbackDetails (FeedbackID, StoredFileName, " +
                 "OriginalFileName, FilePath, FileType, ContentType ) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, feedbackId);
        stmt.setString(2, storedFileName);
        stmt.setString(3, originalFileName);
        stmt.setString(4, filePath);
        stmt.setString(5, fileType);
        stmt.setString(6, contentType);
        stmt.executeUpdate();
    }
}


    public static void main(String[] args) {
        Connection connection = null;
        String feedbackID = "1";
        // Create an instance of the class containing getFeedbackList and pass the connection
        FeedbackDAO feedbackDAO = new FeedbackDAO();

        // Call the getFeedbackList method
        List<Feedback> feedbackList = feedbackDAO.getDetails(feedbackID);

        // Print the feedback list
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }

    }
}
