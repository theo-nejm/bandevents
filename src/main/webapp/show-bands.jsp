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
		background: blue;
		border: 2px solid blue;
	}
	
	.actions .remove-band {
		background-color: red;
		border: 2px solid red;
	}
	
	.actions .remove-band:hover {
		color: red;
		background: none;
	}
	
	.actions .edit-band:hover {
		color: blue;
		background: none;
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
							href="#"
							class="edit-band button"
						>
							Editar
						</a>

						<a
							href="delete-band?bandId=<%= band.getId() %>"
							class="remove-band button"
						>
							Remover
						</a>
					</td>
				</tr>
				<% } %>
			</table>
		</div>
	</main>
</body>
</html>

