package edu.jsp.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import edu.jsp.model.dto.Task;

class TaskDaoTest {

	static TaskDao dao ;
	static EntityManagerFactory factory ;
	static EntityManager manager;

	static{
		dao= new TaskDao();
		factory= Persistence.createEntityManagerFactory("employee_task");
		manager = factory.createEntityManager();
		dao.manager = manager;
	}

//	@Test
//	void testDeleteTask() {
//		Task task=new Task();
//		task.setTaskName("Test Task");
//		EntityTransaction transaction=manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(task);
//		transaction.commit();
//		
//		Task deletedTask=dao.deleteTask(task);
//		
//		assertEquals(deletedTask, task);
//		
//		
//	}

//	@Test
//	void testMergeTask() {
//		
//		Task task=new Task();
//		task.setTaskName("Test Task");
//		EntityTransaction transaction=manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(task);
//		transaction.commit();
//		
//		Task deletedTask=dao.mergeTask(task);
//		
//		assertEquals(deletedTask, task);
//		
//	}

//	@Test
//	void testSaveTask() {
//			
//			Task task=new Task();
//			task.setTaskName("Test Task");
//			EntityTransaction transaction=manager.getTransaction();
//			
//			transaction.begin();
//			manager.persist(task);
//			transaction.commit();
//			
//			dao.saveTask(task);
//			
//			Task fetchedTask=manager.find(Task.class, task.getTaskId());
//			
//			assertEquals(fetchedTask, task);
//			
//	}
//
//	@Test
//	void testGetTask() {
//	}

}
