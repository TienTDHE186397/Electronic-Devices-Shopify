<%-- 
    Document   : CartCompletion
    Created on : Oct 25, 2024, 2:32:40 PM
    Author     : nghie
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thank you!</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        .cart-completion {
            display: flex;
            gap: 2rem;
            padding: 7rem;
            flex-direction: column-reverse;
            align-items: flex-start;
        }

        .completion-message {
            flex: 2;
        }

        .completion-message h2 {
            color: green;
        }

        .sidebar {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }

        .search-box input {
            width: 200%;
            padding: 0.5rem;
        }

        .product-categories, .latest-products, .contact-links {
            background: #f5f5f5;
            padding: 1rem;
            border-radius: 8px;
        }

        .product-categories ul, .latest-products ul {
            list-style-type: none;
            padding: 0;
        }

        .contact-links p {
            margin: 0;
        }

    </style>
    </head>
    
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>
        
        <div class="cart-completion">
            <!-- Completion Message -->
            <div><a href="http://localhost:9999/WebDienTu/home">Return to Home Page</a></div>
            <section class="completion-message">
                <h2>Order Complete!</h2>
                <p>Thank you for your purchase! You’ll receive a confirmation email shortly.</p>
                <div class="order-info">
                    <h3>Order Confirmation</h3>
                    <p id="confirmation-text">Your order has been shipped and payment instructions are provided below:</p>
                </div>
            </section>

            <!-- Sidebar with Product Search and Links -->
            <aside class="sidebar">
                 Product Search Box 
                <div class="search-box">
                    <input type="text" placeholder="Search products..." id="product-search" />
                    <button onclick="searchProducts()">Search</button>
                </div>
                

<!--                 Product Categories -->
               
            </aside>
            
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", () => {
                const confirmationText = document.getElementById("confirmation-text");

                // Display email confirmation and payment instructions
                confirmationText.innerText = getSystemConfig("confirmationText");

                // Display product search function
                function searchProducts() {
                    const query = document.getElementById("product-search").value;
                    // Implement search functionality
                    alert(`Searching for: ${query}`);
                }
            });

// Mock function to get system config settings
            function getSystemConfig(key) {
                const config = {
                    confirmationText: "Your order has been shipped and payment instructions are provided below."
                };
                return config[key];
            }

        </script>

    </body>
    <jsp:include page="footer.jsp"/>
</html>
