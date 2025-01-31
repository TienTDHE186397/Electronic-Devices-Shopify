<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="loginform/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Quên Mật Khẩu</title>
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
                width: 60%;
                height: 50%;
            }
            .form-container {
                width: 300px;
                padding: 20px;
                background-color: white;
                box-shadow: 0 20px 20px rgba(0, 0, 0, 0.1);
                text-align: center;
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            h1 {
                font-size: 22px;
                margin-top:  20px;
                color: #333;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <h1>Quên Mật Khẩu</h1>
                <form action="ForgotPassword" method="post">
                    <input type="email" name="email" placeholder="Nhập email để xác thực" required>
                    <button type="submit" style="background-color:  #b22222" >Xác nhận</button>
                </form>
                <% 
                    String errorMessage = (String) request.getAttribute("error");
                %>
                <div class="message">
                    <%= errorMessage != null ? errorMessage : "" %>
                </div>

            </div>
        </div>
    </body>

</html>
