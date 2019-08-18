package update;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This Class contains method for Showing Options to update the data of an employee.
 */
public class UpdateOptions {
	File file;

	public UpdateOptions(File file2) {
		this.file = file2;
	}

	/*
	 * Methods below takes Parameters from the Controller and according to options
	 * being shown flow is being transferred to the update method
	 */
	public void updateOptions() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("\n Please choose one of the below options for update" + "\n1: update name"
					+ "\n2: Update salary." + "\n3: Update Departmant" + "\n4: Update Gender" + "\n5: Exit");
			int option = scanner.nextInt();
			// calling Update Options from package update.updateOptions package
			UpdateMethods up = new UpdateMethods();
			up.update(file, option);

		} catch (InputMismatchException e) {
			System.out.println("Please enter the correct value");
			new UpdateOptions(file);
		} catch (Exception e) {
			System.out.println("Wrong input\n Please select from the given options only");
			new UpdateOptions(file);
		}
	}
}
