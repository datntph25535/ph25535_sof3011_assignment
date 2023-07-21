<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h1>Thêm nhân viên</h1>
    </div>

    <%--@elvariable id="nhanVien" type="sof3021.sd17306.lt1.viewmodel.NhanVienViewModel"--%>
    <form:form method="post" modelAttribute="nhanVien" action="${action}">
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
            <form:label path="gioiTinh">Giới tính</form:label>
            <form:radiobutton path="gioiTinh" value="Nam"/> <form:label path="gioiTinh"
                                                                        for="gioiTinh1"> Nam</form:label>
            <form:radiobutton path="gioiTinh" value="Nữ"/> <form:label path="gioiTinh" for="gioiTinh2">Nữ </form:label>
            <form:errors cssClass="text-danger" path="gioiTinh"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="diaChi">Địa chỉ</form:label>
            <form:input path="diaChi" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="diaChi"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="sdt">SĐT</form:label>
            <form:input path="sdt" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="sdt"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="matKhau">Mật khẩu</form:label>
            <form:input path="matKhau" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="matKhau"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="trangThai">Cửa hàng</form:label>
            <form:select path="idCH">
                <c:forEach items="${ listCH }" var="ch">
                    <form:option value="${ch.id}">${ ch.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="trangThai"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="trangThai">Chức vụ</form:label>
            <form:select path="idCV">
                <c:forEach items="${ listCV }" var="cv">
                    <form:option value="${cv.id}">${ cv.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="trangThai"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="trangThai">Trạng thái</form:label>
            <form:radiobutton path="trangThai" value="1"/> <form:label path="trangThai"
                                                                       for="trangThai1">Đang hoạt động </form:label>
            <form:radiobutton path="trangThai" value="0"/> <form:label path="trangThai"
                                                                       for="trangThai2">Không hoạt động </form:label>
            <form:errors cssClass="text-danger" path="trangThai"></form:errors>
        </div>

        <div><input type="submit" class="btn btn-primary mt-3" value="Tạo"></div>
    </form:form>
</div>
</body>