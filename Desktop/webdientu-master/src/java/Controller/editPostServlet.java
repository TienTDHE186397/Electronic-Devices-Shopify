package Controller;

import DAO.BlogListDAO;
import DAO.DAOPerson;
import Entity.Blog;
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

@WebServlet(name = "editPostServlet", urlPatterns = {"/editPost"})
@MultipartConfig
public class editPostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editPostServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editPostServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BlogListDAO blogDAO = new BlogListDAO();

        List<String> listBlogType = blogDAO.getDistinctOfBlogType();

        String id_raw = request.getParameter("id");

        try {
            int id = Integer.parseInt(id_raw);
            Blog b = blogDAO.getBlogById(id);
            request.setAttribute("blog", b);

        } catch (Exception e) {

        }

        request.setAttribute("listType", listBlogType);

        request.getRequestDispatcher("editPost.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String err1 = "";
        String err2 = "";
        boolean check = true;
        String blog_type = request.getParameter("blogtype");
        String blog_tittle = request.getParameter("blogtittle");
        String blog_summary = request.getParameter("blogsummary");
        String blog_detail = request.getParameter("blogdetail");
        String blog_status = request.getParameter("blogstatus");
        String blog_flag = request.getParameter("blogflag");
        String image_tittle = request.getParameter("imagetittle");
//-------------------------------------------image--------------------------------------------------------
        Part part = request.getPart("blogimage");
        String blog_image = "";
        String realPath = "";
        if (part != null && part.getSize() > 0) {
            realPath = request.getServletContext().getRealPath("blogimages");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            part.write(realPath + "\\" + filename);
            if (!filename.endsWith(".jpg")) {
                err1 = "File ảnh phải kết thúc với đuôi .jpg";
                check = false;
            } else {
                blog_image = realPath.substring(realPath.length() - 10, realPath.length()) + "/" + filename;
            }
        }
//--------------------------------------------------------------------------------------------------
        int blog_flag_i = 0;
        try {
            blog_flag_i = Integer.parseInt(blog_flag);
        } catch (Exception e) {
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        HttpSession session = request.getSession();

        DAOPerson perDAO = new DAOPerson();

        Person person = perDAO.getPersonById("6");

        BlogListDAO blogDAO = new BlogListDAO();

        String id_raw = request.getParameter("id");
        

        try {
            int id = Integer.parseInt(id_raw);
            Blog b = blogDAO.getBlogById(id);
            if (blog_image.equals("")) {

            } else {
                b.setBlog_img(blog_image);
            }
            b.setBlog_img_tittle(image_tittle);
            b.setBlog_tittle(blog_tittle);
            b.setBlog_type(blog_type);
            b.setBlog_summary_information(blog_summary);
            b.setBlog_update_time(formattedDate);
            b.setBlog_detail(blog_detail);
            b.setBlog_status(blog_status);
            b.setBlog_flag(blog_flag_i);

            
            blogDAO.editBlog(b, person);

        } catch (Exception e) {

        }

        response.sendRedirect("PostListMKT");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
