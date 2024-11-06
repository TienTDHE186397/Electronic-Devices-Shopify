/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categories;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class CategoryDAO extends DBContext {

    public List<Categories> getAllCategory() {

        List<Categories> list = new ArrayList<>();

        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories]";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Categories category = new Categories(rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));

                list.add(category);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public Categories getCategoriesById(int id) {

        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories]\n"
                + "  WHERE CategoryID = ? ";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                Categories category = new Categories(rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));

                return category;
            }

        } catch (Exception e) {
        }

        return null;
    }

    public void addNewCategories(Categories c) {

        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        CategoryDAO cdao = new CategoryDAO();

        List<Categories> c = cdao.getAllCategory();

        for (Categories cl : c) {

            System.out.println(cl.getCategoryName());

        }

    }

}
