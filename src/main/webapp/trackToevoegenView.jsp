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
        <div class="row table-cell">
            <form method="post">
                <div class="col-md-2">
                    <input type="text" name="title" value="<c:out value="${current.getTitle()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="performer" value="<c:out value="${current.getPerformer()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="duration" value="<c:out value="${current.getDuration()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="album" value="<c:out value="${current.getAlbum()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="playCount" value="<c:out value="${current.getPlayCount()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="publicationDate" value="<c:out value="${current.getPublicationDatePrintable()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="description" value="<c:out value="${current.getDescription()}"/>" class="form-control" readonly>
                </div>
                <button class="btn btn-default" type="submit" name="add" value="add">+</button>
            </form>
        </div>
    </c:forEach>
    <div class="row">
        <form method="post">
            <button class="btn btn-default col-md-2 col-md-offset-1" type="submit" name="back" value="back">Terug</button>
        </form>
    </div>
</div>
</body>
</html>
