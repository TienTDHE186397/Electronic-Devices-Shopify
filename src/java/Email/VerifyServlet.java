/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Email;

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
import java.util.Date;

/**
 *
 * @author admin
 */
@WebServlet(name = "VerifyServlet", urlPatterns = {"/VerifyServlet"})
public class VerifyServlet extends HttpServlet {

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
            out.println("<title>Servlet VerifyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyServlet at " + request.getContextPath() + "</h1>");
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
        String inputCode = request.getParameter("verificationCode2");

        // Lấy mã xác thực lưu trữ trong session
        HttpSession session = request.getSession();
        String storedCode = (String) session.getAttribute("verificationCode");
        // Kiểm tra mã xác thực
        if (inputCode != null && inputCode.trim().equals(storedCode.trim())) {
            // Lấy thông tin người dùng từ session và lưu vào database
            String name = (String) session.getAttribute("tempName");
            String age = (String) session.getAttribute("tempAge");
            String gender = (String) session.getAttribute("gender");
            String email = (String) session.getAttribute("tempEmail");
            String phone = (String) session.getAttribute("tempPhone");
            String address = (String) session.getAttribute("tempAddress");
            String password = (String) session.getAttribute("tempPassword");
            Person person = new Person(name, gender, age, null, address, email, phone, 1, password);
            PersonDAO personDAO = new PersonDAO();
            boolean add = personDAO.addPerson(person);  // Thêm người dùng vào database
            if (add) {
                System.out.println("in thanh cong");
            } else {
                System.out.println("add loi");
            }
            // Xóa thông tin tạm thời trong session
            session.removeAttribute("verificationCode");
            session.removeAttribute("tempName");
            session.removeAttribute("tempAge");
            session.removeAttribute("tempEmail");
            session.removeAttribute("tempPhone");
            session.removeAttribute("tempAddress");
            session.removeAttribute("tempPassword");

            // Chuyển hướng tới trang thành công
            request.setAttribute("message", "Xác thực thành công!");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Xác thực thất bại
            request.setAttribute("errorMessage", "Mã xác thực không chính xác.");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
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
