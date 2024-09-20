/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.SaleEmpDAO;
import Entity.OrderByDay;
import Entity.OrderStatus;
import Entity.SaleHomeOrder;
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
@WebServlet(name="SaleHomeEmp", urlPatterns={"/SaleHomeEmp"})
public class SaleHomeEmpServlet extends HttpServlet {
   
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
            out.println("<title>Servlet SaleHomeEmpServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaleHomeEmpServlet at " + request.getContextPath () + "</h1>");
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
       
         
         
        int SaleID = Integer.parseInt(request.getParameter("SaleID"));
       
        int totalCount = saleEmpDAO.getTotalOrderCount(SaleID);
        
        List<SaleHomeOrder> list = saleEmpDAO.getOrderS(SaleID);
        
        List<OrderByDay> odbList = saleEmpDAO.getCompletedOrdersByDayOfWeekS(SaleID);
        
        
        List<OrderStatus> orderStatusList = saleEmpDAO.getOrderCountByStatusS(SaleID);

        
        String[] statusList = new String[orderStatusList.size()];
        Integer[] countList = new Integer[orderStatusList.size()];

        int i = 0;
        for (OrderStatus orderStatus : orderStatusList) {
            statusList[i] = orderStatus.getStatus();
            countList[i] = orderStatus.getCount();
            
            i++;
        }

        request.setAttribute("data", list);
        request.setAttribute("statusList", statusList);
        request.setAttribute("countList", countList);
        request.setAttribute("ordersByDay", odbList);
        request.setAttribute("totalCount", totalCount);

       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SaleHomeEmp.jsp");
        dispatcher.forward(request, response);
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
//public static void main(String[] args){
//    
//    SaleEmpDAO s = new SaleEmpDAO();
//    int testId = 6;
//    
//    List<OrderByDay> o = s.getCompletedOrdersByDayOfWeekS(testId);
//    System.out.println("Orders by Day of Week:");
//    if(o.isEmpty()){
//        System.out.println("not found");
//    }else{
//        for(OrderByDay order : o){
//            System.out.println(order.getDayOfWeek() + ": " + order.getCompletedOrders());
//    }
//    
//}
//}
}
