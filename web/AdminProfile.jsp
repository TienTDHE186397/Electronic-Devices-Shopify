<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Entity.Person" %>
<%@ page import="Email.PasswordUtils" %>
<%@ page session="true" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông tin tài khoản</title>
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
            
            
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
                background-color: #f4f4f9;
            }
            h1 {
                color: #333;
                text-align: center;
            }
            table {
                margin: 20px auto;
                border-collapse: collapse;
                width: 80%;
                max-width: 600px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
                color: #333;
            }
            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin: 4px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            button {
                padding: 10px 20px;
                background-color: #28a745;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }
            button:hover {
                background-color: #218838;
            }
            #changePasswordBtn {
                background-color: #dc3545;
            }
            #changePasswordBtn:hover {
                background-color: #c82333;
            }
        </style>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

    </head>
    <body>
        <%
            PasswordUtils pw = new PasswordUtils();
            Person loggedInPerson = (Person) request.getSession().getAttribute("user");
            if (loggedInPerson == null) {
        %>
        <p style="text-align: center;">Không có thông tin người dùng.</p>
        <%
        } else {
             String pass = pw.ReverPassword(loggedInPerson.getPasword());
        %>
        <input type="checkbox" id="menu-toggle">
        <div class="sidebar">
            <div class="side-header">
                <h3>H<span>STDTech</span></h3>
            </div>

            <div class="side-content">
                <div class="profile">
                    <input type="hidden" id="PersonID" name="PersonID" value="${person.personID}"/>
                    <div class="profile-img bg-img" style="background-image: url(${person.image})"></div>
                    <h4 name="name"><%= loggedInPerson.getName() %></h4>
                    <small>Admin</small>
                </div>

                <div class="side-menu">
                    <ul>
                        <li>
                            <a name="PersonID" href="admin?PersonID=<%= loggedInPerson.getPersonID() %>" class="">
                                <span class="las la-home"></span>
                                <small>Dashboard</small>
                            </a>
                        </li>

                        <li>
                            <a href="chart?PersonID=<%= loggedInPerson.getPersonID() %>">
                                <span class="las la-chart-pie"></span>
                                <small>Chart</small>
                            </a>
                        </li>

                        <li>
                            <a href="adminProfile?PersonID=<%= loggedInPerson.getPersonID() %>" class="active">
                                <span class="las la-user-alt"></span>
                                <small>Profile</small>
                            </a>
                        </li>
                        <li>
                            <a href="userList?PersonID=<%= loggedInPerson.getPersonID() %>">
                                <span class="las la-tasks"></span>
                                <small>User List</small>
                            </a>
                        </li>
                        <li>
                            <a href="settingList?PersonID=<%= loggedInPerson.getPersonID() %>">
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
        
        
        <h1>Thông tin tài khoản</h1>
        <script>
            function redirectToChangePassword() {
                window.location.href = "ChangePassword";
            }
        </script>

        
        <table>
            <thead>
                <tr>
                    <th>Tên cột</th>
                    <th>Giá trị</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Họ và tên</td>
                    <td><input type="text" name="name" value="<%= loggedInPerson.getName() %>" placeholder="Name"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td><input type="text" name="gender" value="<%= loggedInPerson.getGender() %>" placeholder="Gender"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ngày bắt đầu</td>
                    <td><input type="text" name="startDate" value="<%= loggedInPerson.getStartDate() %>" placeholder="Start Date"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%= loggedInPerson.getEmail() %>" placeholder="Email"></td>
                    <td></td>
                </tr>

                <tr>
                    <td>Vai trò</td>
                    <td><input type="text" name="role" value="<%= loggedInPerson.getRoleID() %>" placeholder="Role"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Mật khẩu</td>
                    <td><input type="text" name="password" value="<%= pass %>" placeholder="Password"></td>
                    <td><button type="button" id="changePasswordBtn">Đổi mật khẩu</button></td>
                </tr>
            </tbody>
        </table>

        <script>
            document.getElementById("changePasswordBtn").addEventListener("click", redirectToChangePassword);
        </script>

        <%
            }
        %>
    </body>
    
</html>



