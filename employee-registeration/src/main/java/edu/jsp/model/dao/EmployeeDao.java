package edu.jsp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.model.dto.Employee;

public class EmployeeDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employee");
	EntityManager manager = entityManagerFactory.createEntityManager();

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
