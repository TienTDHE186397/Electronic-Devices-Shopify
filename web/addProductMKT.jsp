
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

                <label for="blogtype">Product Type: <a href="addCategory?type=product">(ADD NEW CATEGORY +)</a>
                    <c:if test="${err1 != null}">
                        <p style="color: red">${err1}</p>
                    </c:if>
                </label>
                <select name="categoryid" id="customSelect" >
                    <option value="">Select Category</option>
                    <c:forEach var="c" begin="0" end="${listType.size() -1}" step ="1">
                        <option value="${listType.get(c).categoryID}" ${(listType.get(c).categoryID == product_category_id) ? "selected" : ""} >${listType.get(c).categoryName}</option>
                    </c:forEach>
                </select>

                <label for="blogTitle">Product Tittle:</label>
                <input type="text" id="blogTitle" name="tittle" value="${product_tittle}" placeholder="Tittle....." required>

                <label for="blogTitle">Product Name:</label>
                <input type="text" id="blogTitle" name="name" value="${product_name}" placeholder="Name......" required>

                <label for="blogTitle">Product Quantity:</label>
                <input type="number" id="blogTitle" name="quantity" value="${product_quantity}" placeholder="Quantity....." required>

                <label for="blogTitle">Product Brand:</label>
                <input type="text" id="blogTitle" name="brand" value="${product_brand}" placeholder="Brand....." required>

                <label for="blogTitle">Product Price:</label>
                <input type="number" id="blogTitle" name="price" min="1" value="${product_price}" placeholder="Price....." required>

                <label for="blogTitle">Product Publisher:</label>
                <input type="text" id="blogTitle" name="publisher" value="${product_publisher}" placeholder="Publisher....." required>
                
                 <label for="blogTitle">Product Sale:</label>
                 <input type="number" id="blogTitle" name="sale" min="0" max="30" value="${product_sale}" placeholder="Sale....." required>

                <label for="blogTitle">Product ShortDescription:</label>
                <input type="text" id="blogTitle" name="shortdescription" value="${product_shortdescription}" placeholder="Short Description....." required>

                <label for="blogDetail">Product Description:</label>
                <textarea style="height: 200px;"  class="tinymce" placeholder="Write A Description For A Product......." name="description" rows="4">${product_description}</textarea>
                <br/>
                <label for="blogStatus">Product Status:</label>
                <select id="blogStatus" name="status" required>
                    <option value="Available" ${(product_status == 'Available') ? "selected" : ""}>Available</option>
                    <option value="Sold Out" ${(product_status == 'Sold Out') ? "selected" : ""}>Sold Out</option>
                    <option value="Hided" ${(product_status == 'Hided') ? "selected" : ""}>Hided</option>
                </select>
                <div class="form-group">
                    <label>Product Image</label>
                    <input type="file" class="form-control" id="centeredInput" accept=".jpg" name="productimage">
                    <c:if test="${err2 != null}">
                        &nbsp; &nbsp; &nbsp; &nbsp;<p style="color: red; display: inline-block;">${err2}</p>
                    </c:if>
                </div>
                <button type="submit">Add Product</button>
            </form>
        </div>

    </body>



</html>
