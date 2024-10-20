
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

        <title>AdminHub</title>
    </head>
    <body>


        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">MKT WorkSpace</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="mktdashboard">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Products</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Slider</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-message-dots' ></i>
                        <span class="text">Feedback</span>
                    </a>
                </li>
                <li>
                    <a href="#">
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
                        <input type="search" placeholder="Search...">
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
                                <select id="statusFilter">
                                    <option value="new">new</option>
                                    <option value="processed">processed</option>
                                    <option value="ignored">ignored</option>
                                </select>
                                <h3>Categories</h3>
                                <select id="productFilter">
                                    <option value="Phone-Tablet">Phone-Tablet</option>
                                    <option value="Laptop">Laptop</option>
                                    <option value="PC">PC</option>
                                    <option value="Monitor">Monitor</option>
                                    <option value="Earphone">Earphone</option>
                                </select>
                                <h3>Rated_star</h3>
                                <select id="ratingFilter">

                                    <option value="5">5 star</option>
                                    <option value="4">4 star</option>
                                    <option value="3">3 star</option>
                                    <option value="2">2 star</option>
                                    <option value="1">1 star</option>
                                </select>
                            </div>        
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>User</th>
                                    <th>Product Name</th>
                                    <th>Rated star</th>
                                    <th>status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
<!--                                    <td>
                                        <img src="img/people.png">
                                        <p>John Doe</p>
                                    </td>-->
                                    <td>Laptop</td>
                                    <td>
                                        <div class="star-rating" data-rating="4">
                                            <span class="filled">☆</span>
                                            <span class="filled">☆</span>
                                            <span>☆</span>
                                            <span>☆</span>
                                            <span>☆</span>
                                        </div>
                                    </td>
                                    <td><span class="status completed">new</span></td>
                                </tr>
                               
                                </tr>
                            </tbody>
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
