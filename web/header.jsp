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
            .header_top {
                background: none repeat scroll 0 0 #F0F0E9;
            }
            .contactinfo ul li:first-child{
                margin-left: -15px;
            }

            .contactinfo ul li a{
                font-size: 12px;
                color: #696763;
                font-family: 'Roboto', sans-serif;
            }


            .contactinfo ul li a:hover{
                background:inherit;
            }

            .social-icons ul li a {
                border: 0 none;
                border-radius: 0;
                color: #696763;
                padding:0px;
            }


            .social-icons ul li{
                display:inline-block;
            }

            .social-icons ul li a i {
                padding: 11px 15px;
                transition: all 0.9s ease 0s;
                -moz-transition: all 0.9s ease 0s;
                -webkit-transition: all 0.9s ease 0s;
                -o-transition: all 0.9s ease 0s;
            }

            .social-icons ul li a i:hover{
                color: #fff;
                transition: all 0.9s ease 0s;
                -moz-transition: all 0.9s ease 0s;
                -webkit-transition: all 0.9s ease 0s;
                -o-transition: all 0.9s ease 0s;
            }


            .fa-facebook:hover {
                background: #0083C9;
            }

            .fa-twitter:hover  {
                background:#5BBCEC;
            }

            .fa-linkedin:hover  {
                background:#FF4518;
            }

            .fa-dribbble:hover  {
                background:#90C9DC;
            }

            .fa-google-plus:hover  {
                background:#CE3C2D;
            }

            .header-middle .container .row {
                border-bottom: 1px solid #f5f5f5;
                margin-left: 0;
                margin-right: 0;
                padding-bottom: 20px;
                padding-top: 20px;
            }

            .header-middle .container .row .col-sm-4{
                padding-left: 0;
            }

            .header-middle .container .row .col-sm-8 {
                padding-right:0;
            }

            .usa {
                border-radius: 0;
                color: #B4B1AB;
                font-size: 12px;
                margin-right: 20px;
                padding: 2px 15px;
                margin-top: 10px;
            }

            .usa:hover {
                background:#FE980F;
                color:#fff;
                border-color:#FE980F;
            }

            .usa:active, .usa.active {
                background: none repeat scroll 0 0 #FE980F;
                box-shadow: inherit;
                outline: 0 none;
            }

            .btn-group.open .dropdown-toggle {
                background: rgba(0, 0, 0, 0);
                box-shadow: none;
            }

            .dropdown-menu  li  a:hover, .dropdown-menu  li  a:focus {
                background-color: #FE980F;
                color: #FFFFFF;
                font-family: 'Roboto', sans-serif;
                text-decoration: none;
            }

            .shop-menu ul li {
                display:inline-block;
                padding-left: 15px;
                padding-right: 15px;
            }

            .shop-menu ul li:last-child {
                padding-right: 0;
            }


            .shop-menu ul li a {
                background: #FFFFFF;
                color: #696763;
                font-family: 'Roboto', sans-serif;
                font-size: 14px;
                font-weight: 300;
                padding:0;
                padding-right: 0;
                margin-top: 10px;
            }


            .shop-menu ul li a i{
                margin-right:3px;
            }


            .shop-menu ul li a:hover {
                color:#fe980f;
                background:#fff;
            }


            .header-bottom {
                padding-bottom: 30px;
                padding-top: 30px;
            }

            .navbar-collapse.collapse{
                padding-left: 0;
            }

            .mainmenu ul li{
                padding-right: 15px;
                padding-left: 15px;
            }

            .mainmenu ul li:first-child{
                padding-left: 0px;
            }

            .mainmenu ul li a {
                color: #696763;
                font-family: 'Roboto', sans-serif;
                font-size: 17px;
                font-weight: 300;
                padding: 0;
                padding-bottom: 10px;
            }

            .mainmenu ul li a:hover, .mainmenu ul li a.active,  .shop-menu ul li a.active{
                background:none;
                color:#fdb45e;
            }

            .search_box input {
                background: #F0F0E9;
                border: medium none;
                color: #B2B2B2;
                font-family: 'roboto';
                font-size: 12px;
                font-weight: 300;
                height: 35px;
                outline: medium none;
                padding-left: 10px;
                width: 155px;
                background-image: url(../images/home/searchicon.png);
                background-repeat: no-repeat;
                background-position: 130px;
            }


            /*  Dropdown menu*/

            .navbar-header
            .navbar-toggle .icon-bar {
                background-color: #fff;
            }


            .nav.navbar-nav > li:hover > ul.sub-menu{
                display: block;
                -webkit-animation: fadeInUp 400ms;
                -moz-animation: fadeInUp 400ms;
                -ms-animation: fadeInUp 400ms;
                -o-animation: fadeInUp 400ms;
                animation: fadeInUp 400ms;
            }

            ul.sub-menu {
                position: absolute;
                top: 30px;
                left: 0;
                background: rgba(0, 0, 0, 0.6);
                list-style: none;
                padding: 0;
                margin: 0;
                width: 220px;
                -webkit-box-shadow: 0 3px 3px rgba(0, 0, 0, 0.1);
                box-shadow: 0 3px 3px rgba(0, 0, 0, 0.1);
                display: none;
                z-index: 999;
            }

            .dropdown ul.sub-menu li .active{
                color: #FDB45E;
                padding-left: 0;
            }


            .navbar-nav li ul.sub-menu li{
                padding: 10px 20px 0 ;
            }

            .navbar-nav li ul.sub-menu li:last-child{
                padding-bottom: 20px;
            }

            .navbar-nav li ul.sub-menu li a{
                color: #fff;
            }

            .navbar-nav li ul.sub-menu li a:hover{
                color: #FDB45E;
            }

            .fa-angle-down{
                padding-left: 5px;
            }
            @-webkit-keyframes fadeInUp {
                0% {
                    opacity: 0;
                    -webkit-transform: translateY(20px);
                    transform: translateY(20px);
                }

                100% {
                    opacity: 1;
                    -webkit-transform: translateY(0);
                    transform: translateY(0);
                }
            }

            ul li {
                list-style: none;
            }

            a:hover {
                outline: none;
                text-decoration:none;
            }

            a:focus {
                outline:none;
                outline-offset: 0;
            }

            a {
                -webkit-transition: 300ms;
                -moz-transition: 300ms;
                -o-transition: 300ms;
                transition: 300ms;
            }

            h1, h2, h3, h4, h5, h6 {
                font-family: 'Roboto', sans-serif;
            }

            .btn:hover,
            .btn:focus{
                outline: none;
                box-shadow: none;
            }

            .navbar-toggle {
                background-color: #000;
            }

            a#scrollUp {
                bottom: 0px;
                right: 10px;
                padding: 5px 10px;
                background: #FE980F;
                color: #FFF;
                -webkit-animation: bounce 2s ease infinite;
                animation: bounce 2s ease infinite;
            }

            a#scrollUp i{
                font-size: 30px;
            }

            body {
                font-family: 'Roboto', sans-serif;
                background:;
                position: relative;
                font-weight:400px;
            }


        </style>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link href="css/responsive.css" rel="stylesheet">
    </head>
    <div id="header"><!--header-->
        <div class="header_top"><!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="row social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><i class="col fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="col fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="col fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="col fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="col fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header_top-->

        <div class="header-middle"><!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="logo pull-left">
                            <a href="index.html"><img src="images/home/logo.png" alt="" /></a>
                        </div>
                        <div class="btn-group pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                    USA
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Canada</a></li>
                                    <li><a href="#">UK</a></li>
                                </ul>
                            </div>

                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                    DOLLAR
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Canadian Dollar</a></li>
                                    <li><a href="#">Pound</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><i class="fa fa-user"></i> Account</a></li>
                                <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
                                <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                <li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                                <li><a href="login.html"><i class="fa fa-lock"></i> Login</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header-middle-->

        <div class="header-bottom"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><a href="index.html" class="active">Home</a></li>
                                <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html">Products</a></li>
                                        <li><a href="product-details.html">Product Details</a></li> 
                                        <li><a href="checkout.html">Checkout</a></li> 
                                        <li><a href="cart.html">Cart</a></li> 
                                        <li><a href="login.html">Login</a></li> 
                                    </ul>
                                </li> 
                                <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="blog.html">Blog List</a></li>
                                        <li><a href="blog-single.html">Blog Single</a></li>
                                    </ul>
                                </li> 
                                <li><a href="404.html">404</a></li>
                                <li><a href="contact-us.html">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="search_box pull-right">
                            <input type="text" placeholder="Search"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/header-bottom-->

       
    </div>
    <!--/header-->
