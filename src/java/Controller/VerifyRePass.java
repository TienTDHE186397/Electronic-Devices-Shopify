/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import DAO.PersonDAO;
import Entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author admin
 */
@WebServlet(name = "VerifyRePass", urlPatterns = {"/VerifyRePass"})
public class VerifyRePass extends HttpServlet {

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
            out.println("<title>Servlet VerifyRePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyRePass at " + request.getContextPath() + "</h1>");
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
        // Lấy mã xác thực từ form
        String action = request.getParameter("action");
        if ("resend".equals(action)) {
            resendVerificationCode(request, response);
        } else {
           verify(request,response);
        }

    }

    private void verify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputCode = request.getParameter("verificationCode2");

        // Lấy mã xác thực lưu trữ trong session
        HttpSession session = request.getSession();
        String storedCode = (String) session.getAttribute("verificationCode");
        // Kiểm tra mã xác thực
        if (inputCode != null && inputCode.trim().equals(storedCode.trim())) {

            request.setAttribute("message", "Xác thực thành công");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        } else {
            // Xác thực thất bại
            request.setAttribute("message", "Mã xác thực không chính xác.");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
        }
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

    // Tạo một đối tượng Random tĩnh và tái sử dụng
    private static final Random random = new Random();

    private String generateVerificationCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();

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
