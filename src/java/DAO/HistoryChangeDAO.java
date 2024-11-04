/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HistoryChange;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author Dokkuhai
 */
public class HistoryChangeDAO extends DBContext {

    public List<HistoryChange> getAllHistoryChanges() {
        List<HistoryChange> historyList = new ArrayList<>();
        String sql = "SELECT * FROM HistoryChange ORDER BY UpdatedDate DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HistoryChange historyChange = new HistoryChange();
                historyChange.setHistoryID(rs.getInt("HistoryID"));
                historyChange.setPersonID(rs.getInt("PersonID"));
                historyChange.setEmail(rs.getString("Email"));
                historyChange.setFullName(rs.getString("FullName"));
                historyChange.setGender(rs.getString("Gender"));
                historyChange.setMobile(rs.getString("Mobile"));
                historyChange.setAddress(rs.getString("Address"));
                historyChange.setUpdatedBy(rs.getString("UpdatedBy"));
                historyChange.setUpdatedDate(rs.getTimestamp("UpdatedDate"));

                historyList.add(historyChange);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public List<HistoryChange> getHistoryByPersonId(int personID) {
        List<HistoryChange> historyList = new ArrayList<>();
        String sql = "SELECT * FROM HistoryChange WHERE PersonID = ? ORDER BY UpdatedDate DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, personID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HistoryChange historyChange = new HistoryChange();
                historyChange.setHistoryID(rs.getInt("HistoryID"));
                historyChange.setPersonID(rs.getInt("PersonID"));
                historyChange.setEmail(rs.getString("Email"));
                historyChange.setFullName(rs.getString("FullName"));
                historyChange.setGender(rs.getString("Gender"));
                historyChange.setMobile(rs.getString("Mobile"));
                historyChange.setAddress(rs.getString("Address"));
                historyChange.setUpdatedBy(rs.getString("UpdatedBy"));
                historyChange.setUpdatedDate(rs.getTimestamp("UpdatedDate"));

                historyList.add(historyChange);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    // Phương thức thêm bản ghi vào bảng HistoryChange
    public boolean addHistoryChange(HistoryChange historyChange) {
        String sql = "INSERT INTO HistoryChange (PersonID, Email, FullName, Gender, Mobile, Address, UpdatedBy, UpdatedDate) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, historyChange.getPersonID());
            ps.setString(2, historyChange.getEmail());
            ps.setString(3, historyChange.getFullName());
            ps.setString(4, historyChange.getGender());
            ps.setString(5, historyChange.getMobile());
            ps.setString(6, historyChange.getAddress());
            ps.setString(7, historyChange.getUpdatedBy());
            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HistoryChange> getHistoryChangesByPage(int personID, int pageIndex, int pageSize) {
        List<HistoryChange> historyList = new ArrayList<>();
        String sql = "SELECT * FROM HistoryChange WHERE PersonID = ? ORDER BY UpdatedDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, personID); // Thêm personID vào truy vấn
            ps.setInt(2, (pageIndex - 1) * pageSize); // Số bản ghi bỏ qua
            ps.setInt(3, pageSize); // Số bản ghi cần lấy

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistoryChange historyChange = new HistoryChange();
                historyChange.setHistoryID(rs.getInt("HistoryID"));
                historyChange.setPersonID(rs.getInt("PersonID"));
                historyChange.setEmail(rs.getString("Email"));
                historyChange.setFullName(rs.getString("FullName"));
                historyChange.setGender(rs.getString("Gender"));
                historyChange.setMobile(rs.getString("Mobile"));
                historyChange.setAddress(rs.getString("Address"));
                historyChange.setUpdatedBy(rs.getString("UpdatedBy"));
                historyChange.setUpdatedDate(rs.getTimestamp("UpdatedDate"));

                historyList.add(historyChange);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public int getTotalHistoryChangesCount(int personID) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM HistoryChange WHERE PersonID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, personID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        HistoryChangeDAO history = new HistoryChangeDAO();
        HistoryChange obj = new HistoryChange(1, 8, "email@gmail.com", "Vũ Đức Hải", "Nam", "0123456789", "Ha nOi", "Marketing manager", null);
        // Gọi phương thức thêm bản ghi vào lịch sử thay đổi
        boolean check = history.addHistoryChange(obj);
        if (check) {
            System.out.println("Thêm lịch sử thay đổi thành công!");
        } else {
            System.out.println("Thêm lịch sử thay đổi thất bại.");
        }
        List<HistoryChange> list = history.getAllHistoryChanges();
        for (HistoryChange h : list) {
            System.out.println(h);
        }

    }
}
