package com.cognixia.jump.project.ems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class ManagementRunner extends Departments implements Initial, Filtered{
	private static Scanner x;
	public static void main(String[] args) throws FileNotFoundException {
		Initial.loadDefaultFiles();
		Departments company1 = new Departments();
		System.out.println(company1);
		
		
		char interested = 'y';
		Scanner input = new Scanner(System.in);
		while(interested == 'y' || interested == 'Y') {
			System.out.println("Enter 1 to edit an employee field\n"
					+ "Enter 2 to add an employee\n"
					+ "Enter 3 to delete an employee");
			
			int operationChoice = input.nextInt();
			operation(Departments.getCurrentDirectory(), operationChoice);
			
			System.out.println("Perform another operation?");
			System.out.println("Enter y or Y to continue, or any other"
					+ " character to exit");
			interested = input.next().charAt(0);
		}

	}
	
	public static void operation(Hashtable<String,ArrayList<Employee>> hashtable, int operation) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, String> departmentDir = new Hashtable<Integer, String>();
		ArrayList<Employee> departmentEmployees = new ArrayList<Employee>();
		String employeeId = "";
		departmentDir.put(1, "management");
		departmentDir.put(2, "customer_service");
		departmentDir.put(3, "engineering");
		departmentDir.put(4, "marketing");
		departmentDir.put(5, "sales");
		departmentDir.put(6, "executive");
		departmentDir.put(7, "human_resources");
		int departmentKey = promptUser();
		switch(operation) {

		case 1:
			departmentEmployees = hashtable.get(departmentDir.get(departmentKey));
			System.out.println("Enter the employeeId you'd like to edit: ");
			employeeId = input.nextLine();
			//String[] attributes = {};
			for(Employee emp: departmentEmployees) {
	
				String[] details = emp.toString().split(", ");
				if(details[3] == employeeId) {
					System.out.println("Enter 1 to edit the first name\n"
							+ "Enter 2 to edit the last name\nEnter 3 to edit the salary"
							+ "Enter 4 to edit the id Number\nEnter 5 to edit the position\n"
							+ "Enter 6 to edit email");
					int employeeFieldToEdit = input.nextInt();
					switch(employeeFieldToEdit){
					case 1: //edit first name
						
						System.out.println("Enter a first name: ");
						String firstName = input.nextLine();
						String[] attributes = {firstName, emp.getLastName(), 
								Double.toString(emp.getSalary()),
								Integer.toString(emp.getEmployeeId()),
								emp.getPosition(),emp.getPosition(),
								emp.getEmail()};
						String filePath = getFilePath(departmentDir.get(departmentKey));
						editRecord(filePath, employeeId, attributes);
						break;
						
					case 2: //edit last name
						System.out.println("Enter a last name: ");
						String lastName = input.nextLine();
						String[] attributes1 = {emp.getFirstName(), lastName, 
								Double.toString(emp.getSalary()),
								Integer.toString(emp.getEmployeeId()),
								emp.getPosition(),emp.getPosition(),
								emp.getEmail()};
						String filePath1 = getFilePath(departmentDir.get(departmentKey));
						editRecord(filePath1, employeeId, attributes1);
						break;
						
					case 3: //edit salary
						System.out.println("Enter a salary (type double): ");
						String salary = input.nextLine();
						String[] attributes2 = {emp.getFirstName(), emp.getLastName(),
								salary, Integer.toString(emp.getEmployeeId()),
								emp.getPosition(), emp.getEmail()};
						String filePath2 = getFilePath(departmentDir.get(departmentKey));
						editRecord(filePath2, employeeId, attributes2);
						break;
						
					case 4: //edit employee Id
						System.out.println("Enter a new integer id");
						String empId = input.nextLine();
						String[] attributes3 = {emp.getFirstName(), emp.getLastName(),
								Double.toString(emp.getSalary()), empId,
								emp.getPosition(), emp.getEmail()};
						String filePath3 = getFilePath(departmentDir.get(departmentKey));
						editRecord(filePath2, employeeId, attributes3);
						break;

						}

					}
				}
			}
			break;
		case 2:
			
		}			

	}
	
	public static void editRecord(String filePath, String editTerm, String[] newTerms) {
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		String firstName = "";
		String lastName = "";
		String salary = "";
		String empId = "";
		String position = "";
		String email = "";
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filePath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				firstName = x.next();
				lastName = x.next();
				salary = x.next();
				empId = x.next();
				position = x.next();
				email = x.next();
				if(empId.equals(editTerm)) {
					String insertTerm = "";
					for(String term : newTerms) {
						insertTerm += term + ", ";
						//pw.print(term);
					}
					pw.println(insertTerm.substring(0, insertTerm.length() - 3));
				}
				else {
					pw.println(firstName + ", " + lastName + ", " + salary + ", "
							+ empId + ", " + position + ", " + email);
				}
				x.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump = new File(filePath);
				newFile.renameTo(dump);
			}
		}catch(Exception e) {
			System.out.println("Error");
		}
	}
	public static String getFilePath(String department) {
		File[] directoryList = Filtered.finder(Initial.getDirectoryPath());
		String deptPath = "";
		int startSliceIdx = 0;
		int endSliceIdx = 0;
		for (File filePath : directoryList) {
			 ArrayList<String[]> deptValueList = new ArrayList<String[]>();
			deptPath = filePath.toString();
			startSliceIdx = Filtered.getSubstrLength(deptPath);
			endSliceIdx = deptPath.indexOf('.');
			String currentKey = (deptPath.substring(startSliceIdx, endSliceIdx));
			if(currentKey == department) {
				return deptPath;
			}
		}
		return null;

	}
	public static int promptUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("1 Management\n2 Customer Service\n3 Engineering"+
				"\n4 Marketing\n5 Sales\n6 Executive\n7 Human Resources\n");
		System.out.println("Enter the department number that you wish to edit: ");
		int departmentChoice = input.nextInt();
		return departmentChoice;
		
	}
}
