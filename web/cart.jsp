<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>Giỏ hàng</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            th, td {
                text-align: left;
                padding: 10px;
            }
            th {
                background-color: #3399ff;
                color: white;
            }

            .sider{
                background-color: #ffffff;
                width: 100%;
                height: 100vh;
                margin-top: 50px;
                border-top: 1px solid black;
                border-left: 1px solid black;

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

            #subs {
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
                margin-top: 70px;

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

            .search-item{
                margin: 20px 20px;
            }

            .drop-shadow {
                filter: drop-shadow(0.3em 0.3em 0.1em #555);
            }

            .category-box{
                margin: 20px 20px;
            }

            table {
                border-spacing: 0;
                width: 100%;
                border: 1px solid black;
            }

            td {
                border: 1px solid black;
                padding: 8px;
                text-align: center;
            }

            .latest-product{
                margin: 20px 20px;
            }

            .card-product{
                display: flex;
                overflow: hidden;
                border: 1px solid black;
                margin: 10px 0px;
            }

            .card-product img{
                width: 50px;
                height: 50px;
                object-fit: contain;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <section id="subs" class="pt-5 pb-5 bg_light_1">
                <div class="container text-center">
                    <h1 class="brand-name">Shopify</h1>
                </div>
            </section>
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-9" style="margin-bottom: 20px">
                            <h3><strong>Giỏ Hàng</strong></h3>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Hình Ảnh</th>
                                        <th>Đơn giá</th>
                                        <th>Số Lượng</th>
                                        <th style="width: 170px">Cập Nhật Số Lượng</th>
                                        <th>Tổng</th>                                         
                                        <th style="text-align: center">Xóa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cart.items}" var="item">
                                    <tr>
                                        <td>${item.getProduct().getProductName()}</td>
                                        <td><img style="width: 69px; height: 100px" src="${item.getProduct().getImg()}" alt="Product Image"></td>
                                        <td style="color: red"><b><fmt:formatNumber value="${item.getPrice()}" type="currency" /></b></td>                                    
                                <form action="update" method="get">
                                    <td>
                                        <input type="hidden" name="ProductID" value="${item.getProduct().getProductID()}">
                                        <input style="width: 50px" type="number" name="quantity" value="${item.getQuantity()}" min="1">
                                    </td>
                                    <td><button type="submit" class="btn btn-primary">Cập Nhật</button></td>
                                </form>
                               <td style="color: red"><b><fmt:formatNumber value="${item.getPrice() * item.getQuantity()}" type="currency" /></b></td>

                                <td style="text-align: center">
                                    <a href="delete?ProductID=${item.getProduct().getProductID()}" class="btn btn-danger">Xóa</a>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <div style="display: flex;justify-content: space-between">
                            <a href="delete?ProductID=${item.getProduct().getProductID()}" class="btn btn-primary">Lưu</a>
                            <a href="cartcontact" class="btn btn-dark">Đặt hàng</a>
                            <c:set var="total" value="0" />
                            <c:forEach items="${cart.items}" var="item">
                                <c:set var="total" value="${total + (item.price * item.quantity)}" />
                            </c:forEach>
                            <div style="color: red; font-size: 20px;"><b>Tổng cộng: <fmt:formatNumber value="${total}" type="currency" /></b></div>
                        </div>  

                    </div>
                    <div class="col-lg-3">
                        <div class="sider drop-shadow">
                            <div class="search-item">
                                <form action="product-list" method="get">
                                    <label><b>Tìm kiếm sản phẩm:</b></label>
                                    <input style="border-radius: 5px;width: 250px" id ="myInput" name="search_product" type="text" placeholder="Nhập thông tin sản phẩm cần tìm..." class="form-input" value="${param.search_product}">
                                </form>
                            </div>

                            <div class="category-box">
                                <h3>Phân Loại</h3>
                                <table border="1" width="100">
                                    <tbody>
                                        <c:forEach items="${listCategory}" var="listC">
                                            <tr>
                                                <td><a href="product-list?category=${listC.getCategoryID()}">${listC.getCategoryName()}</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>                                    
                                </table>
                            </div>

                            <div class="latest-product">
                                <h3>Sản phẩm mới</h3>
                                <c:forEach items="${listProductLatest}" var="listPL">

                                    <a style="border: none" href="product-detail?ProductID=${listPL.getProductID()}">
                                        <div class="card-product">
                                            <img src="${listPL.getImg()}" alt="...">
                                            <div>
                                                <div>${listPL.getProductName()}</div>
                                                <div style="font-size: 10px;font-style: italic">Ngày cập nhật: ${listPL.getReleaseDate()}</div>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </div>    
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>