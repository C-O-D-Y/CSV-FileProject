package methods;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import checkId.CheckUniqueId;

public class Insert {
    File file_path;
    int emp_id;
    String emp_name;
    double emp_salary;
    String emp_department;
    String emp_gender;
    CheckUniqueId cui=new CheckUniqueId();
    Scanner input=new Scanner(System.in);
	public Insert(File file_path)
	{
		this.file_path=file_path;
	}
	public void insert() {
		try {
		System.out.print("Please enter the Employee id:");
		emp_id = input.nextInt();
		cui.checkid(file_path, emp_id);
		System.out.print("Please enter Employee Name:");
		input.nextLine();
		emp_name = input.nextLine();
		System.out.print("Please enter the Employee Salary:");
		emp_salary = input.nextDouble();
		System.out.print("Please enter your Employee Department:");
		input.nextLine();
		emp_department = input.nextLine();
		System.out.print("Please enter Gender of the Employee:");
		emp_gender = input.nextLine();
		FileWriter outputfile = new FileWriter(file_path,true); 
		CSVWriter writer = new CSVWriter(outputfile);
		String[] data= {Integer.toString(emp_id),emp_name,Double.toString(emp_salary),emp_department,emp_gender};
		writer.writeNext(data);
		writer.close();
		}
		catch(Exception e) {
			System.out.println("Wrong Input! Please Enter Correct Data");
			new Insert(file_path).insert();
		}
	}
}
