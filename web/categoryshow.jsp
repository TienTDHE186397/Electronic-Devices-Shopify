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
        <title>ALV Cinema</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
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
        </style>
   


</style>
</head>
<body>
    <%@include file="header.jsp" %>

    <!-- Films product start -->

    <!-- Load phim đang chiếu srart -->
    <section id="deal" class="pt-4 bg-light">
        <div class="container-fluid">
            <div class="row deal_1">
                <!-- Phần này để phim mới ra gần nhất start-->
                <div class="col-md-8 col-lg-4">
                    <div class="deal_1l position-relative clearfix">
                        <div class="clearfix deal_1li">
                            <div class="grid clearfix">
                                <figure class="effect-jazz mb-0">
                                    <a href="detail.html"><img src="${p1.image}" height="750" class="w-100" alt="abc"></a>
                                </figure>
                            </div>
                        </div>

                        <div class="clearfix deal_1li1 w-100 h-100 position-absolute">
                            <h6 class="text-uppercase bg_blue ps-3 pe-3 pt-2 pb-2 d-inline-block text-white font_13">New Arrival</h6>
                            <h3 class="text-white">${p1.productName}</h3>
                            <h5 class="mt-3 text-white">Phim Mới Nhất</h5>

                            <h6 class="mt-3"><a href="detail.html" class="button">Mua vé</a></h6>

                        </div>


                    </div>
                </div>
                <!-- Phần này để phim mới ra gần nhất end-->
                <di    v class="col-md-12  col-lg-8">
                    <div class="deal_1r">
                        <div class="deal_1r1 row">
                            <div class="col-md-6">
                                <div class="deal_1r1l">
                                    <h6 class="h_line font_13">Phim Theo Thể Loại</h6>
                                    <h4 class="mb-0">Phim ${getC.categoryName}</h4>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="deal_1r1r text-end">
                                    <h6 class="mb-0"><a class="col_yell" href="detail.html"><i class="fa fa-caret-right"></i> View All</a></h6>
                                </div>
                            </div>
                        </div> 
                        <div class="deal_1r2">
                            <div id="carouselExampleCaptions1" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleCaptions1" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>

                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <!-- Phần fix cứng load sản phẩm phim đang chiếu start -->
                                        <div class="deal_1r2i row">
                                            <c:forEach items="${listd}" var="d">
                                                <div class="col-md-4" style="margin-bottom:30px">
                                                    <div class="deal_1r2im bg-white p-2">
                                                        <div class="deal_1r2im1 text-center">
                                                            <div class="grid clearfix">
                                                                <figure class="effect-jazz mb-0">
                                                                    <a href="detail.html"><img src="${d.image}" class="w-100" alt="abc"></a>
                                                                </figure>
                                                            </div>
                                                            <h6 class="ellipsis mt-3 font_14"style="color: #000; font-size: 1.5em; text-align: left;"><a href="detail.html">${d.productName}</a></h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể loại <span class="me-2 ms-2">:</span>${d.genre}</h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thời lượng <span class="me-2 ms-2">:</span>${d.time}</h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Đạo diễn <span class="me-2 ms-2">:</span>${d.director}</h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Diễn viên <span class="me-2 ms-2">:</span>${d.performer}</h6>
                                                        </div>
                                                       
                                                    </div>
                                                </div>
                                            </c:forEach>

                                        </div>
                                        <!-- Phần fix cứng load sản phẩm phim đang chiếu end-->
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</section>
<!-- Load phim dang chiếu end-->


<!-- Films product END -->

<!-- FOOTER : VIET ANH -->
<!-- BEGIN -->
<%@include file = "footer.jsp"%>
<!-- END -->


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
