<%@page import="com.theo.eventsband.model.Band"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.theo.eventsband.servlet.ListBands" %>

<% List<Band> bands = (List<Band>) request.getAttribute("bands"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver bandas</title>
<link rel="stylesheet" href="./styles/global.css" />
<style>
	main {
		width: 100vw;
		height: calc(100vh - 4rem);
		display: flex;
		align-items: center;
		justify-content: space-evenly;
		padding: 0 2.5rem;
	}

	.list-container {
		height: calc(100vh - 4rem);
		width: 100vw;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		gap: 1.5rem;
	}
	
	.list-container table {
		height: 60vh;
		width: 30rem;
		
		display: flex;
		align-items: flex-start;
		justify-content: center;
		border-spacing: 2rem;
		
		overflow: auto;
	}
	
	.list-container table tr td:nth-child(1) {
		font-weight: bold;
	}
	
	.actions .remove-band,
	.actions .edit-band {
		border-radius: .25rem;
		padding: .5rem;
		text-decoration: none;
		font-size: .85rem;
		color: #FFF;
		
		transition: .25s;
	}
	
	.actions {
		display: flex;
		gap: .5rem;
	}
	
	.actions .edit-band {
		background: #4040ff;
		border: 2px solid #4040ff;
	}
	
	.actions .remove-band {
		background-color: #ff4040;
		border: 2px solid #ff4040;
	}
	
	.actions .remove-band:hover {
		color: red;
		background: none;
	}
	
	.actions .edit-band:hover {
		color: blue;
		background: none;
	}
	
	.illustration img {
		width: 45vw !important;
	}
	
</style>
</head>
<body>
	<%@ include file="./parts/header.jsp"%>
	<main>
		<div class="list-container">
			<h2>Bandas cadastradas</h2>
			<table>
				<% for (Band band: bands) { %>
				<tr>
					<td>
						<%= band.getName() %>
					</td>
					
					<td class="actions">
						<a  
							href="edit-band.jsp?bandId=<%= band.getId() %>&currentName=<%= band.getName() %>"
							class="edit-band"
						>
							Editar
						</a>

						<a
							href="delete-band?bandId=<%= band.getId() %>"
							class="remove-band"
						>
							Remover
						</a>
					</td>
				</tr>
				<% } %>
			</table>
		</div>
		<div class="illustration">
			<img src="./assets/images/band2.svg" alt="Um grupo de pessoas"/>
		</div>
	</main>
</body>
</html>

