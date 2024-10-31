<%-- 
    Document   : header
    Created on : Sep 14, 2024, 10:35:21 AM
    Author     : Vu Duc Hai (HE181844)
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <!--Link to library file-->
    <link rel="icon" type="image/x-icon" href="img/Icon.png">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet" >
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="css/font-awesome.min.css" rel="stylesheet" >
    <link href="css/global.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link href="https://fonts.cdnfonts.com/css/roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
    <script src="js/bootstrap.bundle.min.js"></script>
    <!-- Intro settings -->
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body{

            font-family: sans-serif;
        }

        nav{
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 60px;
            display: flex;
            align-items: center;
        }

        nav .logo{
            display: flex;
            align-items: center;
            margin: 0 24px;
        }

        .logo .menu-icon{
            color: #333;
            font-size: 24px;
            margin-right: 14px;
            cursor: pointer;
        }

        .logo .logo-name{
            color: #333;
            font-size: 22px;
            font-weight: 500;
        }

        nav .sidebar{
            position: fixed;
            top: 0;
            left: -100%;
            padding: 20px 0;
            height: 100%;
            width: 260px;
            background-color: #fff;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
            transition: all 1s ease;
        }


        nav.open .sidebar{
            left: 0;
        }

        .sidebar .sidebar-content{
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            padding: 30px 16px;
            height: 100%;
        }

        .sidebar-content .list{
            list-style: none;
        }

        .list .nav-link{
            display: flex;
            align-items: center;
            padding: 14px 12px;
            border-radius: 8px;
            text-decoration: none;

        }

        .nav-link:hover{
            background-color: #4070f4;
        }

        .nav-link .icon{
            margin-right: 14px;
            font-size:  20px;
            color: #707070;

        }

        .nav-link .link{
            font-size:  16px;
            color: #707070;
            font-weight: 400;
        }

        .nav-link:hover .icon, .nav-link:hover .link{
            color: #fff;
        }

        .overlay{
            position: fixed;
            top: 0;
            left: 260px;
            height: 1000vh;
            width: 100%;

        }
    </style>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top navigation-custom">
        <div class="container-fluid">

            <div class="logo">
                <i class='bx bx-menu menu-icon'></i>
                <a class="navbar-brand" href="home">
                    <img src="img/Icon.jpg" height="24" alt=""
                         loading="lazy" style="margin-top: -3px;" />
                </a>
                <a href="home"><span class="logo-name">Shopify</span></a> 
            </div>

            <div class="sidebar">

                <div class="logo">
                    <i class='bx bx-menu menu-icon'></i>
                    <a class="navbar-brand" href="home">
                        <img src="img/Icon.jpg" height="24" alt=""
                             loading="lazy" style="margin-top: -3px;" />
                    </a>
                    <a href="home"><span class="logo-name">Shopify</span></a> 
                </div>

                <div class="sidebar-content">
                    <ul class="lists">
                        <li class="list">
                            <a href="./" class="nav-link">
                                <i class="bx bx-home-alt icon"></i>
                                <span class="link">Trang chủ</span>
                            </a>
                        </li>

                        <li class="list">
                            <a href="./PostListHome" class="nav-link">
                                <i class='bx bx-news icon'></i>
                                <span class="link">Bài đăng</span>
                            </a>
                        </li>

                        <li class="list">
                            <a href="./product-list" class="nav-link">
                                <i class='bx bx-box icon'></i>
                                <span class="link">Danh sách sản phẩm</span>
                            </a>
                        </li>
                    </ul>
                    <div class="bottom-content"> 
                        <li class="list">
                            <a href="#" class="nav-link">
                                <i class='bx bx-cog icon'></i>
                                <span class="link">Setting</span>
                            </a>
                        </li>


                        <li class="list">
                            <a href="./login" class="nav-link">
                                <i class='bx bx-user icon'></i>
                                <span class="link">Đăng Nhập</span>
                            </a>
                        </li>
                    </div>           
                </div>
            </div>
            <!-- Navbar brand -->




            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                </ul>

                <ul class="navbar-nav d-flex flex-row">

                    

                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <li class="nav-item">
                                <a class="nav-link" href="login" onclick="alert('Bạn cần đăng nhập để mua hàng')" >
                                    <i class="fa-solid fa-cart-shopping"></i> Giỏ Hàng
                                </a>
                            </li>

                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="cart-detail" >
                                    <i class="fa-solid fa-cart-shopping"></i> Giỏ Hàng
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${sessionScope.user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="./profile.jsp" >
                                <i class="fa-solid fa-user"></i></i>Hello ${sessionScope.user.getName()}
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./LogoutServlet">
                                <i class="fa-solid fa-sign-out-alt"></i> Đăng Xuất
                            </a>
                        </li>
                    </c:if>
                    <c:if  test="${sessionScope.user == null}"> 

                        <li class="nav-item">
                            <a class="nav-link" href="./login" >
                                <i class="fa-solid fa-sign-in-alt"></i> Đăng Nhập
                            </a>
                        </li>
                    </c:if>

                </ul>
            </div>
        </div>
    </nav>

    <script>
        const navBar = document.querySelector("nav"),
                menuBtns = document.querySelectorAll(".menu-icon"),
                overlay = document.querySelectorAll(".overlay");
        menuBtns.forEach(menuBtn => {
            menuBtn.addEventListener("click", () => {
                navBar.classList.toggle("open");
            })
        })


    </script>
    <!-- Navbar -->
</header>
<!--Main Navigation-->