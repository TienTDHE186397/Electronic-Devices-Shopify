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

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

                list.add(blog);

            }

        } catch (Exception e) {

        }

        return list;
    }

    public List<Blog> getBlogPerPage(int page, int perpage) {

        List<Blog> list = new ArrayList<>();

        int pageget = (page * perpage - perpage);

        String sql = "SELECT b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_img_tittle]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[Blog_Flag]\n"
                + "      ,b.[PersonID]\n"
                + "FROM Blog b, Person p\n"
                + "WHERE b.PersonID = p.PersonID\n"
                + "ORDER BY b.BlogID \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT 4 ROWS ONLY";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageget);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

                list.add(blog);

            }

        } catch (Exception e) {

        }

        return list;

    }

    // Khong su dung !!!
    public List<Blog> sortBlogList(String sort) {

        List<Blog> list = new ArrayList<>();

        String sql = "SELECT b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_img_tittle]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[Blog_Flag]\n"
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

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

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

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

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
                + "           ,[Blog_img_tittle]\n"
                + "           ,[Blog_Tittle]\n"
                + "           ,[Blog_Summary_Information]\n"
                + "           ,[Blog_Update_Time]\n"
                + "           ,[Blog_Detail]\n"
                + "           ,[Blog_Views]\n"
                + "           ,[Blog_Status]\n"
                + "           ,[Blog_Flag]\n"
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
            st.setString(3, b.getBlog_img_tittle());
            st.setString(4, b.getBlog_tittle());
            st.setString(5, b.getBlog_summary_information());
            st.setString(6, b.getBlog_update_time());
            st.setString(7, b.getBlog_detail());
            st.setInt(8, b.getBlog_views());
            st.setString(9, b.getBlog_status());
            st.setInt(10, b.getBlog_flag());
            st.setInt(11, o.getPersonID());
            st.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void editBlog(Blog b, Person o) {

        String sql = "UPDATE [dbo].[Blog]\n"
                + "   SET [Blog_Type] = ?\n"
                + "      ,[Blog_img] = ?\n"
                + "      ,[Blog_img_tittle] = ?\n"
                + "      ,[Blog_Tittle] = ?\n"
                + "      ,[Blog_Summary_Information] = ?\n"
                + "      ,[Blog_Update_Time] = ?\n"
                + "      ,[Blog_Detail] = ?\n"
                + "      ,[Blog_Views] = ?\n"
                + "      ,[Blog_Status] = ?\n"
                + "      ,[Blog_Flag] = ?\n"
                + "      ,[PersonID] = ?\n"
                + " WHERE BlogID = " + b.getBlogID();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, b.getBlog_type());
            st.setString(2, b.getBlog_img());
            st.setString(3, b.getBlog_img_tittle());
            st.setString(4, b.getBlog_tittle());
            st.setString(5, b.getBlog_summary_information());
            st.setString(6, b.getBlog_update_time());
            st.setString(7, b.getBlog_detail());
            st.setInt(8, b.getBlog_views());
            st.setString(9, b.getBlog_status());
            st.setInt(10, b.getBlog_flag());
            st.setInt(11, o.getPersonID());
            st.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public List<Blog> searchBlogList2(String tittlewrite, String authorwrite, String type, String statusf, String sort, String event, String page) {

        List<Blog> list = new ArrayList<>();

        int pageget = (Integer.parseInt(page) * 4 - 4);

        String sql = "SELECT b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_img_tittle]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[Blog_Flag]\n"
                + "      ,b.[PersonID]\n"
                + "FROM Blog b, Person p\n"
                + "WHERE b.PersonID = p.PersonID\n";

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

        if (event != null) {

            if (event.equals("phunu")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 3\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 01 AND 08 ";

            }

            if (event.equals("quockhanh")) {

                sql += "AND (\n"
                        + "        (MONTH(b.Blog_Update_Time) = 8 AND DAY(b.Blog_Update_Time) = 31) \n"
                        + "        OR \n"
                        + "        (MONTH(b.Blog_Update_Time) = 9 AND DAY(b.Blog_Update_Time) BETWEEN 1 AND 2)\n"
                        + "      )";

            }

            if (event.equals("giangsinh")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 12\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 20 AND 25 ";

            }

            if (event.equals("namgioi")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 11\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 15 AND 19 ";

            }

            if (event.equals("thieunhi")) {

                sql += "AND (\n"
                        + "        (MONTH(b.Blog_Update_Time) = 5 AND DAY(b.Blog_Update_Time) BETWEEN 30 AND 31) \n"
                        + "        OR \n"
                        + "        (MONTH(b.Blog_Update_Time) = 6 AND DAY(b.Blog_Update_Time) BETWEEN 1 AND 2))\n"
                        + "     ";

            }

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

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

                list.add(blog);

            }

        } catch (Exception e) {
        }

        return list;
    }

    public void changeBlogFlag(Blog b) {

        String sql = "UPDATE [dbo].[Blog]\n"
                + "   SET [Blog_Flag] = ?\n"
                + " WHERE BlogID = " + b.getBlogID();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (b.getBlog_flag() == 1) {
                st.setInt(1, 0);
            }

            if (b.getBlog_flag() == 0) {
                st.setInt(1, 1);
            }

            st.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List<Blog> searchBlogList(String tittlewrite, String authorwrite, String type, String statusf, String sort, String event, String page) {

        List<Blog> list = new ArrayList<>();

        int pageget = (Integer.parseInt(page) * 4 - 4);

        String sql = "SELECT b.[BlogID]\n"
                + "      ,b.[Blog_Type]\n"
                + "      ,b.[Blog_img]\n"
                + "      ,b.[Blog_img_tittle]\n"
                + "      ,b.[Blog_Tittle]\n"
                + "      ,b.[Blog_Summary_Information]\n"
                + "      ,b.[Blog_Update_Time]\n"
                + "      ,b.[Blog_Detail]\n"
                + "      ,b.[Blog_Views]\n"
                + "      ,b.[Blog_Status]\n"
                + "      ,b.[Blog_Flag]\n"
                + "      ,b.[PersonID]\n"
                + "FROM Blog b, Person p\n"
                + "WHERE b.PersonID = p.PersonID\n";

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

        if (event != null) {

            if (event.equals("phunu")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 3\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 01 AND 08 ";

            }

            if (event.equals("quockhanh")) {

                sql += "AND (\n"
                        + "        (MONTH(b.Blog_Update_Time) = 8 AND DAY(b.Blog_Update_Time) = 31) \n"
                        + "        OR \n"
                        + "        (MONTH(b.Blog_Update_Time) = 9 AND DAY(b.Blog_Update_Time) BETWEEN 1 AND 2)\n"
                        + "      )";

            }

            if (event.equals("giangsinh")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 12\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 20 AND 25 ";

            }

            if (event.equals("namgioi")) {

                sql += " AND MONTH(b.Blog_Update_Time) = 11\n"
                        + "  AND DAY(b.Blog_Update_Time) BETWEEN 15 AND 19 ";

            }

            if (event.equals("thieunhi")) {

                sql += "AND (\n"
                        + "        (MONTH(b.Blog_Update_Time) = 5 AND DAY(b.Blog_Update_Time) BETWEEN 30 AND 31) \n"
                        + "        OR \n"
                        + "        (MONTH(b.Blog_Update_Time) = 6 AND DAY(b.Blog_Update_Time) BETWEEN 1 AND 2))\n"
                        + "     ";

            }

        }

        // sort
        if (sort == null || sort.equals("")) {

            sql += " ORDER BY b.BlogID";

        }

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

        sql += "\n OFFSET " + pageget + " ROWS\n"
                + "FETCH NEXT 4 ROWS ONLY";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

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
        int count = 0;
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                if (count == 3) {
                    break;
                }
                Person person = pDAO.getPersonById(rs.getString("PersonID"));

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"), rs.getString("Blog_img_tittle"), rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getString("Blog_Update_Time"),
                        rs.getString("Blog_Detail"), rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), rs.getInt("Blog_Flag"), person);

                if (blog.getBlogID() == b.getBlogID()) {
                    continue;
                }

                list.add(blog);
                count++;
            }

        } catch (Exception e) {

        }

        return list;
    }

    public static void main(String[] args) {

        BlogListDAO bl = new BlogListDAO();
//        List<Blog> b = bl.sortBlogList("viewsd");
        Blog b1 = bl.getBlogById(1);
//           String b = bl.searchBlogList(null, null, null, "Published", "", "thieunhi", "1");
        //   System.out.println(b);
        // System.out.println(b);
//        List<Blog> list = bl.getBlogPerPage(2, 4);
        //  for (Blog m : b) {
        //      System.out.println(m.getBlogID());
        // }
//
        DAOPerson pd = new DAOPerson();

//        //Blog b2 = new Blog(22, "trung", "trung", "trung", "trung", "trung",
//                "2024-9-10", "trung", 12, "Published", "trung", 0, pd.getPersonById("6"));
//
//        bl.insertBlog(b2, pd.getPersonById("6"));
//
//        System.out.println("add thanh cong");
    }

}
