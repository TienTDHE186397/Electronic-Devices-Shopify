<%-- 
    Document   : UserDetail
    Created on : Sep 19, 2024, 7:22:53 AM
    Author     : nghie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <title>User Detail</title>
        <style>
/*            .form-control {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.form-control[readonly] {
    background-color: #f5f5f5;
    cursor: not-allowed;
    
}*/
/*            #centeredInput {
                width: 500px;  Đặt chiều rộng của input 
                height: 40px;  Đặt chiều cao của input 
                box-sizing: border-box;  Đảm bảo padding và border được bao gồm trong kích thước tổng 
                text-align: center;  Căn giữa theo chiều ngang 
                padding: 0;  Loại bỏ padding 
                line-height: 40px;  Căn giữa theo chiều dọc 
            }

             Giữ văn bản placeholder ở giữa 
            #centeredInput::placeholder {
                text-align: center;
            }*/
body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding-top: 50px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
            color: #343a40;
        }

        label {
            font-weight: 500;
            color: #495057;
        }

        #centeredInput {
            margin-bottom: 15px;
        }

        .form-control:focus {
            border-color: #80bdff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
        }

        .btn-submit {
            background-color: #007bff;
            border-color: #007bff;
            color: white;
            padding: 10px;
            font-weight: bold;
        }

        .btn-submit:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
        </style>
    </head>
    <body>
        <form action="editUser" method="post">
            <input type="hidden" name="PersonID" value="${detail.personID}"/>
            <div class="form-group">
                <label>Họ và tên</label>
                <input type="text" class="form-control" id="centeredInput" value="${detail.name}" name="name"/>
            </div>
            <div class="form-group">
                <label>Giới tính</label>
                
                <select name="gender" class="form-select" id="centeredInput">
            <c:choose>
                <c:when test="${detail.gender == 'Nam'}">
                    <option value="Nam" selected>Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>
                </c:when>
                <c:when test="${detail.gender == 'Nữ'}">
                    <option value="Nam">Nam</option>
                    <option value="Nữ" selected>Nữ</option>
                    <option value="Khác">Khác</option>
                </c:when>
                <c:when test="${detail.gender == 'Khác'}">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác" selected>Khác</option>
                </c:when>
            </c:choose>
                </select>
                
            </div>
            <div class="form-group">
                <label>Địa chỉ</label>
                <input type="text" class="form-control" id="centeredInput" value="${detail.address}" name="address"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input class="form-control" name="email" id="centeredInput" value="${detail.email}" readonly/>
            </div>
            <div class="form-group">
                <label>Di động</label>
                <input type="text" class="form-control" id="centeredInput" value="${detail.phone}" name="phone"/>
            </div>
            <div class="form-group">
                <label>Vai trò</label>
                <select name="roleID" class="form-select" id="centeredInput">
                    <c:choose>
                <c:when test="${detail.roleID == '1'}">
                    <option value="1" selected>Customer</option>
                    <option value="2">Marketing</option>
                    <option value="3">Sale</option>
                    <option value="4">Sale Manager</option>
                    <option value="5">Admin</option>
                </c:when>
                <c:when test="${detail.roleID == '2'}">
                    <option value="1" >Customer</option>
                    <option value="2" selected>Marketing</option>
                    <option value="3">Sale</option>
                    <option value="4">Sale Manager</option>
                    <option value="5">Admin</option>
                </c:when>
                <c:when test="${detail.roleID == '3'}">
                    <option value="1" >Customer</option>
                    <option value="2">Marketing</option>
                    <option value="3" selected>Sale</option>
                    <option value="4">Sale Manager</option>
                    <option value="5">Admin</option>
                </c:when>
                <c:when test="${detail.roleID == '4'}">
                    <option value="1" >Customer</option>
                    <option value="2">Marketing</option>
                    <option value="3">Sale</option>
                    <option value="4" selected>Sale Manager</option>
                    <option value="5">Admin</option>
                </c:when>
                <c:when test="${detail.roleID == '5'}">
                    <option value="1" >Customer</option>
                    <option value="2">Marketing</option>
                    <option value="3">Sale</option>
                    <option value="4">Sale Manager</option>
                    <option value="5" selected>Admin</option>
                </c:when>
            </c:choose>
                </select>
            </div>
            <div class="form-group">
                <label>Mật khẩu</label>
                <input type="text" class="form-control" id="centeredInput" value="${detail.pasword}" name="" readonly/>
            </div>
            <div class="form-group">
                <label>Mật khẩu mới</label>
                <input type="text" class="form-control" id="centeredInput" value="" name="password"/>
            </div>
            <div class="form-group">
            <input href="userList"  type="submit" class="form-control" value="Xác nhận" id="centeredInput"/>
            </div>
        </form>
    </body>
</html>
