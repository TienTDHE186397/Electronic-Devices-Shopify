<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="saleID" value="${session.saleID}" />
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>sale Home Employee</title>
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
                            <span class="title">HSDTech</span>
                        </a>

                    </li>

                    <li>
                        <a href="SaleHomeEmp?SaleID=${sessionScope.saleid}">
                            <span class="icon">
                                <ion-icon name="pie-chart-outline"></ion-icon></span>
                            <span class="title">Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <a href="SaleOrderEmp?SaleID=${sessionScope.saleid}">
                            <span class="icon">
                                <ion-icon name="pricetags-outline"></ion-icon></span>
                            <span class="title">Orders</span>
                        </a>
                    </li>

                    <li>
                        <a href="profile">
                            <span class="icon">
                                <ion-icon name="people-outline"></ion-icon>
                            </span>
                            <span class="title">Account information</span>
                        </a>   
                    </li>

                    <li>
                        <a href="home">
                            <span class="icon">
                                <ion-icon name="lock-closed-outline"></ion-icon>
                            </span>
                            <span class="title">Home Page</span>
                        </a>

                    </li>

                    <li>
                        <a href="./LogoutServlet">
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
                        <label>
                            <input type="text" placeholder="search here">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>

                    <div class="user">

                    </div>
                </div>   


                <!--==================Card==================-->
                 <div class="cardBox">
                    <a href="SaleOrderEmp?SaleID=${param.SaleID}" class="btn">
                        <div class="card">
                            <div>
                                <div class="numbers">${totalCount}</div>
                                <div class="cardName">Total Orders</div>
                            </div>

                            <div class="iconBox">
                                <ion-icon name="pricetags-outline"></ion-icon>
                            </div>
                        </div>
                    </a> 
                               
                
                <c:forEach var="status" items="${statusList}" varStatus="loop">
                    <div class="card">
                        <div>
                            <div class="numbers">
                                  ${countList[loop.index] != null ? countList[loop.index] : 0}
                            </div>
                            <div class="cardName">${status}</div>
                        </div>
                        <div class="iconBox">
                            <ion-icon name="${status == 'Complete' ? 'checkmark-outline' : 
                                              status == 'In Progress' ? 'reload-outline' : ''}"></ion-icon>
                        </div> 
                    </div>
                </c:forEach>               
            </div>

            <!--               ===============================Chart============================-->

            <div class="chartsBox">
                <div class="chart"><canvas id="myChart-1"></canvas></div>
                <div class="chart"><canvas id="myChart-2"></canvas></div>
            </div> 


            <!--======================================order List=====================================-->

            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Recent Orders</h2>
                        <a href="SaleOrderEmp?SaleID=${param.SaleID}" class="btn">View All</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>OrderID</td>
                                <td>Order Date</td>
                                <td>Customer Name</td>
                                <td>Total Money</td>
                                <td>Status</td>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${requestScope.data}" var="c">
                                <tr>
                                    <td>${c.orderID}</td>
                                    <td>${c.orderDate}</td>
                                    <td>${c.cusName}</td>
                                    <td><fmt:formatNumber value="${c.total}" type="number" pattern="#,##0"/></td>
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
                                </c:choose></td>
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


    <!--    =========================================chart Js============================-->
    <script>
        const statusList = <%= new Gson().toJson(request.getAttribute("statusList")) %>;
        const countList = <%= new Gson().toJson(request.getAttribute("countList")) %>;
        const ctx1 = document.getElementById("myChart-1").getContext("2d");
        const myChart = new Chart(ctx1, {
            type: "polarArea",
            data: {
                labels: statusList,
                datasets: [
                    {
                        label: "# of Votes",
                        data: countList,
                        backgroundColor: [
                            "rgba(127, 255, 0, 1 )",
                            "rgba(255, 206, 86, 1)",
                            "rgba(255, 99, 132, 1)",
                            "rgba(54, 162, 235, 1)"
                        ],
                    },
                ],
            },
            options: {
                responsive: true,
            },
        });

        const ctx2 = document.getElementById("myChart-2").getContext("2d");
        const orderData = [
            <c:forEach items="${ordersByDay}" var="order" varStatus="status">
                ${order.completedOrders}<c:if test="${!status.last}">,</c:if>
            </c:forEach>
            ];
        const dayLabels = [
            <c:forEach items="${ordersByDay}" var="order" varStatus="status">
            "${order.dayOfWeek}"<c:if test="${!status.last}">,</c:if>
            </c:forEach>
            ];
        const myChart2 = new Chart(ctx2, {
            type: "bar",
            data: {
                labels: dayLabels,
                datasets: [
                    {
                        label: "Order complete folow by Day of the week ",
                        data: orderData,
                        backgroundColor: [
                            "rgba(54, 162, 235, 1)"
                            

                        ],
                    },
                ],
            },
            options: {
                responsive: true,
            },
        });

    </script>




    <!--    ==========================Chart===========================-->


    <!--<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>-->

    <!--==========ionicons==========-->

    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>
