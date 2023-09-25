package edu.jsp.model.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.model.dto.Employee;
import edu.jsp.model.dto.Task;

public class EmployeeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_task");
	EntityManager manager = factory.createEntityManager();

	public Task deleteTask(int empId, int taskId) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Employee employee = manager.find(Employee.class, empId);
			List<Task> tasks = employee.getTasks();

			Iterator<Task> iterator = tasks.iterator();
			while (iterator.hasNext()) {
				Task task = iterator.next();
				if (task.getTaskId() == taskId) {
					iterator.remove(); // Safely remove the task
					manager.merge(employee); // Save the updated employee
					transaction.commit();
					return task;
				}
			}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace(); // Handle exceptions appropriately
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
	}

	public Employee searchEmployeeById(int id) {

		Employee employee = manager.find(Employee.class, id);
		if (employee == null) {
			return null;
		} else {
			return employee;
		}
	}

	public boolean mergeEmployee(Employee employee) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.merge(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Employee searchEmployee(String email) {
		String jpql = "SELECT e FROM Employee e WHERE e.email = :email"; // Removed the space
		Query query = manager.createQuery(jpql);
		query.setParameter("email", email); // Set the parameter value
		List<Employee> employees = null;
		if ((employees = query.getResultList()) != null && employees.size() != 0) {
			return employees.get(0); // Return the first matching employee
		} else {
			return null;
		}
	}

	public List<Employee> getAllEmployees() {
		try {
			// Begin a transaction
			manager.getTransaction().begin();

			// Create and execute the JPQL query
			List<Employee> employees = manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

			// Commit the transaction
			manager.getTransaction().commit();

			return employees;
		} catch (Exception e) {

			return null;
		}
	}

	public boolean saveEmployee(Employee employee) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			if (employee != null) {
				manager.persist(employee);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
