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
        BlogListDAO blogDAO = new BlogListDAO();
        String id_raw = request.getParameter("id");
        List<Blog> listRB;
        String flag_raw = request.getParameter("flag");

        if (flag_raw != null) {

            try {

                int id = Integer.parseInt(flag_raw);
                Blog blog = blogDAO.getBlogById(id);
                blogDAO.changeBlogFlag(blog);
                listRB = blogDAO.getRelatedBlog(blog);
                request.setAttribute("blog", blog);
                request.setAttribute("listRB", listRB);
                response.sendRedirect("PostDetail?id=" + id);
            } catch (Exception e) {

            }

        } else {
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
