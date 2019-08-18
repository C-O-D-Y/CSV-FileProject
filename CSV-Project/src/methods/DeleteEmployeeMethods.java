package methods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import fetchfile.ReInsert;
import fetchfile.Rewrite;

public class DeleteEmployeeMethods extends FetchEmployeeMethods {
	File file = null;
	List<String[]> getAllData;
	Rewrite re = new Rewrite();
	ReInsert reinsert = new ReInsert();
	String[] nextRecord;

	public DeleteEmployeeMethods(File file) throws IOException {
		// FetchEmployeeMethods constructor is been called to load the txt file from the
		// class
		super(file);
		this.file = file;

		/*
		 * Calling rewriteFile() method to rewrite into the file
		 */
	}

	int flag = 0;

	/*
	 * In all below present methods, when if condition is true if true, then that
	 * line is not printed in the file.
	 */

	public void delete() throws IOException {
		getAllData = re.rename(file);
		getAllData.removeAll(getAllData);
		System.out.println("All Records deleted");
	}

	public void delete(String name) throws IOException {
		getAllData = re.rename(file);
		for (int i = 0; i < getAllData.size(); i++) {
			nextRecord = getAllData.get(i);
			if (nextRecord[1].equalsIgnoreCase(name) || nextRecord[3].equalsIgnoreCase(name)) {
				flag = 1;
				getAllData.remove(i);
				System.out.println("Records deleted");
			}
		}
		reinsert.reInsertInFile(file, getAllData);
		if (flag == 0) {
			System.out.println("No Records Found");
		}
	}

	public void delete(int id) throws IOException {
		getAllData = re.rename(file);
		for (int i = 0; i < getAllData.size(); i++) {
			nextRecord = getAllData.get(i);
			if (nextRecord[0].equals(Integer.toString(id))) {
				flag = 1;
				getAllData.remove(i);
				System.out.println("Records deleted");
			}
		}
		reinsert.reInsertInFile(file, getAllData);
		if (flag == 0) {
			System.out.println("No Records Found");
		}
	}
}
