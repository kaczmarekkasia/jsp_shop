<%--
  Created by IntelliJ IDEA.
  User: so-vi
  Date: 30.09.2019
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add invoice</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<jsp:include page="/navigator.jsp"/>
<form action="/add-invoice" method="post">
    Client name: <input type="text" name="client_name">
    <br/>
    NIP: <input type="text" name="NIP">
    <br/>
    Adress: <input type="text" name="adress">
    <br/>
    <br/>
    <input type="submit" class="btn btn-secondary" value="Submit">

</form>

</body>
</html>
