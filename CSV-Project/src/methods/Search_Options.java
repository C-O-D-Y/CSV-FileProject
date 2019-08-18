package methods;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*This class gives option to choose the user to fetch employee by given parameters.
By using switch case it manages the flow control of the program.
*/

public class Search_Options {

	Scanner scanner = new Scanner(System.in);
	// Iterator<EmployeeDetails> itr = EmployeeDetails.iterator;

	public Search_Options() throws InputMismatchException {
		System.out.println("\nPlease choose one of the below options" + "\n1: All Employee." + "\n2: By Id."
				+ "\n3: By name " + "\n4: By Department ");
	}

	// Method options takes input from the user and check it via Switch case.
	public void options(File file) throws IOException {
		FetchEmployeeMethods fem = new FetchEmployeeMethods(file);
		switch (scanner.nextInt()) {
		case 1:
			fem.fetch();
			break;
		case 2:
			System.out.println("Please enter the id of the Employee");
			int id = scanner.nextInt();
			fem.fetch(id);
			break;

		case 3:
			System.out.println("Please enter the Name of the Employee");
			scanner.nextLine();
			String name = scanner.nextLine();
			fem.fetch(name);
			break;

		case 4:

			System.out.println("Please enter the Department of the Employee");
			scanner.nextLine();
			String department = scanner.nextLine();
			fem.fetch(department);
			break;

		default:
			System.out.println("Sorry! Wrong Input");
		}
	}
}
