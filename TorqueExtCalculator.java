import javax.swing.*;
import java.text.DecimalFormat;

public class TorqueExtCalculator 
{
	
	//format double
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void main(String[] args)
	{
	

		//creates blank fields           //5 character lengths of space
		JTextField tqField = new JTextField(5);
		JTextField tqLenField = new JTextField(5);
		JTextField adapterField = new JTextField(5);
	
		//creates object in JPanel class
		JPanel myPanel = new JPanel();
	
		//adds a label (text)
		myPanel.add(new JLabel("TQ Applied (in/ft):"));
		//adds field to input text
		myPanel.add(tqField);
	
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	
		//adds a label (text)
		myPanel.add(new JLabel("Length of TQ Wrench (in inches):"));
		//adds a field to input text
		myPanel.add(tqLenField);
	
		myPanel.add(Box.createHorizontalStrut(15));// a spacer
	
		//adds a label(text)
		myPanel.add(new JLabel("Length of adapter (in inches):"));
		//adds a field to input text
		myPanel.add(adapterField);
	
	
		//adds a label to the window, and the ok/cancel option
		int result = JOptionPane.showConfirmDialog(null, myPanel,
				   "Please Enter Specified TQ, Length of TQ Wrench, Length of Adapter", JOptionPane.OK_CANCEL_OPTION);
	
		//what happens when "OK" is pressed
		while (result == JOptionPane.OK_OPTION)
		{
			
			//values are set using getters and parsed from a string into a double
			double TA = Double.parseDouble(tqField.getText());
			double L= Double.parseDouble(tqLenField.getText());
			double A = Double.parseDouble(adapterField.getText());
	
			//caculate new torque value based on inputed info
			double newTorque = (TA * L)/(L + A);
	
			//format the newTorque into 2 decimal places
			String message = ("(IF VALUE WAS INCH LBS USES INCH POUNDS. IF IT WAS FOOT LBS USE FOOT POUNDS)\n The new TQ is " + df2.format(newTorque) + "(in/ft) lbs.");
			//display new message
			JOptionPane.showMessageDialog(null, message);
			
			//prompt again for another calculation
			result = JOptionPane.showConfirmDialog(null, myPanel,
					   "Please Enter Specified TQ, Length of TQ Wrench, Length of Adapter", JOptionPane.OK_CANCEL_OPTION);
	
	
		 }
		
			//ensures nothing is left running in the background
			//not sure if is needed. Need to further educate on Swing
			System.exit(0);
		
	
	
	
	}

}
