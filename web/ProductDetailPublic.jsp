<%-- 
    Document   : ProductDetailPublic
    Created on : Oct 9, 2024, 11:25:44 PM
    Author     : Dokkuhai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${product.getProductName()}</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/font-awesome.min.css" rel="stylesheet" >
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/bootstrap.bundle.min.js"></script>
        <link href="css/global.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link href="https://fonts.cdnfonts.com/css/roboto" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        
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
                font-size: 22px;
                border-bottom: 1px solid gray;
            }
            
            .product-name{
                margin: 10px 30px 10px 10px;
                
                border-radius: 15px;
                padding: 20px;
                
            }
            
            
            .p-infor{
                display: flex;
                font-style: italic;
            }
            
            .p-body{
                width: 100%;
                background-color: #F7F7F7;
                height: 100vh;
                border: 1px black solid;
                
            }
            
            .p-body-infor{    
                
                height: 200px;
                background-color: #F7F7F7;
                border-radius: 10px;
                margin-right: 10px;
            }
            
            .product-sider{
                
                height: 200px;
                background-color: #F7F7F7;
                border-radius: 10px;    
            }
            
            .product-title-note{
                margin: 0px 10px;
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
        
        
        <div class="product-name">
            <div class="p-title">${product.getProductName()}</div>
            <div class="p-infor">
                <div class="product-title-note">Phân loại: <a href="product-list?category=${product.getCategory().getCategoryID()}">${product.getCategory().getCategoryName()}</a></div>
                <div class="product-title-note">Thương hiệu: ${product.getBrand()}</div>
                <div class="product-title-note">Ngày cập nhật: ${product.getReleaseDate()}</div>
                <div class="product-title-note">${product.getViews()} lượt xem</div>
            </div>
        </div>
        
        <div class="p-body container-fluid">
           
        </div>
        
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>
</html>
