/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.CategoryDAO;
import DAO.PersonDAO;
import Entity.Blog;
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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.*;
import java.lang.*;
import java.net.FileNameMap;
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

        BlogListDAO blogDAO = new BlogListDAO();

        List<String> listBlogType = blogDAO.getDistinctOfBlogType();

        request.setAttribute("listType", listBlogType);

        request.getRequestDispatcher("addPost.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        String err = "";
        boolean check = true;
        String blog_type = request.getParameter("blogtype");
        String blog_tittle = request.getParameter("blogtittle");
        String blog_summary = request.getParameter("blogsummary");
        String blog_detail = request.getParameter("blogdetail");
        String blog_status = request.getParameter("blogstatus");
//-------------------------------------------image--------------------------------------------------------
        Part part = request.getPart("blogimage");
        String image = "";
        String realPath = "";
        if (part != null && part.getSize() > 0) {
            realPath = request.getServletContext().getRealPath("blogimages");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            part.write(realPath + "\\" + filename);
//            if (!filename.endsWith(".jpg")) {
  //              err = "File ảnh phải kết thúc với đuôi .jpg";
    //            check = false;
      //          out.println("Blog Img: " + filename + "<br>");
        //    } else {
                image = realPath.substring(realPath.length() - 10, realPath.length()) + "/" + filename;
                out.println("Blog Img: " + filename + "<br>");
          //  }
        
        
        }
        
        
        //-------------------------------------------image--------------------------------------------------------
        Part part[] = request.getPartV("blogimage");
        String image = "";
        String realPath = "";
        if (part != null && part.getSize() > 0) {
            realPath = request.getServletContext().getRealPath("blogimages");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            part.write(realPath + "\\" + filename);
//            if (!filename.endsWith(".jpg")) {
  //              err = "File ảnh phải kết thúc với đuôi .jpg";
    //            check = false;
      //          out.println("Blog Img: " + filename + "<br>");
        //    } else {
                image = realPath.substring(realPath.length() - 10, realPath.length()) + "/" + filename;
                out.println("Blog Img: " + filename + "<br>");
          //  }
        
        
        }
//--------------------------------------------video-------------------------------------------------
        Part part2 = request.getPart("blogvideo");
        String video = "";
        String realPath2 = "";
        if (part2 != null && part2.getSize() > 0) {
            realPath2 = request.getServletContext().getRealPath("blogvideos");
            String filename2 = Path.of(part2.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath2))) {
                Files.createDirectory(Path.of(realPath2));
            }
            
            
            part2.write(realPath2 + "\\" + filename2);
                video = realPath2.substring(realPath2.length() - 10, realPath2.length()) + "/" + filename2;
                out.println("Blog Video: " + filename2 + "<br>");
        }


//--------------------------------------------------------------------------------------------------
        out.println("Blog Type: " + blog_type + "<br>");
        out.println("Blog Title: " + blog_tittle + "<br>");
        out.println("Blog Summary: " + blog_summary + "<br>");
        out.println("Blog Detail: " + blog_detail + "<br>");
        out.println("Blog Status: " + blog_status + "<br>");
        out.println("Blog Image: " + image + "<br>");
        out.println("real path: " + realPath + "<br>");
        
        out.println("Blog Image: " + video + "<br>");
        out.println("real path: " + realPath2 + "<br>");

//            LocalDate currentDate = LocalDate.now();
//             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formattedDate = currentDate.format(formatter);
//             
////        HttpSession session = request.getSession();
//            PersonDAO perDAO = new PersonDAO();
//                BlogListDAO blogDAO = new BlogListDAO();
//                List<Blog> list = blogDAO.getAllBlog();
//            Blog b = new Blog(list.size() + 1,
//                    blog_image, 
//                    blog_tittle,
//                    blog_type,
//                    blog_summary,
//                    formattedDate,
//                    blog_detail,
//                    0 ,
//                    blog_status,
//                    person);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
