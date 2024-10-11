/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Orders;
import DAO.DAOAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author nghie
 */
@WebServlet(name = "ChartServlet", urlPatterns = {"/chart"})
public class ChartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOAdmin da = new DAOAdmin();
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        int allCustomer = da.getAllCustomers();
        List<Orders> list = da.getOrder();
        int allOrders = da.getAllOrder();
        int successOrders = da.getSuccessOrder();
        int cancelOrders = da.getCancelOrder();
        int shipOrders = da.getShipOrder();
        int sumRevenue = da.TotalRevenue();
        int newRegister = da.NewRegister();
        int newPurchaser = da.NewPurchaser();
        double avgRate = da.Rate();
        int Cate1 = da.getRevenueByCategory(1);
        int Cate2 = da.getRevenueByCategory(2);
        int Cate3 = da.getRevenueByCategory(3);
        int Cate4 = da.getRevenueByCategory(4);
        int Cate5 = da.getRevenueByCategory(5);
        int Rate1 = da.RateCount(1.0);
        int Rate2 = da.RateCount(2.0);
        int Rate3 = da.RateCount(3.0);
        int Rate4 = da.RateCount(4.0);
        int Rate5 = da.RateCount(5.0);
        int comment = da.TotalComment();
        request.setAttribute("allCustomer", allCustomer);
        request.setAttribute("list", list);
        request.setAttribute("allOrders", allOrders);
        request.setAttribute("successOrders", successOrders);
        request.setAttribute("cancelOrders", cancelOrders);
        request.setAttribute("shipOrders", shipOrders);
        request.setAttribute("sumRevenue", sumRevenue);
        request.setAttribute("newRegister", newRegister);
        request.setAttribute("newPurchaser", newPurchaser);
        request.setAttribute("avgRate", avgRate);
        request.setAttribute("comment", comment);
        request.setAttribute("Cate1", Cate1);
        request.setAttribute("Cate2", Cate2);
        request.setAttribute("Cate3", Cate3);
        request.setAttribute("Cate4", Cate4);
        request.setAttribute("Cate5", Cate5);
        request.setAttribute("Rate1", Rate1);
        request.setAttribute("Rate2", Rate2);
        request.setAttribute("Rate3", Rate3);
        request.setAttribute("Rate4", Rate4);
        request.setAttribute("Rate5", Rate5);
        request.getRequestDispatcher("Chart.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
