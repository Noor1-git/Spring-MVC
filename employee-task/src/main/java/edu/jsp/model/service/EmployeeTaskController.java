package edu.jsp.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.jsp.model.dao.EmployeeDao;
import edu.jsp.model.dao.TaskDao;
import edu.jsp.model.dto.Employee;
import edu.jsp.model.dto.Task;
import jakarta.servlet.ServletRequest;

@Controller
public class EmployeeTaskController {

	EmployeeDao dao = new EmployeeDao();
	TaskDao taskDao = new TaskDao();

	@GetMapping("/deletetask")
	public String deleteTask(ServletRequest request, Model model) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		long taskId = Long.parseLong(request.getParameter("taskId"));

		// Delete the task
		Task deletedTask = taskDao.deleteTask(taskId);

		if (deletedTask != null) {
			// Task was successfully deleted
			Employee employee = dao.searchEmployeeById(employeeId);
			request.setAttribute("employee", employee);
			return "taskPage.jsp";
		} else {
			// Task deletion failed, you can handle this case accordingly
			return "failure.jsp";
		}
	}

	@PostMapping("/saveemployee")
	public String saveEmployee(ServletRequest request, Model model) {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String password = request.getParameter("password");
		String taskName = request.getParameter("taskName");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");
		boolean isCompleted = Boolean.parseBoolean(request.getParameter("isCompleted"));

		String dateString = dueDate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Employee employee = new Employee(name, email, contact, designation, salary, password);

		Task task = new Task(taskName, description, date, isCompleted, employee);

		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		employee.setTasks(tasks);

		if (dao.saveEmployee(employee)) {

			List<Employee> employees = dao.getAllEmployees();
			model.addAttribute("employees", employees);
			return "success.jsp";
		} else {
			return "failure.jsp";
		}
	}

	@PostMapping("/addtask")
	public String addTask(ServletRequest request, Model model) {

		String email = request.getParameter("email");
		String taskName = request.getParameter("taskName");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");
		boolean isCompleted = Boolean.parseBoolean(request.getParameter("isCompleted"));

		String dateString = dueDate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Employee employee = dao.searchEmployee(email);

		if (employee == null) {
			return "failure.jsp";
		}
		Task task = new Task(taskName, description, date, isCompleted, employee);
		List<Task> tasks = employee.getTasks();
		tasks.add(task);
		if (dao.mergeEmployee(employee)) {
			model.addAttribute("tasks", tasks);
			return "taskPage.jsp";
		} else {
			return "failure.jsp";
		}
	}

	@GetMapping("/showallemployees")
	public String ShowAllEmployees(ServletRequest request, Model model) {
		List<Employee> employees = dao.getAllEmployees();
		model.addAttribute("employees", employees);
		return "success.jsp";
	}

	@GetMapping("/taskPage")
	public String getTasks(ServletRequest request, Model model) {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = dao.searchEmployeeById(id);
		if (employee != null) {
			List<Task> tasks = employee.getTasks();
			model.addAttribute("tasks", tasks);
			return "taskPage.jsp";
		} else {
			return "failure.jsp";
		}
	}
}