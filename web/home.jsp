<%-- 
   Document   : index
   Created on : May 18, 2024, 11:03:56 PM
   Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Shopify</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <script src="js/bootstrap.bundle.min.js"></script>
        <style>
            body {
                font-family: Roboto;
            }
            /* CSS */
            .prod_2im img {
                width: 406px;
                height: 500px; /* Đặt kích thước cố định */
                object-fit: cover; /* Đảm bảo hình ảnh không bị biến dạng */
            }

            .ellipsis {
                white-space: nowrap; /* Ngăn chặn văn bản xuống dòng */
                overflow: hidden; /* Ẩn phần văn bản bị tràn */
                text-overflow: ellipsis; /* Hiển thị dấu "..." khi văn bản tràn */
            }


            .highlight-yellow {
                color: #f7ba01;
            }
            .logo-img {
                width: 120px;
                height: 75px;
                vertical-align: middle;
                margin-right: 10px;
            }
            .arrive_m {
                background-image: url('img/3i2.jpg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                padding: 20px;
                color: white;
            }

            /*            .custom-button {
                            background-color: #f7c33e;
                            color: #fff;
                            font-size: 12px;
                            padding: 10px 45px;
                            border: 1px solid transparent;
                            border-radius: 8px;
                            font-weight: 600;
                            letter-spacing: 0.5px;
                            text-transform: uppercase;
            
                        }*/

            #subs {
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
            }

            .brand-name {
                font-size: 4rem; /* Kích thước chữ lớn hơn */
                font-weight: bold;
                background: linear-gradient(45deg, #ff6, #f06, #f90, #6f9);
                background-size: 300%;
                color: transparent; /* Ẩn màu chữ gốc */
                background-clip: text;
                -webkit-background-clip: text;
                animation: gradientAnimation 5s ease infinite;
                text-transform: uppercase; /* Viết hoa toàn bộ chữ */
                letter-spacing: 0.2rem; /* Khoảng cách giữa các chữ cái lớn hơn */
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); /* Đổ bóng chữ */
            }

            @keyframes gradientAnimation {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }

            .bg_light_1 {
                background-color: transparent; /* Làm nền trong suốt để hiển thị gradient phía sau */
            }

            .mobile{
                align-content: center;
                border: 1px solid #e5e7eb;
                border-radius: 20px;
                text-align: center;
                margin: 10px;
                background-color: #f3f4f6;
                /*                display: inline-block;*/
                padding: 5px 10px;
                /*                justify-content: center;
                                font-family: Roboto;*/
                text-decoration: none;
                color: #444;
            }

            .card{
                align-content: center;
                border-radius: 20px;
                margin: 5px;
                width: 230px;
                height: 450px;
                align-items: center;
            }

            .card-title {
                font-size: 1rem;
                font-weight: bold;
            }
            .price {
                color: red;
                font-weight: bold;
            }
            .original-price {
                text-decoration: line-through;
                color: gray;
            }
            .discount-badge {
                position: absolute;
                top: 10px;
                left: 10px;
                background-color: red;
                color: white;
                padding: 5px;
                font-size: 0.9rem;
            }
            .card-img-top{
                width: 160px;
                height: 160px;
                display: inline;
                line-height: 24px;
            }

            .product-image{
                width: 205px;
                height: 177px;
            }

            .rating-favorite{
                display: flex;

            }

            .product-type-select{
                justify-content: end;
            }

            .product-type-title{
                align-content: center;
                margin: -12px;
            }

            .card-product{
                padding: 0;
            }
            .container-product-item{
                justify-content: center;
            }
            .product-list{
                padding: 0;
            }
            .center-custom {
                
            }
            /* <!-- Slider css --> */
            .slider-title {
                font-size: 2rem;
                font-weight: bold;
                color: #fff;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            }
            .slider-description {
                font-size: 1.2rem;
                color: #fff;
                text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
            }
            /* CSS Slider Product List */
            .product-list{
                margin: 20px;
            }
        </style>

    </head>
    <body>
        <!-- Sidebar start -->

        <!-- Sidebar end -->
        <!-- Header start -->
        <%@include file="header.jsp" %>
        <!-- Header end -->

        <!-- Product start -->
        <!-- Sidebar start -->

        <!-- Phần banner lớn start-->
        <section id="center" class="center_home container center-custom">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2" class="" aria-current="true"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/thang-oppo-muon-van-uu-dai-home.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 class="slider-title">Ưu đãi tháng Oppo</h5>
                            <p class="slider-description">Nhiều ưu đãi hấp dẫn đang chờ bạn</p>
                            <a href="https://www.example.com" class="btn btn-primary">Xem ngay</a>
                        </div>
                        
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/fold-6-km-moi-home-30-8.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 class="slider-title">Ưu đãi tháng Samsung</h5>
                            <p class="slider-description">Khuyến mãi đặc biệt cho các dòng Samsung</p>
                            <a href="https://www.example.com" class="btn btn-primary">Xem ngay</a>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/laptop-ai-banner-chung-slide.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 class="slider-title">Ưu đãi tháng Laptop</h5>
                            <p class="slider-description">Khuyến mãi đặc biệt cho các dòng laptop</p>
                            <a href="https://www.example.com" class="btn btn-primary">Xem ngay</a>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </section>
        <!-- banner end -->
        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">Shopify</h1>
            </div>
        </section>

        <section class="product-list container">
            <div class="row">
                <h2 class="col product-type-title">Màn hình</h2>
                <div class="col-md-10 row product-type-select">
                    <a href="#" class="col-auto mobile">Apple</a>
                    <a href="#" class="col-auto mobile">Samsung</a>
                    <a href="#" class="col-auto mobile">Xiaomi</a>
                    <a href="#" class="col-auto mobile">Oppo</a>
                    <a href="#" class="col-auto mobile">Vivo</a>
                    <a href="#" class="col-auto mobile">Realme</a>
                    <a href="#" class="col-auto mobile">Xem tất cả</a>
                </div>    
            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${listLaptop}" var="l" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                            </c:if>
                                        <li class="container-product-item col-md-3">
                                            <div class="card position-relative">
                                                <span class="discount-badge">Giảm ${l.getProduct().getSale()}%</span>
                                                <div class="product-image">
                                                    <img src="${l.getImg()}" class="card-img-top" alt="none">
                                                </div>   
                                                <div class="card-body">
                                                    <h6 class="card-title">${l.getLapName()}</h6>
                                                    <p class="price">${l.getPrice()} <span class="original-price">${l.getPrice() * (1 - l.getProduct().getSale() / 100)}đ</span></p>
                                                    <p>Smember giảm thêm đến <b>196.000đ</b></p>
                                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                                </div>
                                            </div>
                                        </li>
                            <c:if test="${status.index % 4 == 3 || status.index == listLaptop.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </section> 
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>

</html>
