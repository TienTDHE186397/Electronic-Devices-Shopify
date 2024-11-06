/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Person;
import DAO.DAOPerson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nghie
 */
@WebServlet(name = "addUserServlet", urlPatterns = {"/addUser"})
@MultipartConfig
public class addUserServlet extends HttpServlet {

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
            out.println("<title>Servlet addUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUserServlet at " + request.getContextPath() + "</h1>");
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
      DAOPerson dp = new DAOPerson();
        List<Person> listP = dp.getAllPerson();
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("addUser.jsp").forward(request, response);

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
    DAOPerson dp = new DAOPerson();
    PrintWriter out = response.getWriter();
    
    // Lấy thông tin từ request
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String dob = request.getParameter("dob");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String roleid = request.getParameter("roleid");
    String pass = request.getParameter("pass");
    LocalDate startDate = LocalDate.now();
    int nroleid = Integer.parseInt(roleid);

    // Xử lý phần tệp
    Part part = request.getPart("image"); // Lấy phần tệp
    String image = "";
    String realPath = "";

    if (part != null && part.getSize() > 0) {
        realPath = request.getServletContext().getRealPath("images"); // Đảm bảo thư mục tồn tại
        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        
        // Tạo thư mục nếu không tồn tại
        if (!Files.exists(Path.of(realPath))) {
            Files.createDirectories(Path.of(realPath));
        }
        
        if (filename.endsWith(".jpg")) { // Kiểm tra định dạng
            part.write(realPath + "/" + filename); // Lưu tệp
            image = "images/" + filename; // Lưu đường dẫn tệp
        } else {
            out.println("File ảnh phải kết thúc với đuôi .jpg");
            return;
        }
    }

    // Tạo đối tượng Person
    LocalDate dobDate = LocalDate.parse(dob); // Nếu dob là dạng "yyyy-MM-dd"
    Person person = new Person(image, name, gender, dobDate.toString(), startDate, address, email, phone, nroleid, pass);
    
    // Gọi phương thức thêm người
    if (dp.addPerson(person, name)) {
        response.sendRedirect("userList");
    } else {
        out.println("Error");
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

