<%-- 
    Document   : about
    Created on : Jun 30, 2024, 9:22:59 PM
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
        <title>Cancer Cinema</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <link href="css/global.css" rel="stylesheet">
        <link href="css/about.css" rel="stylesheet">
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
    </head>
    <body>


        <%@include file="header.jsp" %>

        <section id="center" class="center_o pt-4 pb-4 bg-light">
            <div class="container-xl">
                <div class="row center_o1 text-center">
                    <div class="col-md-12">
                        <h1>GIỚI THIỆU</h1>
                        <h6 class="d-inline-block  font_14 col_yell bg-white"><a class="col_light" href="#">Home</a> <span class="me-2 ms-2">/</span> About Us</h6>
                    </div>
                </div>
            </div>
        </section>

        <section id="about_pg" class="pt-4 pb-4">
            <div class="container-xl">
                <div class="about_pg_1 row">
                    <div class="col-md-6">
                        <div class="about_pg_1l">
                            <div class="grid clearfix">
                                <figure class="effect-jazz mb-0">
                                    <a href="#"><img src="img/about/about.jpg" class="w-100" alt="abc"></a>
                                </figure>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="about_pg_1r">
                            <h3>LỊCH SỬ HÌNH THÀNH</h3>
                            <p class="mt-3">Khởi Đầu (2005)

                                ALV Cinema được thành lập vào năm 2005 bởi ông Nguyễn Văn An tại TP.HCM, Việt Nam, với mục tiêu mang đến trải nghiệm xem phim hiện đại cho khán giả.</p>
                            <p class="mt-3">Phát Triển Ban Đầu (2005-2010)

                                Ban đầu, ALV chỉ có một rạp chiếu nhỏ với ba phòng chiếu. Nhờ vào sự đầu tư vào công nghệ chiếu phim tiên tiến, ALV nhanh chóng thu hút sự chú ý của công chúng.</p>
                            <p class="mt-3">Mở Rộng và Nâng Cấp (2010-2015)

                                Từ năm 2010, ALV mở rộng hệ thống rạp chiếu phim và nâng cấp công nghệ như hệ thống âm thanh Dolby Atmos và màn hình chiếu 3D, giúp nâng cao trải nghiệm xem phim.</p>
                            <h5 class="col_yell mt-4">SỨ MỆNH CỦA CHÚNG TÔI</h5>
                            <hr>
                            <div class="about_pg_1ri row mt-4">
                                <div class="col-md-4 col-4">
                                    <div class="about_pg_1ri1">
                                        <span class="col_light fs-1 float-start me-3 span_1"><i class="fa fa-file-archive-o"></i></span>
                                        <h3 class="mb-0">328+ <br> <span class="font_14 col_light span_2">Projects</span></h3>
                                    </div>
                                </div>
                                <div class="col-md-4 col-4">
                                    <div class="about_pg_1ri1">
                                        <span class="col_light fs-1 float-start me-3 span_1"><i class="fa fa-money"></i></span>
                                        <h3 class="mb-0">$4M <br> <span class="font_14 col_light span_2">Revenue</span></h3>
                                    </div>
                                </div>
                                <div class="col-md-4 col-4">
                                    <div class="about_pg_1ri1">
                                        <span class="col_light fs-1 float-start me-3 span_1"><i class="fa fa-trophy"></i></span>
                                        <h3 class="mb-0">368+ <br> <span class="font_14 col_light span_2">Awards</span></h3>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="spec" class="pt-4 pb-4 bg-light">
            <div class="container-xl">
                <div class="row prod_1 mb-4 text-center">
                    <div class="col-md-12">
                        <h6 class="h_line font_13">TẠI SAO NÊN LỰA CHỌN CHÚNG TÔI</h6>
                        <h2 class="mb-0 col_yell mt-3">KINH NGHIỆM HÀNG ĐẦU TRONG LĨNH VỰC</h2>
                    </div>
                </div>
                <div class="row spec_1 mt-4">
                    <div class="col-md-4">
                        <div class="spec_1i bg-white p-4 pt-2">
                            <span class="col_yell font_50"><i class="fa fa-rocket"></i></span>
                            <h5 class="mt-3">Thao tác thuận tiện</h5>
                            <p class="mt-3">Lorem Ipsum simply dumm the printing and typesetting indust orem Ipsum has been the industry standard dummy men book.</p>
                            <p class="mb-2">Smart UHD TV</p>
                            <p class="mb-0">Snow Frost in Freezer</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="spec_1i bg-white p-4 pt-2">
                            <span class="col_yell font_50"><i class="fa fa-credit-card"></i></span>
                            <h5 class="mt-3">Thanh toán an toàn</h5>
                            <p class="mt-3">Lorem Ipsum simply dumm the printing and typesetting indust orem Ipsum has been the industry standard dummy men book.</p>
                            <p class="mb-2">24/7 Support</p>
                            <p class="mb-0">Money back in 15 days</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="spec_1i bg-white p-4 pt-2">
                            <span class="col_yell font_50"><i class="fa fa-phone"></i></span>
                            <h5 class="mt-3">Hỗ trợ khách hàng 24/7</h5>
                            <p class="mt-3">Lorem Ipsum simply dumm the printing and typesetting indust orem Ipsum has been the industry standard dummy men book.</p>
                            <p class="mb-2">Smart UHD TV</p>
                            <p class="mb-0">Snow Frost in Freezer</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="testim" class="pt-4 pb-5">
            <div class="container-xl">
                <div class="row prod_1 mb-4 text-center">
                    <div class="col-md-12">
                        <h6 class="h_line font_13">SLOGAN</h6>
                        <h2 class="mb-0 col_yell mt-3">SỰ HÀI LÒNG CỦA KHÁCH HÀNG LÀ TRÊN HẾT</h2>
                    </div>
                </div>
                <div class="row testim_1">
                    <div id="carouselExampleCaptions1" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleCaptions1" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions1" data-bs-slide-to="1" aria-label="Slide 2" class="" aria-current="true"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active carousel-item">
                                <div class="testim_1i row">
                                    <div class="col-md-4">
                                        <div class="testim_1i1 text-center bg-light p-4">
                                            <img src="img/43.jpg" class="rounded-circle" alt="abc">
                                            <h6 class="mt-3">Eget Nulla</h6>
                                            <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                            <span class="font_13 col_yell">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </span>
                                            <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="testim_1i1 text-center bg-light p-4">
                                            <img src="img/44.jpg" class="rounded-circle" alt="abc">
                                            <h6 class="mt-3">Quis Sem</h6>
                                            <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                            <span class="font_13 col_yell">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </span>
                                            <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="testim_1i1 text-center bg-light p-4">
                                            <img src="img/45.jpg" class="rounded-circle" alt="abc">
                                            <h6 class="mt-3">Dapibis Diam</h6>
                                            <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                            <span class="font_13 col_yell">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </span>
                                            <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item carousel-item">
                                <div class="testim_1i row">
                                    <div class="testim_1i row">
                                        <div class="col-md-4">
                                            <div class="testim_1i1 text-center bg-light p-4">
                                                <img src="img/43.jpg" class="rounded-circle" alt="abc">
                                                <h6 class="mt-3">Eget Nulla</h6>
                                                <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                                <span class="font_13 col_yell">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="testim_1i1 text-center bg-light p-4">
                                                <img src="img/44.jpg" class="rounded-circle" alt="abc">
                                                <h6 class="mt-3">Quis Sem</h6>
                                                <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                                <span class="font_13 col_yell">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="testim_1i1 text-center bg-light p-4">
                                                <img src="img/45.jpg" class="rounded-circle" alt="abc">
                                                <h6 class="mt-3">Dapibis Diam</h6>
                                                <h6 class="font_13 col_light mb-3">CEO of Company</h6>
                                                <span class="font_13 col_yell">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span>
                                                <p class="mt-3 mb-0">“ In promotion and advertising, a testimonial show consists of a person's written spoken statement extolling the virtue of a product ”</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
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
