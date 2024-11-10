/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.CategoryDAO;
import DAO.ProductListDAO;
import Entity.Categories;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "addProductServlet", urlPatterns = {"/addProductMKT"})
@MultipartConfig
public class addProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách Category
        CategoryDAO cDAO = new CategoryDAO();
        List<Categories> listC = cDAO.getAllCategory();
        request.setAttribute("listType", listC);
        request.getRequestDispatcher("addProductMKT.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String err1 = "";
        String err2 = "";
        boolean check = true;
        // Lấy Thông tin đầu vào của product
        String product_tittle = request.getParameter("tittle");
        String product_name = request.getParameter("name");
        String product_quantity = request.getParameter("quantity");
        String product_brand = request.getParameter("brand");
        String product_price = request.getParameter("price");
        String product_publisher = request.getParameter("publisher");
        String product_shortdescription = request.getParameter("shortdescription");
        String product_description = request.getParameter("description");
        String product_status = request.getParameter("status");
        String product_sale = request.getParameter("sale");
        String product_category_id = request.getParameter("categoryid");

        // Lấy đường dẫn ảnh của Product
        Part part = request.getPart("productimage");
        String image = "";
        String realPath = "";

        try {

            if (part != null && part.getSize() > 0) {
                realPath = request.getServletContext().getRealPath("productimages");
                String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Path.of(realPath))) {
                    Files.createDirectory(Path.of(realPath));
                }
                part.write(realPath + "\\" + filename);
                if (!filename.endsWith(".jpg")) {
                    err2 = "File ảnh phải kết thúc với đuôi .jpg !";
                    check = false;
                } else {
                    image = realPath.substring(realPath.length() - 13, realPath.length()) + "/" + filename;
                }
            } else {
                err2 = "Hãy chọn đường dẫn !<br/>";
                check = false;
            }

        } catch (Exception e) {
            err2 = "Đường dẫn bạn gửi vào không đúng! <br/>";
            check = false;
        }

        if (product_category_id.equals("")) {
            check = false;
            err1 = "Hãy chọn category ! <br/>";
        }

       
        if (!check) {
            // Set up lỗi
            request.setAttribute("err1", err1);
            request.setAttribute("err2", err2);
            //Set Trả lại các giá trị nhập vào 
            request.setAttribute("product_tittle", product_tittle);
            request.setAttribute("product_name", product_name);
            request.setAttribute("product_quantity", product_quantity);
            request.setAttribute("product_brand", product_brand);
            request.setAttribute("product_price", product_price);
            request.setAttribute("product_publisher", product_publisher);
            request.setAttribute("product_shortdescription", product_shortdescription);
            request.setAttribute("product_description", product_description);
            request.setAttribute("product_status", product_status);
            request.setAttribute("product_sale", product_sale);
            request.setAttribute("product_status", product_status);
            request.setAttribute("product_category_id", product_category_id);
            
            doGet(request, response);
            return;
        }

        //Lấy Thông tin ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        //Format Date
        java.sql.Date releaseDate = java.sql.Date.valueOf(formattedDate);

        ProductListDAO pDAO = new ProductListDAO();
        CategoryDAO cDAO = new CategoryDAO();
        // Lấy Category
        Categories c = cDAO.getCategoriesById(Integer.parseInt(product_category_id));
        // Lấy Tất Cả Bài Đăng
        List<Product> list = pDAO.getAllProduct();
        try {
            //Parse giá trị sang int
            int product_quantity_int = Integer.parseInt(product_quantity);
            int product_sale_int = Integer.parseInt(product_sale);
            int product_price_int = Integer.parseInt(product_price);
            // Tạo Product Mới
            Product p = new Product(list.get(list.size() - 1).getProductID() + 1,
                    product_tittle,
                    product_name,
                    0,
                    releaseDate,
                    0,
                    c,
                    product_quantity_int,
                    product_sale_int,
                    image,
                    product_price_int,
                    product_publisher,
                    product_shortdescription,
                    product_description,
                    product_status,
                    product_brand);

            // Thêm mới Product
            pDAO.addNewProduct(p, c);

            response.sendRedirect("ProductMKT");
        } catch (Exception e) {
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
