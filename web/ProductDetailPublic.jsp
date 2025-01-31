<%-- 
    Document   : ProductDetailPublic
    Created on : Oct 9, 2024, 11:25:44 PM
    Author     : Dokkuhai
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.UUID" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="img/Icon.jpg">
        <title>Thông tin chi tiết sản phẩm ${productDetail.getProductName()}</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <meta name="viewport" content="width=device-wixdth, initial-scale=1">
        <script src="js/bootstrap.bundle.min.js"></script>
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.cdnfonts.com/css/roboto" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>

        <style>




            .container {
                display: flex;
                justify-content: space-between;
                max-width: 1200px;
                margin: 0 auto;
            }

            .main-content {
                width: 100%;
            }

            .post-image {
                width: 100%;
                border-radius: 8px;
            }

            h1 {
                margin-top: 20px;
                font-size: 2rem;
                font-weight: bold;
                color: #000;
            }

            .meta span {

                color: #000;

            }

            p {
                margin-top: 10px;
                line-height: 1.6;
                color: #000;
            }

            .social-links {
                margin-top: 20px;
            }

            .social-links a {
                margin-right: 15px;
                color: #000;
                font-size: 1.5rem;
                text-decoration: none;
            }

            .related-posts {
                width: 30%;
                background-color: #222;
                padding: 20px;
                border-radius: 8px;
            }

            h3{
                color: #000;
            }

            .related-post {
                display: flex; /* Sử dụng Flexbox để căn chỉnh nội dung */
                align-items: center; /* Căn giữa theo chiều dọc */
                margin-bottom: 20px;

            }

            .related-post h4 {
                padding-left: 20px;
            }

            .related-posts h2 {
                font-size: 1.5rem;
                margin-bottom: 20px;
            }

            .post {
                margin-bottom: 20px;
            }

            .post img {
                width: 100%;
                border-radius: 8px;
                margin-bottom: 10px;
            }

            .post a {
                color: #000;
                text-decoration: none;
                font-size: 1.1rem;
            }

            .post a:hover {
                color: yellow;
            }

            /* Comments Section */
            .comments-section {
                margin-top: 40px;
                background-color: #222;
                padding: 20px;
                border-radius: 8px;
                max-width: 800px;
                margin-left: auto;
                margin-right: auto;
            }

            .comments-section h2 {
                margin-bottom: 10px;
                font-size: 1.5rem;
            }

            .comments-section textarea {
                width: 100%;
                padding: 10px;
                border-radius: 5px;
                border: none;
                background-color: #333;
                color: #000;
                resize: none;
                font-size: 1rem;
                line-height: 1.4;
            }

            .comments-section button {
                margin-top: 10px;
                padding: 8px 16px;
                border: none;
                background-color: #00bfff;
                color: #000;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1rem;
                display: block;
                margin-left: auto;
            }

            .comments-section button:hover {
                background-color: #0099cc;
            }

            /* Posted Comments Section */
            .posted-comments {
                margin-top: 20px;
                border-top: 1px solid #444;
                padding-top: 20px;
            }

            .posted-comments h3 {
                margin-bottom: 10px;
                font-size: 1.3rem;
                color: #2d2dd5;
            }

            .comment {
                display: flex;
                align-items: flex-start;
                background-color: #333;
                padding: 10px;
                border-radius: 5px;
                color: #000;
                margin-bottom: 20px; /* Add space between comments */
                border-radius: 5px; /* Rounded corners */
            }

            .comment img {
                border-radius: 50%;
                margin-right: 15px;
                width: 50px;
                height: 50px;
            }

            .comment p {
                margin: 0;
                flex: 1;
                color: #f9f9f9f9;
            }

            .comment strong {
                color: #00bfff;
            }

            .related-posts {
                width: 30%;
                background-color: #222;
                padding: 20px;
                border-radius: 8px;
                max-height: 345px;
                overflow: hidden;
            }


            #backButton {
                position: fixed;
                top: 20px;
                left: 20px;
                padding: 10px 20px;
                background-color: blue;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1rem;
            }

            #backButton:hover {
                background-color: #0099cc;
            }

            #backButton a {
                text-decoration: none;
                color: #fff;
            }

            .related-post img {

                width: 60px;
                height: 60px;

            }

            a {
                text-decoration: none;
                color: #fff;
            }

            a:hover {
                color: yellow;
            }


            .related-posts-wrapper {
                display: block;
            }

            .related-posts {
                width: 400px;
                background-color: #222;
                margin-left: 37px;
                padding: 20px;
                border-radius: 8px;
                max-height: 345px;
                overflow: hidden;
                margin-bottom: 20px;
            }
            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body{

                align-items: center;
                justify-content: center;
                min-height: 100vh;

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
            #subs {
                margin-top: 70px;
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
                margin-bottom: 50px;
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

            .p-title{
                font-size: 30px;
                font-family: 'Roboto';
            }

            .p-title-small{
                font-size: 14px;
                font-style: italic;
                margin-right: 25px;
                display: flex;

            }

            .product-name{
                margin: 10px 30px 10px 10px;
                border-radius: 15px;
                padding: 20px;

            }

            .p-body{
                width: 100%;
                display: flex;
                justify-content: space-between;
                align-content: center;
                margin-left: 50px;
            }

            .product-title-note{
                margin: 0px 10px;
            }
            .p-infor{
                width: 45%;
                margin-left: 20px;
                border: 3px solid white;
                border-radius: 10px;
                height: 50%;
            }
            .p-image{
                width: 100%;
                height: 600px; /* Tăng chiều cao */
                max-width: 900px; /* Điều chỉnh theo ý muốn */
                margin: 0 auto; /* Căn giữa carousel */

            }

            .carousel-item{
                width: 100%; /* Đảm bảo carousel item chiếm 100% chiều rộng của phần chứa */
                height: 500px; /* Đặt chiều cao cụ thể cho carousel item */
                background-color: #F08080;
                border-radius: 10px;

            }

            .carousel-item img {
                width: 400px;
                height: 400px;
                object-fit: contain;
                margin-top: 10px;
                border-radius: 10px;
            }

            .carousel-indicators button{
                border-radius: 15px;
                margin: 0px 5px;

            }
            .carousel-indicators button img{
                border-radius: 15px;

            }
            .p-rate{
                display: flex;
            }

            .p-title-information{
                display: flex;
                margin-right: 15px;
                justify-content: space-between;
                align-content: center;
            }

            .price-table{
                padding: 0px 12px;
                width: 75%;
                background-color: #EDEDED;
                height: 150px;
                border-radius: 10px;
                margin: 15px 15px;
            }
            /* Comments Section */
            .comments-section {
                margin-top: 40px;
                background-color: #222;
                padding: 20px;
                border-radius: 8px;
                max-width: 800px;
                margin-left: auto;
                margin-right: auto;
            }

            .comments-section h2 {
                margin-bottom: 10px;
                font-size: 1.5rem;
            }

            .comments-section textarea {
                width: 100%;
                padding: 10px;
                border-radius: 5px;
                border: none;
                background-color: #333;
                color: #000;
                resize: none;
                font-size: 1rem;
                line-height: 1.4;
            }

            .comments-section button {
                margin-top: 10px;
                padding: 8px 16px;
                border: none;
                background-color: #00bfff;
                color: #000;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1rem;
                display: block;
                margin-left: auto;
            }

            .comments-section button:hover {
                background-color: #0099cc;
            }
            .button-container {
                display: flex; /* Sử dụng flexbox để sắp xếp các nút theo hàng ngang */
                gap: 10px; /* Khoảng cách giữa các nút */
                margin-top: 10px; /* Khoảng cách giữa textarea và các nút */
            }

            .brown-button {
                background-color: #8B4513; /* Màu nâu */
                color: white; /* Màu chữ trắng */
                border: none; /* Bỏ viền */
                padding: 10px 15px; /* Padding cho nút */
                border-radius: 5px; /* Bo góc cho nút */
                cursor: pointer; /* Con trỏ chuột khi di chuột qua */
            }

            .brown-button:hover {
                background-color: #7B3F1A; /* Màu nâu tối hơn khi hover */
            }
            .comment-container {
                border: 1px solid #ddd;
                padding: 15px;
                margin-bottom: 15px;
                border-radius: 8px;
                background-color: black;
            }
            .comment-header {
                font-size: 18px;
                font-weight: bold;
                color: #333;
            }
            .comment-body {
                word-wrap: break-word; /* Allow long words to be broken and wrap onto the next line */
                overflow-wrap: break-word; /* Ensure overflow wrapping in all modern browsers */
            }
            .media-section {
                margin-top: 15px;
            }
            .media-title {
                font-size: 16px;
                color: #333;
                margin-bottom: 10px;
            }
            .media-images img,
            .media-videos video {
                margin: 5px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            /*            //phan trang*/
            .pagination {
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 20px 0;
            }

            .page-link {
                display: inline-block;
                padding: 10px 15px;
                margin: 0 5px;
                border: 1px solid #007bff;
                border-radius: 5px;
                color: #007bff;
                text-decoration: none;
                transition: background-color 0.3s, color 0.3s;
            }

            .page-link:hover {
                background-color: #007bff;
                color: white;
            }

            .current-page {
                display: inline-block;
                padding: 10px 15px;
                margin: 0 5px;
                border: 1px solid #007bff;
                border-radius: 5px;
                background-color: #007bff;
                color: white;
            }
            /* General Styles */
            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }

            h1.section-title {
                font-size: 2.5rem;
                color: #333;
                text-align: center;
                margin-bottom: 30px;
                font-family: 'Arial', sans-serif;
                font-weight: bold;
            }

            /* Video Container */
            .video-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: center;
            }

            .video-item {
                width: 250px; /* Reduced width */
                background-color: #f4f4f4;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                text-align: center;
                padding: 10px;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .video-item:hover {
                transform: translateY(-5px);
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
            }

            .video-label {
                display: block;
                font-size: 1.1rem;
                color: #444;
                margin-bottom: 10px; /* Reduced margin */
                font-family: 'Arial', sans-serif;
                font-weight: bold;
            }

            /* Video Preview */
            .video-preview {
                width: 100%;
                height: 180px; /* Fixed height for smaller videos */
                border-radius: 8px;
            }

            /* Responsive Design */
            @media (max-width: 768px) {
                .video-item {
                    width: 100%;
                    max-width: 300px; /* Adjusted for smaller screens */
                }
            }

        </style>
    </head>
    <body>
        <!-- Header start -->
        <%@include file="header.jsp" %>
        <!-- Header end -->
        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">Shopify</h1>
            </div>
        </section>




        <div class="p-body">
            <div class="p-image">
                <%
                    // Tạo UUID ngẫu nhiên làm id duy nhất cho carousel
                    String carouselId = "carouselExampleIndicators" + UUID.randomUUID().toString();
                %>

                <div id="<%= carouselId%>" data-mdb-carousel-init class="carousel slide carousel-fade" data-mdb-ride="carousel">
                    <!-- Slides -->
                    <div class="carousel-inner mb-lg-auto">
                        <div class="carousel-item active">
                            <img src="${productDetail.getImg()}" class="d-block w-100" alt="..." />
                        </div>
                        <c:forEach items="${listImage}" var="imageItem">
                            <div class="carousel-item">
                                <img src="${imageItem.getImage_url()}" class="d-block w-100" alt="..." />
                            </div>
                        </c:forEach>


                    </div>


                    <!-- Controls -->
                    <button class="carousel-control-prev" type="button" data-mdb-target="#<%= carouselId%>" data-mdb-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-mdb-target="#<%= carouselId%>" data-mdb-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>

                    <!-- Thumbnails -->
                    <div class="carousel-indicators" style="margin-bottom: -20px;">
                        <button type="button" data-mdb-target="#<%= carouselId%>" data-mdb-slide-to="0" class="active" aria-current="true" aria-label="Slide 0" style="width: 100px;">
                            <img class="d-block w-100" src="${productDetail.getImg()}" class="img-fluid" />
                        </button>
                        <c:forEach items="${listImage}" var="imageThumnail">
                            <button type="button" data-mdb-target="#<%= carouselId%>" data-mdb-slide-to="${imageThumnail.getImage_id()}" aria-label="Slide ${imageThumnail.getImage_id()}" style="width: 100px;">
                                <img class="d-block w-100" src="${imageThumnail.getImage_url()}" class="img-fluid" />
                            </button>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="p-infor">
                <div class="p-title"><b>${productDetail.getProductName()}</b></div>
                <div class="p-title-small">
                    <div class="p-title-information"><b>Mã SP: </b>${productDetail.getProductID()}</div>
                    <div class="product-title-note"><b>Phân loại: </b><a href="product-list?category=${productDetail.getCategory().getCategoryID()}">${productDetail.getCategory().getCategoryName()}</a></div>
                    <div class="p-title-information">
                        <div><b>Đánh giá: </b></div>
                        <div class="p-rate">
                            <%
                                for (int i = 0; i < 5; i++) {
                            %>
                            <div style="color: #FFC125" class="rate">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <%
                                }
                            %>
                        </div>                        
                    </div>
                    <div class="p-title-information"><b>Lượt xem: </b>${productDetail.getViews()}</div>
                    <div class="product-information"><b>Ngày cập nhật: </b>${productDetail.getReleaseDate()}</div>
                </div>
                <div style="border-bottom: solid 1px gray; width: 95%;margin: 15px 0px;"></div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Thương hiệu: ${productDetail.getBrand()}</span>
                </div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Tình trạng: ${productDetail.getStatus()}</span>
                </div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Số lượng đã bán: ${productDetail.getQuantity()} chiếc</span>
                </div> 
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Số lượng còn: ${productDetail.getQuantity()} chiếc</span>
                </div> 
                <div class="price-table">
                    <div style="color: red; font-size: 20px"><b>Ưu đãi giảm tới ${productDetail.getSale()}%</b></div>
                    <table border="0" style="height: 50%;width: 70%">           
                        <tbody>
                            <tr>
                                <td style="font-size: 20px;"><b>Giá niêm yết:</b></td>
                                <td style="font-size: 20px;text-decoration: line-through;color: gray;"><fmt:formatNumber value="${productDetail.price}" pattern="#,###" />đ</td>
                            </tr>
                            <tr>
                                <td style="font-size: 20px"><b>Giá khuyến mại: </b></td>
                                <td style="font-size: 20px; color: red"><b><fmt:formatNumber value="${productDetail.price * (1 - productDetail.sale / 100)}" pattern="#,###" />đ</b></td>
                            </tr>
                        </tbody>
                    </table>
                    <div style="color: grey; font-size: 20px; font-style: italic">Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</div> 
                </div>

                <div style="display: flex">
                    <form action="cart" method="get">
                        <input type="hidden" name="ProductID" value="${productDetail.getProductID()}">
                        <label><b>Số lượng</b></label>
                        <input style="width: 50px" type="number" name="quantity" min="1" value="1" max="${productDetail.getQuantity()}">

                        <c:choose>
                            <c:when test="${empty sessionScope.user}">
                                <a href="login" onclick="alert('Bạn cần đăng nhập để mua hàng')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;height: 25px;width: 200px;font-style: 5px;"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ hàng</a>

                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ hàng</button>
                            </c:otherwise>
                        </c:choose>
                    </form>      

                </div>
            </div>


        </div>

        <div class="form-row container">

            <div class="video-container">
                <c:forEach var="video" items="${listVideo}" varStatus="status">
                    <div class="video-item">
                        <label class="video-label">${video.alt_text}</label>
                        <video class="video-preview" controls>
                            <source src="${pageContext.request.contextPath}/${video.img_video_url}" type="video/mp4">
                            Your browser does not support the video tag.
                        </video>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="row ">
            <div class="col" style="margin-left: 20px;margin-right: 5px; border: 1px solid grey;border-radius: 10px;background-color: #EDEDED">
                <h3 style="margin-top: 5px;">Thông số kỹ thuật</h3>
                <table style="border-collapse: collapse; width: 100%; border: 1px solid black;">
                    <thead>
                        <tr style="background-color: #f2f2f2;">
                            <th style="border: 1px solid black; padding: 8px; text-align: left;">Mô tả</th>
                            <th style="border: 1px solid black; padding: 8px; text-align: left;">Thông số</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listAttribute}" var="value">
                            <tr>
                                <td style="border: 1px solid black; padding: 8px;">${value.getAttributeName()}</td>
                                <td style="border: 1px solid black; padding: 8px;">${value.getAttributeValue()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                </table>

            </div>
            <div class="comments-section col">
                <h2 style="color: white;">Comments</h2>
                <c:if test="${sessionScope.user != null}">
                    <form action="product-detail?ProductID=${productDetail.getProductID()}" method="post" enctype="multipart/form-data">
                        <textarea name="comment" id="comment" rows="5" placeholder="Enter your comment..." required></textarea>
                        <div class="button-container">
                            <button type="button" class="btn btn-primary brown-button" onclick="addVideo()">Thêm Video</button>
                            <button type="button" class="btn btn-primary brown-button" onclick="addImage()">Thêm Ảnh</button>
                            <button type="submit" class="btn btn-primary brown-button">Post Comment</button>
                        </div>
                        <div id="attributeContainer"></div>
                    </form>
                </c:if>

                <c:if test="${sessionScope.user == null}">
                    <center><h3 style="color: grey;">Bạn phải đăng nhập để sử dụng tính năng bình luận</h3></center>
                    </c:if>

                <div class="posted-comments">
                    <h3 style="color: white;">Previous Comments</h3>

                    <c:forEach var="comment" items="${requestScope.comment}">
                        <div class="comment">
                            <img src="https://m.yodycdn.com/blog/anh-dai-dien-hai-yodyvn2.jpg" alt="User Image">

                            <div class="comment-container">
                                <div class="comment-header">
                                    <strong>Author:</strong> ${comment.person.name}
                                </div>
                                <div class="comment-body">
                                    <p style="max-width: 600px; word-wrap: break-word; overflow-wrap: break-word;">
                                        <strong>Comment:</strong> ${comment.getContent()}
                                    </p>
                                    <p><strong>Created At:</strong> ${comment.getCreateAt()}</p>
                                </div>

                                <c:if test="${not empty comment.imageUrls}">
                                    <div class="media-section media-images">
                                        <div class="media-title">Images:</div>
                                        <img src="${comment.imageUrls[0]}" alt="Comment Image" width="200px" />
                                        <p><strong>Image Text:</strong> ${comment.imageText[0]}</p>
                                        <div id="more-images-${comment.commentid}" style="display: none;">
                                            <c:forEach var="i" begin="1" end="${fn:length(comment.imageUrls) - 1}">
                                                <img src="${comment.imageUrls[i]}" alt="Comment Image" width="200px" />
                                                <p><strong>Image Text:</strong> ${comment.imageText[i]}</p>
                                            </c:forEach>
                                        </div>
                                        <button onclick="toggleVisibility('more-images-${comment.commentid}')">See More Images</button>
                                    </div>
                                </c:if>

                                <!-- Display first video and see more option -->
                                <c:if test="${not empty comment.videoUrls}">
                                    <div class="media-section media-videos">
                                        <div class="media-title">Videos:</div>
                                        <video width="320" height="240" controls>
                                            <source src="${comment.videoUrls[0]}" type="video/mp4">
                                        </video>
                                        <p><strong>Video Text:</strong> ${comment.videoText[0]}</p>
                                        <div id="more-videos-${comment.commentid}" style="display: none;">
                                            <c:forEach var="i" begin="1" end="${fn:length(comment.videoUrls) - 1}">
                                                <video width="320" height="240" controls>
                                                    <source src="${comment.videoUrls[i]}" type="video/mp4">
                                                </video>
                                                <p><strong>Video Text:</strong> ${comment.videoText[i]}</p>
                                            </c:forEach>
                                        </div>
                                        <button onclick="toggleVisibility('more-videos-${comment.commentid}')">See More Videos</button>
                                    </div>
                                </c:if>
                                <!-- ... -->
                            </div>
                        </div>
                    </c:forEach>

                    <c:if test="${requestScope.comment.isEmpty()}">
                        <br/><br/><br/>
                        <center><h3 style="color: gray;">Hãy Là Người Bình Luận Đầu Tiên!</h3></center>
                        <br/><br/><br/>
                    </c:if>

                    <!-- Phân trang -->
                    <!-- Phân trang -->
                    <div class="pagination">
                        <c:if test="${currentPage > 1}">
                            <a class="page-link" href="?ProductID=${param.ProductID}&page=${currentPage - 1}">Previous</a>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <c:choose>
                                <c:when test="${i == currentPage}">
                                    <span class="current-page">${i}</span> <!-- Current button -->
                                </c:when>
                                <c:otherwise>
                                    <a class="page-link" href="?ProductID=${param.ProductID}&page=${i}">${i}</a> <!-- Page button -->
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${currentPage < totalPages}">
                            <a class="page-link" href="?ProductID=${param.ProductID}&page=${currentPage + 1}">Next</a>
                        </c:if>
                    </div>


                </div>
            </div>
        </div>                
        <script>
            function toggleVisibility(id) {
                const element = document.getElementById(id);
                if (element.style.display === "none") {
                    element.style.display = "block";
                } else {
                    element.style.display = "none";
                }
            }
            // Hàm chuyển hướng đến trang đăng nhập
            function redirectToLogin() {
                window.location.href = "/WebDienTu/login"; // Thay đổi URL này theo trang đăng nhập của bạn
            }
            let attributeCount = 0; // Khởi tạo attributeCount bên ngoài hàm
            function confirmDelete() {
                console.log('Confirm delete called');
                return confirm('Are you sure you want to delete this attribute?');
            }

            function addVideo() {
                const attributeContainer = document.getElementById('attributeContainer');
                const newRow = document.createElement('div');
                newRow.classList.add('form-row', 'mb-2');
                newRow.innerHTML = `
<div class="form-group col-md-5">
<input type="text" placeholder="Nhập Tên Video" style="font-weight: bold;" name="vidName" class="form-control" required>
</div>
<div class="form-group col-md-5">
<input name="vidImgValue" type="file" accept="video/*, image/*" class="form-control" required>
</div>
<div class="form-group col-md-2">
<button type="button" class="btn btn-danger delete-button">Xóa</button>
</div>
`;
                attributeContainer.appendChild(newRow);
                attributeCount++;

                // Gán sự kiện xóa cho nút "Xóa" mới tạo
                newRow.querySelector('.delete-button').addEventListener('click', function () {
                    newRow.remove();
                });
            }
            function addImage() {
                const attributeContainer = document.getElementById('attributeContainer');
                const newRow = document.createElement('div');
                newRow.classList.add('form-row', 'mb-2');
                newRow.innerHTML = `
<div class="form-group col-md-5">
<input type="text" placeholder="Nhập Tên Ảnh " style="font-weight: bold;" name="ImageName" class="form-control" required>
</div>
<div class="form-group col-md-5">
<input name="vidImageValue" type="file" accept="video/*, image/*" class="form-control" required>
</div>
<div class="form-group col-md-2">
<button type="button" class="btn btn-danger delete-button">Xóa</button>
</div>
`;
                attributeContainer.appendChild(newRow);
                attributeCount++;

                // Gán sự kiện xóa cho nút "Xóa" mới tạo
                newRow.querySelector('.delete-button').addEventListener('click', function () {
                    newRow.remove();
                });
            }
        </script> 
        <!-- Footer start -->

        <!-- Footer end -->
    </body>
    <%@include file="footer.jsp" %>
</html>
