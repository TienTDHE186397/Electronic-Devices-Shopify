<%-- 
    Document   : BlogDetail
    Created on : Oct 1, 2024, 6:00:42 AM
    Author     : trung
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9f9;
            color: #fff;
            padding: 20px;
        }

        .container {
            display: flex;
            justify-content: space-between;
            max-width: 1200px;
            margin: 0 auto;
        }

        .main-content {
            width: 100%;
        }

        .post-image {
            width: 100%;
            border-radius: 8px;
        }

        h1 {
            margin-top: 20px;
            font-size: 2rem;
            font-weight: bold;
            color: #000;
        }

        .meta span {

            color: #000;

        }

        p {
            margin-top: 10px;
            line-height: 1.6;
            color: #000;
        }

        .social-links {
            margin-top: 20px;
        }

        .social-links a {
            margin-right: 15px;
            color: #000;
            font-size: 1.5rem;
            text-decoration: none;
        }

        .related-posts {
            width: 30%;
            background-color: #222;
            padding: 20px;
            border-radius: 8px;
        }

        h3{
            color: #000;
        }

        .related-post {
            display: flex; /* Sử dụng Flexbox để căn chỉnh nội dung */
            align-items: center; /* Căn giữa theo chiều dọc */
            margin-bottom: 20px;

        }

        .related-post h4 {
            padding-left: 20px;
        }

        .related-posts h2 {
            font-size: 1.5rem;
            margin-bottom: 20px;
        }

        .post {
            margin-bottom: 20px;
        }

        .post img {
            width: 100%;
            border-radius: 8px;
            margin-bottom: 10px;
        }

        .post a {
            color: #000;
            text-decoration: none;
            font-size: 1.1rem;
        }

        .post a:hover {
            color: yellow;
        }

        /* Comments Section */
        .comments-section {
            margin-top: 40px;
            background-color: #222;
            padding: 20px;
            border-radius: 8px;
            max-width: 800px;
            margin-left: auto;
            margin-right: auto;
        }

        .comments-section h2 {
            margin-bottom: 10px;
            font-size: 1.5rem;
        }

        .comments-section textarea {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: #333;
            color: #000;
            resize: none;
            font-size: 1rem;
            line-height: 1.4;
        }

        .comments-section button {
            margin-top: 10px;
            padding: 8px 16px;
            border: none;
            background-color: #00bfff;
            color: #000;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            display: block;
            margin-left: auto;
        }

        .comments-section button:hover {
            background-color: #0099cc;
        }

        /* Posted Comments Section */
        .posted-comments {
            margin-top: 20px;
            border-top: 1px solid #444;
            padding-top: 20px;
        }

        .posted-comments h3 {
            margin-bottom: 10px;
            font-size: 1.3rem;
            color: #2d2dd5;
        }

        .comment {
            display: flex;
            align-items: flex-start;
            background-color: #333;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 10px;
            color: #000;
        }

        .comment img {
            border-radius: 50%;
            margin-right: 15px;
            width: 50px;
            height: 50px;
        }

        .comment p {
            margin: 0;
            flex: 1;
            color: #f9f9f9f9;
        }

        .comment strong {
            color: #00bfff;
        }

        .related-posts {
            width: 30%;
            background-color: #222;
            padding: 20px;
            border-radius: 8px;
            max-height: 345px; /* Giới hạn chiều cao tối đa */
            overflow: hidden; /* Ẩn phần nội dung vượt quá chiều cao */
        }


        #backButton {
            position: fixed; /* Định vị cố định */
            top: 20px; /* Khoảng cách từ trên cùng */
            left: 20px; /* Khoảng cách từ bên trái */
            padding: 10px 20px; /* Padding cho nút */
            background-color: blue; /* Màu nền cho nút */
            color: #fff; /* Màu chữ */
            border: none; /* Không có viền */
            border-radius: 5px; /* Bo tròn góc */
            cursor: pointer; /* Đổi con trỏ khi hover */
            font-size: 1rem; /* Kích thước chữ */
        }

        #backButton:hover {
            background-color: #0099cc; /* Màu nền khi hover */
        }

        #backButton a {
            text-decoration: none; /* Remove underline */
            color: #fff; /* Ensure the text color is white */
        }

        .related-post img {

            width: 60px;
            height: 60px;

        }

        a {
            text-decoration: none; /* Bỏ gạch chân */
            color: #fff; /* Đảm bảo màu chữ là đen */
        }

        a:hover {
            color: yellow; /* Màu chữ khi hover */
        }


        .related-posts-wrapper {
            display: block; /* Đảm bảo các phần tử con xếp theo chiều dọc (mặc định của block) */
        }

        .related-posts {
            width: 400px; /* Đặt độ rộng 100% để phần này chiếm toàn bộ chiều ngang */
            background-color: #222;
            margin-left: 37px;
            padding: 20px;
            border-radius: 8px;
            max-height: 345px; /* Giới hạn chiều cao tối đa */
            overflow: hidden; /* Ẩn phần nội dung vượt quá chiều cao */
            margin-bottom: 20px; /* Tạo khoảng cách giữa hai phần */
        }




    </style>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>The Impact of Technology on Modern Society</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    </head>
    <body>

        <!-- Back Button -->
        <c:set value="${requestScope.slider}" var="slider"/>      
        <c:set value="${requestScope.listRB}" var="RB"/>



        <div class="container row">



            <div>
                <button id="backButton"> 
                    <a href="SliderListMKT">Back</a>
                </button>
            </div>
            <!-- Main Content Section -->
            <div class="main-content ">
                <center><h1>${slider.slider_tittle}</h1><center>
                        <br/>
                        <h2>Slider Image:</h2><br/>  
                        <img src="${slider.slider_image}" style="width: 500px;height: 300px;" alt="Laptop with code" class="post-image">
                        <br/><h2 >Slider Video:</h2><br/>
                        <c:if test="${slider.slider_video == null}">Not Video</c:if>
                        <c:if test="${slider.slider_video != null}">

                            <video style="width: 500px;height: 300px;" controls autoplay loop muted >
                                <source  src="${slider.slider_video}" type="video/mp4">
                            </video>

                        </c:if>
                        <br/>
                        <br/>
                        <br/>
                        <div class="meta">
                            <img src="https://m.yodycdn.com/blog/jerry-meme-yodyvn10.jpg" style="width: 50px;height: 50px;" alt="Author Image">
                            <span>${slider.person.name}</span>
                            <span><i style="color: grey;">${slider.slider_date}</i></span>
                        </div>
                        <br/>
                        <h3>Slider BackLink:  </h3> 
                        <p><a href="${slider.slider_backlink}" target="_blank">${slider.slider_backlink}</a></p>
                        <br/>
                        <h3>Slider Note:</h3>
                        <p>${slider.slider_note}</p>
                        <div class="social-links">

                        </div>
                        </div>



                        </div>

                        </body>
                        </html>
