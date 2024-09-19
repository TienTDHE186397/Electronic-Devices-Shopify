/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Person;
import DAO.DAOPerson;
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
import org.apache.tomcat.jni.SSLContext;

/**
 *
 * @author nghie
 */
@WebServlet(name = "addUserServlet", urlPatterns = {"/addUser"})
public class addUserServlet extends HttpServlet {

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
            out.println("<title>Servlet addUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUserServlet at " + request.getContextPath() + "</h1>");
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
      DAOPerson dp = new DAOPerson();
        List<Person> listP = dp.getAllPerson();
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("addUser.jsp").forward(request, response);

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
        DAOPerson dp = new DAOPerson();
     
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
       
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String roleid = request.getParameter("roleid");
        String pass = request.getParameter("pass");
        LocalDate startDate = LocalDate.now();
        int nroleid = Integer.parseInt(roleid);
        Person person = new Person(name, gender, dob, startDate, address, email, phone, nroleid  , pass);
        dp.addPerson(person);
        
//        Boolean add =  dp.addPerson(new Person( "Duc", "Name", "2004-11-03", "2024-09-17", "Ha Noi", "duqweqwecdsfsdf@gmaisadadasdasdl.com", "0985407026", 5, "123")); 
//        if(add){
//            System.out.println("add thanh cong");
//        }
//        else{
//            System.out.println("loi");
//        }
//        
//     
//        System.out.println(name);
//        System.out.println(gender);
//        System.out.println(dob);
//        System.out.println(sd);
//        System.out.println(address);
//        System.out.println(email);
//        System.out.println(roleid);
        
        
             response.sendRedirect("userList");

        
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
