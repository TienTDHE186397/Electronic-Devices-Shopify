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
</style>
    <body>


        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">MKT WorkSpace</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="mktdashboard">
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
                <li class="active">
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
            </ul>
            <ul class="side-menu">
                </li>
                <li>
                    <a href="#" class="logout">
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
                        <h1>FeedBack</h1>

                    </div>
                </div>



                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Feedback List</h3>
                            <div class="filter">

                                <h3>Status</h3>
                                <select id="statusFilter" class="table-filter">
                                    <option value="all">Tất cả</option>
                                    <option value="New">New</option>
                                    <option value="Resolved">Resolved</option>
                                </select>

                                <h3>Rated_star</h3>
                                <select id="ratingFilter" name="ratingFilter"> 
                                    <option value="all">Tất cả</option>
                                    <option value="5">5 star</option>
                                    <option value="4">4 star</option>
                                    <option value="3">3 star</option>
                                    <option value="2">2 star</option>
                                    <option value="1">1 star</option>
                                </select>
                            </div>
                            <div id="pagination-controls">
                                <label for="rowsPerPage">Number of row:</label>
                                <input type="number" id="rowsPerPage" min="1" value="10">
                                <div id="pagination-buttons"></div>
                            </div>

                        </div>

                        <table id="feedback-table">
                            <thead>
                                <tr>
                                    <th>FID</th>
                                    <th>Product Name</th>
                                    <th>Customer Name</th>
                                    <th>Rate</th>
                                    <th>Created Date</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <c:forEach var="c" items="${requestScope.fList}">
                                <tbody >
                                    <tr>
                                        <td>${c.feedbackID}</td>
                                        <td>${c.proName}</td> 
                                        <td>${c.cusName}</td> 
                                        <td>
                                            <div class="star-rating">
                                                <c:forEach begin="1" end="5" var="i">
                                                    <span ${i <= c.rate ? 'class="filled"' : ''}>☆</span>
                                                </c:forEach>
                                            </div>
                                        </td>
                                        <td>${c.createDate}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${c.status == 'New'}">
                                                    ${c.status}</span
                                                </c:when>
                                                <c:when test="${c.status == 'Resolved'}">
                                                    ${c.status}
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status unknown">${c.status}</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                              <a href="FeedbackDetails?feedbackID=${c.feedbackID}" class="btn-details">Details</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>

                        </table>

                    </div>

                </div>
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->


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




// TOGGLE SIDEBAR
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
