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
        <h1>Thêm chi tiết sp</h1>
    </div>

    <%--@elvariable id="nhanVien" type="sof3021.sd17306.lt1.viewmodel.NhanVienViewModel"--%>
    <form:form method="post" modelAttribute="chiTietSP" action="/chi-tiet-sp/store">
        <div class="mt-3">
            <form:label path="namBH">Sản phẩm</form:label>
            <form:select path="idSP">
                <c:forEach items="${ listSP }" var="sp">
                    <form:option value="${sp.id}">${ sp.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="namBH"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="namBH">NSX</form:label>
            <form:select path="idNsx">
                <c:forEach items="${ listNSX }" var="nsx">
                    <form:option value="${nsx.id}">${ nsx.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="namBH"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="namBH">Màu sắc</form:label>
            <form:select path="idMauSac">
                <c:forEach items="${ listMS }" var="ms">
                    <form:option value="${ms.id}">${ ms.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="namBH"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="namBH">Dòng SP</form:label>
            <form:select path="idDongSP">
                <c:forEach items="${ listDongSP }" var="dsp">
                    <form:option value="${dsp.id}">${ dsp.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors cssClass="text-danger" path="namBH"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="namBH">Năm BH</form:label>
            <form:input path="namBH" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="namBH"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="moTa">Mô tả</form:label>
            <form:input path="moTa" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="moTa"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="soLuongTon">Số lượng tồn</form:label>
            <form:input path="soLuongTon" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="soLuongTon"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="giaNhap">Giá nhập</form:label>
            <form:input path="giaNhap" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="giaNhap"></form:errors>
        </div>
        <div class="mt-3">
            <form:label path="giaBan">Giá bán</form:label>
            <form:input path="giaBan" cssClass="form-control"></form:input>
            <form:errors cssClass="text-danger" path="giaBan"></form:errors>
        </div>


        <div><input type="submit" class="btn btn-primary mt-3" value="Tạo"></div>
    </form:form>
</div>
</body>