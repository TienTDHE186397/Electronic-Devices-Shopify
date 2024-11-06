<%-- 
    Document   : Chart
    Created on : Oct 10, 2024, 7:12:31 PM
    Author     : nghie
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chart</title>
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
                display: flex;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
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


        /*      Chart       */
        .container{
            display: grid;
            align-items: center;
            justify-content: center;
            gap: 50px;
            padding: 20px;
            grid-template-columns: repeat(2, 1fr);
            
        }
        .chart{
            width: 300px;
            height: 300px;
            padding: 2rem;
            border: 1px solid #f49131;
            border-radius: 1rem;
            background: none;
            box-shadow: 0 0 16px rgba(0, 0, 0, 0.8);
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .chart:nth-child(2n+1) {
    margin-right: auto;
}
.chart:nth-child(2n) {
    margin-left: auto;
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
                        <a href="chart?PersonID=${person.personID}" class="active">
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
        
        <div class="container">
            <h2>Orders</h2>
            <h2>Customers</h2>
            <div class="chart">
                <canvas id="doughnut1"></canvas>
            </div>
            <div class="chart">
                <canvas id="doughnut2"></canvas>
            </div>
                <h2>Revenue</h2>
                <h2>Feedback</h2>
            <div class="chart">
                <canvas id="doughnut3"></canvas>
            </div>
            <div class="chart">
                <canvas id="doughnut4"></canvas>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.4/dist/chart.umd.min.js"></script>
        <script src="chart1.js"></script>
        <script>
  const ctx = document.getElementById('doughnut1').getContext('2d');
  

  const doughnut1 = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ['Successful', 'Cancel', 'Shipped'],
      datasets: [{
        label: 'Orders',
        data: [${(successOrders/allOrders)*100}, ${(cancelOrders/allOrders)*100}, ${(shipOrders/allOrders)*100}],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  
  
  const ctx2 = document.getElementById('doughnut2').getContext('2d');
    const doughnut2 = new Chart(ctx2, {
    type: 'doughnut',
    data: {
      labels: ['New Registers', 'New Purchasers', 'Others'],
      datasets: [{
        label: '# of Votes',
        data: [${(newRegister/allCustomer)*100}, ${(newPurchaser/allCustomer)*100}, ${((allCustomer-newRegister)/allCustomer)*100}],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  
  
  const ctx3 = document.getElementById('doughnut3').getContext('2d');
    const doughnut3 = new Chart(ctx3, {
    type: 'doughnut',
    data: {
      labels: ['Phone&Tablet', 'Laptop', 'PC', 'Monitor', 'Earphone'],
      datasets: [{
        label: '# of Votes',
        data: [${(Cate1/sumRevenue)*100}, ${(Cate2/sumRevenue)*100}, ${(Cate3/sumRevenue)*100}, ${(Cate4/sumRevenue)*100}, ${(Cate5/sumRevenue)*100}],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  
  
  const ctx4 = document.getElementById('doughnut4').getContext('2d');
    const doughnut4 = new Chart(ctx4, {
    type: 'doughnut',
    data: {
      labels: ['1 star', '2 stars', '3 stars', '4 stars', '5 stars'],
      datasets: [{
        label: '# of Votes',
        data: [${(Rate1/(Rate1+Rate2+Rate3+Rate4+Rate5))*100}, ${(Rate2/(Rate1+Rate2+Rate3+Rate4+Rate5))*100}, ${(Rate3/(Rate1+Rate2+Rate3+Rate4+Rate5))*100}, ${(Rate4/(Rate1+Rate2+Rate3+Rate4+Rate5))*100}, ${(Rate5/(Rate1+Rate2+Rate3+Rate4+Rate5))*100}],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
</script>
    </body>
</html>
