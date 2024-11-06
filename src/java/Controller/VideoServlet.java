/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 *
 * @author admin
 */
@WebServlet(name = "video", urlPatterns = {"/video"})
public class VideoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoName = request.getParameter("name");
        String realPath = getServletContext().getRealPath("/") + videoName; // Thay đổi đường dẫn nếu cần
        File videoFile = new File(realPath);
            
        if (videoFile.exists()) {
            response.setContentType("video/mp4");
            response.setContentLength((int) videoFile.length());
            try (FileInputStream inStream = new FileInputStream(videoFile);
                 OutputStream outStream = response.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}


