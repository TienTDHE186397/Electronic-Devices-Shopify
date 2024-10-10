/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOProduct;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "DeleteAttributeServlet", urlPatterns = {"/DeleteAttributeServlet"})
public class DeleteAttributeServlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteAttributeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteAttributeServlet at " + request.getContextPath() + "</h1>");
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
        String attributeID = request.getParameter("attributeID");
        int id = Integer.parseInt(request.getParameter("idhi")); // Lấy ID của sản phẩm từ form

        // Kiểm tra xem attributeID có hợp lệ không
        if (attributeID != null && !attributeID.isEmpty()) {
            // Gọi phương thức để xóa thuộc tính trong cơ sở dữ liệu
            DAOProduct dao = new DAOProduct();
            boolean isDeleted = dao.deleteAttribute(Integer.parseInt(attributeID));

            // Phản hồi lại người dùng
            if (isDeleted) {
                request.setAttribute("mess", "Update Successfull");
                // Chuyển hướng đến trang chi tiết sản phẩm sau khi xóa thành công
                response.sendRedirect("ProductDetail?ID=" + id);
            } else {
                request.setAttribute("mess", "Cannot Update");
                response.sendRedirect("ProductDetail?ID=" + id); // Chuyển hướng đến trang lỗi nếu không xóa được
            }
        } else {
            request.setAttribute("mess", "You have some error");
            response.sendRedirect("ProductDetail?ID=" + id); // Chuyển hướng đến trang lỗi nếu attributeID không hợp lệ
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
