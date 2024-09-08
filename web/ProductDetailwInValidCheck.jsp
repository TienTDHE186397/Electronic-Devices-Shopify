<%-- 
    Document   : ProductDetail
    Created on : Jul 4, 2024, 3:40:45 PM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Eco Mart</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/global.css" rel="stylesheet">
        <link href="css/detail.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <script src="js/bootstrap.bundle.min.js"></script>
        <style>
            body {
                font-family: 'Times New Roman', Times, serif;
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
            .commingsoon{
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

        </style>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <section id="center" class="center_o pt-4 pb-4 bg-light">
            <div class="container-xl">
                <div class="row center_o1 text-center">
                    <div class="col-md-12">
                        <h1>PRODUCT DETAIL</h1>
                        <h6 class="d-inline-block bg-white font_14 col_yell"><a class="col_light" href="#">Home</a> <span class="me-2 ms-2">/</span> Thông Tin Phim </h6>
                    </div>
                </div>
            </div>
        </section>

        <section id="detail" class="pt-4 pb-4" style="margin-bottom: 50px">
            <c:forEach items="${listp}" var="p">
                <div class="container-xl">
                    <div class="row detail_1">
                        <div class="col-md-6">
                            <div class="detail_1l">
                                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">


                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <img src="${p.image}" class="d-block w-100" alt="abc">

                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">

                            <div class="detail_1r">
                                <h6 class="d-inline-block bg_yell text-white font_12 ps-3 pe-3 pt-2 pb-2 rounded-1">Mua Vé</h6>
                                <h4 class="mt-2">${p.productName}</h4>
                                <h6 class="font_14 mt-3">  


                                </h6>
                                <h4 class="mt-3"><span class="col_yell me-3">${p.price} VND</span></h4>
                                <p>Mô tả: ${p.description}</p>
                                <h6><span class="me-2">Thể Loại :</span> <a class="font_14 col_light me-1">${p.genre}</a>
                                    <h6><span class="me-2">Thời lượng :</span> <a class="font_14 col_light me-1">${p.time}</a>
                                        <h6><span class="me-2">Diễn Viên :</span> <a class="font_14 col_light me-1" >${p.performer}</a>
                                            <h6><span class="me-2">Đạo Diễn :</span> <a class="font_14 col_light me-1">${p.director}</a>
                                                <ul class="mb-0 mt-3 mb-3">
                                                    <li class="d-inline-block me-1" style="color: red">Độ Tuổi: ${p.age}</li>

                                                </ul>
                                                
                                                <h6 class="text-uppercase mt-4"><a class="button" href="home">Bạn Chỉ Có Thể Mua Vé Ở Phần Phim Sắp Chiếu</a></h6>

                                                <hr>
                                                <h6 class="font_13 col_light">TAG : <a class="col_light" href="#">${p.director}</a></h6>
                                                <h6 class="font_13 col_light mt-3 mb-0">CATEGORIES : <a class="col_light" href="#">${p.genre}</a></h6>
                                                </div>

                                                </div>
                                                </div>




                                                </div>
                                            </c:forEach>
                                            </section>

                                            <%@include file = "footer.jsp"%>

                                            <script>
                                                window.onscroll = function () {
                                                    myFunction()
                                                };

                                                var navbar_sticky = document.getElementById("navbar_sticky");
                                                var sticky = navbar_sticky.offsetTop;
                                                var navbar_height = document.querySelector('.navbar').offsetHeight;

                                                function myFunction() {
                                                    if (window.pageYOffset >= sticky + navbar_height) {
                                                        navbar_sticky.classList.add("sticky")
                                                        document.body.style.paddingTop = navbar_height + 'px';
                                                    } else {
                                                        navbar_sticky.classList.remove("sticky");
                                                        document.body.style.paddingTop = '0'
                                                    }
                                                }
                                            </script>

                                            </body>

                                            </html>
