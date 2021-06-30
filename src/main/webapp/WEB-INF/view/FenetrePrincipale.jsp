<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressourcesweb/css/styleprincipal.css" type="text/css"/>
    <title>Web Application</title>
</head>

<body>
	<jsp:include page="FenetrePrincipale/Header.jsp" />
	<jsp:include page="FenetrePrincipale/MostListened.jsp" />
	<jsp:include page="FenetrePrincipale/Footer.jsp" />
</body>

</html>