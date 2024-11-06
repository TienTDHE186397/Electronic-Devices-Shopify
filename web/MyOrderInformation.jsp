<%-- 
    Document   : MyOrderInformation
    Created on : 29 Oct 2024, 16:21:54
    Author     : admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="personID" value="${session.user.PersonID}" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
            }

            body {
                background: #f2f2f2;
                padding: 20px;
            }
            .wrapbox-content-account{
                background: #f2f2f2;
                padding: 15px;
            }

            .container {
                display: flex;
                gap: 20px;
                max-width: 1200px;
                margin: 50px auto; /* Thêm margin auto để căn giữa */
                padding: 0 20px; /* Thêm padding để tránh dính sát lề */

            }

            .sidebar {
                width: 250px;
                background: white;
                border-radius: 8px;
                padding: 20px;
            }

            .main-content {
                flex: 1;
                background: white;
                border-radius: 8px;
                padding: 20px;
            }

            .user-info {
                display: flex;
                align-items: center;
                gap: 10px;
                padding-bottom: 20px;
                border-bottom: 1px solid #eee;
            }

            .user-avatar {
                width: 40px;
                height: 40px;
                background: #eee;
                border-radius: 50%;
            }

            .progress-bars {
                display: flex;
                justify-content: space-between;
                margin: 20px 0;
                position: relative;
                background: white; /* Thêm background trắng */
                width: 100%; /* Đảm bảo chiều rộng 100% */
                flex-direction: row; /* Đảm bảo hiển thị theo chiều ngang */
                padding: 0 20px;
            }

            .main-content {
                flex: 1;
                background: white;
                border-radius: 8px;
                padding: 20px;
                width: 100%; /* Thêm width 100% */
                overflow: hidden; /* Ngăn overflow */
            }



            .progress-step {
                display: flex;
                flex-direction: column;
                align-items: center;
                z-index: 1;
                min-width: 120px; /* Thêm min-width để các step không bị đè */
                text-align: center; /* Căn giữa text */
            }

            .step-icon {
                width: 30px;
                height: 30px;
                border-radius: 50%;
                background: #e0e0e0;
                display: flex;
                align-items: center;
                justify-content: center;
                margin-bottom: 5px;
                position: relative;
                z-index: 1; /* Đảm bảo icon luôn hiển thị trên progress line */
            }

            .step-icon.active {
                background: #4CAF50;
                color: white;
            }

            .progress-line {
                position: absolute;
                top: 15px;
                left: 60px; /* Điều chỉnh left để line bắt đầu từ giữa step đầu tiên */
                right: 60px; /* Điều chỉnh right để line kết thúc ở giữa step cuối cùng */
                height: 2px;
                background: #e0e0e0;
                z-index: 0;
            }

            .progress-line-active {
                position: absolute;
                top: 15px;
                left: 60px; /* Giữ left giống với progress-line */
                height: 2px;
                background: #4CAF50;
                z-index: 0;
                transition: width 0.3s ease; /* Thêm transition để có animation mượt mà */
            }

            .section {
                margin-bottom: 20px;
                padding: 15px;
                border: 1px solid #eee;
                border-radius: 8px;
            }

            .section-title {
                font-weight: 600;
                margin-bottom: 10px;
                display: flex;
                align-items: center;
                gap: 10px;
            }

            .product-item {
                display: flex;
                gap: 15px;
                margin-bottom: 15px;
                padding-bottom: 15px;
                border-bottom: 1px solid #eee;
            }

            .product-image {
                width: 80px;
                height: 80px;
                background: #f5f5f5;
                border-radius: 4px;
            }

            .product-details {
                flex: 1;
            }

            .price {
                color: #f44336;
                font-weight: 600;
            }

            .original-price {
                text-decoration: line-through;
                color: #999;
                font-size: 0.9em;
            }

            .quantity {
                color: #666;
                font-size: 0.9em;
            }

            .total-section {
                margin-top: 20px;
                padding-top: 20px;
                border-top: 1px solid #eee;
            }

            .total-row {
                display: flex;
                justify-content: space-between;
                margin-bottom: 10px;
            }

            .btn-primary {
                background: #1976d2;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
                margin-top: 20px;
            }

            .menu-item {
                display: flex;
                align-items: center;
                gap: 10px;
                padding: 10px 0;
                color: #666;
                text-decoration: none;
            }

            .status-pending {
                color: #ff9800;
            }
            header {
                position: relative;
                z-index: 1000; /* Đảm bảo header luôn nổi trên cùng */
            }
            .user-avatar img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                background: #eee;
            }
            .product-list {
                position: relative;
            }

            .product-item.hidden {
                display: none;
            }

            .toggle-button {
                background: #1976d2;
                color: white;
                border: none;
                padding: 8px 16px;
                border-radius: 4px;
                cursor: pointer;
                margin-top: 10px;
                width: 100%;
            }

            .toggle-button:hover {
                background: #1565c0;
            }
        </style>
    </head>
    <body>

        <%@include file="header.jsp" %>
        <div class="wrapbox-content-account">
            <div class="container">
                <div class="sidebar">
                    <div class="user-info">
                        <div class="user-avatar">
                            <img src="${pimg}" alt="Profile">
                        </div>
                        <div>${sessionScope.user.getName()}</div>
                    </div>
                    <a href="#" class="menu-item">

                        Thông tin tài khoản
                    </a>
                    <a href="#" class="menu-item">

                        Sổ địa chỉ
                    </a>
                    <a href="MyOrder" class="menu-item">

                        Quản lý đơn hàng
                    </a>
                    <a href="./LogoutServlet" class="menu-item">

                        Đăng xuất
                    </a>
                </div>

                <div class="main-content">
                    <c:forEach var="info" items="${requestScope.orderList}">
                        <input type="hidden" name="orderID" value="${info.orderID}" />
                        <h2>Chi tiết đơn hàng ${info.orderID} - <span class="status-pending">${info.shipStatus}</span></h2>

                        <div class="progress-bars">
                            <div class="progress-line"></div>
                            <div class="progress-line-active"></div>

                            <div class="progress-step">
                                <div class="step-icon active">1</div>
                                <div>Đơn hàng đã đặt</div>
                                <div>
                                    <fmt:formatDate value="${info.orderDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>
                            </div>

                            <div class="progress-step">
                                <div class="step-icon active">2</div>
                                <div>đang tiếp nhận và xử lý</div>
                                <div>
                                    <fmt:formatDate value="${info.completeDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>
                            </div>

                            <div class="progress-step">
                                <div class="step-icon active">3</div>
                                <div>Đã giao cho ĐVVC</div>
                                <div>
                                    <fmt:formatDate value="${info.exportedDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>
                            </div>

                            <div class="progress-step">
                                <div class="step-icon">4</div>
                                <div>Đang giao</div>
                                <div>
                                    <fmt:formatDate value="${info.inDeliveryDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>

                            </div>

                            <div class="progress-step">
                                <div class="step-icon">5</div>
                                <div>Đã Giao</div>
                                <div>
                                    <fmt:formatDate value="${info.deliveredDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>

                            </div>

                            <div class="progress-step">
                                <div class="step-icon">6</div>
                                <div>Đánh Giá</div>
                                <div>
                                    <fmt:formatDate value="${info.receivedDate}" pattern="HH:mm dd/MM/yyyy"/>
                                </div>
                            </div>
                        </div>

                        <div class="section">
                            <div class="section-title">
                                👤 Thông tin khách hàng
                            </div>
                            <c:forEach var="r" items="${requestScope.receiverinfo}">
                                <div>
                                    <div>Người nhận: ${r.receivedName}</div>
                                    <div>Số điện thoại: ${r.receivedPhone}</div>
                                    <div>Địa chỉ nhận hàng: ${r.receivedAddress}</div>
                                </div>
                            </c:forEach>

                        </div>

                        <div class="section">
                            <div class="section-title">
                                📦 Thông tin sản phẩm
                            </div>
                            <c:forEach var="pro" items="${requestScope.orderProducts}" varStatus="loop">
                                <div class="product-item ${loop.index > 1 ? 'hidden' : ''}">
                                    <img src="${pro.img}" alt="Product" class="product-image">
                                    <div class="product-details">
                                        <div>${pro.productName}</div>
                                        <div class="unit-price">
                                            <fmt:formatNumber value="${pro.price}" type="currency" currencySymbol="₫"/>
                                        </div>
                                        <div class="quantity">Số lượng: ${pro.quatity}</div>
                                        <div class="price">
                                            <fmt:formatNumber value="${pro.totalCost}" type="currency" currencySymbol="₫"/>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:if test="${fn:length(requestScope.orderProducts) > 2}">
                                <button class="toggle-button" onclick="toggleProducts()">
                                    Xem thêm sản phẩm
                                </button>
                            </c:if>

                            <!-- More products... -->

                            <div class="total-section">
                                <div class="total-row">
                                    <div>Giá tạm tính:</div>
                                    <fmt:formatNumber value="${info.totalMoney}" type="currency" currencySymbol="₫"/>
                                </div>
                                <div class="total-row">
                                    <div>Phí vận chuyển:</div>
                                    <div>Miễn Phí</div>
                                </div>
                                <div class="total-row">
                                    <div>Tổng tiền:</div>
                                    <div class="price">
                                        <fmt:formatNumber value="${info.totalMoney}" type="currency" currencySymbol="₫"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="MyOrder" class="btn-primary">Quay lại danh sách đơn hàng</a>

                        <c:if test="${info.shipStatus == 'Delivered'}">
                            <form action="MyOrderInformation" method="post">
                                <input type="hidden" name="orderID" value="${info.orderID}" />
                                <button type="submit" class="btn-primary">Xác nhận Đã Nhận Hàng</button>
                            </form>
                        </c:if>

                        <c:if test="${info.shipStatus == 'received'}">
                            <a href="Feedback?orderID=${info.orderID}&&personID=${sessionScope.user.getPersonID()}" class="btn-primary">Phản hồi đánh giá sản phẩm</a>
                        </c:if>




                    </div>
                </c:forEach>     
            </div>
        </div>

        <%@include file="footer.jsp" %>

    </body>
    <script>
        // Đặt script này ở cuối body hoặc trong window.onload
        window.onload = function () {
            // Lấy tất cả các progress step
            const progressSteps = document.querySelectorAll('.progress-step');
            const progressLineActive = document.querySelector('.progress-line-active');

            // Biến đếm số step có giá trị
            let lastActiveStepIndex = -1;

            // Duyệt qua từng step để kiểm tra và xử lý
            progressSteps.forEach((step, index) => {
                // Lấy phần tử div chứa ngày/giờ (div thứ 3 trong mỗi progress-step)
                const dateDiv = step.children[2];

                // Kiểm tra nếu có giá trị ngày/giờ
                if (dateDiv && dateDiv.textContent.trim() !== '') {
                    // Đánh dấu step này là active
                    step.querySelector('.step-icon').classList.add('active');
                    step.querySelector('.step-icon').innerHTML = '✓';
                    lastActiveStepIndex = index;
                } else {
                    // Nếu không có giá trị, giữ nguyên số
                    step.querySelector('.step-icon').classList.remove('active');
                }
            });

            // Tính toán chiều dài của progress line active
            if (lastActiveStepIndex >= 0) {
                // Tính toán phần trăm dựa trên số step có giá trị
                const totalSteps = progressSteps.length - 1; // Trừ 1 vì tính khoảng cách
                const percentage = (lastActiveStepIndex / totalSteps) * 100;

                // Cập nhật chiều dài của progress line active
                progressLineActive.style.width = `${percentage}%`;
            } else {
                // Nếu không có step nào có giá trị
                progressLineActive.style.width = '0%';
            }
        };
    </script>
    <script>
        let isExpanded = false;
        const toggleButton = document.querySelector('.toggle-button');

        function toggleProducts() {
            const products = document.querySelectorAll('.product-item');
            const button = document.querySelector('.toggle-button');

            products.forEach((product, index) => {
                if (index > 1) {
                    product.classList.toggle('hidden');
                }
            });

            isExpanded = !isExpanded;
            button.textContent = isExpanded ? 'Thu gọn' : 'Xem thêm sản phẩm';
        }

        // Đảm bảo chỉ hiển thị nút khi có nhiều hơn 2 sản phẩm
        document.addEventListener('DOMContentLoaded', function () {
            const products = document.querySelectorAll('.product-item');
            if (products.length <= 2) {
                const button = document.querySelector('.toggle-button');
                if (button)
                    button.style.display = 'none';
            }
        });
    </script> 
</html>
