package com.cognixia.jump.project.ems;

import java.text.DecimalFormat;

public class Employee implements Initial{
	
	
	private String firstName;
	private String lastName;
	private double salary;
	private int employeeId;
	private String position;
	private String email;
	
	public void updateEmployee(int attributeId, String attribute) {
		switch(attributeId) {
		case 0:
			setFirstName(attribute);
			break;
		case 1:
			setLastName(attribute);
			break;
		case 2:
			double salary = Double.parseDouble(attribute);
			setSalary(salary);
			break;
		case 3:
			int employeeId = Integer.parseInt(attribute.trim());
			setEmployeeId(employeeId);
			break;
		case 4: 
			setPosition(attribute);
			break;
		case 5:
			setEmail(attribute);
			break;
		default:
			System.out.println("Invalid attributeId");
		}
	}
	
//	public Employee(String firstName) {
//		setFirstName(firstName);
//		setLastName(null);
//		setSalary(0);
//		setEmployeeId(0);
//		setPosition(null);
//		setEmail(null);
//	}
//	public Employee(String firstName, String lastName) {
//		setFirstName(firstName);
//		setLastName(lastName);
//		setSalary(0);
//		setEmployeeId(0);
//		setPosition(null);
//		setEmail(null);
//	}
//	public Employee(String firstName, String lastName, float salary) {
//		
//		setFirstName(firstName);
//		setLastName(lastName);
//		setSalary(salary);
//		setEmployeeId(0);
//		setPosition(null);
//		setEmail(null);
//	}
//	public Employee(String firstName, String lastName, float salary, 
//			int employeeId) {
//		
//		setFirstName(firstName);
//		setLastName(lastName);
//		setSalary(salary);
//		setEmployeeId(employeeId);
//		setPosition(null);
//		setEmail(null);
//	}
//	public Employee(String firstName, String lastName, float salary, 
//			int employeeId, String position) {
//		
//		setFirstName(firstName);
//		setLastName(lastName);
//		setSalary(salary);
//		setEmployeeId(employeeId);
//		setPosition(position);
//		setEmail(null);
//	}
//	public Employee(String firstName, String lastName, float salary, 
//			int employeeId, String position, String email) {
//		
//		setFirstName(firstName);
//		setLastName(lastName);
//		setSalary(salary);
//		setEmployeeId(employeeId);
//		setPosition(position);
//		setEmail(email);
//	}
//	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Override
	public String toString() {
		
		//String attributeTitleRow = "First Name, Last Name, Salary, EmployeeId, Position, Email\n";

		return getFirstName() + ", " + getLastName() + ", " + df.format(salary)
				+ ", " + getEmployeeId() + ", " + getPosition() + ", " + getEmail() + "\n";

	}
	
	
}