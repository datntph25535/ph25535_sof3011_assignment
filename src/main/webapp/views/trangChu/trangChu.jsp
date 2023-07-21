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
<p style="text-align: center">
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="chuc-vu/index">Chức vụ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="cua-hang/index">Cửa hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="nhan-vien/index">Nhân viên</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="khach-hang/index">Khách hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="san-pham/index">Sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="NSX/index">NSX</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="mau-sac/index">Màu sắc</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="dong-sp/index">Dòng SP</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="chi-tiet-sp/index">Chi tiết SP</a>
    </li>
</ul>
</p>

<article>
    <jsp:include page=""></jsp:include>
</article>
</body>