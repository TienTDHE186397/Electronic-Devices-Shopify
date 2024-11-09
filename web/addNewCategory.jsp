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
        <title>Add New Category</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>
        <c:set value="${requestScope.listType}" var="listType" />
        <div class="container">
            <h2>New Category</h2>
            <form action="addCategory" method="post" >
                <label for="blogtype">Category Type:</label>
                <input type="text" class="form-control" id="centeredInput" value="${blog.blog_img_tittle}" name="name" style="width: 95%; height: 23px;" placeholder="Category Type Name..." required>
                <center>     <button type="submit" style="width: 150px;">Add New Category</button> </center>
            </form>
        </div>

    </body>




</html>
