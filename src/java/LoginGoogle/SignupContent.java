/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LoginGoogle;

import DAO.PersonDAO;
import Entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author admin
 */
@WebServlet(name = "SignupContent", urlPatterns = {"/signupWithGG"})
public class SignupContent extends HttpServlet {

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
            out.println("<title>Servlet SignupContent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupContent at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("signupWithGG.jsp").forward(request, response);
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
        String dateString = request.getParameter("date");

        try {
            LocalDate birthDate = LocalDate.parse(dateString);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            if (age < 18) {
                request.setAttribute("errorMessage", "Bạn phải lớn hơn 18 tuổi.");
                request.getRequestDispatcher("SignupContent").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Ngày sinh không hợp lệ.");
            request.getRequestDispatcher("signupWithGG.jsp").forward(request, response);
            return;
        }

        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        String gender = request.getParameter("gender");
        String age = request.getParameter("date");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
         LocalDate startDate = LocalDate.now();
//      public Person(String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
        Person person = new Person(name, gender, age, startDate, address, email, phone,1, password);
        PersonDAO personDAO = new PersonDAO();
        boolean personAdded = personDAO.addPerson(person);

        if (personAdded) {
            request.setAttribute("successMessage", "Đăng ký thành công! Vui lòng click nút bên dưới để quay lại trang đăng nhập.");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi tạo tài khoản.");
            request.getRequestDispatcher("signupWithGG.jsp").forward(request, response);
        }
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
