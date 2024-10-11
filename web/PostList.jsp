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

            <c:set value="${requestScope.listBlogType}" var="listType"/>
            <c:set value="${requestScope.totalP}" var="totalpage"/>


            <div>

                <div  style="margin-top: 15px">
                    <div class="row">
                        <div class="col-12 mb-3 mb-lg-"> 

                            <form id="f1" action="PostListMKT" method="get">

                                <div>
                                    <div style="margin-bottom: 5px">
                                        <center>   <h1>POST LIST</h1> <center>

                                                <span style="background-color: #eeecfd; padding:5px;">TOTAL POST: <b>${requestScope.listB.size()}</b></span>

                                                </div>

                                                <br/>

                                                <span style="margin: 2px;" >        
                                                    <!-- search -->
                                                    <div class="row" >
                                                        <div class="col-md-6">
                                                            <label><b>Tittle:</b></label>
                                                            <input style="background: orange;" id ="myInput" name="tittlewrite" type="text" class="form-control" placeholder="Enter your Tittle" value="${param.tittlewrite == null ? "":param.tittlewrite}">
                                                        </div>
                                                        <div class="col-md-6">
                                                            <label><b>Author:</b></label>
                                                            <input style="background: orange;" id ="myInput" name="authorwrite" type="text" class="form-control" placeholder="Enter your Author" value="${param.authorwrite == null ? "":param.authorwrite}">
                                                        </div>  

                                                    </div>

                                                </span>
                                                <div class="row">


                                                    <div class="col-md-6">
                                                        <div>
                                                            <b>Filter :</b>
                                                            <div>
                                                                <select name="type" id="customSelect" onchange="document.getElementById('f1').submit()">
                                                                    <option value="">All</option>
                                                                    <c:forEach var="c" begin="0" end="${listType.size() -1}" step ="1">
                                                                        <option value="${listType.get(c)}" ${(listType.get(c) == param.type) ? "selected" : ""} >${listType.get(c)}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <select id="customSelect" name="statusf" onchange="document.getElementById('f1').submit()">
                                                                    <option value="">Status</option>
                                                                    <option value="published" ${(param.statusf == "published")? "selected" : ""}>Published</option>
                                                                    <option value="hide" ${(param.statusf == "hided")? "selected" : ""} >Hided</option>
                                                                </select>
                                                            </div>  




                                                        </div> 

                                                        <div>
                                                            <b>Sort By :</b>                                                                              
                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <b>Event :</b>

                                                            <div>
                                                                <select id="customSelect" name="sort" onchange="document.getElementById('f1').submit()">
                                                                    <option value="" class="col-auto mobile">List Default</option>
                                                                    <option value="tittleu" ${(param.sort == "tittleu")? "selected" : ""} class="col-auto mobile">Tittle(A - Z)</option>
                                                                    <option value="tittled" ${(param.sort == "tittled")? "selected" : ""} class="col-auto mobile">Tittle(Z - A)</option>

                                                                    <option value="typeu" ${(param.sort == "typeu")? "selected" : ""} class="col-auto mobile">Type(A - Z)</option>
                                                                    <option value="typed" ${(param.sort == "typed")? "selected" : ""}  class="col-auto mobile">Type(Z - A)</option>

                                                                    <option value="authoru" ${(param.sort == "authoru")? "selected" : ""} class="col-auto mobile">Author(A - Z)</option>
                                                                    <option value="authord" ${(param.sort == "authord")? "selected" : ""} class="col-auto mobile">Author(Z - A)</option>

                                                                    <option value="viewsu" ${(param.sort == "viewsu")? "selected" : ""} class="col-auto mobile">Views(Increase)</option>
                                                                    <option value="viewsd" ${(param.sort == "viewsd")? "selected" : ""} class="col-auto mobile">Views(Decrease)</option>

                                                                </select>


                                                                <select style="width: 293px;" id="customSelect" name="event" onchange="document.getElementById('f1').submit()">
                                                                    <option value="" class="col-auto mobile">Event</option>
                                                                    <option value="phunu" ${(param.event == "phunu")? "selected" : ""} class="col-auto mobile">Ngày Quốc tế Phụ nữ</option>
                                                                    <option value="quockhanh" ${(param.event == "quockhanh")? "selected" : ""} class="col-auto mobile">Ngày Quốc Khánh 2-9</option>
                                                                    <option value="giangsinh" ${(param.event == "giangsinh")? "selected" : ""} class="col-auto mobile">Lễ Giáng Sinh</option>
                                                                    <option value="namgioi" ${(param.event == "namgioi")? "selected" : ""} class="col-auto mobile">Ngày Quốc Tế Nam Giới 19-11</option>
                                                                    <option value="thieunhi" ${(param.event == "thieunhi")? "selected" : ""} class="col-auto mobile">Ngày Quốc tế Thiếu nhi 1-6</option>
                                                                </select>

                                                            </div> 
                                                        </div> 
                                                    </div>

                                                    <div class="col-md-6">
                                                        <button style="float: right; position: relative;"><a href="addPost">ADD NEW POST <i class="fa-solid fa-circle-plus"> </i></a></button>
                                                    </div>


                                                </div>

                                                </div>


                                                <div class="table-responsive">  
                                                    <table class="table mb-0"> <!-- comment -->
                                                        <thead class="text-uppercase bg-body text-muted">
                                                            <tr>
                                                                <th>PostID</th>
                                                                <th>Blog Image</th>
                                                                <th>Blog Tittle</th>
                                                                <th>Blog Type</th>
                                                                <th>Author</th>
                                                                <th>Update Time</th>
                                                                <th>Views</th>
                                                                <th>Status</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>

                                                            <c:forEach items="${requestScope.listBp}" var="blog">
                                                                <tr>
                                                                    <td>${blog.blogID}</td>
                                                                    <td>
                                                                        <img src="${blog.blog_img}" class="img-radius" alt="${b.blog_tittle}" width="100px" height="100px">
                                                                    </td>
                                                                    <c:if test="${blog.blog_flag == 0}">
                                                                        <td><b>${blog.blog_tittle}</b></td>
                                                                    </c:if>
                                                                    <c:if test="${blog.blog_flag == 1}">
                                                                        <td style="color: red;"><b>${blog.blog_tittle}</b></td>
                                                                            </c:if>
                                                                    <td>${blog.blog_type}</td>
                                                                    <td>${blog.person.name}</td>
                                                                    <td>${blog.blog_update_time}</td>
                                                                    <td>${blog.blog_views}</td>
                                                                    <td>${blog.blog_status}</td>
                                                                    <td><a href="PostDetail?id=${blog.blogID}"><i class="fa-regular fa-eye"></i></a>
                                                                        &nbsp;
                                                                        <a href="editPost?id=${blog.blogID}"><i class="fa-solid fa-pen"></i></a>
                                                                        &nbsp; 
                                                                        <c:if test="${blog.blog_flag == 0}">
                                                                            <a href="flagServlet?id=${blog.blogID}"><i class="fa-regular fa-flag"></i></a>
                                                                            </c:if>
                                                                            <c:if test="${blog.blog_flag == 1}">
                                                                            <a href="flagServlet?id=${blog.blogID}"><i class="fa-solid fa-flag"></i></a>
                                                                            </c:if>
                                                                    </td>
                                                                </tr>

                                                            </c:forEach>

                                                        </tbody>

                                                    </table>
                                                </div>
                                                <br/> 


                                                <div class="pagination">
                                                    <c:forEach var="c" begin="1" end="${totalpage}" step ="1">
                                                        <button type="submit" name="page" value="${c}" }>${c}</button>
                                                    </c:forEach>

                                                </div>

                                                </form>


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

                                                </script>

                                                </html>
