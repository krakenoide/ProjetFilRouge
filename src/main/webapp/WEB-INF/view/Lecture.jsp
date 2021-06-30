<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lecture: ${MorceauEnCours.nomMorceau}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ressourcesweb/css/stylelecture.css" type="text/css"/>
</head>
<body>
	
	<div class="product-box no-grid">
		<img class="couverture"
			src="${pageContext.request.contextPath}/ressourcesweb/images/mes_albums/album${MorceauEnCours.album.id}.png">
		<div class="product-bio">
			<h1 class="product-name">${MorceauEnCours.nomMorceau}</h1>
			<h3 class="product-amount">${artiste.nomArtiste}</h3>
		</div>
	</div>
	<embed class="music" src="${cheminlecture}" width="250" height="26"></embed>

	<form:form action="finlecture">
		<input type="hidden" name="cache" value="${cheminlecture}" />
		<div>
			<input class="button" type="submit" value="Retour au menu principal" />
		</div>
	</form:form>

</body>
</html>