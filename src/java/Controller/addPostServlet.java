/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.CategoryDAO;
import DAO.DAOPerson;
import DAO.PersonDAO;
import Entity.Blog;
import Entity.Categories;
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
import java.util.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "addPostServlet", urlPatterns = {"/addPost"})
@MultipartConfig
public class addPostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addPostServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addPostServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Blog List 
        CategoryDAO cDAO = new CategoryDAO();
        List<Categories> listBlogType = cDAO.getAllCategory();
        request.setAttribute("listType", listBlogType);
        request.getRequestDispatcher("addPost.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String err1 = "";
        String err2 = "";
        String err3 = "";
        boolean check = true;
        // Nhận Các Giá Trị Đầu Vào Từ Add New Blog
        String blog_type = request.getParameter("blogtype");
        String blog_tittle = request.getParameter("blogtittle");
        String blog_summary = request.getParameter("blogsummary");
        String blog_detail = request.getParameter("blogdetail");
        String blog_status = request.getParameter("blogstatus");
        String blog_flag = request.getParameter("blogflag");
        String image_tittle = request.getParameter("imagetittle");
        // Nhận Ảnh đầu vào từ input file
        Part part = request.getPart("blogimage");
        String blog_image = "";
        String realPath = "";
        try {
            if (part != null && part.getSize() > 0) {
                realPath = request.getServletContext().getRealPath("blogimages");
                String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Path.of(realPath))) {
                    Files.createDirectory(Path.of(realPath));
                }
                part.write(realPath + "\\" + filename);
                if (!filename.endsWith(".jpg") || filename == null) {
                    err1 = "File ảnh phải kết thúc với đuôi .jpg<br/>";
                    check = false;
                } else {
                    blog_image = realPath.substring(realPath.length() - 10, realPath.length()) + "/" + filename;
                }
            } else {
                err1 = "Image Blog không được để thiếu !!<br/>";
                check = false;
            }
        } catch (Exception e) {
            check = false;
            err1 = "File truyền vào không hợp lệ!!<br/>";
        }
        // Check -- Validate

        if (blog_type.equals("")) {
            err2 = "Hãy chọn Type Blog ! <br/>";
            check = false;
        }
        // Gắn Cờ Cho Bài Blog
        int blog_flag_i = 0;
        try {
            blog_flag_i = Integer.parseInt(blog_flag);
        } catch (Exception e) {
        }
        // Lầy thời gian cho ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        // Lấy Session của người dùng

        HttpSession session = request.getSession();
        DAOPerson perDAO = new DAOPerson();
        Person p = (Person) session.getAttribute("user");

        if (p == null) {
            check = false;
            err3 = "Lỗi hệ thống vui lòng đăng nhập lại để thực hiện chức năng !! <br/>";
            request.setAttribute("err3", err3);
            doGet(request, response);
            return;
        }
        // Lấy danh sách các bài Blog
        BlogListDAO blogDAO = new BlogListDAO();
        List<Blog> list = blogDAO.getAllBlog();
        //Xử Lý -- Validate
        if (!check) {
            // Set Lỗi
            request.setAttribute("err1", err1);
            request.setAttribute("err2", err2);

            // Gán lại giá trị đã nhập vào
            request.setAttribute("blog_tittle", blog_tittle);
            request.setAttribute("blog_summary", blog_summary);
            request.setAttribute("blog_detail", blog_detail);
            request.setAttribute("image_tittle", image_tittle);

            doGet(request, response);
            return;
        }

        Person person = perDAO.getPersonById(String.valueOf(p.getPersonID()));

        // Tạo Blog Mới
        Blog b = new Blog(list.size() + 1,
                blog_image,
                image_tittle,
                blog_tittle,
                blog_type,
                blog_summary,
                formattedDate,
                blog_detail,
                0,
                blog_status,
                blog_flag_i,
                person);
        // Insert bài Blog Mới 
        blogDAO.insertBlog(b, person);
        response.sendRedirect("PostListMKT");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
