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
	<h2>Employee Tasks</h2>
	<table>
		<thead>
			<tr>
				<th>Task ID</th>
				<th>Task Name</th>
				<th>Description</th>
				<th>Due Date</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<%
			
			List<Task> tasks =(List<Task>)request.getAttribute("tasks");
			for (Task task : tasks) {
			%>
			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getTaskName()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getDueDate()%></td>
				<td><%=task.isCompleted()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>