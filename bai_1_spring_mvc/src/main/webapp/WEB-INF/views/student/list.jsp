<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/19/2025
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <div>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    </div>
    <style>

        /* Căn giữa bảng */
        .table-container {
            display: flex;
            justify-content: center;
        }

        table {
            width: 80%;
            table-layout: fixed;
        }

        th, td {
            text-align: center;
            vertical-align: middle !important;
        }

        /* Căn chỉnh nút "Thêm mới" bên trái và ô tìm kiếm bên phải */
        .action-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        /* Chỉnh kích thước ô input tìm kiếm */
        .search-input {
            width: 250px;
        }

        /* Tăng padding cho hàng trong bảng */
        .table th, .table td {
            padding: 12px;
        }

        /* Căn chỉnh nút "Thêm mới" bên trái và ô tìm kiếm bên phải */
        .action-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        /* Chỉnh kích thước ô input tìm kiếm */
        .search-input {
            width: 180px; /* Giảm kích thước input */
            font-size: 14px; /* Giảm cỡ chữ */
            padding: 5px;
        }

        /* Chỉnh kích thước button tìm kiếm */
        .search-btn {
            font-size: 14px; /* Giảm cỡ chữ */
            padding: 5px 10px; /* Giảm padding */
        }

        /* Tăng padding cho hàng trong bảng */
        .table th, .table td {
            padding: 12px;
        }
        .alert-message {
            position: fixed; /* Giữ cố định khi cuộn */
            bottom: 20px; /* Cách đáy màn hình 20px */
            left: 50%; /* Căn giữa theo chiều ngang */
            transform: translateX(-50%); /* Dịch ngược lại 50% để căn giữa */
            background-color: #28a745; /* Màu xanh lá cho thành công */
            color: white; /* Chữ màu trắng */
            padding: 10px 20px;
            border-radius: 5px; /* Bo góc */
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            z-index: 1000; /* Đảm bảo hiển thị trên các phần khác */
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng */
        }
    </style>
</head>
<body>
<h1 style="text-align: center"> Danh Sách Học Sinh</h1>
<a href="student/create" class="btn btn-primary"> Thêm mới</a>
<div class="d-flex justify-content-end mb-3">
    <form action="/student/search" method="post" class="d-flex">
        <input name="name" value="${param.name}" class="form-control search-input" placeholder="Nhập tên" >
        <button class="btn btn-primary search-btn">Tìm kiếm</button>
    </form>
</div>
<table class="table table-primary">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Xóa</th>
        <th>Chỉnh sửa</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <button type="button" class="btn btn-primary btn-sm" onclick="deleteId('${student.id}')"
                        data-bs-toggle="modal" data-bs-target="#confirmDeleteModal">Xóa
                </button>
            </td>
            <td><a href="/student/edit?id=${student.id}" class="btn btn-primary">Chỉnh sửa</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/student/delete" method="get">
                <div class="modal-header bg-primary text-white">
                    <h5 class="modal-title" id="confirmDeleteLabel">Xác Nhận Xóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id" id="deleteId">
                    <p>Bạn có chắc chắn muốn xóa không?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-dark">Xóa</button>
                </div>
            </form>
        </div>
    </div>
</div>
<c:if test="${not empty message}">
    <div  id="alertMessage" style="color:  white; font-weight: bold;" class="alert-message">
            ${message}
    </div>
    <script>
        // Đợi 3 giây (3000ms) rồi ẩn thông báo
        setTimeout(function() {
            document.getElementById("alertMessage").style.display = "none";
        }, 3000);
    </script>
</c:if>
<script>
    function deleteId(id) {
        document.getElementById("deleteId").value = id;
    }
</script>
</html>
