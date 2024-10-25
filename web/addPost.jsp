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
            max-width: 900px;
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

        <script src="https://cdn.tiny.cloud/1/qnmf6c0u3j7wk6wsljsqwke06htozhifzb9v9fs3pw2ed7vx/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>



    </head>

    <body>

        <c:set value="${requestScope.listType}" var="listType" />

        <div class="container">
            <h2>Add New Blog</h2>
            <form action="addPost" method="post"  enctype="multipart/form-data">

                <label for="blogtype">Blog Type: <a href="addCategory">(ADD NEW BLOG TYPE +)</a></label>
                <select name="blogtype" id="customSelect" >
                    <option value="">Select Blog Type</option>
                    <c:forEach var="c" begin="0" end="${listType.size() -1}" step ="1">
                        <option value="${listType.get(c)}" ${(listType.get(c) == param.type) ? "selected" : ""} >${listType.get(c)}</option>
                    </c:forEach>
                </select>

                <label for="blogTitle">Blog Title:</label>
                <input type="text" id="blogTitle" name="blogtittle" placeholder="Tittle Blog....." required>
                
                <label for="blogSummary">Blog Summary Information:</label>
                <input type="text" id="blogTitle" name="blogsummary" placeholder="Summary Blog......" required>

                <!-- comment -->
                <label for="blogDetail">Blog Detail:</label>
                <textarea style="height: 200px;"  class="tinymce" placeholder="Write A Blog......." name="blogdetail" rows="6"></textarea>
                <br/>
                <!-- comment -->

                <label for="blogStatus">Blog Status:</label>
                <select id="blogStatus" name="blogstatus" required>
                    <option value="Published">Published</option>
                    <option value="Hided">Hided</option>
                </select>

                <div class="form-group">
                    <label>Image Blog</label>
                    <input type="file" class="form-control" id="centeredInput" accept=".jpg" name="blogimage">
                    <input type="text" class="form-control" id="centeredInput" name="imagetittle" style="width: 367px; height: 23px;" placeholder="Tittle Image..." required>

                     <b>Blog Flag:</b> <select name="blogflag" id="customSelect">
                        <option value="0">No</option>
                        <option value="1">Yes</option>
                    </select>
                </div>
                
                
                <button type="submit">Add Blog</button>
            </form>
        </div>

    </body>
    
    
    <script>
        tinymce.init({
            selector: '.tinymce',
            plugins: 'advlist autolink lists link image charmap print preview hr anchor pagebreak media',
            toolbar_mode: 'floating'
        });
    </script>



</html>
