<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressourcesweb/css/styleperso.css" type="text/css"/>
    <title>Web Application</title>
</head>

<body>
	<jsp:include page="FenetrePerso/Header.jsp" />	
	<jsp:include page="FenetrePerso/MySongs.jsp" />
	<jsp:include page="FenetrePerso/MyArtists.jsp" />
	<jsp:include page="FenetrePerso/MyAlbums.jsp" />
	<jsp:include page="FenetrePrincipale/Footer.jsp" />
</body>

</html>