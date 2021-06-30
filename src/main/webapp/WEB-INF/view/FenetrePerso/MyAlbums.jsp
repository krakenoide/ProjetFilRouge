<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section id="MyAlbums" class="most-listened-container">
		<h1 class="section-title">My Albums</h1>
		
		<div class="searchbar">
            <form action="searchAlbum" method="POST">
                <input class="search" placeholder="Type here to find albums..."
                    type="search" name="search"> <input class="button"
                    type="submit" value="Search">
            </form>
        </div>
		
		<div class="best-products">

			<c:forEach items="${dataSummary.listeAlbums}" var="i">

				<div class="product-box no-grid">
				<c:if test="${i.couverture==null}">
				<img class="couverture" src="${pageContext.request.contextPath}/ressourcesweb/images/nos_meilleures_ventes/0.jpg">
				</c:if>
				<c:if test="${i.couverture!=null}">
				<img class="couverture" src="${pageContext.request.contextPath}/ressourcesweb/images/mes_albums/album${i.id}.png">
				</c:if>
					<c:url value="/albumvue" var="ghi">
						<c:param name="id" value="${i.id}" />
					</c:url>
					<a href="${ghi}" class="middle image"></a>
					<div class="product-bio">
							<h1 class="product-name">${i.nomAlbum}</h1>
						</div>
					</div>
				</c:forEach>


			<c:if test="${dataSummary.listeAlbums.size()==null}">
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