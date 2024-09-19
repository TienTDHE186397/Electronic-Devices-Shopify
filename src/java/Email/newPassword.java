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

/**
 *
 * @author admin
 */
@WebServlet(name = "newPassword", urlPatterns = {"/newPassword"})
public class newPassword extends HttpServlet {

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
            out.println("<title>Servlet newPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newPassword at " + request.getContextPath() + "</h1>");
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
        String pass = (String) request.getParameter("pass");
        String repass = (String) request.getParameter("repass");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("tempEmail");
        PasswordUtils pw = new PasswordUtils();
        String passCom = pw.shiftPassword(pass);
        System.out.println("pass " + pass);
        System.out.println("repass " + repass);
        if (pass == null || repass == null || !pass.equals(repass)) {
            request.setAttribute("error", "Mật khẩu không khớp!");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
            return;
        }
        PersonDAO personDAO = new PersonDAO();
        boolean add = personDAO.updatePassword(email, passCom);  // Thêm người dùng vào database
        if (add) {
            request.setAttribute("message", "Cập nhật mật khẩu thành công");
            request.getRequestDispatcher("success.jsp").forward(request, response);
            System.out.println("Cập Nhật Thành Công");

        } else {
            System.out.println("Cập Nhật Mật Khẩu Thất Bại");
        }
        // Xóa thông tin tạm thời trong session
        session.removeAttribute("verificationCode");
        session.removeAttribute("tempEmail");

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
