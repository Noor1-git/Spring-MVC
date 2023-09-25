package edu.jsp.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String contact;
	private String designation;
	private double salary;
	private String password;

	@OneToMany(mappedBy = "employee")
	private List<Task> tasks;

	// Getter methods

	public int getId() {
		return id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getContact() {
		return contact;
	}

	public String getDesignation() {
		return designation;
	}

	public double getSalary() {
		return salary;
	}

	public String getPassword() {
		return password;
	}

	// Setter methods

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(String name, String email, String contact, String designation, double salary, String password) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.designation = designation;
		this.salary = salary;
		this.password = password;
	}

	public Employee() {
		super();
	}

}
