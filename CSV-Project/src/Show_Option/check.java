package Show_Option;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class check {
	String filename = null;

	public void checkexistence() {
		String[] defaultRow = { "Id", "Name", "Salary", "Department", "Gender" };
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name with extension");
		filename = scanner.nextLine();
		File file = new File("C:\\Users\\saurabh.chauhan\\eclipse-workspace\\" + filename);
		if (file.exists() == true) {
			System.out.println("File exist in your system");
			new Options(file);
		} else {
			try {
				FileWriter fw = new FileWriter(file, true);
				CSVWriter csvWriter = new CSVWriter(fw);
				csvWriter.writeNext(defaultRow);
				csvWriter.close();
				System.out.println("Your file has been created");
				new Options(file);
				fw.close();
			} catch (IOException e) {
				System.out.println("File not found");
			}
		}
	}

}
