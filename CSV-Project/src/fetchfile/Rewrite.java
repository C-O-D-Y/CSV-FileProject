package fetchfile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;

/*
 * In this Class i'm loading the filePath into FileWriter class so that we can use this file to write and save the data
 */
public class Rewrite {
	/*
	 * In this method, i'm rewriting the file of the new data
	 */
	public List<String[]> rename(File file) throws IOException, ArrayIndexOutOfBoundsException {
		FileReader filereader = new FileReader(file);
		CSVReader csvReader = new CSVReader(filereader);
		List<String[]> allData = csvReader.readAll();
		csvReader.close();
		return allData;
	}
}
