/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.HeadPhoneDAO;
import DAO.LaptopDAO;
import DAO.MonitorDAO;
import DAO.PcDAO;
import DAO.PhoneDAO;
import DAO.ProductListDAO;
import Entity.Categories;
import Entity.HeadPhone;
import Entity.Laptop;
import Entity.Monitor;
import Entity.PC;
import Entity.Phone;
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
        PhoneDAO phoneDao = new PhoneDAO();
        PcDAO pcDao = new PcDAO();
        MonitorDAO monitorDao = new MonitorDAO();
        LaptopDAO laptopDao = new LaptopDAO();
        HeadPhoneDAO headPhoneDAO = new HeadPhoneDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> listP = plDao.getAllProduct();
        List<Phone> listPhone = phoneDao.getAllPhone();
        List<PC> listPc = pcDao.getAllPC();
        List<Monitor> listMonitor = monitorDao.getAllMonitor();
        List<Laptop> listLaptop = laptopDao.getAllLaptop();
        List<HeadPhone> listHeadPhone = headPhoneDAO.getAllHeadPhone();
        List<Categories> listCategory = categoryDAO.getAllCategory();

        request.setAttribute("listP", listP);
        request.setAttribute("listPhone", listPhone);
        request.setAttribute("listPc", listPc);
        request.setAttribute("listMonitor", listMonitor);
        request.setAttribute("listLaptop", listLaptop);
        request.setAttribute("listHeadPhone", listHeadPhone);
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
