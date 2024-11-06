/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Product;
import DAO.CategoryDAO;
import Entity.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.ProductDAOPublic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dokkuhai
 */
public class ProductListPublic extends HttpServlet {

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
            out.println("<title>Servlet ProductList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductList at " + request.getContextPath() + "</h1>");
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
//==============================================================================
// Khởi tạo các đối tượng DAO để thao tác với dữ liệu sản phẩm và danh mục
        ProductDAOPublic pDao = new ProductDAOPublic();
        CategoryDAO cDao = new CategoryDAO();

//==============================================================================
// Lấy các giá trị từ URI của trang web
        String queryString = request.getQueryString();   // Lấy chuỗi truy vấn từ URL (query string)
        String uri = request.getRequestURI();            // Lấy URI hiện tại

// Lấy các tham số từ request parameter
        String category = request.getParameter("category");             // Lấy danh mục sản phẩm
        String quantity_product = request.getParameter("numberOfProducts"); // Lấy số lượng sản phẩm hiển thị mỗi trang
        String indexPage = request.getParameter("page");                // Lấy trang hiện tại cho phân trang
        String searchProduct = request.getParameter("search_product");  // Lấy từ khóa tìm kiếm sản phẩm
        String sort = request.getParameter("sort");                     // Lấy tham số sắp xếp

// Giá trị mặc định
        int cate = 0;           // Mã danh mục mặc định là 0 (tất cả danh mục)
        int quantity = 4;       // Số lượng sản phẩm mặc định hiển thị mỗi trang là 4
        if (indexPage == null) {
            indexPage = "1";    // Mặc định trang hiện tại là trang 1 nếu không có tham số `page`
        }
        if (sort == null) {
            sort = "releaseDate DESC"; // Mặc định sắp xếp theo ngày phát hành giảm dần
        }

// Xử lý dữ liệu nhận được từ truy vấn
        if (category != null) {
            cate = Integer.parseInt(category);  // Chuyển đổi danh mục từ chuỗi sang số nguyên nếu khác null
        }
        if (quantity_product != null) {
            quantity = Integer.parseInt(quantity_product);  // Chuyển đổi số lượng sản phẩm từ chuỗi sang số nguyên nếu khác null
        }
        int index = Integer.parseInt(indexPage);  // Chuyển đổi trang hiện tại sang số nguyên

//==============================================================================
// Lấy danh sách sản phẩm bán chạy dựa trên phần trăm giảm giá
        List<Product> listProductTop = pDao.getTop4Product();
        request.setAttribute("hot_product", listProductTop); // Gán danh sách sản phẩm bán chạy vào request attribute

//==============================================================================
// Lấy tất cả danh mục sản phẩm
        List<Categories> listCategory = cDao.getAllCategory(); // Lấy danh sách tất cả danh mục sản phẩm

//==============================================================================
        /**
         * ********************************Phân trang*****************************
         */
// Lấy danh sách sản phẩm cho trang hiện tại với bộ lọc theo danh mục, số lượng, sắp xếp và từ khóa tìm kiếm
        List<Product> listP = pDao.pagingProductByCategory1(index, cate, quantity, sort, searchProduct);

// Tính tổng số trang dựa trên tổng số sản phẩm
        int count = pDao.getTotalProduct(cate, searchProduct);  // Tổng số sản phẩm sau khi áp dụng bộ lọc
        int endPage = count / quantity;
        if (count % quantity != 0) {
            endPage += 1; // Thêm 1 trang nếu tổng sản phẩm không chia hết cho số lượng sản phẩm mỗi trang
        }

//==============================================================================
// Gửi dữ liệu qua request để truyền sang JSP
        request.setAttribute("uri", uri);                // Gán URI hiện tại vào request attribute
        request.setAttribute("queryString", queryString); // Gán query string hiện tại vào request attribute
        request.setAttribute("listCategory", listCategory); // Gán danh sách danh mục vào request attribute
        request.setAttribute("list_P", listP);           // Gán danh sách sản phẩm cho trang hiện tại vào request attribute
        request.setAttribute("endP", endPage);           // Gán tổng số trang vào request attribute

//==============================================================================
// Chuyển tiếp request và response đến trang `ProductListPublic.jsp` để hiển thị dữ liệu
        request.getRequestDispatcher("ProductListPublic.jsp").forward(request, response);
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
