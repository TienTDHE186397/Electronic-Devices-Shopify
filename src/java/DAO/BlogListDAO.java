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

                Blog blog = new Blog(rs.getInt("BlogID"), rs.getString("Blog_img"),rs.getString("Blog_Tittle"),
                        rs.getString("Blog_Type"), rs.getString("Blog_Summary_Information"),
                        rs.getDate("Blog_Update_Time"),
                        rs.getString("Blog_Detail"),rs.getInt("Blog_Views"),
                        rs.getString("Blog_Status"), person);

                list.add(blog);

            }

        } catch (Exception e) {

        }

        return list;
    }
    
    
    public static void main(String[] args) {
        
        
        BlogListDAO bl = new BlogListDAO();
        
        List<Blog> b = bl.getAllBlog();
        
        
        for(Blog m : b) {
            System.out.println(m.getBlog_views());
        }
        
        
    }

}
