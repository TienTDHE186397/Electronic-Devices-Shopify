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
        <style>
            
        </style>
    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <div style="padding-top: 20px ; background-color: white;max-height: 450px; overflow-y: scroll" >
                    <form action="signup" method="post">
                    <h1>Create Account</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>

                    <input type="text" placeholder="Name" name="user" required>
                    <input type="password" placeholder="Password"name="pass" required>
                    <input type="password" placeholder="RePassword"name="repass" required>
                    <input name="name" type="text" id="user-fullname" class="form-control" placeholder="Họ tên" required>
                    <select name="gender" id="user-gender" class="form-control" required>
                        <option value="" disabled selected>Giới tính</option>
                        <option value="Male">Nam</option>
                        <option value="Female">Nữ</option>
                    </select>
                    <input name="date" type="date" id="user-date" class="form-control" placeholder="Ngày sinh" required>
                    <input name="address" type="text" id="user-address" class="form-control" placeholder="Địa chỉ" required>
                    <input name="email" type="email" id="user-email" class="form-control" placeholder="Email: example@gmail.com" required>
                    <input name="phone" type="tel" id="user-phone" class="form-control" placeholder="Số điện thoại" required>
                    <button>Đăng Ký</button>
                    <a href="login.jsp" class="text-muted"><i class="fas fa-angle-left"></i> Quay lại</a>
              </form>
                </div>
                
            </div>

            <div class="form-container sign-in">
                <form action="login" method="post">
                    <h1>Đăng Nhập</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>Sử dụng tài khoản hiện có </span>
                    <input name="user" type="text" id="inputEmail" class="form-control" value="${cookie.cname.value}" placeholder="Tên đăng nhập" required autofocus>
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

                    <button type="submit">Đăng Nhập</button>
                </form>
            </div>

            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to use all of site features</p>
                        <button class="hidden" id="login">Đăng Nhập</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Hello, Friend!</h1>
                        <p>Register with your personal details to use all of site features</p>
                        <button class="hidden" id="register">Đăng Ký</button>
                    </div>
                </div>
            </div>
        </div>
        </br><p style="text-decoration: underline; font-style: italic; font-size: 13px;"><a href="home">Return home page</a></p>
        <script src="loginform\script.js"></script>
    </body>

</html>