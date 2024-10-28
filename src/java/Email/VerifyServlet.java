/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Email;

import DAO.DAOimgVideo;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        String action = request.getParameter("action");
        if ("resend".equals(action)) {
            resendVerificationCode(request, response);
        } else {
            registerUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy mã xác thực từ form
        String inputCode = request.getParameter("verificationCode2");
        HttpSession session = request.getSession();
        String storedCode = (String) session.getAttribute("verificationCode");
        System.out.println(storedCode);
        // Kiểm tra mã xác thực
        if (inputCode != null && inputCode.equals(storedCode)) {
            // Lấy thông tin người dùng từ session và lưu vào database
            List<String> videoNotes = (List<String>) session.getAttribute("tempVideoName");
            List<String> videoPaths = (List<String>) session.getAttribute("tempVideoValue");
            List<String> ImageNotes = (List<String>) session.getAttribute("tempImageName");
            List<String> ImagePaths = (List<String>) session.getAttribute("tempImageValue");
            String name = (String) session.getAttribute("tempName");
            String age = (String) session.getAttribute("tempAge");
            String phone = (String) session.getAttribute("tempPhone");
            String address = (String) session.getAttribute("tempAddress");
            String password = (String) session.getAttribute("tempPassword");
            String email = (String) session.getAttribute("tempEmail");
            String gender = (String) session.getAttribute("tempGender");

            System.out.println();
            PersonDAO personDAO = new PersonDAO();
            LocalDate startDate = LocalDate.now();
//            nt newPersonId = personDAO.registerPerson(name, dateOfBirth,gender , email, password, startDate);
            int personId = personDAO.registerPerson(name, gender, age, email, password, startDate);  // Thêm người dùng vào database
            System.out.println("PersonID" + personId);
            DAOimgVideo di = new DAOimgVideo();
            if (videoNotes != null && videoPaths != null && videoNotes.size() == videoPaths.size()) {
                // Giả sử bạn đã có personId từ một nơi nào đó
                for (int i = 0; i < videoNotes.size(); i++) {
                    String note = videoNotes.get(i);
                    String path = videoPaths.get(i);

                    // Gọi phương thức insertImage để lưu vào database
                    boolean check = personDAO.insertVideo(personId, path, note);
                    System.out.println(check);
                }
            } else {
                // Xử lý khi danh sách null hoặc không cùng kích thước
                System.out.println("Danh sách videoNotes hoặc videoPaths null hoặc không cùng kích thước.");
            }
            if (ImageNotes != null && ImagePaths != null && ImageNotes.size() == ImagePaths.size()) {
                // Giả sử bạn đã có personId từ một nơi nào đó
                for (int i = 0; i < ImageNotes.size(); i++) {
                    String note = ImageNotes.get(i);
                    String path = ImagePaths.get(i);

                    // Gọi phương thức insertImage để lưu vào database
                    boolean check = personDAO.insertImage(personId, path, note);
                    System.out.println(check);
                }
            } else {
                // Xử lý khi danh sách null hoặc không cùng kích thước
                System.out.println("Danh sách videoNotes hoặc videoPaths null hoặc không cùng kích thước.");
            }
            boolean addAddress = personDAO.insertAddress(personId, address, true);
            boolean addPhone = personDAO.insertPhone(personId, phone, true);
            System.out.println("checkADDress" + addAddress);
            System.out.println("checkPHone" + addPhone);
            session.removeAttribute("verificationCode");
            session.removeAttribute("tempEmail");
            session.removeAttribute("tempAge");
            session.removeAttribute("tempAddress");
            session.removeAttribute("tempName");
            session.removeAttribute("tempPassword");
            session.removeAttribute("tempPhone");
            session.removeAttribute("tempGender");
            session.removeAttribute("tempTime");

            // Chuyển hướng tới trang thành công
            request.setAttribute("message", "Đăng kí tài khoản thành công!");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Xác thực thất bại
            request.setAttribute("message", "Mã xác thực không chính xác.");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
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
        response.sendRedirect("verifyEmail.jsp");
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
