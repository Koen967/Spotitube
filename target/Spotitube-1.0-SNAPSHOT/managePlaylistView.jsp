<%--
  Created by IntelliJ IDEA.
  User: koen
  Date: 24-3-2017
  Time: 20:25
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
    <c:forEach items="${playlistsFromOwner}" var="current">
        <div class="row" id="playlist">
            <form method="post">
                    <%--${current.getName()}<br>--%>
                <div class="col-md-3" id="playlistNaam">
                    <a href=""><c:out value="${current.getPlaylistName()}"/></a>
                    <input type="hidden" name="playlistName" value="<c:out value="${current.getPlaylistName()}"/> ">
                </div>
                <div class="col-md-3" id="wijzigen">
                    <button class="btn btn-default" type="submit" name="edit" value="edit">Naam wijzigen</button>
                </div>
                <div class="col-md-3" id="toevoegen">
                    <button class="btn btn-default" type="submit" name="add" value="add">Track toevoegen</button>
                </div>
                <div class="col-md-3" id="verwijderen">
                    <button class="btn btn-default" type="submit" name="delete" value = delete>Verwijderen</button>
                </div>
            </form>
        </div>
    </c:forEach>
    <div class="row" id="totalTime">
        <p>Totale lengte is ... uur</p>
    </div>
    <div class="row">
        <div class="col-md-3">
            <button class="btn btn-default" type="submit">Nieuwe playlist</button>
        </div>
        <div class="col-md-3">
            <button class="btn btn-default" type="submit">Zoek track</button>
        </div>
    </div>
</div>
</body>
</html>
