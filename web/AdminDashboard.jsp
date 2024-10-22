<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Modern Admin Dashboard</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Merriweather+Sans:wght@300;400;500;600&display=swap');

            :root {
                --main-color: #22BAA0;
                --color-dark: #34425A;
                --text-grey: #B0B0B0;
            }

            * {
                margin: 0;
                padding: 0;
                text-decoration: none;
                list-style-type: none;
                box-sizing: border-box;
                font-family: 'Merriweather', sans-serif;
            }

            #menu-toggle {
                display: none;
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
            .profile input {
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

            #menu-toggle:checked ~ .sidebar {
                width: 60px;
            }

            #menu-toggle:checked ~ .sidebar .side-header span {
                display: none;
            }

            #menu-toggle:checked ~ .main-content {
                margin-left: 60px;
                width: calc(100% - 60px);
            }

            #menu-toggle:checked ~ .main-content header {
                left: 60px;
            }

            #menu-toggle:checked ~ .sidebar .profile,
            #menu-toggle:checked ~ .sidebar .side-menu a small {
                display: none;
            }

            #menu-toggle:checked ~ .sidebar .side-menu a span {
                font-size: 1.3rem;
            }


            .main-content {
                margin-left: 165px;
                width: calc(100% - 165px);
                transition: margin-left 300ms;
            }

            header {
                position: fixed;
                right: 0;
                top: 0;
                left: 165px;
                z-index: 100;
                height: 60px;
                box-shadow: 0px 5px 5px -5px rgb(0 0 0 /10%);
                background: #fff;
                transition: left 300ms;
            }

            .header-content, .header-menu {
                display: flex;
                align-items: center;
            }

            .header-content {
                justify-content: space-between;
                padding: 0rem 1rem;
            }

            .header-content label:first-child span {
                font-size: 1.3rem;
            }

            .header-content label {
                cursor: pointer;
            }

            .header-menu {
                justify-content: flex-end;
                padding-top: .5rem;
            }

            .header-menu label,
            .header-menu .notify-icon {
                margin-right: 2rem;
                position: relative;
            }

            .header-menu label span,
            .notify-icon span:first-child {
                font-size: 1.3rem;
            }

            .notify-icon span:last-child {
                position: absolute;
                background: var(--main-color);
                height: 16px;
                width: 16px;
                display: flex;
                justify-content: center;
                align-items: center;
                border-radius: 50%;
                right: -5px;
                top: -5px;
                color: #fff;
                font-size: .8rem;
                font-weight: 500;
            }

            .user {
                display: flex;
                align-items: center;
            }

            .user div, .client-img {
                height: 40px;
                width: 40px;
                margin-right: 1rem;
            }

            .user span:last-child {
                display: inline-block;
                margin-left: .3rem;
                font-size: .8rem;
            }

            main {
                margin-top: 60px;
            }

            .page-header {
                padding: 1.3rem 1rem;
                background: #E9edf2;
                border-bottom: 1px solid #dee2e8;
            }

            .page-header h1, .page-header small {
                color: #74767d;
            }

            .page-content {
                padding: 1.3rem 1rem;
                background: #f1f4f9;
            }

            .analytics {
                display: grid;
                grid-template-columns: repeat(4, 1fr);
                grid-gap: 2rem;
                margin-top: .5rem;
                margin-bottom: 2rem;
            }

            .card {
                box-shadow: 0px 5px 5px -5px rgb(0 0 0 / 10%);
                background: #fff;
                padding: 1rem;
                border-radius: 3px;
            }

            .card-head {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .card-head h2 {
                color: #333;
                font-size: 1.8rem;
                font-weight: 500;
            }

            .card-head span {
                font-size: 3.2rem;
                color: var(--text-grey);
            }

            .card-progress small {
                color: #777;
                font-size: .8rem;
                font-weight: 600;
            }

            .card-indicator {
                margin: .7rem 0rem;
                height: 10px;
                border-radius: 4px;
                background: #e9edf2;
                overflow: hidden;
            }

            .indicator {
                height: 10px;
                border-radius: 4px;
            }

            .indicator.one {
                background: #22baa0;
            }

            .indicator.two {
                background: #11a8c3;
            }

            .indicator.three {
                background: #f6d433;
            }

            .indicator.four {
                background: #f25656;
            }

            .records {
                box-shadow: 0px 5px 5px -5px rgb(0 0 0 / 10%);
                background: #fff;
                border-radius: 3px;
            }

            .record-header {
                padding: 1rem;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .add, .browse {
                display: flex;
                align-items: center;
            }

            .add span {
                display: inline-block;
                margin-right: .6rem;
                font-size: .9rem;
                color: #666;
            }

            input, button, select {
                outline: none;
            }

            .add select, .browse input, .browse select {
                height: 35px;
                border: 1px solid #b0b0b0;
                border-radius: 3px;
                display: inline-block;
                width: 75px;
                padding: 0rem .5rem;
                margin-right: .8rem;
                color: #666;
            }

            .add button {
                background: var(--main-color);
                color: #fff;
                height: 37px;
                border-radius: 4px;
                padding: 0rem 1rem;
                border: none;
                font-weight: 600;
            }

            .browse input {
                width: 150px;
            }

            .browse select {
                width: 100px;
            }

            .table-responsive {
                width: 100%;
                overflow: auto;
            }

            table {
                border-collapse: collapse;
            }

            table thead tr {
                background: #e9edf2;
            }

            table thead th {
                padding: 1rem 0rem;
                text-align: left;
                color: #444;
                font-size: .9rem;
            }

            table thead th:first-child {
                padding-left: 1rem;
            }

            table tbody td {
                padding: 1rem 0rem;
                color: #444;
            }

            table tbody td:first-child {
                padding-left: 1rem;
                color: var(--main-color);
                font-weight: 600;
                font-size: .9rem;
            }

            table tbody tr {
                border-bottom: 1px solid #dee2e8;
            }

            .client {
                display: flex;
                align-items: center;
            }

            .client-img {
                margin-right: .5rem;
                border: 2px solid #b0b0b0;
                height: 45px;
                width: 45px;
            }

            .client-info h4 {
                color: #555;
                font-size: .95rem;
            }

            .client-info small {
                color: #777;
            }

            .actions span {
                display: inline-block;
                font-size: 1.5rem;
                margin-right: .5rem;
            }

            .paid {
                display: inline-block;
                text-align: center;
                font-weight: 600;
                color: var(--main-color);
                background: #e5f8ed;
                padding: .5rem 1rem;
                border-radius: 20px;
                font-size: .8rem;
            }

            @media only screen and (max-width: 1200px) {
                .analytics {
                    grid-template-columns: repeat(2, 1fr);
                }
            }

            @media only screen and (max-width: 768px) {
                .analytics {
                    grid-template-columns: 100%;
                }

                .sidebar {
                    left: -165px;
                    z-index: 90;
                }

                header {
                    left: 0;
                    width: 100%;
                }

                .main-content {
                    margin-left: 0;
                    width: 100%;
                }

                #menu-toggle:checked ~ .sidebar {
                    left: 0;
                }

                #menu-toggle:checked ~ .sidebar {
                    width: 165px;
                }

                #menu-toggle:checked ~ .sidebar .side-header span {
                    display: inline-block;
                }

                #menu-toggle:checked ~ .sidebar .profile,
                #menu-toggle:checked ~ .sidebar .side-menu a small {
                    display: block;
                }

                #menu-toggle:checked ~ .sidebar .side-menu a span {
                    font-size: 1.7rem;
                }

                #menu-toggle:checked ~ .main-content header {
                    left: 0px;
                }

                table {
                    width: 900px;
                }
            }












        </style>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <body>
        <input type="checkbox" id="menu-toggle">
        <div class="sidebar">
            <div class="side-header">
                <h3>H<span>STDTech</span></h3>
            </div>

            <div class="side-content">
                <div class="profile">
                    <input type="hidden" id="PersonID" name="PersonID" value="${person.personID}"/>
                    <div class="profile-img bg-img" style="background-image: url(https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/1200px-User_icon_2.svg.png)"></div>
                    <h4 name="name">${person.name}</h4>
                    <small>Admin</small>
                </div>

                <div class="side-menu">
                    <ul>
                        <li>
                            <a name="PersonID" href="admin?PersonID=${person.personID}" class="active">
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
                            <a href="settingList?PersonID=${person.personID}">
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

        <div class="main-content">

            <header>
                <div class="header-content">
                    <label for="menu-toggle">
                        <span class="las la-bars"></span>
                    </label>

                    <div class="header-menu">
                        <label for="">
                            <span class="las la-search"></span>
                        </label>

                        <div class="notify-icon">
                            <span class="las la-envelope"></span>
                            <span class="notify">4</span>
                        </div>

                        <div class="notify-icon">
                            <span class="las la-bell"></span>
                            <span class="notify">3</span>
                        </div>

                        <div class="user">
                            <div class="bg-img" style="background-image: url(img/1.jpeg)"></div>

                            <span class="las la-power-off"></span>
                            <span onclick="window.location.href = 'login'">Logout</span>
                        </div>
                    </div>
                </div>
            </header>


            <main>

                <div class="page-header">
                    <h1>Dashboard</h1>
                    <small>Home / Dashboard</small>
                </div>

                <div class="page-content">

                    <div class="analytics">
                        <!--         Orders        -->
                        <div class="card">
                            <div class="card-head">
                                <h2>${allOrders}</h2>
                                <span class="las la-cart-arrow-down" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>All Orders</small>
                                <div class="card-indicator">
                                    <div class="indicator one" style="width: 100%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${successOrders}</h2>
                                <span class="las la-check-circle" style="color: greenyellow"></span>
                            </div>
                            <div class="card-progress">
                                <small>Complete</small>
                                <div class="card-indicator">
                                    <div class="indicator one" style="width: ${(successOrders/allOrders)*100}%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${cancelOrders}</h2>
                                <span class="las la-times" style="color: red"></span>
                            </div>
                            <div class="card-progress">
                                <small>In Line</small>
                                <div class="card-indicator">
                                    <div class="indicator four" style="width: ${(cancelOrders/allOrders)*100}%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${shipOrders}</h2>
                                <span class="las la-truck" style="color: orange"></span>
                            </div>
                            <div class="card-progress">
                                <small>In Progress</small>
                                <div class="card-indicator">
                                    <div class="indicator three" style="width: ${(shipOrders/allOrders)*100}%"></div>
                                </div>
                            </div>
                        </div>

                        <!--         Revenue        -->

                        <div class="card">
                            <div class="card-head">
                                <h2><fmt:formatNumber value="${sumRevenue}" type="number"/></h2>
                                <span class="las la-coins" style="color: yellow"></span>
                            </div>
                            <div class="card-progress">
                                <small>Revenue</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: 100%"></div>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2><fmt:formatNumber value="${Cate1}" type="number"/></h2>
                                <span class="las la-mobile" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Phone-Tablet</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: ${(Cate1/sumRevenue)*100}%"></div>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2><fmt:formatNumber value="${Cate2}" type="number"/></h2>
                                <span class="las la-laptop" style="color: blue"></span>
                            </div>
                            <div class="card-progress">
                                <small>Laptop</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: ${(Cate2/sumRevenue)*100}%"></div>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2><fmt:formatNumber value="${Cate3}" type="number"/></h2>
                                <span class="las la-window-minimize" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>PC</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: ${(Cate3/sumRevenue)*100}%"></div>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2><fmt:formatNumber value="${Cate4}" type="number"/></h2>
                                <span class="las la-desktop" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Monitor</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: ${(Cate4/sumRevenue)*100}%"></div>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2><fmt:formatNumber value="${Cate5}" type="number"/></h2>
                                <span class="las la-headphones-alt" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Earphone</small>
                                <div class="card-indicator">
                                    <div class="indicator two" style="width: ${(Cate5/sumRevenue)*100}%"></div>
                                </div>
                            </div>
                        </div>

                        <!--         Customers        -->

                        <div class="card">
                            <div class="card-head">
                                <h2>${allCustomer}</h2>
                                <span class="las la-user-alt" style="color: blue"></span>
                            </div>
                            <div class="card-progress">
                                <small>Customers</small>
                                <div class="card-indicator">
                                    <div class="indicator three" style="width: 100%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${newRegister}</h2>
                                <span class="las la-user-alt" style="color: blue"></span>
                            </div>
                            <div class="card-progress">
                                <small>New Registations</small>
                                <div class="card-indicator">
                                    <div class="indicator three" style="width: ${(newRegister/allCustomer)*100}%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${newPurchaser}</h2>
                                <span class="las la-user-alt" style="color: blue"></span>
                            </div>
                            <div class="card-progress">
                                <small>New Purchasers</small>
                                <div class="card-indicator">
                                    <div class="indicator three" style="width: ${(newPurchaser/allOrders)*100}%"></div>
                                </div>
                            </div>
                        </div>

                        <!--         Feedback        -->

                        <div class="card">
                            <div class="card-head">
                                <h2>${comment}</h2>
                                <span class="las la-comment" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Comment</small>
                                <div class="card-indicator">
                                    <div class="indicator four" style="width: 90%"></div>
                                </div>
                            </div>
                            <div class="card-head">
                                <h2>${avgRate}</h2>
                                <span class="las la-star" style="color: yellow"></span>
                            </div>
                            <div class="card-progress">
                                <small>Avarage Rate</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${avgRate>=0&&avgRate<=1.65}">
                                            <div class="indicator four" style="width: ${(avgRate/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${avgRate>=1.66&&avgRate<=3.33}">
                                            <div class="indicator three" style="width: ${(avgRate/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${avgRate>=3.34&&avgRate<=5}">
                                            <div class="indicator one" style="width: ${(avgRate/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>

                            <div class="card-head">
                                <h2>${Rate1}</h2>
                                <span class="las la-mobile" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Phone-Tablet</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${Rate1>=0&&Rate1<=1.65}">
                                            <div class="indicator four" style="width: ${(Rate1/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate1>=1.66&&Rate1<=3.33}">
                                            <div class="indicator three" style="width: ${(Rate1/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate1>=3.34&&Rate1<=5}">
                                            <div class="indicator one" style="width: ${(Rate1/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2>${Rate2}</h2>
                                <span class="las la-laptop" style="color: blue"></span>
                            </div>
                            <div class="card-progress">
                                <small>Laptop</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${Rate2>=0&&Rate2<=1.65}">
                                            <div class="indicator four" style="width: ${(Rate2/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate2>=1.66&&Rate2<=3.33}">
                                            <div class="indicator three" style="width: ${(Rate2/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate2>=3.34&&Rate2<=5}">
                                            <div class="indicator one" style="width: ${(Rate2/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2>${Rate3}</h2>
                                <span class="las la-window-minimize" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>PC</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${Rate3>=0&&Rate3<=1.65}">
                                            <div class="indicator four" style="width: ${(Rate3/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate3>=1.66&&Rate3<=3.33}">
                                            <div class="indicator three" style="width: ${(Rate3/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate3>=3.34&&Rate3<=5}">
                                            <div class="indicator one" style="width: ${(Rate3/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2>${Rate4}</h2>
                                <span class="las la-desktop" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Monitor</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${Rate4>=0&&Rate4<=1.65}">
                                            <div class="indicator four" style="width: ${(Rate4/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate4>=1.66&&Rate4<=3.33}">
                                            <div class="indicator three" style="width: ${(Rate4/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate4>=3.34&&Rate4<=5}">
                                            <div class="indicator one" style="width: ${(Rate4/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>


                            <div class="card-head">
                                <h2>${Rate5}</h2>
                                <span class="las la-headphones-alt" style="color: black"></span>
                            </div>
                            <div class="card-progress">
                                <small>Earphone</small>
                                <div class="card-indicator">
                                    <c:choose>
                                        <c:when test="${Rate5>=0&&Rate5<=1.65}">
                                            <div class="indicator four" style="width: ${(Rate5/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate5>=1.66&&Rate5<=3.33}">
                                            <div class="indicator three" style="width: ${(Rate5/5)*100}%"></div>
                                        </c:when>
                                        <c:when test="${Rate5>=3.34&&Rate5<=5}">
                                            <div class="indicator one" style="width: ${(Rate5/5)*100}%"></div>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>
                        </div>

                    </div>


                    <div class="records table-responsive">

                        <div class="record-header">
                            <!--                        <div class="add">
                                                        <span>Entries</span>
                                                        <select name="" id="">
                                                            <option value="">ID</option>
                                                        </select>
                                                    </div>-->
                            <div>

                            </div>
                            <div class="browse">
                                <form action="admin" method="get">
                                    Start date <input type="datetime-local" id="start-date" name="startDate" value="${param.startDate}"> 
                                    End date <input type="datetime-local" id="end-date" name="endDate" value="${param.endDate}">
                                    <input type="text" name="search" placeholder="Search by Method" class="record-search" value="${param.search}">
                                    <select name="status" id="status">
                                        <option value="">Status</option>
                                        <option value="Complete" ${param.status == 'Complete' ? 'selected' : ''}>Complete</option>
                                        <option value="In line" ${param.status == 'In line' ? 'selected' : ''}>In Line</option>
                                        <option value="In progress" ${param.status == 'In progress' ? 'selected' : ''}>In Progress</option>
                                    </select>
                                    <input style="background-color: blue;color: white" type="submit" value="Search">
                                </form>
                            </div>
                        </div>

                        <div>
                            <table id="orderTable" width="100%">
                                <thead>
                                    <tr>
                                        <th onclick="sortID(0)">ORDER ID</th>
                                        <th><span class="las la-sort"></span> ORDER DATE</th>
                                        <th><span class="las la-sort"></span> PERSON ID</th>
                                        <th><span class="las la-sort"></span> SHOWROOM ID</th>
                                        <th><span class="las la-sort"></span> TOTAL MONEY</th>
                                        <th><span class="las la-sort"></span> METHOD</th>
                                        <th><span class="las la-sort"></span> STATUS</th>
                                        <th><span class="las la-sort"></span> ACTIONS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.list}" var="list">
                                        <tr>
                                            <td>${list.orderID}</td>
                                            <td>
                                                ${list.orderDate}
                                            </td>
                                            <td>${list.personID}</td>
                                            <td>${list.showroomID}</td>
                                            <td><fmt:formatNumber value="${list.totalMoney}" type="number"/></td>
                                            <td>${list.method}</td>
                                            <td>${list.status}</td>
                                            <td>
                                                <div class="actions">
                                                    <span class="lab la-telegram-plane"></span>
                                                    <span class="las la-eye"></span>
                                                    <span class="las la-ellipsis-v"></span> 
                                                </div>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>

            </main>

        </div>
        <script>
            function sortID(n) {
                let table = document.getElementById("orderTable"), rows, switching = true, dir = "asc", switchCount = 0;

                while (switching) {
                    switching = false;
                    rows = table.rows;
                    for (let i = 1; i < rows.length - 1; i++) {
                        let x = parseFloat(rows[i].getElementsByTagName("ORDER ID")[n].innerHTML);
                        let y = parseFloat(rows[i + 1].getElementsByTagName("ORDER ID")[n].innerHTML);

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
            
            
            window.onload = function () {
    // Lấy thời gian hiện tại
    const now = new Date();

    // Chuyển đổi thời gian hiện tại thành định dạng phù hợp cho datetime-local (YYYY-MM-DDTHH:mm)
    const currentDateTime = now.toISOString().slice(0, 16);

    // Gán thời gian hiện tại cho trường End date
    document.getElementById('end-date').value = currentDateTime;
};


        </script>
    </body>
</html>