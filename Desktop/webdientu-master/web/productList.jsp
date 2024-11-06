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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.6.0/css/fontawesome.min.css" integrity="sha384-NvKbDTEnL+A8F/AA5Tc5kmMLSJHUO868P+lDtTpJIeQdGYaUIuLr4lVGOEA1OcMy" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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

            /*Phan trang*/
            .pagination {
                display: flex;
                justify-content: center;
                align-items: center;
                gap: 10px; /* Tạo khoảng cách đều giữa các button */
                margin-top: 20px; /* Khoảng cách giữa pagination và nội dung phía trên */
            }

            .pagination button {
                padding: 10px 20px;
                background-color: #007bff; /* Màu nền xanh */
                color: white; /* Màu chữ */
                border: none; /* Bỏ viền */
                border-radius: 5px; /* Góc bo tròn */
                cursor: pointer; /* Thay đổi con trỏ khi hover */
                font-size: 16px;
                transition: background-color 0.3s ease; /* Hiệu ứng mượt khi hover */
            }

            .pagination button:hover {
                background-color: #0056b3; /* Màu nền khi hover */
            }

            .pagination button:focus {
                outline: none; /* Bỏ khung viền mặc định khi button được focus */
                box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.5); /* Hiệu ứng khi focus */
            }

            .pagination button:disabled {
                background-color: #ccc; /* Màu nền khi button bị disable */
                cursor: not-allowed; /* Thay đổi con trỏ khi button bị disable */
            }

            button.active {
                background-color: #4CAF50;
                color: white;
            }

        </style>

    </head>


    <body>

        <c:set value="${requestScope.listCategory}" var="cate" />


        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <a href="mktdashboard"><h1 class="brand-name"> MKT DashBoard</h1></a>
            </div>
        </section>

        <section class="product-list container">


            <div>

                <div  style="margin-top: 15px">
                    <div class="row">
                        <div class="col-12 mb-3 mb-lg-"> 
                            <form id="f1" action="ProductMKT" method="get">
                                <div>
                                    <center>
                                        <div style="margin-bottom: 5px">
                                            <h1>PRODUCT LIST</h1>                                  
                                            <span style="background-color: #eeecfd; padding:5px;">TOTAL Product: <b>${requestScope.listP.size()}</b></span>
                                        </div>
                                    </center>
                                    <br/>
                                    <br/>
                                    <span style="margin: 2px;" >        
                                        <!-- search -->
                                        <label for="filter"><b>Search:</b></label>
                                        <input name="search" type="text" class="form-control" placeholder="Name,Brand,Tittle........" value="${param.search == null ? "":param.search}">
                                        <div class="row" >
                                            <!-- from price -->
                                            <div class="col-md-6">
                                                <label for="filter"><b>From Price:</b></label>
                                                <input name="fromprice" type="number" class="form-control" placeholder="From Price" value="${param.fromprice == null ? "":param.fromprice}">
                                            </div>
                                            <!-- to price -->
                                            <div class="col-md-6">
                                                <label for="filter"><b>To Price:</b></label>
                                                <input name="toprice" type="number" class="form-control" placeholder="To Price" value="${param.toprice == null ? "":param.toprice}">
                                            </div>  
                                        </div>

                                        <label for="filter"><b>Short Description:</b></label>
                                        <input name="shortdescription" type="text" class="form-control" placeholder="Short Description" value="${param.shortdescription == null ? "":param.shortdescription}">
                                    </span>
                                    <div>
                                        <div class="row ">
                                            <b>Filter:</b>
                                            <div class="col-md-6" >
                                                <select name="category" id="customSelect" onchange="document.getElementById('f1').submit()">
                                                    <option value="0">All</option>
                                                    <c:forEach var="c" begin="0" end="${cate.size() -1}" step ="1">
                                                        <option value="${cate.get(c).categoryID}" ${(cate.get(c).categoryID == param.category) ? "selected" : ""} >${cate.get(c).getCategoryName()}</option>
                                                    </c:forEach>
                                                </select>
                                                <select id="customSelect" name="status" onchange="document.getElementById('f1').submit()">
                                                    <option class="col-auto mobile" value="Available" ${(param.status == "Available") ? "selected" : ""}>Available</option>
                                                    <option class="col-auto mobile" value="Sold Out" ${(param.status == "Sold Out") ? "selected" : ""}>Sold Out</option>
                                                    <option class="col-auto mobile" value="Hided" ${(param.status == "Hided") ? "selected" : ""}>Hided</option>
                                                </select>

                                                <select id="customSelect" name="sort" onchange="document.getElementById('f1').submit()">
                                                    <option value="0">Sort</option>
                                                    <option value="1" ${(param.sort == "1") ? "selected" : ""}>Tittle (A-Z)</option>
                                                    <option value="2" ${(param.sort == "2") ? "selected" : ""}>Tittle (Z-A)</option>
                                                    <option value="3" ${(param.sort == "3") ? "selected" : ""}>Category (A - Z)</option>
                                                    <option value="4" ${(param.sort == "4") ? "selected" : ""}>Category (Z - A)</option>
                                                    <option value="5" ${(param.sort == "5") ? "selected" : ""}>Posted Price Up</option>
                                                    <option value="6" ${(param.sort == "6") ? "selected" : ""}>Posted Price Down</option>
                                                    <option value="7" ${(param.sort == "7") ? "selected" : ""}>Selling Price Up</option>
                                                    <option value="8" ${(param.sort == "8") ? "selected" : ""}>Selling Price Down</option>
                                                </select>
                                            </div>   
                                            <div class="col-md-6" style="text-align: right;" ><a href="addProductMKT" style="border: 3px solid black; padding: 2px;" >ADD NEW PRODUCT <i class="fa-solid fa-circle-plus"></i></a></div>
                                        </div>
                                    </div>  
                                </div>
                                <input type="submit" hidden>
                            </form>

                            <div class="table-responsive">  
                                <table class="table mb-0"> <!-- comment -->
                                    <thead class="text-uppercase bg-body text-muted">
                                        <tr>
                                            <th>ProductID</th>
                                            <th>Image</th>
                                            <th>Product Name</th>
                                            <th>Category Name</th>
                                            <th>Posted Price</th>
                                            <th>Selling Price</th>
                                            <th>Views</th>
                                            <th>Sale</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listP}" var="p">
                                            <tr class="align-content-between">
                                                <td>${p.productID}</td>
                                                <td>

                                                    <img src="${p.img}" class="img-radius" alt="${p.productName}" width="80px" height="80px">

                                                </td>
                                                <td>${p.productName}</td>
                                                <td>${p.category.categoryName}</td>
                                                <td>${p.price}đ</td>
                                                <td>${p.price - ((p.sale)*(p.price))/100}đ</td>
                                                <td>${p.views}</td>
                                                <td>${p.sale}%</td>
                                                <td>${p.status}</td>
                                                <td>
                                                    <a href="ProductDetail?ID=${p.getProductID()}"><i class="fa-solid fa-pen"></i></a>
                                                    &nbsp; 
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                            </div>

                            <div class="pagination">
                                <c:if test="${totalpage > 1}">
                                    <c:forEach var="c" begin="1" end="${totalpage}" step ="1">
                                        <button type="submit" name="page" onclick="goToPage(${c})">${c}</button>
                                    </c:forEach>
                                </c:if>
                            </div>


                            <form id="paginationForm" action="ProductMKT" method="get">
                                <input type="hidden" name="search" value="${param.search}">
                                <input type="hidden" name="fromprice" value="${param.fromprice}">
                                <input type="hidden" name="toprice" value="${param.toprice}">
                                <input type="hidden" name="shortdescription" value="${param.shortdescription}">
                                <input type="hidden" name="category" value="${param.category}">
                                <input type="hidden" name="status" value="${param.status}">
                                <input type="hidden" name="sort" value="${param.sort}">
                                <input type="hidden" name="page" id="pageInput" value="1">
                            </form>

                        </div>
                    </div>
                </div>
            </div>


        </section>


        <script>

            function goToPage(pageNumber) {

                document.getElementById('pageInput').value = pageNumber;

                document.getElementById('paginationForm').submit();

            }


        </script>



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
