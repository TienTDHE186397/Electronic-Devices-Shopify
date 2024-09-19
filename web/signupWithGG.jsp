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
            <div class="form-container sign-in" style=" height: 500px; max-height: 600px; overflow-y: scroll">
                <form action="signupWithGG" method="post">
                    <h1>Đăng Kí With Google</h1>
                    <span>Đăng Kí Tài Khoản </span>
                    <input type="text" placeholder="Name" name="name" value="${user.name}" >
                    <input type="email" placeholder="Email" name="email" value="${user.email}" readonly required>
                    <input name="date" type="date" id="user-date" class="form-control" placeholder="Ngày sinh" required>
                    <input name="phone" type="tel" id="user-phone" class="form-control" placeholder="Số điện thoại" required>
                    <h6>Số điện thoại để giao hàng</h6>

                    <div style="color: red"><b>${mess}</b></div>

                    <button type="submit">Đăng Kí</button>
                </form>
            </div>

            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-right">
                        <h1>Hello, Friend!</h1>
                        <p>If You Have Account Turn Back To The Login Page</p>
                        <button onclick="redirectToLogin()">Quay lại trang Login</button>
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