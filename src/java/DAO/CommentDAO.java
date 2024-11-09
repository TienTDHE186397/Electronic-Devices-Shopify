
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.CommentPerson;
import Entity.Person;
import Entity.imageComment;
import Entity.videoComment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class CommentDAO extends DBContext {

    DAOPerson pDAO = new DAOPerson();

    // Hàm lấy danh sách ảnh của một bình luận
    public List<CommentPerson> getCommentsByProductId(int productId) {
        List<CommentPerson> comments = new ArrayList<>();
        String sql = "SELECT [comment_id],\n"
                + "       [ProductID],\n"
                + "       [PersonID],\n"
                + "       [CommentDetail],\n"
                + "       [created_at]\n"
                + "FROM [dbo].[Comment]\n"
                + "WHERE [ProductID] = ?\n"
                + "ORDER BY [comment_id] DESC;"; // Sắp xếp giảm dần theo comment_id

        try (PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                LocalDate createAtLocalDate = rs.getDate("created_at").toLocalDate();
                Person person = pDAO.getPersonById(rs.getString("personID")); // Gọi phương thức để lấy Person

                CommentPerson comment = new CommentPerson(
                        rs.getInt("comment_id"),
                        rs.getInt("ProductID"),
                        person,
                        rs.getString("CommentDetail"),
                        createAtLocalDate
                );

                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comments;
    }

    public List<imageComment> getImageUrlsByCommentId(int commentId) {
        List<imageComment> imageComments = new ArrayList<>();
        String sql = "SELECT image_id, image_url FROM CommentImages WHERE comment_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, commentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int imageId = rs.getInt("image_id");

                String imageUrl = rs.getString("image_url");
//            String altText = rs.getString("alt_text");
                // Tạo một đối tượng imageComment và thêm nó vào danh sách
                imageComment imageCommentObj = new imageComment(imageId, imageUrl, null);
                imageComments.add(imageCommentObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageComments;
    }

    // Phương thức lấy tất cả video của một bình luận
    public List<videoComment> getVideoUrlsByCommentId(int commentId) {
        List<videoComment> videoComments = new ArrayList<>();
        String sql = "SELECT video_id, video_url FROM CommentVideos WHERE comment_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, commentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int videoId = rs.getInt("video_id");
//            int personId = rs.getInt("PersonID");
                String videoUrl = rs.getString("video_url");
//            String altText = rs.getString("alt_text"); // Giả sử bạn có thuộc tính alt_text cho video

                // Tạo một đối tượng VideoComment và thêm vào danh sách
                videoComment videoCommentObj = new videoComment(videoId, videoUrl, null);
                videoComments.add(videoCommentObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoComments;
    }

    public List<CommentPerson> getCommentsByProductId3(int productId) {
        String sql = """
            SELECT c.comment_id, c.CommentDetail, c.created_at, 
                               p.PersonID, p.Name, p.Email, p.Gender, p.DateOfBirth, 
                               img.image_url, vid.video_url , img.image_text , vid.video_text
                        FROM Comment c
                        JOIN Person p ON c.PersonID = p.PersonID
                        LEFT JOIN CommentImages img ON c.comment_id = img.comment_id
                        LEFT JOIN CommentVideos vid ON c.comment_id = vid.comment_id
                        WHERE c.ProductID = ?
                        ORDER BY c.created_at DESC
            """;

        Map<Integer, CommentPerson> commentMap = new HashMap<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, productId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int commentId = rs.getInt("comment_id");

                    // Kiểm tra xem comment đã tồn tại trong Map hay chưa
                    CommentPerson comment = commentMap.get(commentId);
                    if (comment == null) {
                        // Tạo CommentPerson mới nếu chưa có trong Map
                        String content = rs.getString("CommentDetail");
                        LocalDate createdAt = rs.getDate("created_at").toLocalDate();

                        // Lấy thông tin của Person
                        Person person = pDAO.getPersonById(rs.getString("personID")); // Gọi phương thức để lấy Person

                        // Khởi tạo CommentPerson và đưa vào Map
                        comment = new CommentPerson(commentId, productId, person, content, createdAt);
                        commentMap.put(commentId, comment);
                    }

                    // Thêm URL ảnh vào CommentPerson nếu có
                    String imageUrl = rs.getString("image_url");
                    String imageText = rs.getString("image_text");
                    if (imageUrl != null) {
                        comment.addImageUrl(imageUrl);
                        comment.addImageText(imageUrl);
                    }

                    // Thêm URL video vào CommentPerson nếu có
                    String videoUrl = rs.getString("video_url");
                    String videoText = rs.getString("video_text");
                    if (videoUrl != null) {
                        comment.addVideoUrl(videoUrl);
                        comment.addVideoText(videoText);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>(commentMap.values());
    }

    public int addComment(int productId, int personId, String commentDetail, LocalDate date) {
        int add = -1;
        String commentSql = "INSERT INTO Comment (ProductID, PersonID, CommentDetail, created_at) VALUES (?, ?, ?, ?)";
        try {
            // Chuẩn bị câu lệnh cho chèn dữ liệu
            PreparedStatement commentPs = connection.prepareStatement(commentSql, Statement.RETURN_GENERATED_KEYS);
            commentPs.setInt(1, productId);
            commentPs.setInt(2, personId);
            commentPs.setString(3, commentDetail);
            commentPs.setObject(4, date);

            // Thực hiện câu lệnh INSERT và kiểm tra nếu chèn thành công
            int affectedRows = commentPs.executeUpdate();

            // Nếu chèn thành công, lấy ID được tự động tạo
            if (affectedRows > 0) {
                ResultSet rs = commentPs.getGeneratedKeys();
                if (rs.next()) {
                    add = rs.getInt(1); // ID của bình luận mới chèn
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add; // Trả về -1 nếu có lỗi, hoặc ID của bình luận nếu chèn thành công
    }

    public boolean addCommentImages(int commentId, List<String> imageUrls, List<String> imageText) {
        String commentImageSql = "INSERT INTO CommentImages (comment_id, image_url, image_text) VALUES (?, ?, ?)";
        try (PreparedStatement imagePs = connection.prepareStatement(commentImageSql)) {
            for (int i = 0; i < imageUrls.size(); i++) {
                imagePs.setInt(1, commentId);
                imagePs.setString(2, imageUrls.get(i));
                imagePs.setString(3, imageText.get(i));
                imagePs.executeUpdate();
            }
            return true; // Images added successfully
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Failed to add images
    }

    public boolean addCommentVideos(int commentId, List<String> videoUrls, List<String> videoText) {
        String commentVideoSql = "INSERT INTO CommentVideos (comment_id, video_url, video_text) VALUES (?, ?, ?)";
        try (PreparedStatement videoPs = connection.prepareStatement(commentVideoSql)) {
            for (int i = 0; i < videoUrls.size(); i++) {
                videoPs.setInt(1, commentId);
                videoPs.setString(2, videoUrls.get(i));
                videoPs.setString(3, videoText.get(i));
                videoPs.executeUpdate();
            }
            return true; // Videos added successfully
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Failed to add videos
    }

//  
    public static void main(String[] args) {
        CommentDAO cm = new CommentDAO();
        List<CommentPerson> cd = cm.getCommentsByProductId(1);
        for (CommentPerson commentPerson : cd) {
            System.out.println(commentPerson);
        }
    }
}

