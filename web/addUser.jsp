<%-- 
    Document   : addUser
    Created on : Sep 14, 2024, 1:52:27 PM
    Author     : nghie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <style>


            #centeredInput {
                width: 500px; /* Đặt chiều rộng của input */
                height: 40px; /* Đặt chiều cao của input */
                box-sizing: border-box; /* Đảm bảo padding và border được bao gồm trong kích thước tổng */
                text-align: center; /* Căn giữa theo chiều ngang */
                padding: 0; /* Loại bỏ padding */
                line-height: 40px; /* Căn giữa theo chiều dọc */
            }

            /* Giữ văn bản placeholder ở giữa */
            #centeredInput::placeholder {
                text-align: center;
            }


        </style>
    </head>
    <body>

        <div class="row">
            <div class="col-12 mb-3 mb-lg-"> 
                <div class="position-relative card table-nowrap table-card ">
                    <div style="margin-bottom: 5px">
                        <h1>Add User</h1>
                    </div>
                    <center>

                        <div class="modal-body">
                            <form action="addUser" method="post">
                                <div class="form-group">
                                    <label>Họ và tên</label>
                                    <input type="text" class="form-control" id="centeredInput" name="name"/>
                                </div>
                                <div class="form-group">
                                    <label>Giới tính</label>
                                    <select id="centeredInput" name="gender" class="form-select">
                                        <option value="Nam">Nam</option>
                                        <option value="Nữ">Nữ</option>
                                        <option value="Khác">Khác</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Ngày sinh</label>
                                    <input type = "date" class="form-control" id="centeredInput" name="dob"/>
                                </div>
                                <div class="form-group">
                                    <label>Ngày bắt đầu</label>
                                    <input type = "date" class="form-control" id="centeredInput" name="sd"/>
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control" id="centeredInput" name="address"/>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" id="centeredInput" name="email"/>
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại</label>
                                    <input type="text" class="form-control" id="centeredInput" name="phone"/>
                                </div>
                                <div class="form-group">
                                    <label>Vai trò</label>
                                    <select id="centeredInput" name="roleid" class="form-select">
                                        <option value="2">Marketing</option>
                                        <option value="3">Sale</option>
                                        <option value="4">SaleManager</option>
                                        <option value="5">Admin</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Mật khẩu</label>
                                    <input type="text" class="form-control" id="centeredInput" name="pass"/>
                                </div>
                                <input type="submit" class="form-control"/>
                            </form>
                        </div>

                </div>
            </div>

        </div>


    </center>
</body>
</html>
