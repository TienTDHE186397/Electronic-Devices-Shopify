<%-- 
    Document   : UserList
    Created on : Sep 13, 2024, 8:41:45 PM
    Author     : nghie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
<!--        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

        <style>
            
/*        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }*/
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

/*        body {
            background-color: #f4f6f9;
            padding: 20px;
        }*/

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Search and Filter Form */
        .main-container {
    display: flex;
    width: 100%;
    justify-content: space-around;
}

.search-form {
    margin-bottom: 20px; /* Thêm khoảng cách giữa form và bảng */
}

.search-form form {
    width: 100%;
    display: flex;
    align-items: center;
    gap: 10px; /* Khoảng cách giữa các input */
}
        form {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        form input[type="text"], form select {
            padding: 10px;
            width: 30%;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        form input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* User Table */
/*        table {
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        .table-container {
    display: flex;
    justify-content: flex-end;  Đẩy bảng về phía bên phải 
    width: 100%;  Chiếm hết chiều rộng khung chứa 
}

        thead {
            background-color: #007bff;
            color: white;
        }

        thead th {
            padding: 15px;
            text-align: left;
            font-weight: 500;
        }

        tbody tr {
            border-bottom: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody td {
            padding: 15px;
        }*/
        table {
                border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
            }
            .table-container {
    display: flex;
    justify-content: flex-end;
    width: 100%;
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
        /* Links and Actions */
        tbody td a {
            color: #007bff;
            text-decoration: none;
        }

        tbody td a:hover {
            text-decoration: underline;
        }
            
        /* Responsive Table */
        @media screen and (max-width: 768px) {
            form {
                flex-direction: column;
            }

            form input[type="text"], form select {
                width: 100%;
                margin-bottom: 10px;
            }

            table {
                font-size: 14px;
            }

            thead th, tbody td {
                padding: 10px;
            }
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
                <div class="profile-img bg-img" style="background-image: url(https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/1200px-User_icon_2.svg.png)"></div>
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
                        <a href="userList?PersonID=${person.personID}" class="active">
                            <span class="las la-tasks"></span>
                            <small>User List</small>
                        </a>
                    </li>
                    <li>
                        <a href="settingList?PersonID=${person.personID}" class="">
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
 
        
        <div  style="margin-top: 15px">
            <div class="row">
                <div class="col-12 mb-3 mb-lg-"> 
                    <div class="position-relative card table-nowrap table-card ">
                        <div style="margin-bottom: 5px">
        <h1>Danh sách người dùng</h1>

    <!-- Form tìm kiếm và lọc -->
    <div class="main-container">
    <div class="search-form">
    <form method="GET" action="userControl">
        <input type="text" name="search" placeholder="Tìm kiếm theo tên, email, di động" value="${param.search}" />
        <select name="gender" id="gender">
            <option value="">Chọn giới tính</option>
            <option value="Nam" ${param.gender == 'Nam' ? 'selected' : ''}>Nam</option>
            <option value="Nữ" ${param.gender == 'Nữ' ? 'selected' : ''}>Nữ</option>
            <option value="Khác" ${param.gender == 'Khác' ? 'selected' : ''}>Khác</option>
        </select>
        <select name="roleid" id="roleid">
            <option value="">Chọn vai trò</option>
            <option value="1" ${param.roleid == '1' ? 'selected' : ''}>Customer</option>
            <option value="2" ${param.roleid == '2' ? 'selected' : ''}>Marketing</option>
            <option value="3" ${param.roleid == '3' ? 'selected' : ''}>Sale</option>
            <option value="4" ${param.roleid == '4' ? 'selected' : ''}>SaleManager</option>
            <option value="5" ${param.roleid == '5' ? 'selected' : ''}>Admin</option>
        </select>
        <input type="submit" value="Tìm kiếm" />
    </form>
    </div>
        </div>
         <!-- Bảng danh sách người dùng -->
         <div class="table-container">
    <table border="1" width="89%" id="settingsTable">
        <thead>
            <tr>
                <th onclick="sortID(0)">ID</th>
                <th onclick="sortTable(1)">Họ tên</th>
                <th onclick="sortTable(2)">Giới tính</th>
                <th onclick="sortTable(3)">Ngày sinh</th>
                <th onclick="sortTable(4)">Địa chỉ</th>
                <th onclick="sortTable(5)">Email</th>
                <th onclick="sortID(6)">Di động</th>
                <th onclick="sortTable(7)">Vai trò</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            
        <c:forEach var="person" items="${listP}">
                <tr>
                    <td>${person.personID}</td>
                    <td>${person.name}</td>
                    <td>${person.gender}</td>
                    <td>${person.dateOfBirth}</td>
                    <td>${person.address}</td>
                    <td>${person.email}</td>
                    <td>${person.phone}</td>
                <c:choose>
                    <c:when test="${person.roleID == 1}">
                        <td>Customer</td>
                    </c:when>
                        <c:when test="${person.roleID == 2}">
                        <td>Marketing</td>
                    </c:when>
                        <c:when test="${person.roleID == 3}">
                        <td>Sale</td>
                    </c:when>
                        <c:when test="${person.roleID == 4}">
                        <td>SaleManager</td>
                    </c:when>
                        <c:when test="${person.roleID == 5}">
                        <td>Admin</td>
                    </c:when>
                </c:choose>
                    
                        <td>
                            <a href="userDetail?PersonID=${person.personID}" style="">Chỉnh sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
             
             </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div style="text-align: center; margin-top: 15px;">
    <center><h5> <a href="addUser"><input type="button" value="Thêm người dùng mới" id="addUser" style="border: none;padding: 20px;color: white;background-color: #007bff;border-radius: 8px;"></a></h5></center>
        </div>
        <script>
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
        </script>
    </body>
</html>
