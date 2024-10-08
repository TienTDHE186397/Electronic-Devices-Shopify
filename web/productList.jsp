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
        <title>MKT DashBoard</title>
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


            #customSelect {
                background-color: black;
                border: 1px solid #555;
                color: white;
                padding: 5px 10px;
                border-radius: 20px;
                font-family: 'Arial', sans-serif;
                font-size: 14px;
                text-align: center;
                width: 150px;
                height: 30px;
                margin-left: 10px;
                display: inline-block;
            }

            #customSelect option {
                background-color: white;
                color: black;
                padding: 10px;
                font-family: 'Arial', sans-serif;
            }

        </style>

    </head>


    <body>

        <c:set value="${requestScope.listCategory}" var="cate" />


        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">MKT DashBoard</h1>
            </div>
        </section>

        <section class="product-list container">


            <div>

                <div  style="margin-top: 15px">
                    <div class="row">
                        <div class="col-12 mb-3 mb-lg-"> 
                            <div>
                                <div style="margin-bottom: 5px">
                                    <h1>Product List</h1>
                                    <a href="#">Add new product </a>

                                    <span style="background-color: #eeecfd; padding:5px;">TOTAL Product: <b>${requestScope.listP.size()}</b></span>

                                </div>

                                <br/>
                                <br/>

                                <span style="margin: 2px;" >        
                                    <!-- search -->
                                    <label for="filter"><b>Search:</b></label>
                                    <input name="search" type="text" class="form-control" placeholder="Name,Brand,Model" value="${param.search == null ? "":param.search}">
                                    <div class="row" >
                                        <!-- from price -->
                                        <div class="col-md-6">
                                            <label for="filter"><b>Post Price:</b></label>
                                            <input name="postedprice" type="number" class="form-control" placeholder="Posted Price" value="${param.postedprice == null ? "":param.postedprice}">
                                        </div>
                                        <!-- to price -->
                                        <div class="col-md-6">
                                            <label for="filter"><b>Selling Price:</b></label>
                                            <input name="sellingprice" type="number" class="form-control" placeholder="Selling Price" value="${param.sellingprice == null ? "":param.sellingprice}">
                                        </div>  

                                    </div>
                                    <label for="filter"><b>Short Description:</b></label>
                                    <input name="postedprice" type="text" class="form-control" placeholder="Short Description" value="${param.postedprice == null ? "":param.postedprice}">

                                </span>

                                <div>
                                    <b>Search:</b>

                                    <div class="row ">
                                        <select name="category" id="customSelect" onchange="document.getElementById('f1').submit()">
                                            <option value="0">All</option>
                                            <c:forEach var="c" begin="0" end="${cate.size() -1}" step ="1">
                                                <option value="${cate.get(c).getCategoryName()}" ${(cate.get(c).getCategoryName() == param.category) ? "selected" : ""} >${cate.get(c).getCategoryName()}</option>
                                            </c:forEach>
                                        </select>
                                        <select id="customSelect" name="status">
                                            <option class="col-auto mobile">Available</option>
                                            <option class="col-auto mobile">Sold Out</option>
                                            <option class="col-auto mobile">Maintaince</option>
                                        </select>
                                    </div>    
                                </div> 
                            </div>




                            <div class="table-responsive">  
                                <table class="table mb-0"> <!-- comment -->
                                    <thead class="text-uppercase bg-body text-muted">
                                        <tr>
                                            <th>ProductID</th>
                                            <th>Image</th>
                                            <th>Views</th>
                                            <th>Release Date</th>
                                            <th>Quantity Sold</th>
                                            <th>CategoryID</th>
                                            <th>Quantity</th>
                                            <th>Posted Price</th>
                                            <th>Selling Price</th>
                                            <th>Sale</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listP}" var="p">
                                            <tr class="align-content-between">
                                                <td>${p.productID}</td>
                                                <td>

                                                    <img src="${p.img}" class="img-radius" alt="${p.productName}" width="80px" height="80px">

                                                </td>
                                                <td>${p.views}</td>
                                                <td>${p.releaseDate}</td>
                                                <td>${p.quantitySold}</td>
                                                <td>${p.category.categoryName}</td>
                                                <td>${p.quantity}</td>
                                                <td>${p.price}</td>
                                                <td>${p.price - ((p.sale)*(p.price))/100}</td>
                                                <td>${p.sale}</td>
                                                <td>${p.status}</td>

                                            </tr>
                                        </c:forEach>



                                    </tbody>

                                </table>
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


<script>


</script>

</html>
