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
                    <a href="#" data-text="Home page">Home Page</a>
                </li>
                <li>
                    <a href="#most-listened" data-text="Most Listened">Most Listened</a>
                </li>
                <li>
                    <a href="vaVersJSPLogin" data-text="Login">Login</a>
                </li>
            </ul>
        </header>
        <div class="landing">
            <h1 class="big-title">The music all around you !</h1>
        </div>
    </section>

</body>
</html>