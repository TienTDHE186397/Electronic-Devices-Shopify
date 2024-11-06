<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="css/styleFeedback.css">
        <title>FeedbackList</title>

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

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: #f0f2f5;
            padding: 20px;
        }

        .dashboard {
            max-width: 1200px;
            margin: 0 auto;
        }

        .header {
            background: white;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .date-picker {
            display: flex;
            gap: 20px;
            align-items: center;
            margin-top: 10px;
        }

        .date-picker input {
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 20px;
        }

        .stat-card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .stat-card h3 {
            color: #666;
            font-size: 14px;
            margin-bottom: 10px;
        }

        .stat-card .number {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }

        .trend {
            color: #28a745;
            font-size: 14px;
            margin-top: 5px;
        }

        .trend.negative {
            color: #dc3545;
        }

        .chart-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            /* Thêm max-height và overflow */
            max-height: 400px;
            overflow: auto;
        }

        .chart-wrapper {
            width: 100%;
            /* Bỏ position: relative và height cố định */
            margin-top: 10px;
        }

        /* Thêm style cho table */
        .chart-wrapper table {
            width: 100%;
            border-collapse: collapse;
        }

        .chart-wrapper table td,
        .chart-wrapper table th {
            padding: 10px;
        }

        /* Cố định header của bảng khi cuộn */
        .chart-wrapper table thead {
            position: sticky;
            top: 0;
            background: white;
            z-index: 1;
        }



    </style>
    <body>
        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">MKT WorkSpace</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
<<<<<<< HEAD
                    <a href="mktdashboard" >
=======
                    
                    <a href="mktdashboard">
>>>>>>> 0b6be8a00745b8b32ad85e25a4b913010e860ae0
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
                <li>
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
        <!-- Content -->
        <section id="content">
            <div class="dashboard">
                <form action="mktdashboard">
                    <div class="header">
                        <h1>Marketing Dashboard</h1>
                        <div id="f1">

                            <div class="date-picker">
                                <label>Từ ngày:</label>
                                <input type="date" name="fromdate" id="start-date" >
                                <label>Đến ngày:</label>
                                <input type="date" name="todate" id="end-date" >
                            </div>

                            <input type="submit" value="CHANGE">

                        </div>

                    </div>
                </form>
                <div class="stats-grid">
                    <div class="stat-card">
                        <h3>Tổng số bài đăng</h3>
                        <div class="number">${requestScope.listAllBlog.size()}</div>
                        <div class="trend">+12% so với tuần trước</div>
                    </div>
                    <div class="stat-card">
                        <h3>Sản phẩm mới</h3>
                        <div class="number">${requestScope.listAllProduct.size()}</div>
                        <div class="trend">+5% so với tuần trước</div>
                    </div>
                    <div class="stat-card">
                        <h3>Khách hàng mới</h3>
                        <div class="number">156</div>
                        <div class="trend negative">-3% so với tuần trước</div>
                    </div>
                    <div class="stat-card">
                        <h3>Phản hồi khách hàng</h3>
                        <div class="number">89</div>
                        <div class="trend">+18% so với tuần trước</div>
                    </div>
                </div>

                <div class="chart-container">
                    <h2>Bài Đăng Mới Thêm Hoặc Chỉnh Sửa Gần Đây</h2>
                    <div class="chart-wrapper">
                        <% int id = 0;%>
                        <table style="width: 100%">
                            <c:forEach items="${requestScope.listB}" var="b">
                                <%id++;%>
                                <tr>
                                    <td><%=id%></td> 
                                    <td>
                                        <img src="${b.blog_img}" width="100px" height="100px">
                                    </td> 
                                    <td>${b.blog_tittle}</td> 
                                    <td>${b.blog_update_time}</td> 
                                    <td>new</td> 
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <%id = 0;%>
                <div class="chart-container">
                    <h2>Sản Phẩm Mới Thêm Hoặc Chỉnh Sửa Gần Đây</h2>
                    <div class="chart-wrapper">
                        <table style="width: 100%">
                            <c:forEach items="${requestScope.listP}" var="p">
                                <%id++;%>
                                <tr>
                                    <td><%=id%></td> 
                                    <td>
                                        <img src="${p.img}" width="100px" height="100px">
                                    </td> 
                                    <td>${p.productName}</td>
                                    <td>${p.releaseDate}</td>
                                    <td>new</td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

                <div class="chart-container">
                    <h2>Phản Hồi Khách Hàng Gần Đây</h2>
                    <div class="chart-wrapper">
                        <table style="width: 100%">
                            <tr>
                                <td>1</td> 
                                <td>1</td> 
                                <td>1</td> 
                                <td>1</td> 
                                <td>1</td> 
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </section> 
        <script>
            const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
            allSideMenu.forEach(item => {
                const li = item.parentElement;
                item.addEventListener('click', function () {
                    allSideMenu.forEach(i => {
                        i.parentElement.classList.remove('active');
                    })
                    li.classList.add('active');
                })
            });
            const menuBar = document.querySelector('#content nav .bx.bx-menu');
            const sidebar = document.getElementById('sidebar');
            menuBar.addEventListener('click', function () {
                sidebar.classList.toggle('hide');
            })
            const searchButton = document.querySelector('#content nav form .form-input button');
            const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
            const searchForm = document.querySelector('#content nav form');
            searchButton.addEventListener('click', function (e) {
                if (window.innerWidth < 576) {
                    e.preventDefault();
                    searchForm.classList.toggle('show');
                    if (searchForm.classList.contains('show')) {
                        searchButtonIcon.classList.replace('bx-search', 'bx-x');
                    } else {
                        searchButtonIcon.classList.replace('bx-x', 'bx-search');
                    }
                }
            })
            if (window.innerWidth < 768) {
                sidebar.classList.add('hide');
            } else if (window.innerWidth > 576) {
                searchButtonIcon.classList.replace('bx-x', 'bx-search');
                searchForm.classList.remove('show');
            }
            window.addEventListener('resize', function () {
                if (this.innerWidth > 576) {
                    searchButtonIcon.classList.replace('bx-x', 'bx-search');
                    searchForm.classList.remove('show');
                }
            })

        </script>



    </body>
</html>
