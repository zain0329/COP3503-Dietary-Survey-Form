import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
/** 
 * Creates the GUI for the Dietary Survey Form
*/ 
@SuppressWarnings("serial")
public class CustomJFrame extends JFrame {

	//declare variables
	public static String data = "";
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	private static JTextField firstNameTextField;
	private static JTextField lastNameTextField;
	private static JTextField phoneNumberTextField;
	private static JTextField emailTextField;
	private static JRadioButton maleRadioButton;
	private static JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private static ButtonGroup radioButtonGroup;
	private static JSpinner waterIntakeSpinner;
	private static JSlider mealSlider;
	private static JCheckBox wheatCheckBox;
	private static JCheckBox sugarCheckBox;
	private static JCheckBox dairyCheckBox;
	@SuppressWarnings("rawtypes")
	private static JComboBox walkComboBox;
	private String[] walkOptions = {"Less than 1 Mile                                             ", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	private static JFormattedTextField weightFormattedTextField;
	private static JButton clearButton;
	private static JButton submitButton;
	private FileHandler fileHandler = new FileHandler();
	GridBagConstraints gbc = new GridBagConstraints();
	
	/** 
	   * Creates the GUI window for the survey
	* @return The GUI window for the survey.
	*/ 
	public CustomJFrame() {
		
		//set the window layout to grid bag layout
		setLayout(new GridBagLayout());

		//add personal information heading
		headingLabel = new JLabel("Personal Information");
		gbc.insets = new Insets(10, -15, 6, 0);
		add(headingLabel, gbc);
	
		
		//add first name
		firstNameLabel = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(firstNameLabel, gbc);
		setFirstNameTextField(new JTextField("",15));
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(getFirstNameTextField(), gbc);
		
		
		//add last name
		lastNameLabel = new JLabel("Last Name:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(lastNameLabel, gbc);
		setLastNameTextField(new JTextField("",15));
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(getLastNameTextField(), gbc);
		
		
		//add phone number
		phoneNumberLabel = new JLabel("Phone Number:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(phoneNumberLabel, gbc);
		setPhoneNumberTextField(new JTextField("",15));
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(getPhoneNumberTextField(), gbc);
		
		
		//add email
		emailLabel = new JLabel("Email:");
		gbc.gridx = 0;
		gbc.gridy = 8;
		add(emailLabel, gbc);
		setEmailTextField(new JTextField("",15));
		gbc.gridx = 1;
		gbc.gridy = 8;
		add(getEmailTextField(), gbc);
		
		
		//add sex
		genderLabel = new JLabel("Sex:");
		gbc.gridx = 0;
		gbc.gridy = 10;
		add(genderLabel, gbc);
		setMaleRadioButton(new JRadioButton("Male"));
		setFemaleRadioButton(new JRadioButton("Female"));
		preferRadioButton = new JRadioButton("Prefer not to say");
		setRadioButtonGroup(new ButtonGroup());
		getRadioButtonGroup().add(getMaleRadioButton());
		getRadioButtonGroup().add(getFemaleRadioButton());
		getRadioButtonGroup().add(preferRadioButton);
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.insets = new Insets(-3, -152, -10, 0);
		add(getMaleRadioButton(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.insets = new Insets(-3, -137, 0, 0);
		add(getFemaleRadioButton(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.insets = new Insets(-3, -85, 0, 0);
		add(preferRadioButton, gbc);
		
	
		
		//add dietary questions heading
		dietaryLabel = new JLabel("Dietary Questions");
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.insets = new Insets(10, -15, 6, 0);
		add(dietaryLabel, gbc);
		
		
		//add water question
		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		gbc.gridx = 1;
		gbc.gridy = 16;
		gbc.insets = new Insets(10, -110, 6, 0);
		add(waterLabel, gbc);
		SpinnerNumberModel spinner = new SpinnerNumberModel(15,0,50,1);
		setWaterIntakeSpinner(new JSpinner(spinner));
		gbc.gridx = 1;
		gbc.gridy = 18;
		gbc.insets = new Insets(10, -110, 2, 0);
		add(getWaterIntakeSpinner(), gbc);

		
		
		//add meals question
		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		gbc.gridx = 1;
		gbc.gridy = 20;
		gbc.insets = new Insets(10, -110, 10, 0);
		add(mealsLabel, gbc);
		setMealSlider(new JSlider(JSlider.HORIZONTAL, 0, 10, 3));
		getMealSlider().setPaintTicks(true);
		getMealSlider().setPaintLabels(true);
		getMealSlider().setSnapToTicks(true);
		getMealSlider().setMajorTickSpacing(1);
		gbc.gridx = 1;
		gbc.gridy = 22;
		gbc.insets = new Insets(10, -110, 2, 0);
		add(getMealSlider(), gbc);
		
		//add check boxes
		checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
		gbc.insets = new Insets(10, -120, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 23;
		add(checkBoxLabel, gbc);
		setDairyCheckBox(new JCheckBox("Dairy"));
		gbc.insets = new Insets(10, -270, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 24;
		add(getDairyCheckBox(), gbc);
		setWheatCheckBox(new JCheckBox("Wheat"));
		gbc.insets = new Insets(10, -140, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 24;
		add(getWheatCheckBox(), gbc);
		setSugarCheckBox(new JCheckBox("Sugar"));
		gbc.insets = new Insets(10, -10, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 24;
		add(getSugarCheckBox(), gbc);
		
		//add miles question
		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		gbc.insets = new Insets(10, -110, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 25;
		add(walkLabel, gbc);
		setWalkComboBox(new JComboBox(walkOptions));
		gbc.gridx = 1;
		gbc.gridy = 26;
		gbc.insets = new Insets(10, -110, 4, 0);
		add(getWalkComboBox(), gbc);
		
		//add weight question
		weightLabel = new JLabel("How much do you weigh?");
		gbc.insets = new Insets(10, -110, 4, 0);
		gbc.gridx = 1;
		gbc.gridy = 27;
		add(weightLabel, gbc);
		setWeightFormattedTextField(new JFormattedTextField("                                                           "));
		gbc.gridx = 1;
		gbc.gridy = 28;
		gbc.insets = new Insets(10, -110, 4, 0);
		add(getWeightFormattedTextField(), gbc);
		
		//clear button
		setClearButton(new JButton("Clear"));
		gbc.gridx = 0;
		gbc.gridy = 29;
		Color yellow=new Color(255,255,0);
		getClearButton().setBackground(yellow);
		gbc.insets = new Insets(20, -70, 0, 0);
		getClearButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//call actionPerformed method from InnerActionLister class
				InnerActionListener innerActionListener = new InnerActionListener();
				innerActionListener.actionPerformed(e);
		    }
		});
		add(getClearButton(), gbc);
		
		//submit button
		setSubmitButton(new JButton("Submit"));
		Color green=new Color(0,255,0);
		getSubmitButton().setBackground(green);
		gbc.gridx = 1;
		gbc.gridy = 29;
		gbc.insets = new Insets(20, 0, 0, -160);
		
		getSubmitButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//call actionPerformed method from InnerActionLister class
				InnerActionListener innerActionListener = new InnerActionListener();
				innerActionListener.actionPerformed(e);
				fileHandler.writeResults(CustomJFrame.data);
		    }
		});
		add(getSubmitButton(), gbc);
		
	}
	
	/** 
	   * Getter method for first name text field.  
	* @return The first name text field.  
	*/ 
	public static JTextField getFirstNameTextField() {
		return firstNameTextField;
	}
	
	/**
	 * Setter method for first name text field.  
	 * @param firstNameTextField The first name text field. 
	 */
	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	/** 
	   * Getter method for phone number text field.  
	* @return The phone number text field.
	*/ 
	public static JTextField getPhoneNumberTextField() {
		return phoneNumberTextField;
	}
	
	/**
	 * Setter method for phone number text field. 
	 * @param phoneNumberTextField The phone number text field.
	 */
	public void setPhoneNumberTextField(JTextField phoneNumberTextField) {
		this.phoneNumberTextField = phoneNumberTextField;
	}

	/** 
	   * Getter method for last name text field.  
	* @return The last name text field.  
	*/
	public static JTextField getLastNameTextField() {
		return lastNameTextField;
	}
	
	/**
	 * Setter method for last name text field. 
	 * @param lastNameTextField The last name text field. 
	 */
	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	/** 
	   * Getter method for email text field.  
	* @return The email text field.  
	*/
	public static JTextField getEmailTextField() {
		return emailTextField;
	}
	
	/**
	 * Setter method for email text field. 
	 * @param emailTextField The email text field.
	 */
	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	/** 
	   * Getter method for female raio button.  
	* @return The female raio button.  
	*/
	public static JRadioButton getFemaleRadioButton() {
		return femaleRadioButton;
	}
	
	/**
	 * Setter method for female raio button.
	 * @param femaleRadioButton The female raio button.  
	 */
	public void setFemaleRadioButton(JRadioButton femaleRadioButton) {
		this.femaleRadioButton = femaleRadioButton;
	}

	/** 
	   * Getter method for male raio button.  
	* @return The male raio button.  
	*/
	public static JRadioButton getMaleRadioButton() {
		return maleRadioButton;
	}

	/** 
	   * Setter method for male raio button.  
	* @param maleRadioButton The male raio button.  
	*/
	public void setMaleRadioButton(JRadioButton maleRadioButton) {
		this.maleRadioButton = maleRadioButton;
	}

	/** 
	   * Getter method for water spinner.  
	* @return The water spinner.  
	*/
	public static JSpinner getWaterIntakeSpinner() {
		return waterIntakeSpinner;
	}

	/** 
	   * Setter method for water spinner.  
	* @param waterIntakeSpinner The water spinner.  
	*/
	public void setWaterIntakeSpinner(JSpinner waterIntakeSpinner) {
		this.waterIntakeSpinner = waterIntakeSpinner;
	}

	/**
	 * Getter method for radio button group.
	 * @return The radio button group.
	 */
	public static ButtonGroup getRadioButtonGroup() {
		return radioButtonGroup;
	}

	/**
	 * Setter method for radio button group.
	 * @param radioButtonGroup The radio button group.
	 */
	public static void setRadioButtonGroup(ButtonGroup radioButtonGroup) {
		CustomJFrame.radioButtonGroup = radioButtonGroup;
	}

	/**
	 * Getter method for wheat check box.
	 * @return The wheat check box.
	 */
	public static JCheckBox getWheatCheckBox() {
		return wheatCheckBox;
	}

	/**
	 * Setter method for wheat check box.
	 * @param wheatCheckBox The wheat check box.
	 */
	public static void setWheatCheckBox(JCheckBox wheatCheckBox) {
		CustomJFrame.wheatCheckBox = wheatCheckBox;
	}

	/**
	 * Getter method for sugar check box.
	 * @return The sugar check box.
	 */
	public static JCheckBox getSugarCheckBox() {
		return sugarCheckBox;
	}

	/**
	 * Setter method for sugar check box.
	 * @param sugarCheckBox The sugar check box.
	 */
	public static void setSugarCheckBox(JCheckBox sugarCheckBox) {
		CustomJFrame.sugarCheckBox = sugarCheckBox;
	}

	/**
	 * Getter method for daiy check box.
	 * @return The dairy check box.
	 */
	public static JCheckBox getDairyCheckBox() {
		return dairyCheckBox;
	}

	/**
	 * Setter method for dairy check box.
	 * @param dairyCheckBox The dairy check box.
	 */
	public static void setDairyCheckBox(JCheckBox dairyCheckBox) {
		CustomJFrame.dairyCheckBox = dairyCheckBox;
	}

	/**
	 * Getter method for weight text field.
	 * @return The weight text field.
	 */
	public static JFormattedTextField getWeightFormattedTextField() {
		return weightFormattedTextField;
	}

	/**
	 * Setter method for weight text field.
	 * @param weightFormattedTextField The weight text field.
	 */
	public static void setWeightFormattedTextField(JFormattedTextField weightFormattedTextField) {
		CustomJFrame.weightFormattedTextField = weightFormattedTextField;
	}

	/**
	 * Getter method for meal slider.
	 * @return The meal slider.
	 */
	public static JSlider getMealSlider() {
		return mealSlider;
	}

	/**
	 * Setter method for meal slider.
	 * @param mealSlider The meal slider.
	 */
	public void setMealSlider(JSlider mealSlider) {
		this.mealSlider = mealSlider;
	}

	/**
	 * Getter method for walk combo box.
	 * @return The walk combo box.
	 */
	public static JComboBox getWalkComboBox() {
		return walkComboBox;
	}

	/**
	 * Setter method for walk combo box.
	 * @param walkComboBox The walk combo box.
	 */
	public void setWalkComboBox(JComboBox walkComboBox) {
		this.walkComboBox = walkComboBox;
	}

	/**
	 * Getter method for clear button.
	 * @return The clear button.
	 */
	public static JButton getClearButton() {
		return clearButton;
	}



	/**
	 * Setter method for clear button.
	 * @param clearButton The clear button.
	 */
	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	/**
	 * Getter method for submit button.
	 * @return The submit button.
	 */
	public static JButton getSubmitButton() {
		return submitButton;
	}


	/**
	 * Setter method for submit button.
	 * @param submitButton The submit button.
	 */
	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}
	
	}

/** 
 * Performs action when the Submit or Clear buttons are pressed
*/ 
	   class InnerActionListener implements ActionListener {
		   
		   
		   /** 
		    * Performs action when button is pressed. 
		 * @param ActionEvent The ActionEvent that is performed.
		 * @return The submitted data.
		 */ 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//if clear button is pressed, clear form
			if(CustomJFrame.getClearButton().getModel().isArmed()) {
				clearForm();
			}
			//if submit button is pressed, save data and clear form
			else if(CustomJFrame.getSubmitButton().getModel().isArmed()){
				
			//save data to strings
			String firstName = CustomJFrame.getFirstNameTextField().getText() ;
			String lastName = CustomJFrame.getLastNameTextField().getText() ;
			String phoneNumber = CustomJFrame.getPhoneNumberTextField().getText();
			String email = CustomJFrame.getEmailTextField().getText();
			String sex = "";
			if(CustomJFrame.getMaleRadioButton().isSelected()) {
				sex = "Male";
			}else if(CustomJFrame.getFemaleRadioButton().isSelected()) {
				sex = "Female";
			}else {
				sex = "Prefer not to say";
			}
			int waterNumber = (Integer) CustomJFrame.getWaterIntakeSpinner().getValue();
			String waterNumberString = String.valueOf(waterNumber);
			int mealNumber = (Integer) CustomJFrame.getMealSlider().getValue();
			String mealNumberString = String.valueOf(mealNumber);
			String dairy = "";
			if(CustomJFrame.getDairyCheckBox().isSelected()) {
				dairy = "TRUE";
			}else {
				dairy = "FALSE";
			}
			String wheat = "";
			if(CustomJFrame.getWheatCheckBox().isSelected()) {
				wheat = "TRUE";
			}else {
				wheat = "FALSE";
			}
			String sugar = "";
			if(CustomJFrame.getSugarCheckBox().isSelected()) {
				sugar = "TRUE";
			}else {
				sugar = "FALSE";
			}
			String miles = CustomJFrame.getWalkComboBox().getSelectedItem().toString();
			String milesFinal = "";
			if(miles.contains("Less than 1 Mile")) {
				milesFinal = "Less than 1 Mile";
			}else if(miles.contains("More than 1 mile but less than 2 miles")) {
				milesFinal = "More than 1 mile but less than 2 miles";
			}else if(miles.contains("More than 2 mile")) {
				milesFinal = "More than 2 miles but less than 3 miles";
			}else if(miles.contains("More than 3 mile")) {
				milesFinal = "More than 3 miles";
			}

			//declares weight integer variable
			int weightNumber;
			String weight = CustomJFrame.getWeightFormattedTextField().getText().replaceAll("\\s", "");
			try {
				//if the weight string is parsed into the variable, the number is printed
				weightNumber = Integer.parseInt(weight);
				CustomJFrame.data = firstName + "," + lastName + "," + phoneNumber + "," + email + "," + sex + "," + waterNumberString + "," + mealNumberString + "," + wheat + "," + sugar + "," + dairy + "," + milesFinal + "," + weightNumber;
			}catch(Exception m){
				//if the weight string is not parsed into the variable, null is printed
				weightNumber = 0;
				CustomJFrame.data = firstName + "," + lastName + "," + phoneNumber + "," + email + "," + sex + "," + waterNumberString + "," + mealNumberString + "," + wheat + "," + sugar + "," + dairy + "," + milesFinal + "," + "null";
			}
			
			//calls clear form method to clear all forms
			clearForm();
			}
		}
		
		/** 
		   * Clears all forms.  
		* @return Cleared forms. 
		*/ 
		private void clearForm() {
			//clears all forms
			CustomJFrame.getFirstNameTextField().setText("");
			CustomJFrame.getLastNameTextField().setText("");
			CustomJFrame.getPhoneNumberTextField().setText("");
			CustomJFrame.getEmailTextField().setText("");
			CustomJFrame.getRadioButtonGroup().clearSelection();
			CustomJFrame.getWaterIntakeSpinner().setValue(0);
			CustomJFrame.getWheatCheckBox().setSelected(false);
			CustomJFrame.getDairyCheckBox().setSelected(false);
			CustomJFrame.getSugarCheckBox().setSelected(false);
			CustomJFrame.getWeightFormattedTextField().setText("                                                  ");
		}
		

	}

