<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--     taglib form propre à Spring MVC -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GestionCategorie</title>
</head>

<body>

	<div align="center">
		<h1 style="color: green;">Ajout d'une nouvelle categorie</h1>

		<div align="center">
			<table>
				<form:form modelAttribute="CategorieCommand"
					action="${pageContext.request.contextPath}/categorie/ajout"
					method="POST">
					<tr>
						<td><form:label path="nom">Nom :</form:label></td>
						<td><form:input path="nom" /></td>
					</tr>
					<tr>
						<td><form:label path="description">Description :</form:label></td>
						<td colspan="50" rowspan="10"><form:input path="description" /></td>
					</tr>


					<tr colspan="2">
						<td><input type="submit" value="Ajouter categorie" /></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
	
	
	
	
	
	
	
	<div align="center">
		<h1 style="background-color: lime; color: darkgreen;">
		Liste des Categories
		</h1>
		
		<table cellspacing="0" cellpadding="6" border="1" width="60%">
			<tr bgcolor="grey" style="color: white">
				<th>Identifiant</th>
				<th>Nom</th>
				<th>Description</th>
			</tr>
			
			<c:forEach var="categorie" items="${attributCategorie}">
				<tr bgcolor="lightyellow">
					<td>${categorie.id}</td>
					<td>${categorie.nom}</td>
					<td>${categorie.description}</td>
				
					<td><a href="${pageContext.request.contextPath}/categorie/supprimer/${categorie.id}">Supprimer</a></td>
					<td><a href="${pageContext.request.contextPath}/categorie/updatecategorieform?categorieid=${categorie.id}">Modifier</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>