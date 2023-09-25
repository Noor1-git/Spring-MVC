package edu.jsp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.model.dto.Task;

public class TaskDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("employee_task");
	EntityManager manager=factory.createEntityManager();
	
	public Task deleteTask(long taskId) {
		EntityTransaction transaction = manager.getTransaction();
		Task task = manager.find(Task.class, taskId);
		if (task == null) {
			return null;
		} else {
			transaction.begin();
			manager.remove(task);
			transaction.commit();
			return task;
		}
	}
}
