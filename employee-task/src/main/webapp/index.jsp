<!DOCTYPE html>
<html>
<head>
<title>Navigation</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

a {
	display: block;
	width: 30%; /* Set the width to 30% */
	padding: 10px;
	margin: 10px;
	margin: 10px auto;
	text-decoration: none;
	background-color: #007BFF;
	color: #fff;
	border-radius: 4px;
	transition: background-color 0.3s ease-in-out;
}

a:hover {
	background-color: #0056b3;
}

h1 {
	text-align: center;
	color: #333;
	margin-top: 20px; /* Add some top margin to the h1 element */
}

h2 {
	text-align: center;
	color: #333;
}
</style>
</head>
<body>
	<h1>Welcome to Task Management System...</h1>
	<a href="AddEmployee.jsp">Add New Employee</a>
	<a href="showallemployees">Show All Employees</a>
	<a href="AddTask.jsp">Add New Task</a>
	<a href="UpdateEmployee.jsp">Assign Task to Existing Employee</a>

</body>
</html>