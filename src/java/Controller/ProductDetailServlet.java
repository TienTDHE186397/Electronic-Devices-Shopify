/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CommentDAO;
import DAO.ProductDAO;
import Email.PasswordUtils;
import Entity.CommentPerson;
import Entity.Person;
import Entity.Product;
import Entity.ProductAttribute;
import Entity.ProductImage;
import Entity.imageComment;
import Entity.videoComment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dokkuhai
 */
@MultipartConfig()
public class ProductDetailServlet extends HttpServlet {

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
             {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDetailServlet</title>");
            out.println("<title>Servlet ProductDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet ProductDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Khởi tạo đối tượng ProductDAO để truy xuất dữ liệu sản phẩm
        ProductDAO pDao = new ProductDAO();

// Lấy `productid` từ request parameter và chuyển đổi thành số nguyên
        int productid = Integer.parseInt(request.getParameter("ProductID"));

// Truy xuất chi tiết sản phẩm theo `productid`
        Product p = pDao.getProductsById(productid);

// Lấy danh sách hình ảnh của sản phẩm theo `productid`
        List<ProductImage> listImage = pDao.getAllProductImageById(productid);

// Lấy danh sách thuộc tính của sản phẩm theo `productid`
        List<ProductAttribute> listAttribute = pDao.getAllProductAttributeById(productid);

// Thiết lập các attribute để truyền dữ liệu sang trang JSP
        request.setAttribute("productDetail", p);         // Gán chi tiết sản phẩm vào attribute
        request.setAttribute("listImage", listImage);     // Gán danh sách hình ảnh sản phẩm vào attribute
        request.setAttribute("listAttribute", listAttribute); // Gán danh sách thuộc tính sản phẩm vào attribute

// Chuyển tiếp request và response đến trang `ProductDetailPublic.jsp` để hiển thị chi tiết sản phẩm
        request.getRequestDispatcher("ProductDetailPublic.jsp").forward(request, response);
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
