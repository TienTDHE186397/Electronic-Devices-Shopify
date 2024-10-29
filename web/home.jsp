<%-- 
   Document   : index
   Created on : May 18, 2024, 11:03:56 PM
   Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Slider" %>
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
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
        <style>
            body {
                
                background: #e2f2fd;
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

            .card.position-relative{
                border-radius: 10px;
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
                border-radius: 5px;
            }
            .card-img-top{
                width: 160px;
                height: 180px;
                display: inline;
                line-height: 24px;
                margin: 5px;

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
            
            .buy-option{
                display: flex;
                justify-content: center;
            }
        </style>

    </head>
    <body>
        <!-- Header start -->
        <%@include file="header.jsp" %>
        <!-- Header end -->
        <!---------------------------- Phần banner lớn start-------------------------------->
        <section id="center" class="center_home center-custom">
            <%
                List<Slider> sliders = (List<Slider>) request.getAttribute("listSlider");
                String carouselId = "carousel" + System.currentTimeMillis();
            %>

            <div id="<%= carouselId %>" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <%
                        for (int i = 0; i < sliders.size(); i++) {
                            Slider slider = sliders.get(i);
                    %>
                    <div class="carousel-item <%= (i == 0) ? "active" : "" %>">
                        <img class="d-block w-100" src="<%= slider.getSlider_image() %>" alt="<%= slider.getSlider_tittle() %>">
                        <div class="carousel-caption d-none d-md-block">
                            <h5><%= slider.getSlider_tittle() %></h5>
                            <p><%= slider.getSlider_note() %></p>
                            <a href="<%= slider.getSlider_backlink() %>" class="btn btn-primary">Learn More</a>
                        </div>
                    </div>
                    <% } %>
                </div>

                <!-- Điều khiển trái/phải -->
                <a class="carousel-control-prev" href="#<%= carouselId %>" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#<%= carouselId %>" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </section>
        <!-- banner end -->
        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">Shopify</h1>
            </div>
        </section>

        <!-------------------------------- comment --------------------------------->     


        <section class="product-list container">
            <div class="row">
                <h2 class="col-md-6 product-type-title" id="dien_thoai">Điện Thoại - Tablet</h2>

                <div class="col-md-6 row product-type-select">
                    <c:forEach items="${brand_phone_and_tablet}" var="brand">
                        <a href="./home?cateid=1&brand=${brand}" class="col-auto mobile">${brand}</a>
                    </c:forEach>
                    <a href="./home?cateid=1&brand=all" class="col-auto mobile">Xem tất cả</a>
                </div>

            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${list_phone_and_tablet}" var="list1" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                                    </c:if>
                                    <li class="container-product-item col-md-3">
                                        <div class="card position-relative">
                                            <span class="discount-badge">Giảm ${list1.getSale()}%</span>
                                            <a href="product-detail?ProductID=${list1.getProductID()}">
                                            <div class="product-image">
                                                <img src="${list1.getImg()}" class="card-img-top" alt="none">
                                            </div>
                                            </a>
                                            <div class="card-body">
                                                <h6 class="card-title">${list1.getProductName()}</h6>
                                                <div class="price">Giá ưu đãi: ${list1.getPrice() * (1 - list1.getSale() / 100)}đ</div>
                                                <div class="original-price">Giá gốc: ${list1.getPrice()}đ</div>
                                                <div style="color: #000;">Số lượng còn: <b>${list1.getQuantity()}</b></div>
                                                <div style="color: #000;">Thương hiệu: <b>${list1.getBrand()}</b></div>                                 
                                                <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                                <div class="buy-option">                                                  
                                                    <c:choose>
                                                        <c:when test="${empty sessionScope.user}">
                                                            <a href="cart?ProductID=${list1.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="cart?ProductID=${list1.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${status.index % 4 == 3 || status.index == list_phone_and_tablet.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>         
            </div>
        </section> 

        <!-------------------------------- comment --------------------------------->             

        <section class="product-list container">
            <div class="row">
                <h2 class="col product-type-title">Laptop</h2>

                <div class="col-md-10 row product-type-select">
                    <c:forEach items="${brand_laptop}" var="brand_laptop">
                        <a href="./home?cateid=2&brand=${brand_laptop}" class="col-auto mobile">${brand_laptop}</a>
                    </c:forEach>
                    <a href="./home?cateid=2&brand=all" class="col-auto mobile">Xem tất cả</a>
                </div>

            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${list_laptop}" var="list2" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                                    </c:if>
                                    <li class="container-product-item col-md-3">
                                        <div class="card position-relative">
                                            <span class="discount-badge">Giảm ${list2.getSale()}%</span>
                                            <a href="product-detail?ProductID=${list2.getProductID()}">
                                            <div class="product-image">
                                                <img src="${list2.getImg()}" class="card-img-top" alt="none">
                                            </div>
                                            </a>
                                            <div class="card-body">
                                                <h6 class="card-title">${list2.getProductName()}</h6>
                                                <div class="price">Giá ưu đãi: ${list2.getPrice() * (1 - list2.getSale() / 100)}đ</div>
                                                <div class="original-price">Giá gốc: ${list2.getPrice()}đ</div>                            
                                                <div style="color: #000;">Số lượng còn: <b>${list2.getQuantity()}</b></div>
                                                <div style="color: #000;">Thương hiệu: <b>${list2.getBrand()}</b></div> 
                                                <p>Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</p>
                                                <div class="buy-option">        
                                                    <c:choose>
                                                        <c:when test="${empty sessionScope.user}">
                                                            <a href="cart?ProductID=${list2.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                           
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="cart?ProductID=${list2.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${status.index % 4 == 3 || status.index == list_laptop.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </section> 

        <!-------------------------------- comment --------------------------------->           

        <section class="product-list container">
            <div class="row">
                <h2 class="col product-type-title">PC</h2>              
                <div class="col-md-10 row product-type-select">
                    <c:forEach items="${brand_pc}" var="brand_pc">
                        <a href="./home?cateid=3&brand=${brand_pc}" class="col-auto mobile">${brand_pc}</a>
                    </c:forEach>
                    <a href="./home?cateid=3&brand=all" class="col-auto mobile">Xem tất cả</a>
                </div>
            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${list_pc}" var="list3" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                                    </c:if>
                                    <li class="container-product-item col-md-3">
                                        <div class="card position-relative">
                                            <span class="discount-badge">Giảm ${list3.getSale()}%</span>
                                            <a href="product-detail?ProductID=${list3.getProductID()}">
                                            <div class="product-image">
                                                <img src="${list3.getImg()}" class="card-img-top" alt="none">
                                            </div>
                                            </a>
                                            <div class="card-body">
                                                <h6 class="card-title" style="overflow: hidden">${list3.getProductName()}</h6>
                                               <div class="price">Giá ưu đãi: ${list3.getPrice() * (1 - list3.getSale() / 100)}đ</div>
                                                <div class="original-price">Giá gốc: ${list3.getPrice()}đ</div>                              
                                                <div style="color: #000;">Số lượng còn: <b>${list3.getQuantity()}</b></div>
                                                <div style="color: #000;">Thương hiệu: <b>${list3.getBrand()}</b></div> 
                                                
                                                <div class="buy-option">
                                                   
                                                    <c:choose>
                                                        <c:when test="${empty sessionScope.user}">
                                                            <a href="cart?ProductID=${list3.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="cart?ProductID=${list3.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${status.index % 4 == 3 || status.index == list_pc.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>      
            </div>
        </section>

        <!-------------------------------- comment --------------------------------->     

        <section class="product-list container">
            <div class="row">
                <h2 class="col product-type-title">Màn Hình</h2>              
                <div class="col-md-10 row product-type-select">
                    <c:forEach items="${brand_monitor}" var="brand_monitor">
                        <a href="./home?cateid=4&brand=${brand_monitor}" class="col-auto mobile">${brand_monitor}</a>
                    </c:forEach>
                    <a href="./home?cateid=4&brand=all" class="col-auto mobile">Xem tất cả</a>
                </div>
            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${list_monitor}" var="list4" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                                    </c:if>
                                    <li class="container-product-item col-md-3">
                                        <div class="card position-relative">
                                            <span class="discount-badge">Giảm ${list4.getSale()}%</span>
                                            <a href="product-detail?ProductID=${list4.getProductID()}">
                                            <div class="product-image">
                                                <img src="${list4.getImg()}" class="card-img-top" alt="none">
                                            </div>
                                            </a>
                                            <div class="card-body">
                                                <h6 class="card-title">${list4.getProductName()}</h6>
                                                <div class="price">Giá ưu đãi: ${list4.getPrice() * (1 - list4.getSale() / 100)}đ</div>
                                                <div class="original-price">Giá gốc: ${list4.getPrice()}đ</div>                              
                                                <div style="color: #000;">Số lượng còn: <b>${list4.getQuantity()}</b></div>
                                                <div style="color: #000;">Thương hiệu: <b>${list4.getBrand()}</b></div>                             
                                                <div style="font-style: italic">Trả góp <b>0%</b> qua thẻ tín dụng kỳ hạn <b>3-6 tháng</b></div>
                                                <div class="buy-option">
                                                    
                                                    <c:choose>
                                                        <c:when test="${empty sessionScope.user}">
                                                            <a href="cart?ProductID=${list4.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="cart?ProductID=${list4.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${status.index % 4 == 3 || status.index == list_monitor.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>      
            </div>
        </section>
        <!-------------------------------- comment --------------------------------->       
        <section class="product-list container" id="headphone">
            <div class="row">
                <h2 class="col product-type-title">Tai nghe</h2>              
                <div class="col-md-10 row product-type-select">
                    <c:forEach items="${brand_headphone}" var="brand_headphone">
                        <a href="./home?cateid=5&brand=${brand_headphone}" class="col-auto mobile">${brand_headphone}</a>
                    </c:forEach>
                    <a href="./home?cateid=5&brand=all" class="col-auto mobile">Xem tất cả</a>
                </div>
            </div>

            <div id="productList" class="product-list">
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${list_headphone}" var="list5" varStatus="status">
                            <c:if test="${status.index % 4 == 0}">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                    <ul class="list-unstyled d-flex flex-wrap justify-content-center">
                                    </c:if>
                                    <li class="container-product-item col-md-3">
                                        <div class="card position-relative">
                                            <span class="discount-badge">Giảm ${list5.getSale()}%</span>
                                            <a href="product-detail?ProductID=${list5.getProductID()}">
                                            <div class="product-image">
                                                <img src="${list5.getImg()}" class="card-img-top" alt="none">
                                            </div>
                                            </a>
                                            <div class="card-body">
                                                <h6 class="card-title">${list5.getProductName()}</h6>
                                                <div class="price">Giá ưu đãi: ${list5.getPrice() * (1 - list5.getSale() / 100)}đ</div>
                                                <div class="original-price">Giá gốc: ${list5.getPrice()}đ</div>                              
                                                <div style="color: #000;">Số lượng còn: <b>${list5.getQuantity()}</b></div>
                                                <div style="color: #000;">Thương hiệu: <b>${list5.getBrand()}</b></div>                             
                                                <div style="font-style: italic">Trả góp <b>0%</b> qua thẻ tín dụng kỳ hạn <b>3-6 tháng</b></div>
                                                <div class="buy-option">
                                                    
                                                    <c:choose>
                                                        <c:when test="${empty sessionScope.user}">
                                                            <a href="cart?ProductID=${list5.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="cart?ProductID=${list5.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${status.index % 4 == 3 || status.index == list_headphone.size() - 1}">
                                    </ul>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                
                
            </div>
        </section>
        
        <df-messenger
                    intent="WELCOME"
                    chat-title="Test_AI_@1543"
                    agent-id="5b284bab-6b4e-465e-bf1b-a4722ed1f4cb"
                    language-code="vi"
                    ></df-messenger>
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>

</html>
