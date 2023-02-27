import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/** 
 * The File Handler that creates the csv file with the result data 
*/ 
public class FileHandler {

	//declares private variables
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	
	/** 
	   * Creates the header and csv file.
	* @return The csv file with the header 
	*/ 
	public FileHandler() {
		
		try {
			//create header
			String header = "DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight\n";
			
			//create csv file
			printWriter =new PrintWriter(new FileWriter(surveyFile, true ));
			
			//write header to csv file
			printWriter.write(header);
			
			//flush and close the printwriter
			printWriter.flush();
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	   * Appends the survey data to the csv file
	* @param surveyFile The name of the csv file. 
	* @return The csv file with the written data.
	*/ 
	public void writeResults(String surveyData) {
		
		try {
			
		//allow the file writer to append the existing csv file
		 fileOutput = new FileWriter(surveyFile, true); 
		
		//create new date to add dates and time to log file
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		 Date date = new Date();  
		 
		 //convert data to string
		 String newDate = formatter.format(date);  
		 
	
		 //write data to file 
		fileOutput.append(newDate+","+surveyData+"\n");
	     
		//close file writer
		fileOutput.close();
		 
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
