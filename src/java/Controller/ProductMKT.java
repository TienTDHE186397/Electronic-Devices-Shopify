package Controller;

import DAO.CategoryDAO;

import DAO.ProductListDAO;
import Entity.Categories;

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

@WebServlet(name = "ProductMKT", urlPatterns = {"/ProductMKT"})
public class ProductMKT extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductMKT</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductMKT at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductListDAO plDao = new ProductListDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> listP = plDao.getAllProduct();
        List<Categories> listCategory = categoryDAO.getAllCategory();

        request.setAttribute("listP", listP);
        request.setAttribute("listCategory", listCategory);

        request.getRequestDispatcher("productList.jsp").forward(request, response);

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
