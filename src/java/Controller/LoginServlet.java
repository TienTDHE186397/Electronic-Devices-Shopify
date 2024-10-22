package Controller;

import DAO.PersonDAO;
import Email.PasswordUtils;

import Entity.Person;
import Entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember = request.getParameter("remember");
        PasswordUtils pw = new PasswordUtils();
        String passHash = pw.shiftPassword(password);
        System.out.println(username);
        System.out.println(password);
        System.out.println(passHash);
        Cookie cn = new Cookie("cname", username);
        Cookie cp = new Cookie("cpass", password);
        Cookie cr = new Cookie("crem", remember);

        if (remember != null) {
            cn.setMaxAge(60 * 60 * 24);
            cp.setMaxAge(60 * 60 * 24);
            cr.setMaxAge(60 * 60 * 24);
        } else {
            cn.setMaxAge(0);
            cp.setMaxAge(0);
            cr.setMaxAge(0);
        }
        response.addCookie(cr);
        response.addCookie(cn);
        response.addCookie(cp);
        PersonDAO u = new PersonDAO();
        Person user = u.login(username, passHash);
        System.out.println("User: " + user);
        if (user == null) {
            request.setAttribute("mess", "Username or Password incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (user.getRoleID() == 5) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("homeAdmin");
            } else if (user.getRoleID() == 3) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("SaleHomeEmp?SaleID=" + user.getPersonID());
            } else if (user.getRoleID() == 4) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("SaleHomeManager");
            } else if (user.getRoleID() == 1) {
                HttpSession session = request.getSession();
                Person person = user;
                session.setAttribute("user", person);
                response.sendRedirect("home");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("login.jsp");
            }
            System.out.println(user.getPersonID());
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
