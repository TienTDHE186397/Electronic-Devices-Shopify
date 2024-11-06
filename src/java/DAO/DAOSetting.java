/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Setting;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nghie
 */
public class DAOSetting extends DBContext {

    public List<Setting> getAllSettings() {
        List<Setting> list = new ArrayList<>();
        String sql = "select * from Setting";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt("ID"),
                        rs.getString("Type"),
                        rs.getString("Value"),
                        rs.getString("Image"),
                        rs.getInt("Order"),
                        rs.getString("Status"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void changeStatusById(String status, String id) {
        String sql = "UPDATE [dbo].[Setting] \n"
                + "   SET [Status] = '" + status + "'" + " WHERE ID = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getTypeDistinct(String type) {
        List<String> list = new ArrayList<>();
        String sql = "select distinct [Type] from Setting";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                type = rs.getString("type");
                list.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addSetting(Setting s) {
        String sql = "INSERT INTO [dbo].[Setting] \n"
                + "           ([Type]\n"
                + "           ,[Value]\n"
                + "           ,[Order]\n"
                + "           ,[Status] \n"
                + "           ,[Image])\n"
                + "     VALUES \n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getType());
            ps.setString(2, s.getValue());
            ps.setInt(3, s.getOrder());
            ps.setString(4, s.getStatus());
            ps.setString(5, s.getImage());
            int n = ps.executeUpdate();
            return n>0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        
    }
    public void updateSetting(String id, String type, String value, String order, String status, String image){
        String sql = "UPDATE [dbo].[Setting] \n" +
"   SET " +
"      [Type] = ?\n" +
"      ,[Value] = ?\n" +
"      ,[Order] = ?\n" +
"      ,[Status] = ?\n" +
"      ,[Image] = ?\n" +
" WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, value);
            ps.setString(3, order);
            ps.setString(4, status);
            ps.setString(5, image);
            ps.setString(6, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
    }
    }
    public void deleteSetting(String id){
        String sql = "DELETE FROM [dbo].[Setting] \n" +
"      WHERE ID = " + id;
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getTotalSettings() {
        int n = 0;
        String sql = "select count(*) \n"
                + "from Setting";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Setting> pagingSetting(int index) {
        List<Setting> list = new ArrayList<>();
        String sql = "select * from Setting \n"
                + "order by ID \n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Setting(rs.getInt("ID"),
                        rs.getString("Type"),
                        rs.getString("Value"),
                        rs.getString("Image"),
                        rs.getInt("Order"),
                        rs.getString("Status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Setting getSettingById(String id) {
        String sql = "Select * from Setting where ID = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt("ID"),
                        rs.getString("Type"),
                        rs.getString("Value"),
                        rs.getString("Image"),
                        rs.getInt("Order"),
                        rs.getString("Status"));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Setting> searchSetting(String search, String type, String status) {
        List<Setting> list = new ArrayList<>();
        String sql = "Select * from Setting where 1=1 ";
        if (search != null && !search.isEmpty()) {
            sql += "and (Type like N'%" + search + "%'" + "or Value like N'%" + search + "%')";
        }
        if (type != null && !type.isEmpty()) {
            sql += "and Type like N'%" + type + "%'";
        }
        if (status != null && !status.isEmpty()) {
            sql += "and Status = N'" + status + "'";
        }
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(
                        rs.getInt("ID"),
                        rs.getString("Type"),
                        rs.getString("Value"),
                        rs.getString("Image"),
                        rs.getInt("Order"),
                        rs.getString("Status"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DAOSetting ds = new DAOSetting();
//        int count = ds.getTotalSettings();
//        System.out.println(count);
        List<Setting> list = ds.pagingSetting(2);
        for (Setting s : list) {
            System.out.println(s);
        }
    }
}
