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
        <h2>Email Verification</h2>
        <form action="SendMailServlet" method="post">
            <label for="email">Enter your email:</label>
            <input type="email" id="email" name="email" required>
            <button type="submit">Send Verification Email</button>
        </form>
    </body>
</html>
