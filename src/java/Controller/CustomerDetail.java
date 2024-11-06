/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOCustomer;
import DAO.HistoryChangeDAO;
import Entity.HistoryChange;
import Entity.Person;
import Entity.PersonImage;
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
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dokkuhai
 */
@WebServlet(name = "CustomerDetail", urlPatterns = {"/customer-detail"})
@MultipartConfig
public class CustomerDetail extends HttpServlet {

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
            out.println("<title>Servlet CustomerDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerDetail at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        int cusid = Integer.parseInt(id);
        DAOCustomer customerDAO = new DAOCustomer();
        HistoryChangeDAO historyDAO = new HistoryChangeDAO();
        Person customer = customerDAO.getPersonById(cusid);
        List<PersonImage> images = customerDAO.getPersonImageByPersonId(cusid);
        List<HistoryChange> historyList = null;
//======================================================================         
        int pageIndex = 1; // Mặc định là trang 1
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        int pageSize = 10; // Số bản ghi trên mỗi trang

        // Lấy danh sách lịch sử thay đổi
        historyList = historyDAO.getHistoryChangesByPage(cusid, pageIndex, pageSize);

        // Tính tổng số bản ghi
        int totalCount = historyDAO.getTotalHistoryChangesCount(cusid);
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        if (pageIndex > totalPages) {
            pageIndex = totalPages;
            historyList = historyDAO.getHistoryChangesByPage(cusid, pageIndex, pageSize);
        }

        request.setAttribute("historyList", historyList);
        request.setAttribute("customerDetail", customer);
        request.setAttribute("id", cusid);
        request.setAttribute("currentPage", pageIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("listImages", images);
//=======================================================================
        request.getRequestDispatcher("CustomerDetail.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Đặt đường dẫn lưu ảnh mặc định
    private static final String UPLOAD_DIRECTORY = "img";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOCustomer customerDAO = new DAOCustomer();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String dob = request.getParameter("dateOfBirth");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String image_id = request.getParameter("imgEdit");
        int id = Integer.parseInt(request.getParameter("id"));
        if(!image_id.equals("0")){
            int image = Integer.parseInt(image_id);
            boolean check1 = customerDAO.updatePersonImage(id, image);
        }
        
        
        String userName = request.getParameter("userName");
   
        //Update thông tin khách hàng
        
        HistoryChangeDAO historyDAO = new HistoryChangeDAO();
        SimpleDateFormat format = new SimpleDateFormat();

        // Kiểm tra nếu dob không null và không rỗng trước khi chuyển đổi thành java.sql.Date
        java.sql.Date dateOfBirth = java.sql.Date.valueOf(dob);

        boolean check = customerDAO.updateCustomer(id, name, gender, dateOfBirth, email);
        boolean check2 = customerDAO.updatePersonAddress(id, address);

        //Thêm bản ghi
        HistoryChange history = new HistoryChange(id, email, name, gender, phone, address, userName);
        boolean check3 = historyDAO.addHistoryChange(history);
        if (check && check2 && check3) {
            response.sendRedirect("customer-detail?id=" + id + "&success=true");
        } else {
            response.sendRedirect("customer-detail?id=" + id + "&success=false");
        }

        //Thêm ảnh, video
        String realVideoPath = request.getServletContext().getRealPath("/img");
        String realImagePath = request.getServletContext().getRealPath("/img");

        //---------------------------------------------------------------------------------------------------------------------------------
        // Giả định rằng bạn đã có một danh sách để lưu trữ các đường dẫn video
        List<String> videoPaths = new ArrayList<>();
        List<String> videoNotes = new ArrayList<>();
        // Lặp qua các phần của request
        if (videoPaths != null) {
            for (Part part : request.getParts()) {
                if (part.getName().equals("vidValue")) {
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
                } else if (part.getName().equals("vidName")) {
                    // Xử lý ghi chú
                    String note = request.getParameter(part.getName());
                    videoNotes.add(note); // Lưu ghi chú
                }
            }
        }

        System.out.println("videoPaths: " + videoPaths);
        System.out.println("videoNotes: " + videoNotes);
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

                        // Ghi ảnh vào thư mục
                        part.write(realVideoPath + File.separator + IMGFilename);

                        // Kiểm tra định dạng ảnh
                        if (IMGFilename.endsWith(".jpg")) {
                            ImagePaths.add("img/" + IMGFilename); // Lưu đường dẫn ảnh
                        } else {
                            ImagePaths.add("img/default-phone.jpg"); // Lưu đường dẫn ảnh mặc định nếu không phải .mp4
                        }
                    }
                } else if (part.getName().equals("vidImageName")) {
                    // Xử lý ghi chú
                    String note = request.getParameter(part.getName());
                    ImageNotes.add(note); // Lưu ghi chú
                }
            }
        }
        System.out.println("ImagePaths: " + ImagePaths);
        System.out.println("ImageNotes: " + ImageNotes);
        int i=0;
         // Lưu video vào cơ sở dữ liệu
        for (String videoPath : videoPaths) {
            String altText = "Video" + i++;
            customerDAO.addVideoPerson(id, videoPath, altText);
        }

        // Lưu ảnh vào cơ sở dữ liệu
        for (String imagePath : ImagePaths) {
            String altText = "Ảnh cá nhân";
            boolean isPrimary = false; // Cài đặt giá trị tùy ý
            customerDAO.addImgPerson(id, imagePath, altText);
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
