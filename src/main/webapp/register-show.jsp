<%@page import="com.theo.eventsband.model.Band"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% List<Band> bands = (List<Band>) request.getAttribute("bands"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar uma banda</title>
<link rel="stylesheet" href="styles/global.css" />
<style type="text/css">
	form {
		height: 50vh;
	}
	
	form select {
		outline: none;
		width: 16rem;
		border: 2px solid #C8ABFF;
		padding: .25rem;
	}
	
	form select option {
		height: 1.5rem;
	}
</style>
</head>
<body>
	<%@ include file="./parts/header.jsp"%> 
	<main>
		<div class="register-container">
			<div class="illustration">
				<img src="assets/images/show.svg" alt="Cadastrar uma banda">
			</div>
			<div class="form">
				<form action="register-show" method="post">
					<h2>Agendar um show</h2>
					<input name="bandName" type="text" placeholder="Nome do show: " required />
					<select name="bands" multiple size="4">
						<% for (Band band: bands) { %>
						<option value="<%= band.getId() %>"><%= band.getName() %></option>
						<% } %>
					</select>
					
					<button type="submit">Agendar show</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>