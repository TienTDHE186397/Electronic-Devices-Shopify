package Controller;

import DAO.PersonDAO;
import DAO.UserDAO;
import Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");

        // Kiểm tra mật khẩu có trùng khớp không
        if (!pass.equals(repass)) {
            String error = "Password does not match Re-entered Password";
            request.setAttribute("error", error);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return; // Dừng xử lý tiếp tục
        }

        // Tạo đối tượng PersonDAO để thao tác với cơ sở dữ liệu
        PersonDAO personDAO = new PersonDAO();

        // Kiểm tra email đã tồn tại trong cơ sở dữ liệu
        if (personDAO.isEmailExists(email)) {
            String error = "Email already exists. Please use a different email.";
            request.setAttribute("error", error);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return; // Dừng xử lý tiếp tục
        }

        // Xác định RoleID (có thể là 1, 2, 3, ... tùy vào hệ thống của bạn)
        int roleId = 1; // Giả sử vai trò người dùng mới là 1

        // Thêm người dùng vào cơ sở dữ liệu
        boolean personAdded = personDAO.addPerson(name, gender, date, null, address, email, phone, roleId, pass);
        if (!personAdded) {
            String error = "Failed to add person to the database. Please try again.";
            request.setAttribute("error", error);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return; // Dừng xử lý tiếp tục
        }

        // Gửi email xác minh (nếu cần thiết)
       
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
