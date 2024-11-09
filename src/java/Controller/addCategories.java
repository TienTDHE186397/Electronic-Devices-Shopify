/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import Entity.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;

@WebServlet(name = "addCategories", urlPatterns = {"/addCategory"})
public class addCategories extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addCategories</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addCategories at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("addNewCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoryDAO cDAO = new CategoryDAO();
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        boolean check = true;
        String err = "";
        request.setAttribute("namec", name);
        // Lấy danh sách Categories
        List<Categories> list = cDAO.getAllCategory();
        // Check Lỗi Categories
        for (Categories c1 : list) {
            if (c1.getCategoryName().equals(name)) {
                check = false;
                err = "Category đã tồn tại hãy nhập lại ! ";
                break;
            }
        }
        if (!check) {
            request.setAttribute("err", err);
            doGet(request, response);
            return;
        }
        // Thêm mới categories
        Categories c = new Categories(list.size() + 1, name);
        cDAO.addNewCategories(c);
        if (type.equals("blog")) {
            response.sendRedirect("addPost");
        } else {
            response.sendRedirect("addProductMKT");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
