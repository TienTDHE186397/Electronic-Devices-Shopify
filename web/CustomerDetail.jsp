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
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container title" style="margin-top: 100px">
            <div class="col-md-7 col-lg-8 col-xl-9">
                <div class="card">
                    <div class="card-body">
                        <h4>Thông tin khách hàng</h4>
                        <form action="customer-detail" method="post">
                            <div class="row form-row">
                                <div class="col-12 col-md-12">
                                    <div class="form-group">
                                        <div class="change-avatar">
                                            <div class="profile-img">
                                                <img src="img/default-phone.jpg" alt="User Image">
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Tên đầy đủ</label>
                                        <input type="text" class="form-control" value="${customerDetail.getName()}">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Giới tính</label>
                                        <input type="text" class="form-control" value="${customerDetail.getGender()}">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="email" class="form-control"
                                               value="${customerDetail.getEmail()}">
                                        <label>Ngày tháng năm sinh</label>
                                        <div class="cal-icon">
                                            <input type="text" class="form-control datetimepicker"
                                                   value="${customerDetail.getDateOfBirth()}">
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <label>Số điện thoại</label>
                                        <input type="text" value="${customerDetail.getPhone()}" class="form-control">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" value="${customerDetail.getAddress()}">
                                    </div>
                                </div>
                            </div>
                            <div class="upload-img">
                                <div class="change-photo-btn">
                                    <span><i class="fa fa-upload"></i> Upload Photo</span>
                                    <input type="file" class="upload">
                                </div>
                                <small class="form-text text-muted">Allowed JPG, GIF or PNG. Max
                                    size of 2MB</small>
                            </div>
                            <select name="img">
                                <option></option>
                                <option></option>
                            </select>
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
            <table class="table table-bordered">
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
        <div class="pagination">
            <c:if test="${currentPage > 1}">
                <a href="customer-detail?personID=${customerDetail.getPersonID()}&pageIndex=${currentPage - 1}">Trang trước</a>
            </c:if>

            <c:forEach var="i" begin="1" end="${totalPages}">
                <c:choose>
                    <c:when test="${i == currentPage}">
                        <strong>${i}</strong> <!-- Hiển thị trang hiện tại -->
                    </c:when>
                    <c:otherwise>
                        <a href="customer-detail?personID=${customerDetail.getPersonID()}&pageIndex=${i}">${i}</a> <!-- Liên kết đến các trang khác -->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage < totalPages}">
                <a href="customer-detail?personID=${personID}&pageIndex=${currentPage + 1}">Trang tiếp theo</a>
            </c:if>
        </div>                               
    </body>
</html>
