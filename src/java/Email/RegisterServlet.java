/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Email;

// RegisterServlet.java
import DAO.PersonDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

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
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        String gender = request.getParameter("gender");
        String age = request.getParameter("date");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        PasswordUtils pw = new PasswordUtils();
        String passHash = pw.shiftPassword(password);
        String rePassHash = pw.shiftPassword(repassword);
        System.out.println(passHash);
        System.out.println(rePassHash);
        System.out.println("Password: " + password);
        System.out.println("RePassword: " + repassword);
        if (!passHash.equals(rePassHash)) {
            request.setAttribute("error", "Mật khẩu không khớp!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.isEmailExists(email)) {
            request.setAttribute("error", "Email already exists. Please use a different email.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (age != null && !age.isEmpty()) {
            LocalDate birthDate = LocalDate.parse(age);
            LocalDate today = LocalDate.now();
            int age2 = Period.between(birthDate, today).getYears();

            if (age2 < 18) {
                request.setAttribute("error", "Bạn chưa đủ 18 tuổi.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("error", "Vui lòng nhập ngày sinh hợp lệ.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Generate verification code
        String verificationCode = generateVerificationCode();

        // Send verification code
        MailSender.sendVerificationEmail(email, verificationCode);

        // Store user info and verification code in session
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(120);
        session.setAttribute("tempName", name);
        session.setAttribute("tempAge", age);
        session.setAttribute("tempEmail", email);
        session.setAttribute("tempPhone", phone);
        session.setAttribute("tempAddress", address);
        session.setAttribute("tempPassword", passHash);
        session.setAttribute("verificationCode", verificationCode);
        System.out.println(session.getAttribute("tempPassword"));
        System.out.println(session.getAttribute("tempAge"));
        System.out.println(session.getAttribute("verificationCode2"));

        // Redirect to verification page
        response.sendRedirect("verifyEmail.jsp");
    }

    private void resendVerificationCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newCode = generateVerificationCode();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("tempEmail");
        if (email == null || email.isEmpty()) {
            request.setAttribute("error", "Không tìm thấy địa chỉ email. Vui lòng thử lại.");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
            return;
        }
        session.setAttribute("verificationCode", newCode);
        MailSender.sendVerificationEmail(email, newCode);
        response.sendRedirect("verifyEmail.jsp");
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
}
