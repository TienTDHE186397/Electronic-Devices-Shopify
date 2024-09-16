<%-- 
    Document   : header
    Created on : Sep 14, 2024, 10:35:21 AM
    Author     : Vu Duc Hai (HE181844)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <!--Link to library file-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet" >
    <!-- Intro settings -->
    <style>
        #intro {
            /* Margin to fix overlapping fixed navbar */
            margin-top: 58px;
        }

        @media (max-width: 991px) {
            #intro {
                /* Margin to fix overlapping fixed navbar */
                margin-top: 45px;
            }
        }
        


    </style>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #d70018;box-shadow: #0000001a 0px 4px 6px -1px;color: #4a4a4a">
        <div class="container-fluid">
            <!-- Navbar brand -->
            <a class="navbar-brand" target="_blank" href="#">
                <img src="https://drive.google.com/file/d/1YoYfvxlyzbUCz0kMZ0TufLcRpMxcubhW/view?usp=sharing" height="16" alt=""
                     loading="lazy" style="margin-top: -3px;" />
            </a>
            <button class="navbar-toggler" type="button" data-mdb-collapse-init data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link" href="https://mdbootstrap.com/docs/standard/" target="_blank">Danh mục</a>
                    </li>
                    <li class="nav-item">
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
                            <a class="menu-item " href="#" target="_blank">
                                <div class="menu-icon"><i class="fa-solid fa-cart-plus"></i></div>
                                <div class="menu-text">Giỏ hàng</div>
                            </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="https://mdbootstrap.com/docs/standard/" target="_blank">Sign in</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
</header>
<!--Main Navigation-->
