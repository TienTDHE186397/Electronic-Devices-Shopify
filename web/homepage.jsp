<%-- 
    Document   : homepage
    Created on : Sep 13, 2024, 12:12:58 PM
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
        <h1>HomePage</h1>
        <form action="" method="post">
          
             <button onclick="redirectToLogin()">Đăng Xuat</button> <input type="reset" value="RESET">
        </form>
         <script>
            // Hàm chuyển hướng đến trang đăng nhập
            function redirectToLogin() {
                window.location.href = "/WebDienTu/login.jsp"; // Thay đổi URL này theo trang đăng nhập của bạn
            }
        </script> 
    </body>
</html>
