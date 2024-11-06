<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        .error-container {
            width: 80%;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ff0000;
            border-radius: 5px;
            background-color: #fff5f5;
        }
        .error-message {
            color: #ff0000;
            font-weight: bold;
        }
        .back-link {
            margin-top: 20px;
            display: block;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h2>Error Occurred</h2>
        <div class="error-message">
            <%= request.getAttribute("error") != null ? 
                request.getAttribute("error") : "An unknown error occurred" %>
        </div>
        <a href="javascript:history.back()" class="back-link">Go Back</a>
    </div>
</body>
</html>