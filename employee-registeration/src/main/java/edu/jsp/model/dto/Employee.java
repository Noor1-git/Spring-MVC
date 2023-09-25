package edu.jsp.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	// Getter methods

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
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

	// Setter methods

	public void setId(int id) {
		this.id = id;
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

	public Employee(String name, String email, String contact, String designation, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.designation = designation;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

}
