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
<h1>Edit service </h1>
<p style="color: red"><c:out value="${message}"/></p>
<a href="/">|| back home ||</a>
<a href="/Products">|| back to product list ||</a>
<form method="post" action="/Product?action=edit&&id=${product.id}" >
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr><tr>
        <td>Amount:</td>
        <td><input type="text" name="amount" value="${product.amount}"></td>
    </tr><tr>
        <td>detail:</td>
        <td><input type="text" name="detail" value="${product.detail}"></td>
    </tr>
        <tr>
            <td>cat_id:</td>
            <td><select name="cat_id" >
                <c:forEach items="${categories}" var="category">
                    <c:choose>
                        <c:when test="${category.getId()==product.cat_id}">
                            <option selected value="${category.getId()}"><c:out value="${category.getName()}"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="${category.getId()}"><c:out value="${category.getName()}"/></option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select></td>
        </tr>
        <tr><td></td>
            <td><button type="reset">reset</button>  <button type="submit">submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
