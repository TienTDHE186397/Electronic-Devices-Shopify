/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.DAOProduct;
import DAO.DAOimgVideo;
import Entity.Categories;
import Entity.ImageVideo;
import Entity.Product;
import Entity.ProductAttribute;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author admin
 */
@WebServlet(name = "ProductDetail", urlPatterns = {"/ProductDetail"})
@MultipartConfig()
public class ProductDetail extends HttpServlet {

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
            out.println("<title>Servlet ProductDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetail at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("ID"));
        DAOProduct pd = new DAOProduct();
        Product product = pd.getProductById(id);
        List attribute = pd.getProductAttributesById(id);
        CategoryDAO cd = new CategoryDAO();
        List category = cd.getAllCategory();
        DAOimgVideo imdao = new DAOimgVideo();
        List<ImageVideo> video = imdao.getImByProductID(id);
        request.setAttribute("pro", product);
        request.setAttribute("attribute", attribute);
        request.setAttribute("category", category);
        request.setAttribute("video", video);
        request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("idhi"));
        String title = request.getParameter("title");
        String productName = request.getParameter("productName");
        Part imagePart = request.getPart("image");
        String image = "img/default-phone.jpg";
        String realImagePath = request.getServletContext().getRealPath("/img");
        String realVideoPath = request.getServletContext().getRealPath("/img");
        DAOProduct dp = new DAOProduct();
// Xử lý hình ảnh
        if (imagePart != null && imagePart.getSize() > 0) { // Chỉ xử lý khi có ảnh mới được upload
            String filename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(Path.of(realImagePath))) {
                Files.createDirectory(Path.of(realImagePath));
            }

            imagePart.write(realImagePath + File.separator + filename);

            // Chỉ chấp nhận file ảnh có đuôi .jpg, nếu không sẽ gán ảnh mặc định
            if (!filename.endsWith(".jpg")) {
                image = "img/default-phone.jpg"; // Ảnh mặc định
            } else {
                image = "img/" + filename;
            }
        } else {
            // Không có ảnh mới, giữ nguyên ảnh cũ
            // Giả sử ảnh cũ được lưu trữ trong một biến khác từ cơ sở dữ liệu
            image = dp.getImageById(id); // Lấy ảnh cũ từ cơ sở dữ liệu
        }
        System.out.println(image);
        System.out.println(imagePart);
// Xử lý video
// In ra đường dẫn để kiểm tra
        int views = Integer.parseInt(request.getParameter("views"));
        String publisher = request.getParameter("publisher");
        String releaseDateStr = request.getParameter("releaseDate");
        java.sql.Date releaseDate = null;
        if (releaseDateStr != null && !releaseDateStr.isEmpty()) {
            releaseDate = java.sql.Date.valueOf(releaseDateStr);
        }
//        ------------------------------------------------------------

        int category = Integer.parseInt(request.getParameter("category"));
        int sale = Integer.parseInt(request.getParameter("sale"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String sortDescription = request.getParameter("sortDescription");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        boolean updateSuccessful = true; // Cờ để kiểm tra thành công
        DAOProduct productAttributesDAO = new DAOProduct();
        DAOimgVideo imageDAO = new DAOimgVideo();
        String[] newAttributeNames2 = request.getParameterValues("attributeName2");
        String[] newAttributeValues2 = request.getParameterValues("attributeValue2");

        String[] newAttributeNames = request.getParameterValues("attributeName");
        String[] newAttributeValues = request.getParameterValues("attributeValue");
        String[] oldAttributeNames = request.getParameterValues("oldAttributeName");
        DAOProduct productDAO = new DAOProduct();
//        int productId, String title, String ProductName, int view, Date releaseDate, int QuantitySold, int category,
//            int Quantity, int Sale, String img, double price, String publisher, String sortDescription, String description, String status
        boolean insertSuccessful = productDAO.updateProduct(id, title, productName, views, releaseDate, quantity, category, quantity, sale, image, price, publisher, sortDescription, description, status);
        if (oldAttributeNames != null) {
            for (int i = 0; i < oldAttributeNames.length; i++) {
                String oldName = oldAttributeNames[i];
                String newName = newAttributeNames[i];
                String value = newAttributeValues[i];

                if (newName != null && value != null) {
                    boolean check = productAttributesDAO.updateProductAttributes(id, oldName, newName, value);
                    if (!check) {
                        updateSuccessful = false;
                    } else {
                        System.out.println("cap nhat thanh cong");
                    }
                }
            }
        }
        boolean addattri = true;
        if (newAttributeNames2 != null && newAttributeValues2 != null) {
            for (int i = 0; i < newAttributeNames2.length; i++) {
                boolean exists = false;
                String newName2 = newAttributeNames2[i];
                String value2 = newAttributeValues2[i];
                if (oldAttributeNames != null) {
                    for (String oldName : oldAttributeNames) {
                        if (oldName.equals(newName2)) {
                            exists = true;
                            break;
                        }
                    }
                }

                if (!exists && value2 != null) {
                   addattri = productAttributesDAO.addProductAttribute(id, newName2, value2);
                }
            }
        }
//------------------------------------------------------------------------------------------------------------------//
        Part videoPart = request.getPart("vidImgValue");
        String vid = "img/default-vid.mp4";
        String newVidName = request.getParameter("vidImgName");
        // XU LY VIDEO
        if (videoPart != null && videoPart.getSize() > 0) {
            String videoFilename = Path.of(videoPart.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realVideoPath))) {
                Files.createDirectory(Path.of(realVideoPath));
            }
            videoPart.write(realVideoPath + File.separator + videoFilename);

            if (!videoFilename.endsWith(".mp4")) {
                vid = "img/default-vid.mp4";
            } else {
                vid = "img/" + videoFilename;
            }
        }
        boolean a = true;
        //ADD VIDEO VAO DATABASE
        if (newVidName != null && vid != null) {
            a = imageDAO.addImageVi(id, vid, newVidName);
            if (a) {
                System.out.println("add thanh cong");
            } else {
                System.out.println("add that bai");
            }
        }
        
        if (a || insertSuccessful) {
            response.sendRedirect("ProductMKT");
        } else {
            response.sendRedirect("error.jsp");
        }
       
        System.out.println("Image path: " + realImagePath);
        System.out.println("Video path: " + realVideoPath);
        System.out.println("Video path: " + vid);
        System.out.println("--------------------------------------------------------------------------------");
    }

}

// Gọi phương thức update để cập nhật thuộc tính sản phẩm
/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
