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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public Blog getBlogById(int id) {

        String sql = "select *"
                + "from Blog where BlogID = " + id;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"),
                        rs.getString("Blog_img"),
                        rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"),
                        rs.getString("Blog_Summary_Information"),
                        rs.getDate("Blog_Update_Time"),
                        rs.getString("Blog_Detail"),
                        rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"),
                        person);

                return blog;

            }

        } catch (Exception e) {

        }

        return null;

    }

    public void insertBlog(Blog b, Person o) {

        String sql = "INSERT INTO [dbo].[Blog]\n"
                + "           ([Blog_Type]\n"
                + "           ,[Blog_img]\n"
                + "           ,[Blog_Tittle]\n"
                + "           ,[Blog_Summary_Information]\n"
                + "           ,[Blog_Update_Time]\n"
                + "           ,[Blog_Detail]\n"
                + "           ,[Blog_Views]\n"
                + "           ,[Blog_Status]\n"
                + "           ,[PersonID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, b.getBlog_type());
            st.setString(2, b.getBlog_img());
            st.setString(3, b.getBlog_tittle());
            st.setString(4, b.getBlog_summary_information());
            st.setDate(5, (java.sql.Date) b.getBlog_update_time());
            st.setString(6, b.getBlog_detail());
            st.setInt(7, b.getBlog_views());
            st.setString(8, b.getBlog_status());
            st.setString(9, o.getName());
            st.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public List<Blog> searchBlogList(String tittlewrite, String authorwrite, String type, String statusf, String sort) {

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

    public List<Blog> getRelatedBlog(Blog b) {

        List<Blog> list = new ArrayList<>();
        //  Blog_Status = 'Published' AND 

        String sql = "select *\n"
                + "from Blog\n"
                + "Where (Blog_Type = N'"
                + b.getBlog_type() + "' OR PersonID = " + b.getPerson().getPersonID() + ")";

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

                if (blog.getBlogID() == b.getBlogID()) {
                    continue;
                }

                list.add(blog);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public static void main(String[] args) {

        BlogListDAO bl = new BlogListDAO();
//        List<Blog> b = bl.sortBlogList("viewsd");
        Blog b1 = bl.getBlogById(1);
        List<Blog> b = bl.getRelatedBlog(b1);
        
       for (Blog m : b) {

           System.out.println(m.getBlogID());

        }

    }

}
