package Facade.facade_example2;

import java.io.IOException;

public class FileSystemFacade {

	private FileWriter fileWriter;
	private FileReader fileReader;
	private FileDeleter fileDeleter;

	public FileSystemFacade() {
		this.fileWriter = new FileWriter();
		this.fileReader = new FileReader();
		this.fileDeleter = new FileDeleter();
	}

	public String readFile(String filePath) {
		try {
			return fileReader.readFile(filePath);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return null;
		}
	}

	public boolean writeFile(String filePath, String content) {
		try {
			fileWriter.writeFile(filePath, content);
			return true;
		} catch (IOException e) {
			System.err.println("Error writing file: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteFile(String filePath) {
		try {
			fileDeleter.deleteFile(filePath);
			return true;
		} catch (IOException e) {
			System.err.println("Error deleting file: " + e.getMessage());
			return false;
		}
	}
}
