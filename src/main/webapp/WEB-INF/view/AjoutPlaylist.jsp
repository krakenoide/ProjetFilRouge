<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="affichageplaylist" modelAttribute="modelePlaylist">
		<div>
			Titre de la playlist : <form:input path="titre"/>
			
		</div>
		<input type="submit" value="Enregistrer la playlist" />
</form:form>

</body>
</html>