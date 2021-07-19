package com.cognixia.jump.project.ems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface Initial {
	public static void loadDefaultFiles() throws FileNotFoundException {
		String salesFileName = "sales.txt";
		String marketingFileName = "marketing.txt";
		String humanResourcesFileName = "human_resources.txt";
		String executiveFileName = "executive.txt";
		String engineeringFileName = "engineering.txt";
		String customerServiceFileName = "customer_service.txt";
		String managementFileName = "management.txt";
		

		File salesFile = new File(salesFileName);
		if(!salesFile.exists()) {
			String salesEmployee1 = "John-Jacob, Jingleheimer-Schmidt, "
					+ "23000, 343, Sales Representative, jjjs@gmail.com";
			String salesEmployee2 = "Celeste, Nelson, 100000, 324, Sales Representative";
			PrintWriter salesFileOutput = new PrintWriter(salesFile);
			salesFileOutput.println(salesEmployee1);
			salesFileOutput.println(salesEmployee2);
			salesFileOutput.close();
			
		}
		
		
		File marketingFile = new File(marketingFileName);
		if(!marketingFile.exists()) {
			String marketingEmployee1 = "Mary, Celeste, 20000, 233, Marketing Intern,"
					+ " mary@gmail.com";
			String marketingEmployee2 = "John, Smith, 34000, 211, Marketing Senior";
			PrintWriter marketingFileOutput = new PrintWriter(marketingFileName);
			marketingFileOutput.println(marketingEmployee1);
			marketingFileOutput.println(marketingEmployee2);
			marketingFileOutput.close();
		}
		
		

		File hrFile = new File(humanResourcesFileName);
		if(!hrFile.exists()) {
			String hrEmployee1 = "Chad, Mendez, 29999, 123, Senior "
					+ "Resourcer, cm@gmail.com";
			String hrEmployee2 = "Ryan, Hall, 34000, 144, Junior Resourcer";
			PrintWriter hrFileOutput = new PrintWriter(hrFile);
			hrFileOutput.println(hrEmployee1);
			hrFileOutput.println(hrEmployee2);
			hrFileOutput.close();
		}

		File execFile = new File(executiveFileName);
		if(!execFile.exists()) {
			String executiveEmployee1 = "Chuck, Norris, 100000, 433, CEO, c@gmail.com";
			String executiveEmployee2 = "Angela, Merkle, 200000, 455, COO";
			PrintWriter execFileOutput = new PrintWriter(execFile);
			execFileOutput.println(executiveEmployee1);
			execFileOutput.println(executiveEmployee2);
			execFileOutput.close();
		}
		
		File engineeringFile = new File(engineeringFileName);
		if(!engineeringFile.exists()) {
			String engineeringEmployee1 = "John, Cena, 100000, 567, SW Engineer,"
					+ " jc@gmail.com";
			String engineeringEmployee2 = "Ellen, Mirran, 200000, 599, FullStack "
					+ "Engineer";
			PrintWriter engineeringFileOutput = new PrintWriter(engineeringFile);
			engineeringFileOutput.println(engineeringEmployee1);
			engineeringFileOutput.println(engineeringEmployee2);
			engineeringFileOutput.close();
		}
		
		File customerServiceFile = new File(customerServiceFileName);
		if(!customerServiceFile.exists()) {
			String csEmployee1 = "Ellen, Degenerous, 30000, 695, Customer-service"
					+ " Representative, ed@gmail.com";
			String csEmployee2 = "Dave, Mathews, 49000, 654, Customer-service "
					+ "Agent";
			PrintWriter csFileOutput = new PrintWriter(customerServiceFile);
			csFileOutput.println(csEmployee1);
			csFileOutput.println(csEmployee2);
			csFileOutput.close();
		}
		
		File managementFile = new File(managementFileName);
		if(!managementFile.exists()) {
			String managementEmployee1 = "Albert, Camus, 200000, 788, National"
					+ " Manager, ac@gmail.com";
			String managementEmployee2 = "Kim, Possible, 39222, 783, SW Regional"
					+ " Manager";
			PrintWriter managementFileOutput = new PrintWriter(managementFile);
			managementFileOutput.println(managementEmployee1);
			managementFileOutput.println(managementEmployee2);
			managementFileOutput.close();
					
		}
	}
	public static String getDirectoryPath() {
		File managementFile = new File("management.txt");
		String path = managementFile.getAbsolutePath();
		//System.out.println(path);
		return path.substring(0, path.length() - 15);
	}

	
}
