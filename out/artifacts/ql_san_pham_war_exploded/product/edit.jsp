<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: konkon
  Date: 04/09/2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<c:if test="${requestScope['message']!=null}">
    <span style="color: green">${requestScope['message']}</span>
</c:if>
<p>
    <a href="products"> Back to list</a>
</p>
<form method="post">
    <fieldset>
        <legend>product Information</legend>
        <table>
            <tr>
                <td>price:</td>
                <td><input type="text" id="price" name="price" value = '${requestScope["product"].getPrice()}'></td>
            </tr>
            <tr>
                <td>description:</td>
                <td><input type="text" id="description" name="description" value="${requestScope['product'].getDescription()}"></td>
            </tr>
            <tr>
                <td>supplier:</td>
                <td><input type="text" id="supplier" name="supplier" value="${requestScope['product'].getSupplier()}">
                </td>
            </tr>
            <tr>
                <td>image:</td>
                <td><input type="text" id="image" name="image" value="${requestScope['product'].getImage()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Edit Customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
