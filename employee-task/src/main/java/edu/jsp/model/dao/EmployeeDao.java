package edu.jsp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.model.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee_task");
	EntityManager manager = factory.createEntityManager();

	public Employee searchEmployeeById(int id) {

		Employee employee = manager.find(Employee.class, id);
		if (employee == null) {
			return null;
		} else {
			return employee;
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
			manager.getTransaction().begin();
			List<Employee> employees = manager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
			manager.getTransaction().commit();
			return employees;
		} catch (Exception e) {
			return null;
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

	public Employee deleteEmployee(Employee employee) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.remove(employee);
			transaction.commit();
			return employee;
		} catch (Exception e) {
			return null;
		}
	}
}
