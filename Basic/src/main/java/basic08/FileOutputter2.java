package basic08;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter2 implements Outputter {
	//어느 파일에 저장할 것인지
	private String filePath;
	
	public void setFilePath(String path) { filePath = path; }
	
	@Override
	public void output(String msg) throws IOException {
		FileWriter writer = new FileWriter(filePath);
		writer.write(msg);
		writer.close();
	}

}
