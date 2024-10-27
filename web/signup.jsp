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
        <link rel="stylesheet" href="./loginform/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Modern Login Page | AsmrProg</title>

    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-in" style=" max-height: 700px; overflow-y: scroll;padding-top: 30px">
                <form style="height: fit-content" action="RegisterServlet" method="post" enctype="multipart/form-data">
                    <h1>Đăng Kí</h1>
                    <div class="social-icons">
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/WebDienTu/SignupGoogle&response_type=code&client_id=630598609264-9sp60ioal96seml048sl3946slk6eohr.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="https://www.facebook.com/v19.0/dialog/oauth?fields=id,name,email&client_id=504057159000367&redirect_uri=http://localhost:9999/WebDienTu/LoginFaceBook&scope=email" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    </div>
                    <span>Đăng Kí Tài Khoản</span>
                    <input name="name" type="text" placeholder="Name" value="<%= request.getParameter("user") != null ? request.getParameter("user") : ""%>" required>
                    <input name="pass" type="password" placeholder="Password"  required>
                    <input name="repass" type="password" placeholder="RePassword"  required>
                    <select name="gender" id="user-gender" class="form-control" required>
                        <option value="" disabled selected>Giới tính</option>
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                    </select>

                    <input name="date" type="date" id="user-date" class="form-control" placeholder="Ngày sinh" value="<%= request.getParameter("date") != null ? request.getParameter("date") : ""%>" required>
                    <input type="email" id="email" name="email" " value="<%= request.getParameter("email") != null ? request.getParameter("email") : ""%>" placeholder="email" >
                    <input name="phone" type="tel" id="user-phone" class="form-control" placeholder="Số điện thoại" value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : ""%>" required>
                    <input type="address" id="address" name="address" " value="<%= request.getParameter("address") != null ? request.getParameter("address") : ""%>" placeholder="address" >
                    <button type="button" class="btn btn-primary" onclick="addVideo()">Thêm Video</button>

                    <button type="button" class="btn btn-primary" onclick="addImage()">Thêm Ảnh</button>
                    <div id="attributeContainer" style="margin-top: 20px;"></div>
                    <div id="attributeContainer" style="margin-top: 20px;"></div>




                    <%
                        String error = (String) request.getAttribute("error");
                    %>
                    <h4><%= error != null ? error : ""%></h4>

                    <button type="submit " style="background-color:  #b22222">Đăng Kí</button>
                </form>
            </div>

            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-right" style="background-color:  #ef5455">
                        <h1>Xin chào!</h1>
                        <p>Nếu Đã Có Tài Khoản Hãy Ấn Vô Đây Để Đăng Nhập</p>
                        <button onclick="redirectToLogin()"  style="background-color:  #b22222">Đăng nhập</button>
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
            let attributeCount = 0; // Khởi tạo attributeCount bên ngoài hàm
            function confirmDelete() {
                console.log('Confirm delete called');
                return confirm('Are you sure you want to delete this attribute?');
            }

            function addVideo() {
                const attributeContainer = document.getElementById('attributeContainer');
                const newRow = document.createElement('div');
                newRow.classList.add('form-row', 'mb-2');
                newRow.innerHTML = `
    <div class="form-group col-md-5">
        <input type="text" placeholder="Nhập Tên Video" style="font-weight: bold;" name="vidImgName" class="form-control" required>
    </div>
    <div class="form-group col-md-5">
        <input name="vidImgValue" type="file" accept="video/*, image/*" class="form-control" required>
    </div>
    <div class="form-group col-md-2">
        <button type="button" class="btn btn-danger delete-button">Xóa</button>
    </div>
`;
                attributeContainer.appendChild(newRow);
                attributeCount++;

                // Gán sự kiện xóa cho nút "Xóa" mới tạo
                newRow.querySelector('.delete-button').addEventListener('click', function () {
                    newRow.remove();
                });
            }
            function addImage() {
                const attributeContainer = document.getElementById('attributeContainer');
                const newRow = document.createElement('div');
                newRow.classList.add('form-row', 'mb-2');
                newRow.innerHTML = `
    <div class="form-group col-md-5">
        <input type="text" placeholder="Nhập Tên Ảnh " style="font-weight: bold;" name="vidImageName" class="form-control" required>
    </div>
    <div class="form-group col-md-5">
        <input name="vidImageValue" type="file" accept="video/*, image/*" class="form-control" required>
    </div>
    <div class="form-group col-md-2">
        <button type="button" class="btn btn-danger delete-button">Xóa</button>
    </div>
`;
                attributeContainer.appendChild(newRow);
                attributeCount++;

                // Gán sự kiện xóa cho nút "Xóa" mới tạo
                newRow.querySelector('.delete-button').addEventListener('click', function () {
                    newRow.remove();
                });
            }
        </script> 
    </body>

</html>
