<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>Borrower's Slip</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            th, td {
                text-align: left;
                padding: 10px;
            }
            th {
                background-color: #3399ff;
                color: white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-9" style="margin-bottom: 20px">
                            <h3><strong>Borrower's Slip</strong></h3>
                            <form action="borrowdetail" method="post">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Tên Sách</th>
                                            <th>Hình Ảnh</th>
                                            <th>Tác Giả</th>
                                            <th>Số Lượng</th>
                                            <th style="width: 170px">Cập Nhật Số Lượng</th>
                                            <th style="text-align: center">Xóa</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                 
                                        <tr>
                                            <td>${pro.getProductName()}</td>
                                            <td><img style="width: 69px; height: 100px" src="${pro.getImg()}" alt="Book Image"></td>
                                            <td>${c.getBook().getAuthor()}</td>
                                            <td>
                                                <input style="width: 50px" type="number" name="amount_${pro.getProductID()}" value="${pro.getQuantity()}" min="1">
                                            </td>
                                            <td style="text-align: center"><button type="submit" class="btn btn-primary">Cập Nhật</button></td>
                                            <td style="text-align: center">
                                                <a href="remove?bookID=${pro.getProductID()}" class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                   
                                </tbody>
                            </table>
                        </form>
                       
                    </div>
                </div>
            </div>
        </section>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
