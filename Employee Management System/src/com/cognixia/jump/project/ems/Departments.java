package com.cognixia.jump.project.ems;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Departments extends Employee implements Filtered, Initial{

	public static Hashtable<String, Employee> departments = new 
			Hashtable<String, Employee>();

	public static Hashtable<String, ArrayList<Employee>> getCurrentDirectory() throws FileNotFoundException {

		String currentKey = "";
		
		 Hashtable<String, ArrayList<Employee>> directory = new Hashtable<String, ArrayList<Employee>>();

		File[] directoryList = Filtered.finder(Initial.getDirectoryPath());
		String deptFile = "";
		int startSliceIdx = 0;
		int endSliceIdx = 0;

		Scanner sc = null;
		for (File file : directoryList) {
			 ArrayList<String[]> deptValueList = new ArrayList<String[]>();
			deptFile = file.toString();
			startSliceIdx = Filtered.getSubstrLength(deptFile);
			endSliceIdx = deptFile.indexOf('.');
			currentKey = (deptFile.substring(startSliceIdx, endSliceIdx));
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				deptValueList.add(sc.nextLine().split(", "));
				//tempStringArray

			}
			ArrayList<Employee> employeesList = new ArrayList<Employee>();
			for(String[] employee: deptValueList) {
				int i = 0;
				Employee employeeObj = new Employee();
				
				for (String attribute : employee) {
//					System.out.println(attribute);
//					System.out.println(i);
					employeeObj.updateEmployee(i, attribute);
					i++;
					
				}
				employeesList.add(employeeObj);
				
			}
			
			directory.put(currentKey, employeesList);
		}
		

		return directory;
		
	}

	@Override
	public String toString() {
		Hashtable<String, ArrayList<Employee>> directory;
		try {
			directory = getCurrentDirectory();
			String output = "";
			Iterator<Map.Entry<String, ArrayList<Employee>>> itr = directory.entrySet().iterator();
			Map.Entry<String, ArrayList<Employee>> entry = null;
			String fileName = "";
			while(itr.hasNext()) {
				
				entry = itr.next();
				fileName = entry.getKey() + ".csv";
				FileWriter csvWriter = new FileWriter(fileName);
				//System.out.println( );
				ArrayList<Employee> employees = entry.getValue();
				for(Employee employee: employees) {
					csvWriter.append(employee.toString());
				}
				output += entry.getKey() + "->" + entry.getValue() + "\n";
				csvWriter.flush();
				csvWriter.close();
			}
			return output;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}
}