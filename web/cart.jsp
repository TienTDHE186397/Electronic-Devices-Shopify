<%-- 
    Document   : cart
    Created on : Oct 21, 2024, 2:27:10 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="styles.css">
    <style>body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7;
}

.cart-container {
    max-width: 800px;
    margin: 100px auto;
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.cart-headermenu {
    text-align: center;
    margin-bottom: 20px;
}

.progress-bar2 {
    display: flex;
    justify-content: space-around;
    padding: 0;
    list-style-type: none;
}

.progress-bar2 li {
    flex: 1;
    text-align: center;
    padding: 10px;
    border-bottom: 2px solid #ccc;
}

.progress-bar2 li.active {
    border-bottom: 2px solid red;
    color: red;
}

.cart-content {
    border-top: 1px solid #eee;
    padding-top: 20px;
}

.cart-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.cart-item img {
    max-width: 150px;
    border-radius: 8px;
}

.item-details {
    flex: 2;
    margin-left: 20px;
}

.item-details h3 {
    margin: 0;
    font-size: 18px;
}

.price {
    color: red;
    font-weight: bold;
    margin-right: 10px;
}

.old-price {
    text-decoration: line-through;
    color: #aaa;
}

.item-actions {
    text-align: center;
}

.remove-btn {
    background-color: transparent;
    border: none;
    color: #888;
    cursor: pointer;
}

.quantity-selector {
    display: flex;
    align-items: center;
    margin-top: 10px;
}

.quantity-selector button {
    width: 30px;
    height: 30px;
    background-color: #ddd;
    border: none;
    cursor: pointer;
}

.quantity-selector input {
    width: 50px;
    text-align: center;
    border: 1px solid #ddd;
}

.discount-code {
    margin: 20px 0;
    text-align: right;
}

.discount-code button {
    background-color: #f0f0f0;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
}

.shipping-details {
    text-align: right;
}

.total-price {
    font-size: 20px;
    color: red;
    font-weight: bold;
}

.checkout-button {
    text-align: center;
    margin-top: 20px;
}

.checkout-button button {
    background-color: red;
    color: white;
    padding: 15px 30px;
    border: none;
    cursor: pointer;
    font-size: 16px;
}

    </style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="cart-container">
        <div class="cart-headermenu">
            <ul class="progress-bar2">
                <li class="active">Giỏ hàng</li>
                <li>Thông tin đặt hàng</li>
                <li>Thanh toán</li>
                <li>Hoàn tất</li>
            </ul>
        </div>
        
        <div class="cart-content">
            <div class="cart-item">
                <img src="${pro.getImg()}" alt="Laptop">
                <div class="item-details">
                    <h3>${pro.getProductName()}</h3>
                    <span class="price">${pro.getPrice()}</span>
                    <span class="old-price">48.990.000đ</span>
                </div>
                <div class="item-actions">
                    <button class="remove-btn">Xoá</button>
                    <div class="quantity-selector">
                        <button class="decrease">-</button>
                        <input type="number" value="1">
                        <button class="increase">+</button>
                    </div>
                </div>
            </div>

            <div class="discount-code">
                <button>Sử dụng mã giảm giá</button>
            </div>

            <div class="shipping-details">
                <p>Phí vận chuyển: <span>Miễn phí</span></p>
                <p>Tổng tiền: <span class="total-price">47.990.000đ</span></p>
            </div>
        </div>

        <div class="checkout-button">
            <button>ĐẶT HÀNG NGAY</button>
        </div>
    </div>
</body>
</html>

