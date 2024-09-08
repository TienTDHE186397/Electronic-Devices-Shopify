/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CalendarDAO;
import DAO.DAO;
import Entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AddProductControl extends HttpServlet {

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
        // Retrieve parameters from request
        String mname = request.getParameter("name");
        String mgenre = request.getParameter("genre");
        String mdirector = request.getParameter("director");
        String mperformer = request.getParameter("performer");
        String mprice = request.getParameter("price");
        String mage = request.getParameter("age");
        String mimage = request.getParameter("image");
        String mbanner = request.getParameter("banner");
        String mdescription = request.getParameter("description");
        String mview = request.getParameter("view");
        String mtime = request.getParameter("time");
        String mdate = request.getParameter("date");
        int msold = Integer.parseInt(request.getParameter("sold"));
        int mcategoryid = Integer.parseInt(request.getParameter("categoryid"));
        int mstatus = Integer.parseInt(request.getParameter("status"));
        int mcinema = Integer.parseInt(request.getParameter("cinema"));

        // Retrieve manager ID from session
//    HttpSession session = request.getSession();
//    Account a = (Account) session.getAttribute("acc");
//    int cid = a.getID();
        // Instantiate DAO and insert movie
        DAO dao = new DAO();
        dao.insertMovie(mname, mgenre, mdirector, mperformer, mprice, mage, mimage, mbanner, mdescription, mview, mtime, mdate, msold, mcategoryid, mcinema);
        Product lastadd = dao.getLastAddProduct();
        CalendarDAO cdao = new CalendarDAO();
        cdao.InsertNewCalendarByPid(lastadd.getProductId(), mcinema);
        
        response.sendRedirect("manager");
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
