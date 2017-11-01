package application.model;

/**
 * Calculator class handles the model for a basic Java calculator.
 * 
 * @author Dr. T. Bylander	- Java Swing version
 * @author Dr. A. Fernandez	- updated to JavaFX Fall 2017
 */
public class Calculator {

    private double displayValue;			// the numeric value of the number the user is entering, or the number that was just calculated
	private double internalValue;		// the previous value entered or calculated
	private String displayString;		// the String corresponding to what the user is entering
	private String operation;			// the last operation entered by the user
	private boolean start;				// true if the next digit entered starts a new value
    private boolean dot;					// true if a decimal dot has been entered for the current value

	public Calculator() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}

	/**
	 * Updates the values maintained by the calculator based on the
	 * button that the user has just clicked.
	 * 
	 * @param text is the name of the button that the user has just clicked
	 */
	public void update(String text) {
		if (start) {	
			internalValue = displayValue;
			displayValue = 0;
			displayString = "";
			start = false;
			dot = false;
		}
		if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
			displayString += text;
			displayValue = Double.valueOf(displayString);
		} else if (text.equals(".")) {
			if (! dot) {	
				dot = true;	
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
			}
		} else {
		    if (operation.equals("+")) {
				displayValue = internalValue + displayValue;
			} else if (operation.equals("-")) {
				displayValue = internalValue - displayValue;
			} else if (operation.equals("*")) {
				displayValue = internalValue * displayValue;
			} else if (operation.equals("/")) {
				displayValue = internalValue / displayValue;
			} else if( operation.equals("=") ) {
				displayValue = internalValue;
			} else if( operation.equals("C")) {
				displayValue = 0;
				internalValue = 0;
				displayString = "";
			} else if ( operation.equals( "x^2" ) ) {
				displayValue = displayValue * displayValue;
			}
//			} else if( operation.equals( "%" ) ) {
//				displayValue = internalValue / 100;
//			} else if( operation.equals( "^2" ) ) {
//				displayValue = internalValue * internalValue;
//			} else if( operation.equals( "^3" ) ) {
//				displayValue = internalValue * internalValue * internalValue;
//			} else if( operation.equals( "C" ) ) {
//				displayValue = 0;
//			}
		    
			displayString = "" + displayValue;
			internalValue = displayValue;
			operation = text;
			start = true;
		}
	}
}
