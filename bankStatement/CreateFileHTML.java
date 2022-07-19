package bankStatement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileHTML {
	
	public CreateFileHTML(String filename,String fileDetails) 
	{
		
		{
			try {
				FileWriter myObj =  new FileWriter(filename + ".html");
				
				myObj.write(fileDetails);
				myObj.close();
				System.out.println("Sucessfully written file "+ filename);
	
				
			} catch (IOException e) {
				
				System.out.println("An eror has occured.");
				e.printStackTrace();
			}
			
			
			
		}
		
	}

}
