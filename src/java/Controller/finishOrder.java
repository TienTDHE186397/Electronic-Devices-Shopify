/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOAdmin;
import DAO.MyOrderDAO;
import Email.MailSender;
import Entity.Banks;
import Entity.Cart;
import Entity.CartItem;
import Entity.OrderInformation;
import Entity.Person;
import Entity.Product;
import jakarta.servlet.ServletContext;
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
 * @author nghie
 */
@WebServlet(name = "finishOrder", urlPatterns = {"/finishOrder"})
public class finishOrder extends HttpServlet {

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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        MyOrderDAO mod = new MyOrderDAO();
        DAOAdmin da = new DAOAdmin();
        Cart cart = (Cart)session.getAttribute("cart");
        Person person = (Person)session.getAttribute("user");
        double total = 0;
        double totalMoney = 0;
        for(CartItem ci: cart.getItems()){
            total += ci.getPrice()*ci.getQuantity();  
        }
        totalMoney = total - (total/10) + 30000;
        String method = request.getParameter("method");
            boolean add = mod.addOrder(person.getPersonID(), 1, totalMoney, method, "In Line","Must be complete fast", "OrderNotComplete");
            int OrderID = da.getNewestOrderID()-1;
        for(CartItem ci: cart.getItems()){
            Product p = ci.getProduct();
            int pid = p.getProductID();
            int quantity = ci.getQuantity();
            double price = ci.getPrice();
            mod.addOrderDetail(OrderID, pid, 2, quantity, price, total);
        }    
        session.removeAttribute("cart");
        ServletContext context = request.getServletContext();
            List<Banks> banks = new ArrayList<>();
            banks.add(new Banks(context.getInitParameter("bankName1"), context.getInitParameter("AccountName"), context.getInitParameter("AccountNumber")));
            banks.add(new Banks(context.getInitParameter("bankName2"), context.getInitParameter("AccountName2"), context.getInitParameter("AccountNumber2")));
            banks.add(new Banks(context.getInitParameter("bankName3"), context.getInitParameter("AccountName3"), context.getInitParameter("AccountNumber3")));
            banks.add(new Banks(context.getInitParameter("bankName4"), context.getInitParameter("AccountName4"), context.getInitParameter("AccountNumber4")));
            String selectedBank = request.getParameter("selectedBank");
            Banks bank = new Banks();
            if (selectedBank != null && selectedBank.equals("MB Bank")) {
                bank = new Banks(context.getInitParameter("bankName1"), context.getInitParameter("AccountName"), context.getInitParameter("AccountNumber"));
            }
            if (selectedBank != null && selectedBank.equals("Vietcombank")) {
                bank = new Banks(context.getInitParameter("bankName2"), context.getInitParameter("AccountName2"), context.getInitParameter("AccountNumber2"));
            }
            if (selectedBank != null && selectedBank.equals("Vietinbank")) {
                bank = new Banks(context.getInitParameter("bankName3"), context.getInitParameter("AccountName3"), context.getInitParameter("AccountNumber3"));

            }
            if (selectedBank != null && selectedBank.equals("ABBank")) {
                bank = new Banks(context.getInitParameter("bankName4"), context.getInitParameter("AccountName4"), context.getInitParameter("AccountNumber4"));

            }
            String name = request.getParameter("name1");
            String phone = request.getParameter("phone1");
            String address = request.getParameter("address1");
            OrderInformation oi = new OrderInformation(OrderID, name, phone, address, method, "In line");
            request.setAttribute("selectedBank", selectedBank);
            request.setAttribute("banks", banks);
            MailSender.sendAccountBank(person.getEmail(), bank, oi, total);

        request.getRequestDispatcher("FinishOrder.jsp").forward(request, response);
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