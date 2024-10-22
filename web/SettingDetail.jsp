<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Setting Detail</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to external CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: white;
            padding: 20px;
            margin-top: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"], select, textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            font-size: 18px;
            color: white;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Setting Detail</h2>
        
        <form>
            <c:set value="${requestScope.setting}" var="setting"/>
            <!-- Type -->
            <div class="form-group">
                <input type="hidden" name="id" value="${setting.ID}"/>
                <label for="type">Thể loại</label>
                <input type="text" id="type" name="type" value="${setting.type}" readonly>
            </div>
            
            <!-- Value -->
            <div class="form-group">
                <label for="value">Mô tả</label>
                <input type="text" id="value" name="value" value="${setting.value}" readonly>
            </div>
            
            <!-- Description -->
            <div class="form-group">
                <label for="image">Hình ảnh</label>
                <input type="text" id="image" name="image" value="${setting.image}" readonly>
            </div>
            
            
            <!-- Order -->
            <div class="form-group">
                <label for="order">Thứ tự</label>
                <input type="number" id="order" name="order" value="${setting.order}" readonly>
            </div>
            
            
            
            <!-- Status -->
            <div class="form-group">
                <label for="status">Trạng thái</label>
                <input type="text" id="status" name="status" value="${setting.status}" readonly>
            </div>
             
        </form>
            <button onclick="window.location.href = 'editSetting?id=${setting.ID}'">Edit</button>
        
        <!-- Back Link -->
        <a href="settingList" class="back-link">Back to Setting List</a>
    </div>
</body>
</html>
