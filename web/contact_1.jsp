<%-- 
    Document   : contact
    Created on : Jun 30, 2024, 9:34:13 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="css/contact.css" rel="stylesheet">
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
                        <h1>CONTACT US</h1>
                        <h6 class="d-inline-block  font_14 col_yell bg-white"><a class="col_light" href="#">Home</a> <span class="me-2 ms-2">/</span> Contact Us</h6>
                    </div>
                </div>
            </div>
        </section>

        <section id="contact" class="pt-4 pb-4 bg_light_1">
            <div class="container-xl">
                <div class="row contact_1 ">
                    <div class="col-md-4">
                        <div class="contact_1i text-center  bg-white">
                            <span class="bg_yell text-white fs-2 span_1"><i class="fa fa-map-marker"></i></span>
                            <h5 class="mt-3">Our Location</h5>
                            <p class="mb-0 mt-3">X892 YTower Stat, Suite 36 Knockland,<br>  DB 6228 United Kingdom</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="contact_1i text-center  bg-white">
                            <span class="bg_yell text-white fs-2 span_1"><i class="fa fa-envelope"></i></span>
                            <h5 class="mt-3">Our Email</h5>
                            <p class="mb-0 mt-3"><span class="fw-bold">Email Us:</span> info@gmail.Com<br>  info@gmail.Com</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="contact_1i text-center  bg-white">
                            <span class="bg_yell text-white fs-2 span_1"><i class="fa fa-phone"></i></span>
                            <h5 class="mt-3">Phone Number</h5>
                            <p class="mb-0 mt-3"><span class="fw-bold">Contacr Numbers:</span> +123 123 456<br>  +123 123 456</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="contact_o" class="pt-4 pb-4">
            <div class="container-xl">
                <div class="row prod_1 mb-4 text-center">
                    <div class="col-md-12">
                        <h6 class="h_line font_13">LET’S TALK</h6>
                        <h2 class="col_yell mt-3">SEND US A MASSAGE</h2>
                        <p class="mb-0">We are always happy to talk with you. Be sure to write to us if you have any <br> questions or need help and support.</p>
                    </div>
                </div>
                <div class="row contact_o1">
                    <div class="col-md-6">
                        <div class="contact_o1l">
                            <div class="contact_o1li row">
                                <div class="col-md-6">
                                    <div class="contact_o1lil">
                                        <div class="input-group p-2 bg_light">
                                            <input type="text" class="form-control border-0 bg-transparent" placeholder="First Name*">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary bg-transparent border-0 fs-6" type="button">
                                                    <i class="fa fa-user col_light"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="contact_o1lil">
                                        <div class="input-group p-2 bg_light">
                                            <input type="text" class="form-control border-0 bg-transparent" placeholder="Last Name*">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary bg-transparent border-0 fs-6" type="button">
                                                    <i class="fa fa-user col_light"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="contact_o1li row mt-3">
                                <div class="col-md-6">
                                    <div class="contact_o1lil">
                                        <div class="input-group p-2 bg_light">
                                            <input type="text" class="form-control border-0 bg-transparent" placeholder="Your Email*">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary bg-transparent border-0 fs-6" type="button">
                                                    <i class="fa fa-envelope col_light"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="contact_o1lil">
                                        <div class="input-group p-2 bg_light">
                                            <input type="text" class="form-control border-0 bg-transparent" placeholder="Phone*">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary bg-transparent border-0 fs-6" type="button">
                                                    <i class="fa fa-phone col_light"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="contact_o1li row mt-3">
                                <div class="col-md-12">
                                    <div class="contact_o1lil">
                                        <textarea placeholder="Enter Your Message" class="form-control bg_light border-0 form_area"></textarea>
                                        <h6 class="mb-0 mt-4"><a class="button" href="#">SUBMIT</a></h6>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="contact_o1r">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d114964.53925916665!2d-80.29949920266738!3d25.782390733064336!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x88d9b0a20ec8c111%3A0xff96f271ddad4f65!2sMiami%2C+FL%2C+USA!5e0!3m2!1sen!2sin!4v1530774403788" height="380" style="border:0; width:100%;" allowfullscreen=""></iframe>
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

