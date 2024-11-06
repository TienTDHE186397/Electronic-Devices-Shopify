<%-- 
    Document   : testmktdashboard
    Created on : Nov 4, 2024, 11:18:52 AM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
        <title>Marketing Dashboard</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            }

            body {
                background-color: #f0f2f5;
                padding: 20px;
            }

            .dashboard {
                max-width: 1200px;
                margin: 0 auto;
            }

            .header {
                background: white;
                padding: 20px;
                border-radius: 10px;
                margin-bottom: 20px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }

            .date-picker {
                display: flex;
                gap: 20px;
                align-items: center;
                margin-top: 10px;
            }

            .date-picker input {
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            .stats-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 20px;
                margin-bottom: 20px;
            }

            .stat-card {
                background: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }

            .stat-card h3 {
                color: #666;
                font-size: 14px;
                margin-bottom: 10px;
            }

            .stat-card .number {
                font-size: 24px;
                font-weight: bold;
                color: #333;
            }

            .trend {
                color: #28a745;
                font-size: 14px;
                margin-top: 5px;
            }

            .trend.negative {
                color: #dc3545;
            }

            .chart-container {
                background: white;
                padding: 20px;
                border-radius: 10px;
                margin-bottom: 20px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }

            /* Sửa phần CSS cho chart wrapper */
            .chart-wrapper {
                position: relative;
                height: 300px;
                width: 100%;
                margin-top: 10px;
            }

            /* Canvas sẽ nằm trong wrapper */
            .chart-wrapper canvas {
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
            }
        </style>
    </head>
    <body>

        <div class="dashboard">
            <div class="header">
                <h1>Marketing Dashboard</h1>
                <div class="date-picker">
                    <label>Từ ngày:</label>
                    <input type="date" id="start-date">
                    <label>Đến ngày:</label>
                    <input type="date" id="end-date">
                </div>
            </div>

            <div class="stats-grid">
                <div class="stat-card">
                    <h3>Tổng số bài đăng</h3>
                    <div class="number">245</div>
                    <div class="trend">+12% so với tuần trước</div>
                </div>
                <div class="stat-card">
                    <h3>Sản phẩm mới</h3>
                    <div class="number">38</div>
                    <div class="trend">+5% so với tuần trước</div>
                </div>
                <div class="stat-card">
                    <h3>Khách hàng mới</h3>
                    <div class="number">156</div>
                    <div class="trend negative">-3% so với tuần trước</div>
                </div>
                <div class="stat-card">
                    <h3>Phản hồi khách hàng</h3>
                    <div class="number">89</div>
                    <div class="trend">+18% so với tuần trước</div>
                </div>
            </div>

            <div class="chart-container">
                <h2>Xu hướng khách hàng mới</h2>
                <div class="chart-wrapper">
                    <canvas id="newCustomersChart"></canvas>
                </div>
            </div>

            <div class="chart-container">
                <h2>Thống kê bài đăng</h2>
                <div class="chart-wrapper">
                    <canvas id="postsChart"></canvas>
                </div>
            </div>

            <div class="chart-container">
                <h2>Phản hồi khách hàng</h2>
                <div class="chart-wrapper">
                    <canvas id="feedbackChart"></canvas>
                </div>
            </div>
        </div>

        <script>
            // Dữ liệu mẫu cho 7 ngày
            const dates = [
                '2024-11-01', '2024-11-02', '2024-11-03',
                '2024-11-04', '2024-11-05', '2024-11-06', '2024-11-07'
            ];

            // Cấu hình chung cho tất cả biểu đồ
            const commonOptions = {
                responsive: true,
                maintainAspectRatio: true,
                plugins: {
                    legend: {
                        position: 'top',
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: {
                            drawBorder: false
                        }
                    },
                    x: {
                        grid: {
                            display: false
                        }
                    }
                },
                layout: {
                    padding: {
                        left: 10,
                        right: 10
                    }
                }
            };

            // Biểu đồ khách hàng mới
            const newCustomersCtx = document.getElementById('newCustomersChart').getContext('2d');
            new Chart(newCustomersCtx, {
                type: 'line',
                data: {
                    labels: dates,
                    datasets: [{
                            label: 'Khách hàng mới',
                            data: [25, 32, 28, 35, 40, 38, 42],
                            borderColor: '#4e73df',
                            tension: 0.3,
                            fill: false
                        }]
                },
                options: commonOptions
            });

            // Biểu đồ bài đăng
            const postsCtx = document.getElementById('postsChart').getContext('2d');
            new Chart(postsCtx, {
                type: 'bar',
                data: {
                    labels: dates,
                    datasets: [{
                            label: 'Số bài đăng',
                            data: [45, 38, 42, 50, 48, 55, 45],
                            backgroundColor: '#1cc88a'
                        }]
                },
                options: commonOptions
            });

            // Biểu đồ phản hồi
            const feedbackCtx = document.getElementById('feedbackChart').getContext('2d');
            new Chart(feedbackCtx, {
                type: 'line',
                data: {
                    labels: dates,
                    datasets: [{
                            label: 'Phản hồi tích cực',
                            data: [15, 18, 20, 22, 25, 23, 28],
                            borderColor: '#36b9cc',
                            tension: 0.3,
                            fill: false
                        }, {
                            label: 'Phản hồi tiêu cực',
                            data: [5, 4, 6, 3, 5, 4, 2],
                            borderColor: '#e74a3b',
                            tension: 0.3,
                            fill: false
                        }]
                },
                options: commonOptions
            });
        </script>

    </body>
</html>
</html>
