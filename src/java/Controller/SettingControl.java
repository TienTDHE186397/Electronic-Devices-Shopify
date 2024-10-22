/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Setting;
import DAO.DAOSetting;
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
@WebServlet(name = "SettingControl", urlPatterns = {"/settingControl"})
public class SettingControl extends HttpServlet {

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
        DAOSetting ds = new DAOSetting();
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        List<Setting> listS = ds.searchSetting(search, type, status);
        if ((search == null||search.isEmpty()) && (type == null||type.isEmpty()) && (status == null||status.isEmpty())) {
            int count = ds.getTotalSettings();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            String pageStr = request.getParameter("page");
            if (pageStr == null) {
                pageStr = "1";
            }
            int page = Integer.parseInt(pageStr);
            List<Setting> list = ds.pagingSetting(page);
            request.setAttribute("endPage", endPage);
            request.setAttribute("list", list);
            request.getRequestDispatcher("settingList").forward(request, response);
        } else {
            request.setAttribute("list", listS);
            request.getRequestDispatcher("SettingList.jsp").forward(request, response);
        }
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
