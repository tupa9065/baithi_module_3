<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/6/2021
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Product list</h1>
<a href="/Products?action=create">|| create new ||</a>
<p style="color: red"><c:out value="${message}"/></p>
<table >
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Amount</td>
        <td>detail</td>
        <td>category id</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.amount}"/></td>
            <td><c:out value="${product.detail}"/></td>
            <td><c:out value="${product.cat_id}"/></td>
            <td><a href="/Products?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/Products?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
