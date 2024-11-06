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
            max-height: 345px;
            overflow: hidden;
        }


        #backButton {
            position: fixed;
            top: 20px;
            left: 20px;
            padding: 10px 20px;
            background-color: blue;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
        }

        #backButton:hover {
            background-color: #0099cc;
        }

        #backButton a {
            text-decoration: none;
            color: #fff;
        }

        .related-post img {

            width: 60px;
            height: 60px;

        }

        a {
            text-decoration: none;
            color: #fff;
        }

        a:hover {
            color: yellow;
        }


        .related-posts-wrapper {
            display: block;
        }

        .related-posts {
            width: 400px;
            background-color: #222;
            margin-left: 37px;
            padding: 20px;
            border-radius: 8px;
            max-height: 345px;
            overflow: hidden;
            margin-bottom: 20px;
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
    <c:set value="${requestScope.blog}" var="B"/>      
    <c:set value="${requestScope.listRB}" var="RB"/>



    <div class="container row">



        <div>
            <button id="backButton"> 
                <a href="PostListHome">Back</a>
            </button>
        </div>
        <!-- Main Content Section -->
        <div class="main-content ">
            <img src="${B.blog_img}" alt="Laptop with code" class="post-image">
            <center><h3 style="color: gray; font-style: italic;">${B.blog_img_tittle}</h3><center>
                    <c:if test="${B.blog_flag == 0}">
                        <h1>${B.blog_tittle}</h1>
                    </c:if>

                    <c:if test="${B.blog_flag == 1}">
                        <h1 style="color: red;">${B.blog_tittle}</h1>
                    </c:if>

                    <div class="meta">
                        <img src="https://m.yodycdn.com/blog/jerry-meme-yodyvn12.jpg" width="80px" height="80px" alt="Author Image">
                        <span>${B.person.name}</span>
                        <span>${B.blog_update_time}</span>
                    </div>
                    <br/>
                    <h3>Summary Information:  </h3> <p>${B.blog_summary_information}</p>
                    <br/>
                    <h3>Blog Detail:</h3>
                    <p>${B.blog_detail}</p>
                    <div class="social-links">
                        <a href="#"><i class="fab fa-facebook"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-linkedin"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                    </div>

                    <div class="related-posts-wrapper">
                        <div class="related-posts">
                            <h2>Related Posts</h2>
                            <c:forEach var="c" begin="0" end="${RB.size() - 1}" step ="1">
                                <a href="PostDetailHome?id=${RB.get(c).blogID}">  
                                    <div class="related-post">
                                        <img src="${RB.get(c).blog_img}" alt="Related Post Image">
                                        <h4>${RB.get(c).blog_tittle}</h4>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>

    </div>
                    
                    <div class="comments-section">
                        <h2>Comments</h2>
                        <c:if test="${sessionScope.user != null}">
                        <form action="PostDetailHome?id=${param.id}" method="post">
                            <textarea name="comment" id="comment" rows="5" placeholder="Enter your comment..."></textarea>
                            <button type="submit">Post Comment</button>
                        </form>
                        </c:if>
                        
                        <c:if test="${sessionScope.user == null}">
                            <center><h3 style="color: grey;">Bạn phải đăng nhập để sử dụng tính năng bình luận</h3></center>
                        </c:if>
                        <div class="posted-comments">
                            <h3>Previous Comments</h3>

                            <c:forEach items="${requestScope.listC}" var="c">
                                <div class="comment">
                                    <img src="https://m.yodycdn.com/blog/anh-dai-dien-hai-yodyvn2.jpg" alt="User Image">
                                    <p><strong>${c.person.name}:</strong> <i style="color: gray;">${c.comment_date}</i> ${c.comment_text}</p>
                                </div>
                            </c:forEach>


                            <c:if test="${requestScope.listC.isEmpty()}">
                                <br/>
                                <br/>
                                <br/>

                                <center> <h3 style="color: gray;">Hãy Là Người Bình Luận Đầu Tiên!</h3> </center>
                                
                                <br/>
                                <br/>
                                <br/>
                            </c:if>



                        </div>
                    </div>



                    </body>
                    </html>
