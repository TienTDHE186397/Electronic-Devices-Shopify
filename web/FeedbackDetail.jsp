<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="css/styleFeedbackDetail.css">
        <script src="https://cdn.tiny.cloud/1/qnmf6c0u3j7wk6wsljsqwke06htozhifzb9v9fs3pw2ed7vx/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>

        <title>AdminHub</title>
        <style>
    .media-container {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
        gap: 1rem;
        padding: 1rem;
    }

    .media-item {
        position: relative;
        cursor: pointer;
    }

    .media-item img {
        max-width: 100%;
        height: auto;
    }

    .media-item video {
        max-width: 100%;
        height: auto;
    }

    .lightbox {
        display: none;
        position: fixed;
        z-index: 1000;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.9);
        
        align-items: center;
        justify-content: center;
        padding: 2rem;
    }

    .lightbox-content {
        position: relative;
        max-width: 90%;
        height:  90vh;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: auto;
    }

    .lightbox-close {
        position: absolute;
        right: 20px;
        top: 20px;
        color: white;
        font-size: 30px;
        cursor: pointer;
        z-index: 100;
    }

    .video-container {
        position: relative;
        width: 100%;
        padding-top: 56.25%; 
    }

    .video-container video {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }

</style>

    </head>
    <body>


        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="mktdashboard" class="brand">
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
                        <h1>FeedBack Details</h1>

                    </div>
                </div>



                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <c:forEach var="c" items="${requestScope.fList}">
                                <div class="container">
                                    <h1>FeedBack Detail</h1>
                                    <div class="feedback-detail">

                                        <label for="fullname">Họ tên:</label>
                                        <input type="text" id="fullname" value="${c.cusName}" readonly>

                                        <label for="email">Email:</label>
                                        <input type="email" id="email" value="${c.email}" readonly>

                                        <label for="mobile">Số điện thoại:</label>
                                        <input type="text" id="mobile" value="${c.phoneNumber}" readonly>

                                        <label for="product">Sản phẩm:</label>
                                        <input type="text" id="product" value="${c.proName}" readonly>

                                        <label for="rating">Đánh giá:</label>
                                        <div class="star-rating">
                                            <c:forEach begin="1" end="5" var="i">
                                                <span ${i <= c.rate ? 'class="filled"' : ''}>☆</span>
                                            </c:forEach>
                                        </div>

                                        <label for="feedback">Nội dung phản hồi:</label>
                                        <textarea id="feedback" rows="4" readonly>${c.feedContent}</textarea>

                                        <div class="media-container">
                                            <c:forEach items="${requestScope.mediaList}" var="media">
                                                <div class="media-item">
                                                    <c:choose>
                                                        <%-- Nếu là ảnh --%>
                                                        <c:when test="${media.fileType == 'image'}">
                                                            <img src="${media.filePath}" 
                                                                 alt="${media.originalFileName}"
                                                                 onclick="openLightbox('${media.filePath}', 'image')">
                                                        </c:when>
                                                        <%-- Nếu là video --%>
                                                        <c:when test="${media.fileType == 'video'}">
                                                            <div class="video-container">
                                                                <video onclick="openLightbox('${media.filePath}', 'video')" 
                                                                       preload="metadata"
                                                                       >
                                                                    <source src="${media.filePath}" 
                                                                            type="${media.contentType != null ? media.contentType : 'video/mp4'}">
                                                                    Your browser does not support the video tag.
                                                                </video>

                                                            </div>
                                                        </c:when>
                                                    </c:choose>
                                                </div>
                                            </c:forEach>
                                        </div>

                                        <div id="lightbox" class="lightbox">
                                            <span class="lightbox-close" onclick="closeLightbox()">&times;</span>
                                            <div id="lightbox-content" class="lightbox-content"></div>
                                        </div>




                                    </div>
                                    <form method="post" action="FeedbackDetail">
                                        <input type="hidden" name="feedbackID" value="${c.feedbackID}" />
                                        <div class="status-change">
                                           <label for="${status.index}">Status:</label>
                                            <select id="${status.index}" name="statusUpdate">
                                                <option value="New" ${c.status == 'New' ? 'selected' : ''}>New</option>
                                                <option value="Processing" ${c.status == 'Processing' ? 'selected' : ''}>Processing</option>
                                                <option value="Resolved" ${c.status == 'Resolved' ? 'selected' : ''}>Resolved</option>

                                            </select>
                                            <label for="${status.index}">Processed By:</label>
                                            <select id="${status.index}" name="feedbackPerson" >
                                                <c:choose>
                                                    <c:when test="${c.mktEmp != null}" >
                                                        <!-- Hiển thị tên người xử lý nếu đã có -->
                                                        <option value="${c.mktID}">${c.mktEmp}</option>
                                                        
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!-- Nếu chưa có người xử lý, hiển thị tất cả nhân viên -->
                                                        <option value="">Select your Name</option>
                                                        <c:forEach var="person" items="${requestScope.mList}">
                                                            <option value="${person.personID}">${person.name}</option> 
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                            <input type="hidden" name="feedbackPersonHidden" id="feedbackPersonHidden" value="${c.mktID != null ? c.mktID : ''}"/>
                                            <button class="btn" type="submit">Cập nhật trạng thái</button>
                                            <a href="FeedbackList" class="btn">Trở về trang FeedbackList</a>
                                        </div>
                                    </form>  
                                </div>
                            </c:forEach>

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
            });







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
            });





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
            });




        </script>
        <script>
            tinymce.init({
                selector: '.tinymce',
                plugins: 'advlist autolink lists link image charmap print preview hr anchor pagebreak media',
                toolbar_mode: 'floating'
            });
        </script>
        <script>
function openLightbox(src, type) {
    var lightbox = document.getElementById("lightbox");
    var lightboxContent = document.getElementById("lightbox-content");
    
    if (type === 'image') {
        lightboxContent.innerHTML = '<img src="' + src + '" style="max-width: 100%; max-height: 90vh;">';
    } else if (type === 'video') {
        lightboxContent.innerHTML = '<video width="70%" height="70%" controls autoplay>' +
            '<source src="' + src + '" type="video/mp4">' +
            'Your browser does not support the video tag.</video>';
    }
    
    lightbox.style.display = "block";
}

function closeLightbox() {
    var lightbox = document.getElementById("lightbox");
    lightbox.style.display = "none";
}
</script>
   <script>
    document.getElementById("feedbackForm").addEventListener("submit", function(event) {
        // Lấy giá trị của feedbackPerson
        const feedbackPersonSelect = document.querySelector("select[name='feedbackPerson']");
        const feedbackPersonHidden = document.getElementById("feedbackPersonHidden");

        // Nếu feedbackPerson có giá trị thì gán giá trị đó cho feedbackPersonHidden
        if (feedbackPersonSelect.value) {
            feedbackPersonHidden.value = feedbackPersonSelect.value;
        }
    });
</script>
    </body>
</html>
