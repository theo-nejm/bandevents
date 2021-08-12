<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar uma banda</title>
<link rel="stylesheet" href="styles/global.css" />
</head>
<body>
	<%@ include file="./parts/header.jsp"%> 
	<main>
		<div class="register-container">
			<div class="illustration">
				<img src="assets/images/band.svg" alt="Cadastrar uma banda">
			</div>
			<div class="form">
				<form action="edit-band">
					<h2>Editar uma banda</h2>
					<input
						name="bandName" 
						type="text" 
						placeholder="Nome da banda: " 
						required
						value="<%= request.getParameter("currentName") %>"
					/>
					<input
						name="bandId"
						value="<%= request.getParameter("bandId")%>"
						style="display: none;"
					/>
					<button type="submit">Editar banda</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>