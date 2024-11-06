/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Orders;
import DAO.DAOAdmin;
import Entity.Person;
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
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

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

        List<Orders> listS = null;

        response.setContentType("text/html;charset=UTF-8");
        DAOAdmin da = new DAOAdmin();
        String id = request.getParameter("PersonID");
        Person p = da.getPersonById(id);
        String search = request.getParameter("search");
        String status = request.getParameter("status");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<Orders> list = da.getOrder();

        try {
            if (startDate != null && endDate != null) {
                listS = da.searchOrders(search, status, startDate.substring(0, 10), endDate.substring(0, 10));

            } else {
                listS = da.searchOrders(search, status, startDate, endDate);
            }

        } catch (Exception e) {
            listS = da.searchOrders(search, status, startDate, endDate);
        }
        int allCustomer = da.getAllCustomers();
        int allOrders = da.getAllOrder();
        int successOrders = da.getSuccessOrder();
        int cancelOrders = da.getCancelOrder();
        int shipOrders = da.getShipOrder();
        int sumRevenue = da.TotalRevenue();
        int newRegister = da.NewRegister();
        int newPurchaser = da.NewPurchaser();
        int Cate1 = da.getRevenueByCategory(1);
        int Cate2 = da.getRevenueByCategory(2);
        int Cate3 = da.getRevenueByCategory(3);
        int Cate4 = da.getRevenueByCategory(4);
        int Cate5 = da.getRevenueByCategory(5);
        double Rate1 = da.getRateByCategory(1);
        double Rate2 = da.getRateByCategory(2);
        double Rate3 = da.getRateByCategory(3);
        double Rate4 = da.getRateByCategory(4);
        double Rate5 = da.getRateByCategory(5);
        double avgRate = da.Rate();
        int comment = da.TotalComment();
        request.setAttribute("person", p);
        request.setAttribute("allCustomer", allCustomer);
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
        if (search == null && status == null && startDate == null && endDate == null) {
            request.setAttribute("list", list);
            request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("list", listS);
            request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
        }
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
