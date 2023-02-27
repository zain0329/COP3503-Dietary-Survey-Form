/* 
*  Author: Zain Malik 
*  Course: COP3503 
*  Project #: 4
*  Title  : Dietary Survey Form 
*  Due Date:  12/11/2022 
*  
*  Creates a Dietary Survey Form 
*/ 
 
import javax.swing.JFrame;
/** 
 * Creates a Dietary Survey Form 
*/ 
public class Project4 {

	
	public static void main(String[] args) {


		//creates CustomJFrame constructor
		CustomJFrame customJframe = new CustomJFrame();
		
		//sets title of the Dietary Survey Form window
		customJframe.setTitle("Dietary Survey");
		
		//sets the size of the window
		customJframe.setSize(370, 750);
		
		//closes the window if the X button is pressed
		customJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sets the visibility of the window to true
		customJframe.setVisible(true);
		
		
	}

}
