<%--
  Created by IntelliJ IDEA.
  User: so-vi
  Date: 30.09.2019
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<form action="${requestScope.productId==null ?'/add-product' : '/edit-product'}" method="post">
    <input type="hidden" name="invoice_which_i_should_add_product_to" value="${requestScope.invoiceId}">
    <input type="hidden" name="productId" value="${requestScope.productId}">
    Name: <input type="text" name="name" value="${requestScope.productName}">
    <br/>
    Price: <input type="number" step="0.01" name="price" value="${requestScope.productPrice}">
    <br/>
    TaxType: <select name="tax_type" value="${requestScope.productTaxType}">">
                <option value="PRODUCT">PRODUCT</option>
                <option value="SERVICE">SERVICE</option>
            </select>
    <br/>
    Stock: <input type="number" name="stock" value="${requestScope.productStock}">
    <br/>
    <input type="submit" class="btn btn-secondary" value="Submit">
</form>

</body>
</html>
