/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Calendar;
import Entity.Calendar2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import context.DBContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dutpr
 */
public class CalendarDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Calendar2> getCalendarForView() {
        List<Calendar2> list = new ArrayList<>();
        String query = "SELECT DISTINCT s.[ScheduleID], c.CinemaID, p.ProductName, s.MovieDate, \n"
                + "                s.Slot1, s.Slot2, s.Slot3, s.Slot4, s.Slot5, s.RoomID, s.[Status]	\n"
                + "FROM Schedule s\n"
                + "INNER JOIN Products p ON s.ProductID = p.ProductID\n"
                + "INNER JOIN Cinema c ON p.CinemaID = c.CinemaID\n"
                + "WHERE s.[Status] IN (0,1, 2, 3, 4)";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Calendar2(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Calendar2> getCalendarForViewByCinemaId(String id) {
        List<Calendar2> list = new ArrayList<>();
        String query = "SELECT DISTINCT s.[ScheduleID], c.CinemaID, p.ProductName, s.MovieDate, \n"
                + "                s.Slot1, s.Slot2, s.Slot3, s.Slot4, s.Slot5, s.RoomID, s.[Status]	\n"
                + "FROM Schedule s\n"
                + "INNER JOIN Products p ON s.ProductID = p.ProductID\n"
                + "INNER JOIN Cinema c ON p.CinemaID = c.CinemaID\n"
                + "WHERE s.[Status] IN (0,1, 2, 3) AND c.CinemaID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Calendar2(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Calendar> getCalendarBypid(String pid) {
        List<Calendar> list = new ArrayList<>();
        String query = "Select * from Schedule S WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Calendar(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Calendar> getCalendarByCid(int cid) {
        List<Calendar> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "FROM Schedule\n"
                + "WHERE ScheduleID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Calendar(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Calendar get1CalendarBypid(String pid) {
        List<Calendar> list = new ArrayList<>();
        String query = "Select * from Schedule S WHERE ProductID = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Calendar(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteCalendar(String pid) {
        String deleteCalendarQuery = "DELETE FROM Schedule WHERE ProductID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(deleteCalendarQuery);
            ps.setString(1, pid);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void InsertNewCalendarByPid(int productId, int cinemaId) {
        String query = "INSERT INTO Schedule ([CinemaID], [ProductID], [MovieDate], [Slot1], [Slot2], [Slot3], [Slot4], [Slot5], [RoomID], [Status])\n"
                + "VALUES (?, ?, CAST(GETDATE() AS DATE), N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', 0, 0)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Open connection to the database
            ps = conn.prepareStatement(query);
            ps.setInt(1, cinemaId);
            ps.setInt(2, productId);
            ps.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE queries
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

    public void updateCalendarByCid(int cid, String slot1,String slot2, String slot3,String slot4,String slot5,int roomid,int status) {
        String query = "UPDATE Schedule\n"
                + "SET \n"
                + "	[Slot1] = ?,\n"
                + "	[Slot2] = ?,\n"
                + "	[Slot3] = ?,\n"
                + "	[Slot4] = ?,\n"
                + "	[Slot5] = ?,\n"
                + "	[RoomID] = ?,\n"
                + "	[Status] =?\n"
                + "WHERE ScheduleID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection(); // Open connection to the database
            ps = conn.prepareStatement(query);
            ps.setString(1, slot1);
            ps.setString(2, slot2);
            ps.setString(3, slot3);
            ps.setString(4, slot4);
            ps.setString(5, slot5);
            ps.setInt(6, roomid);
            ps.setInt(7, status);
            ps.setInt(8, cid);
            ps.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE queries
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
        CalendarDAO dao = new CalendarDAO();
        List<Calendar> list = dao.getCalendarByCid(103);
        for (Calendar o : list) {
            System.out.println(o);
        }
    }
}
