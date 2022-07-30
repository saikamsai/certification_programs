import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VirtualKey {
	class Options {

		public static void printWelcomeScreen(String appName, String developerName) {
			String Details = String.format("*****************************************\n" + " Welcome to %s.com. \n"
					+ "This application was developed by %s.\n", appName, developerName);
			String appFunctions = "You can use this application to :-\n"
					+ " Retrieve all file names from the directory\n"
					+ " Search, add, or delete files from the directory\n"
					+ "\n**Please be careful and ensure that the correct filename provided for searching/deleting files.**\n";
			System.out.println(Details);

			System.out.println(appFunctions);
		}

		public static void displayMenu() {
			String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
					+ "1) Retrieving the file names in an ascending order\n"
					+ "2) Display menu for Business-level operations\n" + "3) Exit program\n";
			System.out.println(menu);
		}

		public static void displayFileMenuOptions() {
			String fileMenu = "\n\n****** Select any option from below and press Enter ******\n\n"
					+ "1) Add a file to existing directory\n" + "2) Delete a file from existing directory\n"
					+ "3) Search for a file from main directory\n" + "4) Show Previous Menu\n";
			System.out.println(fileMenu);
		}
	}

	class optionsSelection {
		public static void ScreenInput() {
			boolean running = true;
			Scanner sc = new Scanner(System.in);
			do {
				try {
					Options.displayMenu();
					int input = sc.nextInt();

					switch (input) {
					case 1:
						FileOps.RetrievingAllFiles("Sampletest");
						break;
					case 2:
						optionsSelection.FileMenuOptionsselection();
						break;
					case 3:
						System.out.println("Program exited successfully.");
						running = false;
						sc.close();
						System.exit(0);
						break;
					default:
						System.out.println("Please select a valid option from above.");
					}
				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					ScreenInput();
				}
			} while (running == true);
		}

		public static void FileMenuOptionsselection() {
			boolean running = true;
			Scanner sc = new Scanner(System.in);
			do {
				try {
					Options.displayFileMenuOptions();
					FileOps.createMainFolder("Sampletest");

					int input = sc.nextInt();
					switch (input) {
					case 1:
						// File Add
						System.out.println("Enter the file name to add in \"Sampletest\" folder");
						String filenameToAdd = sc.next();
						FileOps.FileCreation(filenameToAdd, sc);
						break;
					case 2:
						// File delete
						System.out.println("Enter the name of the file to be deleted from \"Sampletest\" folder");
						String filenameToDelete = sc.next();
						FileOps.DeleteFile(filenameToDelete, sc);
						break;
					case 3:
						// File Search
						System.out.println("Enter the file name to search from \"Sampletest\" folder");
						String filenameTosearch = sc.next();
						FileOps.createMainFolder("Sampletest");
						FileOps.searchFile(filenameTosearch, sc);
						break;
					case 4:
						// Go to Previous menu
						optionsSelection.ScreenInput();
						return;
					default:
						System.out.println("Please select a valid option from above.");
					}
				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					FileMenuOptionsselection();
				}
			} while (running == true);
		}
	}

	class FileOps {
		public static void createMainFolder(String folderName) {
			File file = new File(folderName);
			// If file doesn't exist, create the Sampletest folder
			if (!file.exists()) {
				file.mkdirs();
			}
		}

		public static void RetrievingAllFiles(String path) throws IOException {
			FileOps.createMainFolder("Sampletest");
			@SuppressWarnings("unused")
			List<String> filesListNames = FileOps.FilesInDirectory(path, new ArrayList<String>());
		}

		public static List<String> FilesInDirectory(String path, List<String> fileListNames) {
			File dir = new File(path);
			File[] files = dir.listFiles();
			List<File> filesList = Arrays.asList(files);
			Collections.sort(filesList);
			System.out.println("Displaying all files in ascending order\n");
			if (files != null && files.length > 0) {
				for (File file : filesList) {
					if (file.isDirectory()) {
						System.out.println(file.getName());
						fileListNames.add(file.getName());
						FilesInDirectory(file.getAbsolutePath(), fileListNames);
					} else {
						System.out.println(file.getName());
						fileListNames.add(file.getName());
					}
				}
			} else {
				System.out.println("--Empty Directory");
			}
			return fileListNames;
		}

		public static void FileCreation(String filenameToAdd, Scanner sc) {
			FileOps.createMainFolder("Sampletest");
			Path pathToFile = Paths.get("./Sampletest/" + filenameToAdd);
			try {
				Files.createDirectories(pathToFile.getParent());
				Files.createFile(pathToFile);
				System.out.println(filenameToAdd + " created successfully");
			} catch (IOException e) {
				System.out.println("Failed to create file " + filenameToAdd);
				System.out.println(e.getClass().getName());
			}
		}

		public static void DeleteFile(String filenameToDelete, Scanner sc) {
			FileOps.createMainFolder("Sampletest");
			Path pathToFile = Paths.get("./Sampletest/" + filenameToDelete);
			File dir = new File("Sampletest\\");
			String[] list = dir.list();
			try {
				// Delete file
				boolean flag = false;
				for (int i = 0; i < list.length; i++) {
					if (filenameToDelete.equals(list[i])) {
						flag = true;
					}
				}
				if (flag) {
					Files.delete(pathToFile);
					System.out.println("File deleted successfully");
				} else {
					System.out.printf("File not found : %s\n", pathToFile);
				}
			} catch (NoSuchFileException ex) {
				System.out.printf("File not found : %s\n", pathToFile);
			} catch (DirectoryNotEmptyException ex) {
				System.out.printf("Directory %s is not empty\n", pathToFile);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		}

		public static void searchFile(String filenameTosearch, Scanner sc) throws Exception {
			File dir = new File("Sampletest\\");
			String absolute = dir.getAbsolutePath();
			String[] list = dir.list();
			System.out.println("Files in the directory: " + Arrays.toString(list));
			boolean flag = false;
			for (int i = 0; i < list.length; i++) {
				if (filenameTosearch.equals(list[i])) {
					flag = true;
				}
			}
			if (flag) {
				System.out.println(filenameTosearch + " " + "File is Found" + "\nLocation is" + " " + absolute);
			} else {
				System.out.println("Unsuccessfull operation "+filenameTosearch + " " + "File Not Found");
			}
		}
	}

	public static void main(String[] args) {
		Options.printWelcomeScreen("LockedMe", "Saikam Saiswetha Reddy");
		optionsSelection.ScreenInput();
		FileOps.createMainFolder("Sampletest");

	}
}
