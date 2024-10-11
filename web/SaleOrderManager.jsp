<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>sale Order Manager</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- =============Style css ======================== -->
        <link rel="stylesheet" type="text/css" href="css/styleSaleManager.css">

    </head>

    <body>
        <!--==============================Navigation==================================-->
        <div class="container">
            <div class="navigation">
                <ul>
                    <li>
                        <a href="#">
                            <span class="icon">
                                <ion-icon name="laptop-outline"></ion-icon>
                            </span>
                            <span class="title">Webdientu</span>
                        </a>

                    </li>

                    <li>
                        <a href="SaleHomeManager">
                            <span class="icon">
                                <ion-icon name="pie-chart-outline"></ion-icon></span>
                            <span class="title">Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <a href="SaleOrderManager">
                            <span class="icon">
                                <ion-icon name="pricetags-outline"></ion-icon></span>
                            <span class="title">Orders</span>
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <span class="icon">
                                <ion-icon name="people-outline"></ion-icon>
                            </span>
                            <span class="title">Account information</span>
                        </a>   
                    </li>

                    <li>
                        <a href="#">
                            <span class="icon">
                                <ion-icon name="lock-closed-outline"></ion-icon>
                            </span>
                            <span class="title">Change Password</span>
                        </a>

                    </li>

                    <li>
                        <a href="#">
                            <span class="icon">
                                <ion-icon name="log-out-outline"></ion-icon>
                            </span>
                            <span class="title">Log Out</span>
                        </a>
                    </li>
                </ul>
            </div>

            <!--====================Main=========================-->
            <div class="main">
                <div class="topbar">
                    <div class="toggle">
                        <ion-icon name="reorder-four-outline"></ion-icon>
                    </div>

                    <div class="search">
                        <form action="SaleOrderManager" method="GET">
                            <label> 
                                <input type="text" name="searchQuery" placeholder="search here">
                                <ion-icon name="search-outline"></ion-icon>
                            </label>
                        </form>
                    </div>

                    <div class="user">

                    </div>
                </div>   


                <!--==================Card==================-->
                <div class="cardBox">
                    <a href="SaleOrderManager" class="btn">
                        <div a href="SaleOrderManager" class="card">

                            <div>
                                <div class="numbers">${totalOrderCount}</div>
                                <div class="cardName">Total Orders</div>
                            </div>

                            <div class="iconBox">
                                <ion-icon name="pricetags-outline"></ion-icon>
                            </div>
                        </div>
                    </a>

                    <c:forEach var="status" items="${statusOrderList}" varStatus="loop">
                        <a href="SaleOrderManager?status=${status}" class="btn">
                            <div class="card">
                                <div>
                                    <div class="numbers">${countOrderList[loop.index]}</div>
                                    <div class="cardName">${status}</div>
                                </div>
                                <div class="iconBox">
                                    <ion-icon name="${status == 'Complete' ? 'checkmark-outline' : 
                                                      status == 'In Progress' ? 'reload-outline' : 
                                                      status == 'In Line' ? 'close-circle-outline' : ''}"></ion-icon>
                                </div> 
                            </div>
                        </a>
                    </c:forEach>               
                </div>




                <!--======================================order List=====================================-->

                <div class="details">
                    <div class="recentOrders">
                        <div class="cardHeader">
                            <h2>Recent Orders</h2>
                            <!--                            <a href="SaleOrderManager" class="btn">View All</a>-->
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <td>OrderID</td>
                                    <td>Order Date</td>
                                    <td>Customer Name</td>
                                    <td>ShowRoomName</td>
                                    <td>Total Money</td>
                                    <td>Method</td>
                                    <td>SaleName</td>
                                    <td>Status</td>
                                    <td>Actions</td>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${requestScope.dataList}" var="c">
                                    <tr>
                                        <td>${c.orderID}</td>
                                        <td>${c.orderDate}</td>
                                        <td>${c.cusName}</td>
                                        <td>${c.showRoomID}</td>
                                        <td><fmt:formatNumber value="${c.total}" type="number" pattern="#,##0"/></td>
                                        <td>${c.method}</td>
                                        <td>${c.saleName}</td>
                                        <td> <c:choose>
                                                <c:when test="${c.status == 'Complete'}">
                                                    <span class="status Complete">${c.status}</span>
                                                </c:when>
                                                <c:when test="${c.status == 'In Line'}">
                                                    <span class="status inline">${c.status}</span>
                                                </c:when>
                                                <c:when test="${c.status == 'In Progress'}">
                                                    <span class="status inProgress">${c.status}</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status unknown">${c.status}</span> 
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="OrderDetails?orderID=${c.orderID}" class="btn-details">Details</a>
                                            <button onclick="showAssignPopup(${c.orderID})" class="btn-assign">Assign</button>
                                            <button class="btn-submit">Submit</button>

                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div> 
                </div>
                <div id="assignPopup" class="popup">
                    <div class="popup-content">
                        <span class="close" onclick="closeAssignPopup()">&times;</span>
                        <h2>Assign Order to Sales Representative</h2>
                        <table id="salesTable">
                            <thead>
                                <tr>
                                    <th>Sale ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                            </tbody>
                        </table>



                    </div>
                </div>
                </div>
               </div>




                <!--=========================Script navigation=======================-->
                <script>
                    let list = document.querySelectorAll(".navigation li");

                    function activeLink() {
                        list.forEach((item) => {
                            item.classList.remove("hovered");
                        });
                        this.classList.add("hovered");
                    }

                    list.forEach((item) => item.addEventListener("mouseover", activeLink));

                    //menu toggle

                    let toggle = document.querySelector(".toggle");
                    let navigation = document.querySelector(".navigation");
                    let main = document.querySelector(".main");

                    toggle.onclick = function () {
                        navigation.classList.toggle("active");
                        main.classList.toggle("active");
                    };

                </script>
                








                <!--==========ionicons==========-->

                <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
                <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

                </body>
                </html>
