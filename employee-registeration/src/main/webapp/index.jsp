<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration Form</title>
    <style>
        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        
        /* Header styles */
        h1 {
            color: #0073e6;
            text-align: center;
            padding: 20px;
        }
        
        /* Form styles */
        form {
            background-color: #ffffff;
            border: 1px solid #ccc;
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }
        
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        button {
            background-color: #0073e6;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        
        button:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>

<h1>Employee Registration Form</h1>

<form action="save" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required>
    
    <label for="contact">Contact:</label>
    <input type="number" id="contact" name="contact" required>
    
    <label for="designation">Designation:</label>
    <input type="text" id="designation" name="designation" required>
    
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>
    
    <br><br>
    <button type="submit">Submit</button>
</form>

</body>
</html>
