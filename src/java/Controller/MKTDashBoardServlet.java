
package Controller;

import DAO.BlogListDAO;
import DAO.DAOPerson;
import DAO.FeedbackDAO;
import DAO.ProductListDAO;
import Entity.Blog;
import Entity.Feedback;
import Entity.Person;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.lang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MKTDashBoardServlet", urlPatterns = {"/mktdashboard"})
public class MKTDashBoardServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MKTDashBoardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MKTDashBoardServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy Dữ Liệu Từ DAO
        BlogListDAO bDAO = new BlogListDAO();
        ProductListDAO pDAO = new ProductListDAO();
        FeedbackDAO fDAO = new FeedbackDAO();
        DAOPerson perDAO = new DAOPerson();
        // Gán Ngày Bắt Đầu Và Ngày Kết Thức
        String fromdate = request.getParameter("fromdate");
        String todate = request.getParameter("todate");
        // Format theo định dạng năm-tháng-ngày 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();
        // Check ngày bắt đầu có được truyền vào URL hay không
        // Nếu như không đặt ngày From date thành mốc thời gian của 7 ngày tính từ ngày hiện tại
        if (fromdate == null || fromdate.isBlank()) {
            LocalDate previousDate = currentDate.minusDays(7);
            fromdate = previousDate.format(formatter);
        }
        // Check đến ngày nào có được truyền vào URL hay không
        // Nếu như không đặt To date thành mốc thời gian của ngày tính từ ngày hôm nay
        if (todate == null || todate.isBlank()) {
            todate = currentDate.format(formatter);
        }
        request.setAttribute("fromdate", fromdate);
        request.setAttribute("todate", todate);
        // Lấy năm tháng ngày của 2 mốc thời gian fromdate và todate
        String[] date1 = fromdate.split("-");
        String[] date2 = todate.split("-");
        // Đặt biến kiểm tra toDate có nhỏ hơn fromDate hay không để thực hiện thay đổi
        boolean check = false;
        boolean checkMonth = false;
        if (Integer.parseInt(date1[0]) - Integer.parseInt(date2[0]) > 0) {
            check = true;
        }
        if (Integer.parseInt(date1[1]) - Integer.parseInt(date2[1]) > 0) {
            check = true;
            checkMonth = true;
        }
        if (checkMonth) {
            if (Integer.parseInt(date1[2]) - Integer.parseInt(date2[2]) > 0) {
                check = true;
            }
        }
        // nếu như fromDate > toDate thì thực hiện thay đổi giá trị của 2 ngày FromDate và ToDate
        if (check) {
            String changedate = "";
            changedate = fromdate;
            fromdate = todate;
            todate = changedate;
        }
        // List Blog and Blog(FromDate -> ToDate)
        List<Blog> listAllBlog = bDAO.getAllBlog();
        List<Blog> listB = bDAO.getBlogMKTDashBoard(fromdate, todate);
        request.setAttribute("listAllBlog", listAllBlog);
        request.setAttribute("listB", listB);
        //List All Product and Product(FromDate -> ToDate)
        List<Product> listAllProduct = pDAO.getAllProduct();
        List<Product> listP = pDAO.getProductMKTDashBoard(fromdate, todate);
        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listP", listP);
        //List All FeedBack and FeedBack (FromDate -> ToDate)
        List<Feedback> listAllFeedBack = fDAO.getAllFeedbacks();
        List<Feedback> listF = fDAO.getFeedBackMKTDashBoard(fromdate, todate);
        request.setAttribute("listAllFeedBack", listAllFeedBack);
        request.setAttribute("listF", listF);
        //List All Person and Person (FromDate -> ToDate)
        List<Person> listAllPerson = perDAO.getAllPerson();
        request.setAttribute("listAllPerson", listAllPerson);
        request.getRequestDispatcher("mktdashboard.jsp").forward(request, response);
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
