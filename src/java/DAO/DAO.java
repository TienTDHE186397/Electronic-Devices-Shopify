/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import Entity.Product;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getTrendingFilm() {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from Products order by [Views] desc";
        try {
            conn = new DBContext().getConnection(); // Mở kết nối với SQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra console để dễ debug
        } finally {
            // Đóng kết nối, PreparedStatement và ResultSet nếu có
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Product> getMoviesByNamePattern(String namePattern) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Schedule.CinemaID = 1\n"
                + "AND ProductName LIKE ?";
        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + namePattern + "%"); // Include wildcards in the parameter value
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the error to the console for debugging
        } finally {
            // Close connection, PreparedStatement, and ResultSet if they exist
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Schedule.CinemaID = 1\n"
                + "AND Schedule.[Status] = 1";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLastAddProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 1 *\n"
                + "FROM Products\n"
                + "ORDER BY ProductID DESC;";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        5);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getAllProductForManager() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllByCalendarId() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "WHERE Schedule.[Status] = 1 OR Schedule.[Status] = 2 OR Schedule.[Status] = 3";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(String pid) {
//    String deleteCalendarQuery = "DELETE FROM Calendar WHERE MovieID = ?";
        String query = "DELETE FROM Products WHERE ProductID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            // Xóa từ bảng Calendar
//        ps = conn.prepareStatement(deleteCalendarQuery);
//        ps.setString(1, pid);
//        ps.executeUpdate();
            // Xóa từ bảng Movies
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();

            conn.commit(); // Xác nhận giao dịch
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Quay lại giao dịch nếu có lỗi
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void insertMovie(String movieName, String genre, String director, String performer, String price, String ageRating, String image,
            String imageBanner, String description, String views, String time, String releaseDate, int quantitySold, int categoryid, int cinemaId) {
        String query = "INSERT INTO Products([ProductName],[Genre],[Director],[Performer],[Price],[Age],[Image],[ImageBanner],[Description],[Views],[Time],[ReleaseDate],[QuantitySold],[CategoryID], [CinemaID]) VALUES\n"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, movieName);
            ps.setString(2, genre);
            ps.setString(3, director);
            ps.setString(4, performer);
            ps.setString(5, price);
            ps.setString(6, ageRating);
            ps.setString(7, image);
            ps.setString(8, imageBanner);
            ps.setString(9, description);
            ps.setString(10, views);
            ps.setString(11, time);
            ps.setString(12, releaseDate);
            ps.setInt(13, quantitySold);
            ps.setInt(14, categoryid);
            ps.setInt(15, cinemaId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Product> getMoviesByManagerID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "FROM Products m\n"
                + "JOIN Cinema c ON m.CinemaID = c.CinemaID\n"
                + "WHERE c.cinemaManagerID = ?;";

        try {
            conn = new DBContext().getConnection(); // Open connection to SQL
            ps = conn.prepareStatement(query);
            ps.setInt(1, id); // Set the parameter
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print error to console for debugging
        } finally {
            // Close connection, PreparedStatement, and ResultSet if they exist
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Product> getDangChieuProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Schedule.CinemaID = 1\n"
                + "AND Schedule.[Status] = 0";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBypid(String pid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Products.[ProductID] = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product get1ProductBypid(String pid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Products.[ProductID] = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getDaChieuProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "Where\n"
                + "Schedule.CinemaID = 1\n"
                + "AND Schedule.[Status] = 4";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getCommingsoonProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "Products.ProductID,\n"
                + "Products.ProductName,\n"
                + "Products.Genre,\n"
                + "Products.Director,\n"
                + "Products.Performer,\n"
                + "Products.Price,\n"
                + "Products.Age,\n"
                + "Products.[Image],\n"
                + "Products.ImageBanner,\n"
                + "Products.[Description],\n"
                + "Products.[Views],\n"
                + "Products.[Time],\n"
                + "Products.releaseDate,\n"
                + "Products.QuantitySold,\n"
                + "Products.CategoryID,\n"
                + "Products.CinemaID,\n"
                + "Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "WHERE Products.CinemaID = 1\n"
                + "AND Schedule.[Status] = 2\n"
                + "";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getMostViewProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 4\n"
                + "    Products.ProductID,\n"
                + "    Products.ProductName,\n"
                + "    Products.Genre,\n"
                + "    Products.Director,\n"
                + "    Products.Performer,\n"
                + "    Products.Price,\n"
                + "    Products.Age,\n"
                + "    Products.[Image],\n"
                + "    Products.ImageBanner,\n"
                + "    Products.[Description],\n"
                + "    Products.[Views],\n"
                + "    Products.[Time],\n"
                + "    Products.releaseDate,\n"
                + "    Products.QuantitySold,\n"
                + "    Products.CategoryID,\n"
                + "    Products.CinemaID,\n"
                + "    Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "WHERE Products.CinemaID = 1\n"
                + "AND Schedule.[Status] IN (1, 0, 3, 4)\n"
                + "ORDER BY Products.[Views] DESC;";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getBannerProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 3\n"
                + "    Products.ProductID,\n"
                + "    Products.ProductName,\n"
                + "    Products.Genre,\n"
                + "    Products.Director,\n"
                + "    Products.Performer,\n"
                + "    Products.Price,\n"
                + "    Products.Age,\n"
                + "    Products.[Image],\n"
                + "    Products.ImageBanner,\n"
                + "    Products.[Description],\n"
                + "    Products.[Views],\n"
                + "    Products.[Time],\n"
                + "    Products.releaseDate,\n"
                + "    Products.QuantitySold,\n"
                + "    Products.CategoryID,\n"
                + "    Products.CinemaID,\n"
                + "    Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "WHERE Products.CinemaID = 1\n"
                + "AND Schedule.[Status] IN (1, 0, 3)\n"
                + "ORDER BY Products.releaseDate DESC;";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Categories> getAllCategories() {
        List<Categories> list = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Categories(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT \n"
                + "    Products.ProductID,\n"
                + "    Products.ProductName,\n"
                + "    Products.Genre,\n"
                + "    Products.Director,\n"
                + "    Products.Performer,\n"
                + "    Products.Price,\n"
                + "    Products.Age,\n"
                + "    Products.[Image],\n"
                + "    Products.ImageBanner,\n"
                + "    Products.[Description],\n"
                + "    Products.[Views],\n"
                + "    Products.[Time],\n"
                + "    Products.releaseDate,\n"
                + "    Products.QuantitySold,\n"
                + "    Products.CategoryID,\n"
                + "    Products.CinemaID,\n"
                + "    Schedule.[Status]\n"
                + "FROM Products\n"
                + "INNER JOIN Schedule ON Products.ProductID = Schedule.ProductID\n"
                + "WHERE Products.CinemaID = 1\n"
                + "AND Products.CategoryID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16),
                        rs.getInt(17)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void editMovies(int productID, String movieName, String genre, String director, String performer, String price, String ageRating, String image,
            String imageBanner, String description, String views, String time, String releaseDate, String quantitySold, int categoryid, int cinemaId) {
        String query = "UPDATE Products \n"
                + "SET \n"
                + "    [ProductName] = ?,\n"
                + "    [Genre] = ?,\n"
                + "    [Director] = ?,\n"
                + "    [Performer] = ?,\n"
                + "    [Price] = ?,\n"
                + "    [Age] = ?,\n"
                + "    [Image] = ?,\n"
                + "    [ImageBanner] = ?,\n"
                + "    [Description] = ?,\n"
                + "    [Views] = ?,\n"
                + "    [Time] = ?,\n"
                + "    [releaseDate] = ?,\n"
                + "    [QuantitySold] = ?,\n"
                + "    [CategoryID] = ?,\n"
                + "    [CinemaID] = ?\n"
                + "WHERE \n"
                + "    [ProductID] = ?;";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, movieName);
            ps.setString(2, genre);
            ps.setString(3, director);
            ps.setString(4, performer);
            ps.setString(5, price);
            ps.setString(6, ageRating);
            ps.setString(7, image);
            ps.setString(8, imageBanner);
            ps.setString(9, description);
            ps.setString(10, views);
            ps.setString(11, time);
            ps.setString(12, releaseDate);
            ps.setString(13, quantitySold);
            ps.setInt(14, categoryid);
            ps.setInt(15, cinemaId);
            ps.setInt(16, productID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getProductBypid("1");
        for (Product o : list) {
            System.out.println(o);
        }
    }
}
