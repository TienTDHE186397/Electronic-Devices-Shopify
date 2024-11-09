package Controller;

import DAO.CategoryDAO;

import DAO.ProductListDAO;
import Entity.Categories;

import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;

@WebServlet(name = "ProductMKT", urlPatterns = {"/ProductMKT"})
public class ProductMKT extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductMKT</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductMKT at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy giá trị của search 
        String search = request.getParameter("search");
        // Lấy giá trị từ giá nào đến giá nào
        String fromprice = request.getParameter("fromprice");
        String toprice = request.getParameter("toprice");
        // Tìm kiếm theo shortdescription
        String shortdescription = request.getParameter("shortdescription");
        // Tìm kiếm theo category
        String category = request.getParameter("category");
        // Lọc theo trang thái
        String status = request.getParameter("status");
        // Sort bài đăng
        String sort = request.getParameter("sort");
        // Lấy thông tin trang hiện tại
        String page = request.getParameter("page");
        // Nếu như page không được truyền vào hoặc để trổng thì gán bằng page = 1
        if (page == null || page.equals("")) {
            page = "1";
        }
        // Nếu như không truyền vào giá trị nào thì sẽ thực hiện yêu câu dưới
        if (search == null && fromprice == null && toprice == null && shortdescription == null && category == null && status == null && sort == null) {
            
            ProductListDAO plDao = new ProductListDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            // Tìm kiến theo danh sách
            List<Product> listP = plDao.searchProduct("", "", "", "", "0", "", "0", 1, 10);
            // Lấy tất cả categories của Product
            List<Categories> listCategory = categoryDAO.getAllCategory();
            // Lấy danh sách được tìm kiếm không phân trang để tính total page
            List<Product> listPa = plDao.searchProduct2(search, fromprice, toprice, shortdescription, category, status, sort);
            int totalpage = (int) Math.ceil((double) listPa.size() / 10);
            //Set Attribute
            request.setAttribute("totalpage", String.valueOf(totalpage));
            request.setAttribute("listP", listP);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("productList.jsp").forward(request, response);

        } else {
            // Nếu như truyền giá trị vào thì thực hiện yêu cầu dưới
            ProductListDAO plDao = new ProductListDAO();
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Product> listP = plDao.searchProduct(search, fromprice, toprice, shortdescription, category, status, sort, Integer.parseInt(page), 10);
            List<Categories> listCategory = categoryDAO.getAllCategory();
            List<Product> listPa = plDao.searchProduct2(search, fromprice, toprice, shortdescription, category, status, sort);
            int totalpage = (int) Math.ceil((double) listPa.size() / 10);
            request.setAttribute("totalpage", String.valueOf(totalpage));
            request.setAttribute("listP", listP);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("productList.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
