package Controller;

import DAO.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Entity.Account;
import Entity.Wallet;

public class LoginControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        AccountDAO dao = new AccountDAO();
        Account a = dao.login(user, pass);

        if (a == null) {
            request.setAttribute("mess", "Sai tên người dùng hoặc mật khẩu");
            request.getRequestDispatcher("loginform.jsp").forward(request, response);
        } else {
            int aid = a.getID();
            Wallet w = dao.getWalletByAid(aid);
//            
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            session.setAttribute("wallet", w);
            session.setMaxInactiveInterval(1800);
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
