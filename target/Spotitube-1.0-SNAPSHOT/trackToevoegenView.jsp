<%--
  Created by IntelliJ IDEA.
  User: koen
  Date: 27-3-2017
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Beheer playlists</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/Spotitube.css" rel="stylesheet">

</head>
<body>
<div class="row" id="body">
    <c:forEach items="${trackList}" var="current">
        <div class="row">
            <div class="col-md-2 table-cell">
                <p id="title"><c:out value="${current.getTitle()}"/> </p>
            </div>
            <div class="col-md-2 table-cell">
                <p id="performer"><c:out value="${current.getPerformer()}"/></p>
            </div>
            <div class="col-md-1 table-cell">
                <p id="duration"><c:out value="${current.getDuration()}"/></p>
            </div>
            <div class="col-md-2 table-cell">
                <p id="album"><c:out value="${current.getAlbum()}"/></p>
            </div>
            <div class="col-md-1 table-cell">
                <p id="playCount"><c:out value="${current.getPlayCount()}"/></p>
            </div>
            <div class="col-md-1 table-cell">
                <p id="publicationDate"><c:out value="${current.getPublicationDatePrintable()}"/></p>
            </div>
            <div class="col-md-2 table-cell">
                <p id="description"><c:out value="${current.getDescription()}"/></p>
            </div>
            <button class="btn btn-default" type="submit" name="add" value="add">+</button>
        </div>
    </c:forEach>
</div>
</body>
</html>
