<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/19/2025
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <div>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    </div>
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card shadow-lg p-4 rounded-4" style="width: 400px;">
        <h2 class="text-center mb-4 text-primary">Thêm Mới Học Sinh</h2>
        <form action="/student/create" method="post">
            <input type="hidden" name="id" >
            <div class="mb-3">
                <label class="form-label">Tên học sinh</label>
                <input type="text" name="name" class="form-control" placeholder="Nhập tên" required>
            </div>
            <div class="d-flex justify-content-between">
                <a href="/student" class="btn btn-secondary">Quay lại</a>
                <button type="submit" class="btn btn-primary">Lưu</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
