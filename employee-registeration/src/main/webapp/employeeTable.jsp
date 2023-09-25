<%@page import="edu.jsp.model.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Table</title>
    <style>
        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light gray background color */
            color: #333; /* Dark text color */
            text-align: center;
            padding: 20px;
            margin: 0;
        }
        
        /* Heading styles */
        h1 {
            font-size: 28px;
            margin-bottom: 10px;
        }

        /* Table styles */
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); /* Add a subtle box shadow */
        }

        th, td {
            border: 1px solid #333;
            padding: 10px;
        }

        th {
            background-color: #333;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Light gray background for even rows */
        }

        /* Additional styles for better readability and aesthetics */
        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); /* Add a subtle box shadow */
        }

        /* Responsive table styles */
        @media (max-width: 600px) {
            table {
                width: 100%;
            }
            th, td {
                display: block;
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <h1>Employee Table</h1>
    
    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Designation</th>
                    <th>Salary</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                for (Employee employee : employees) {
                %>
                    <tr>
                        <td><%= employee.getId() %></td>
                        <td><%= employee.getName() %></td>
                        <td><%= employee.getEmail() %></td>
                        <td><%= employee.getContact() %></td>
                        <td><%= employee.getDesignation() %></td>
                        <td><%= employee.getSalary() %></td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
