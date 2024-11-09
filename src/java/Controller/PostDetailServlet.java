/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import Entity.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;

@WebServlet(name = "PostDetailServlet", urlPatterns = {"/PostDetail"})
public class PostDetailServlet extends HttpServlet {

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
        // Lấy Id Blog
        BlogListDAO blogDAO = new BlogListDAO();
        String id_raw = request.getParameter("id");
        // Gọi đến bài đăng liên quan (related Blog)
        List<Blog> listRB;
        // Lấy giá trị của cờ 0 hoặc 1
        String flag_raw = request.getParameter("flag");
        // Nếu như thay đổi cờ của bài đăng thì thực hiện yêu cầu dưới
        if (flag_raw != null) {
            try {
                // Lấy ID của flag
                int id = Integer.parseInt(flag_raw);
                // Lấy Blog Detail Bằng ID truyền Vào
                Blog blog = blogDAO.getBlogById(id);
                // Thay đổi cờ của bài đăng
                blogDAO.changeBlogFlag(blog);
                // Lấy các bài đăng liên quan
                listRB = blogDAO.getRelatedBlog(blog);
                request.setAttribute("blog", blog);
                request.setAttribute("listRB", listRB);
                response.sendRedirect("PostDetail?id=" + id);
            } catch (Exception e) {
            }
        } else {
            // Thực hiện yêu cầu nếu flag nhận vào không = null
            try {
                int id = Integer.parseInt(id_raw);
                Blog blog = blogDAO.getBlogById(id);
                listRB = blogDAO.getRelatedBlog(blog);
                request.setAttribute("blog", blog);
                request.setAttribute("listRB", listRB);
                request.getRequestDispatcher("PostDetail.jsp").forward(request, response);

            } catch (Exception e) {
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
