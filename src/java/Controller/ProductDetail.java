/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.DAOProduct;
import Entity.Product;
import Entity.ProductAttribute;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;

/**
 *
 * @author admin
 */
@WebServlet(name = "ProductDetail", urlPatterns = {"/ProductDetail"})
public class ProductDetail extends HttpServlet {

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
            out.println("<title>Servlet ProductDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetail at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("ID"));
        DAOProduct pd = new DAOProduct();
        Product product = pd.getProductById(id);
        List attribute = pd.getProductAttributesById(id);
        CategoryDAO cd = new CategoryDAO();
        List category = cd.getAllCategory();
        request.setAttribute("pro", product);
        request.setAttribute("attribute", attribute);
        request.setAttribute("category", category);
        request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idhi"));
        String title = request.getParameter("title");
        String productName = request.getParameter("productName");
        String img = request.getParameter("image");
        String views = request.getParameter("views");
        String publisher = request.getParameter("publisher");
        String releaseDate = request.getParameter("releaseDate");
        String category = request.getParameter("category");
        String sale = request.getParameter("sale");
        String quantity = request.getParameter("quantity");
        String newAttributeName = request.getParameter("");
        boolean updateSuccessful = true; // Cờ để kiểm tra thành công
        DAOProduct productAttributesDAO = new DAOProduct();
        String[] newAttributeNames2 = request.getParameterValues("attributeName2");
        String[] newAttributeValues2 = request.getParameterValues("attributeValue2");
        String[] newAttributeNames = request.getParameterValues("attributeName");
        String[] newAttributeValues = request.getParameterValues("attributeValue");
        String[] oldAttributeNames = request.getParameterValues("oldAttributeName");

        if (oldAttributeNames != null) {
            for (int i = 0; i < oldAttributeNames.length; i++) {
                String oldName = oldAttributeNames[i];
                String newName = newAttributeNames[i];
                String value = newAttributeValues[i];

                if (newName != null && value != null) {
                    boolean check = productAttributesDAO.updateProductAttributes(id, oldName, newName, value);
                    if (!check) {
                        updateSuccessful = false;
                    } else {
                        System.out.println("cap nhat thanh cong");
                    }
                }
            }
        }

        if (newAttributeNames2 != null && newAttributeValues2 != null) {
            for (int i = 0; i < newAttributeNames2.length; i++) {
                boolean exists = false;
                String newName2 = newAttributeNames2[i];
                String value2 = newAttributeValues2[i];
                if (oldAttributeNames != null) {
                    for (String oldName : oldAttributeNames) {
                        if (oldName.equals(newName2)) {
                            exists = true;
                            break;
                        }
                    }
                }

                if (!exists && value2 != null) {
                    productAttributesDAO.addProductAttribute(id, newName2, value2);
                }
            }
        }
        if (updateSuccessful) {
            response.sendRedirect("ListProduct");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Gọi phương thức update để cập nhật thuộc tính sản phẩm
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
