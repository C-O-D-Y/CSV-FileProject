package checkId;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Show_Option.Options;
import fetchfile.Rewrite;

public class CheckUniqueId {
	File file1 = null;
	List<String[]> getAllData;
	Rewrite re = new Rewrite();
	String[] nextRecord;
	int flag=0;
	public void checkid(File file,int id) {
		try {
			file1=file;
			getAllData = re.rename(file1);
			for (int i = 0; i < getAllData.size(); i++) {
				nextRecord = getAllData.get(i);
				if (nextRecord[0].equals(Integer.toString(id))) {
					System.out.println("Sorry! Emp id already present");
					new Options(file1);
				}
			}
					} catch (IOException e) {
			System.out.println("System error occur");
			System.exit(0);
		}
	}
}
