<%-- 
    Document   : CartContact
    Created on : Oct 31, 2024, 7:08:45 PM
    Author     : Dokkuhai
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin đặt hàng</title>

        <style>
            body{
                box-sizing: border-box;
            }
            #subs {
                background-color: #f7f7f7; /* Màu nền nhẹ */
                padding-top: 5rem;
                padding-bottom: 5rem;
                margin-top: 70px;
                margin-bottom: 30px;
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

            .bg_light_1 {
                background-color: transparent; /* Làm nền trong suốt để hiển thị gradient phía sau */
            }

            .search-item{
                margin: 20px 20px;
            }

            .drop-shadow {
                filter: drop-shadow(0.3em 0.3em 0.1em #555);
            }

            .category-box{
                margin: 20px 20px;
            }

            table {
                border-spacing: 0;
                width: 100%;

            }
            td {
                border: 1px solid black;

                padding: 8px;
                text-align: center;
            }
            .latest-product{
                margin: 20px 20px;
            }

            .card-product{
                display: flex;
                overflow: hidden;
                border: 1px solid black;
                margin: 10px 0px;
            }
            .card-product img{
                width: 50px;
                height: 50px;
                object-fit: contain;
            }

            .sider{
                background-color: #ffffff;
                width: 100%;
                height: 100vh;
                margin-top: 50px;
                border-top: 1px solid black;
                border-left: 1px solid black;

            }

            .contact-table{
                width: 100%;
                margin: 50px 20px 10px 10px;
                background-color: #d9d9d9;
                border-radius: 10px;
                border: 1px solid black;
                padding: 40px;
                object-fit: contain;
            }

            .contact-information{
                margin: 20px 10px 0px 0px;
            }

            .price-table{
                margin-left: 0px;

                background-color: white;
                border-radius: 10px;

            }

            .input{
                width: 100%;
                height: 20px;
                border: 1px solid black;
            }

            /* CSS cho bảng sản phẩm */
            #productTable {
                border-collapse: collapse;
                width: 100%;
            }

            #productTable th, #productTable td {
                padding: 10px;
                text-align: center;
                font-size: 14px;
            }

            #productTable th {
                background-color: #f2f2f2;
                color: #333;
            }

            /* CSS cho phân trang */
            #paginationControls {
                display: flex;
                justify-content: center;
                gap: 5px;
                margin-top: 10px;
            }

            #paginationControls button {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 5px 10px;
                cursor: pointer;
                border-radius: 3px;
                font-size: 14px;
                transition: background-color 0.3s;
            }

            #paginationControls button:hover {
                background-color: #0056b3;
            }

            #paginationControls button:disabled {
                background-color: #ddd;
                color: #888;
                cursor: default;
            }

            /* CSS cho lựa chọn số hàng */
            #rowCount {
                width: 50px;
                padding: 3px;
                border-radius: 3px;
                border: 1px solid #ccc;
                font-size: 14px;
            }
        </style>

    </head>
    <body>
        <%@include file="header.jsp" %>

        <section id="subs" class="pt-5 pb-5 bg_light_1">
            <div class="container text-center">
                <h1 class="brand-name">Shopify</h1>
            </div>
        </section>


        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <div class="contact-table container">
                        <div class="row">
                            <div class="contact-information col-md-7">
                                <form action="cartCompletion" method="get" id="cartForm" onchange="return validateForm()">
                                    <h3>Thông tin đặt hàng</h3>
                                    <label><b>Họ tên người nhận hàng</b></label><br>
                                    <input type="text" name="name" id="name" value="${sessionScope.user.getName()}" class="input"/>
                                    <div style="display: flex;justify-content: space-between">
                                        <div style="width: 55%">
                                            <label><b>Địa chỉ email</b></label><br>
                                            <input type="text" name="email" value="${sessionScope.user.getEmail()}" class="input"/>
                                        </div>
                                        <div style="width: 35%">
                                            <label><b>Số điện thoại</b></label><br>
                                            <input type="text" name="phone" id="phone" value="${sessionScope.user.getPhone()}" class="input"/>
                                        </div>
                                    </div>
                                    <label><b>Địa chỉ nhận hàng</b></label><br>
                                    <input type="text" name="address" value="${sessionScope.user.getAddress()}" class="input"/> 
                                    <label><b>Phương thức thanh toán</b></label><br>
                                    <select name="payment">
                                        <option value="Tiền mặt" ${param.payment == 'Tiền mặt' ? 'selected' : ''}>Thanh toán bằng tiền mặt</option>
                                        <option value="Chuyển khoản" ${param.payment == 'Chuyển khoản' ? 'selected' : ''}>Chuyển khoản</option>
                                    </select>
                                </form>
                            </div>

                            <!-- Input chọn số hàng mỗi trang -->
                            <div class="price-table col-md-4">
                                <div style="font-size: 20px; margin-top: 10px;">Thông tin đơn hàng</div>
                                <div>
                                    <label><input type="checkbox" onclick="toggleColumn(0)" checked> Tên SP</label>
                                    <label><input type="checkbox" onclick="toggleColumn(1)" checked> SL</label>
                                    <label><input type="checkbox" onclick="toggleColumn(2)" checked> Tổng</label>
                                </div>
                                <div style="margin-top: 10px;">
                                    <label for="rowCount">Số hàng hiển thị:</label>
                                    <input type="number" id="rowCount" value="5" min="1" onchange="updatePagination()">
                                </div>
                                <table id="productTable" border="0">
                                    <thead>
                                        <tr>
                                            <th style="text-align: start;">Tên SP</th>
                                            <th style="text-align: center;">SL</th>
                                            <th style="text-align: start;">Tổng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cart.items}" var="item">
                                            <tr>
                                                <td style="text-align: start; font-size: 12px;">${item.getProduct().getProductName()}</td>
                                                <td style="text-align: center; font-size: 12px;">x${item.getQuantity()}</td>
                                                <td style="text-align: end; font-size: 12px;">
                                                    <fmt:formatNumber value="${item.getPrice() * item.getQuantity()}" type="currency" />đ
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div id="paginationControls"></div>
                            </div>
                            <div style="border-bottom: 1px solid gray;margin: 0px -10px;"></div>
                            <c:set var="total" value="0" />
                            <c:forEach items="${cart.items}" var="item">
                                <c:set var="total" value="${total + (item.price * item.quantity)}" />
                            </c:forEach>
                            <table border="0">
                                <tbody>
                                    <tr>
                                        <td style="text-align: start"><b>Ưu đãi</b></td>
                                        <td style="text-align: end">-<fmt:formatNumber value="${total/10}"/>đ</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: start"><b>Phí vận chuyển</b></td>
                                        <td style="text-align: end">+30.000đ</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: start"><b>Thuế</b></td>
                                        <td style="text-align: end">0đ</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div style="border-bottom: 1px solid gray;margin: 0px -10px;"></div>
                            <table border="0">                                  
                                <tbody>
                                    <tr>
                                        <td style="text-align: start"><b>Tổng đơn hàng</b></td>
                                        <td style="text-align: end"><fmt:formatNumber value="${total - (total / 10) + 30000}" type="currency" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>   
                    <div style="display: flex;justify-content: space-between">
                        <a href="cart-detail" class="btn btn-primary">Thay đổi</a>
                        <input type="submit" id="payForm" value="Thanh toán" class="btn btn-primary"/>
                        <!--                        <a href="cartCompletion" id="payForm" class="btn btn-primary">Thanh toán</a>-->
                    </div>

                </div>    
                <div class="col-lg-3">
                    <div class="sider drop-shadow">
                        <div class="search-item">
                            <form action="product-list" method="get">
                                <label><b>Tìm kiếm sản phẩm:</b></label>
                                <input style="border-radius: 5px;width: 250px" id ="myInput" name="search_product" type="text" placeholder="Nhập thông tin sản phẩm cần tìm..." class="form-input" value="${param.search_product}">
                            </form>
                        </div>

                        <div class="category-box">
                            <h3>Phân Loại</h3>
                            <table border="1" width="100">
                                <tbody>
                                    <c:forEach items="${listCategory}" var="listC">
                                        <tr>
                                            <td><a href="product-list?category=${listC.getCategoryID()}">${listC.getCategoryName()}</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>                                    
                            </table>
                        </div>

                        <div class="latest-product">
                            <h3>Sản phẩm mới</h3>
                            <c:forEach items="${listProductLatest}" var="listPL">
                                <a href="product-detail?ProductID=${listPL.getProductID()}">
                                    <div class="card-product">
                                        <img src="${listPL.getImg()}" alt="...">
                                        <div>
                                            <div>${listPL.getProductName()}</div>
                                            <div style="font-size: 10px;font-style: italic">Ngày cập nhật: ${listPL.getReleaseDate()}</div>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>    
                    </div>
                </div>
            </div>            
        </div>
        <%@include file="footer.jsp" %>
        <script>
            document.getElementById("payForm").onclick = function () {
                document.getElementById("cartForm").submit();
            }
        </script>
        <script>
            let currentPage = 1;
            
            

            function validateForm() {
                console.log("Validate form is called");
                const nameInput = document.getElementById("name").value.trim();

                if (nameInput === "") {
                    alert("Tên không được để trống.");
                    return false;
                }

                if (nameInput.length < 2) {
                    alert("Tên phải có ít nhất 2 ký tự.");
                    return false;
                }

                // Kiểm tra nếu tên chứa số hoặc ký tự đặc biệt
                const namePattern = /^[A-Za-zÀ-ỹà-ỹ\s]+$/u; // Cho phép các chữ cái (cả dấu) và khoảng trắng
                if (!namePattern.test(nameInput)) {
                    alert("Tên chỉ được chứa các chữ cái.");
                    return false;
                }

                // Kiểm tra số điện thoại
                const phoneInput = document.getElementById("phone").value.trim();
                const phonePattern = /^\d{10}$/;  // Giới hạn là 10 chữ số (có thể thay đổi theo yêu cầu)
                if (!phonePattern.test(phoneInput)) {
                    alert("Vui lòng nhập số điện thoại hợp lệ (10 chữ số).");
                    return false;
                }
            }

            // Hàm ẩn/hiện cột
            function toggleColumn(columnIndex) {
                const table = document.getElementById("productTable");
                const rows = table.rows;

                for (let i = 0; i < rows.length; i++) {
                    const cell = rows[i].cells[columnIndex];
                    if (cell) {
                        cell.style.display = cell.style.display === "none" ? "" : "none";
                    }
                }
            }

            // Hàm cập nhật phân trang
            function updatePagination() {
                const rowsPerPage = parseInt(document.getElementById("rowCount").value) || 5;
                const rows = document.querySelectorAll("#productTable tbody tr");
                const totalPages = Math.ceil(rows.length / rowsPerPage);

                rows.forEach((row, index) => {
                    row.style.display = (index >= (currentPage - 1) * rowsPerPage && index < currentPage * rowsPerPage) ? "" : "none";
                });

                renderPaginationControls(totalPages);
            }

            // Hàm tạo điều khiển phân trang
            function renderPaginationControls(totalPages) {
                const paginationControls = document.getElementById("paginationControls");
                paginationControls.innerHTML = "";

                for (let i = 1; i <= totalPages; i++) {
                    const button = document.createElement("button");
                    button.textContent = i;
                    button.onclick = () => goToPage(i);
                    button.disabled = i === currentPage;
                    paginationControls.appendChild(button);
                }
            }

            // Hàm chuyển trang
            function goToPage(pageNumber) {
                currentPage = pageNumber;
                updatePagination();
            }

            document.addEventListener("DOMContentLoaded", updateRowCount);

            
        </script>

    </body>
</html>
