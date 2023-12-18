<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/18/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Infor Customer</title>
</head>
<body>
<form method="post">
    <div class="mb-3">
        <label class="form-label">Id</label>
        <input type="text" name="id" disabled value="<c:out value="${customer.getId()}"/>" class="form-control" id="id">
    </div>
    <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" name="name" value="<c:out value="${customer.getName()}"/>" class="form-control" id="title">
    </div>
    <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" value="<c:out value="${customer.getEmail()}"/>" id="price">
    </div>
    <div class="mb-3">
        <label class="form-label">Address</label>
        <input type="text" name="address" value="<c:out value="${customer.getAddress()}"/>" class="form-control" id="description">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    <a href="/customer" class="btn btn-info">Cancel</a>
</form>
</body>

</html>
