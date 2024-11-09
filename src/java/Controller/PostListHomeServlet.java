package Controller;

import DAO.BlogListDAO;
import Entity.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import java.lang.*;

@WebServlet(name = "PostListHomeServlet", urlPatterns = {"/PostListHome"})
public class PostListHomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin tìm kiếm của người dùng
        HttpSession session = request.getSession();
        BlogListDAO blogDAO = new BlogListDAO();
        String search = request.getParameter("search");
        // Lấy thông tin trang của người dùng tìm kiếm
        String page = request.getParameter("page");
        List<Blog> listRB = blogDAO.trendingBlogList();
        String numberofpage = request.getParameter("numberofpage");
        String[] col = request.getParameterValues("col");
        request.setAttribute("nof", numberofpage);
        if (col != null) {
            for (int i = 0; i < col.length; i++) {
                request.setAttribute(col[i], col[i]);
            }
        }
        if (numberofpage != null) {
            if (numberofpage.isBlank() || numberofpage.matches("0+")) {
                numberofpage = String.valueOf(blogDAO.getAllBlog().size());
            }
        }
        // Nếu không truyền Page vào hoặc page = ""
        if (page == null || page.isBlank()) {
            page = "1";
        }
        if (search != null) {
            session.setAttribute("search", search);
        }
        // Lẩy Uri hiện tại của trang web và queryString hiện tại của trang Web
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        request.setAttribute("uri", uri);
        request.setAttribute("queryString", queryString);

        // Nếu như search  và numberofpage bị Null khi truyền vào trang web thì nó sẽ hiện thị danh sách Blog như bình thường
        if (search == null && numberofpage == null) {
            // Lấy danh sách Blog
            List<Blog> listB = blogDAO.getAllBlog();
            List<String> listBlogType = blogDAO.getDistinctOfBlogType();
            // Lấy số bài đăng mỗi trang
            int postPerPage = blogDAO.getAllBlog().size();
            //Lấy Tổng Số Trang hiện thị khi số bài đăng mỗi trang được nhập vào
            int totalpage = (int) Math.ceil((double) listB.size() / postPerPage);
            // Lấy danh sách bài đăng mỗi trang
            List<Blog> listBp = blogDAO.getBlogPerPageHome(Integer.parseInt(page), postPerPage);
            // Set Attribute
            request.setAttribute("search", search);
            request.setAttribute("listRB", listRB);
            request.setAttribute("listBp", listBp);
            request.setAttribute("totalP", String.valueOf(totalpage));
            request.setAttribute("listB", listB);
            request.setAttribute("listBlogType", listBlogType);
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("page", page);
            request.getRequestDispatcher("PostListHome.jsp").forward(request, response);
        } else {
            // Nếu như search và numberofpage được truyền vào thông qua URL thì thực hiện yêu cầu dưới
            try {   
                // Lấy Bài Đăng Mỗi Trang
                int postPerPage = Integer.parseInt(numberofpage);
                // Lấy tổng số bài đăng theo tìm kiếm để chia cho số trang
                List<Blog> listB2 = blogDAO.searchBlogListHome2(search, page);
                // Lấy Tất cả bài đăng
                List<Blog> listB = blogDAO.getAllBlog();
                // Lấy Danh Sách Bài Đăng tìm kiếm theo phân trang
                List<Blog> listBp = blogDAO.searchBlogListHome(search, page, postPerPage);
                // Lấy Danh Sách Loại Bài Đăng
                List<String> listBlogType = blogDAO.getDistinctOfBlogType();
                // Lấy Tổng Số Trang
                int totalpage = (int) Math.ceil((double) listB2.size() / postPerPage);
                // Set Attribute
                request.setAttribute("search", search);
                request.setAttribute("listRB", listRB);
                request.setAttribute("listB", listB);
                request.setAttribute("totalP", String.valueOf(totalpage));
                request.setAttribute("listBp", listBp);
                request.setAttribute("listBlogType", listBlogType);
                request.setAttribute("totalpage", totalpage);
                request.setAttribute("page", page);
                request.getRequestDispatcher("PostListHome.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
