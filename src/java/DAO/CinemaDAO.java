/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Cinema;
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
public class CinemaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Cinema> getAllCinema() {
        List<Cinema> list = new ArrayList<>();
        String query = "SELECT * FROM Cinema";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cinema(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Cinema> getCinemaById(String cinemaid) {
        List<Cinema> list = new ArrayList<>();
        String query = "SELECT * FROM Cinema \n"
                + "WHERE cinema.CinemaID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, cinemaid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cinema(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductByCinemaID(String cinemaid) {
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
                + "Schedule.CinemaID = ?\n"
                + "AND Schedule.[Status] = 1\n";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, cinemaid);
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

    public List<Product> getDaChieuProductByCinemaID(String cinemaid) {
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
                + "Schedule.CinemaID = ?\n"
                + "AND Schedule.[Status] = 4";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, cinemaid);
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

    public List<Product> getDangChieuProductByCinemaID(String cinemaid) {
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
                + "Schedule.CinemaID = ?\n"
                + "AND Schedule.[Status] = 0";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, cinemaid);
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

    public static void main(String[] args) {
        CinemaDAO dao = new CinemaDAO();
        List<Cinema> list = dao.getCinemaById("1");
        for (Cinema o : list) {
            System.out.println(o);
        }
    }

    public void editCinema(String id, String name, String address) {
        String query = "UPDATE Cinema\n"
                + "SET \n"
                + "	[CinemaName] = ?,\n"
                + "	[Address] = ?\n"
                + "WHERE\n"
                + "	[CinemaID] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, id);
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

    public void AddCinema(String name, String address) {
        String query = "INSERT INTO Cinema ([CinemaName], [Address]) VALUES\n"
                + "(?,?);";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            
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

    public void deletecinema(String aid) {
        String deleteCalendarQuery = "DELETE FROM Cinema WHERE [CinemaID] = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(deleteCalendarQuery);
            ps.setString(1, aid);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
