/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Email;

import DAO.PersonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 *
 * @author admin
 */
@WebServlet(name = "ForgotPassword", urlPatterns = {"/ForgotPassword"})
public class ForgotPassword extends HttpServlet {

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
            out.println("<title>Servlet ForgotPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassword at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("forgot.jsp").forward(request, response);
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
        String action = request.getParameter("action");

        if ("resend".equals(action)) {
            resendVerificationCode(request, response);
        } else {
            registerUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
//        String password = request.getParameter("pass");
//        String repassword = request.getParameter("repass");
        PasswordUtils pw = new PasswordUtils();
//        String passCom = pw.shiftPassword(password);
//        if (!password.equals(repassword)) {
//            request.setAttribute("error", "Mật khẩu không khớp!");
//            request.getRequestDispatcher("forgot.jsp").forward(request, response);
//            return;
//        }

        PersonDAO personDAO = new PersonDAO();
        if (!personDAO.isEmailExists(email)) {
            request.setAttribute("error", "Email not exist Please register account");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
            return;
        }
        String verificationCode = generateVerificationCode();
        MailSender.sendVerificationEmail(email, verificationCode);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(120);
        session.setAttribute("tempEmail", email);
        session.setAttribute("verificationCode", verificationCode);
        // Redirect to verification page
        response.sendRedirect("verifyRePass.jsp");
    }
    
    private void resendVerificationCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Generate a new verification code
        String newCode = generateVerificationCode();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("tempEmail");
        session.setAttribute("verificationCode", newCode);
        MailSender.sendVerificationEmail(email, newCode);
        response.sendRedirect("verifyRePass.jsp");
    }

    private String generateVerificationCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return code.toString();
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
