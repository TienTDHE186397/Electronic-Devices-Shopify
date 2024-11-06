/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.SliderListDAO;
import Entity.Slider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;

@WebServlet(name = "SliderListServlet", urlPatterns = {"/SliderListMKT"})
public class SliderListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SliderListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SliderListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("search");
        String status = request.getParameter("status");

        String numberofpage = request.getParameter("numberofpage");
        String[] col = request.getParameterValues("col");
        SliderListDAO sDAO = new SliderListDAO();
        String page = request.getParameter("page");

        request.setAttribute("nof", numberofpage);
        request.setAttribute("search", search);

        if (page == null || page.isBlank()) {
            page = "1";
        }
        if (col != null) {
            for (int i = 0; i < col.length; i++) {
                request.setAttribute(col[i], col[i]);
            }
            
        }
        if (numberofpage != null) {
            if (numberofpage.isBlank() || numberofpage.matches("0+")) {
                numberofpage = String.valueOf(sDAO.getAllSlider().size());
            }
        }
        
        
        

        if (search != null && status != null && (numberofpage != null && !numberofpage.isEmpty())) {
            List<Slider> listS = sDAO.searchSlider(search, status, Integer.parseInt(page), Integer.parseInt(numberofpage));
            List<Slider> list = sDAO.getAllSlider();
            List<Slider> listM = sDAO.searchSlider(search, status, 1, list.size());

            int totalpage = (int) Math.ceil((double) listM.size() / Integer.parseInt(numberofpage));
            request.setAttribute("totalpage", String.valueOf(totalpage));
            request.setAttribute("list", list);
            request.setAttribute("listS", listS);
            request.getRequestDispatcher("SliderList.jsp").forward(request, response);

        } else {
            List<Slider> listS = sDAO.getAllSlider();
            request.setAttribute("listS", listS);
            request.getRequestDispatcher("SliderList.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
