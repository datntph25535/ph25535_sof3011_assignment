<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cửa hàng</title>
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
        <h1>Danh sách khách hàng</h1>
    </div>
    <div><a href="/khach-hang/create" class="btn btn-primary">Thêm cửa hàng</a></div>

    <table class="table table-striped mt-4">
        <thead>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tên đệm</th>
        <th>Họ</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Thành phố</th>
        <th>Quốc gia</th>
        <th>Mật khẩu</th>
        <th>Action</th>
        </thead>

        <tbody>
        <%--@elvariable id="lstCuaHang" type="org.springframework.data.domain.Page"--%>
        <c:forEach items="${datakh.content}" var="khachHang">
            <tr>
                <td>${khachHang.ma}</td>
                <td>${khachHang.ten}</td>
                <td>${khachHang.tenDem}</td>
                <td>${khachHang.ho}</td>
                <td>${khachHang.ngaySinh}</td>
                <td>${khachHang.sdt}</td>
                <td>${khachHang.diaChi}</td>
                <td>${khachHang.thanhPho}</td>
                <td>${khachHang.quocGia}</td>
                <td>${khachHang.matKhau}</td>
                <td>
                    <a href="/khach-hang/edit/${khachHang.id}" class="btn btn-info">Cập nhật</a>
                    <a href="/khach-hang/delete/${khachHang.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${datakh.totalPages - 1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/khach-hang/index?page=${loop.begin + loop.count - 1}">${loop.begin + loop.count}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</div>
</body>