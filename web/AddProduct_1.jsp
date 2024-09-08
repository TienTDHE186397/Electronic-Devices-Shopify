
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
                    <form action="add" method="post">

                        <div class="modal-header">						
                            <h4 class="modal-title">Add Movies</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">

                            </div>					
                            <div class="form-group">
                                <label>Name</label>
                                <input  name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Genre</label>
                                <input name="genre" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Director</label>
                                <input name="director" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Performer</label>
                                <input name="performer" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>AgeRating</label>
                                <input name="age" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>ImageBanner</label>
                                <input  name="banner" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Views</label>
                                <input name="view" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Time</label>
                                <input name="time" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>releaseDate</label>
                                <input name="date" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>quantitySold ( Integer )</label>
                                <input name="sold" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>CategoryID ( Integer )</label>
                                <input name="categoryid" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Status ( Integer )</label>
                                <input value="2" name="status" type="text" class="form-control" required readonly>
                            </div>

                            <div class="form-group">
                                <label>Location</label>
                                <select name="cinema" class="form-select" aria-label="Default select example">

                                    <option value="1">ALV Thanh Xuân</option>
                                    <option value="2">ALV Mỹ Đình</option>
                                    <option value="3">ALV Long Biên</option>
                                    <option value="4">ALV Hòa Lạc</option>

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

