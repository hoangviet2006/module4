<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/19/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../../bootstrap.jsp"></c:import>
    <style>
        /* Căn bảng vào giữa màn hình */
        .table-container {
            width: 80%;
            max-width: 900px;
            margin: auto;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Bo tròn các góc bảng và xóa đường kẻ giữa các cột */
        table {
            width: 100%;
            border-collapse: separate; /* Không gộp đường viền */
            border-spacing: 0; /* Loại bỏ khoảng cách giữa các ô */
            border-radius: 15px; /* Bo tròn bảng */
            overflow: hidden;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            border: 2px solid black; /* Đường viền ngoài của bảng */
        }

        /* Bo tròn góc của bảng */
        th:first-child {
            border-top-left-radius: 15px;
        }

        th:last-child {
            border-top-right-radius: 15px;
        }

        tr:last-child td:first-child {
            border-bottom-left-radius: 15px;
        }

        tr:last-child td:last-child {
            border-bottom-right-radius: 15px;
        }

        /* Định dạng tiêu đề bảng */
        th {
            background-color: #007bff;
            color: white;
            padding: 15px;
        }

        /* Xóa đường kẻ giữa các ô */
        th, td {
            padding: 10px;
            text-align: center;
            border: none; /* Loại bỏ viền giữa các ô */
        }

        /* Hiệu ứng hover */
        tr:hover {
            background-color: rgba(0, 0, 255, 0.2);
            transition: background-color 0.3s ease-in-out;
        }

        /* Định dạng nút */
        .btn {
            border-radius: 10px;
        }

    </style>
</head>
<c:import url="../../navbar.jsp"></c:import>
<body>
<h2 class="text-center mb-4 text-dark">Danh Sách Người Dùng</h2>
<div class="d-flex justify-content-between align-items-center mb-4">
    <a href="human/create" class="btn btn-primary tex-dark"> Thêm mới</a>
    <div class="d-flex justify-content-end mb-4">
        <form action="/human/search" method="post" class="d-flex">
            <input class="form-control me-2" name="name" value="${param.name}" placeholder="Nhập tên">
            <button class="btn btn-primary tex-dark">Search</button>
        </form>
    </div>
</div>
<table class="table table-primary table-hover text-center  ">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Địa chỉ</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach items="${human}" var="human">
        <tr>
            <td>${human.id}</td>
            <td>${human.name}</td>
            <td>${human.address}</td>
            <td><a href="/human/${human.id}/detail" class=" btn btn-primary">Chi tiết</a></td>
        </tr>
    </c:forEach>
</table>
<div class="position-fixed bottom-0 end-0 p-3">
    <div id="myToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
         aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                ${message} <!-- Hiển thị thông báo từ Backend -->
            </div>
            <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>
<script>
    window.onload = function () {
        var toastEl = document.getElementById('myToast');
        if (toastEl.innerText.trim() !== "") { // Kiểm tra nếu có thông báo
            var toast = new bootstrap.Toast(toastEl, {delay: 2000});
            toast.show();
            // Tự động ẩn sau 3 giây
            setTimeout(function () {
                toast.hide();
            }, 2000);
        }
    };
</script>
</body>
</html>
