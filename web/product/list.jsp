<%--
  Created by IntelliJ IDEA.
  User: konkon
  Date: 04/09/2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<p>
    <a href="products?action=create">Create new Product</a>
</p>
<p>Search Product: </p>
<form method="post">
    <input type="text" name="searchByName" id="searchByName" placeholder="Enter product name">
    <input type="submit" value="Search">
</form>

    <table border="2">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>price</td>
            <td>description</td>
            <td>supplier</td>
            <td>edit</td>
            <td>delete</td>
        </tr>
        <c:forEach items="${requestScope['products']}" var="product">
            <tr>
           <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getSupplier()}</td>
            <td><a href="products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="products?action=delete&id=${product.getId()}">delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
