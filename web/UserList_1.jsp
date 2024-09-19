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
            body {
                margin-top: 20px;
                background: #eeecfd;
            }

            .card {
                box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
                padding: 20px; /* Thêm padding ?? n?i dung không ch?m vào c?nh c?a card */
            }

            .avatar.sm {
                width: 2.25rem;
                height: 2.25rem;
                font-size: .818125rem;
            }

            .table-nowrap .table td,
            .table-nowrap .table th {
                white-space: nowrap;
            }

            .table>:not(caption)>*>* {
                padding: 0.75rem 1.25rem;
                border-bottom-width: 1px;
            }

            table th {
                font-weight: 600;
                background-color: #eeecfd !important;
            }

            .fa-arrow-up {
                color: #00CED1;
            }

            .fa-arrow-down {
                color: #FF00FF;
            }

            .centered-table-wrapper {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }


            th, td {
                border: 1px solid #dee2e6; /* ???ng vi?n gi?a các ô */
                text-align: center;
                margin-left: 5px; /* Áp d?ng margin-left cho các ô */

            }





            tbody td {

                margin-left: 5px; /* Kho?ng cách gi?a các ô trong cùng m?t hàng */
            }

            h1 {
                text-align: center;
                margin-bottom: 20px;
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
            <option value="Nữ" ${param.gender == 'Nam' ? 'selected' : ''}>Nữ</option>
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
                    <c:if test="${person.roleID == 5}">
                        <td>
                        <a href="editUser?PersonID=${id}" style="">Chỉnh sửa</a>
                    </td>
                    </c:if>
                    <c:if test="${person.roleID != 5}">
                        <td></td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
         <div>
    <c:forEach begin="1" end="${totalPages}" var="i">
        <a href="userList?page=${i}${param.search != null ? '&search=' + param.search : ''}${param.gender != null ? '&gender=' + param.gender : ''}${param.role != null ? '&role=' + param.role : ''}">${i}</a>
    </c:forEach>
</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <center> <a href="addUser.jsp"><input type="button" value="Thêm người dùng mới"></a></center>
    </body>
</html>
