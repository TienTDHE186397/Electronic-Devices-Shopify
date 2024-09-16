<%-- 
    Document   : register
    Created on : Sep 14, 2024, 12:49:03 AM
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
        <h2>Đăng ký tài khoản</h2>
        <form action="UserVerify" method="post">
            Tên: <input type="text" name="name" required><br>
            Tuổi: <input type="number" name="age" required><br>
            Địa chỉ: <input type="text" name="address" required><br>
            Số điện thoại: <input type="text" name="phone" required><br>
            Email: <input type="email" name="email" required><br>
            Mật khẩu: <input type="password" name="password" required><br>
            <input type="submit" value="Đăng ký">
        </form>
    </body>
</html>
