/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.SaleDAO;
import Entity.OrderProduct;
import Entity.Person;

import Entity.SaleOrderL;

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
@WebServlet(name="OrderDetailsManager", urlPatterns={"/OrderDetailsManager"})
public class SaleOrderDetailsM extends HttpServlet {
   
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
            out.println("<title>Servlet SaleOrderDetailsM</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaleOrderDetailsM at " + request.getContextPath () + "</h1>");
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
    SaleDAO saleDAO = new SaleDAO();
    String orderID = request.getParameter("orderID");
    
    
    try {
        // Lấy chi tiết đơn hàng theo orderID
        List<SaleOrderL> orderDetails = saleDAO.getDetails(orderID);
        List<OrderProduct> orderProduct = saleDAO.getProDetails(orderID);
        List<SaleOrderL> updateL = saleDAO.getUpdate(orderID);
        List<Person> saleP = saleDAO.getAllSale();
        // Set thông tin vào request scope
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("orderProducts", orderProduct);
        request.setAttribute("upList", updateL);
        request.setAttribute("SaleList", saleP);
        
    }catch(NumberFormatException e){
        System.out.println(e);
    }
    
    
    
    // Tiếp tục xử lý các logic khác hoặc redirect về trang SaleOrderManager.jsp
request.getRequestDispatcher("OrderDetailsManager.jsp").forward(request, response);
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
         
    String orderID = request.getParameter("orderID");
    String status = request.getParameter("statusUpdate");
    String saleNotes = request.getParameter("saleNotes");
    String saleID = request.getParameter("salePerson");
    String shipstatus = request.getParameter("shipUpdate");

    SaleDAO updateDAO = new SaleDAO();
    try {
        SaleOrderL so = new SaleOrderL(orderID, saleNotes, saleID, status, shipstatus);
        updateDAO.Update(so);

//            response.getWriter().println(orderID);
//            response.getWriter().println(status);
//            response.getWriter().println(saleNotes);
//            response.getWriter().println(saleID);
//            response.getWriter().println(shipstatus);
        // Return a success response
        response.sendRedirect("SaleOrderManager?orderID=" + orderID + "&statusUpdate=success");

    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("failure: " + e.getMessage());
    }
    }

    
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
//     public static void main(String[] args) {
//        SaleDAO dao = new SaleDAO();
//        String id = "2";
//        List<SaleOrderL> list = dao.getUpdate(id);
//        for(SaleOrderL o : list){
//            System.out.println(o);
//        }
//    }

}
