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


    <c:set value="${requestScope.listP}" var="p" />
    <body>

        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">MKT DashBoard</h1>
            </div>
        </section>

        <section class="product-list container">




            <div  style="margin-top: 15px">
                <div class="row">
                    <div class="col-12 mb-3 mb-lg-"> 
                        <div>
                            <div style="margin-bottom: 5px">
                                <h1>Product List</h1>
                                <span style="background-color: #eeecfd; padding:5px;">TOTAL Product: <b>${requestScope.listP.size()}</b></span>
                            </div>

                            <form id="f1" action="filterServlet">
                                <div>


                              
                                    <c:set value="${requestScope.listCategory}" var="cate" />
                                    <div class="row ">
                                        <select name="category" id="customSelect" onchange="document.getElementById('f1').submit()">
                                            <option value="0">All</option>
                                            <c:forEach var="c" begin="0" end="${cate.size() -1}" step ="1">
                                                <option value="${cate.get(c).getCategoryName()}" ${(cate.get(c).getCategoryName() == param.category) ? "selected" : ""} >${cate.get(c).getCategoryName()}</option>
                                            </c:forEach>

                                        </select>

                                        <select id="customSelect">
                                            <option class="col-auto mobile">a</option>
                                            <option class="col-auto mobile">a</option>
                                            <option class="col-auto mobile">a</option>

                                        </select>


                                        <select id="customSelect">
                                            <option class="col-auto mobile">a</option>
                                            <option class="col-auto mobile">a</option>
                                            <option class="col-auto mobile">a</option>

                                        </select>

                                    </div>    
                                </div>
              </form>

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

                                        <c:forEach items="${requestScope.listPhone}" var="phone">
                                            <tr class="align-content-between">
                                                <td>${phone.product.productID}</td>
                                                <td> 
                                                    <img src="${phone.img}" class="card-img-top" alt="iPhone 15 128GB"> </td>
                                                <td>${phone.product.views}</td>
                                                <td>${phone.product.releaseDate}</td>
                                                <td>${phone.product.quantitySold}</td>
                                                <td>${phone.product.category.getCategoryName()}</td>
                                                <td>${phone.product.quantity}</td>
                                                <td>${phone.price}.00 VND</td>
                                                <td>${phone.price - (phone.price*phone.product.sale /100)}VND</td>
                                                <td>${phone.product.sale} %</td>
                                                <c:if test="${phone.product.quantitySold > 0}">
                                                    <td>Available</th>
                                                    </c:if>

                                                    <c:if test="${phone.product.quantitySold <= 0}">
                                                    <td>Sold Out</th>
                                                    </c:if>


                                            </tr>

                                        </c:forEach>
                                        <c:forEach items="${requestScope.listLaptop}" var="lap">
                                            <tr class="align-content-between">
                                                <td>${lap.product.productID}</td>
                                                <td> 

                                                    <img src="${lap.img}" class="card-img-top" alt="iPhone 15 128GB"> </td>

                                                <td>${lap.product.views}</td>

                                                <td>${lap.product.releaseDate}</td>
                                                <td>${lap.product.quantitySold}</td>
                                                <td>${lap.product.category.getCategoryName()}</td>
                                                <td>${lap.product.quantity}</td>
                                                <td>${lap.price}.00 VND</td>
                                                <td>${lap.price - (lap.price*(lap.product.sale /100))}VND</td>
                                                <td>${lap.product.sale} %</td>
                                            
                                                  <c:if test="${lap.product.quantitySold > 0}">
                                                    <td>Available</th>
                                                    </c:if>

                                                    <c:if test="${lap.product.quantitySold <= 0}">
                                                    <td>Sold Out</th>
                                                    </c:if>
                                            
                                            </tr>
                                        </c:forEach>
                                        <c:forEach items="${requestScope.listPc}" var="pc">
                                            <tr class="align-content-between">
                                                <td>${pc.product.productID}</td>
                                                <td> 

                                                    <img src="${pc.pcImage}" class="card-img-top" alt="iPhone 15 128GB"> </td>

                                                <td>${pc.product.views}</td>

                                                <td>${pc.product.releaseDate}</td>
                                                <td>${pc.product.quantitySold}</td>
                                                <td>${pc.product.category.getCategoryName()}</td>
                                                <td>${pc.product.quantity}</td>
                                                <td>${pc.pcPrice}.00 VND</td>
                                                <td>${pc.pcPrice - (pc.pcPrice*pc.product.sale /100)}VND</td>
                                                <td>${pc.product.sale} %</td>
                                                
                                                  <c:if test="${pc.product.quantitySold > 0}">
                                                    <td>Available</th>
                                                    </c:if>

                                                    <c:if test="${pc.product.quantitySold <= 0}">
                                                    <td>Sold Out</th>
                                                    </c:if>
                                            </tr>

                                        </c:forEach>

                                        <c:forEach items="${requestScope.listMonitor}" var="mo">
                                            <tr class="align-content-between">
                                                <td>${mo.product.productID}</td>
                                                <td> 

                                                    <img src="${mo.monitorImage}" class="card-img-top" alt="iPhone 15 128GB"> </td>

                                                <td>${mo.product.views}</td>

                                                <td>${mo.product.releaseDate}</td>
                                                <td>${mo.product.quantitySold}</td>
                                                <td>${mo.product.category.getCategoryName()}</td>
                                                <td>${mo.product.quantity}</td>
                                                <td>${mo.monitorPrice}.00 VND</td>
                                                <td>${mo.monitorPrice - (mo.monitorPrice*mo.product.sale /100)}VND</td>
                                                <td>${mo.product.sale} %</td>
                                                
                                                  <c:if test="${mo.product.quantitySold > 0}">
                                                    <td>Available</th>
                                                    </c:if>

                                                    <c:if test="${mo.product.quantitySold <= 0}">
                                                    <td>Sold Out</th>
                                                    </c:if>
                                            </tr>

                                        </c:forEach>


                                        <c:forEach items="${requestScope.listHeadPhone}" var="head">
                                            <tr class="align-content-between">
                                                <td>${head.product.productID}</td>
                                                <td> 

                                                    <img src="${head.img}" class="card-img-top" alt="iPhone 15 128GB"> </td>

                                                <td>${head.product.views}</td>

                                                <td>${head.product.releaseDate}</td>
                                                <td>${head.product.quantitySold}</td>
                                                <td>${head.product.category.getCategoryName()}</td>
                                                <td>${head.product.quantity}</td>
                                                <td>${head.price}.00 VND</td>
                                                <td>${head.price - (head.price*head.product.sale /100)}VND</td>
                                                <td>${head.product.sale} %</td>
                                                
                                                  <c:if test="${head.product.quantitySold > 0}">
                                                    <td>Available</th>
                                                    </c:if>

                                                    <c:if test="${head.product.quantitySold <= 0}">
                                                    <td>Sold Out</th>
                                                    </c:if>
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
