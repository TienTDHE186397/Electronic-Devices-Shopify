<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>sale Home Manager</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- =============Style css ======================== -->
        <link rel="stylesheet" type="text/css" href="css/styleSaleManager.css">
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
                        <a href="SaleHomeManager.jsp">
                            <span class="icon">
                                <ion-icon name="pie-chart-outline"></ion-icon></span>
                            <span class="title">Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <a href="SaleOrderManager.jsp">
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
                    <div class="card">
                        <div>
                            <div class="numbers">1000</div>
                            <div class="cardName">Order complete</div>
                        </div>
                        <div class="iconBox">
                            <ion-icon name="checkmark-outline"></ion-icon>
                        </div> 
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">1000</div>
                            <div class="cardName">Order Inprogress</div>
                        </div>
                        <div class="iconBox">
                            <ion-icon name="reload-outline"></ion-icon>
                        </div> 
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">1000</div>
                            <div class="cardName">Unprocessed orders</div>
                        </div>
                        <div class="iconBox">
                            <ion-icon name="close-circle-outline"></ion-icon>
                        </div> 
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">1000</div>
                            <div class="cardName">Total Order</div>
                        </div>
                        <div class="iconBox">
                            <ion-icon name="cart-outline"></ion-icon>
                        </div> 
                    </div>
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
                            <a href="SaleOrder.jsp" class="btn">View All</a>
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <td>Name</td>
                                    <td>Price</td>
                                    <td>Payment</td>
                                    <td>Status</td>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Star Refrigerator</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status delivered">Delivered</span></td>
                                </tr>

                                <tr>
                                    <td>Dell Laptop</td>
                                    <td>$110</td>
                                    <td>Due</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>

                                <tr>
                                    <td>Apple Watch</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status unprocessed">unprocessed</span></td>
                                </tr>

                                <tr>
                                    <td>Addidas Shoes</td>
                                    <td>$620</td>
                                    <td>Due</td>
                                    <td><span class="status inProgress">In Progress</span></td>
                                </tr>

                                <tr>
                                    <td>Star Refrigerator</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status delivered">Delivered</span></td>
                                </tr>

                                <tr>
                                    <td>Dell Laptop</td>
                                    <td>$110</td>
                                    <td>Due</td>
                                    <td><span class="status pending">Pending</span></td>
                                </tr>

                                <tr>
                                    <td>Apple Watch</td>
                                    <td>$1200</td>
                                    <td>Paid</td>
                                    <td><span class="status return">Return</span></td>
                                </tr>

                                <tr>
                                    <td>Addidas Shoes</td>
                                    <td>$620</td>
                                    <td>Due</td>
                                    <td><span class="status inProgress">In Progress</span></td>
                                </tr>
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
            const ctx1 = document.getElementById("myChart-1").getContext("2d");
            const myChart = new Chart(ctx1, {
                type: "polarArea",
                data: {
                    labels: ["Order complete", "Order Inprogress", "Unprocessed orders", "Total Order"],
                    datasets: [
                        {
                            label: "# of Votes",
                            data: [600, 800, 1000, 1000],
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
            const myChart2 = new Chart(ctx2, {
                type: "bar",
                data: {
                    labels: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
                    datasets: [
                        {
                            label: "Order complete folow by Day of the week ",
                            data: [600, 700, 450, 200, 100, 300, 100],
                            backgroundColor: [
                                "rgba(54, 162, 235, 1)",
                                "rgba(54, 162, 235, 1)",
                                "rgba(54, 162, 235, 1)",
                                "rgba(54, 162, 235, 1)",
                                "rgba(54, 162, 235, 1)",
                                "rgba(54, 162, 235, 1)",
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
