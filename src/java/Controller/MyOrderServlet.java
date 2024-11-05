/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.MyOrderDAO;
import Entity.MyOrder;
import Entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
@WebServlet(name = "MyOrderServlet", urlPatterns = {"/MyOrder"})
public class MyOrderServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyOrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // Lấy personID từ session thay vì parameter

        HttpSession session = request.getSession();
        Person user = (Person) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
            return;
        }

        // Lấy PersonID từ đối tượng Person và chuyển thành String
        String personID = String.valueOf(user.getPersonID());
        String PersonImg = null;
       

        MyOrderDAO dao = new MyOrderDAO();
        List<MyOrder> orderList = dao.getOrderByPersonID(personID);
        PersonImg = dao.getImgByPersonID(personID);
        // Lấy danh sách sản phẩm cho mỗi đơn hàng
       // Map để lưu danh sách sản phẩm của từng đơn hàng
        Map<String, List<MyOrder>> orderProducts = new HashMap<>();
        
        // Lấy sản phẩm cho từng đơn hàng
        for (MyOrder order : orderList) {
            List<MyOrder> products = dao.getProductListByOrderID(personID, order.getOrderID());
            orderProducts.put(order.getOrderID(), products);
        }
         request.setAttribute("pimg", PersonImg);
         request.setAttribute("orderList", orderList);
         request.setAttribute("orderProducts", orderProducts);
            request.getRequestDispatcher("/MyOrder.jsp").forward(request, response);

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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

            processRequest(request, response);

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
 

    public static void main(String[] args) {
        MyOrderDAO dao = new MyOrderDAO();
        String PersonID = "1";
        String OrderID = "1";
        List<MyOrder> list = dao.getOrderByPersonID(PersonID);
        for (MyOrder o : list) {
            System.out.println(o);
        }
    }
}
