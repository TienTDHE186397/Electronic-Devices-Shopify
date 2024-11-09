/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BlogListDAO;
import DAO.DAOPerson;
import DAO.SliderListDAO;
import Entity.Blog;
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

@WebServlet(name = "editSliderServlet", urlPatterns = {"/editSlider"})
@MultipartConfig
public class editSliderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editSliderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editSliderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_raw = request.getParameter("id");

        SliderListDAO sDAO = new SliderListDAO();

        try {
            int id = Integer.parseInt(id_raw);

            Slider slider = sDAO.getSliderById(id);

            request.setAttribute("slider", slider);
            request.setAttribute("id", id_raw);
            request.getRequestDispatcher("editSlider.jsp").forward(request, response);

        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        String err1 = "";
        String err2 = "";
        boolean check = true;

        String slider_tittle = request.getParameter("slidertittle");
        String slider_backlink = request.getParameter("sliderbacklink");
        String slider_status = request.getParameter("sliderstatus");
        String slider_note = request.getParameter("slidernote");
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
//--------------------------------------------------------------------------------------------------
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        DAOPerson perDAO = new DAOPerson();
        Person person = perDAO.getPersonById("6");
        SliderListDAO sDAO = new SliderListDAO();
        String id_raw = request.getParameter("id");

        try {
            int id = Integer.parseInt(id_raw);

            Slider s = sDAO.getSliderById(id);

            if (image.equals("")) {

            } else {
                s.setSlider_image(image);
            }

            if (video.equals("")) {

            } else {
                s.setSlider_video(video);
            }

            s.setSlider_tittle(slider_tittle);
            s.setSlider_backlink(slider_backlink);
            s.setSlider_date(formattedDate);
            s.setSlider_note(slider_note);
            s.setSlider_status(slider_status);
            

            sDAO.updateSlider(s, person);

        } catch (Exception e) {
            

        }
        
        response.sendRedirect("SliderListMKT");
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
