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
        <h1>Cập nhập sản phẩm</h1>
    </div>
    <form:form method="post" modelAttribute="sanPham" action="/san-pham/update/${sanPham.id}">
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


        <div><input type="submit" class="btn btn-primary mt-3" value="Sửa"></div>
    </form:form>
</div>
</body>
</html>