/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.*;
import Email.SendOrder;
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

        if (session != null && session.getAttribute("cart") != null) {
            String id = request.getParameter("PersonID");
            String oid = request.getParameter("ProductID");
            DAOAdmin da = new DAOAdmin();
            Person pe = da.getPersonById(id);
            PersonAddressDAO pad = new PersonAddressDAO();
            PersonPhoneDAO ppd = new PersonPhoneDAO();
            PersonAddress pa = pad.getAddressById(id);
            PersonPhone pp = ppd.getPhoneById(id);
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
            cart.setPerson(p);

//            CategoryDAO cDao = new CategoryDAO();
//            ProductDAO pDao = new ProductDAO();
//            List<Product> listProductLatest = pDao.getTop5ProductLatests();
//            List<Categories> listC = cDao.getAllCategory();
            session.setAttribute("address", pa);
            session.setAttribute("phone", pp);
            session.setAttribute("cart", cart);
            session.setAttribute("person", pe);

            ServletContext context = request.getServletContext();
            String BankName = context.getInitParameter("bankName");
            String AccountName = context.getInitParameter("AccountName");
            String AccountNumber = context.getInitParameter("AccountNumber");
            OrderProduct order = da.getOrderById(oid);
            request.setAttribute("order", order);
            request.setAttribute("p", p);
            request.setAttribute("bankName", BankName);
            request.setAttribute("AccountName", AccountName);
            request.setAttribute("AccountNumber", AccountNumber);

            SendOrder so = new SendOrder();
            so.send(p.getEmail(), order, BankName, AccountName, AccountNumber);
//            request.setAttribute("listCategory", listC);
//            request.setAttribute("listProductLatest", listProductLatest);
        request.getRequestDispatcher("CartCompletion.jsp").forward(request, response);
//            PrintWriter out = response.getWriter();
//            out.println(cart);
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
