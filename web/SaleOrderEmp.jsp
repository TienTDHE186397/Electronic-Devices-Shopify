<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="saleID" value="${param.SaleID}" />
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>sale Order Employee</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- =============Style css ======================== -->
        <link rel="stylesheet" type="text/css" href="css/styleSale.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                        <a href="SaleHomeEmp?SaleID=${param.SaleID}">
                            <span class="icon">
                                <ion-icon name="pie-chart-outline"></ion-icon></span>
                            <span class="title">Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <a href="SaleOrderEmp?SaleID=${param.SaleID}">
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

                      
                        <c:if test="${saleID != null}">
                            
                        <form action="SaleOrderEmp" method="GET">
                            <input type="hidden" name="SaleID" value="${SaleID}" />
                            <label> 
                                
                                <input type="text" name="searchQuery" placeholder="search here">
                                <ion-icon name="search-outline"></ion-icon>
                            </label>
                        </form>
                     </c:if>
                    </div>

                    <div class="user">

                    </div>
                </div>   

                <!--==================Card==================-->
                 <div class="cardBox">
                    <a href="SaleOrderEmp?SaleID=${param.SaleID}" class="btn">
                        <div class="card">
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
                        <a href="SaleOrderEmp?status=${status}&SaleID=${param.SaleID}" class="btn">
                            <div class="card">
                                <div>
                                    <div class="numbers">
                                        ${countOrderList[loop.index]}
                                    </div>
                                    <div class="cardName">${status}</div>
                                </div>
                                <div class="iconBox">
                                    <ion-icon name="${status == 'Complete' ? 'checkmark-outline' : 
                                                      status == 'In Progress' ? 'reload-outline' : ''}"></ion-icon>
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
                                    <button class="btn-submit">Submit</button>
                                </td>
                                </tr>
                            </c:forEach>
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
