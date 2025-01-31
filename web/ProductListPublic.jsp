<%-- 
    Document   : ProductListPublic
    Created on : Oct 8, 2024, 5:55:43 AM
    Author     : Dokkuhai
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Sản Phẩm</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <script src="js/bootstrap.bundle.min.js"></script>
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.cdnfonts.com/css/roboto" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            h5{
                font-family: 'Roboto', sans-serif;
            }
            h1{
                font-family: 'Roboto', sans-serif;
            }
            body{
                font-family: 'Roboto', sans-serif;
                background-color: #faf2e8;
                overflow-x: scroll;
            }
            .bg_light_1 {
                background-color: transparent; /* Làm nền trong suốt để hiển thị gradient phía sau */
            }

            #subs {
                margin-top: 70px;
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
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

            .hot-product-banner{
                border: 1px solid whitesmoke;
                padding: 20px;

                background-color: #f8405e;
                border-radius: 20px;
                margin-top: 70px;
                margin-bottom: 50px;
                background-image: linear-gradient(#f8405e,#F95A74);
                font-size: 16px;
            }

            .title{
                display: flex;
                color: #fff;
                font-weight: 500;
                justify-content: center;
                font-style: 100px;

            }

            .title .title-icon{
                color: #fff;
                font-size: 46px;
                margin-right: 10px;
                justify-items: center;
            }

            .title-list{
                border-bottom: 1px solid #979494;
            }


            .background-container{
                border: 1px solid whitesmoke;
                padding: 0px 30px;
                height: 100%;
                width: 100%;
                background-color: #d9d9d9;
                border-radius: 20px;
                margin: 20px;
                display: flex;
                flex-direction: column;
            }



            /* --------------------------------------------------------- */
            .card {
                border: 1px solid #ddd;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                transition: transform 0.2s;
                margin: 20px;
                flex: 1 1 calc(25% - 40px); /* Adjust size to fit container */
                max-width: calc(25% - 40px); /* Ensure max width */
                height: 100%;
                box-sizing: border-box;
                overflow: auto;
            }

            .card:hover {
                transform: scale(1.05);
            }

           

            .card-body {
                padding: 15px;
            }

            .card-title {
                font-size: 20px;
                font-weight: bold;
                margin-bottom: 10px;
            }

            .card-text {
                font-size: 16px;
                color: #555;
                margin-bottom: 15px;
            }

            .btn-primary {
                background-color: #007bff;
                border: none;
                padding: 5px 10px;
                border-radius: 5px;

                text-transform: uppercase;
            }

            .btn .btn-primary{
                font-size: 16px;
            }

            .btn-primary:hover {
                background-color: #0056b3;
            }

            .product-card {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                width: auto;
                height: auto;
            }
            .category-table{
                background-color: #f7f7f9;
                margin: 15px 0px;
                padding: 15px;
                border-radius: 15px;
                display: flex;
                justify-items: left;

            }

            .dropdown{
                margin: 0px 10px;
            }

            .pagination{
                justify-content: center;
            }

            .filter-table{
                margin: 0px 15px;
            }

            .pagination-button{
                margin: 0px 5px;
                padding: 10px;
                border: solid 1px #d9d9d9;
                border-radius: 5px;
                
            }

            .form-input{
                background: #d9d9d9;
                border: solid 1px #d9d9d9;
                border-radius: 5px;
                width: 50%;
            }
            
            .filter-col{
                border-radius: 5px;
                text-align: center;
                
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
            
            .pagination-container{
                display: flex;
                justify-content: center;
                max-width: 100%; /* Giới hạn chiều rộng theo kích thước của phần tử cha */
                max-height: 100%;
                overflow-x: scroll;

            }
            
            .buy-option{
                display: flex;
                justify-content: space-between;
            }
            
            .p-image{
                display: flex;
                justify-content: center;
                height: auto;
                
            }
            
            .p-image img{
                max-width: 60%;
                height: auto;
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
        <!-------------------------------- comment ------------------------------>          

        <section> 
            <div class="container hot-product-banner">
                <div class="title">
                    <i class='bx bxs-hot title-icon'></i>
                    <h1>HOT SALE MÙA TỰU TRƯỜNG</h1>
                </div>
                <div class="product-card">

                    <c:forEach items="${hot_product}" var="hotproduct">
                        <div class="card" style="height: 250px; flex: 1 1 calc(20% - 20px); max-width: calc(20% - 20px);">
                            <span class="discount-badge">Giảm ${hotproduct.getSale()}%</span>
                            <a href="product-detail?ProductID=${hotproduct.getProductID()}">
                            <div class="p-image">
                                <img src="${hotproduct.getImg()}" class="card-img-top" alt="Hot Product Image" style="height: 100px;object-fit: contain">
                            </div>
                            </a>
                            <div class="card-body" style="padding: 10px;">
                                <div class="card-title" style="font-size: 12px; margin-bottom: 5px; ">${hotproduct.getProductName()}</div>
                                <div style="color: #F95A74">Thương hiệu: ${hotproduct.getBrand()}</div>
                                <div class="price">Giá ưu đãi: <fmt:formatNumber value="${hotproduct.price * (1 - hotproduct.sale / 100)}" pattern="#,###" />đ </div>
                                <div class="original-price">Giá gốc: <fmt:formatNumber value="${hotproduct.price}" pattern="#,###" />đ</div>
                                <div class="buy-option">                              
                                    <c:choose>
                                        <c:when test="${empty sessionScope.user}">
                                            <a href="#" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>Thêm vào giỏ hàng</a>
                                            <a href="javascript:history.back()" class=""></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="cart?ProductID=${hotproduct.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 10px"><i class="fa fa-cart-plus" aria-hidden="true"></i>Thêm vào giỏ hàng</a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>

                        </div>
                    </c:forEach>
                </div>
            </div>               
        </section>
        <!-------------------------------- comment ------------------------------>        
        <section id="product-list-container">
            <div class="title-list container">
                <h1 style="font-family: 'Roboto';">TẤT CẢ SẢN PHẨM</h1>
            </div>
            <form action="product-list" id="form1" method="get">
                <div class="container category-table">

                    <div class="filter-table">
                        <label><b>Phân loại:</b></label>
                        <select class="filter-col" name="category" id="categoryselect" onchange="document.getElementById('form1').submit()">
                            <option value="0">All</option>
                            <c:forEach var="c" items="${listCategory}">
                                <option value="${c.getCategoryID()}" ${c.getCategoryID() == param.category ? "selected":""} >${c.getCategoryName()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="filter-table">
                        <label><b>Sắp xếp theo:</b></label>
                        <select class="filter-col" name="sort" id="categoryselect" onchange="document.getElementById('form1').submit()">
                            <option value="releaseDate DESC" ${"releaseDate DESC" == param.sort ? "selected":""}>Mới cập nhật</option>
                            <option value="ProductName" ${"ProductName" == param.sort ? "selected":""}>Tên(A-Z)</option>
                             <option value="ProductName DESC" ${"ProductName DESC" == param.sort ? "selected":""} >Tên(Z-A)</option>
                            <option value="price DESC" ${"price DESC" == param.sort ? "selected":""}>Giá(Cao - Thấp)</option>
                            <option value="price" ${"price" == param.sort ? "selected":""}>Giá(Thấp - Cao)</option>
                        </select>
                    </div>
                    <div class="filter-table">
                        <label><b>Số lượng xem:</b></label>
                        <select class="filter-col" name="numberOfProducts" id="categoryselect" onchange="document.getElementById('form1').submit()">
                            <c:if test="${param.numberOfProducts == null}">
                                    <option value="4" ${"selected"}>4(default)</option>
                            </c:if>
                            <c:forEach var="count" begin="3" end="12">
                                <option value="${count}" ${count == param.numberOfProducts ? "selected":""}>${count}</option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="filter-table">
                        <label><b>Tìm kiếm sản phẩm:</b></label>
                        <input style="border-radius: 5px;width: 250px" id ="myInput" name="search_product" type="text" placeholder="Nhập thông tin sản phẩm cần tìm..." class="form-input" value="${param.search_product}">
                    </div> 
            </div>
            
            <div class="container background-container">
                
                <div class="container background-container">
                    <div class="product-card">
                        <c:forEach items="${list_P}" var="list1">
                            <div class="card">
                                <span class="discount-badge">Giảm ${list1.getSale()}%</span>
                                <a href="product-detail?ProductID=${list1.getProductID()}">
                                <div class="p-image">
                                    <img src="${list1.getImg()}" class="card-img-top" alt="Product Image">
                                </div>
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title">${list1.getProductName()}</h5>
                                    <div style="color: #000;">Thương hiệu: <b>${list1.getBrand()}</b></div>
                                    <div style="color: #000;">Số lượng còn: <b>${list1.getQuantity()}</b></div>
                                    <div style="font-style: italic">Trả góp 0% qua thẻ tín dụng</div>
                                    <p class="price">Giá ưu đãi: <fmt:formatNumber value="${list1.price * (1 - list1.sale / 100)}" pattern="#,###" />đ  <span class="original-price"><fmt:formatNumber value="${list1.price}" pattern="#,###" />đ</span></p>
                                    <div class="buy-option">
                                    <c:choose>
                                        <c:when test="${empty sessionScope.user}">
                                            <a href="cart?ProductID=${list1.getProductID()}" onclick="alert('Bạn cần đăng nhập để mua hàng')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 11px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                            <a href="javascript:history.back()" class=""></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="cart?ProductID=${list1.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ</a>
                                        </c:otherwise>
                                    </c:choose>
                                    </div>        
                                </div>  
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="pagination-container" aria-label="Page navigation">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${endP}" var="o">
                            <button class="pagination-button" type="submit" name="page" value="${o}" ${o == param.page ? "selected":""} }>${o}</button>
                        </c:forEach>
                    </ul>
                </div>
            </form>
        </section>
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>

 
</html>
