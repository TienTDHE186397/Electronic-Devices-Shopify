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

        HttpSession session = request.getSession();
        BlogListDAO blogDAO = new BlogListDAO();
        String search = request.getParameter("search");
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
        if (page == null || page.isBlank()) {
            page = "1";
        }
        if (search != null) {
            session.setAttribute("search", search);
        }
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        request.setAttribute("uri", uri);
        request.setAttribute("queryString", queryString);

        if (search == null && numberofpage == null) {

            List<Blog> listB = blogDAO.getAllBlog();
            List<String> listBlogType = blogDAO.getDistinctOfBlogType();
            int postPerPage = blogDAO.getAllBlog().size();
            int totalpage = (int) Math.ceil((double) listB.size() / postPerPage);

            List<Blog> listBp = blogDAO.getBlogPerPage(Integer.parseInt(page), postPerPage);

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

            try {

                int postPerPage = Integer.parseInt(numberofpage);
                List<Blog> listB2 = blogDAO.searchBlogListHome2(search, page);
                List<Blog> listB = blogDAO.getAllBlog();
                List<Blog> listBp = blogDAO.searchBlogListHome(search, page, postPerPage);
                List<String> listBlogType = blogDAO.getDistinctOfBlogType();

                int totalpage = (int) Math.ceil((double) listB2.size() / postPerPage);

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
