<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đặt Hàng</title>
        <link rel="stylesheet" href="css/cart.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 20px;
            }
            .container2 {
              
                max-width: 600px;
                margin: 0 auto;
                background: white;
                padding: 60px 20px 20px 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            header {
                text-align: center;
            }

           

            p {
                font-weight: bold;
                font-size: 15px; /* Kích thước chữ cho h2 */
                color: #333;
                /* Thay đổi font chữ ở đây */
            }
            input[type="text"],
            input[type="tel"],
            input[type="number"],
            select {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            input[type="radio"] {
                margin-right: 10px;
            }
            button {
                background-color: #28a745;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
            }
            button:hover {
                background-color: #218838;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container2">
            <header>
                <h1>Thông tin đặt hàng</h1>
            </header>
            <form id="order-form" action="OrderServlet" method="post">
                <div class="customer-info">
                    <p>Thông tin khách mua hàng</p>
                    <label>
                        <input type="radio" name="gender" value="anh" checked> Anh
                    </label>
                    <label>
                        <input type="radio" name="gender" value="chi"> Chị
                    </label>
                    <label for="fullName">Họ tên:</label>
                    <input type="text" id="fullName" name="fullName" placeholder="Nhập họ tên" required>

                    <label for="phone">Số điện thoại:</label>
                    <input type="tel" id="phone" name="phone" placeholder="Nhập số điện thoại" required>
                </div>
                <div class="delivery-method">
                    <p>Chọn cách nhận hàng<p>
                    <label>
                        <input type="radio" name="delivery" value="tannoi" checked> Giao hàng tận nơi
                    </label>
                    <label for="city">Thành phố:</label>
                    <select id="city" name="city">
                        <option value="ha-noi">Hà Nội</option>
                        <option value="ho-chi-minh">TP Hồ Chí Minh</option>
                    </select>
                    <label for="district">Quận/Huyện:</label>
                    <select id="district" name="district">
                        <option value="quan-ba-dinh">Quận Ba Đình</option>
                        <option value="quan-1">Quận 1</option>
                    </select>
                    <label for="address">Số nhà, tên đường:</label>
                    <input type="text" id="address" name="address" placeholder="Số nhà, tên đường" required>
                </div>
                <div class="order-details">
                    <p>Thông tin đơn hàng</p>
                    <label for="quantity">Số lượng:</label>
                    <input type="number" id="quantity" name="quantity" placeholder="Số lượng" required>

                    <div class="shipping-options">
                        <p>Dịch vụ giao hàng</p>
                        <label>
                            <input type="radio" name="shipping" value="nhanh" checked> Giao hàng nhanh (2 - 4h)
                        </label>
                        <label>
                            <input type="radio" name="shipping" value="tieu-chuan"> Giao hàng tiêu chuẩn
                        </label>
                    </div>
                </div>
                <div class="total-price">
                    <h5>Tổng tiền: <span id="total">2.940.000đ</span></h5>
                    <button type="submit">Hoàn tất đơn hàng</button>
                </div>
            </form>
        </div>
    </body>
</html>
