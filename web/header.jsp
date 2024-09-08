<%-- 
    Document   : header
    Created on : May 27, 2024, 10:35:14 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            nav {
                width: 150px; /* Độ rộng của menu */
            }

            nav ul {
                list-style-type: none; /* Xóa dấu chấm đầu dòng */
                padding: 0;
                margin: 0;
            }

            nav ul li {
                margin-bottom: 2px; /* Khoảng cách giữa các mục */
            }

            nav ul li a {
                display: flex; /* Để các biểu tượng và chữ nằm cùng hàng */
                align-items: center;
                text-decoration: none; /* Xóa gạch chân */
                color: black; /* Màu chữ */
                padding: 10px;
                font-size: 10px; /* Kích thước chữ */
                background-color: #f8f9fa; /* Màu nền */
                border-radius: 5px; /* Bo góc */
                transition: background-color 0.3s; /* Hiệu ứng khi di chuột */
            }

            nav ul li a:hover {
                background-color: #e9ecef; /* Màu nền khi di chuột */
            }

            nav ul li a i {
                margin-right: 10px; /* Khoảng cách giữa icon và chữ */
            }

            nav ul li a.logout {
                color: red; /* Đổi màu cho mục "Logout" */
            }
            nav ul {
                list-style-type: none;
                padding: 0;
                margin: 0;
            }
            nav ul li {
                position: relative; /* Để có thể định vị dropdown */
            }
            .dropdown-menu {
                display: none; /* Ẩn ban đầu */
                position: absolute;
                left: 80%; /* Bảng sẽ xuất hiện bên phải của mục "LapTop" */

                background-color: #f8f9fa;
                box-shadow: 0 8px 16px rgba(0,0,0,0.1); /* Hiệu ứng bóng đổ */

                z-index: 1000; /* Đảm bảo nó nằm trên các phần tử khác */
            }


            /* Hiển thị dropdown khi lướt chuột vào Set Item */
            .set-item:hover + .dropdown-menu,
            .dropdown-menu:hover {
                display: block;
            }
            /* Tạo hiệu ứng dropdown hiển thị ngay bên phải */
          

            /* Ẩn bảng ban đầu */
            .d-none {
                display: none;
            }

            /* Hiển thị bảng khi di chuột vào mục "LapTop" hoặc bảng */
            .nav-item:hover #laptop-options,
            #laptop-options:hover {
                display: block;
            }

            /* Định dạng danh sách bên trong bảng */
          

        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    </head>
    <!-- Header start -->
    <section id="top">
        <div class="container-fluid">
            <div class="row top_1">
                <div class="col-md-4">

                </div>
                <div class="col-md-8">
                    <div class="top_1i text-end">
                        <ul class="mb-0">
                            <c:if test="${sessionScope.acc.roleID == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="vieworderadmin"><i class="fa fa-caret-right col_yell me-1"></i> View Orders</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleID == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="managercinema"><i class="fa fa-caret-right col_yell me-1"></i> Manager Cinema</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleID == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="manager"><i class="fa fa-caret-right col_yell me-1"></i> Manager Product</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleID == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="manageraccount"><i class="fa fa-arrow-circle-o-right col_yell me-1"></i> Manager Account</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.isSell == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="viewcalendar"><i class="fa fa-user col_yell me-1"></i> Loại Tài Khoản: Nhân Viên</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.isSell == 1 || sessionScope.acc.roleID == 1}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="viewcalendar"><i class="fa fa-pencil col_yell me-1"></i> View Calendar</a>
                                </li>
                            </c:if>

                            <c:if test="${sessionScope.acc.roleID == 0 && sessionScope.acc.isSell == 0}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="#"><i class="fa fa-caret-right col_yell me-1"></i> Số Dư: <c:choose>
                                            <c:when test="${sessionScope.wallet.balance != 0}">
                                                ${sessionScope.wallet.balance}
                                            </c:when>
                                            <c:otherwise>
                                                0
                                            </c:otherwise>
                                        </c:choose> VND</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleID == 0 && sessionScope.acc.isSell == 0}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="vieworderuser"><i class="fa fa-caret-right col_yell me-1"></i> View My Order</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleID == 0 && sessionScope.acc.isSell == 0}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="#"><i class="fa fa-user col_yell me-1"></i>Loại Tài Khoản: Người Dùng</a>
                                </li>
                            </c:if>

                            <c:if test="${sessionScope.acc != null}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="logout"><i class="fa fa-sign-in col_yell me-1"></i> Logout</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">
                                <li class="nav-item  d-inline-block font_13 border-0">
                                    <a class="text-light" href="#"><i class="fa fa-user col_yell me-1"></i> Hello ${sessionScope.acc.user} </a>
                                </li>
                            </c:if>

                            <c:if test="${sessionScope.acc == null}">
                                <li class="nav-item  d-inline-block font_13 me-2 pe-2">
                                    <a class="text-light" href="loginform.jsp"><i class="fa fa-sign-in col_yell me-1"></i> Sign In</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                                <li class="nav-item  d-inline-block font_13 border-0">
                                    <a class="text-light" href="loginform.jsp"><i class="fa fa-user col_yell me-1"></i> Login </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="header" class="bg_light">
        <nav class="navbar navbar-expand-md navbar-light pt-0 pb-0" id="navbar_sticky">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mb-0">

                        <nav>
                            <ul>


                                <ul>
                                    <li>
                                        <a href="#" class="set-item">
                                            <i class="fas fa-user"></i>
                                            <span class="nav-item">trang chủ</span>
                                        </a>
                                        <ul class="dropdown-menu " aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="#sapchieu"><i class=""></i> Bluetooth</a></li>
                                            <li><a class="dropdown-item border-0" href="#dangchieu"><i class=""></i>Chụp tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dachieu"><i class=""></i>Nhét Tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dacbiet"><i class=""></i> Có dây</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <a href="#" class="set-item">
                                            <i class="fa-solid fa-laptop"></i>
                                            <span class="nav-item">LapTop</span>
                                        </a>
                                        <ul class="dropdown-menu " aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="#sapchieu"><i class=""></i> Bluetooth</a></li>
                                            <li><a class="dropdown-item border-0" href="#dangchieu"><i class=""></i>Chụp tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dachieu"><i class=""></i>Nhét Tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dacbiet"><i class=""></i> Có dây</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="nav-item">
                                        <a href="#" class="set-item">
                                            <i class="fa-solid fa-laptop"></i>
                                            <span class="nav-item">LapTop</span>
                                        </a>

                                        <!-- Bảng tùy chọn sẽ hiển thị khi di chuột vào "LapTop" -->
                                        <div class="dropdown-menu p-4 bg-light">
                                            <div class="row">
                                                <div class="col-6">
                                                    <h5>Bluetooth</h5>
                                                    <ul>
                                                        <li><a class="dropdown-item" href="#option1">Option 1</a></li>
                                                        <li><a class="dropdown-item" href="#option2">Option 2</a></li>
                                                    </ul>
                                                </div>
                                                <div class="col-6">
                                                    <h5>Chụp tai</h5>
                                                    <ul>
                                                        <li><a class="dropdown-item" href="#option3">Option 3</a></li>
                                                        <li><a class="dropdown-item" href="#option4">Option 4</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>

                                <ul>
                                    <li>
                                        <a href="#" class="set-item">
                                            <i class="fa-solid fa-headphones-simple"></i>
                                            <span class="nav-item">Tai Nghe</span>
                                        </a>
                                        <ul class="dropdown-menu " aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="#sapchieu"><i class=""></i> Bluetooth</a></li>
                                            <li><a class="dropdown-item border-0" href="#dangchieu"><i class=""></i>Chụp tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dachieu"><i class=""></i>Nhét Tai</a></li>
                                            <li><a class="dropdown-item border-0" href="#dacbiet"><i class=""></i> Có dây</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <a href="#" class="set-item">
                                            <i class="fa-regular fa-sun"></i>
                                            <span class="nav-item">Khuyến Mãi</span>
                                        </a>
                                        <ul class="dropdown-menu " aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="#sapchieu"><i class=""></i> Laptop khuyến mãi</a></li>
                                            <li><a class="dropdown-item border-0" href="#dangchieu"><i class=""></i>Tai nghe khuyến mãi</a></li>
                                            <li><a class="dropdown-item border-0" href="#dachieu"><i class=""></i>Điện thoại khuyến mãi</a></li>
                                            <li><a class="dropdown-item border-0" href="#dacbiet"><i class=""></i> Tivi khuyến mãi</a></li>
                                        </ul>
                                    </li>
                                </ul>











                            </ul>
                        </nav>

                        <!--                       
                                                <li class="nav-item dropdown">
                                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                        Thể Loại
                                                    </a>
                                                    <ul class="dropdown-menu drop_2 drop_cat" aria-labelledby="navbarDropdown">
                        <c:forEach var="c" items="${sessionScope.listC}">
                            <li><a class="dropdown-item" href="category?cid=${c.categoryId}"><i class="fa fa-caret-right me-1 col_yell"></i> ${c.categoryName}</a></li>
                        </c:forEach>
                </ul>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Ví
                </a>
                <ul class="dropdown-menu drop_2 drop_cat" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item border-0" href="Deposit.jsp"><i class="fa fa-caret-right me-1 col_yell"></i> Nạp Tiền</a></li>
                        <c:if test="${sessionScope.acc.roleID == 1}">
                        <li><a class="dropdown-item border-0" href="depositmanager"><i class="fa fa-caret-right me-1 col_yell"></i>Quản Lý Nạp Tiền</a></li>
                        </c:if>
                </ul>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Liên Hệ</a>
            </li>-->




                    </ul>
                </div>
            </div>
        </nav>
    </section>

    <section id="header_top" class="pt-4 pb-4">
        <div class="container-fluid">
            <div class="row header_top1">
                <div class="col-md-3">
                    <div class="header_top1l">
                        <h3 class="mb-0" style="font-family: serif"><a class="col_dark" href="home"><img src="img/logo/logo.png" alt="ALV Cinema Logo" class="logo-img"> TNREAL</a></h3>
                    </div>

                </div>
                <div class="col-md-6">
                    <form action="search" method="POST">
                        <div class="header_top1m">
                            <select name="categories" class="form-select  bg_light" >
                                <option value="">Tất Cả Phim</option>
                                <option>Mới Nhất</option>
                                <option>Cũ Nhất</option>
                                <option>Xem Nhiều</option>
                                <option>Bán Chạy</option>
                            </select>

                            <div class="input-group">
                                <input type="text" class="form-control border-start-0" placeholder="Tìm kiếm" name="txt">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary bg_yell" type="submit">
                                        <i class="fa fa-search"></i> </button>
                                </span>

                            </div>
                        </div>
                    </form> 
                </div>

            </div>
        </div>
    </section>
    <script>
        document.getElementById("laptop-menu").addEventListener("click", function (e) {
            e.preventDefault(); // Ngăn chặn link mặc định

            var options = document.getElementById("laptop-options");

            // Toggle hiển thị
            if (options.classList.contains("d-none")) {
                options.classList.remove("d-none");
            } else {
                options.classList.add("d-none");
            }
        });
    </script>



    <!-- Header end -->
</html>
