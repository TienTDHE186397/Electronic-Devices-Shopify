<%-- 
    Document   : header
    Created on : Sep 14, 2024, 10:35:21 AM
    Author     : Vu Duc Hai (HE181844)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <!--Link to library file-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet" >
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <script src="js/bootstrap.bundle.min.js"></script>
    <!-- Intro settings -->
    <style>
        .navigation-custom{
            /* Margin to fix overlapping fixed navbar */
            margin-bottom: 100px;
        }

    </style>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top navigation-custom">
        <div class="container-fluid"  style="background-color: #ef5455">   
            <!-- Navbar brand -->
            <a class="navbar-brand" target="_blank" href="#">
                <img src="https://drive.google.com/uc?export=view&id=1YoYfvxlyzbUCz0kMZ0TufLcRpMxcubhW" height="16" alt=""
                     loading="lazy" style="margin-top: -3px;" />
            </a>
            <button class="navbar-toggler" type="button" data-mdb-collapse-init data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="#">
                            <i class="fa-solid fa-house"></i> Home
                        </a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link" href="#" target="_blank">
                            <i class="fa-solid fa-list"></i> Danh mục
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Xem giá tại
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Hồ Chí Minh</a>
                            <a class="dropdown-item" href="#">Hà Nội</a>
                        </div>
                    </li>
                </ul>

                <ul class="navbar-nav d-flex flex-row">

                    <li class="nav-item">
                        <a class="nav-link" href="#" >
                            <i class="fa-solid fa-cart-shopping"></i> Giỏ Hàng
                        </a>
                    </li>
                        
                    <li class="nav-item">
                        <a class="nav-link" href="/WebDienTu/login" >
                            <i class="fa-solid fa-sign-in-alt"></i>Đăng nhập
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
</header>
<!--Main Navigation-->
