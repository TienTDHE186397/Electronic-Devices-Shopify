<%-- 
    Document   : CustomerDetail
    Created on : Nov 4, 2024, 10:29:55 PM
    Author     : Vũ Đức Hải
--%>
<%@ page import="java.util.List"%>
<%@ page import="Entity.HistoryChange"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khách Hàng - ${customerDetail.getName()}</title>
        <style>
            .profile-img{
                width: 220px;
                height: 220px;
                object-fit: contain;
            }
            .profile-img img{
                width: 100%;
                height: 100%;
                object-fit: contain;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container title" style="margin-top: 100px">
            <div class="col-md-7 col-lg-8 col-xl-9">
                <div class="card">
                    <div class="card-body">
                        <h4>Thông tin khách hàng</h4>
                        <form action="customer-detail" method="post" enctype="multipart/form-data">
                            <div class="row form-row">
                                <div class="col-12 col-md-12">
                                    <div class="form-group">
                                        <div class="change-avatar">
                                            <div class="profile-img">
                                                <img src="${customerDetail.getImage()}" alt="User Image">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <div class="form-group">
                                            <input name="id" type="hidden" class="form-control" value="${customerDetail.getPersonID()}">
                                            <input name="userName" type="hidden" class="form-control" value="${sessionScope.user.getName()}">
                                        </div>
                                    </div>        
                                </div>

                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Tên đầy đủ</label>
                                        <input name="name" type="text" class="form-control" value="${customerDetail.getName()}">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Giới tính</label>
                                        <input type="text" name="gender" class="form-control" value="${customerDetail.getGender()}">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="email" name="email" class="form-control"
                                               value="${customerDetail.getEmail()}">
                                        <label>Ngày tháng năm sinh</label>
                                        <div class="cal-icon">
                                            <input type="text" name="dateOfBirth" class="form-control datetimepicker"
                                                   value="${customerDetail.getDateOfBirth()}">
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Số điện thoại</label>
                                        <input type="text" value="${customerDetail.getPhone()}" name="phone" class="form-control">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="address" value="${customerDetail.getAddress()}">
                                    </div>
                                </div>
                            </div>
                            <label>Thay ảnh đại diện</label>        
                            <select name="imgEdit">
                                <option value="0">Ảnh đại diện</option>
                                <c:forEach items="${listImages}" var="img">
                                    <option value="${img.getImage_id()}" >${img.getAlt_text()}</option>
                                </c:forEach>
                            </select>
                            <div class="wrapper" style="margin: 20px;">                           
                                <button type="button" class="btn btn-primary" onclick="addVideo()">Thêm Video</button>
                                <button type="button" class="btn btn-primary" onclick="addImage()">Thêm Ảnh</button>
                                <div id="attributeContainer" style="margin-top: 20px;"></div>
                                <div id="attributeContainer" style="margin-top: 20px;"></div>
                            </div>

                            <div class="submit-section">
                                <button type="submit" class="btn btn-primary submit-btn">Lưu thông tin</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <div class="container mt-4">
            <h2>Lịch sử thay đổi</h2>
            <div>
                <label><input type="checkbox" onclick="toggleColumn(0)" checked> ID người dùng</label>
                <label><input type="checkbox" onclick="toggleColumn(1)" checked> Email</label>
                <label><input type="checkbox" onclick="toggleColumn(2)" checked> Họ tên</label>
                <label><input type="checkbox" onclick="toggleColumn(3)" checked> Giới tính</label>
                <label><input type="checkbox" onclick="toggleColumn(4)" checked> Điện thoại</label>
                <label><input type="checkbox" onclick="toggleColumn(5)" checked> Địa chỉ</label>
                <label><input type="checkbox" onclick="toggleColumn(6)" checked> Người cập nhật</label>
                <label><input type="checkbox" onclick="toggleColumn(7)" checked> Ngày cập nhật</label>
            </div>
            <table class="table table-bordered" id="table-history">
                <thead>
                    <tr>
                        <th>Person ID</th>
                        <th>Email</th>
                        <th>Họ tên</th>
                        <th>Giới tính</th>
                        <th>Điện thoại</th>
                        <th>Địa chỉ</th>
                        <th>Người cập nhật</th>
                        <th>Ngày cập nhật</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="history" items="${historyList}">
                        <tr>
                            <td>${history.personID}</td> <!-- Hiển thị Person ID -->
                            <td>${history.email}</td>    <!-- Hiển thị Email -->
                            <td>${history.fullName}</td> <!-- Hiển thị Họ tên -->
                            <td>${history.gender}</td>   <!-- Hiển thị Giới tính -->
                            <td>${history.mobile}</td>   <!-- Hiển thị Điện thoại -->
                            <td>${history.address}</td>  <!-- Hiển thị Địa chỉ -->
                            <td>${history.updatedBy}</td> <!-- Hiển thị Người cập nhật -->
                            <td>${history.updatedDate}</td> <!-- Hiển thị Ngày cập nhật -->
                        </tr>
                    </c:forEach>

                    <c:if test="${empty historyList}">
                        <tr>
                            <td colspan="8" class="text-center">Không có dữ liệu.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <!-- Phân trang -->
        <div class="pagination container" style="display: flex;justify-content: center;width: 100%">

            <c:forEach var="i" begin="1" end="${totalPages}">
                <c:choose>
                    <c:when test="${i == currentPage}">
                        <strong style="padding: 20px">${i}</strong> <!-- Hiển thị trang hiện tại -->
                    </c:when>
                    <c:otherwise>
                        <a style="padding: 20px;" href="customer-detail?id=${customerDetail.getPersonID()}&pageIndex=${i}">${i}</a> <!-- Liên kết đến các trang khác -->
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>                               
    </body>
    <script>
        let attributeCount = 0; // Khởi tạo attributeCount bên ngoài hàm
        function confirmDelete() {
            console.log('Confirm delete called');
            return confirm('Are you sure you want to delete this attribute?');
        }

        function addVideo() {
            const attributeContainer = document.getElementById('attributeContainer');
            const newRow = document.createElement('div');
            newRow.classList.add('form-row', 'mb-2');
            newRow.innerHTML = `
                <div class="form-group col-md-5">
                    <input type="text" placeholder="Nhập Tên Video" style="font-weight: bold;" name="vidName" class="form-control" required>
                </div>
                <div class="form-group col-md-5">
                    <input name="vidValue" type="file" accept="video/*, image/*" class="form-control" required>
                </div>
                <div class="form-group col-md-2">
                    <button type="button" class="btn btn-danger delete-button">Xóa</button>
                </div>
`;
            attributeContainer.appendChild(newRow);
            attributeCount++;

            // Gán sự kiện xóa cho nút "Xóa" mới tạo
            newRow.querySelector('.delete-button').addEventListener('click', function () {
                newRow.remove();
            });
        }
        function addImage() {
            const attributeContainer = document.getElementById('attributeContainer');
            const newRow = document.createElement('div');
            newRow.classList.add('form-row', 'mb-2');
            newRow.innerHTML = `
                <div class="form-group col-md-5">
                    <input type="text" placeholder="Nhập Tên Ảnh " style="font-weight: bold;" name="vidImageName" class="form-control" required>
                </div>
                <div class="form-group col-md-5">
                    <input name="vidImageValue" type="file" accept="video/*, image/*" class="form-control" required>
                </div>
                <div class="form-group col-md-2">
                    <button type="button" class="btn btn-danger delete-button">Xóa</button>
                </div>
`;
            attributeContainer.appendChild(newRow);
            attributeCount++;

            // Gán sự kiện xóa cho nút "Xóa" mới tạo
            newRow.querySelector('.delete-button').addEventListener('click', function () {
                newRow.remove();
            });
        }

        function toggleColumn(columnIndex) {
            const table = document.getElementById("table-history");
            const rows = table.rows;

            for (let i = 0; i < rows.length; i++) {
                const cell = rows[i].cells[columnIndex];
                if (cell) {
                    cell.style.display = cell.style.display === "none" ? "" : "none";
                }
            }
        }
    </script>
</html>
