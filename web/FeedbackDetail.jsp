<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="css/styleFeedbackDetail.css">

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
                    <a href="#">
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
                            <div class="container">
                                <h1>FeedBack Detail</h1>
                            <div class="feedback-detail">
                                <label for="fullname">Họ tên:</label>
                                <input type="text" id="fullname" value="Nguyễn Văn A" readonly>

                                <label for="email">Email:</label>
                                <input type="email" id="email" value="nguyenvana@email.com" readonly>

                                <label for="mobile">Số điện thoại:</label>
                                <input type="text" id="mobile" value="0123456789" readonly>

                                <label for="product">Sản phẩm:</label>
                                <input type="text" id="product" value="Laptop XYZ" readonly>

                                <label for="rating">Đánh giá:</label>
                                <div class="star-rating">★★★★☆</div>

                                <label for="feedback">Nội dung phản hồi:</label>
                                <textarea id="feedback" rows="4" readonly>Sản phẩm tốt, nhưng pin không được lâu như mong đợi.</textarea>

                                <label>Hình ảnh:</label>
                                <img src="/api/placeholder/400/200" alt="Hình ảnh phản hồi" class="image-preview">

                                <label>Video:</label>
                                <video src="#" controls class="video-preview">Trình duyệt của bạn không hỗ trợ tag video.</video>

                                <label for="reply">Phản hồi của nhà cung cấp:</label>
                                <textarea id="reply" rows="4">Cảm ơn bạn đã phản hồi. Chúng tôi sẽ xem xét vấn đề pin trong các phiên bản tiếp theo.</textarea>

                                <label for="customer-feedback">Phản hồi của khách hàng:</label>
                                <textarea id="customer-feedback" rows="4" readonly>Cảm ơn bạn đã lắng nghe ý kiến của tôi.</textarea>
                            </div>

                            <div class="status-change">
                                <label for="status">Thay đổi trạng thái:</label>
                                <select id="status">
                                    <option value="new">Mới</option>
                                    <option value="processing">Đang xử lý</option>
                                    <option value="resolved">Đã giải quyết</option>
                                    <option value="closed">Đã đóng</option>
                                </select>
                                <button class="btn" onclick="updateStatus()">Cập nhật trạng thái</button>
                            </div>
                            </div>
                            
                        </div>

                        
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



            const switchMode = document.getElementById('switch-mode');

            switchMode.addEventListener('change', function () {
                if (this.checked) {
                    document.body.classList.add('dark');
                } else {
                    document.body.classList.remove('dark');
                }
            })

        </script>
    </body>
</html>
