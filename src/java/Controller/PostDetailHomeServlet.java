/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.DAOPerson;
import Entity.Blog;
import Entity.CommentBlog;
import Entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import java.lang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "PostDetailHomeServlet", urlPatterns = {"/PostDetailHome"})
public class PostDetailHomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BlogListDAO blogDAO = new BlogListDAO();
        String id_raw = request.getParameter("id");
        List<Blog> listRB;

        try {
            int id = Integer.parseInt(id_raw);
            Blog blog = blogDAO.getBlogById(id);
            listRB = blogDAO.getRelatedBlog(blog);
            List<CommentBlog> listC = blogDAO.getAllCommetFromBlog(id);
            
            blogDAO.increaseViewBlog(blog);

            request.setAttribute("listC", listC);
            request.setAttribute("blog", blog);
            request.setAttribute("listRB", listRB);
            request.getRequestDispatcher("PostDetailHome.jsp").forward(request, response);
        } catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comment = request.getParameter("comment");
        String id_raw = request.getParameter("id");

        try {

            int id = Integer.parseInt(id_raw);
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            BlogListDAO blogDAO = new BlogListDAO();
            DAOPerson perDAO = new DAOPerson();
            
            HttpSession session = request.getSession();
            Blog blog = blogDAO.getBlogById(id);
            //    session.setAttribute("user", user);
            Person p = (Person) session.getAttribute("user");
            Person person = perDAO.getPersonById(String.valueOf(p.getPersonID()));

            List<Blog> list = blogDAO.getAllBlog();

            CommentBlog c = new CommentBlog(list.get(list.size() - 1).getBlogID() + 1, comment, formattedDate, person, blog);

            blogDAO.addCommentBlog(c, blog, person);

            doGet(request, response);

        } catch (Exception e) {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
