<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="personID" value="${session.user.PersonID}" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/MyOrder.css">
        <fmt:setLocale value="vi_VN"/>

         
        <script>
            function toggleProducts(button, orderId) {
                const orderItem = button.closest('.order-item');
                const hiddenProducts = orderItem.querySelectorAll('.hidden-product');
                const isExpanded = button.getAttribute('data-expanded') === 'true';
                const hiddenCount = button.getAttribute('data-hidden-count');

                if (!isExpanded) {
                    // Hiện tất cả sản phẩm
                    hiddenProducts.forEach(product => product.style.display = 'flex');
                    button.textContent = 'Thu gọn ' + hiddenCount + ' sản phẩm';
                    button.setAttribute('data-expanded', 'true');
                } else {
                    // Ẩn bớt sản phẩm
                    hiddenProducts.forEach(product => product.style.display = 'none');
                    button.textContent = 'Xem thêm ' + hiddenCount + ' sản phẩm';
                    button.setAttribute('data-expanded', 'false');
                }
            }

            // Đảm bảo chỉ hiển thị 2 sản phẩm đầu tiên khi trang được tải
            document.addEventListener('DOMContentLoaded', function () {
                const orders = document.querySelectorAll('.order-item');
                orders.forEach(order => {
                    const products = order.querySelectorAll('.product-container');
                    if (products.length > 2) {
                        // Ẩn các sản phẩm từ vị trí thứ 3 trở đi
                        for (let i = 2; i < products.length; i++) {
                            products[i].style.display = 'none';
                        }
                    }
                });
            });
            
    document.addEventListener('DOMContentLoaded', function() {
    const tabs = document.querySelectorAll('.tab');
    const orders = document.querySelectorAll('.order-item');
    
    tabs.forEach(tab => {
        tab.addEventListener('click', function(e) {
            e.preventDefault();
            
            // Remove active class from all tabs
            tabs.forEach(t => t.classList.remove('active'));
            
            // Add active class to clicked tab
            this.classList.add('active');
            
            const status = this.getAttribute('data-status');
            
            // Show/hide orders based on status
            orders.forEach(order => {
                if (status === 'all') {
                    order.style.display = 'block';
                } else {
                    const orderStatus = order.getAttribute('data-status');
                    order.style.display = orderStatus === status ? 'block' : 'none';
                }
            });
        });
    });
});
</script> 
       
    </head>
    <style>
        .product-container {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 10px;
            border-bottom: 1px solid #eee;
        }

        .hidden-product {
            display: none;
        }

        .expand-link {
    background-color: white; /* Màu nền */
    color: black; /* Màu chữ */
    border: none; /* Không có viền */
    border-radius: 5px; /* Bo góc */
    padding: 10px 15px; /* Đệm */
    cursor: pointer; /* Con trỏ chuột */
    font-size: 16px; /* Kích thước chữ */
    transition: background-color 0.3s; /* Hiệu ứng chuyển đổi */
}

.expand-link:hover {
    background-color: #0056b3; /* Màu nền khi hover */
    color: white;
}

        .products-wrapper {
            display: flex;
            flex-direction: column;
        }
    </style>

    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>

        <div class="wrapbox-content-account">
            <div class="layout-container">
                <!-- Left Sidebar -->
                <div class="sidebar">
                    <div class="user-profile">
                        <img src="${pimg}" alt="Profile">
                        
                        <span>${sessionScope.user.getName()}</span>
                    </div>
                    <a href="profile" class="menu-item">
                        <span>Thông tin tài khoản</span>
                    </a>
                    <a href="#" class="menu-item">
                        <span>Số địa chỉ</span>
                    </a>
                    <a href="#" class="menu-item active">
                        <span>Quản lý đơn hàng</span>
                    </a>
                    <a href="./LogoutServlet" class="menu-item">
                        <span>Đăng xuất</span>
                    </a>
                </div>

                <!-- Main Content -->
                <div class="content">
                    <div class="tabs">
                        <a href="#" class="tab active" data-status="all">TẤT CẢ (${orderList.size()})</a>
                        <a href="#" class="tab" data-status="OrderNotComplete">ĐANG XỬ LÝ</a>
                        <a href="#" class="tab" data-status="Exported">ĐÃ XUẤT KHO</a>
                        <a href="#" class="tab" data-status="InDelivery">ĐANG VẬN CHUYỂN</a>
                        <a href="#" class="tab" data-status="Delivered">HOÀN THÀNH</a>
                        <a href="#" class="tab" data-status="received">ĐÃ NHẬN HÀNG</a>
                    </div>

                    <div class="search-container">
                        <input type="text" class="search-input" placeholder="Tìm đơn hàng theo Mã đơn hàng">
                        <button class="search-button">Tìm đơn hàng</button>
                    </div>

                    <c:forEach var="order" items="${requestScope.orderList}">
                        <div class="order-item" data-status="${order.shipStatus}">
                            <div class="order-header">
                                <div>${order.shipStatus}</div>
                                <div>#${order.orderID}</div>
                            </div>

                            <div class="products-wrapper">
                                <c:forEach var="product" items="${requestScope.orderProducts[order.orderID]}" varStatus="status">
                                    <%-- Chỉ hiển thị 2 sản phẩm đầu tiên, các sản phẩm còn lại sẽ ẩn --%>
                                    <div class="product-container ${status.index >= 2 ? 'hidden-product' : ''}" 
                                         style="${status.index >= 2 ? 'display: none;' : ''}">
                                        <img src="${product.img}" alt="Product" class="product-image">
                                        <div class="product-info">
                                            <div>${product.productName}</div>
                                        </div>
                                        <div class="product-price">
                                            <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="₫"/>
                                        </div>
                                        <div>${product.quatity}</div>
                                        <div>
                                            <fmt:formatNumber value="${product.totalCost}" type="currency" currencySymbol="₫"/>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>

                            <%-- Chỉ hiển thị nút "Xem thêm" nếu có nhiều hơn 2 sản phẩm --%>
                            <c:if test="${requestScope.orderProducts[order.orderID].size() > 2}">
                                <button class="expand-link" 
                                        data-hidden-count="${requestScope.orderProducts[order.orderID].size() - 2}" 
                                        onclick="toggleProducts(this, '${order.orderID}')">
                                    Xem thêm ${requestScope.orderProducts[order.orderID].size() - 2} sản phẩm
                                </button>
                            </c:if>

                            <div class="order-total">
                                <span>Tổng tiền: </span>
                                <span class="total-amount">
                                    <fmt:formatNumber value="${order.totalMoney}" type="currency" currencySymbol="₫"/>
                                </span>
                                <a href="MyOrderInformation?personID=${sessionScope.user.getPersonID()}&orderID=${order.orderID}" class="view-details">Xem chi tiết</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>

    </body>

</html>