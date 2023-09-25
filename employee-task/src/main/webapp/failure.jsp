<!DOCTYPE html>
<html>
<head>
<title>Failure Message</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

h2 {
	text-align: center;
	color: #333;
}

.failure-message {
	text-align: center;
	margin: 20px auto;
	padding: 20px;
	background-color: #ff6666;
	color: #fff;
	border-radius: 10px;
	width: 70%;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.failure-message h3 {
	font-size: 24px;
	margin-bottom: 10px;
}

.retry-button {
	display: inline-block;
	background-color: #ff4444;
	color: #fff;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s ease-in-out;
}

.retry-button:hover {
	background-color: #ff0000;
}
</style>
</head>
<body>
	<h2>Failure Message</h2>
	<div class="failure-message">
		<h3>Sorry, your request could not be processed.</h3>
		<h3>Please try again later.</h3>
		<a href="#" class="retry-button">Retry</a>
	</div>
</body>
</html>
