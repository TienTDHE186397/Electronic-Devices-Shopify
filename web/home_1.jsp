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
    <!-- Header start -->
    <%@include file="header.jsp" %>

    <!-- Header end -->

    <!-- Films product start -->
    <!-- Phần banner lớn start-->
    <section id="center" class="center_home">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2" class="" aria-current="true"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${p1.imageBanner}" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-md-block">
                        <h1 class="text-white fw-normal font_50 text-uppercase" ><span class="highlight-yellow">PHIM MỚI NHẤT</span> <br> <span class="fw-bold">${p1.productName}</span></h1>
                        <p class="fs-6 mt-4">Xem ngay để nhận <span class="col_yell fw-bold">ưu đãi</span> tốt nhất!</p>
                        <h6 class="text-uppercase mt-4 mb-0"><a class="button" href="productdetail?pid=${p1.productId}&checkid=${p1.status}">Mua Vé</a></h6>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${p2.imageBanner}" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-md-block">
                        <h1 class="text-white fw-normal font_50 text-uppercase"><span class="highlight-yellow">PHIM MỚI NHẤT</span><br> <span class="fw-bold">${p2.productName}</span></h1>
                        <p class="fs-6 mt-4">Xem ngay để nhận <span class="col_yell fw-bold">ưu đãi</span> tốt nhất!</p>
                        <h6 class="text-uppercase mt-4 mb-0"><a class="button" href="productdetail?pid=${p2.productId}&checkid=${p2.status}">Mua Vé</a></h6>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${p3.imageBanner}" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-md-block">
                        <h1 class="text-white fw-normal font_50 text-uppercase"><span class="highlight-yellow">PHIM MỚI NHẤT</span><br> <span class="fw-bold">${p3.productName}</span></h1>
                        <p class="fs-6 mt-4">Xem ngay để nhận <span class="col_yell fw-bold">ưu đãi</span> tốt nhất!</p>
                        <h6 class="text-uppercase mt-4 mb-0"><a class="button" href="productdetail?pid=${p3.productId}&checkid=${p3.status}">Mua Vé</a></h6>
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
            <h1 class="brand-name">TNreal</h1>
        </div>
    </section>
    <!-- Load phim sắp chiếu start-->
    <section id="prod" class="pt-4 pb-4">
        <div class="container-xl">
            <div class="row prod_1 mb-4 text-center">
                <div class="col-md-12">
                    <h6 class="h_line font_13">New Release</h6>
                    <h4 class="" id="sapchieu">Phim Sắp Chiếu</h4>
                </div>
            </div>
            <div class="row prod_2 text-center">
                <!-- Đang fix cứng 8 phim lặp lại -->
                <c:forEach items="${listP}" var="o">  
                    <div class="toggle-container col-md-3" style="margin-top: 30px">
                        <div class="prod_2im position-relative clearfix">
                            <div class="prod_2i1 clearfix">
                                <div class="grid clearfix">
                                    <figure class="effect-jazz mb-0">
                                        <a href="productdetail?pid=${o.productId}&checkid=${o.status}"><img src="${o.image}" class="w-100" alt="abc"></a>
                                    </figure>
                                </div>
                            </div>
                            <div class="prod_2i2 pb-2 clearfix" style="margin-left: 15px; margin-right: 15px">
                                <h6 class="mt-3 ellipsis" style="color: #000; font-size: 1.5em; text-align: left;">
                                    <a href="productdetail?pid=${o.productId}&checkid=${o.status}" class="ellipsis">${o.productName}</a>
                                </h6>
                                <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể Loại<span class="me-2 ms-2">:</span>${o.genre}</h6>
                                <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thời lượng<span class="me-2 ms-2">:</span>${o.time}</h6>
                                <h6 class="fw-normal mb-0" style="text-align: left; margin-top: 5px">Giá vé<span class="me-2 ms-2">:</span>     <span class="fw-bold col_yell"> ${o.price}vnd</span></h6>
                                <a href="productdetail?pid=${o.productId}&checkid=${o.status}" class="btn btn-primary mt-2 custom-button" style="font-size: 1em; padding: 10px 20px; width: 100%;">Mua Vé</a>


                            </div>

                            <div class="prod_2i3 clearfix position-absolute">
                                <h6 class="bg_yell d-inline-block pt-1 pb-1 font_13 text-white ps-3 pe-3">NEW</h6>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>
    </section>
    <!-- Load phim sắp chiếu end -->

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
                                    <a href="detail.html"><img src="img/14.jpg" height="750" class="w-100" alt="abc"></a>
                                </figure>
                            </div>
                        </div>

                        <div class="clearfix deal_1li1 w-100 h-100 position-absolute">
                            <h6 class="text-uppercase bg_blue ps-3 pe-3 pt-2 pb-2 d-inline-block text-white font_13">New Arrival</h6>
                            <h3 class="text-white">${p1.productName}</h3>
                            <h5 class="mt-3 text-white">Phim Mới Nhất</h5>

                            <h6 class="mt-3"><a href="productdetail?pid=${p1.productId}&checkid=${p1.status}" class="button">Mua vé</a></h6>

                        </div>


                    </div>
                </div>
                <!-- Phần này để phim mới ra gần nhất end-->
                <di    v class="col-md-12  col-lg-8">
                    <div class="deal_1r">
                        <div class="deal_1r1 row">
                            <div class="col-md-6">
                                <div class="deal_1r1l">
                                    <h6 class="h_line font_13" >Currently Showing</h6>
                                    <h4 class="mb-0" id="dangchieu">Phim Đang Chiếu</h4>
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
                                                <div class="col-md-4">
                                                    <div class="deal_1r2im bg-white p-2">
                                                        <div class="deal_1r2im1 text-center">
                                                            <div class="grid clearfix">
                                                                <figure class="effect-jazz mb-0">
                                                                    <a href="productdetail?pid=${d.productId}&checkid=${d.status}"><img src="${d.image}" class="w-100" alt="abc"></a>
                                                                </figure>
                                                            </div>
                                                            <h6 class="ellipsis mt-3 font_14"style="color: #000; font-size: 1.5em; text-align: left;"><a href="productdetail?pid=${d.productId}&checkid=${d.status}">${d.productName}</a></h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể Loại <span class="me-2 ms-2">:</span>${d.genre}</h6>
                                                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thời lượng <span class="me-2 ms-2">:</span>${d.time}</h6>
                                                        </div>
                                                        <div class="deal_1r2im2">
                                         
                                                            <h6 class="mt-3 text-center col_light"><span class="col_yell"></span>Đang Chiếu</h6>

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

<!-- Load Suat Chieu Dac Biet start -->
<section id="prod_o" class="pt-4 pb-4">
    <div class="container-xl">
        <div class="row prod_1 mb-4 text-center">
            <div class="col-md-12">
                <h6 class="h_line font_13">EXCLUSIVE COLLECTION</h6>
                <h2 class="mb-0 col_yell mt-3" id="dacbiet">Bộ Sưu Tập Biệt</h2>
            </div>
        </div>
        <div class="row prod_o1  text-center">
            <div class="col-md-12">
                <ul class="nav nav-tabs bg-light mb-0 border-0 justify-content-center">
                    <li class="nav-item">
                        <a href="#home" data-bs-toggle="tab" aria-expanded="false" class="nav-link active">
                            <span class="d-md-block">Xem Nhiều Nhất</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="#product" data-bs-toggle="tab" aria-expanded="false" class="nav-link">
                            <span class="d-md-block">Sắp ra mắt</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="prod_o2 row mt-4">
            <div class="tab-content">
                <!-- Phần sản phẩm xem nhiều start -->
                <div class="tab-pane active" id="home">

                    <div class="prod_o2i row">
                        <!-- Phần fix cứng load sản phẩm xem nhiều start -->
                        <c:forEach items="${listmv}" var="mv">    
                            <div class="col-md-3">
                                <div class="prod_2im position-relative clearfix">
                                    <div class="prod_2i1 clearfix">
                                        <div class="grid clearfix">
                                            <figure class="effect-jazz mb-0">
                                                <a href="productdetail?pid=${mv.productId}&checkid=${mv.status}"><img src="${mv.image}" class="w-100" alt="abc"></a>
                                            </figure>
                                        </div>
                                    </div>
                                    <div class="prod_2i2 pt-4 pb-4 ps-3 pe-3  clearfix">
                                        <h6 class="ellipsis"><a href="productdetail?pid=${mv.productId}&checkid=${mv.status}" style="color: #000; font-size: 1.5em; text-align: left;">${mv.productName}</a></h6>
                                        <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể Loại <span class="me-2 ms-2">:</span>${mv.genre}</h6>
                                        <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thời lượng <span class="me-2 ms-2">:</span>${mv.time}</h6>
                                        <h6 class="fw-normal mb-0" style="text-align: left; margin-top: 5px">Giá vé<span class="me-2 ms-2">:</span>     <span class="fw-bold col_yell"> ${mv.price}vnd</span></h6>
                                        <hr>

                                        <a href="productdetail?pid=${mv.productId}&checkid=${mv.status}" class="btn btn-primary mt-2 custom-button" style="font-size: 1em; padding: 10px 20px; width: 100%;">Mua Vé</a>

                                    </div>  

                                </div>
                            </div>
                        </c:forEach>
                        <!-- Phần fix cứng load sản phẩm xem nhiều End -->
                    </div>

                </div>
                <!-- Phần sản phẩm xem nhiều end -->


                <div class="tab-pane" id="product">
                    <!-- Phần fix cứng load sắp ra mắt start -->
                    <div class="prod_o2i row">
                        <c:forEach items="${listcs}" var="cs">
                            <div class="col-md-3">   
                                <div class="prod_2im position-relative clearfix">
                                    <div class="prod_2i1 clearfix">
                                        <div class="grid clearfix">
                                            <figure class="effect-jazz mb-0">
                                                <a href="productdetail?pid=${cs.productId}&checkid=${cs.status}"><img src="${cs.image}" class="w-100" alt="abc"></a>
                                            </figure>
                                        </div>
                                    </div>
                                    <div class="prod_2i2 pt-4 pb-4 ps-3 pe-3  clearfix">
                                        <h6 class="commingsoon" style="color: #000; font-size: 1.5em; text-align: left;"><a href="productdetail?pid=${cs.productId}&checkid=${cs.status}">${cs.productName}</a></h6>
                                        <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể loại <span class="me-2 ms-2">:</span>${cs.genre}</h6>
                                        <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thời lượng <span class="me-2 ms-2">:</span>${cs.time}</h6>
                                        <h6 class="fw-normal font_14 mt-2 mb-0" style="text-align: left;">
                                            Ngày khởi chiếu <span class="me-2 ms-2">:</span><strong>${cs.releaseDate}</strong>
                                        </h6>
                                        <hr>
                                        <h6 class="mt-3 text-center col_light"><span class="col_yell"></span>Sắp Ra Mắt</h6>


                                    </div> 
                                    <div class="prod_2i3 clearfix position-absolute w-100">
                                        <h6 class="bg_yell d-inline-block pt-1 pb-1 font_13 text-white ps-3 pe-3">COMMING SOON</h6>

                                    </div>
                                </div>
                            </div>
                        </c:forEach> 
                    </div>
                    <!-- Phần fix cứng load sắp ra mắt End --> 
                </div>
            </div>
        </div>
        <!-- Chỗ này cũng để phim mới nhất start -->
        <div class="arrive row mt-4 me-0 ms-0">
            <div class="arrive_m text-center col-md-12">
                <h6 class="text-uppercase bg_blue ps-3 pe-3 pt-2 pb-2 d-inline-block text-white font_13">New Arrival</h6>
                <h1 class="text-uppercase mt-3 text-white"><span class="fw-normal">CẬP NHẬT MỚI NHẤT</span> <br> ${p1.productName}</h1>

                <h6 class="text-uppercase mt-4 mb-0"><a class="button" href="productdetail?pid=${p1.productId}&checkid=${p1.status}">Mua Vé</a></h6>
            </div>
        </div>
        <!-- Chỗ này cũng để phim mới nhất end -->
    </div>
</section>
<!-- Load Suat Chieu Dac Biet end -->

<!-- Load Phim Đã Chiếu start -->
<section id="blog_h" class="pt-4 pb-4 bg-light">
    <div class="container-xl">
        <div class="row prod_1 mb-4 text-center">
            <div class="col-md-12">
                <h6 class="h_line font_13">SEE LATER</h6>
                <h2 class="mb-0 col_yell mt-3" id="dachieu">Phim Chiếu</h2>
            </div>
        </div>
        <hr>
        
        <div class="row blog_h1">
            <!-- Phần fix cứng load phim đã chiếu start --> 
            <c:forEach items="${listpdc}" var="pdc">
                <div class="col-md-4">

                    <div class="blog_h1i">
                        <div class="grid clearfix">
                            <figure class="effect-jazz mb-0">
                                <a href="productdetail?pid=${pdc.productId}&checkid=${pdc.status}"><img src="${pdc.image}" class="w-100" alt="abc"></a>
                            </figure>
                        </div>
                        <div class="blog_h1i1 bg-white pt-4 pb-4 ps-3 pe-3">
                            <h6 class="font_14 col_light"><i class="fa fa-calendar col_yell me-1"></i> ${pdc.releaseDate}</h6>
                            <h4 class="mt-3"><a href="productdetail?pid=${pdc.productId}&checkid=${pdc.status}">${pdc.productName}</a></h4>
                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Thể Loại <span class="me-2 ms-2">:</span>${pdc.genre}</h6>
                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Đạo Diễn <span class="me-2 ms-2">:</span>${pdc.director}</h6>
                            <h6 class="fw-normal font_14 mt-2 mb-0"style="text-align: left;">Diễn Viên<span class="me-2 ms-2">:</span>${pdc.performer}</h6>
                            <hr>
                            <p id="description">${pdc.description}</p>
                            <h6 class="mb-0"><a class="button_1" href="productdetail?pid=${pdc.productId}&checkid=${pdc.status}">Read More</a></h6>
                        </div>
                    </div>

                </div>
            </c:forEach>
            <!-- Phần fix cứng load phim đã chiếu end --> 
        </div>
    </div>
</section>
<!-- Load Phim Đã Chiếu end -->
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
