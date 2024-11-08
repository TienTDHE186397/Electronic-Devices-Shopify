package Controller;

import DAO.DBContext;
import DAO.FeedbackDAO;
import DAO.FeedbackService;
import DAO.MyOrderDAO;
import Entity.Feedback;
import Entity.MyOrder;
import Entity.Person;
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
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "FeedbackformServlet", urlPatterns = {"/Feedback"})
//Cấu hình các giới hạn kích thước cho tệp tải lên
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1 MB
    maxFileSize = 1024 * 1024 * 20,  // 20 MB
    maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class FeedbackformServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FeedbackformServlet.class.getName());
    private FeedbackService feedbackService; //Đối tượng dịch vụ xử lý phản hồi
    private static final String UPLOAD_DIRECTORY = "D:\\SWP_Presentation\\webdientu\\web\\uploadfeeback"; // Thư mục lưu trữ tệp tải lên (đường dẫn tuyệt đối trong hệ thống).

    @Override
    public void init() throws ServletException {
        try {
            File uploadDir = new File(UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                logger.info("Upload directory created: " + created);
            }
            DBContext dBContext = new DBContext();
            feedbackService = new FeedbackService(UPLOAD_DIRECTORY, dBContext);
            logger.info("FeedbackController initialized successfully");
        } catch (Exception e) {
            logger.severe("Error initializing FeedbackController: " + e.getMessage());
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FeedbackformServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeedbackformServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Display information of user who want to submit feedback
        HttpSession session = request.getSession();
        Person user = (Person) session.getAttribute("user");
        String orderID = request.getParameter("orderID");
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
       

        MyOrderDAO dao = new MyOrderDAO();
        List<MyOrder> orderProducts = dao.getProductListInfoByOrderID(orderID);
        request.setAttribute("orderProducts", orderProducts);

        request.getRequestDispatcher("Feedback.jsp").forward(request, response);
    }

    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String orderID = request.getParameter("orderID");
        String personID = request.getParameter("customerId");
        String desimg = request.getParameter("descriptionimg");
        String desvid = request.getParameter("descriptionvid");
        try {
            logger.info("Processing new feedback submission");
            String customerIdStr = request.getParameter("customerId");
            String productIdStr = request.getParameter("productId");
            String ratingStr = request.getParameter("rating");

            if (customerIdStr == null || productIdStr == null || ratingStr == null) {
                throw new IllegalArgumentException("Required parameters are missing");
            }

            Feedback feedback = new Feedback();
            feedback.setCusID(customerIdStr);
            feedback.setProID(productIdStr);
            feedback.setRate(Integer.parseInt(ratingStr));
            feedback.setFeedContent(request.getParameter("feedback"));
//                    xử lý file ảnh và video
            Collection<Part> parts = request.getParts();
            logger.info("Number of parts received: " + parts.size());

            Collection<Part> imageParts = new ArrayList<>();
            Collection<Part> videoParts = new ArrayList<>();
            for (Part part : parts) {
                String contentType = part.getContentType();
                String name = part.getName();
                logger.info("Processing part - Name: " + name + ", ContentType: " + contentType);
                if (contentType != null) {
                    if (contentType.startsWith("image/") && "images".equals(name)) {
                        imageParts.add(part);
                    } else if (contentType.equals("video/mp4") && "videos".equals(name)) {
                        videoParts.add(part);
                    }
                }
            }
            logger.info("Number of images found: " + imageParts.size());
            logger.info("Number of videos found: " + videoParts.size());
//                 điều kiện số lượng file ảnh và video
            if (imageParts.size() > 5) {
                throw new IllegalArgumentException("Maximum 5 images allowed");
            }
            if (videoParts.size() > 3) {
                throw new IllegalArgumentException("Maximum 3 videos allowed");
            }

            feedback.setImages(imageParts);
            feedback.setVideos(videoParts);

            feedbackService.processFeedback(feedback, desimg, desvid);

            logger.info("Feedback processed successfully");

            request.setAttribute("message", "Feedback submitted successfully!");
            response.sendRedirect("MyOrderInformation?personID=" + personID + "&orderID=" + orderID);

        } catch (Exception e) {
            logger.severe("Error processing feedback: " + e.getMessage());
            e.printStackTrace();

            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    } 

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
  