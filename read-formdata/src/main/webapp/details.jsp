<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
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
        
        /* Displayed information styles */
        h3 {
            margin: 10px 0;
            padding: 10px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<h1>Student Information</h1>

<h3>Name: ${param.name}</h3>
<h3>Email: ${param.email}</h3>
<h3>Contact: ${param.contact}</h3>
<h3>Gender: ${param.gender}</h3>

</body>
</html>
