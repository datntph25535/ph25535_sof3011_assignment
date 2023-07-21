<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>Cập nhật chức vụ</h1>
    </div>
    <%--@elvariable id="nhanVien" type="sof3021.sd17306.lt1.viewmodel.NhanVienViewModel"--%>
    <form:form method="post" modelAttribute="khachHang" action="/khach-hang/update/${khachHang.id}">
        <div class="mt-3">
            <form:label path="ma">Mã</form:label>
            <form:input path="ma" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="ma"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="ten">Tên</form:label>
            <form:input path="ten" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="ten"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="tenDem">Tên đệm</form:label>
            <form:input path="tenDem" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="tenDem"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="ho">Họ</form:label>
            <form:input path="ho" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="ho"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="ngaySinh">Ngày sinh</form:label>
            <form:input type="date" path="ngaySinh" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="ngaySinh"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="sdt">Sđt</form:label>
            <form:input path="sdt" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="sdt"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="diaChi">Địa chỉ</form:label>
            <form:input path="diaChi" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="diaChi"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="thanhPho">Thành phố</form:label>
            <form:input path="thanhPho" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="thanhPho"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="quocGia">Quốc gia</form:label>
            <form:input path="quocGia" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="quocGia"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="matKhau">Mật khẩu</form:label>
            <form:input path="matKhau" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="matKhau"></form:errors>
        </div>

        <div><input type="submit" class="btn btn-primary mt-3" value="Sửa"></div>
    </form:form>
</div>
</body>
</html>