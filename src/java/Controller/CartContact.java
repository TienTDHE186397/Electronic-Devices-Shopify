/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Categories;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Dokkuhai
 */
@WebServlet(name = "CartContact", urlPatterns = {"/cartcontact"})
public class CartContact extends HttpServlet {

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
            out.println("<title>Servlet CartContact</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartContact at " + request.getContextPath() + "</h1>");
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
        // Khởi tạo các đối tượng DAO để truy xuất dữ liệu danh mục và sản phẩm
        CategoryDAO cDao = new CategoryDAO();
        ProductDAO pDao = new ProductDAO();

        // Lấy danh sách 5 sản phẩm mới nhất từ ProductDAO  
        List<Product> listProductLatest = pDao.getTop5ProductLatests();

        // Lấy danh sách tất cả danh mục sản phẩm từ CategoryDAO
        List<Categories> listC = cDao.getAllCategory();

        // Thiết lập các attribute để truyền dữ liệu sang trang JSP
        request.setAttribute("listCategory", listC);            // Gán danh sách danh mục vào attribute
        request.setAttribute("listProductLatest", listProductLatest); // Gán danh sách 5 sản phẩm mới nhất vào attribute
        // Chuyển tiếp request và response đến trang `CartContact.jsp` để hiển thị dữ liệu
        request.getRequestDispatcher("CartContact.jsp").forward(request, response);
        //PrintWriter out = response.getWriter();
        //out.print(payment);
        
        
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
        processRequest(request, response);
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
