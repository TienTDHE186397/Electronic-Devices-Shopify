/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.CinemaDAO;
import DAO.DAO;
import Entity.Categories;
import Entity.Cinema;
import Entity.Product;
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
 * @author Admin
 */@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
   
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
        //get data from dao
        DAO dao = new DAO();
        CinemaDAO cinemaDAO = new CinemaDAO();
        //get sapchieu product
        List<Product> list = dao.getAllProduct();
        //Get top 3 Product Banner
        List<Product> listB = dao.getBannerProduct();
        Product p1 = listB.get(0);
        Product p2 = listB.get(1);
        Product p3 = listB.get(2);
        request.setAttribute("p1", p1);
        request.setAttribute("p2", p2);
        request.setAttribute("p3", p3);
        //Get categories product
        List<Categories> listC = dao.getAllCategories();
        //Get dangchieu Product
        List<Product> listdc = dao.getDangChieuProduct();
        //get commingsoon product
        List<Product> listcs = dao.getCommingsoonProduct();
        //get mostview product
        List<Product> listmv = dao.getMostViewProduct();
        //get dachieu product
        List<Product> listpdc = dao.getDaChieuProduct();
        //get list rap chieu
        List<Cinema> listCinema = cinemaDAO.getAllCinema();
        
        request.setAttribute("listpdc", listpdc);
        request.setAttribute("listmv", listmv);
        request.setAttribute("listcs", listcs);
        request.setAttribute("listd", listdc);
        request.getSession().setAttribute("listC", listC);
        request.getSession().setAttribute("listCinema", listCinema);
        request.setAttribute("listP", list);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        processRequest(request, response);
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
