/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.ProductDAO;
import Entity.Cart;
import Entity.CartItem;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dokkuhai
 */
@WebServlet(name="AddToCartController", urlPatterns={"/cart"})
public class AddToCartController extends HttpServlet {
   
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
            out.println("<title>Servlet AddToCartController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartController at " + request.getContextPath () + "</h1>");
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
        ProductDAO pDao = new ProductDAO();
       String currentUrl = request.getRequestURI() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");  
        int quantity =1;
        int id;
        if(request.getParameter("ProductID")!=null){
            id = Integer.parseInt(request.getParameter("ProductID"));
            Product p = pDao.getProductsById(id);
            if(p!=null){
                if(request.getParameter("quantity") !=null){
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                HttpSession session = request.getSession();
                if(session.getAttribute("cart") == null){
                    Cart cart = new Cart();
                    List<CartItem> listItems = new ArrayList<>();
                    CartItem item = new CartItem();
                    item.setQuantity(quantity);
                    item.setProduct(p);
                    item.setPrice(p.getPrice());
                    listItems.add(item);
                    cart.setItems(listItems);
                    session.setAttribute("cart", cart);
                }else{
                    Cart cart = (Cart) session.getAttribute("cart");
                    List<CartItem> listItems = cart.getItems();
                    boolean check = false;
                    for(CartItem item:listItems){
                        if(item.getProduct().getProductID() == p.getProductID()){
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if(check ==false){
                        CartItem item = new CartItem();
                        item.setQuantity(quantity);
                        item.setProduct(p);
                        item.setPrice(p.getPrice());
                        listItems.add(item);
                    }
                    session.setAttribute("cart", cart);
                }
            }
            response.sendRedirect(request.getContextPath());
        }
        else{
            response.sendRedirect(request.getContextPath());
        }
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
