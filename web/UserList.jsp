<%-- 
    Document   : UserList
    Created on : Sep 13, 2024, 8:41:45 PM
    Author     : nghie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
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
        <style>
            
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background-color: #f4f6f9;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Search and Filter Form */
        form {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        form input[type="text"], form select {
            padding: 10px;
            width: 30%;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        form input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* User Table */
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        thead {
            background-color: #007bff;
            color: white;
        }

        thead th {
            padding: 15px;
            text-align: left;
            font-weight: 500;
        }

        tbody tr {
            border-bottom: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody td {
            padding: 15px;
        }

        /* Links and Actions */
        tbody td a {
            color: #007bff;
            text-decoration: none;
        }

        tbody td a:hover {
            text-decoration: underline;
        }
            
        /* Responsive Table */
        @media screen and (max-width: 768px) {
            form {
                flex-direction: column;
            }

            form input[type="text"], form select {
                width: 100%;
                margin-bottom: 10px;
            }

            table {
                font-size: 14px;
            }

            thead th, tbody td {
                padding: 10px;
            }
        }
        </style>
    </head>
    <body>
        <div  style="margin-top: 15px">
            <div class="row">
                <div class="col-12 mb-3 mb-lg-"> 
                    <div class="position-relative card table-nowrap table-card ">
                        <div style="margin-bottom: 5px">
        <h1>Danh sách người dùng</h1>

    <!-- Form tìm kiếm và lọc -->
    <form method="GET" action="userControl">
        <input type="text" name="search" placeholder="Tìm kiếm theo tên, email, di động" value="${param.search}" />
        <select name="gender" id="gender">
            <option value="">Chọn giới tính</option>
            <option value="Nam" ${param.gender == 'Nam' ? 'selected' : ''}>Nam</option>
            <option value="Nữ" ${param.gender == 'Nữ' ? 'selected' : ''}>Nữ</option>
            <option value="Khác" ${param.gender == 'Khác' ? 'selected' : ''}>Khác</option>
        </select>
        <select name="roleid" id="roleid">
            <option value="">Chọn vai trò</option>
            <option value="1" ${param.roleid == '1' ? 'selected' : ''}>Customer</option>
            <option value="2" ${param.roleid == '2' ? 'selected' : ''}>Marketing</option>
            <option value="3" ${param.roleid == '3' ? 'selected' : ''}>Sale</option>
            <option value="4" ${param.roleid == '4' ? 'selected' : ''}>SaleManager</option>
            <option value="5" ${param.roleid == '5' ? 'selected' : ''}>Admin</option>
        </select>
        <input type="submit" value="Tìm kiếm" />
    </form>
         <!-- Bảng danh sách người dùng -->
    
    <table border="1" width = 100%>
        <thead>
            <tr>
                <th>ID</th>
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Email</th>
                <th>Di động</th>
                <th>Vai trò</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            
        <c:forEach var="person" items="${listP}">
                <tr>
                    <td>${person.personID}</td>
                    <td>${person.name}</td>
                    <td>${person.gender}</td>
                    <td>${person.dateOfBirth}</td>
                    <td>${person.address}</td>
                    <td>${person.email}</td>
                    <td>${person.phone}</td>
                <c:choose>
                    <c:when test="${person.roleID == 1}">
                        <td>Customer</td>
                    </c:when>
                        <c:when test="${person.roleID == 2}">
                        <td>Marketing</td>
                    </c:when>
                        <c:when test="${person.roleID == 3}">
                        <td>Sale</td>
                    </c:when>
                        <c:when test="${person.roleID == 4}">
                        <td>SaleManager</td>
                    </c:when>
                        <c:when test="${person.roleID == 5}">
                        <td>Admin</td>
                    </c:when>
                </c:choose>
                    
                        <td>
                            <a href="userDetail?PersonID=${person.personID}" style="">Chỉnh sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div style="text-align: center; margin-top: 15px;">
    <center><h5> <a href="addUser"><input type="button" value="Thêm người dùng mới" id="addUser" style="border: none;padding: 20px;color: white;background-color: #007bff;border-radius: 8px;"></a></h5></center>
        </div>
    </body>
</html>
