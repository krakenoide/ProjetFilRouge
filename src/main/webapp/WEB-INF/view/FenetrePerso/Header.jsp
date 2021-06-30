<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
<section id="home" class="home-container">
		<header id="header" class="header">
            <img src="${pageContext.request.contextPath}/ressourcesweb/images/logo.png" alt="logo" class="logo">
            <ul class="nav-links">
                <li>
                    <a href="#MySongs" data-text="My Songs">My Songs</a>
                </li>
                <li>
                    <a href="#MyArtists" data-text="My Artists">My Artists</a>
                </li>
                <li>
                    <a href="#MyAlbums" data-text="My Albums">My Albums</a>
                </li>
                <li>
                	<a href="affichageAjout">Add Music</a>
                </li>
                <li>
                	<a href="ajoutPlayList">Add Playlist</a>
                </li>
                <li>
                    <a href="HomePage" data-text="Log Out">Log Out</a>
                </li>
            </ul>
        </header>
        <div class="landing">
            <h1 class="big-title">Welcome</h1>
        </div>
    </section>

</body>
</html>