/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CalendarDAO;
import DAO.DAO;
import Entity.Account;
import Entity.Calendar;
import Entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AddToCartController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            String pid = request.getParameter("pid");
            String slot = request.getParameter("slot");
            int numticket = Integer.parseInt(request.getParameter("numticket"));
            String mess = "";
            DAO dao = new DAO();
            List<Product> listp = dao.getProductBypid(pid);
            CalendarDAO cdao = new CalendarDAO();
            List<Calendar> listca = cdao.getCalendarBypid(pid);
            CalendarDAO cadao = new CalendarDAO();
            Calendar caorder = cadao.get1CalendarBypid(pid);
            if (acc != null) {
                Product porder = dao.get1ProductBypid(pid);
                
                session.setAttribute("caorder", caorder);
                session.setAttribute("porder", porder);
                session.setAttribute("slotoder", slot);
                session.setAttribute("numticketoder", numticket);
                response.sendRedirect("MovieSeat.jsp");
            } else {
                mess = "Bạn Chưa Đặng Nhập! Hãy Đăng Nhập Để Tiếp Tục";
                request.setAttribute("listca", listca);
                request.setAttribute("listp", listp);
                request.setAttribute("listp", listp);
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("ProductDetailwValidCheck.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            String pid = request.getParameter("pid");
            String mess = "Vui lòng nhập số lượng vé hợp lệ";
            DAO dao = new DAO();
            List<Product> listp = dao.getProductBypid(pid);
            CalendarDAO cdao = new CalendarDAO();
            List<Calendar> listca = cdao.getCalendarBypid(pid);
            request.setAttribute("listca", listca);
            request.setAttribute("listp", listp);
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("ProductDetailwValidCheck.jsp").forward(request, response);
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
