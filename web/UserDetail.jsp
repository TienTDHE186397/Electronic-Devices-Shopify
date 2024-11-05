<%-- 
    Document   : UserDetail
    Created on : Sep 19, 2024, 7:22:53 AM
    Author     : nghie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <title>User Detail</title>
        <style>
            body {
                background-color: #f8f9fa;
                font-family: 'Poppins', sans-serif;
                padding-top: 50px;
            }

            .form-container {
                max-width: 600px;
                margin: 0 auto;
                padding: 30px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            }

            .form-title {
                font-size: 28px;
                font-weight: bold;
                margin-bottom: 20px;
                text-align: center;
                color: #007bff;
            }

            label {
                font-weight: 500;
                color: #495057;
            }

            .form-control {
                border-radius: 0.5rem;
                box-shadow: none;
                transition: border-color 0.3s;
            }

            .form-control:focus {
                border-color: #007bff;
                box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
            }

            .btn-submit {
                background-color: #007bff;
                border-color: #007bff;
                color: white;
                padding: 10px;
                font-weight: bold;
                border-radius: 0.5rem;
                width: 100%;
                transition: background-color 0.3s;
            }

            .btn-submit:hover {
                background-color: #0056b3;
                border-color: #004085;
            }

            .readonly-input {
                background-color: #f5f5f5;
                cursor: not-allowed;
            }

            .form-group {
                margin-bottom: 20px;
            }

            #centeredInput {
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2 class="form-title">User Details</h2>
            <form action="editUser" method="post">
                <input type="hidden" name="PersonID" value="${detail.personID}"/>
                
                <div class="form-group">
                    <label for="name">Họ và tên</label>
                    <input type="text" class="form-control" id="name" value="${detail.name}" name="name" required/>
                </div>

                <div class="form-group">
                    <label for="gender">Giới tính</label>
                    <select name="gender" class="form-control" id="gender" required>
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
                    <label for="address">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" value="${detail.address}" name="address" required/>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control readonly-input" name="email" id="email" value="${detail.email}" readonly/>
                </div>

                <div class="form-group">
                    <label for="phone">Di động</label>
                    <input type="text" class="form-control" id="phone" value="${detail.phone}" name="phone" required/>
                </div>

                <div class="form-group">
                    <label for="roleID">Vai trò</label>
                    <select name="roleID" class="form-control" id="roleID" required>
                        <c:choose>
                            <c:when test="${detail.roleID == '1'}">
                                <option value="1" selected>Customer</option>
                                <option value="2">Marketing</option>
                                <option value="3">Sale</option>
                                <option value="4">Sale Manager</option>
                                <option value="5">Admin</option>
                            </c:when>
                            <c:when test="${detail.roleID == '2'}">
                                <option value="1">Customer</option>
                                <option value="2" selected>Marketing</option>
                                <option value="3">Sale</option>
                                <option value="4">Sale Manager</option>
                                <option value="5">Admin</option>
                            </c:when>
                            <c:when test="${detail.roleID == '3'}">
                                <option value="1">Customer</option>
                                <option value="2">Marketing</option>
                                <option value="3" selected>Sale</option>
                                <option value="4">Sale Manager</option>
                                <option value="5">Admin</option>
                            </c:when>
                            <c:when test="${detail.roleID == '4'}">
                                <option value="1">Customer</option>
                                <option value="2">Marketing</option>
                                <option value="3">Sale</option>
                                <option value="4" selected>Sale Manager</option>
                                <option value="5">Admin</option>
                            </c:when>
                            <c:when test="${detail.roleID == '5'}">
                                <option value="1">Customer</option>
                                <option value="2">Marketing</option>
                                <option value="3">Sale</option>
                                <option value="4">Sale Manager</option>
                                <option value="5" selected>Admin</option>
                            </c:when>
                        </c:choose>
                    </select>
                </div>

                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input type="text" class="form-control readonly-input" id="password" value="${detail.getPasword()}" name="" readonly/>
                </div>

                <div class="form-group">
                    <label for="newPassword">Mật khẩu mới</label>
                    <input type="password" class="form-control" id="newPassword" name="password" required/>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-submit" value="Xác nhận"/>
                </div>
            </form>
        </div>
    </body>
</html>
