/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import Entity.Person;
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
                + "    f.FeedbackReply,\n"
                + "    s.Name As ProcessedByMkt,\n"
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
                        rs.getString("FeedbackReply"),
                        rs.getString("ProcessedByMkt"),
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
        String sql = "UPDATE Feedback SET FeedbackReply = ?, Status = ?, ProcessedBy = ? WHERE FeedbackID = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, s.getFeedReply());
            st.setString(2, s.getStatus());
            st.setString(3, s.getMktEmp());
            st.setString(4, s.getFeedbackID());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Updating feedback failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating feedback: " + e.getMessage());
            e.printStackTrace();
        }
    }
     public String createFeedback(Feedback feedback) throws SQLException {
    String sql = """
        INSERT INTO Feedback (CustomerID, ProductID, RatedStar, FeedbackContent, 
                            Status, CreatedDate)
        VALUES (?, ?, ?, ?, 'New', GETDATE())
    """;

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        // Check if CustomerID is present, if not set it to null
        if (feedback.getCusID() != null && !feedback.getCusID().isEmpty()) {
            stmt.setString(1, feedback.getCusID());  // CustomerID as String
        } else {
            stmt.setNull(1, java.sql.Types.VARCHAR); // Set null for VARCHAR
        }

        stmt.setString(2, feedback.getProID());   // ProductID as String
        stmt.setInt(3, feedback.getRate());       // RatedStar as int
        stmt.setString(4, feedback.getFeedContent()); // FeedbackContent as String

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getString(1); // Return the generated FeedbackID as String
        }
    }
    return null;  // Return null if insertion failed
}

      public void saveFeedbackDetail(Feedback detail) throws SQLException {
        String sql = """
            INSERT INTO FeedbackDetails (FeedbackID, StoredFileName, OriginalFileName, 
                                       FilePath, FileType)
            VALUES (?, ?, ?, ?, ?)
        """;
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, detail.getFeedbackID());
            stmt.setString(2, detail.getStoreFileName());
            stmt.setString(3, detail.getOriginalFileName());
            stmt.setString(4, detail.getFilePath());
            stmt.setString(5, detail.getFileType());
            
            stmt.executeUpdate();
        }
    }
      public List<Feedback> getFeedbackMedia(String feedbackId) throws SQLException {
        String sql = """
            SELECT * FROM FeedbackDetails 
            WHERE FeedbackID = ?
            ORDER BY FileType DESC
        """;
        
        List<Feedback> mediaFiles = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, feedbackId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Feedback detail = new Feedback();
                detail.setFbDetail(rs.getString("FeedbackDetailID"));
                detail.setFeedbackID(rs.getString("FeedbackID"));
                detail.setStoreFileName(rs.getString("StoredFileName"));
                detail.setOriginalFileName(rs.getString("OriginalFileName"));
                detail.setFilePath(rs.getString("FilePath"));
                detail.setFileType(rs.getString("FileType"));
                mediaFiles.add(detail);
            }
        }
        return mediaFiles;
    }
        public void updateFeedbackStatus(String feedbackId, String status, 
                                   String processedBy, String reply) throws SQLException {
        String sql = """
            UPDATE Feedback 
            SET Status = ?, 
                ProcessedBy = ?, 
                FeedbackReply = ?,
                ProcessedDate = GETDATE()
            WHERE FeedbackID = ?
        """;
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(2, processedBy);
            stmt.setString(3, reply);
            stmt.setString(4, feedbackId);
            
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
