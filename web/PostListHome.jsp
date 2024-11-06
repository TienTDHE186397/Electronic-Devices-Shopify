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
                background-color: transparent;
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


            .blog-title {
                display: inline-block;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                max-width: 150px;
                vertical-align: middle;
            }

        </style>

    </head>


    <body>

        <c:set value="${requestScope.listCategory}" var="cate" />
        <c:set value="${requestScope.listRB}" var="RB"/>

        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <%@include file="header.jsp" %>
        </section>
        <section class="product-list container">
            <c:set value="${requestScope.listBlogType}" var="listType"/>
            <c:set value="${requestScope.totalP}" var="totalpage"/>
            <div>
                <div  style="margin-top: 15px">
                    <div class="row">
                        <div class="col-12 mb-3 mb-lg-"> 

                            <div class="row">
                                <form action="PostListHome" method="get">
                                    <div class="search col-md-5">
                                        <i style="margin-right: 10px;" class="fa-solid fa-magnifying-glass"></i><input name="search" style="width: 350px; height: 30px; display: inline-block; border: 1px #fff solid" id="myInput" type="text" class="form-control" placeholder=" Tìm Kiếm..." value="${(param.search == null) ? "" : param.search}">
                                    </div>
                                    <br/>
                                    <div class="col-md-7">
                                        <b>Number Per Page:</b>  <input type="number" name="numberofpage" value="${nof}" placeholder="Number of page ...."> <br/>
                                        <b>Hide:  </b>

                                        <input type="checkbox" name="col" value="image" ${(image != null) ? "checked" : ""}> Image
                                        <input type="checkbox" name="col" value="information" ${(information != null) ? "checked" : ""}> Information 
                                        <br/>
                                        <br/>
                                        <input type="submit" value="Apply">
                                    </div>

                                </form>
                                   <input type="hidden" name="page" value="${param.page}">

                            </div>


                            <section class="product-list container">
                                <div class="row">
                                    <div class="col-md-9">
                                        <br/>
                                        <c:if test="${search == null || search.isBlank()}">
                                            <h5 style="text-decoration: underline;">Newest Blog</h5>
                                        </c:if>
                                        <c:if test="${!search.isBlank() && search != null}">
                                            <h5> Bạn Đang Tìm Kiếm : ${param.search} </h5>
                                        </c:if>
                                        <div class="table-responsive">  
                                            <table class="table mb-0"> 
                                                <tbody>
                                                    <c:forEach items="${requestScope.listBp}" var="blog">
                                                        <tr>
                                                            <c:if test="${image == null}">
                                                                <td> 
                                                                    <a href="PostDetailHome?id=${blog.blogID}">
                                                                        <img src="${blog.blog_img}" class="img-radius" alt="${b.blog_tittle}" width="100px" height="100px">
                                                                    </a>
                                                                </td>
                                                            </c:if>
                                                            <c:if test="${information == null}">

                                                                <c:if test="${blog.blog_flag == 0}">
                                                                    <td>
                                                                        <a href="PostDetailHome?id=${blog.blogID}">
                                                                            <b>${blog.blog_tittle}</b><br/>
                                                                            <p >${blog.blog_summary_information}</p>
                                                                            ${blog.person.name} <i class="fa-solid fa-calendar-days"></i> ${blog.blog_update_time}
                                                                        </a>
                                                                    </td>
                                                                </c:if>
                                                                <c:if test="${blog.blog_flag == 1}">
                                                                    <td> 
                                                                        <a href="PostDetailHome?id=${blog.blogID}">
                                                                            <b style="color: red;">${blog.blog_tittle}</b>
                                                                            <p>${blog.blog_summary_information}</p>
                                                                            ${blog.person.name} <i class="fa-solid fa-calendar-days"></i> ${blog.blog_update_time}
                                                                        </a>
                                                                    </td>
                                                                </c:if>

                                                            </c:if>

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

                                        <form id="paginationForm" action="PostListHome" method="get">
                                            <input type="hidden" name="search" value="${param.search}">
                                            <input type="hidden" name="numberofpage" value="${param.numberofpage}">

                                            <c:if test="${image != null}">
                                                <input type="hidden" name="col" value="${image}">
                                            </c:if>
                                            <c:if test="${information != null}">
                                                <input type="hidden" name="col" value="${information}">
                                            </c:if>

                                            <input type="hidden" name="page" id="pageInput" value="1">
                                            
                                        </form>


                                    </div>

                                    <div class="col-md-3"
                                         <div class="related-post">
                                        <h5 style="text-decoration: underline;">TOP 5 Most View</h5>

                                        <ul>
                                            <c:forEach var="c" begin="0" end="4" step ="1">
                                                <a href="PostDetailHome?id=${RB.get(c).blogID}">  
                                                    <div class="related-post">
                                                        <img src="${RB.get(c).blog_img}" width="80px" height="80px" alt="Related Post Image">
                                                        <b class="blog-title">${RB.get(c).blog_tittle}</b>
                                                    </div>
                                                    <br/>
                                                </a>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                        </div>
                        </section>
                        <br/> 
                        <c:if test="${search != null}">
                            </form>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>


    </section>

    <!-- Footer start -->
    <%@include file="footer.jsp" %>
    <!-- Footer end -->
</body>


<script>

    function goToPage(pageNumber) {

        document.getElementById('pageInput').value = pageNumber;

        document.getElementById('paginationForm').submit();

    }

</script>

</html>
