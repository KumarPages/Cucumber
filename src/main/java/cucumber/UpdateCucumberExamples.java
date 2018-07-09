package cucumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UpdateCucumberExamples {
	
	public static void main(String[] args) {
		replace("CreateLead",new String[] {"Babu","Manickam","N"});
	}

	public static void replace(String fileName, String[] data) {
		String oldFileName = "C:\\TL\\Cucumber\\CucumberLearning\\src\\main\\java\\features\\"+fileName+".feature";
		String tmpFileName = "C:\\TL\\Cucumber\\CucumberLearning\\src\\main\\java\\features\\"+fileName+"_u.feature";

		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			List<String> newLines = new ArrayList<>();
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));
			String line;
			boolean bExamplesFound = false;
			int i = 3;
			while ((line = br.readLine()) != null) {
				if (line.contains("Examples:")) {
					bExamplesFound = true;
					i = 0;
				}
				if(i==2 && bExamplesFound) {
					System.out.println(line);					
					line = "|"+String.join("|", data)+"|";
				}
				newLines.add(line);
				i++;
			}
			Files.write(Paths.get(tmpFileName), newLines, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				//
			}
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				//
			}
		}
		// Once everything is complete, delete old file..
		File oldFile = new File(oldFileName);
		oldFile.delete();

		// And rename tmp file's name to old file name
		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);

	}
}