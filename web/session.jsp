<%-- 
    Document   : session
    Created on : Sep 10, 2024, 11:08:09 PM
    Author     : admin
--%>
<%@page uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            const hamburger = document.querySelector(".hamburger");
            const navMenu = document.querySelector(".nav-menu");

            hamburger.addEventListener("click", mobileMenu);

            function mobileMenu() {
                hamburger.classList.toggle("active");
                navMenu.classList.toggle("active");
            }


// when we click on hamburger icon its close 

            const navLink = document.querySelectorAll(".nav-link");

            navLink.forEach(n => n.addEventListener("click", closeMenu));

            function closeMenu() {
                hamburger.classList.remove("active");
                navMenu.classList.remove("active");
            }
        </script>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,500;1,400&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            html {
                font-size: 62.5%;
                font-family: 'Roboto', sans-serif;
            }

            li {
                list-style: none;
            }

            a {
                text-decoration: none;
            }

            /* css to reset all the designs */

            /* add styles on elements */

            .header {
                border-bottom: 1px solid #E2E8F0;
                background-color: #222;
            }

            .navbar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 1.5rem 1.5rem;
            }

            .hamburger {
                display: none;
            }

            .bar {
                display: block;
                width: 25px;
                height: 3px;
                margin: 5px auto;
                -webkit-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
                /* background-color: #101010; */
                background-color: #fff;
            }

            .nav-menu {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .nav-item {
                margin-left: 5rem;
            }

            .nav-link {
                /* font-size: 1.6rem; */
                font-size: 2rem;
                font-weight: 400;
                /* color: #475569; */
                color: #fff;
                /* change */
            }

            .nav-link:hover {
                color: #482ff7;
            }

            .nav-logo {
                /* font-size: 2.1rem; */
                font-size: 3rem;
                font-weight: 500;
                /* color: #482ff7; */
                color: #fff;
            }

            @media only screen and (max-width: 768px) {
                .nav-menu {
                    position: fixed;
                    left: -100%;
                    top: 5rem;
                    flex-direction: column;
                    /* background-color: #fff; */
                    background-color: #222;
                    width: 100%;
                    border-radius: 10px;
                    text-align: center;
                    transition: 0.3s;
                    box-shadow:
                        0 10px 27px rgba(0, 0, 0, 0.05);
                }

                .nav-link {
                    color: #fff;
                }

                .nav-menu.active {
                    left: 0;
                }

                .nav-item {
                    margin: 2.5rem 0;
                }

                .hamburger {
                    display: block;
                    cursor: pointer;
                }

                .hamburger.active .bar:nth-child(2) {
                    opacity: 0;
                }

                .hamburger.active .bar:nth-child(1) {
                    transform: translateY(8px) rotate(45deg);
                }

                .hamburger.active .bar:nth-child(3) {
                    transform: translateY(-8px) rotate(-45deg);
                }

            }
        </style>
    </head>
    <body>
        <header class="header">
            <nav class="navbar">
                <a href="#" class="nav-logo">CuriousAman</a>
                <ul class="nav-menu">
                    <li class="nav-item">
                        <a href="#" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">About</a>
                    </li>
                    <c:if test="${sessionScope.user != null}">
                        <li class="nav-item">
                            <a href="#" class="nav-link">Logout</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <li class="nav-item">
                            <a href="login" class="nav-link">Login</a>
                        </li>
                    </c:if>
                </ul>
                <div class="hamburger">
                    <span class="bar"></span>
                    <span class="bar"></span>
                    <span class="bar"></span>
                </div>
            </nav>
        </header>
    </body>
</html>
