import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class CScrape_NganHoang {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		String userInput;
		do {
		try {
			
		System.out.println("Please enter a filename: ");
		String filename = scnr.nextLine();
		
		String newfilename = filename.substring(0, filename.indexOf('.')+1);
		
		File file = new File(newfilename+"txt");
		
		
		PrintWriter pw = new PrintWriter(file);
		
		pw.println("Comment Scrape - N. Hoang");
		pw.println("No // comment here! ");
		pw.println("No /* comment here! */");
		pw.println("There is a" + // comment here! 
		" comment. ");
		pw.println("/*****************************************");
		pw.println("** This is my program // Weird comment! **");
		pw.println("*****************************************/");
		pw.println("/* Amount available */");
		pw.println("/* This is my code */");
		pw.println("int total, /* Amount available */ used /* Another comment */;");
		pw.println("int total, /* Amount available */ used // Another comment");
		pw.close();
		
		Scanner scnr1 = new Scanner(file);

		int lineNumber = 1;
		 
		String line0 = scnr1.nextLine();
		System.out.println(line0 + "\n" );
		 
	    while(scnr1.hasNextLine()){
	    	 
	    String line = scnr1.nextLine();
	    System.out.println(lineNumber + ": " + line);
	    lineNumber++;
	    }
	    scnr1.close();
		}
		catch (IOException e) {
			System.out.println("File error!");
		}
		
		System.out.println("\nDo you want to quit?");
		userInput = scnr.nextLine();
		
		} while (userInput.equalsIgnoreCase("no"));
		
		System.out.println("Done the program.");
		
		scnr.close();
	}

}
