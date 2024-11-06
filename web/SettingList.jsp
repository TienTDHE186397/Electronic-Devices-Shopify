<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Settings List</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Merriweather+Sans:wght@300;400;500;600&display=swap');

:root {
    --main-color: #22BAA0;
    --color-dark: #34425A;
    --text-grey: #B0B0B0;
}
            *{
                margin: 0;
    padding: 0;
    text-decoration: none;
    list-style-type: none;
    box-sizing: border-box;
    font-family: 'Merriweather', sans-serif;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f2f5;
                color: #333;
            }
            .sidebar {
    position: fixed;
    height: 100%;
    width: 165px;
    left: 0;
    bottom: 0;
    top: 0;
    z-index: 100;
    background: var(--color-dark);
    transition: left 300ms;
}

.side-header {
    box-shadow: 0px 5px 5px -5px rgb(0 0 0 /10%);
    background: var(--main-color);
    height: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.side-header h3, side-head span {
    color: #fff;
    font-weight: 400;
}

.side-content {
    height: calc(100vh - 60px);
    overflow: auto;
}

 width 
.side-content::-webkit-scrollbar {
  width: 5px;
}

 Track 
.side-content::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
  border-radius: 10px;
}
 
 Handle 
.side-content::-webkit-scrollbar-thumb {
  background: #b0b0b0; 
  border-radius: 10px;
}

 Handle on hover 
.side-content::-webkit-scrollbar-thumb:hover {
  background: #b30000; 
}
.profile {
    text-align: center;
    padding: 2rem 0rem;
}

.bg-img {
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 50%;
    background-size: cover;
}

.profile-img {
    height: 80px;
    width: 80px;
    display: inline-block;
    margin: 0 auto .5rem auto;
    border: 3px solid #899DC1;
}

.profile h4 {
    color: #fff;
    font-weight: 500;
}

.profile small {
    color: #899DC1;
    font-weight: 600;
}

.sidebar {
    /*overflow-y: auto;*/
}
.side-menu ul {
    text-align: center;
}

.side-menu a {
    display: block;
    padding: 1.2rem 0rem;
}

.side-menu a.active {
    background: #2B384E;
}

.side-menu a.active span, .side-menu a.active small {
    color: #fff;
}

.side-menu a span {
    display: block;
    text-align: center;
    font-size: 1.7rem;
}

.side-menu a span, .side-menu a small {
    color: #899DC1;
}

    
            .container {
                max-width: 1200px;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
            }
            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }
            .header h1 {
                font-size: 24px;
                color: #333;
            }
            .header .search-box input {
                padding: 8px;
                width: 300px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }
            .filters {
                display: flex;
                gap: 20px;
                margin-bottom: 20px;
            }
            .filters select, .filters input {
                padding: 8px;
                border-radius: 5px;
                border: 1px solid #ccc;
                background-color: #f5f5f5;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table th, table td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            table th {
                background-color: #f7f7f7;
                cursor: pointer;
            }
            table tr:hover {
                background-color: #f1f1f1;
            }
            .actions button {
                padding: 6px 12px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                color: #fff;
            }
            .actions .edit {
                background-color: #4CAF50;
            }
            .actions .toggle {
                background-color: #f39c12;
            }
            .actions .view {
                background-color: #3498db;
            }
            .pagination {
                display: flex;
                margin-top: 20px;
                justify-content: center;
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
                border: 1px solid #ddd;
                margin: 0 4px;
                transition: background-color 0.3s;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
                border: 1px solid #4CAF50;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
            }
            .delete-icon {
            color: red;
            cursor: pointer;
        }

        </style>
    </head>
    <body>
        <div class="sidebar">
        <div class="side-header">
            <h3>H<span>STDTech</span></h3>
        </div>
        
        <div class="side-content">
            <div class="profile">
                <div class="profile-img bg-img" style="background-image: url(${person.image})"></div>
                <h4 name="name">${person.name}</h4>
                <small>Admin</small>
            </div>

            <div class="side-menu">
                <ul>
                    <li>
                       <a href="admin?PersonID=${person.personID}" class="">
                            <span class="las la-home"></span>
                            <small>Dashboard</small>
                        </a>
                    </li>
                    
                    <li>
                       <a href="chart?PersonID=${person.personID}">
                            <span class="las la-chart-pie"></span>
                            <small>Chart</small>
                        </a>
                    </li>
                    
                    <li>
                       <a href="adminProfile?PersonID=${person.personID}">
                            <span class="las la-user-alt"></span>
                            <small>Profile</small>
                        </a>
                    </li>
                    <li>
                       <a href="userList?PersonID=${person.personID}">
                            <span class="las la-tasks"></span>
                            <small>User List</small>
                        </a>
                    </li>
                    <li>
                        <a href="settingList?PersonID=${person.personID}" class="active">
                            <span class="las la-cog"></span>
                            <small>Setting List</small>
                        </a>
                    </li>
<!--                    <li>
                       <a href="">
                            <span class="las la-clipboard-list"></span>
                            <small>Projects</small>
                        </a>
                    </li>
                    <li>
                       <a href="">
                            <span class="las la-shopping-cart"></span>
                            <small>Orders</small>
                        </a>
                    </li>-->

                </ul>
            </div>
        </div>
    </div>

        <div class="container">
            <!-- Header with Search and Add Button -->
            <div class="header">
                <h1>Settings List</h1>

                <button onclick="window.location.href = 'addSetting.jsp'" style="padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;">+ Add New Setting</button>
            </div>

            <!-- Filters for Type and Status -->
            <div class="filters">
                <form action="settingControl" method="get">
                    <input type="text" id="searchValue" name="search" placeholder="Tìm kiếm bằng thể loại,..." value="${param.search}">
                    <select id="type" name="type">
                        <option value="">Thể loại</option>
                        <option value="Giao diện" ${param.type == 'Giao diện' ? 'selected' : ''}>Giao diện</option>
                        <option value="Thanh toán" ${param.type == 'Thanh toán' ? 'selected' : ''}>Thanh toán</option>
                        <option value="Khuyến mãi" ${param.type == 'Khuyến mãi' ? 'selected' : ''}>Khuyến mãi</option>
                    </select>
                    <select id="status" name="status">
                        <option value="">Trạng thái</option>
                        <option value="Active" ${param.status == 'Active' ? 'selected' : ''}>Active</option>
                        <option value="Deactive" ${param.status == 'Deactive' ? 'selected' : ''}>Deactive</option>
                    </select>
                    <input type="submit" style="padding: 10px; border: black; border-radius: 5px; cursor: pointer;" value="Tìm kiếm" />
                    <input type="reset" style="padding: 10px; border: black; border-radius: 5px; cursor: pointer;" name="Reset" value="Reset"/>
                </form>

            </div>

            <!-- Table of Settings -->
            <table id="settingsTable">
                <thead>
                    <tr>
                        <th onclick="sortID(0)">ID</th>
                        <th onclick="sortTable(1)">Thể loại</th>
                        <th onclick="sortTable(2)">Mô tả</th>
                        <th>Hình ảnh</th>
                        <th onclick="sortID(4)">Thứ tự</th>
                        <th onclick="sortTable(5)">Trạng thái</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Sample data for testing -->
                    <c:forEach var="setting" items="${list}">
                        <tr>
                            <td>${setting.ID}</td>
                            <td>${setting.type}</td>
                            <td>${setting.value}</td>
                            <td>
                                <img src="${setting.image}" class="img-radius" width="100px" height="100px">
                            </td>
                            <td>${setting.order}</td>
                            <c:choose>
                                <c:when test="${setting.status=='Active'}">
                                    <td style="color: greenyellow">Active</td>
                                </c:when>
                                <c:when test="${setting.status=='Deactive'}">
                                    <td style="color: red">Deactive</td>
                                </c:when>
                            </c:choose>
                            <td class="actions">
                                <button class="view" onclick="viewSetting(${setting.ID})">View</button>
                                <button class="edit" onclick="editSetting(${setting.ID})">Edit</button>
                                <c:if test="${setting.status == 'Deactive'}">
                                    <form action="pagingServlet" method="get" style="display:inline;">
                                        <input type="hidden" name="id" value="${setting.ID}">
                                        <input type="hidden" name="status" value="${setting.status}">
                                        <button type="submit" class="toggle">Active</button>
                                    </form>
                                </c:if>

                                <c:if test="${setting.status == 'Active'}">
                                    <form action="pagingServlet" method="get" style="display:inline;">
                                        <input type="hidden" name="id" value="${setting.ID}">
                                        <input type="hidden" name="status" value="${setting.status}">
                                        <button type="submit" class="toggle">Deactivate</button>
                                    </form>
                                </c:if>
                                <a href="deleteSetting?id=${setting.ID}" onclick="return confirm('Are you sure you want to delete this setting?');">
                                    <i class="fas fa-trash delete-icon"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="pagination">
                <c:forEach begin="1" end="${endPage}" var="i">
                    <a href="settingList?page=${i}" class="${(i == page) ? 'active' : ''}">${i}</a>
                </c:forEach>
                <!-- Pagination -->

                <!--                <button onclick="prevPage()">Previous</button>
                                <button onclick="nextPage()">Next</button>-->
            </div>
        </div>

        <script>
            // Sorting function for table columns
            function sortID(n) {
                let table = document.getElementById("settingsTable"), rows, switching = true, dir = "asc", switchCount = 0;

                while (switching) {
                    switching = false;
                    rows = table.rows;
                    for (let i = 1; i < rows.length - 1; i++) {
                        let x = parseFloat(rows[i].getElementsByTagName("TD")[n].innerHTML);
                        let y = parseFloat(rows[i + 1].getElementsByTagName("TD")[n].innerHTML);

                        if ((dir === "asc" && x > y) || (dir === "desc" && x < y)) {
                            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                            // row[i].parentNode.insertBefore(new Node, reference Node);
                            //parentNode: tra ve phan tu cha
                            //insertBefore(new Node, reference Node): chen new Node len truoc reference Node.
                            switching = true;
                            switchCount++;
                            break;
                        }
                    }

                    if (!switching && dir === "asc" && switchCount === 0) {
                        dir = "desc";
                        switching = true;
                    }
                }
            }


            function sortTable(n) {
                let table, rows, switching, i, x, y, shouldSwitch, switchCount = 0;
                let dir = "asc";
                table = document.getElementById("settingsTable"); // lay gia tri cua bang voi id la settingsTable
                switching = true;
                // Start with ascending order
                while (switching) {
                    switching = false;
                    rows = table.rows; // gan cac hang cua bang cho rows

                    for (i = 1; i < (rows.length - 1); i++) {
                        shouldSwitch = false;
                        x = rows[i].getElementsByTagName("TD")[n]; //lay gia tri hang hien tai i
                        y = rows[i + 1].getElementsByTagName("TD")[n]; // lay gia tri hang ke tiep i+1

                        if (dir === "asc") {
                            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        } else if (dir === "desc") {
                            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }

                    if (shouldSwitch) {
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        // row[i].parentNode.insertBefore(new Node, reference Node);
                        //parentNode: tra ve phan tu cha
                        //insertBefore(new Node, reference Node): chen new Node len truoc reference Node.
                        switching = true;
                        switchCount++;
                    } else {
                        if (switchCount === 0 && dir === "asc") {
                            dir = "desc";
                            switching = true;
                        }
                    }
                }
            }

            // Placeholder functions for actions
            function viewSetting(id) {
                window.location.href = "settingDetail?id=" + id;
            }

            function editSetting(id) {
                window.location.href = "editSetting?id=" + id;
            }
        </script>

    </body>
</html>
