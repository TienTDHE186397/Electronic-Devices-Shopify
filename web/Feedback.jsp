<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="personID" value="${session.user.PersonID}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Feedback</title>
        <link href="https://cdnjs.cloudflare.com/api/placeholder/400/320" rel="stylesheet">
        <script src="https://cdn.tiny.cloud/1/qnmf6c0u3j7wk6wsljsqwke06htozhifzb9v9fs3pw2ed7vx/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
        <style>
            :root {
                --primary-color: #4CAF50;
                --secondary-color: #45a049;
                --text-color: #333;
                --background-color: #f2f2f2;
            }

            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body {
                font-family: Arial, sans-serif;
                line-height: 1.6;
                color: var(--text-color);
                background-color: var(--background-color);
            }

            .container {
                width: 100%;
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
                display: flex;
                flex-wrap: wrap;
            }

            header {
                width: 100%;
                background-color: var(--primary-color);
                color: white;
                text-align: center;
                padding: 1rem;
            }

            main {
                flex: 3;
                padding: 20px;
            }

            aside {
                flex: 1;
                padding: 20px;
                background-color: white;
                margin-left: 20px;
            }

            .feedback-form {
                background-color: white;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="email"],
            input[type="tel"],
            select,
            textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
            }

            .star-rating {
                display: flex;
                flex-direction: row-reverse;
                justify-content: flex-end;
            }

            .star-rating input {
                display: none;
            }

            .star-rating label {
                cursor: pointer;
                font-size: 30px;
                color: #ddd;
            }

            .star-rating label:before {
                content: '★';
            }

            .star-rating input:checked ~ label {
                color: #ffca08;
            }

            button {
                background-color: var(--primary-color);
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                background-color: var(--secondary-color);
            }

            @media (max-width: 768px) {
                .container {
                    flex-direction: column;
                }

                aside {
                    margin-left: 0;
                    margin-top: 20px;
                }

                .star-rating {
                    justify-content: center;
                }
            }

            @media (max-width: 480px) {
                .form-group {
                    margin-bottom: 15px;
                }

                label {
                    font-size: 14px;
                }

                input[type="text"],
                input[type="email"],
                input[type="tel"],
                select,
                textarea {
                    padding: 8px;
                    font-size: 14px;
                }

                .star-rating label {
                    font-size: 24px;
                }

                button {
                    padding: 8px 16px;
                    font-size: 14px;
                }
            }
        </style>
    </head>
    <body>

        <header>
            <!-- Footer start -->
            <%@include file="header.jsp" %>
            <!-- Footer end -->
        </header>
        <div class="container">
            <main>
                <form class="feedback-form" action="${pageContext.request.contextPath}/Feedback" method="post" enctype="multipart/form-data" onsubmit="return validateForm(event)">
                    <div class="form-group">
                        <label for="fullName">Full Name:</label>
                        <input type="hidden" value="${sessionScope.user.getPersonID()}" name="customerId">
                        
                        <input type="text" value="${sessionScope.user.getName()}" id="fullName" readonly>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <input type="text" value="${sessionScope.user.getGender()}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" value="${sessionScope.user.getEmail()}" readonly>
                    </div>
                        
                    <div class="form-group">
                         <c:if test="${not empty requestScope.orderProducts}">
                           <input type="hidden" value="${requestScope.orderProducts[0].orderID}" name="orderID" />
                         </c:if>    
                        <label for="product">Product:</label>
                        <select id="product" name="productId">
                        <c:forEach items="${requestScope.orderProducts}" var="product">
                        
                        <option value="${product.productID}">${product.productName}</option>
                        </c:forEach>
                        </select>
                        
                    
                    </div>
                    <div class="form-group">
                        <label>Rating:</label>
                        <div class="star-rating">
                            <input type="radio" id="star5" name="rating" value="5" /><label for="star5"></label>
                            <input type="radio" id="star4" name="rating" value="4" /><label for="star4"></label>
                            <input type="radio" id="star3" name="rating" value="3" /><label for="star3"></label>
                            <input type="radio" id="star2" name="rating" value="2" /><label for="star2"></label>
                            <input type="radio" id="star1" name="rating" value="1" /><label for="star1"></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="feedback">Feedback:</label>
                        <textarea style="height: 200px;" placeholder="Write Your feedback......." name="feedback" rows="6" onchange = "validateFeedback(this)"></textarea>
                        <br/>
                    </div>
                    <div class="form-group">
                        <label for="images">Attach Images (Max 5 images, .jpg/.png only):</label>
                        <input type="file" id="images" name="images" accept="image/jpeg,image/png" multiple onchange="validateImages(this)">
                        <small class="text-muted">Select up to 5 images</small>
                        <input type="text" name="descriptionimg" placeholder="Write Your images description......." name="feedback" rows="1" onchange="validateDesc(this)">
                    </div>
                    <div class="form-group">
                        <label for="videos">Attach Videos (Max 3 videos, 20MB each, .mp4 only):</label>
                        <input type="file" id="videos" name="videos" accept="video/mp4" multiple onchange="validateVideos(this)">
                        <small class="text-muted">Select up to 3 videos, max 10MB each</small>
                        <input type="text" name="descriptionvid" placeholder="Write Your videos description......." name="feedback" rows="1" onchange="validateDesc(this)">
                    </div>

                    
                    <button type="submit" >Submit Feedback</button>
                </form>
            </main>

        </div>
        <!-- Footer start -->
        <%@include file="footer.jsp" %>
        <!-- Footer end -->
    </body>
    
   
           <script>
   // Validation functions for the form
function validateImages(input) {
    const files = input.files;
    
    
    // Check number of files
    if (files.length > 5) {
        alert(`Please select maximum 5 images`);
        input.value = '';
        return false;
    }
    
    // Check each file
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        
        // Check file type
        if (!file.type.match('image/jpeg') && !file.type.match('image/png')) {
            alert('Please upload only JPG or PNG images');
            input.value = '';
            return false;
        }
        
        // Check file size
        if (file.size > 5 * 1024 * 1024) {
            alert(`Image ${file.name} is too large. Maximum size is ${maxSizeMB}MB`);
            input.value = '';
            return false;
        }
    }
    
    return true;
}

function validateVideos(input) {
    const files = input.files;
   // 20MB max per video
    
    // Check number of files
    if (files.length > 3) {
        alert(`Please select maximum 3 videos`);
        input.value = '';
        return false;
    }
    
    // Check each file
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        
        // Check file type
        if (!file.type.match('video/mp4')) {
            alert('Please upload only MP4 videos');
            input.value = '';
            return false;
        }
        
        // Check file size
        if (file.size > 20 * 1024 * 1024) {
            alert('Video ${file.name} is too large. Maximum size is 20 MB');
            input.value = '';
            return false;
        }
    }
    
    return true;
}

function validateDesc(input) {
    if (!input.value || input.value.trim() === '') {
        alert('Please enter a description');
        return false;
    }
    return true;
}
function validateRating() {
    rating = document.querySelector('input[name="rating"]:checked');
    if (!rating) {
        alert('Please select a rating');
        return false;
    }
    return true;
}

function validateFeedback(textarea) {
    const minLength = 10; // Minimum characters required
    const maxLength = 1000; // Maximum characters allowed
    
    const text = textarea.value.trim();
    
    if (text.length < minLength) {
        alert(`Please enter your feedback at least 10 character for feedback`);
        return false;
    }
    
    if (text.length > maxLength) {
        alert(`Feedback cannot exceed 1000 characters`);
        textarea.value = text.substring(0, maxLength);
        return false;
    }
    
    return true;
}

// Form submission validation
function validateForm(event) {
    // Fix: Corrected form element selection
    const form = event.currentTarget;
    const imagesInput = form.querySelector('#images');
    const videosInput = form.querySelector('#videos');
    const feedback = form.querySelector('textarea[name="feedback"]');
    const imgDesc = form.querySelector('input[name="descriptionimg"]');
    const vidDesc = form.querySelector('input[name="descriptionvid"]');
    
    // Validate rating
    if (!validateRating()) {
        event.preventDefault();
        return false;
    }
    
    // Validate feedback
    if (!validateFeedback(feedback)) {
        event.preventDefault();
        return false;
    }
    
    if (imagesInput.files.length === 0 && videosInput.files.length === 0) {
        alert('Please select at least one image or video');
        event.preventDefault();
        return false;
    }
  
    
    // Validate media and descriptions
    if (imagesInput.files.length > 0 || videosInput.files.length > 0) {
        if (imagesInput.files.length > 0 && !validateDesc(imgDesc)) {
            alert('please enter description for images');
            event.preventDefault();
            return false;
        }
        if(videosInput.files.length === 0){
            alert('please provide feedback video');
            event.preventDefault();
            return false;
        }
        
        if (videosInput.files.length > 0 && !validateDesc(vidDesc)) {
            alert('please enter description for videos');
            event.preventDefault();
            return false;
        }
    }
    
    return true;
}
document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.feedback-form');
    if (form) {
        form.addEventListener('submit', validateForm);
    }
});
</script>

</html>