/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.DAOProduct;
import DAO.DAOimgVideo;
import Entity.Categories;
import Entity.CommentPerson;
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
        List<ImageVideo> video = imdao.getVidByProductID(id);
        List<ImageVideo> image = imdao.getImByProductID(id);
        request.setAttribute("pro", product);
        request.setAttribute("attribute", attribute);
        request.setAttribute("category", category);
        request.setAttribute("video", video);
        request.setAttribute("image", image);
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

// Khởi tạo các biến với giá trị mặc định hoặc xử lý khi tham số không có
        int videoID = -1;
        int imageID = -1;

// Kiểm tra xem tham số videoID hoặc imageID có trong yêu cầu không
        String videoIDParam = request.getParameter("videoID");
        String imageIDParam = request.getParameter("imageID");

        DAOimgVideo div = new DAOimgVideo();

// Nếu video cần xóa
        if (request.getParameter("deleteVideo") != null && videoIDParam != null) {
            try {
                videoID = Integer.parseInt(videoIDParam); // Chỉ phân tích cú pháp khi tham số không phải null
                div.deleteVidByProductID(id, videoID);
            } catch (NumberFormatException e) {
                // Log hoặc xử lý ngoại lệ nếu videoID không hợp lệ
                e.printStackTrace();
            }
        }

// Nếu ảnh cần xóa
        if (request.getParameter("deleteImage") != null && imageIDParam != null) {
            try {
                imageID = Integer.parseInt(imageIDParam); // Chỉ phân tích cú pháp khi tham số không phải null
                div.deleteImageByProductID(id, imageID);
            } catch (NumberFormatException e) {
                // Log hoặc xử lý ngoại lệ nếu imageID không hợp lệ
                e.printStackTrace();
            }
        }
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

        if (newAttributeNames2 != null && newAttributeValues2 != null) {
            for (int i = 0; i < newAttributeNames2.length; i++) {
                System.out.println("Attribute Name: " + newAttributeNames2[i]);
                System.out.println("Attribute Value: " + newAttributeValues2[i]);
            }
        } else {
            System.out.println("No attributes found.");
        }
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

        if (newAttributeNames2 != null && newAttributeNames2.length > 0 && newAttributeValues2 != null && newAttributeValues2.length > 0) {
            System.out.println("DA CHECK DUOC ROI");

            for (int i = 0; i < newAttributeNames2.length; i++) {
                String newName2 = newAttributeNames2[i];
                String value2 = newAttributeValues2[i];

                // Check if the attribute already exists in the database
                if (productAttributesDAO.attributeExists(id, newName2)) {
                    // If it exists, set a message and forward to the same page
                    request.setAttribute("message", "Attribute " + newName2 + " already exists.");
                    request.getRequestDispatcher("ProductMKT").forward(request, response);
                    return; // Exit to prevent further processing
                } else {
                    // If it does not exist, add the new attribute
                    productAttributesDAO.addProductAttribute(id, newName2, value2);
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
            a = imageDAO.addVideo(id, vid, newVidName);
            if (a) {
                System.out.println("add thanh cong");
            } else {
                System.out.println("add that bai");
            }
        }
//-----------------------------------------------------------------------------------------------------------------------------//
// Xu ly Anh
//Xu ly Anh
        List<String> ImagePaths = new ArrayList<>();
        List<String> ImageNotes = new ArrayList<>();

// Lặp qua các phần của request
        if (ImagePaths != null) {
            for (Part part : request.getParts()) {
                if (part.getName().equals("vidImageValue")) {
                    // Xử lý video
                    if (part.getSize() > 0) {
                        String IMGFilename = Path.of(part.getSubmittedFileName()).getFileName().toString();

                        // Kiểm tra và tạo thư mục nếu chưa tồn tại
                        if (!Files.exists(Path.of(realVideoPath))) {
                            Files.createDirectory(Path.of(realVideoPath));
                        }

                        // Ghi video vào thư mục
                        part.write(realVideoPath + File.separator + IMGFilename);

                        // Kiểm tra định dạng video
                        if (IMGFilename.endsWith(".jpg")) {
                            ImagePaths.add("img/" + IMGFilename); // Lưu đường dẫn video
                        } else {
                            ImagePaths.add("img/default-phone.jpg"); // Lưu đường dẫn video mặc định nếu không phải .mp4
                        }
                    }
                } else if (part.getName().equals("vidImageName")) {
                    // Xử lý ghi chú
                    String note = request.getParameter(part.getName());
                    ImageNotes.add(note); // Lưu ghi chú
                }
            }
        }
        if (ImageNotes != null && ImagePaths != null && ImageNotes.size() == ImagePaths.size()) {
            // Giả sử bạn đã có personId từ một nơi nào đó
            for (int i = 0; i < ImageNotes.size(); i++) {
                String note = ImageNotes.get(i);
                String path = ImagePaths.get(i);

                a = imageDAO.addImage(id, path, note);
                if (a) {
                    System.out.println("add thanh cong");
                } else {
                    System.out.println("add that bai");
                }
            }
        } else {
            // Xử lý khi danh sách null hoặc không cùng kích thước
            System.out.println("Danh sách videoNotes hoặc videoPaths null hoặc không cùng kích thước.");
        }

        if (a || insertSuccessful) {

            // After all attributes are added, set a success message and forward
            request.setAttribute("message", "Update Product successfully.");
            request.getRequestDispatcher("ProductMKT").forward(request, response);
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
