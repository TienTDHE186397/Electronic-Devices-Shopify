<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&family=Open+Sans:wght@300;400;600;700&display=swap" rel="stylesheet">
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>Edit Product</title>

        <style>
            .modal-header, .modal-footer {
                background-color: #f8f9fa;
            }
            .modal-title {
                font-weight: 600;
                font-size: 24px;
            }
            .form-group {
                margin-bottom: 1rem;
            }
            body {
                background-color: red; /* Nền nhẹ để các phần khác nổi bật */
                font-family: 'Roboto', sans-serif;
                ;
            }

            /* Tiêu đề chính */
            .modal-title {
                color: red; /* Màu cam đậm */
                font-weight: 700;
                font-size: 24px;
            }

            /* Phong cách nút */
            .btn-success {
                background-color: #4CAF50; /* Màu xanh lá cây đậm */
                color: white;
                font-weight: 600;
            }

            .btn-default {
                background-color: #f44336; /* Màu đỏ đậm */
                color: white;
            }

            /* Cải thiện form input */

            /* Label cho các form */
            label {
                font-weight: bold;
                color: #333;
                font-family: 'Open Sans', sans-serif;
            }

            /* Hình ảnh trong form */
            img {
                border: 2px solid #ddd;
                padding: 5px;
                border-radius: 10px;
                max-width: 200px;
            }

            /* Thêm một chút hiệu ứng hover cho nút */
            .btn-success:hover, .btn-default:hover {
                opacity: 0.8;
            }



        </style>

        <script type="text/javascript">
            // Hide message after 2 seconds
            function hideMessage() {
                var messageElement = document.getElementById("message");
                if (messageElement) {
                    setTimeout(function () {
                        messageElement.style.display = "none";
                    }, 2000);
                }
            }
            window.onload = hideMessage;
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container mt-5">
                <div class="main">
                    <section class="hero">
                        <form action="ProductDetail" method="post" class="p-4 border rounded" enctype="multipart/form-data">
                            <input style="background-color: #ddd" type="hidden" name="idhi" value="${pro.getProductID()}"> 
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Product</h4>
                            <button style="background-color: #ddd" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Title</label>
                                    <input style="background-color: #ddd" name="title" value="${pro.getTitle()}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Product Name</label>
                                    <input style="background-color: #ddd" name="productName" value="${pro.getProductName()}" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>IMG</label><br/>
                                <img src="${pro.getImg()}" alt="Product Image" style="max-width: 200px; max-height: 200px;">
                                <input  style="background-color: #ddd" name="image" type="file" class="form-control mt-2" >
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Views</label>
                                    <input  style="background-color: #ddd" name="views" value="${pro.getViews()}" type="text" class="form-control" required>
                                </div>
                                <div class="form-">
                                    <label>Publisher</label>
                                    <input  style="background-color: #ddd" name="publisher" value="${pro.getPublisher()}" type="text" class="form-control" required>
                                </div>

                            </div>
                            <div class="form-row">
                                <div>
                                    <c:forEach var="video" items="${video}" varStatus="status">
                                        <label>Video ${status.index + 1}</label><br/>
                                        <video width="320" height="240" controls>
                                            <source src="${pageContext.request.contextPath}/${video.img_video_url}" type="video/mp4">
                                            Trình duyệt của bạn không hỗ trợ thẻ video.
                                        </video>
                                        <input  style="background-color: #ddd" name="vid${status.index}" type="file" class="form-control mt-2" >
                                        <input  style="background-color: #ddd" name="vidTitle${status.index}" type="text" value="${video.alt_text}" class="form-control mt-2" >
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Release Date</label>
                                    <input name="releaseDate"  style="background-color: #ddd" value="${pro.getReleaseDate()}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Category</label>
                                    <select id="id" class="form-control" name="category">
                                        <c:forEach items="${category}" var="c">
                                            <option  style="background-color: #ddd" value="${c.categoryID}" ${(c.categoryID == pro.category.categoryID) ? "selected" : "" } >${c.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Sale</label>
                                    <input name="sale" style="background-color: #ddd" value="${pro.getSale()}" type="number" class="form-control" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Quantity</label>
                                    <input name="quantity" style="background-color: #ddd" value="${pro.getQuantity()}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Price</label>
                                    <input name="price"  style="background-color: #ddd" value="${pro.getPrice()}" type="text" class="form-control" required>
                                </div>

                                <div class="form-group col-md-6"> 
                                    <label>Status</label>
                                    <input name="status"  style="background-color: #ddd" value="${pro.getStatus()}" type="text" class="form-control" required>
                                </div> 

                            </div>
                            <div class="form-group col-md-6"">
                                <label>Publisher</label>
                                <input name="publisher"  style="background-color: #ddd"  value="${pro.getPublisher()}" type="text" class="form-control" required>
                            </div>
                            <c:forEach items="${ivideo}" var="i">
                                <option value="${c.categoryID}" ${(c.categoryID == pro.category.categoryID) ? "selected" : "" } >${c.categoryName}</option>
                            </c:forEach>
                            <c:forEach items="${attribute}" var="a">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <input type="text" style="background-color: #ddd"  placeholder="Enter attribute name" style="font-weight: bold;"value="${a.getAttributeName()}" 
                                               name="attributeName" class="form-control" required>
                                        <input type="hidden" name="oldAttributeName" value="${a.getAttributeName()}"/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="text"  style="background-color: #ddd" placeholder="Enter value"  style="color: #003eff;"   value="${a.getAttributeValue()}" 
                                               name="attributeValue" class="form-control" required>
                                        <input type="hidden"  style="background-color: #ddd"name="oldAttributeValue" value="${a.getAttributeValue()}"/>
                                    </div>
                                </div>
                            </c:forEach>
                            <button type="button" class="btn btn-primary" onclick="addAttribute()">Thêm thuộc tính</button>
                            <button type="button" class="btn btn-primary" onclick="addVideoImage()">Thêm Video,ảnh</button>
                            <div class="form-group col-md-3">
                                <label>Sort Description</label>
                                <textarea name="sortDescription" class="form-control" rows="3" required>${pro.getSortDescription()}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea style="background-color: #ddd" name="description" class="form-control" rows="3" required>${pro.getDescription()}</textarea>
                            </div>
                            <div class="form-group col-md-6">
                                <div id="attributeContainer" class="mt-3"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <input type="submit" class="btn btn-success" value="Save">
                            </div>


                    </form>
                </section>
            </div>

            <script>
                let attributeCount = 0; // Khởi tạo attributeCount bên ngoài hàm

                function addAttribute() {
                    const attributeContainer = document.getElementById('attributeContainer');
                    const newRow = document.createElement('div');
                    newRow.classList.add('form-row', 'mb-2');
                    ////////////////////////////////////////////////////////
                    // Tạo ô nhập liệu cho thuộc tính mới
                    const attributeNameField = `
        <div class="form-group col-md-5">
            <input type="text" placeholder="Nhập tên thuộc tính" style="font-weight: bold;" name="attributeName2" class="form-control" required>
        </div>
    `;
                    const attributeValueField = `
        <div class="form-group col-md-5">
            <input type="text" placeholder="Nhập giá trị" style="color: #003eff;" name="attributeValue2" class="form-control" required>
        </div>
    `;
                    const deleteButton = `
        <div class="form-group col-md-2">
            <button type="button" class="btn btn-danger" onclick="removeAttribute(this)">Xóa</button>
        </div>
    `;
                    // Gắn tất cả các trường vào hàng mới
                    newRow.innerHTML = attributeNameField + attributeValueField + deleteButton;
                    attributeContainer.appendChild(newRow);
                    // Tăng số lượng thuộc tính
                    attributeCount++;
                }
                function addVideoImage() {
                    const attributeContainer = document.getElementById('attributeContainer');
                    const newRow = document.createElement('div');
                    newRow.classList.add('form-row', 'mb-2');
                    ////////////////////////////////////////////////////////
                    // Tạo ô nhập liệu cho thuộc tính mới
                    const attributeNameField = `
        <div class="form-group col-md-5">
            <input type="text" placeholder="Nhập Tên Ảnh or Video" style="font-weight: bold;" name="vidImgName" class="form-control" required>
        </div>
    `;
                    const attributeValueField = `
        <div class="form-group col-md-5">
         <input id="vidImgValue" name="vidImgValue" type="file" accept="video/*" class="form-control" required>
        </div>
    `;
                    const deleteButton = `
        <div class="form-group col-md-2">
            <button type="button" class="btn btn-danger" onclick="removeAttribute(this)">Xóa</button>
        </div>
    `;
                    // Gắn tất cả các trường vào hàng mới
                    newRow.innerHTML = attributeNameField + attributeValueField + deleteButton;
                    attributeContainer.appendChild(newRow);
                    // Tăng số lượng thuộc tính
                    attributeCount++;
                }

            </script>
        </div>


        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
