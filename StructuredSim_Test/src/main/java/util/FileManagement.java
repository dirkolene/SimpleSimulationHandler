package util;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import static java.nio.file.StandardCopyOption.*;


public class FileManagement {
	
	public String saveSimultationResult(String result) throws IOException{
		Properties properties = new Properties();
		properties.put("Result", result);
		
		String filePath = "./data/results.txt";
		
		FileOutputStream fops;
		try {
			fops = new FileOutputStream(filePath, true);
			properties.store(fops, null);
			fops.flush();
			fops.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return filePath;
		
	}
	
	public void createFolder(String folderPath) {
		new File(folderPath).mkdir();
	}
	
	public void moveFile(String originFile, String destinationFile){
		Path originPath = Paths.get(originFile);
		Path destinationPath = Paths.get(destinationFile);
		try {
		
			Files.move(originPath, destinationPath, REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Impossible to move this file");
			e.printStackTrace();
		}
		
		
	}

}