<%-- 
    Document   : addPost
    Created on : Sep 28, 2024, 2:42:41 PM
    Author     : trung
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="file"],
        input[type="date"],
        input[type="number"],
        textarea,
        select {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
        }

        button {
            padding: 10px 15px;
            border: none;
            background: #28a745;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }

    </style>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Blog</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

        <c:set value="${requestScope.listType}" var="listType" />

        <div class="container">
            <h2>Add New Blog</h2>
            <form action="addPost" method="post" enctype="multipart/form-data">


                <label for="blogType">Blog Type: <a href="#">(ADD NEW BLOG TYPE +)</a></label>
                <select name="blogtype" id="customSelect" onchange="document.getElementById('f1').submit()">
                    <option value="">Select Blog Type</option>
                    <c:forEach var="c" begin="0" end="${listType.size() -1}" step ="1">
                        <option value="${listType.get(c)}" ${(listType.get(c) == param.type) ? "selected" : ""} >${listType.get(c)}</option>
                    </c:forEach>
                </select>

                <label for="blogImg">Blog Image: (.JPG)</label>
                <input type="file" id="blogImg" name="blogimg" accept=".jpg" required>

                <label for="blogTitle">Blog Title:</label>
                <input type="text" id="blogTitle" name="blogtittle" required>

                <label for="blogSummary">Blog Summary Information:</label>
                <textarea id="blogSummary" name="blogsummary" rows="4" required>
                    

                </textarea>



                <label for="blogDetail">Blog Detail:</label>
                <textarea style="height: 200px;" id="blogDetail" name="blogdetail" rows="6" required >
                    

                </textarea>
                <label for="blogImg">Blog Image: (.JPG)</label>
                <input type="file" id="blogImg" name="blogimg" accept=".jpg" required>

                <button>+</button>
                
                <br/>

                <label for="blogStatus">Blog Status:</label>
                <select id="blogStatus" name="blogstatus" required>
                    <option value="published">Published</option>
                    <option value="hided">Hided</option>
                </select>

                <button type="submit">Add Blog</button>
            </form>
        </div>



    </body>
</html>
