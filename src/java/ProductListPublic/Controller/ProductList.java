/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package ProductListPublic.Controller;

import Entity.Product;
import DAO.CategoryDAO;
import Entity.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ProductListPublic.DAO.ProductDAO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dokkuhai
 */
public class ProductList extends HttpServlet {
   
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
            out.println("<title>Servlet ProductList</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductList at " + request.getContextPath () + "</h1>");
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
//==============================================================================
        ProductDAO pDao = new ProductDAO();
        CategoryDAO cDao = new CategoryDAO();
//==============================================================================
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        request.setAttribute("uri", uri);
        request.setAttribute("queryString", queryString);
        String category = request.getParameter("category");
        int cate=0;
        if(category !=null){
            cate = Integer.parseInt(category);
        }
        String quantity_product = request.getParameter("numberOfProducts");
        int quantity = 4;
        if(quantity_product != null){
            quantity = Integer.parseInt(quantity_product);
        }
        
        String indexPage = request.getParameter("page");
        if (indexPage == null) {
                indexPage = "1";
            }
        int index = Integer.parseInt(indexPage);
//==============================================================================

        

//------------------------------------------------------------------------------

        
    List<Product> listProductTop = pDao.getTop4Product();
    request.setAttribute("hot_product", listProductTop);

//==============================================================================
    List<Categories> listCategory = cDao.getAllCategory();
    request.setAttribute("listCategory", listCategory);

//==============================================================================

 /**********************************Paging******************************/
            
            List<Product> listP = pDao.pagingProductByCategory(index, cate,quantity);
            int count = pDao.getTotalProductByCatetory(cate);
            int endPage = count / quantity;
            if (count % quantity != 0) {
                endPage += 1;
            }
            request.setAttribute("list_P", listP);
            request.setAttribute("endP", endPage);
//==============================================================================
        request.getRequestDispatcher("ProductListPublic.jsp").forward(request, response);
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

}
