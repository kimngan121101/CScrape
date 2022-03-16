import java.io.*;
import java.util.Scanner;

public class CScrape {

public static void main(String[] args) throws IOException { // Declare variables
	Scanner scnr = new Scanner (System.in);
	boolean isInComment = false;
	int lineNumber = 1;	
	String line;
	
	System.out.println("Please enter a filename: "); // Ask user for input file
	String filename = scnr.nextLine().trim();
	
		try // try and catch errors
		{ 	
		BufferedReader br = new BufferedReader(new FileReader(filename));  // Read file 
	    String newfilename = filename.substring(0, filename.length()-4);
		File newfile = new File(newfilename+"txt"); // Create new file (.txt)
		PrintWriter pw = new PrintWriter (newfile); 
		pw.write("Comment Scrape - N. Hoang \n\n");
		
		 while((line = br.readLine()) != null) // Write comments with line number
         { 
			line = line.trim();
			 if ((line.contains("/*") && !line.contains("*/")) || isInComment) {
				 isInComment = true;
				 if (line.contains("/*"))
				 		pw.write(lineNumber+": "+line.substring(line.indexOf("/*"))+"\n");
				 else if (line.contains("*/")) {
					 	pw.write(lineNumber+": "+line.substring(0, line.indexOf("*/")+2)+"\n");
					 	isInComment = false;
				 }
				 else 
					 pw.write(lineNumber+": "+line+"\n");
			 }
			 else if (line.contains("//"))
				 pw.write(lineNumber+": "+line.substring(line.indexOf("//"))+"\n");
			 if (line.contains("/*") && line.contains("*/"))
				 pw.write(lineNumber+": "+line.substring(line.indexOf("/*"), line.indexOf("*/")+2)+"\n");
			 
       	  	lineNumber++;	 
         } 	
		
		br.close(); // Prevent sources leak
		pw.close();	
		
		} // Catch file errors
		catch (FileNotFoundException e1){
			System.out.println("File not found!");
		}
		catch (IOException e) {
			System.out.println("File error!");
		}
		
		System.out.println("Done the program."); // End the program
		scnr.close(); // Prevent source leaks
	}

}
