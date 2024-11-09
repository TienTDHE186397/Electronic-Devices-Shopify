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
            <div class="toggle-container" style="background-color:  #ef5455">
                <div class="toggle">
                    <div class="toggle-panel toggle-left" style="background-color:  #ef5455">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to use all of site features</p>
                        <button class="hidden" id="login">Đăng Nhập</button>
                    </div>
                    <div class="toggle-panel toggle-right" style="background-color:  #ef5455" >
                        <h1>Hello, Friend!</h1>
                        <p>Nếu Chưa Có Tài Khoản Đăng kí tại đây</p>
                        <button onclick="redirectToLogin()" style="background-color:  #b22222">Đăng Kí</button>
                    </div>
                </div>  
            </div>

            <div class="form-container sign-in" style="padding-top: 60px">
                <form action="login" method="post">
                    <h1>Đăng Nhập</h1>
                    <div class="social-icons">
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/WebDienTu/LoginGoogleHandler&response_type=code&client_id=630598609264-9sp60ioal96seml048sl3946slk6eohr.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="https://www.facebook.com/v19.0/dialog/oauth?fields=id,name,email&client_id=504057159000367&redirect_uri=http://localhost:9999/WebDienTu/LoginFaceBook&scope=email" class="icon"><i class="fa-brands fa-facebook-f"></i></a>

                    </div>
                    <span>Sử dụng tài khoản hiện có </span>
                    <input name="user" type="text" id="inputEmail" class="form-control" value="${cookie.cname.value}" placeholder="Email" required autofocus>
                    <input name="pass" type="password" id="inputPassword" class="form-control" placeholder="Mật khẩu" value="${cookie.cpass.value}" required>

                    <div class="all" style="width: 70%; display: flex; align-items: center; justify-content: space-between;">

                        <div  style="display: flex; align-items: center;">
                            <div>
                                <input name="remember" value="1" type="checkbox" ${cookie.crem!=null?'checked':''} id="exampleCheck1">
                            </div>
                            <div>  
                                <label for="exampleCheck1" style="margin-left: 10px;">Nhớ mật khẩu</label>
                            </div>
                        </div>
                        <div>
                            <a href="forgot.jsp">Quên mật khẩu?</a>
                        </div>

                    </div>

                    <div style="color: red"><b>${mess}</b></div>

                    <button type="submit" style="background-color:  #b22222">Đăng Nhập</button>

                </form>
            </div>


        </div>
        </br><p style="text-decoration: underline; font-style: italic; font-size: 13px;"><a href="home">Return home page</a></p>
        <script>
            // Hàm chuyển hướng đến trang đăng nhập
            function redirectToLogin() {
                window.location.href = "/WebDienTu/RegisterServlet"; // Thay đổi URL này theo trang đăng nhập của bạn
            }
        </script> 
    </body>

</html>