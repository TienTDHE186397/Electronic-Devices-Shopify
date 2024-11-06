
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
        <title>Add New Product</title>
        <link rel="stylesheet" href="styles.css">
        <script src="https://cdn.tiny.cloud/1/qnmf6c0u3j7wk6wsljsqwke06htozhifzb9v9fs3pw2ed7vx/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
    </head>

    
    
    <body>

        <c:set value="${requestScope.listType}" var="listType" />

        <div class="container">
            <h2>Add New Product</h2>
            <form action="addProductMKT" method="post"  enctype="multipart/form-data">

                <label for="blogtype">Product Type: <a href="addCategory">(ADD NEW CATEGORY +)</a></label>
                <select name="categoryid" id="customSelect" >
                    <option value="">Select Category</option>
                    <c:forEach var="c" begin="0" end="${listType.size() -1}" step ="1">
                        <option value="${listType.get(c).categoryID}" ${(listType.get(c).categoryName == param.type) ? "selected" : ""} >${listType.get(c).categoryName}</option>
                    </c:forEach>
                </select>

                <label for="blogTitle">Product Tittle:</label>
                <input type="text" id="blogTitle" name="tittle" placeholder="Tittle....." required>

                <label for="blogTitle">Product Name:</label>
                <input type="text" id="blogTitle" name="name" placeholder="Name......" required>

                <label for="blogTitle">Product Quantity:</label>
                <input type="number" id="blogTitle" name="quantity" placeholder="Quantity....." required>

                <label for="blogTitle">Product Brand:</label>
                <input type="text" id="blogTitle" name="brand" placeholder="Brand....." required>

                <label for="blogTitle">Product Price:</label>
                <input type="number" id="blogTitle" name="price" placeholder="Price....." required>

                <label for="blogTitle">Product Publisher:</label>
                <input type="text" id="blogTitle" name="publisher" placeholder="Publisher....." required>
                
                 <label for="blogTitle">Product Sale:</label>
                <input type="number" id="blogTitle" name="sale" placeholder="Sale....." required>

                <label for="blogTitle">Product ShortDescription:</label>
                <input type="text" id="blogTitle" name="shortdescription" placeholder="Short Description....." required>

                <label for="blogDetail">Product Description:</label>
                <textarea style="height: 200px;"  class="tinymce" placeholder="Write A Description For A Product......." name="description" rows="4"></textarea>
                <br/>
                <label for="blogStatus">Product Status:</label>
                <select id="blogStatus" name="status" required>
                    <option value="Available">Available</option>
                    <option value="Sold Out">Sold Out</option>
                    <option value="Hided">Hided</option>
                </select>
                <div class="form-group">
                    <label>Product Image</label>
                    <input type="file" class="form-control" id="centeredInput" accept=".jpg" name="productimage">
                </div>
                <button type="submit">Add Product</button>
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
