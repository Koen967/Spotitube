<%--
  Created by IntelliJ IDEA.
  User: koen
  Date: 6-4-2017
  Time: 15:19
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
    <form method="post">
        <div class="row">
            <div class=" col-md-8 col-md-offset-2">
                <label>Naam</label>
                <input type="text" name="playlistName">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-2">
                <button class="btn btn-default" type="submit" name="confirm" value="confirm">Bevestigen</button>
            </div>
            <div class="col-md-3">
                <button class="btn btn-default" type="submit" name="cancel" value="cancel">Annuleren</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
