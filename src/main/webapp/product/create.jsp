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
<h1> Create new product</h1>
<a href="/Products">|| Back to product list ||</a>
<p style="color: red"><c:out value="${message}"/></p>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td><input type="text" name="amount"></td>
        </tr>
        <tr>
            <td>Detail:</td>
            <td><input type="text" name="detail"></td>
        </tr>
        <tr>
            <td>Category :</td>
            <td><select name="cat_id">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.getId()}"><c:out value="${category.getName()}"/></option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="reset">reset</button>
                <button type="submit">submit</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
