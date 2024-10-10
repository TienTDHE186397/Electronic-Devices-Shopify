<%-- 
    Document   : video
    Created on : Sep 30, 2024, 4:54:29 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <video width="200" height="250" controls>
            <source src="<%= request.getContextPath()%>/video?name=img/default-vid.mp4" type="video/mp4">
            Your browser does not support the video tag.
        </video>
    </body>
</html>
