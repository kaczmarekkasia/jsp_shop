<%@ page import="model.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: so-vi
  Date: 19.09.2019
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Product list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<table class="table table-striped" style="width: 100%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Tax value</th>
        <th>Tax type</th>
        <th>Stock</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${requestScope.product_list}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${Math.round(product.getTaxValue()*100)/100}</td>
            <td>${product.getTaxType()}</td>
            <td>${product.getStock()}</td>
            <td>
                <c:if test="${product.getInvoice().getDateOfRelease() == null}">
                <a href="/edit-product?productId=${product.getId()}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">EDIT</a>
                </c:if>
            </td>
            <td>
                <c:if test="${product.getInvoice().getDateOfRelease() == null}">
                <a href="/delete-product?productId=${product.getId()}" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">DELETE</a>
                </c:if>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
