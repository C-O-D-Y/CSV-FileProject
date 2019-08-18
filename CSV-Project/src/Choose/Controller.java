package Choose;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

import methods.Insert;
import methods.Search_Options;
import update.UpdateOptions;

public class Controller {

	public void getchoice(int choose, File file) throws IOException {

		switch (choose) {
		case 1:
			try {
				new Insert(file).insert();
			} catch (InputMismatchException e) {
				System.out.println("Wrong Input");
			}
			break;
		case 2:
			try {
				new Search_Options().options(file);
			} catch (InputMismatchException | IOException e) {
				System.out.println("Wrong Input");
			}

			break;
		case 3:
			try {
				new methods.DeleteEmployeeOptions(file);
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;

		case 4:
			try {
				new UpdateOptions(file).updateOptions();
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Adios Amigo");
			System.exit(0);
		default:
			System.out.println("Wrong Option, Please select Correct Option");
		}
	}
}