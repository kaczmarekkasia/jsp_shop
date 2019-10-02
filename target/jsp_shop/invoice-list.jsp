<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: so-vi
  Date: 26.09.2019
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Invoice list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Date of creation</th>
        <th>Client</th>
        <th>NIP</th>
        <th>Adress</th>
        <th>Paid</th>
        <th>Date of realese</th>
        <th>Date of payment</th>
        <th>Bill value</th>
        <th>Number of products</th>
        <th></th>
    </tr>
    <c:forEach var="invoice" items = "${requestScope.invoice_list}">
        <tr>
            <td>${invoice.getId()}</td>
            <td>${invoice.getDateOfCreation().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
            <td>${invoice.getClientName()}</td>
            <td>${invoice.getNIP()}</td>
            <td>${invoice.getAdress()}</td>
            <td>${invoice.isIfPaid()}</td>
            <td>${invoice.getDateOfRelease().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
            <td>${invoice.getDateOfPayment().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
            <c:choose>
                <c:when test="${invoice.getBillValue() != null}">
                    <td>${Math.round(invoice.getBillValue()*100)/100}</td>
                    <%--<td>${invoice.getBillValue()}</td>--%>
                 </c:when>
                <c:otherwise>
                <td></td>
                </c:otherwise>
            </c:choose>
            <td>${invoice.getProduct().size()}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <c:if test="${invoice.getDateOfRelease()==null}" >
                            <a href="/add-product?invoiceId=${invoice.getId()}">ADD PRODUCT</a>
                            </c:if>
                        </td>
                        <td>
                            <a href="/product-list?invoiceId=${invoice.getId()}">LIST PRODUCTS</a>
                        </td>
                        <td>
                            <c:if test="${invoice.getDateOfRelease() == null}" >
                            <a href="/edit-invoice?invoiceId=${invoice.getId()}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">RELEASE</a>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${invoice.getDateOfPayment() == null}" >
                            <a href="/pay-invoice?invoiceId=${invoice.getId()}" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">PAID</a>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
