/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.CategoryDAO;
import DAO.PersonDAO;
import Entity.Blog;
import Entity.Categories;
import Entity.Product;
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

@WebServlet(name = "addPostServlet", urlPatterns = {"/addPost"})
public class addPostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addPostServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addPostServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BlogListDAO blogDAO = new BlogListDAO();

        List<String> listBlogType = blogDAO.getDistinctOfBlogType();

        request.setAttribute("listType", listBlogType);

        request.getRequestDispatcher("addPost.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();

        String blog_type = request.getParameter("blogtype");
        String blog_image = request.getParameter("blogimg");
        String blog_tittle = request.getParameter("blogtittle");
        String blog_summary = request.getParameter("blogsummary");
        String blog_detail = request.getParameter("blogdetail");
        String blog_status = request.getParameter("blogstatus");
        
        

                   Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            out.println(paramName + ": " + request.getParameter(paramName) + "<br>");
        }
        
        


        out.println("Blog Type: " + blog_type);
        out.println("Blog Title: " + blog_tittle);
        out.println("Blog Summary: " + blog_summary);
        out.println("Blog Detail: " + blog_detail);
        out.println("Blog Status: " + blog_status);

//            LocalDate currentDate = LocalDate.now();
//             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formattedDate = currentDate.format(formatter);
//             
////        HttpSession session = request.getSession();
//            PersonDAO perDAO = new PersonDAO();
//                BlogListDAO blogDAO = new BlogListDAO();
//                List<Blog> list = blogDAO.getAllBlog();
//            Blog b = new Blog(list.size() + 1,
//                    blog_image, 
//                    blog_tittle,
//                    blog_type,
//                    blog_summary,
//                    formattedDate,
//                    blog_detail,
//                    0 ,
//                    blog_status,
//                    person);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
