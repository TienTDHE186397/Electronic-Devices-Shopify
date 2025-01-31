/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.DAOPerson;
import DAO.MyOrderDAO;
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
        // Lấy bài Blog theo ID
        BlogListDAO blogDAO = new BlogListDAO();
        String id_raw = request.getParameter("id");
        List<Blog> listRB;
        MyOrderDAO mDAO = new MyOrderDAO();
        // Lấy Bài Blog Theo ID và Comment Blog 
        try {
            int id = Integer.parseInt(id_raw);
            Blog blog = blogDAO.getBlogById(id);
            listRB = blogDAO.getRelatedBlog(blog);
            // Lấy Comment Blog
            List<CommentBlog> listC = blogDAO.getAllCommetFromBlog(id);
            // Lấy Ảnh Của Tác Giả
            String imgAuthor = mDAO.getImgByPersonID(String.valueOf(blog.getPerson().getPersonID()));

            List<String> listI = new ArrayList<>();
            for (int i = 0; i < listC.size(); i++) {
                listI.add(mDAO.getImgByPersonID(String.valueOf(listC.get(i).getPerson().getPersonID())));
            }

            // Tăng Views Blogs
            blogDAO.increaseViewBlog(blog);
            request.setAttribute("imgAuthor", imgAuthor);
            request.setAttribute("listImg", listI);
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
        // Lấy comment của người dùng và id của trang web
        String comment = request.getParameter("comment");
        String id_raw = request.getParameter("id");

        try {
            // Convert sang int
            int id = Integer.parseInt(id_raw);
            // Lấy thời gian của ngày commnet
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            BlogListDAO blogDAO = new BlogListDAO();
            DAOPerson perDAO = new DAOPerson();
            // Tạo session và lấy session của người dùng 
            HttpSession session = request.getSession();
            Blog blog = blogDAO.getBlogById(id);
            Person p = (Person) session.getAttribute("user");
            Person person = perDAO.getPersonById(String.valueOf(p.getPersonID()));
            // Lấy tất cả bài đăng
            List<Blog> list = blogDAO.getAllBlog();
            // Tạo Commnent Blog Mới
            CommentBlog c = new CommentBlog(list.get(list.size() - 1).getBlogID() + 1, comment, formattedDate, person, blog);
            // Thêm comment vào database
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
