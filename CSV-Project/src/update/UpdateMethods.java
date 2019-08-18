package update;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import fetchfile.ReInsert;
import fetchfile.Rewrite;

/*
 * This Class contains method for updating an employee 
 * which update the data of the employee in the Collection.
 */
public class UpdateMethods {
	List<String[]> getAllData;
	Rewrite re = new Rewrite();
	ReInsert reinsert = new ReInsert();
	String[] nextRecord;
	String updateInput;
	int flag = 0;

	/*
	 * Methods below takes Parameters from the user_input and being called to
	 * according method for update, when condition is satisfied it will just update
	 * the data in the file.
	 */
	public void update(File file, int option) throws IOException, InputMismatchException {
		try {
			getAllData = re.rename(file);
			System.out.println("Please enter the id of the employee which you have to update");
			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();
			scanner.nextLine();
			closeLoop: for (int i = 0; i < getAllData.size(); i++) {
				nextRecord = getAllData.get(i);
				if (nextRecord[0].equals(Integer.toString(id))) {
					flag = 1;
					System.out.println("Please enter the updated data");
					switch (option) {
					case 1:
						updateInput = scanner.nextLine();
						nextRecord[1] = updateInput;
						getAllData.set(i, nextRecord);
						System.out.println("Record updated");
						reinsert.reInsertInFile(file, getAllData);
						break;
					case 2:
						int updatedId = scanner.nextInt();
						nextRecord[2] = Integer.toString(updatedId);
						getAllData.set(i, nextRecord);
						System.out.println("Record updated");
						reinsert.reInsertInFile(file, getAllData);
						break;
					case 3:
						updateInput = scanner.nextLine();
						nextRecord[3] = updateInput;
						getAllData.set(i, nextRecord);
						System.out.println("Record updated");
						reinsert.reInsertInFile(file, getAllData);
						break;
					case 4:
						updateInput = scanner.nextLine();
						nextRecord[4] = updateInput;
						getAllData.set(i, nextRecord);
						System.out.println("Record updated");
						reinsert.reInsertInFile(file, getAllData);
						break;
					default:
						System.out.println("Please enter correct input");
					}
					break closeLoop;
				}
			}
			if (flag == 0) {
				System.out.println("Enter id doesn't exist ");
				new UpdateMethods().update(file, option);
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter the integer value");
			new UpdateMethods().update(file, option);
		} catch (Exception e) {
			System.out.println("Please enter Correct value");
			new UpdateMethods().update(file, option);
		}
	}
}
