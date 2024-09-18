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
<<<<<<< HEAD
            .custom-button {
                background-color: #f7c33e;
                color: #fff;
                font-size: 12px;
                padding: 10px 45px;
                border: 1px solid transparent;
                border-radius: 8px;
                font-weight: 600;
                letter-spacing: 0.5px;
                text-transform: uppercase;

            }
=======

>>>>>>> 5df174f637e24d3e4e68b2f64790ed8afcec6e1c

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
                display: inline-block;
                padding: 5px 10px;
                justify-content: center;
                font-family: Roboto;
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
        </style>

    </head>
    <body>

        <!-- Header start -->


        <!-- Header end -->

        <!-- Product start -->

        <!-- Phần banner lớn start-->
        <section id="center" class="center_home container">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2" class="" aria-current="true"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/thang-oppo-muon-van-uu-dai-home.jpg" class="d-block w-100" alt="...">

                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/fold-6-km-moi-home-30-8.png" class="d-block w-100" alt="...">

                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/laptop-ai-banner-chung-slide.png" class="d-block w-100" alt="...">

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
                <h2 class="col product-type-title">ĐIỆN THOẠI</h2>
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

            <div class="container-product-item row container-fluid">
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 15%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="iPhone 15 128GB">
                        <div class="card-body">
                            <h6 class="card-title">iPhone 15 128GB</h6>
                            <p class="price">19.590.000đ <span class="original-price">22.990.000đ</span></p>
                            <p>Smember giảm thêm đến <b>196.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>
                <!-- Product Card 2 -->
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 17%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Samsung Galaxy M55">
                        <div class="card-body">
                            <h6 class="card-title">Samsung Galaxy M55 (12GB 256GB)</h6>
                            <p class="price">10.490.000đ <span class="original-price">12.690.000đ</span></p>
                            <p>Smember giảm thêm đến <b>105.000đ</b></p>
                            <p>S-Student giảm thêm đến <b>600.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>
                <!-- Product Card 3 -->
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>

                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span> 
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>

                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                        <div class="rating-favorite">
                            <div>
                                <!-- Five star rating -->
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                            </div>

                            <!-- Favorite Icon Section -->
                            <div>
                                <!-- Heart Icon -->
                                <span style="color: red; font-size: 20px; cursor: pointer;">&#10084;</span>
                            </div>
                        </div>
                    </div>
                </div>

                <section class="product-list container">
                    <div class="row">
                        <h2 class="col product-type-title">LAPTOP</h2>
                        <div class="col-md-10 row product-type-select">
                            <a href="#" class="col-auto mobile">Macbook</a>
                            <a href="#" class="col-auto mobile">Asus</a>
                            <a href="#" class="col-auto mobile">MSI</a>
                            <a href="#" class="col-auto mobile">Lenovo</a>
                            <a href="#" class="col-auto mobile">HP</a>
                            <a href="#" class="col-auto mobile">Acer</a>
                            <a href="#" class="col-auto mobile">Dell</a>
                            <a href="#" class="col-auto mobile">Gigabyte</a>
                            <a href="#" class="col-auto mobile">Xem tất cả</a>
                        </div>    
                    </div>

                    <div class="container-product-item row container-fluid">
                        <div class="col-auto card-product">
                            <div class="card position-relative">
                                <span class="discount-badge">Giảm 15%</span>
                                <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="iPhone 15 128GB">
                                <div class="card-body">
                                    <h6 class="card-title">iPhone 15 128GB</h6>
                                    <p class="price">19.590.000đ <span class="original-price">22.990.000đ</span></p>
                                    <p>Smember giảm thêm đến <b>196.000đ</b></p>
                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                </div>
                            </div>
                        </div>
                        <!-- Product Card 2 -->
                        <div class="col-auto card-product">
                            <div class="card position-relative">
                                <span class="discount-badge">Giảm 17%</span>
                                <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Samsung Galaxy M55">
                                <div class="card-body">
                                    <h6 class="card-title">Samsung Galaxy M55 (12GB 256GB)</h6>
                                    <p class="price">10.490.000đ <span class="original-price">12.690.000đ</span></p>
                                    <p>Smember giảm thêm đến <b>105.000đ</b></p>
                                    <p>S-Student giảm thêm đến <b>600.000đ</b></p>
                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                </div>
                            </div>
                        </div>
                        <!-- Product Card 3 -->
                        <div class="col-auto card-product">
                            <div class="card position-relative">
                                <span class="discount-badge">Giảm 6%</span>
                                <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                                <div class="card-body">
                                    <h6 class="card-title">Xiaomi Redmi 14C</h6>
                                    <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                                    <p>Smember giảm thêm đến <b>31.000đ</b></p>
                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-auto card-product">
                            <div class="card position-relative">
                                <span class="discount-badge">Giảm 6%</span> 
                                <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                                <div class="card-body">
                                    <h6 class="card-title">Xiaomi Redmi 14C</h6>
                                    <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                                    <p>Smember giảm thêm đến <b>31.000đ</b></p>
                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-auto card-product">
                            <div class="card position-relative">
                                <span class="discount-badge">Giảm 6%</span>
                                <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                                <div class="card-body">
                                    <h6 class="card-title">Xiaomi Redmi 14C</h6>
                                    <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                                    <p>Smember giảm thêm đến <b>31.000đ</b></p>
                                    <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                </div>
                                <div class="rating-favorite">
                                    <div>
                                        <!-- Five star rating -->
                                        <span style="color: gold;">&#9733;</span>
                                        <span style="color: gold;">&#9733;</span>
                                        <span style="color: gold;">&#9733;</span>
                                        <span style="color: gold;">&#9733;</span>
                                        <span style="color: gold;">&#9733;</span>
                                    </div>

                                    <!-- Favorite Icon Section -->
                                    <div>
                                        <!-- Heart Icon -->
                                        <span style="color: red; font-size: 20px; cursor: pointer;">&#10084;</span>
                                    </div>
                                </div>
                            </div>
                        </div>    
                    </div>
            </div>

        </section>

<<<<<<< HEAD

=======
        <section class="product-list container">
            <div class="row">
                <h2 class="col product-type-title">PC</h2>
                <div class="col-md-10 row product-type-select">
                    <a href="#" class="col-auto mobile">Macbook</a>
                    <a href="#" class="col-auto mobile">Asus</a>
                    <a href="#" class="col-auto mobile">MSI</a>
                    <a href="#" class="col-auto mobile">Lenovo</a>
                    <a href="#" class="col-auto mobile">HP</a>
                    <a href="#" class="col-auto mobile">Acer</a>
                    <a href="#" class="col-auto mobile">Dell</a>
                    <a href="#" class="col-auto mobile">Gigabyte</a>
                    <a href="#" class="col-auto mobile">Xem tất cả</a>
                </div>    
            </div>

            <div class="container-product-item row container-fluid">
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 15%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="iPhone 15 128GB">
                        <div class="card-body">
                            <h6 class="card-title">iPhone 15 128GB</h6>
                            <p class="price">19.590.000đ <span class="original-price">22.990.000đ</span></p>
                            <p>Smember giảm thêm đến <b>196.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>
                <!-- Product Card 2 -->
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 17%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Samsung Galaxy M55">
                        <div class="card-body">
                            <h6 class="card-title">Samsung Galaxy M55 (12GB 256GB)</h6>
                            <p class="price">10.490.000đ <span class="original-price">12.690.000đ</span></p>
                            <p>Smember giảm thêm đến <b>105.000đ</b></p>
                            <p>S-Student giảm thêm đến <b>600.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>
                <!-- Product Card 3 -->
                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>

                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span> 
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                    </div>
                </div>

                <div class="col-auto card-product">
                    <div class="card position-relative">
                        <span class="discount-badge">Giảm 6%</span>
                        <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                        <div class="card-body">
                            <h6 class="card-title">Xiaomi Redmi 14C</h6>
                            <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                            <p>Smember giảm thêm đến <b>31.000đ</b></p>
                            <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                        </div>
                        <div class="rating-favorite">
                            <div>
                                <!-- Five star rating -->
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                                <span style="color: gold;">&#9733;</span>
                            </div>

                            <!-- Favorite Icon Section -->
                            <div>
                                <!-- Heart Icon -->
                                <span style="color: red; font-size: 20px; cursor: pointer;">&#10084;</span>
                            </div>
                        </div>
                    </div>
                </div>    
            </div>
        </div>
    </section>
>>>>>>> 5df174f637e24d3e4e68b2f64790ed8afcec6e1c

    <section class="product-list container">
        <div class="row">
            <h2 class="col product-type-title">Màn hình</h2>
            <div class="col-md-10 row product-type-select">
                <a href="#" class="col-auto mobile">Macbook</a>
                <a href="#" class="col-auto mobile">Asus</a>
                <a href="#" class="col-auto mobile">MSI</a>
                <a href="#" class="col-auto mobile">Lenovo</a>
                <a href="#" class="col-auto mobile">HP</a>
                <a href="#" class="col-auto mobile">Acer</a>
                <a href="#" class="col-auto mobile">Dell</a>
                <a href="#" class="col-auto mobile">Gigabyte</a>
                <a href="#" class="col-auto mobile">Xem tất cả</a>
            </div>    
        </div>

        <div class="container-product-item row container-fluid">
            <div class="col-auto card-product">
                <div class="card position-relative">
                    <span class="discount-badge">Giảm 15%</span>
                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="iPhone 15 128GB">
                    <div class="card-body">
                        <h6 class="card-title">iPhone 15 128GB</h6>
                        <p class="price">19.590.000đ <span class="original-price">22.990.000đ</span></p>
                        <p>Smember giảm thêm đến <b>196.000đ</b></p>
                        <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                    </div>
                </div>
            </div>
            <!-- Product Card 2 -->
            <div class="col-auto card-product">
                <div class="card position-relative">
                    <span class="discount-badge">Giảm 17%</span>
                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Samsung Galaxy M55">
                    <div class="card-body">
                        <h6 class="card-title">Samsung Galaxy M55 (12GB 256GB)</h6>
                        <p class="price">10.490.000đ <span class="original-price">12.690.000đ</span></p>
                        <p>Smember giảm thêm đến <b>105.000đ</b></p>
                        <p>S-Student giảm thêm đến <b>600.000đ</b></p>
                        <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                    </div>
                </div>
            </div>
            <!-- Product Card 3 -->
            <div class="col-auto card-product">
                <div class="card position-relative">
                    <span class="discount-badge">Giảm 6%</span>
                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                    <div class="card-body">
                        <h6 class="card-title">Xiaomi Redmi 14C</h6>
                        <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                        <p>Smember giảm thêm đến <b>31.000đ</b></p>
                        <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                    </div>
                </div>
            </div>

            <div class="col-auto card-product">
                <div class="card position-relative">
                    <span class="discount-badge">Giảm 6%</span> 
                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                    <div class="card-body">
                        <h6 class="card-title">Xiaomi Redmi 14C</h6>
                        <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                        <p>Smember giảm thêm đến <b>31.000đ</b></p>
                        <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                    </div>
                </div>
            </div>

            <div class="col-auto card-product">
                <div class="card position-relative">
                    <span class="discount-badge">Giảm 6%</span>
                    <img src="https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-15-plus_1__1.png" class="card-img-top" alt="Xiaomi Redmi 14C">
                    <div class="card-body">
                        <h6 class="card-title">Xiaomi Redmi 14C</h6>
                        <p class="price">3.090.000đ <span class="original-price">3.290.000đ</span></p>
                        <p>Smember giảm thêm đến <b>31.000đ</b></p>
                        <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                    </div>
                    <div class="rating-favorite">
                        <div>
                            <!-- Five star rating -->
                            <span style="color: gold;">&#9733;</span>
                            <span style="color: gold;">&#9733;</span>
                            <span style="color: gold;">&#9733;</span>
                            <span style="color: gold;">&#9733;</span>
                            <span style="color: gold;">&#9733;</span>
                        </div>

                        <!-- Favorite Icon Section -->
                        <div>
                            <!-- Heart Icon -->
                            <span style="color: red; font-size: 20px; cursor: pointer;">&#10084;</span>
                        </div>
                    </div>
                </div>
            </div>    
        </div>
    </div>
</section>        



</div>
</div>

</section>


<!-- Footer start -->
<%@include file="footer.jsp" %>
<!-- Footer end -->
</body>

</html>
