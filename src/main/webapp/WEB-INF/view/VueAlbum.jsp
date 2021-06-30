<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/ressourcesweb/css/styleperso.css" type="text/css"/>
<title>${Album.nomAlbum}</title>
</head>
<body>
<section id="my-songs" class="most-listened-container">
		<h1 class="section-title">${Album.nomAlbum} Songs</h1>
		
		<div class="best-products">

			<c:forEach items="${dataSummary.listeMorceaux}" var="i">
				<c:if test="${i.album.nomAlbum==Album.nomAlbum}">
					<div class="product-box no-grid">
						<c:if test="${i.album.couverture==null}">
							<img class="couverture"
								src="${pageContext.request.contextPath}/ressourcesweb/images/nos_meilleures_ventes/0.jpg">
						</c:if>
						<c:if test="${i.album.couverture!=null}">
							<img class="couverture"
								src="${pageContext.request.contextPath}/ressourcesweb/images/mes_albums/album${i.album.id}.png">
						</c:if>
						<c:url value="/lecture" var="ghi">
							<c:param name="id" value="${i.id}" />
						</c:url>
						<a href="${ghi}" class="middle image"></a>
						<div class="product-bio">
							<h1 class="product-name">${i.nomMorceau}</h1>
							<h3 class="product-amount">${i.artiste}</h3>
						</div>
					</div>
				</c:if>
			</c:forEach>




			<c:if test="${dataSummary.listeMorceaux.size()==null}">
				<div class="product-box no-grid product0">
					<a href="#" class="middle image"></a>
					<div class="product-bio">
						<h1 class="product-name">No Songs</h1>
					</div>
				</div>
			</c:if>

		</div>
	</section>

</body>
</html>