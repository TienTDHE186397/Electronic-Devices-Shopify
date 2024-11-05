/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DAOCustomer;
import DAO.HistoryChangeDAO;
import Entity.HistoryChange;
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
 * @author Dokkuhai
 */
@WebServlet(name="CustomerDetail", urlPatterns={"/customer-detail"})
public class CustomerDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerDetail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerDetail at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        int cusid = Integer.parseInt(id);
        DAOCustomer customerDAO = new DAOCustomer();
        HistoryChangeDAO historyDAO = new HistoryChangeDAO();
        Person customer = customerDAO.getPersonById(cusid);
        List<HistoryChange> historyList = null;
//======================================================================         
        int pageIndex = 1; // Mặc định là trang 1
            if (request.getParameter("page") != null) {
                pageIndex = Integer.parseInt(request.getParameter("page"));
            }
        int pageSize = 10; // Số bản ghi trên mỗi trang
        
         // Lấy danh sách lịch sử thay đổi
        historyList = historyDAO.getHistoryChangesByPage(cusid, pageIndex, pageSize);
        
        // Tính tổng số bản ghi
        int totalCount = historyDAO.getTotalHistoryChangesCount(cusid);
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);
        request.setAttribute("historyList", historyList);
        request.setAttribute("customerDetail", customer);
        request.setAttribute("currentPage", pageIndex);
        request.setAttribute("totalPages", totalPages);
//=======================================================================
        request.getRequestDispatcher("CustomerDetail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
