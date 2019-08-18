package fetchfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVWriter;
import Show_Option.Options;

public class ReInsert {
	String data[];

	public void reInsertInFile(File outputfile, List<String[]> nextRecord) throws NullPointerException, IOException {
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputfile);
		} catch (IOException e) {
			System.out.println("File not found");
			new Options(outputfile);
		}
		CSVWriter writer = new CSVWriter(fw);
		writer.writeAll(nextRecord);
		writer.close();
	}
}