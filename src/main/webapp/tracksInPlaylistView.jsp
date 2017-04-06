<%--
  Created by IntelliJ IDEA.
  User: koen
  Date: 5-4-2017
  Time: 13:06
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
    <div class="row table-cell">
        <div class="col-md-2">
            <h5>Title</h5>
        </div>
        <div class="col-md-2">
            <h5>Performer</h5>
        </div>
        <div class="col-md-1">
            <h5>Duration</h5>
        </div>
        <div class="col-md-2">
            <h5>Ablum</h5>
        </div>
        <div class="col-md-1">
            <h5>Play count</h5>
        </div>
        <div class="col-md-1">
            <h5>Publication date</h5>
        </div>
        <div class="col-md-2">
            <h5>Description</h5>
        </div>
        <div class="col-md-1>">
            <h5>Offline Available</h5>
        </div>
    </div>
    <c:forEach items="${tracksInPlaylist}" var="current">
        <div class="row table-cell">
            <form method="post">
                <div class="col-md-2">
                    <input type="text" name="title" value="<c:out value="${current.getTrack().getTitle()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="performer" value="<c:out value="${current.getTrack().getPerformer()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="duration" value="<c:out value="${current.getTrack().getDuration()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="album" value="<c:out value="${current.getTrack().getAlbum()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="playCount" value="<c:out value="${current.getTrack().getPlayCount()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="publicationDate" value="<c:out value="${current.getTrack().getPublicationDatePrintable()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-2">
                    <input type="text" name="description" value="<c:out value="${current.getTrack().getDescription()}"/>" class="form-control" readonly>
                </div>
                <div class="col-md-1">
                    <input type="text" name="offlineAvailable" value="<c:out value="${current.isOfflineAvailable()}"/>" class="form-control" readonly>
                </div>
            </form>
        </div>
    </c:forEach>
    <div class="row">
        <form method="post">
            <div class="col-md-3 col-md-offset-2">
                <button class="btn btn-default" type="submit" name="back" value="back">Terug</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
