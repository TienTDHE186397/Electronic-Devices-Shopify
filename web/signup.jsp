<%-- 
    Document   : loginform
    Created on : Jun 5, 2024, 12:29:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="loginform\style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Modern Login Page | AsmrProg</title>

    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-in" style="height: 500px; max-height: 600px; overflow-y: scroll">
                <form action="signup" method="post">
                    <h1>Đăng Kí</h1>
                    <div class="social-icons">
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/WebDienTu/SignupGoogle&response_type=code&client_id=630598609264-9sp60ioal96seml048sl3946slk6eohr.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="https://www.facebook.com/v19.0/dialog/oauth?fields=id,name,email&client_id=504057159000367&redirect_uri=http://localhost:9999/WebDienTu/LoginFaceBook&scope=email" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    </div>
                    <span>Đăng Kí Tài Khoản</span>
                    <input type="text" placeholder="Name" name="user" value="<%= request.getParameter("user") != null ? request.getParameter("user") : ""%>" required>
                    <input type="password" placeholder="Password" name="pass" required>
                    <input type="password" placeholder="RePassword" name="repass" required>
                    <input name="name" type="text" id="user-fullname" class="form-control" placeholder="Họ tên" value="<%= request.getParameter("name") != null ? request.getParameter("name") : ""%>" required>
                    <select name="gender" id="user-gender" class="form-control" required>
                        <option value="" disabled selected>Giới tính</option>
                        <option value="Male" <%= "Male".equals(request.getParameter("gender")) ? "selected" : ""%>>Nam</option>
                        <option value="Female" <%= "Female".equals(request.getParameter("gender")) ? "selected" : ""%>>Nữ</option>
                    </select>
                    <input name="date" type="date" id="user-date" class="form-control" placeholder="Ngày sinh" value="<%= request.getParameter("date") != null ? request.getParameter("date") : ""%>" required>
                    <input name="email" type="email" id="user-email" class="form-control" placeholder="Email: example@gmail.com" value="<%= request.getParameter("email") != null ? request.getParameter("email") : ""%>" required>
                    <input name="phone" type="tel" id="user-phone" class="form-control" placeholder="Số điện thoại" value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : ""%>" required>

                    <%
                        String error = (String) request.getAttribute("error");
                    %>
                    <h4><%= error != null ? error : ""%></h4>

                    <button type="submit">Đăng Kí</button>
                </form>
            </div>

            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-right">
                        <h1>Hello, Friend!</h1>
                        <p>If You Have Account Turn Back To The Login Page</p>
                        <button onclick="redirectToLogin()">Đăng nhập</button>
                    </div>
                </div>
            </div>
        </div>
        </br><p style="text-decoration: underline; font-style: italic; font-size: 13px;"><a href="home">Return home page</a></p>
        <script>
            // Hàm chuyển hướng đến trang đăng nhập
            function redirectToLogin() {
                window.location.href = "/WebDienTu/login"; // Thay đổi URL này theo trang đăng nhập của bạn
            }
        </script> 
    </body>

</html>