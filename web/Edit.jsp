
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Movies</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">

            <div id="editEmployeeModal" 
                 <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit" method="post">
                        <c:forEach items="${detail}" var="detail">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Movies</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input value="${detail.productId}" name="id" type="text" class="form-control" readonly required>
                            </div>					
                            <div class="form-group">
                                <label>Name</label>
                                <input value="${detail.productName}" name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Genre</label>
                                <input value="${detail.genre}" name="genre" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Director</label>
                                <input value="${detail.director}" name="director" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Performer</label>
                                <input value="${detail.performer}" name="performer" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input value="${detail.price}" name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>AgeRating</label>
                                <input value="${detail.age}" name="age" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input value="${detail.image}" name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>ImageBanner</label>
                                <input value="${detail.imageBanner}" name="banner" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description"  class="form-control"  required>${detail.description}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Views</label>
                                <input  value="${detail.view}" name="view" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Time</label>
                                <input value="${detail.time}" name="time" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>releaseDate</label>
                                <input value="${detail.releaseDate}" name="date" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>quantitySold</label>
                                <input value="${detail.quantitySold}" name="sold" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>CategoryID</label>
                                <input value="${detail.categoryId}" name="categoryid" type="text" class="form-control" required>
                            </div>
                            </c:forEach>
                            <div class="form-group">
                                <label>Location</label>
                                <select name="cinema" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listCC}" var="o">
                                        <option value="${o.cinemaid}">${o.cinemaname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default" data-dismiss="modal" value="Cancel"><a href="manager">Cancel</a></button>
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>


    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>

