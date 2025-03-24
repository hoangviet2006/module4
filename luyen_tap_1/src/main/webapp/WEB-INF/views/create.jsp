<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/19/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../../bootstrap.jsp"></c:import>
    <style>
        /* Căn giữa card và làm nổi bật */
        .container {
            position: relative;
            z-index: 1;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Hiệu ứng đẹp cho card */
        .card {
            width: 400px;
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            background: rgba(255, 255, 255, 0.9); /* Màu trắng trong suốt */
        }

        /* Tiêu đề nổi bật */
        .card h2 {
            font-weight: bold;
        }

        /* Form */
        .form-control {
            border-radius: 10px;
        }

        /* Nút bấm */
        .btn-primary {
            background-color: #007bff;
            border-radius: 10px;
            transition: 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            border-radius: 10px;
        }
    </style>
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card shadow-lg p-4 rounded-4" style="width: 400px;">
        <h2 class="text-center mb-4 text-dark">Thêm Mới Người Dùng</h2>
        <form:form action="/human/create" method="post" modelAttribute="human">
            <form:hidden  path="id"/>
            <div class="mb-3">
                <label class="form-label">Tên </label>
                <form:input  class="form-control" placeholder="Nhập tên"  path="name"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày sinh </label>
                <form:input  type="date" class="form-control" placeholder="Nhập ngày sinh" path="date"/>
                <form:errors path="date" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính </label>
                <form:select  class="form-control" path="gender">
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                </form:select>
                <form:errors path="gender" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <form:input  class="form-control" placeholder="Nhập địa chỉ" path="phoneNumber"/>
                <form:errors path="phoneNumber" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ </label>
                <form:textarea  class="form-control" placeholder="Nhập địa chỉ" path="address"></form:textarea>
                <form:errors path="address" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Công Việc </label>
                <form:input path="job" class="form-control" placeholder="Nhập địa chỉ" />
                <form:errors path="job" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc tịch </label>
                <form:input path="nationality" class="form-control" placeholder="Nhập quốc tịch"/>
                <form:errors path="nationality" cssClass="text-danger"/>
            </div>
            <div class="d-flex justify-content-between">
                <a href="/human" class="btn btn-secondary">Quay lại</a>
                <form:button type="submit" class="btn btn-primary">Lưu</form:button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
