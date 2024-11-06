<%-- 
    Document   : CartCompletion
    Created on : Oct 25, 2024, 2:32:40 PM
    Author     : nghie
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Completion</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .container {
                display: flex;
                justify-content: space-between;
                width: 1000px;
                margin: 20px auto;
                padding: 5rem;
            }
            .sidebar, .order-details {
                width: 20%;
                border: 1px solid #000;
                padding: 10px;
            }
            .cart-items {
                width: 55%;
                border: 1px solid #000;
                padding: 10px;
            }
            .cart-items table {
                width: 100%;
                border-collapse: collapse;
            }
            .cart-items table th, .cart-items table td {
                border: 1px solid #000;
                padding: 8px;
                text-align: center;
            }
            .cart-items .item-list {
                margin-top: 10px;
            }
            .buttons {
                display: flex;
                justify-content: space-between;
                margin-top: 20px;
            }
            .buttons button {
                padding: 10px 20px;
                font-size: 16px;
            }
        </style>
    </head>

    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

        <div class="container">

            <!-- Cart Items Section -->
            <div class="cart-items">
                <h2>Cart Completion</h2>
                <table>
                    <thead>
                        <!-- Table headers for cart item details -->
                        <tr>
                            <th>ID</th>
                            <th>Hình ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Looping through each item in the cart to display details -->
                        <c:forEach items="${cart.items}" var="item">
                            <tr>
                                <!-- Display product ID -->
                                <td>${item.getProduct().getProductID()}</td>
                                <!-- Display product image with fixed width and height -->
                                <td><img src="${item.getProduct().getImg()}" width="100px" height="100px" alt="alt"/></td>
                                <!-- Display product name -->
                                <td>${item.getProduct().getProductName()}</td>
                                <!-- Static price per item (here it is set as $10, but should be dynamically calculated) -->
                                <td>$10</td>
                                <!-- Display quantity of each product in the cart -->
                                <td>x${item.getQuantity()}</td>
                                <!-- Display total cost for each product (price * quantity) -->
                                <td>${item.getPrice() * item.getQuantity()}đ</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <!-- Order Details Section -->
            <div class="order-details">
                <!-- Calculate the total cost of all items in the cart -->
                <c:forEach items="${cart.items}" var="item">
                    <c:set var="total" value="${total + (item.price * item.quantity)}" />
                </c:forEach>

                <!-- Display general order information -->
                <h3>Order Information</h3>
                <!-- Hidden fields for PersonID and OrderID, useful for backend processing -->
                <input type="hidden" id="PersonID" name="PersonID" value="${p.personID}"/>
                <input type="hidden" id="OrderID" name="OrderID" value="${p.personID}"/>
                <!-- Display order ID from the order object -->
                <p>Order ID: ${order.odID}</p>
                <!-- Display customer's name, email, and phone number -->
                <p>Họ và tên: ${sessionScope.user.getName()}</p>
                <p>Email: ${sessionScope.user.getEmail()}</p>
                <p>Số điện thoại: ${sessionScope.user.getPhone()}</p>
                <!-- Display shipping address -->
                <p>Địa chỉ nhận hàng: ${address}</p>
                <!-- Placeholder for payment method, this could be a dropdown or text -->
                <p>Phương thức thanh toán:</p>
                <!-- Display total cost with discount and shipping fee (if any) -->
                <p>Total Cost: ${total - (total / 10) + 30000}đ</p>
                <!-- Display order status -->
                <p>Order Status: Shipped</p>
                <!-- Display current date and time when the order was created -->
                <p>Created Order: <input type="datetime-local" id="currentDate" readonly/></p>

                <!-- Payment Information Section -->
                <h3>Payment Information</h3>
                <!-- Display bank information for payment transfer -->
                <p><strong>Bank Name:</strong> ${bankName}</p>
                <p><strong>Account Name:</strong> ${AccountName}</p>
                <p><strong>Account Number:</strong> ${AccountNumber}</p>
                <!-- Display total amount for payment -->
                <p><strong></strong>Amount: $${total - (total / 10) + 30000}</p>
            </div>
        </div>

        <!-- Action Buttons Section -->
        <div class="buttons">
            <!-- Button to continue shopping, redirects to the home page -->
            <button onclick="window.location.href = 'home'">Continue Shopping</button>
            <!-- Button to complete the payment process, redirects to the finishOrder page -->
            <button onclick="window.location.href = 'finishOrder'">Completed the Payment</button>
        </div>

        <!-- Script Section -->
        <script>
            const now = new Date();

            // Chuyển đổi thời gian hiện tại thành định dạng phù hợp cho datetime-local (YYYY-MM-DDTHH:mm)
            const currentDateTime = now.toISOString().slice(0, 16);

            // Gán thời gian hiện tại cho trường End date
            document.getElementById('currentDate').value = currentDateTime;
        </script>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
