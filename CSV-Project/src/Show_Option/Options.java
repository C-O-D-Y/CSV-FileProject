package Show_Option;

import java.io.File;
import java.util.Scanner;

import Choose.Controller;

public class Options {
	public Options(File file) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try
		{
		do {
			System.out.println("\n Please choose one of the below options" + "\n1: New Employee."
					+ "\n2: Fetch Employee." + "\n3: Delete current Employee." + "\n4: Update Employee"
					+ "\n5: Exit");
			int option = scanner.nextInt();
			//calling Controller class from package com.EmployeeManager.Choose
			Controller c=new Controller();
			c.getchoice(option,file);
		} 
		while (1 > 0);
		}
		catch (Exception e) {
			System.out.println("Wrong input\n Please select from the given options only");
			new Options(file);
		}
	}
}
