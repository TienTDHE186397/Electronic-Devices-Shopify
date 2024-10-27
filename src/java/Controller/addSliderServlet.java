/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOPerson;
import DAO.SliderListDAO;
import Entity.Person;
import Entity.Slider;
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

@WebServlet(name = "addSliderServlet", urlPatterns = {"/addSlider"})
@MultipartConfig
public class addSliderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addSliderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addSliderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addSlider.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String slider_tittle = request.getParameter("slidertittle");
        String slider_backlink = request.getParameter("sliderbacklink");
        String slider_status = request.getParameter("sliderstatus");
        String slider_note = request.getParameter("slidernote");

        PrintWriter out = response.getWriter();
        String err1 = "";
        String err2 = "";
        boolean check = true;

        if (slider_tittle == null && slider_backlink == null && slider_status == null && slider_note == null) {
            request.getRequestDispatcher("addSlider.jsp").forward(request, response);
        } else {
//-------------------------------------------image--------------------------------------------------------
            Part part = request.getPart("sliderimage");
            String image = "";
            String realPath = "";
            if (part != null && part.getSize() > 0) {
                realPath = request.getServletContext().getRealPath("sliderimages");
                String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Path.of(realPath))) {
                    Files.createDirectory(Path.of(realPath));
                }
                part.write(realPath + "\\" + filename);
                if (!filename.endsWith(".jpg")) {
                    err1 = "File ảnh phải kết thúc với đuôi .jpg";
                    check = false;
                } else {
                    image = realPath.substring(realPath.length() - 12, realPath.length()) + "/" + filename;
                }
            }
//--------------------------------------------video-------------------------------------------------
            Part part2 = request.getPart("slidervideo");
            String video = "";
            String realPath2 = "";
            if (part2 != null && part2.getSize() > 0) {
                realPath2 = request.getServletContext().getRealPath("slidervideos");
                String filename2 = Path.of(part2.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Path.of(realPath2))) {
                    Files.createDirectory(Path.of(realPath2));
                }
                part2.write(realPath2 + "\\" + filename2);
                if (!filename2.endsWith(".mp4")) {
                    err1 = "File ảnh phải kết thúc với đuôi .mp4";
                    check = false;
                } else {
                    video = realPath2.substring(realPath2.length() - 12, realPath2.length()) + "/" + filename2;
                }
            }
//-------------------------------------------------------------------------------------
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            HttpSession session = request.getSession();

            DAOPerson perDAO = new DAOPerson();
        //    session.setAttribute("user", user);
            Person p = (Person)session.getAttribute("user");
            Person person = perDAO.getPersonById(String.valueOf(p.getPersonID()));

            SliderListDAO sDAO = new SliderListDAO();
            List<Slider> list = sDAO.getAllSlider();

            Slider s = new Slider(list.get(list.size() - 1).getSlider_id() + 1,
                    slider_tittle,
                    image,
                    video,
                    slider_backlink,
                    formattedDate,
                    slider_status,
                    slider_note,
                    person);
            sDAO.insertSlider(s, person);
            response.sendRedirect("SliderListMKT");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
