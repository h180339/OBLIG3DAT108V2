<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <!-- Fra https://purecss.io/ -->
    <link rel="stylesheet"
          href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <link rel="stylesheet" href="style.css">
    <title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table class="pure-table">
    <tr bgcolor="#cccccc">
        <th>Kjønn</th>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>

    <c:forEach items="${rows}" var="row">
        <tr class="${row.classname}">
            <td align="center">${row.bruker.kjonn}</td>
            <td>${row.bruker.etternavn}, ${row.bruker.fornavn}</td>
            <td>${row.bruker.mobil}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="loggut">Ferdig</a>
</p>
</body>
</html>