/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.*;
import Email.MailSender;
import Entity.*;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nghie
 */
@WebServlet(name = "CartCompletion", urlPatterns = {"/cartCompletion"})
public class CartCompletion extends HttpServlet {

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
        DAOAdmin da = new DAOAdmin();
        if (session != null && session.getAttribute("cart") != null) {

            String id = request.getParameter("PersonID");

            Cart cart = (Cart) session.getAttribute("cart");
            Person person = (Person) session.getAttribute("user");
            Person p = new Person(person.getPersonID(),
                    person.getImage(),
                    person.getName(),
                    person.getGender(),
                    person.getDateOfBirth(),
                    LocalDate.MAX,
                    person.getAddress(),
                    person.getEmail(),
                    person.getPhone(),
                    person.getRoleID(), person.getPasword());
            double total = 0;
            for (CartItem cartitems : cart.getItems()) {
                double price = cartitems.getPrice();
                int quantity = cartitems.getQuantity();
                total+=price*quantity;
            }
            double amount = total - (total / 10) + 30000;
            cart.setPerson(p);
            MyOrderDAO mod = new MyOrderDAO();
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String paymentMethod = request.getParameter("payment");
            int OrderID = da.getNewestOrderID();
            OrderInformation oi = new OrderInformation(OrderID, name, phone, address, paymentMethod, "In line");
//            mod.createUpdateOrderDetailsProcedure();
//            mod.updateOrderDetails(person.getPersonID(), name, address, phone, paymentMethod, "Complete");
            // Update the session's person with new values
//            person.setName(name);
//            person.setPhone(phone);
//            person.setAddress(address);
//            session.setAttribute("user", person);  // Update session with modified person object
            session.setAttribute("cart", cart);
            String payment = (String) session.getAttribute("payment");
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

            request.setAttribute("selectedBank", selectedBank);
            request.setAttribute("OrderInfo", oi);
            request.setAttribute("payment", payment);
            request.setAttribute("p", p);
            request.setAttribute("banks", banks);
//            MailSender.sendAccountBank(p.getEmail(), bank, oi, amount);
            request.getRequestDispatcher("CartCompletion.jsp").forward(request, response);
//            PrintWriter out = response.getWriter();
//            out.println(p);
//            out.print(oi);
//            out.println(p.getEmail());
//            out.println(order);
//            out.println(pe);
//            out.println(BankName);
//            out.println(AccountName);
//            out.println(AccountNumber);
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