/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Email;

// RegisterServlet.java
import DAO.PersonDAO;
import Entity.ImgPerson;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig()
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassword at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("resend".equals(action)) {
            resendVerificationCode(request, response);
        } else {
            registerUser(request, response);
        }
    }
    private static final String UPLOAD_DIRECTORY = "img";

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        String gender = request.getParameter("gender");
        String age = request.getParameter("date");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String realVideoPath = request.getServletContext().getRealPath("/img");
        System.out.println(gender);
        System.out.println(address);
        System.out.println(phone);
        PasswordUtils pw = new PasswordUtils();
        String passHash = pw.shiftPassword(password);
        String rePassHash = pw.shiftPassword(repassword);
        String image = "img/default-phone.jpg";
        String realImagePath = request.getServletContext().getRealPath("/img");
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
        System.out.println("ImagePaths: " + ImagePaths);
        System.out.println("ImageNotes: " + ImageNotes);
        //--------------------------------------------------------------------------
        if (!passHash.equals(rePassHash)) {
            request.setAttribute("error", "Mật khẩu không khớp!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.isEmailExists(email)) {
            request.setAttribute("error", "Email already exists. Please use a different email.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (age != null && !age.isEmpty()) {
            LocalDate birthDate = LocalDate.parse(age);
            LocalDate today = LocalDate.now();
            int age2 = Period.between(birthDate, today).getYears();

            if (age2 < 18) {
                request.setAttribute("error", "Bạn chưa đủ 18 tuổi.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("error", "Vui lòng nhập ngày sinh hợp lệ.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Generate verification code
        String verificationCode = generateVerificationCode();

        // Send verification code
        MailSender.sendVerificationEmail(email, verificationCode);

        // Store user info and verification code in session
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(120);
         session.setAttribute("tempImageName", ImageNotes);
        session.setAttribute("tempImageValue", ImagePaths);
        session.setAttribute("tempVideoName", videoNotes);
        session.setAttribute("tempVideoValue", videoPaths);
        session.setAttribute("tempAge", age);
        session.setAttribute("tempName", name);
        session.setAttribute("tempAge", age);
        session.setAttribute("tempEmail", email);
        session.setAttribute("tempGender", gender);
        session.setAttribute("tempPhone", phone);
        session.setAttribute("tempAddress", address);
        session.setAttribute("tempPassword", passHash);
        session.setAttribute("verificationCode", verificationCode);
        System.out.println("Session" + session.getAttribute("tempVideoName"));
        System.out.println("Session" + session.getAttribute("tempVideoValue"));
        System.out.println("Session" + session.getAttribute("verificationCode"));
        // Redirect to verification page
        response.sendRedirect("verifyEmail.jsp");
    }

    private void resendVerificationCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newCode = generateVerificationCode();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("tempEmail");
        if (email == null || email.isEmpty()) {
            request.setAttribute("error", "Không tìm thấy địa chỉ email. Vui lòng thử lại.");
            request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
            return;
        }
        session.setAttribute("verificationCode", newCode);
        MailSender.sendVerificationEmail(email, newCode);
        response.sendRedirect("verifyEmail.jsp");
    }

    private String generateVerificationCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return code.toString();
    }
}
