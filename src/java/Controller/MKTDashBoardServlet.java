/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.ProductListDAO;
import Entity.Blog;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MKTDashBoardServlet", urlPatterns = {"/mktdashboard"})
public class MKTDashBoardServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MKTDashBoardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MKTDashBoardServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BlogListDAO bDAO = new BlogListDAO();
        ProductListDAO pDAO = new ProductListDAO();

        String fromdate = request.getParameter("fromdate");
        String todate = request.getParameter("todate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();

        if (fromdate == null || fromdate.isBlank()) {
            LocalDate previousDate = currentDate.minusDays(7);
            fromdate = previousDate.format(formatter);
        }
        if (todate == null || todate.isBlank()) {
            todate = currentDate.format(formatter);
        }
        
        // List Blog and Blog(FromDate -> ToDate)
        List<Blog> listAllBlog = bDAO.getAllBlog();
        List<Blog> listB = bDAO.getBlogMKTDashBoard(fromdate, todate);
        request.setAttribute("listAllBlog", listAllBlog);
        request.setAttribute("listB", listB);
        
        //List All Product and Product(FromDate -> ToDate)
        List<Product> listAllProduct = pDAO.getAllProduct();
        List<Product> listP = pDAO.getProductMKTDashBoard(fromdate, todate);
        
        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("mktdashboard.jsp").forward(request, response);
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
