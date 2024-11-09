<%-- 
    Document   : CustomerList
    Created on : Oct 24, 2024, 10:17:26 PM
    Author     : nghie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="css/styleCustomer.css">
        <title>Customer List</title>
    </head>
    <style>



        #pagination-controls {
            margin-top: 20px;
        }
        #rowsPerPage {
            width: 60px;
            margin-right: 10px;
        }
        #pagination-buttons button {
            margin: 0 5px;
            padding: 5px 10px;
            cursor: pointer;
        }
        #pagination-buttons button.active {
            font-weight: bold;
            background-color: #007bff;
            color: white;
        }

        .search-form {
            margin-bottom: 20px; /* Thêm khoảng cách giữa form và bảng */
        }

        .search-form form {
            width: 100%;
            display: flex;
            align-items: center;
            gap: 10px; /* Khoảng cách giữa các input */
        }

        form input[type="text"], form select {
            padding: 10px;
            width: 30%;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        form input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

    </style>
    <body>
        <!-- SIDEBAR -->
         <section id="sidebar">
            <a href="mktdashboard" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">MKT WorkSpace</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="#">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="ProductMKT">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Products</span>
                    </a>
                </li>
                <li>
                    <a href="SliderListMKT">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Slider</span>
                    </a>
                </li>
                <li>
                    <a href="FeedbackList">
                        <i class='bx bxs-message-dots' ></i>
                        <span class="text">Feedback</span>
                    </a>
                </li>
                
                <li>
                    <a href="PostListMKT">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Post</span>
                    </a>
                </li>
                <li class="active">
                    <a href="customerList">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Customer List</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                </li>
                <li>
                    <a href="./LogoutServlet" class="logout">
                        <i class='bx bxs-log-out-circle' ></i>
                        <span class="text">Logout</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- SIDEBAR -->



        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu' ></i>

                <form action="#">
                    <div class="form-input">
                        <input type="search" id="searchInput" placeholder="Search...">
                        <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
                    </div>
                </form>

            </nav>
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Customer</h1>

                    </div>
                </div>


                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Customer List</h3>
                            
                            <div class="filter">

                                <form id="searchForm" method="GET" action="customerControl">
                                    <input type="text" name="search" placeholder="Tìm kiếm theo tên, email, di động" value="${param.search}" />
                                    <select name="gender" id="gender">
                                        <option value="">Chọn giới tính</option>
                                        <option value="Nam" ${param.gender == 'Nam' ? 'selected' : ''}>Nam</option>
                                        <option value="Nữ" ${param.gender == 'Nữ' ? 'selected' : ''}>Nữ</option>
                                        <option value="Khác" ${param.gender == 'Khác' ? 'selected' : ''}>Khác</option>
                                    </select>
                                    <select name="roleid" id="roleid">
                                        <option value="">Chọn vai trò</option>
                                        <option value="1" ${param.roleid == '1' ? 'selected' : ''}>Customer</option>
                                        <option value="2" ${param.roleid == '2' ? 'selected' : ''}>Marketing</option>
                                        <option value="3" ${param.roleid == '3' ? 'selected' : ''}>Sale</option>
                                        <option value="4" ${param.roleid == '4' ? 'selected' : ''}>SaleManager</option>
                                        <option value="5" ${param.roleid == '5' ? 'selected' : ''}>Admin</option>
                                    </select>
<!--                                            <input type="submit" value="Tìm kiếm" />-->
                                </form>
                                    
                                    <input id="submit" style="padding: 10px 20px;
                                   background-color: #007bff;
                                   color: white;
                                   border: none;
                                   border-radius: 4px;
                                   cursor: pointer;" type="submit" value="Tìm kiếm" />
                                    
                            </div>
                            <!--                            <div id="pagination-controls">
                                                            <label for="rowsPerPage">Number of row:</label>
                                                            <input type="number" id="rowsPerPage" min="1" value="10">
                                                            <div id="pagination-buttons"></div>
                                                        </div>-->

                        </div>

                        <table id="">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Customer Name</th>
                                    <th>Gender</th>
                                    <th>Date Of Birth</th>
                                    <th>Address</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>


                                <c:forEach var="person" items="${listC}">
                                    <c:if test="${person.roleID == 1}">
                                        <tr>
                                            <td>${person.personID}</td>
                                            <td>${person.name}</td> 
                                            <td>${person.gender}</td> 
                                            <td>${person.dateOfBirth}</td>
                                            <td>${person.address}</td>
                                            <td>${person.email}</td>
                                            <td>${person.phone}</td>
                                            <td>
                                                <a href="customer-detail?id=${person.personID}" class="btn-details">Details</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>

                        </table>

                    </div>

                </div>
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->
        
        <script>
    // Khi nút được nhấn, submit form
    document.getElementById("submit").onclick = function() {
        document.getElementById("searchForm").submit();
    }
</script>
        
    </body>
</html>
