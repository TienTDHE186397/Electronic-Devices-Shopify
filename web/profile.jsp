<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Entity.Person" %>
<%@ page import="Email.PasswordUtils" %>
<%@ page session="true" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông tin tài khoản</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
                background-color: #f4f4f9;
            }
            h1 {
                color: #333;
                text-align: center;
            }
            table {
                margin: 20px auto;
                border-collapse: collapse;
                width: 80%;
                max-width: 600px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
                color: #333;
            }
            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin: 4px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            button {
                padding: 10px 20px;
                background-color: #28a745;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }
            button:hover {
                background-color: #218838;
            }
            #changePasswordBtn {
                background-color: #dc3545;
            }
            #changePasswordBtn:hover {
                background-color: #c82333;
            }
        </style>
    </head>
    <body>
        <h1>Thông tin tài khoản</h1>
        <script>
            function redirectToChangePassword() {
                window.location.href = "ChangePassword";
            }
        </script>

        <%
            PasswordUtils pw = new PasswordUtils();
            Person loggedInPerson = (Person) request.getSession().getAttribute("user");
            if (loggedInPerson == null) {
        %>
        <p style="text-align: center;">Không có thông tin người dùng.</p>
        <%
        } else {
             String pass = pw.ReverPassword(loggedInPerson.getPasword());
        %>
        <table>
            <thead>
                <tr>
                    <th>Tên cột</th>
                    <th>Giá trị</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Họ và tên</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getName() %>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Hình ảnh</td>
                    <td><img src="<%= loggedInPerson.getImage()%>" width="100px" height="100px"/></td>
                    <td></td>
                </tr>
                
                <tr>
                    <td>Giới tính</td>
                    <td><input type="text" name="gender" value="<%= loggedInPerson.getGender() %>" placeholder="Gender"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ngày sinh</td>
                     <td><input type="text" name="name" value="<%= loggedInPerson.getDateOfBirth() %>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ngày bắt đầu</td>
                    <td><input type="text" name="startDate" value="<%= loggedInPerson.getStartDate() %>" placeholder="Start Date"></td>
                    <td></td>
                </tr>
                
                <tr>
                    <td>Địa chỉ</td>
                     <td><input type="text" name="name" value="<%= loggedInPerson.getAddress() %>" placeholder="Name"></td>
                    <td></td>
                </tr>
               
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%= loggedInPerson.getEmail() %>" placeholder="Email"></td>
                    <td></td>
                </tr>
                
                <tr>
                    <td>Số điện thoại</td>
                     <td><input type="text" name="name" value="<%= loggedInPerson.getPhone() %>" placeholder="Name"></td>
                    <td><button type="button" id="changePasswordBtn">Đổi mật khẩu</button></td>
                </tr>
                <tr>
                    <td>Mật khẩu</td>
                    <td><input type="text" name="password" value="<%= pass %>" placeholder="Password"></td>
                    <td><a href="home">Return to home page</a></td>
                </tr>
            </tbody>
        </table>

        <script>
            document.getElementById("changePasswordBtn").addEventListener("click", redirectToChangePassword);
        </script>

        <%
            }
        %>
    </body>
</html>
