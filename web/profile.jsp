<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Entity.Person" %>
<%@ page import="Email.PasswordUtils" %>
<%@ page session="true" %>
<html>
    <head>
        <title>Thông tin tài khoản</title>
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
        <p>Không có thông tin người dùng.</p>
        <%
        } else {
             String pass = pw.ReverPassword(loggedInPerson.getPasword());
        %>
        <table border="0">
            <thead>
                <tr>
                    <th>Tên Cột</th>
                    <th>Tên cột</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Họ và tên</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getName()%>" placeholder="Name"> </td>
                    <td></td>
                </tr>
                <tr>
                    <td> Giới tính:</td>
                    <td><input type="text" name="name" value=" <%= loggedInPerson.getGender()%>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ngày bắt đầu</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getStartDate()%>" placeholder="Name"> </td>
                    <td></td>
                </tr>
                <tr>
                    <td> Địa chỉ</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getAddress()%>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getEmail()%>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Điện thoại</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getPhone()%>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td> Vai trò:</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getRoleID()%>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="name" value="<%= pass %>" placeholder="Name"></td>
                     <td><button type="button" id="changePasswordBtn" style="background-color: #b22222">Đổi mật khẩu</button></td>
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


</html>
