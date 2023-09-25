package edu.jsp.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import edu.jsp.model.dao.EmployeeDao;
import edu.jsp.model.dto.Employee;
import jakarta.servlet.ServletRequest;

@Controller
public class TestController {
	@PostMapping("/save")
	public String saveEmployee(ServletRequest request, Model model) {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String contact = request.getParameter("contact");
	    String designation = request.getParameter("designation");
	    double salary = Double.parseDouble(request.getParameter("salary"));
	
	    Employee employee = new Employee(name, email, contact, designation, salary);
	
	    EmployeeDao dao = new EmployeeDao();
	
	    if (dao.saveEmployee(employee)) {
	        model.addAttribute("id", employee.getId());
	        model.addAttribute("name", employee.getName());
	        model.addAttribute("email", employee.getEmail());
	        model.addAttribute("contact", employee.getContact());
	        model.addAttribute("designation", employee.getDesignation());
	        model.addAttribute("salary", employee.getSalary());
	
	        // Check if the list of employees is not null before adding it to the model
	        List<Employee> employees = dao.getAllEmployees(); // Assuming you have a getEmployees() method
	        if (employees != null) {
	            model.addAttribute("employees", employees);
	        }
	
	        return "employeeTable.jsp"; // Show the Employee Table
	    } else {
	        return "failed.jsp";
	    }
	}
	
}

