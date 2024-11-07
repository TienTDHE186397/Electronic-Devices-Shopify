/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DBContext;
import DAO.FeedbackDAO;
import DAO.FeedbackService;
import DAO.mediaDAO;
import Entity.Feedback;
import Entity.Person;
import Entity.media;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author admin
 */
@WebServlet(name = "FeedbackDetailServlet", urlPatterns = {"/FeedbackDetail"})

public class FeedbackDetailServlet extends HttpServlet {
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
            out.println("<title>Servlet FeedbackDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeedbackDetailServlet at " + request.getContextPath() + "</h1>");
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
    String action = request.getParameter("action");
        
        // Nếu là request để stream media
        if ("getMedia".equals(action)) {
            handleMediaStream(request, response);
            return;
        }
       

        // code for displaying feedback details
        FeedbackDAO feedbackDao = new FeedbackDAO();
        mediaDAO mediadao = new mediaDAO();
        String feedbackID = request.getParameter("feedbackID");
        try {
            List<Feedback> fb = feedbackDao.getDetails(feedbackID);
            List<Person> lp = feedbackDao.getAllMkt();
            List<media> ml = mediadao.getALl(feedbackID);

            // Cập nhật đường dẫn để sử dụng servlet streaming
            for (media media : ml) {
                media.setFilePath(request.getContextPath()
                        + "/FeedbackDetail?action=getMedia&feedbackID="
                        + feedbackID + "&fileName=" + media.getStoredFileName());
            }

            request.setAttribute("fList", fb);
            request.setAttribute("mList", lp);
            request.setAttribute("mediaList", ml);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("FeedbackDetail.jsp").forward(request, response);
    }

    private void handleMediaStream(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String feedbackID = request.getParameter("feedbackID");
        String fileName = request.getParameter("fileName");

        if (feedbackID == null || fileName == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String filePath = "E:\\PEPRJ301P\\webdientu\\web\\uploadfeedback\\feedback_"
                + feedbackID + File.separator + fileName;
        File file = new File(filePath);

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Get media type from filename
        String contentType;
        if (fileName.toLowerCase().endsWith(".mp4")) {
            contentType = "video/mp4";
        } else if (fileName.toLowerCase().endsWith(".webm")) {
            contentType = "video/webm";
        } else if (fileName.toLowerCase().endsWith(".jpg")
                || fileName.toLowerCase().endsWith(".jpeg")) {
            contentType = "image/jpeg";
        } else if (fileName.toLowerCase().endsWith(".png")) {
            contentType = "image/png";
        } else {
            contentType = getServletContext().getMimeType(fileName);
        }

        // Set response headers
        response.setContentType(contentType);
        response.setContentLength((int) file.length());

        if (contentType.startsWith("video/")) {
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
        }

        // Stream the file
        try (java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.io.FileInputStream(file)); java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(response.getOutputStream())) {

            byte[] buffer = new byte[8192];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
        }
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
        //update Status's Feedback
        String feedbackID = request.getParameter("feedbackID");
        if (feedbackID == null || feedbackID.isEmpty()) {
    throw new IllegalArgumentException("Feedback ID is invalid");
        }

        String status = request.getParameter("statusUpdate");
        String mktfeedback = request.getParameter("feedbackPerson");
        if (mktfeedback == null || mktfeedback.isEmpty()) {
            mktfeedback = request.getParameter("feedbackPersonHidden");
        }
        FeedbackDAO updateDAO = new FeedbackDAO();
        try {
            Feedback f = new Feedback(status, mktfeedback, feedbackID);
            updateDAO.Update(f);
            response.sendRedirect("FeedbackDetail?feedbackID=" + feedbackID + "&statusUpdate=success");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("failure: " + e.getMessage());
            return;
        }
    }
    

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
