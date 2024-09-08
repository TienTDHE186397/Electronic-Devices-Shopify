
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
                    <form action="editcarlendarafterset" method="post">
                        <c:forEach items="${detail}" var="detail">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Calendar</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Calendar ID</label>
                                <input value="${detail.calendarId}" name="calendarId" type="text" class="form-control" readonly required>
                            </div>					
                            <div class="form-group">
                                <label>Cinema Id</label>
                                <input value="${detail.cinemaId}" name="cinemaId" type="text" class="form-control"  readonly required>
                            </div>
                                <div class="form-group">
                                    <label>Product Id</label>
                                    <input value="${detail.productId}" name="cinemaId" type="text" class="form-control"  readonly required>
                                </div>
                            <div class="form-group">
                                <label>Movie Date</label>
                                <input value="${detail.movieDate}" name="movieDate" type="text" class="form-control" readonly required>
                            </div>
                            <div class="form-group">
                                <label>Slot 1</label>
                                <input value="${detail.slot1}" name="slot1" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Slot 2</label>
                                <input value="${detail.slot2}" name="slot2" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Slot 3</label>
                                <input value="${detail.slot3}" name="slot3" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Slot 4</label>
                                <input value="${detail.slot4}" name="slot4" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Slot 5</label>
                                <input value="${detail.slot5}" name="slot5" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Room ID</label>
                                <input value="${detail.roomId}" name="roomid" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Status</label>
                                <input value="${detail.status}" name="status" type="text" class="form-control" required>
                            </div>



                            </c:forEach>

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default" data-dismiss="modal" value="Cancel"><a href="viewcalendar">Cancel</a></button>
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

