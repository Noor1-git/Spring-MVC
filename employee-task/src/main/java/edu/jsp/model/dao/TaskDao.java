package edu.jsp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.model.dto.Task;

public class TaskDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("employee_task");
	public EntityManager manager=factory.createEntityManager();
	
	public Task deleteTask(Task task) {
		EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(task);
			transaction.commit();
			return task;
	}
	
	public Task mergeTask(Task task) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.merge(task);
			transaction.commit();
			return task;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Task saveTask(Task task) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(task);
		transaction.commit();
		return task;
	}
	
	public Task getTask(long id) {
		return manager.find(Task.class, id);
	}
}