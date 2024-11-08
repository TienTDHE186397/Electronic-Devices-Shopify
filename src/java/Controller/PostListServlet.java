/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Categories;
import DAO.BlogListDAO;
import Entity.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;

@WebServlet(name = "PostListServlet", urlPatterns = {"/PostListMKT"})
public class PostListServlet extends HttpServlet {

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

        BlogListDAO blogDAO = new BlogListDAO();
        String tittlewrite = request.getParameter("tittlewrite");
        String authorwrite = request.getParameter("authorwrite");
        String type1 = request.getParameter("type1");
        String statusf = request.getParameter("statusf");
        String sort = request.getParameter("sort");
        String event = request.getParameter("event");
        String page = request.getParameter("page");
        String numberofpage = request.getParameter("numberofpage");
        String[] col = request.getParameterValues("col");
        request.setAttribute("nof", numberofpage);
        request.setAttribute("tittlewrite", tittlewrite);
        request.setAttribute("authorwirte", authorwrite);
        request.setAttribute("type1", type1);
        request.setAttribute("statusf", statusf);
        request.setAttribute("sort", sort);
        request.setAttribute("event", event);
        if (page == null || page.equals("")) {
            page = "1";
        }

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
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        request.setAttribute("uri", uri);
        request.setAttribute("queryString", queryString);

        if (tittlewrite == null && authorwrite == null && type1 == null && statusf == null && sort == null && event == null && numberofpage == null) {

            List<Blog> listB = blogDAO.getAllBlog();
            List<String> listBlogType = blogDAO.getDistinctOfBlogType();
            int postPerPage = blogDAO.getAllBlog().size();
            int totalpage = (int) Math.ceil((double) listB.size() / postPerPage);

            List<Blog> listBp = blogDAO.getBlogPerPage(Integer.parseInt(page), postPerPage);

            request.setAttribute("listBp", listBp);
            request.setAttribute("totalP", String.valueOf(totalpage));
            request.setAttribute("listB", listB);
            request.setAttribute("listBlogType", listBlogType);
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("page", page);
            request.getRequestDispatcher("PostList.jsp").forward(request, response);

        } else {
            try {
                int postPerPage = Integer.parseInt(numberofpage);
                List<Blog> listB2 = blogDAO.searchBlogList2(tittlewrite, authorwrite, type1, statusf, sort, event, page);
                List<Blog> listB = blogDAO.getAllBlog();
                List<Blog> listBp = blogDAO.searchBlogList(tittlewrite, authorwrite, type1, statusf, sort, event, page, postPerPage);
                List<String> listBlogType = blogDAO.getDistinctOfBlogType();
                int totalpage = (int) Math.ceil((double) listB2.size() / postPerPage);
                request.setAttribute("listB", listB);
                request.setAttribute("totalP", String.valueOf(totalpage));
                request.setAttribute("listBp", listBp);
                request.setAttribute("listBlogType", listBlogType);
                request.getRequestDispatcher("PostList.jsp").forward(request, response);
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
