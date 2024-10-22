/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Cart;

import DAO.CardDAO;
import DAO.DAOProduct;
import Entity.Cart;
import Entity.Person;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardDAO cd = new CardDAO();
        DAOProduct pd = new DAOProduct();
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        Product pro = pd.getProductById(productID);
        HttpSession session = request.getSession();
        session.getAttribute("user");
        System.out.println(session.getAttribute("user"));   
        Person user = (Person) session.getAttribute("user");
        System.out.println("HAHAHHA: " + user);
//        int personId = user.getPersonID();
//        System.out.println(personId);
        Cart cart = cd.getCartByPersonId(user.getPersonID());
        System.out.println(cart);
        if (cart == null) {
            cart = new Cart();
            cart.setPersonID(user.getPersonID());
            cd.createCart(cart);
        }

        request.setAttribute("pro", pro);
        request.getRequestDispatcher("cart.jsp").forward(request, response);

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int productId = Integer.parseInt(request.getParameter("ProductId"));
//        ystem.out.println("ProductID" + productID);
//        System.out.println(productID);
//        Product product = productDAO.selectProductById(productId);
//        if (product != null) {
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//
//            if (cart == null) {
//                cart = new Cart();
//                session.setAttribute("cart", cart);
//            }
//
//            cart.addItem(product, quantity);
//        }
//
//        response.sendRedirect("cart");
//    }
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
