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
     * /**
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
        CommentDAO comment = new CommentDAO();
        List<CommentPerson> com = comment.getCommentsByProductId3(productid);

//        List<imageComment> image = comment.getImageUrlsByCommentId(productid);
//        List<videoComment> video = comment.getVideoUrlsByCommentId(productid);
//        request.setAttribute("image", image);
//        request.setAttribute("video", video);
        request.setAttribute("comment", com);
        //Set attribute for object to send data request to JSP Page

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
        String comment = request.getParameter("comment");
        String realVideoPath = request.getServletContext().getRealPath("/img");
        String image = "img/default-phone.jpg";
        String realImagePath = request.getServletContext().getRealPath("/img");
        int productid = Integer.parseInt(request.getParameter("ProductID"));
        System.out.println("productID: " + productid);
        //---------------------------------------------------------------------------------------------------------------------------------
        // Giả định rằng bạn đã có một danh sách để lưu trữ các đường dẫn video
        List<String> videoPaths = new ArrayList<>();
        List<String> videoNotes = new ArrayList<>();

// Lặp qua các phần của request
        if (videoPaths != null) {
            for (Part part : request.getParts()) {
                if (part.getName().equals("vidImgValue")) {
                    // Xử lý video
                    if (part.getSize() > 0) {
                        String videoFilename = Path.of(part.getSubmittedFileName()).getFileName().toString();

                        // Kiểm tra và tạo thư mục nếu chưa tồn tại
                        if (!Files.exists(Path.of(realVideoPath))) {
                            Files.createDirectory(Path.of(realVideoPath));
                        }

                        // Ghi video vào thư mục
                        part.write(realVideoPath + File.separator + videoFilename);

                        // Kiểm tra định dạng video
                        if (videoFilename.endsWith(".mp4")) {
                            videoPaths.add("img/" + videoFilename); // Lưu đường dẫn video
                        } else {
                            videoPaths.add("img/default-vid.mp4"); // Lưu đường dẫn video mặc định nếu không phải .mp4
                        }
                    }
                } else if (part.getName().equals("vidImgName")) {
                    // Xử lý ghi chú
                    String note = request.getParameter(part.getName());
                    videoNotes.add(note); // Lưu ghi chú
                }
            }
        }

        //---------------------------------------------------------------------------------------------
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
        System.out.println("comment: " + comment);
        System.out.println("videoPaths: " + videoPaths);
        System.out.println("videoNotes: " + videoNotes);
        System.out.println("ImagePaths: " + ImagePaths);
        System.out.println("ImageNotes: " + ImageNotes);
        HttpSession session = request.getSession();
        CommentDAO comDAO = new CommentDAO();
        Person person = (Person) session.getAttribute("user");
        if (comment == null || comment.trim().isEmpty()) {
            // Nếu comment là null hoặc rỗng, chuyển hướng về trang chi tiết sản phẩm
            response.sendRedirect("product-detail?ProductID=" + productid);
        } else {

            LocalDate date2 = LocalDate.now();
            int addC = comDAO.addComment(productid, person.getPersonID(), comment, date2);
            boolean addIm = comDAO.addCommentImages(addC, ImagePaths);
            boolean addVideo = comDAO.addCommentVideos(addC, videoPaths);
            System.out.println(addC);
            System.out.println("check1" + addIm);
            System.out.println("check2" + addVideo);
//        boolean addComment = comDAO.addCommentWithMedia(productid, person.getPersonID(), comment, ImagePaths, videoPaths, date2);
            response.sendRedirect("product-detail?ProductID=" + productid);

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
