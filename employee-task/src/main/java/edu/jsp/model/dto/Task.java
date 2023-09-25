package edu.jsp.model.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long taskId;
	private String taskName;
	private String description;
	private Date dueDate;
	private boolean isCompleted;

	@ManyToOne
	private Employee employee;

	// Getter methods

	public long getTaskId() {
		return taskId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getDescription() {
		return description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	// Setter methods

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setCompleted(boolean completed) {
		isCompleted = completed;
	}

	public Task(String taskName, String description, Date dueDate, boolean isCompleted, Employee employee) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
		this.employee = employee;
	}

	public Task() {
		super();
	}

}
