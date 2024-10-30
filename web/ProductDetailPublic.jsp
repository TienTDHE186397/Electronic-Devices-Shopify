<%-- 
    Document   : ProductDetailPublic
    Created on : Oct 9, 2024, 11:25:44 PM
    Author     : Dokkuhai
--%>
<%@ page import="java.util.UUID" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="img/Icon.jpg">
        <title>Thông tin chi tiết sản phẩm ${productDetail.getProductName()}</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <meta name="viewport" content="width=device-wixdth, initial-scale=1">
        <script src="js/bootstrap.bundle.min.js"></script>
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.cdnfonts.com/css/roboto" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
        
        <style>

            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body{

                align-items: center;
                justify-content: center;
                min-height: 100vh;
               
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
            #subs {
                margin-top: 70px;
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
                margin-bottom: 50px;
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

            .p-title{
                font-size: 30px;
                font-family: 'Roboto';
            }
            
            .p-title-small{
                font-size: 14px;
                font-style: italic;
                margin-right: 25px;
                display: flex;
                
            }
            
            .product-name{
                margin: 10px 30px 10px 10px;
                border-radius: 15px;
                padding: 20px;

            }
            
            .p-body{
                width: 100%;
                display: flex;
                justify-content: space-between;
                align-content: center;
                margin-left: 50px;
            }

            .product-title-note{
                margin: 0px 10px;
            }
            .p-infor{
                width: 45%;
                margin-left: 20px;
                border: 3px solid white;
                border-radius: 10px;
                height: 50%;
            }
            .p-image{
                width: 100%;            
                height: 600px; /* Tăng chiều cao */
                max-width: 900px; /* Điều chỉnh theo ý muốn */
                margin: 0 auto; /* Căn giữa carousel */
                
            }
            
            .carousel-item{
                width: 100%; /* Đảm bảo carousel item chiếm 100% chiều rộng của phần chứa */
                height: 500px; /* Đặt chiều cao cụ thể cho carousel item */
                background-color: #F08080;            
                border-radius: 10px;
                
            }
            
            .carousel-item img {
                width: 400px; 
                height: 400px; 
                object-fit: contain; 
                margin-top: 10px;
                border-radius: 10px;
            }
            
            .carousel-indicators button{
                border-radius: 15px;
                margin: 0px 5px;
                
            }
            .carousel-indicators button img{
                border-radius: 15px;
                
            }
            .p-rate{
                display: flex;
            }
            
            .p-title-information{
                display: flex;
                margin-right: 15px;
                justify-content: space-between;
                align-content: center; 
            }
            
            .price-table{
                padding: 0px 12px;
                width: 75%;
                background-color: #EDEDED;
                height: 150px;
                border-radius: 10px; 
                margin: 15px 15px;    
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


        

        <div class="p-body">
            <div class="p-image">
                <%
                    // Tạo UUID ngẫu nhiên làm id duy nhất cho carousel
                    String carouselId = "carouselExampleIndicators" + UUID.randomUUID().toString();
                %>

                <div id="<%= carouselId %>" data-mdb-carousel-init class="carousel slide carousel-fade" data-mdb-ride="carousel">
                    <!-- Slides -->
                    <div class="carousel-inner mb-lg-auto">
                        <div class="carousel-item active">
                            <img src="${productDetail.getImg()}" class="d-block w-100" alt="..." />
                        </div>
                            <c:forEach items="${listImage}" var="imageItem">
                                <div class="carousel-item">
                                    <img src="${imageItem.getImage_url()}" class="d-block w-100" alt="..." />
                                </div>
                            </c:forEach>
                    </div>

                    <!-- Controls -->
                    <button class="carousel-control-prev" type="button" data-mdb-target="#<%= carouselId %>" data-mdb-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-mdb-target="#<%= carouselId %>" data-mdb-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>

                    <!-- Thumbnails -->
                    <div class="carousel-indicators" style="margin-bottom: -20px;">
                        <button type="button" data-mdb-target="#<%= carouselId %>" data-mdb-slide-to="0" class="active" aria-current="true" aria-label="Slide 0" style="width: 100px;">
                            <img class="d-block w-100" src="${productDetail.getImg()}" class="img-fluid" />
                        </button>
                            <c:forEach items="${listImage}" var="imageThumnail">
                                <button type="button" data-mdb-target="#<%= carouselId %>" data-mdb-slide-to="${imageThumnail.getImage_id()}" aria-label="Slide ${imageThumnail.getImage_id()}" style="width: 100px;">
                                    <img class="d-block w-100" src="${imageThumnail.getImage_url()}" class="img-fluid" />
                                </button>
                            </c:forEach>
                    </div>
                </div>
            </div>
            <div class="p-infor">
                <div class="p-title"><b>${productDetail.getProductName()}</b></div>
                <div class="p-title-small">
                    <div class="p-title-information"><b>Mã SP: </b>${productDetail.getProductID()}</div>
                    <div class="product-title-note"><b>Phân loại: </b><a href="product-list?category=${productDetail.getCategory().getCategoryID()}">${productDetail.getCategory().getCategoryName()}</a></div>
                    <div class="p-title-information">
                        <div><b>Đánh giá: </b></div>
                        <div class="p-rate">
                            <%
                                for (int i = 0; i < 5; i++) {
                            %>
                            <div style="color: #FFC125" class="rate">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <% 
                                }
                            %>
                        </div>                        
                    </div>
                    <div class="p-title-information"><b>Lượt xem: </b>${productDetail.getViews()}</div>
                    <div class="product-information"><b>Ngày cập nhật: </b>${productDetail.getReleaseDate()}</div>
                </div>
                <div style="border-bottom: solid 1px gray; width: 95%;margin: 15px 0px;"></div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Thương hiệu: ${productDetail.getBrand()}</span>
                </div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Tình trạng: ${productDetail.getStatus()}</span>
                </div>
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Số lượng đã bán: ${productDetail.getQuantity()} chiếc</span>
                </div> 
                <div>
                    <i class="fa-solid fa-circle-check" style="color: #FFC125"></i><span>Số lượng còn: ${productDetail.getQuantity()} chiếc</span>
                </div> 
                <div class="price-table">
                    <div style="color: red; font-size: 20px"><b>Ưu đãi giảm tới ${productDetail.getSale()}%</b></div>
                    <table border="0" style="height: 50%;width: 70%">           
                        <tbody>
                            <tr>
                                <td style="font-size: 20px;"><b>Giá niêm yết:</b></td>
                                <td style="font-size: 20px;text-decoration: line-through;color: gray;">${productDetail.getPrice()}đ</td>
                            </tr>
                            <tr>
                                <td style="font-size: 20px"><b>Giá khuyến mại: </b></td>
                                <td style="font-size: 20px; color: red"><b>${productDetail.getPrice() * (1 - productDetail.getSale() / 100)}đ</b></td>
                            </tr>
                        </tbody>
                    </table>
                    <div style="color: grey; font-size: 20px; font-style: italic">Trả góp 0% qua thẻ tín dụng kỳ hạn 3-6 tháng</div> 
                </div>
                <div>            
                 
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <a href="cart?ProductID=${productDetail.getProductID()}" onclick="alert('Bạn cần đăng nhập để mượn sách')" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;width: 75%;height: 100px;"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ hàng</a>
                        <a href="javascript:history.back()" class=""></a>
                    </c:when>
                    <c:otherwise>
                        <a href="cart?ProductID=${productDetail.getProductID()}" class="btn btn-primary" style="background-color: #f8405e;border-color: #f8405e;font-size: 12px"><i class="fa fa-cart-plus" aria-hidden="true"></i>  Thêm vào giỏ hàng</a>
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>
</html>
