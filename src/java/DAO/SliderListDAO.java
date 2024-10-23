/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import Entity.Slider;
import java.util.*;
import java.lang.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SliderListDAO extends DBContext {

    DAOPerson pDAO = new DAOPerson();

    public List<Slider> getAllSlider() {

        List<Slider> list = new ArrayList<>();

        String sql = "Select * From Slider";

        try {

            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Slider slider = new Slider(rs.getInt("SliderID"), rs.getString("SliderTittle"),
                        rs.getString("SliderImage"), rs.getString("SliderVideo"),
                        rs.getString("SliderBacklink"),
                        rs.getString("SliderDate"),
                        rs.getString("SliderStatus"),
                        rs.getString("SliderNote"), person);

                list.add(slider);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public List<Slider> searchSlider(String search, String filter, int page, int perpage) {

        List<Slider> list = new ArrayList<>();

        int pageget = (page * perpage - perpage);

        String sql = "Select * From Slider WHERE 1=1 ";

        if (!search.isBlank()) {
            sql += "AND (SliderTittle Like N'%" + search.trim() + "%' OR SliderBacklink Like N'%" + search.trim() + "%') ";
        }

        if (!filter.isBlank()) {
            sql += "AND SliderStatus = '" + filter + "' \n";
        }

        sql += "ORDER BY SliderID \n"
                + "OFFSET " + pageget + " ROWS\n"
                + "FETCH NEXT " + perpage + " ROWS ONLY";

        try {

            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Slider slider = new Slider(rs.getInt("SliderID"), rs.getString("SliderTittle"),
                        rs.getString("SliderImage"), rs.getString("SliderVideo"),
                        rs.getString("SliderBacklink"),
                        rs.getString("SliderDate"),
                        rs.getString("SliderStatus"),
                        rs.getString("SliderNote"), person);

                list.add(slider);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public Slider getSliderById(int id) {

        String sql = "Select * From Slider WHERE SliderID = " + id;

        try {

            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Slider slider = new Slider(rs.getInt("SliderID"), rs.getString("SliderTittle"),
                        rs.getString("SliderImage"), rs.getString("SliderVideo"),
                        rs.getString("SliderBacklink"),
                        rs.getString("SliderDate"),
                        rs.getString("SliderStatus"),
                        rs.getString("SliderNote"), person);

                return slider;

            }

        } catch (Exception e) {

        }

        return null;

    }

    public void insertSlider(Slider s, Person o) {
        String sql = "INSERT INTO [dbo].[Slider]\n"
                + "           ([SliderTittle]\n"
                + "           ,[SliderImage]\n"
                + "           ,[SliderVideo]\n"
                + "           ,[SliderBacklink]\n"
                + "           ,[SliderDate]\n"
                + "           ,[SliderStatus]\n"
                + "           ,[SliderNote]\n"
                + "           ,[PersonID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSlider_tittle());
            st.setString(2, s.getSlider_image());
            st.setString(3, s.getSlider_video());
            st.setString(4, s.getSlider_backlink());
            st.setString(5, s.getSlider_date());
            st.setString(6, s.getSlider_status());
            st.setString(7, s.getSlider_note());
            st.setInt(8, o.getPersonID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateSlider(Slider s, Person o) {
        String sql = "UPDATE [dbo].[Slider]\n"
                + "   SET [SliderTittle] = ?\n"
                + "      ,[SliderImage] = ?\n"
                + "      ,[SliderVideo] = ?\n"
                + "      ,[SliderBacklink] = ?\n"
                + "      ,[SliderDate] = ?\n"
                + "      ,[SliderStatus] = ?\n"
                + "      ,[SliderNote] = ?\n"
                + "      ,[PersonID] = ?\n"
                + " WHERE SliderID = " + s.getSlider_id();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSlider_tittle());
            st.setString(2, s.getSlider_image());
            st.setString(3, s.getSlider_video());
            st.setString(4, s.getSlider_backlink());
            st.setString(5, s.getSlider_date());
            st.setString(6, s.getSlider_status());
            st.setString(7, s.getSlider_note());
            st.setInt(8, o.getPersonID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Slider> getSliderPerPage(int page, int perpage) {

        List<Slider> list = new ArrayList<>();

        int pageget = (page * perpage - perpage);

        String sql = "SELECT [SliderID]\n"
                + "      ,[SliderTittle]\n"
                + "      ,[SliderImage]\n"
                + "      ,[SliderVideo]\n"
                + "      ,[SliderBacklink]\n"
                + "      ,[SliderDate]\n"
                + "      ,[SliderStatus]\n"
                + "      ,[SliderNote]\n"
                + "      ,[PersonID]\n"
                + "  FROM [dbo].[Slider]\n"
                + "ORDER BY SliderID \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageget);
            st.setInt(2, perpage);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Person person = pDAO.getPersonById(rs.getString("PersonID"));
                Slider slider = new Slider(rs.getInt("SliderID"), rs.getString("SliderTittle"),
                        rs.getString("SliderImage"), rs.getString("SliderVideo"),
                        rs.getString("SliderBacklink"),
                        rs.getString("SliderDate"),
                        rs.getString("SliderStatus"),
                        rs.getString("SliderNote"), person);

                list.add(slider);

            }

        } catch (Exception e) {

        }

        return list;

    }

}
