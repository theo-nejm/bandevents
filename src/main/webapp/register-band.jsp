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
				<form>
					<h2>Cadastrar uma banda</h2>
					<input type="text" placeholder="Nome da banda: " required />
					<button type="submit">Cadastrar banda</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>