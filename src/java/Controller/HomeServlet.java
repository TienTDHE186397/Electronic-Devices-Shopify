/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.ProductDAO;
import DAO.SliderListDAO;
import Entity.Blog;
import Entity.Product;
import Entity.Slider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 
 * @author Vu Duc Hai
 * 
 * This Servlet resolve request on homepage, include session of user........
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet{
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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        ProductDAO pDao = new ProductDAO();
        
        
//==============================================================================\

    /* Session or any other servlet please write here */
        
    String category = request.getParameter("cateid");
    int cateId = 0;
    if(category != null){
        cateId = Integer.parseInt(category);
    }
    String brand =  request.getParameter("brand");
//==============================================================================
/*____________ ProductDAO ----> Homeservlet -----> Home.jsp _________________ */
        List<String> listBPhoneAndTablet = pDao.getBrandByCategory(1);
        List<Product> listPhoneAndTablet = pDao.getProductByCategory(1);
        if(cateId == 1 && brand.equals("all") == false){
            listPhoneAndTablet = pDao.getProductByBrand(cateId, brand);
        }
        request.setAttribute("list_phone_and_tablet", listPhoneAndTablet);
        request.setAttribute("brand_phone_and_tablet", listBPhoneAndTablet);
        
//------------------------------------------------------------------------------

        List<String> listBLaptop = pDao.getBrandByCategory(2);
        List<Product> listLaptop = pDao.getProductByCategory(2);
        if(cateId == 2 && brand.equals("all") == false){
            listLaptop = pDao.getProductByBrand(cateId, brand);
        }
        request.setAttribute("list_laptop", listLaptop);
        request.setAttribute("brand_laptop", listBLaptop);
        
//------------------------------------------------------------------------------

        List<String> listBPc = pDao.getBrandByCategory(3);
        List<Product> listPc = pDao.getProductByCategory(3);
        if(cateId == 3 && brand.equals("all") == false){
            listPc = pDao.getProductByBrand(cateId, brand);
        }
        request.setAttribute("list_pc", listPc);
        request.setAttribute("brand_pc", listBPc);
        
//------------------------------------------------------------------------------
        List<String> listBMonitor = pDao.getBrandByCategory(4);
        List<Product> listMonitor = pDao.getProductByCategory(4);
        if(cateId == 4 && brand.equals("all") == false){
            listMonitor = pDao.getProductByBrand(cateId, brand);
        }
        request.setAttribute("list_monitor", listMonitor);
        request.setAttribute("brand_monitor", listBMonitor);
        
//------------------------------------------------------------------------------

        List<String> listBHeadphone = pDao.getBrandByCategory(5);
        List<Product> listHeadphone = pDao.getProductByCategory(5);
        if(cateId == 5 && brand.equals("all") == false){
            listHeadphone = pDao.getProductByBrand(cateId, brand);
        }
        request.setAttribute("list_headphone", listHeadphone);
        request.setAttribute("brand_headphone", listBHeadphone);
//------------------------------------------------------------------------------
        //Slider
        SliderListDAO slDAO = new SliderListDAO();
        List<Slider> list_slider = slDAO.getAllSliderPublished();
        request.setAttribute("listSlider", list_slider);
        
//------------------------------------------------------------------------------
    //Latest Post
        BlogListDAO blogDAO = new BlogListDAO();
        List<Blog> listBlog = blogDAO.getLatestBlog();
        request.setAttribute("lBlog", listBlog);
//==============================================================================
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        return;
        
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
