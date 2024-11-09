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
            .image-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                margin-top: 20px;
            }

            .image-item {
                width: 320px;
                text-align: center;
                border: 1px solid #ddd;
                border-radius: 8px;
                padding: 10px;
                background-color: #f9f9f9;
            }

            .image-label {
                font-weight: bold;
                margin-bottom: 5px;
                display: block;
                font-size: 14px;
            }

            .image-preview {
                width: 100%;
                height: auto;
                margin-bottom: 10px;
                border-radius: 5px;
            }

            .file-input, .title-input {
                background-color: #ddd;
                font-size: 14px;
            }
            .video-container, .image-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                margin-top: 20px;
            }

            .video-item, .image-item {
                width: 320px;
                text-align: center;
                border: 1px solid #ddd;
                border-radius: 8px;
                padding: 10px;
                background-color: #f9f9f9;
            }

            .video-label, .image-label {
                font-weight: bold;
                margin-bottom: 5px;
                display: block;
                font-size: 14px;
            }

            .video-preview, .image-preview {
                width: 100%;
                height: auto;
                margin-bottom: 10px;
                border-radius: 5px;
            }

            .file-input, .title-input {
                background-color: #ddd;
                font-size: 14px;
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
                        <h3>${mess}</h3>
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
                                <input  style="background-color: #ddd" name="image" type="file" class="form-control mt-2" value="${pro.getImg()}">
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
                                <div class="video-container">
                                    <c:forEach var="video" items="${video}" varStatus="status">
                                        <div class="video-item">
                                            <label class="video-label">Video ${status.index + 1}</label>
                                            <video class="video-preview" controls>
                                                <source src="${pageContext.request.contextPath}/${video.img_video_url}" type="video/mp4">
                                                Your browser does not support the video tag.
                                            </video>
                                            
                                            <input name="vid${status.index}" type="file" class="form-control file-input mt-2">
                                            <input name="vidTitle${status.index}" type="text" value="${video.alt_text}" class="form-control title-input mt-2">
                                            <button type="submit" class="btn btn-primary" name="delete" style="background-color: red">Xóa</button>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="image-container">
                                    <c:forEach var="image" items="${image}" varStatus="status">
                                        <div class="image-item">
                                            <label class="image-label">Image ${status.index + 1}</label>
                                            <img src="${pageContext.request.contextPath}/${image.img_video_url}" alt="Image ${status.index + 1}" class="image-preview">
                                            <input name="img${status.index}" type="file" class="form-control file-input mt-2">
                                            <input name="imgTitle${status.index}" type="text" value="${image.alt_text}" class="form-control title-input mt-2">
                                        </div>
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

                                    <select name="status" style="background-color: #ddd" class="form-control" required>
                                        <option value="Available" ${pro.getStatus() == 'Available' ? 'selected' : ''}>Available</option>
                                        <option value="Sold Out" ${pro.getStatus() == 'Sold Out' ? 'selected' : ''}>Sold Out</option>
                                        <option value="Hided" ${pro.getStatus() == 'Hided' ? 'selected' : ''}>Hided</option>
                                    </select>
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
                                <div class="form-row" id="row-${a.getAttributeID()}">

                                    <div class="form-group col-md-5">
                                        <input type="text" style="background-color: #ddd" placeholder="Enter attribute name" value="${a.getAttributeName()}" 
                                               name="attributeName" class="form-control" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="text" style="background-color: #ddd" placeholder="Enter value" value="${a.getAttributeValue()}" 
                                               name="attributeValue" class="form-control" required>
                                    </div>
                                    <div class="form-group col-md-1">

                                        <form action="DeleteAttributeServlet" method="post" onsubmit="return confirmDelete();">
                                            <input type="hidden" name="idhi" value="${pro.getProductID()}"> 
                                            <input type="hidden" name="attributeID" value="${a.getAttributeID()}">
                                            <button type="submit" class="btn btn-danger" onclick="return confirmDelete();">Delete</button>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>

                            <div class="d-flex gap-2">
                                <button type="button" class="btn btn-primary" onclick="addAttribute()">Thêm thuộc tính</button>
                                <button type="button" class="btn btn-primary" onclick="addVideo()">Thêm Video</button>
                                <button type="button" class="btn btn-primary" onclick="addImage()">Thêm Ảnh</button>
                            </div>
                            <div id="attributeContainer" style="margin-top: 20px;"></div>
                            <div id="attributeContainer" style="margin-top: 20px;"></div>
                            <div class="form-group col-md-3">
                                <label>Sort Description</label>
                                <textarea name="sortDescription" class="form-control" rows="3" required>${pro.getSortDescription()}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea style="background-color: #ddd" name="description" class="form-control" rows="3" required>${pro.getDescription()}</textarea>
                            </div>
                            <div class="form-group col-md-6">
                                <div id="attributeContainer" style="margin-top: 20px;"></div>
                                <div id="attributeContainer" style="margin-top: 20px;"></div>
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
                function confirmDelete() {
                    console.log('Confirm delete called');
                    return confirm('Are you sure you want to delete this attribute?');
                }

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
        <button type="button" class="btn btn-danger delete-button">Xóa</button>
        </div>
    `;
                    // Gắn tất cả các trường vào hàng mới
                    newRow.innerHTML = attributeNameField + attributeValueField + deleteButton;
                    attributeContainer.appendChild(newRow);
                    newRow.querySelector('.delete-button').addEventListener('click', function () {
                        newRow.remove();
                    });
                    // Tăng số lượng thuộc tính
                    attributeCount++;
                }
                function addVideo() {
                    const attributeContainer = document.getElementById('attributeContainer');
                    const newRow = document.createElement('div');
                    newRow.classList.add('form-row', 'mb-2');
                    newRow.innerHTML = `
    <div class="form-group col-md-5">
        <input type="text" placeholder="Nhập Tên Video" style="font-weight: bold;" name="vidImgName" class="form-control" required>
    </div>
    <div class="form-group col-md-5">
        <input name="vidImgValue" type="file" accept="video/*, image/*" class="form-control" required>
    </div>
    <div class="form-group col-md-2">
        <button type="button" class="btn btn-danger delete-button">Xóa</button>
    </div>
`;
                    attributeContainer.appendChild(newRow);
                    attributeCount++;

                    // Gán sự kiện xóa cho nút "Xóa" mới tạo
                    newRow.querySelector('.delete-button').addEventListener('click', function () {
                        newRow.remove();
                    });
                }
                function addImage() {
                    const attributeContainer = document.getElementById('attributeContainer');
                    const newRow = document.createElement('div');
                    newRow.classList.add('form-row', 'mb-2');
                    newRow.innerHTML = `
    <div class="form-group col-md-5">
        <input type="text" placeholder="Nhập Tên Ảnh " style="font-weight: bold;" name="vidImageName" class="form-control" required>
    </div>
    <div class="form-group col-md-5">
        <input name="vidImageValue" type="file" accept="video/*, image/*" class="form-control" required>
    </div>
    <div class="form-group col-md-2">
        <button type="button" class="btn btn-danger delete-button">Xóa</button>
    </div>
`;
                    attributeContainer.appendChild(newRow);
                    attributeCount++;

                    // Gán sự kiện xóa cho nút "Xóa" mới tạo
                    newRow.querySelector('.delete-button').addEventListener('click', function () {
                        newRow.remove();
                    });
                }


            </script>
        </div>


        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
