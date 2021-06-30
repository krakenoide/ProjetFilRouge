<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FormulaireMorceau</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ressourcesweb/css/styleajoutmodif.css" type="text/css"/>
</head>
<body>
<form:form action="affichageResultatMorceau"
		modelAttribute="modelMorceau">
        <table border="0">
            <tr>
                <td>Nom du morceau :</td>
                <td><form:input class="textfield" path="nomMorceau" />
			<form:errors path="nomMorceau" style="color:red" /></td>
            </tr>
            
            <tr>
                <td>Artiste :</td>
                <td><form:input class="textfield" path="nomArtiste" />
			<form:errors path="nomArtiste" style="color:red" /></td>
            </tr>
            
            <tr>
                <td>Album :</td>
                <td><form:input class="textfield" path="nomAlbum" />
			<form:errors path="nomAlbum" style="color:red" /></td>
            </tr>
            
            <tr>
                <td>Genre :</td>
                <td><form:select class="select textfield" path="nomGenreMorceau" id="genre">
				<form:option value="-" label="--Please Select" />
				<form:options items="${dataSummary.listeGenres}"
					itemValue="nomGenre" itemLabel="nomGenre" />
			</form:select>
			<form:errors path="nomGenreMorceau" style="color:red" /></td>
            </tr>
            
            <tr>
                <td><label>Fichier mp3 :</label></td>
                <td><input class="file" type="file" path="son" accept=".mp3"/></td>
            </tr>
        </table>
        <br>
	<section class="flex">
			<div>
				<input class="buttonregister" type="submit" value="Enregistrer le morceau" />
			</div>
	</form:form>

	<form:form action="Login">
		<div>
			<input class="buttoncancel" type="submit" value="Annuler" />
		</div>
	</form:form>
	</section>


</body>
</html>