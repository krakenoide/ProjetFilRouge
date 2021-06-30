<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvel Utilisateur</title>
</head>
<body>

	<form:form action="enregisterNouvelUtilisateur"
		modelAttribute="modelUtilisateur">

		<div>
			Utilisateur :
			<form:input path="nomDeCompte" />
			<form:errors path="nomDeCompte" style="color:red" />
			<helloworld style="color:red"> "${errorUtilisateur}"</helloworld>
		</div>

		<hr>

		<div>
			Mot de Passe :
			<form:password path="motDePasse" />
			<form:errors path="motDePasse" style="color:red" />
		</div>

		<hr>

		<div>
			Vérification Mot de Passe :
			<form:password path="motDePasseVerification" />
			<form:errors path="motDePasseVerification" style="color:red" />
			<helloworld style="color:red"> "${errorMDP}"</helloworld>
		</div>

		<hr>

		<div>
			<input type="submit" value="Valider" />
		</div>

	</form:form>

	<hr>

	<form:form action="vaVersJSPLogin">
		<div>
			<input type="submit" value="Retour Login" />
		</div>
	</form:form>

	<hr>

	<form:form action="PremierAffichage">
		<div>
			<input type="submit" value="Menu Principal" />
		</div>
	</form:form>

</body>
</html>