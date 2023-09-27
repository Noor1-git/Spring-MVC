<%@page import="edu.jsp.model.dto.Task"%>
<%@page import="edu.jsp.model.dto.Employee"%>
<%@page import="edu.jsp.model.dao.EmployeeDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Employee Tasks</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	color: #333;
}

.success-message {
	text-align: center;
	margin: 20px auto;
	padding: 20px;
	background-color: #66ff66;
	color: #333;
	border-radius: 10px;
	width: 70%;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.success-message h3 {
	font-size: 24px;
	margin-bottom: 10px;
}

.back-button {
	display: inline-block;
	background-color: #4caf50;
	color: #fff;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s ease-in-out;
}

.back-button:hover {
	background-color: #45a049;
}


/* Add CSS for the table */
table {
	width: 100%;
	border-collapse: collapse;
	border-spacing: 0;
	margin-top: 20px;
}

table th, table td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

table th {
	background-color: #f2f2f2;
	font-weight: bold;
	text-transform: uppercase;
	border: 1px solid #ddd;
}

table td {
	padding: 10px;
	border: 1px solid #ddd;
}

table tbody tr:hover {
	background-color: #e0e0e0;
	transition: background-color 0.3s;
}

table tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h2>Success Message</h2>
	<div class="success-message">
		<h3>Your request was processed successfully!</h3>
		<a href="index.jsp" class="back-button">Home</a>
	</div>
	<h2>Employee Tasks</h2>
	<table>
		<thead>
			<tr>
				<th>Task ID</th>
				<th>Task Name</th>
				<th>Description</th>
				<th>Due Date</th>
				<th>Status</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Task> tasks = (List<Task>) request.getAttribute("tasks");
			for (Task task : tasks) {
			%>
			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getTaskName()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getDueDate()%></td>
				<td><%=task.isCompleted()%></td>
				<td><a href="preupdatetask?taskId=<%= task.getTaskId()%>" class="back-button">Update</a></td>
				<td><a href="deletetask?taskId=<%= task.getTaskId()%>" class="back-button">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>