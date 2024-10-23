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
            <c:set value="${requestScope.listS}" var="listS"/>


            <div>

                <div  style="margin-top: 15px">
                    <div class="row">
                        <div class="col-12 mb-3 mb-lg-"> 
                            <div>

                                <div style="margin-bottom: 5px">
                                    <center>   <h1>SLIDER LIST</h1> <center>
                                            <span style="background-color: #eeecfd; padding:5px;">TOTAL SLIDER: <b>${list.size()}</b></span>
                                            </div>
                                            <br/>

                                            <div class="search-filter">
                                                <form action="SliderListMKT" method="get" id="f1">     
                                                    <span style="margin: 2px;" >      
                                                        <div>
                                                            <div>
                                                                <center>
                                                                    <label><b>Search:</b></label>
                                                                    <input style="width: 450px;border-radius: 15px; background: orange;" id ="myInput" name="search" type="text" class="form-control" placeholder="Enter your Tittle Or Backlink .........." value="${search}">
                                                                </center> 
                                                            </div>
                                                        </div>
                                                    </span>
                                                    <div>
                                                        <div>
                                                            <div>
                                                                <center>
                                                                    <b>Filter :</b>
                                                                    <div>
                                                                        <select name="status" id="customSelect" onchange="document.getElementById('f1').submit()">
                                                                            <option value="">All</option>
                                                                            <option value="Published" ${(param.status == "Published") ? "selected" : ""}>Published</option>
                                                                            <option value="Hided"  ${(param.status == "Hided") ? "selected" : ""}>Hided</option>
                                                                        </select>
                                                                    </div>
                                                                </center>
                                                                <a href="addSlider" style=" padding: 5px;border: 2px black solid;"><i class="fa-solid fa-circle-plus"></i> ADD NEW SLIDER</a>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <br/>  
                                                    <div>
                                                        <b>Number Per Page:</b>  <input type="number" name="numberofpage" value="${nof}" placeholder="Number of page ...."> <br/>
                                                        <b>Column To Hide:</b>
                                                        <br/>
                                                        <input type="checkbox" name="col" value="id" ${(id != null) ? "checked" : ""}> Slider ID
                                                        <input type="checkbox" name="col" value="tittle" ${(tittle != null) ? "checked" : ""}> Slider Tittle
                                                        <input type="checkbox" name="col" value="image" ${(image != null) ? "checked" : ""}> Slider Image
                                                        <input type="checkbox" name="col" value="video" ${(video != null) ? "checked" : ""}> Slider Video
                                                        <input type="checkbox" name="col" value="backlink" ${(backlink != null) ? "checked" : ""}> Slider BackLink
                                                        <input type="checkbox" name="col" value="status" ${(status != null) ? "checked" : ""}> Slider Status 
                                                        <br/>
                                                        <input type="submit" value="Apply">
                                                    </div>

                                                    <input type="hidden" name="page" value="${param.page}">

                                                    </div>

                                                </form>


                                                </br>
                                                <div class="table-responsive">  
                                                    <table class="table mb-0"> <!-- comment -->
                                                        <thead class="text-uppercase bg-body text-muted">
                                                            <tr>
                                                                <c:if test="${id == null}">
                                                                    <th>Slider ID</th>
                                                                    </c:if>
                                                                    <c:if test="${tittle == null}">
                                                                    <th>Slider Tittle</th>
                                                                    </c:if>
                                                                    <c:if test="${image == null}">
                                                                    <th>Slider Image</th>
                                                                    </c:if>
                                                                    <c:if test="${video == null}">
                                                                    <th>Slider Video</th>
                                                                    </c:if>
                                                                    <c:if test="${backlink == null}">
                                                                    <th>Slider BackLink</th>
                                                                    </c:if>
                                                                    <c:if test="${status == null}">
                                                                    <th>Slider Status</th>
                                                                    </c:if>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${requestScope.listS}" var="slider">
                                                                <tr>
                                                                    <c:if test="${id == null}">
                                                                        <td>${slider.slider_id}</td>
                                                                    </c:if>
                                                                    <c:if test="${tittle == null}">
                                                                        <td>${slider.slider_tittle}</td>
                                                                    </c:if>


                                                                    <c:if test="${image == null}">
                                                                        <td>
                                                                            <img src="${slider.slider_image}" class="img-radius" alt="${b.blog_tittle}" width="100px" height="100px">
                                                                        </td>
                                                                    </c:if>


                                                                    <c:if test="${video == null}">
                                                                        <td>
                                                                            <c:if test="${slider.slider_video == null}">Not Video</c:if>
                                                                            <c:if test="${slider.slider_video != null}">

                                                                                <video style="width: 100px; height: 100px;" controls autoplay loop muted poster="poster-image.jpg">
                                                                                    <source  src="${slider.slider_video}" type="video/mp4">
                                                                                </video>
                                                                            </td>

                                                                        </c:if>
                                                                    </c:if>

                                                                    <c:if test="${backlink == null}">
                                                                        <td><a href="${slider.slider_backlink}" target="_blank">${slider.slider_backlink}</a></td>
                                                                        </c:if>
                                                                        <c:if test="${status == null}">
                                                                        <td>${slider.slider_status}</td>
                                                                    </c:if>
                                                                    <td><a href="SliderDetail?id=${slider.slider_id}"><i class="fa-regular fa-eye"></i></a>
                                                                        &nbsp;
                                                                        <a href="editSlider?id=${slider.slider_id}"><i class="fa-solid fa-pen"></i></a>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>

                                                    <div class="pagination">
                                                        <c:if test="${totalpage > 1}">
                                                            <c:forEach var="c" begin="1" end="${totalpage}" step ="1">
                                                                <button type="submit" name="page" onclick="goToPage(${c})">${c}</button>
                                                            </c:forEach>
                                                        </c:if>
                                                    </div>

                                                    <form id="paginationForm" action="SliderListMKT" method="get">
                                                        <input type="hidden" name="search" value="${param.search}">
                                                        <input type="hidden" name="status" value="${param.status}">
                                                        <input type="hidden" name="numberofpage" value="${param.numberofpage}">
                                                        <c:if test="${id != null}">
                                                            <input type="hidden" name="col" value="${id}">
                                                        </c:if>
                                                        <c:if test="${tittle != null}">
                                                            <input type="hidden" name="col" value="${tittle}">
                                                        </c:if>
                                                        <c:if test="${image != null}">
                                                            <input type="hidden" name="col" value="${image}">
                                                        </c:if>
                                                        <c:if test="${video != null}">
                                                            <input type="hidden" name="col" value="${video}">
                                                        </c:if>
                                                        <c:if test="${backlink != null}">
                                                            <input type="hidden" name="col" value="${backlink}">
                                                        </c:if>
                                                        <c:if test="${status != null}">
                                                            <input type="hidden" name="col" value="${status}">
                                                        </c:if>
                                                        <input type="hidden" name="page" id="pageInput" value="1">
                                                    </form>

                                                </div>
                                                <br/> 



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
