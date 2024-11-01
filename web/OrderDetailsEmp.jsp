<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="saleID" value="${sessionScope.saleid}" />
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
                 <h1>Order Details</h1>

                <div class="order-section">
                    <h2>Basic Order Information</h2>

                    <c:forEach var="order" items="${requestScope.orderDetails}">
                        <div class="order-section">
                            <h2>Order Information</h2>
                            <div class="order-info">
                                <p><strong>Order ID:</strong> ${order.orderID}</p>
                                <p><strong>Customer Name:</strong> ${order.cusName}</p>
                                <p><strong>Email:</strong> ${order.email}</p>
                                <p><strong>Mobile:</strong> ${order.mobile}</p>
                                <p><strong>Order Date:</strong> ${order.orderDate}</p>
                                <p><strong>Total Cost:</strong> <fmt:formatNumber value="${order.total}" type="number" pattern="#,##0"/></p>
                                <p><strong>Sale Name:</strong> ${order.saleName}</p>
                                <p><strong>Status:</strong> ${order.status}</p>
                                <p><strong>ShipStatus</strong> ${order.shipstatus}</p>
                            </div>
                        </div>

                    </div>

                    <div class="order-section">
                        <h2>Receiver Information</h2>
                        <div class="receiver-info">
                            <p><strong>Full Name:</strong> ${order.cusName}</span></p>
                            <p><strong>Gender:</strong> ${order.gender}</p>
                            <p><strong>Email:</strong>  ${order.email}</p>
                            <p><strong>Mobile:</strong> ${order.mobile}</p>
                            <p><strong>Address:</strong> ${order.address}</p>
                        </div>
                    </div>
                </c:forEach>
                <div class="order-section">
                    <h2>Ordered Products</h2>
                    <c:set var="list" value="${requestScope.orderProducts}"/>
                    <c:if test="${(list == null || (list.size()==0))}">
                        <h3>No Products Exist</h3>
                    </c:if>
                    <table class="product-list">
                        <thead>
                            <tr>
                                <th>Thumbnail</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Unit Price</th>
                                <th>Quantity</th>
                                <th>Total Cost</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pder" items="${requestScope.orderProducts}">

                                <tr>
                                    <td><img src="${pder.img}" width="100px" height="100px"/></td>
                                    <td>${pder.name}</td>
                                    <td>${pder.category}</td>
                                    <td><fmt:formatNumber value="${pder.unitprice}" type="number" pattern="#,##0"/></td>
                                    <td>${pder.quantity}</td>
                                    <td><fmt:formatNumber value="${pder.totalCost}" type="number" pattern="#,##0"/></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
  <div class="order-section status-section">
    <h2>Update Order</h2>
    <form action="OrderDetailsEmp" method="post" >
       <c:forEach var="c" items="${requestScope.upList}">
           <input type="hidden" name="orderID" value="${c.orderID}" />
           <input type="hidden" name="saleID" value="${c.saleID}" />
            
            <div>
                <label for="Status-${c.orderID}">Status:</label>
                <select id="status-${c.orderID}" name="statusUpdate">
                    <option value="Complete" ${c.status == 'Complete' ? 'selected' : ''}>Complete</option>
                    <option value="In Line" ${c.status == 'In Line' ? 'selected' : ''}>In Line</option>
                    <option value="In Progress" ${c.status == 'In Progress' ? 'selected' : ''}>In Progress</option>
                </select>
            </div>
            <div>
                <label for="shipstatus">Status:</label>
                <select id="shipstatus-${c.orderID}" name="shipUpdate" >
                     <option value="OrderNotComplete" ${c.shipstatus == 'OrderNotComplete' ? 'selected' : ''}>đơn hàng chưa được xử lý</option>
                    <option value="Exproted" ${c.shipstatus == 'Exproted' ? 'selected' : ''}>đã xuất kho</option>
                    <option value="InDelivery" ${c.shipstatus == 'InDelivery' ? 'selected' : ''}>đang giao hàng</option>
                    <option value="Delivered" ${c.shipstatus == 'Delivered' ? 'selected' : ''}>đã giao hàng</option>
                    <option value="received" ${c.shipstatus == 'received' ? 'selected' : ''}>đã nhận hàng</option>
                </select>
            </div>
            
             <div>
            <label for="saleNotes-${c.orderID}">Sale Notes:</label>
            <textarea id="saleNotes-${c.orderID}" rows="4" name="saleNotes">${c.saleNotes}</textarea>
             </div>
            
            <div>
                  
                <label for="salePerson-${c.orderID}}">Assigned Sale:</label>
                <input type="hidden" value="${Sale}" name="salePerson" />
                <input type="text" value="${c.saleID}" readonly/>
                
            </div>
        </c:forEach>
        
        <button type="submit">Update Order</button>
    </form>
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
