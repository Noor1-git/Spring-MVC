<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Information Form</title>
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

    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ddd;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #333;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
        font-size: 16px;
    }

    input[type="submit"] {
        background-color: #007BFF;
        color: #fff;
        border: none;
        padding: 12px 20px;
        font-size: 18px;
        border-radius: 3px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Additional styles for form elements */
    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="number"] {
        transition: border-color 0.3s ease;
    }

    input[type="text"]:focus,
    input[type="email"]:focus,
    input[type="password"]:focus,
    input[type="number"]:focus {
        border-color: #007BFF;
    }

    /* Error message style */
    .error-message {
        color: #ff0000;
        font-size: 14px;
        margin-top: 5px;
    }
</style>

</head>
<body>
    <h2>Employee Information Form</h2>
    <form action="updateemployee" method="post">
        <input name="employeeId" value="<%=request.getParameter("employeeId") %>" hidden="true">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="contact">Contact:</label>
        <input type="text" id="contact" name="contact" required>
        <br>
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required>
        <br>
        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
