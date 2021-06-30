<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form:form action="Login" method="POST" >

		<div>
			Utilisateur :
			<input name="username" />
		</div>

		<hr>

		<div>
			Mot de Passe :
			<input type="password" name="password" />
		</div>

		<hr>

		<div>
			<input type="submit" value="Login" />
		</div>
		
	<hr>

	</form:form>

		<form:form action="vaVersJSPCreationNouvelUtilisateur">
		<div>
			<input type="submit" value="Nouvel Utilisateur" />
		</div>
	</form:form>

	<hr>

	<form:form action="HomePage">
		<div>
			<input type="submit" value="Menu Principal" />
		</div>
	</form:form>
	
	<hr>

</body>
</html>