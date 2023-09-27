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
	background-color: #66ff66;
	color: black;
	border-radius: 4px;
	transition: background-color 0.3s ease-in-out;
}

a:hover {
	background-color: #0056b3;
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
<div class="success-message">
	<h1>Welcome to Task Management System...</h1>
	<h3>Select Operation to perform</h3>
	</div>
	<a href="AddEmployee.jsp">Add New Employee</a>
	<a href="showallemployees">Show All Employees</a>
	<a href="AddTask.jsp">Add New Task</a>

</body>
</html>