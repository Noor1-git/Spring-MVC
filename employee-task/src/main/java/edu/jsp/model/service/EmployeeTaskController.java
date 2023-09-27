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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
		taskDao.saveTask(task);
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

	@GetMapping("/deleteemployee")
	public String deleteEmployee(ServletRequest request, Model model) {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = dao.searchEmployeeById(id);
		if (employee != null) {
			if (dao.deleteEmployee(employee) != null) {
				List<Employee> employees = dao.getAllEmployees();
				model.addAttribute("employees", employees);
				return "success.jsp";
			} else {
				return "failure.jsp";
			}

		} else {
			return "failure.jsp";
		}
	}

	@GetMapping("/preupdateemployee")
	public String preUpdateEmployee(ServletRequest request, Model model) {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = dao.searchEmployeeById(id);
		request.setAttribute("employee", employee);
		return "updateemployee.jsp";
	}

	@GetMapping("/postupdateemployee")
	public String postUpdateEmployee(ServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = dao.searchEmployeeById(id);
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setContact(request.getParameter("contact"));
		employee.setDesignation(request.getParameter("designation"));
		employee.setSalary(Double.parseDouble(request.getParameter("salary")));
		employee.setPassword(request.getParameter("password"));

		if (dao.mergeEmployee(employee)) {
			List<Employee> employees = dao.getAllEmployees();
			model.addAttribute("employees", employees);
			return "success.jsp";
		} else {
			return "failure.jsp";
		}
	}

	@GetMapping("/preupdatetask")
	public String preUpdateTask(ServletRequest request, Model model) {
		long id = Long.parseLong(request.getParameter("taskId"));
		Task task = taskDao.getTask(id);
		if (task != null) {
			request.setAttribute("task", task);
			return "updatetask.jsp";
		} else {
			return "failure.jsp";
		}
	}

	@GetMapping("/postupdatetask")
	public String postUpdateTask(ServletRequest request, Model model) {

		long id = Long.parseLong(request.getParameter("taskId"));

		Task task = taskDao.getTask(id);

		if (task != null) {

			task.setTaskName(request.getParameter("taskName"));
			task.setDescription(request.getParameter("description"));

			String dueDate = request.getParameter("dueDate");

			boolean isCompleted = Boolean.parseBoolean(request.getParameter("isCompleted"));

			String dateString = dueDate;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;

			try {
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			task.setDueDate(date);
			task.setCompleted(isCompleted);

			if (taskDao.mergeTask(task)!=null) {
				List<Task> tasks = task.getEmployee().getTasks();
				model.addAttribute("tasks", tasks);
				return "taskPage.jsp";
			} else {
				return "failure.jsp";
			}
		} else {
			return "failure.jsp";
		}
	}

	@GetMapping("/deletetask")
	public String deleteTask(ServletRequest request, Model model) {

		long id = Long.parseLong(request.getParameter("taskId"));

		Task task = taskDao.getTask(id);

		if (task != null) {
			if (taskDao.deleteTask(task) != null) {
				List<Task> tasks = task.getEmployee().getTasks();
				model.addAttribute("tasks", tasks);
				return "taskPage.jsp";
			} else {
				return "failure.jsp";
			}
		} else {
			return "failure.jsp";
		}
	}

}