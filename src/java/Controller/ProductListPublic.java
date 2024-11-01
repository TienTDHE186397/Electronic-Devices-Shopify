/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Entity.Product;
import DAO.CategoryDAO;
import Entity.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.ProductDAOPublic;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dokkuhai
 */
public class ProductListPublic extends HttpServlet {
   
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
        //Init Data Access Object Package
        ProductDAOPublic pDao = new ProductDAOPublic();
        CategoryDAO cDao = new CategoryDAO();
//==============================================================================
        //Get Value from URI webpage
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        
        String category = request.getParameter("category");
        String quantity_product = request.getParameter("numberOfProducts");
        String indexPage = request.getParameter("page");
        String searchProduct = request.getParameter("search_product");
        String sort = request.getParameter("sort");
        //Default Value
        int cate=0;
        int quantity = 4;
        if (indexPage == null) {
                indexPage = "1";
            }
        if(sort == null){
            sort = "releaseDate DESC" ;
        }

        // Process data received from query
        if(category !=null){
            cate = Integer.parseInt(category);
        }
       
        
        if(quantity_product != null){
            quantity = Integer.parseInt(quantity_product);
        }
        
        int index = Integer.parseInt(indexPage);
           
//==============================================================================

    // Get Hot product by Sale percent
    List<Product> listProductTop = pDao.getTop4Product();
    request.setAttribute("hot_product", listProductTop);

//==============================================================================
        // Get all category
    List<Categories> listCategory = cDao.getAllCategory();
    

//==============================================================================

 /**********************************Paging******************************/

    List<Product> listP = pDao.pagingProductByCategory1(index, cate,quantity,sort,searchProduct);

    int count = pDao.getTotalProduct(cate, searchProduct);
    int endPage = count / quantity;
    if (count % quantity != 0) {
        endPage += 1;
    }

 //==============================================================================
        //Send data request to jsp page
        /* Send uri and query to webpage when send request to servlet*/
        request.setAttribute("uri", uri);
        request.setAttribute("queryString", queryString);
        
        /* Send list catgory to webpage */
        request.setAttribute("listCategory", listCategory);
        
        /* Send list product to webpage and total page*/
        
        request.setAttribute("list_P", listP);
        request.setAttribute("endP", endPage);
//==============================================================================
        // Forward to JSP Page 
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
