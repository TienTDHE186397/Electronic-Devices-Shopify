/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Blog;
import Entity.Person;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class BlogListDAO extends DBContext {

    DAOPerson pDAO = new DAOPerson();

    public List<Blog> getAllBlog() {

        List<Blog> list = new ArrayList<>();

        String sql = "select * from Blog";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getDate("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), person);

                list.add(blog);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public List<Blog> sortBlogList(String sort) {

        List<Blog> list = new ArrayList<>();

        String sql = "select b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[PersonID]\n"
                + " from Blog b , Person p\n"
                + " where b.PersonID = p.PersonID "
                + "";

        if (sort.equals("tittleu")) {
            sql += "ORDER BY b.Blog_Tittle ASC";
        }

        if (sort.equals("tittled")) {
            sql += "ORDER BY b.Blog_Tittle DESC";
        }

        if (sort.equals("typeu")) {
            sql += "ORDER BY b.Blog_Type ASC";
        }

        if (sort.equals("typed")) {
            sql += "ORDER BY b.Blog_Type DESC";
        }

        if (sort.equals("authoru")) {
            sql += "ORDER BY p.Name ASC";
        }

        if (sort.equals("authord")) {
            sql += "ORDER BY p.Name DESC";
        }

        if (sort.equals("viewsu")) {
            sql += "ORDER BY b.Blog_Views ASC";
        }

        if (sort.equals("viewsd")) {
            sql += "ORDER BY b.Blog_Views DESC";
        }

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getDate("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), person);

                list.add(blog);

            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Blog> searchBlogList(String tittlewrite, String authorwrite, String type, String statusf,String sort) {

        List<Blog> list = new ArrayList<>();

        String sql = "  select b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[PersonID]\n"
                + " from Blog b , Person p\n"
                + " where b.PersonID = p.PersonID ";

        if (tittlewrite != null) {

            sql += "AND b.Blog_Tittle Like N'%" + tittlewrite + "%' ";
        }

        if (authorwrite != null) {

            sql += "AND p.Name like N'%" + authorwrite + "%' ";
        }

        if (type != null) {

            sql += "AND b.Blog_Type like N'%" + type + "%' ";
        }

        if (statusf != null) {

            sql += "AND b.Blog_Status like N'%" + statusf + "%' ";
        }
        
        // sort
        
          if (sort.equals("tittleu")) {
            sql += "ORDER BY b.Blog_Tittle ASC";
        }

        if (sort.equals("tittled")) {
            sql += "ORDER BY b.Blog_Tittle DESC";
        }

        if (sort.equals("typeu")) {
            sql += "ORDER BY b.Blog_Type ASC";
        }

        if (sort.equals("typed")) {
            sql += "ORDER BY b.Blog_Type DESC";
        }

        if (sort.equals("authoru")) {
            sql += "ORDER BY p.Name ASC";
        }

        if (sort.equals("authord")) {
            sql += "ORDER BY p.Name DESC";
        }

        if (sort.equals("viewsu")) {
            sql += "ORDER BY b.Blog_Views ASC";
        }

        if (sort.equals("viewsd")) {
            sql += "ORDER BY b.Blog_Views DESC";
        }

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getDate("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), person);

                list.add(blog);

            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<String> getDistinctOfBlogType() {

        List<String> list = new ArrayList();

        String sql = "select distinct Blog_Type\n"
                + "from Blog";

        try {

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("Blog_Type"));
            }

        } catch (Exception e) {

        }

        return list;
    }

    public static void main(String[] args) {

        BlogListDAO bl = new BlogListDAO();
        List<Blog> b = bl.sortBlogList("viewsd");
        for(Blog m : b) {
            
            System.out.println(m.getBlogID());
            
        }




    }

}
