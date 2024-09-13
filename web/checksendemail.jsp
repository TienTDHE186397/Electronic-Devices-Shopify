<%-- 
    Document   : checksendemail
    Created on : Sep 13, 2024, 1:02:24 AM
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
        <form action="SendMailServlet" method="post">
            Enter Email:<input type="text" name="to"> <br>
            Enter Subject: <input type="text" name="subject"><br>
            <textarea id="id" name="content" rows="5" cols="10" ></textarea>
            <input type="submit" value="Button"> <input type="reset" value="RESET">
        </form>
    </body>
</html>
