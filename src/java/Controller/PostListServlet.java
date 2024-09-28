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

@WebServlet(name = "PostListServlet", urlPatterns = {"/PostListMKT"})
public class PostListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BlogListDAO blogDAO = new BlogListDAO();

        PrintWriter out = response.getWriter();
        String tittlewrite = request.getParameter("tittlewrite");
        String authorwrite = request.getParameter("authorwrite");
        String type = request.getParameter("type");
        String statusf = request.getParameter("statusf");
        String sort = request.getParameter("sort");
        String statuss = request.getParameter("statuss");

        if (tittlewrite == null && authorwrite == null && type == null && statusf == null && sort == null && statuss == null) {

            List<Blog> listB = blogDAO.getAllBlog();
            List<String> listBlogType = blogDAO.getDistinctOfBlogType();

            request.setAttribute("listB", listB);
            request.setAttribute("listBlogType", listBlogType);

            request.getRequestDispatcher("PostList.jsp").forward(request, response);

        } else {
            try {

                List<Blog> listB = blogDAO.searchBlogList(tittlewrite, authorwrite, type, statusf,sort);
                List<String> listBlogType = blogDAO.getDistinctOfBlogType();

                request.setAttribute("listB", listB);
                request.setAttribute("listBlogType", listBlogType);

            
                 request.getRequestDispatcher("PostList.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
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
