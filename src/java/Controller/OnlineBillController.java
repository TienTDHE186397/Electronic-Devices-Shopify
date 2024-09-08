/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.OrderDAO;
import DAO.WalletDAO;
import Entity.Account;
import Entity.Calendar;
import Entity.Product;
import Entity.Wallet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class OnlineBillController extends HttpServlet {

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
        int totalm = Integer.parseInt(request.getParameter("total"));
        HttpSession session = request.getSession();
        Wallet w = (Wallet) session.getAttribute("wallet");
        Account a = (Account) session.getAttribute("acc");
        Product p = (Product) session.getAttribute("porder");
        Calendar c = (Calendar) session.getAttribute("caorder");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedDate = currentDate.format(formatter);
        int ouderid = a.getID();
        String ousername = a.getUser();
        String oproductname = p.getProductName();
        int oroomid = c.getRoomId();
        int oquantityProduct = (int) session.getAttribute("numticketoder");
        int oquantityFood = getSessionAttribute(session, "f1order") + getSessionAttribute(session, "f2order");
        int oquantityDrink = getSessionAttribute(session, "d1order") + getSessionAttribute(session, "d2order");
        String ocinemaname = getCinemaName(p.getCinemaID());
        String omethod = "Online";
        if (totalm <= w.getBalance()) {
            WalletDAO dao = new WalletDAO();
            dao.onlinePayment(w.getUserid(), totalm);
            w.setBalance(w.getBalance() - totalm);
            OrderDAO orderdao = new OrderDAO();
            orderdao.insertOrder(formattedDate, ouderid, ousername, oproductname, oroomid, oquantityProduct, oquantityFood, oquantityDrink, ocinemaname, totalm, omethod);
            session.setAttribute("wallet", w);
            response.sendRedirect("Thankyou.jsp");
        } else {
            request.setAttribute("mess4u", "Số Dư Không Đủ Vui Lòng Nạp Thêm!");
            request.getRequestDispatcher("Bill.jsp").forward(request, response);
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

    private int getSessionAttribute(HttpSession session, String attributeName) {
        Integer attributeValue = (Integer) session.getAttribute(attributeName);
        return attributeValue != null ? attributeValue : 0;
    }

    private String getCinemaName(int cinemaId) {
        switch (cinemaId) {
            case 1:
                return "ALV Thanh Xuân";
            case 2:
                return "ALV Mỹ Đình";
            case 3:
                return "ALV Long Biên";
            case 4:
                return "ALV Hòa Lạc";
            default:
                return "Unknown Cinema";
        }
    }

}
