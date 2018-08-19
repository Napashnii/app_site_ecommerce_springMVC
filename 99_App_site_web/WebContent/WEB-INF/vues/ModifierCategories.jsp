<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<h1>Modification d'une categorie</h1>
		
		<div align="center">
			<table>
				<form:form modelAttribute="CategorieModifCommand" action="${pageContext.request.contextPath}/categorie/update" method="POST">
					<tr>
						<td>
							<form:hidden path="id"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="nom">Nom :</form:label></td>
						<td>
							<form:input path="nom"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="description">Description :</form:label></td>
						<td>
							<form:input path="description"/>
						</td>
					</tr>

					<tr colspan="2">
						<td><input type="submit" value="Modifier"/></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>

</body>
</html>