<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>Danh sách nhân viên</h1>
    </div>
    <div><a href="/nhan-vien/create" class="btn btn-primary">Thêm nhân viên</a></div>

    <table class="table table-striped mt-4">
        <thead>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tên đệm</th>
        <th>Họ</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>SĐT</th>
        <th>Mật khẩu</th>
        <th>Cửa hàng</th>
        <th>Chức vụ</th>
        <th>Trạng thái</th>
        <th>Action</th>
        </thead>

        <tbody>
        <c:forEach items="${datanv.content}" var="nhanVien">
            <tr>
                <td>${nhanVien.ma}</td>
                <td>${nhanVien.ten}</td>
                <td>${nhanVien.tenDem}</td>
                <td>${nhanVien.ho}</td>
                <td>${nhanVien.ngaySinh}</td>
                <td>${nhanVien.gioiTinh}</td>
                <td>${nhanVien.diaChi}</td>
                <td>${nhanVien.sdt}</td>
                <td>${nhanVien.matKhau}</td>
                <td>${nhanVien.cuaHang.ten}</td>
                <td>${nhanVien.chucVu.ten}</td>
                <td>${nhanVien.trangThai == 1? "Đang hoạt động" : "Không hoạt động"}</td>
                <td>
                    <a href="/nhan-vien/edit/${nhanVien.id}" class="btn btn-info">Cập nhật</a>
                    <a href="/nhan-vien/delete/${nhanVien.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${datanv.totalPages - 1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/nhan-vien/index?page=${loop.begin + loop.count - 1}">${loop.begin + loop.count}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
        </tbody>
    </table>
</div>
</body>