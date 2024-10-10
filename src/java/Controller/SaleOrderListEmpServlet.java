/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.SaleEmpDAO;
import Entity.OrderStatus;
import Entity.SaleOrderL;
import jakarta.servlet.RequestDispatcher;
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
 * @author admin
 */
@WebServlet(name="SaleOrderEmp", urlPatterns={"/SaleOrderEmp"})
public class SaleOrderListEmpServlet extends HttpServlet {
   
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
            out.println("<title>Servlet SaleOrderListEmpServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaleOrderListEmpServlet at " + request.getContextPath () + "</h1>");
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
       SaleEmpDAO saleEmpDAO = new SaleEmpDAO();
       
        Integer SaleID = null;
        String saleIDParam = request.getParameter("SaleID");
//        int SaleID = Integer.parseInt(request.getParameter("SaleID"));
       if(saleIDParam != null && !saleIDParam.trim().isEmpty()){
           try{
               SaleID = Integer.parseInt(saleIDParam);
           }catch (NumberFormatException e){
               request.setAttribute("errorMessage", "Invalid SaleID");
               request.getRequestDispatcher("SaleOrderEmp.jsp").forward(request, response);
                   return;
           }
           } else{
                   request.setAttribute("errorMessage", "SaleID is required");
                   request.getRequestDispatcher("SaleOrderEmp.jsp").forward(request, response);
                   return;
                   }
      
        

        int totalOrderCount = saleEmpDAO.getTotalOrderCount(SaleID);
        
        String status = request.getParameter("status");
        // Lấy giá trị tìm kiếm từ request
        String searchQuery = request.getParameter("searchQuery");
        // Nếu không có tìm kiếm, redirect về trang SaleOrder.jsp
        
    
        List<SaleOrderL> list;
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // Nếu có searchQuery, lấy danh sách đơn hàng dựa trên tìm kiếm
            list = saleEmpDAO.searchOrdersS(searchQuery, SaleID);
        } else if (status != null && !status.isEmpty()) {
            // Nếu có status, lấy danh sách đơn hàng theo status
            list = saleEmpDAO.getOrderLByStatusS(status, SaleID);
        } else {
            // Nếu không có searchQuery và status, lấy toàn bộ danh sách đơn hàng
            list = saleEmpDAO.getOrderLS(SaleID);
        }
        
        List<OrderStatus> orderStatusList = saleEmpDAO.getOrderCountByStatusS(SaleID);
         
        

        
        String[] statusList = new String[orderStatusList.size()];
        Integer[] countList = new Integer[orderStatusList.size()];
        int i = 0;
        for (OrderStatus orderStatus : orderStatusList) {
            statusList[i] = orderStatus.getStatus();
            countList[i] = orderStatus.getCount();
            i++;
        }
        
        
        request.setAttribute("dataList", list);
        request.setAttribute("statusOrderList", statusList);
        request.setAttribute("countOrderList", countList);
        request.setAttribute("totalOrderCount", totalOrderCount);
       
        
       
      
        request.getRequestDispatcher("SaleOrderEmp.jsp").forward(request, response);
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
