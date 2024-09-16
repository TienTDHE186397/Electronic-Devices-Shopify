<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký thành công</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
        }
        .popup {
            width: 300px;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            font-size: 22px;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-size: 16px;
            margin-bottom: 10px;
            display: block;
            color: #555;
        }
        input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button, input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover, input[type="submit"]:hover {
            background-color: #45a049;
        }
        #timer {
            margin-bottom: 20px;
            font-size: 18px;
            color: #f00;
        }
        .button-container {
            display: flex;
            justify-content: space-around;
            width: 100%;
        }
        #resendButton {
            visibility: hidden; /* Initially hidden */
        }
    </style>
    <script>
        let timer;
        let timeLeft = 120;

        function startCountdown() {
            timer = setInterval(function() {
                if (timeLeft <= 0) {
                    clearInterval(timer);
                    document.getElementById("timer").innerHTML = "Thời gian đã hết. Gửi lại mã xác thực.";
                    document.getElementById("verificationCode").disabled = true; // Disable input
                    document.getElementById("resendButton").style.visibility = "visible"; // Show "Resend Code" button
                    document.getElementById("submitBtn").style.visibility = "hidden"; // Hide "Verify" button
                } else {
                    document.getElementById("timer").innerHTML = "Mã sẽ hết hạn sau " + timeLeft + " giây";
                }
                timeLeft -= 1;
            }, 1000);
        }

        function resendCode() {
            alert("Mã xác thực đã được gửi lại.");
            document.getElementById("resendButton").style.visibility = "hidden"; // Hide "Resend Code" button
            document.getElementById("submitBtn").style.visibility = "visible"; // Show "Verify" button
            document.getElementById("verificationCode").disabled = false; // Enable input
            document.getElementById("action").value = "resend"; // Set action to "resend"
            document.getElementById("verifyForm").submit(); // Submit the form to trigger resend
        }

        window.onload = function() {
            startCountdown(); // Start countdown when the page loads
        };
    </script>
</head>
<body>
    <div class="container">
        <div class="popup">
            <h2>Nhập mã xác thực</h2>
            <div id="timer"></div> <!-- Countdown timer will display here -->

            <form id="verifyForm" action="VerifyRePass" method="post">
                <input type="hidden" id="action" name="action" value="verify"> <!-- Default action -->
                <label for="verificationCode">Mã xác thực:</label>
                <input type="text" id="verificationCode" name="verificationCode2" required><br>
                <%
                    String message = (String) request.getAttribute("message");
                %>
                <h4><%= message != null ? message : "" %></h4>
                    <button type="submit" id="submitBtn" style="margin-right: 20px">Xác thực</button>
                    <button type="button" id="resendButton" onclick="resendCode()">Gửi lại mã</button>
                </div>
            </form>
        </div>
    </
