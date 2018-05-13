package Calculations;
/* ---------------------------------------------------
 * Generate button logic & data flow explanation:
 * ---------------------------------------------------
 * Cache our input data from our double variable soda
 * Set the price of x dollar value to the selected item
 * Once decimal amount is inputed by end user, our cached
 * data is stored. Cached data is stored with next items
 * that are calculated. We use the same method as earlier 
 * stated.
 * 
 * We add the cached data (variable name) to any other
 * items that are present in this case.
 * Cycle will loop each time the button is clicked,
 * triggering the action to preform the methods below.
 * -----------------------------------------------------
 * Test Method | Pass | Fail | Result | Program Result
 * -----------------------------------------------------
 * Coke = C    |  xxx | xxxx | xxxx   |    xxxxxxx
 * Diet = D    |  xxx | xxxx | xxxx   |    xxxxxxx
 * 2 * C       |   Y  |  N   | 3.00   |    3.00
 * 1 * D       |   Y  |  N   | 1.50   |    1.60  
 * -----------------------------------------------------
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Drop_Items {

	private JFrame frame;
	private JTextField input_qty;

	/**
	 * Launch the application.
	 */
	final double PRICE_Coke = 1.5;
	final double PRICE_Diet_Coke = 1.5;
	final double PRICE_Sprite = 2.0;
	final double PRICE_Seltzer = 0.50;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drop_Items window = new Drop_Items();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drop_Items() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		input_qty = new JTextField();
		input_qty.setColumns(10);
		input_qty.setBounds(231, 56, 175, 56);
		frame.getContentPane().add(input_qty);

		JLabel label = new JLabel("Total Cost");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		label.setBounds(25, 158, 194, 57);
		frame.getContentPane().add(label);

		JLabel Jlbl_Total_Cost = new JLabel("");
		Jlbl_Total_Cost.setForeground(Color.DARK_GRAY);
		Jlbl_Total_Cost.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jlbl_Total_Cost.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		Jlbl_Total_Cost.setBackground(Color.BLACK);
		Jlbl_Total_Cost.setBounds(231, 158, 175, 57);
		frame.getContentPane().add(Jlbl_Total_Cost);
		/* ---------------------------------------------------
		 * Generate button logic & data flow explanation:
		 * ---------------------------------------------------
		 * Cache our input data from our double variable drinks
		 * Set the price of x dollar value to the selected item
		 * from the JComboBox.
		 * Once decimal amount is inputed by end user, our cached
		 * data is stored. Cached data is stored within the combo
		 * box. Then, its calculated once button is triggered.
		 * 
		 * 
		 * We add the cached data (variable name) to any other
		 * items that are present in this case.
		 * Cycle JCombobox with IF/ELSE statements.
		 * 
		 * -----------------------------------------------------
		 * Test Method | Pass | Fail | Result | Program Result
		 * -----------------------------------------------------
		 * |C = COKE   |  x   |  x   |  N/A   |
		 * |S = SPRITE |  x   |  x   |  N/A   |
		 * |D = DIET   |  x   |  x   |  N/A   |
		 * |s = Seltzer|  x   |  x   |  N/A   |
		 * |C * 2      |  Y   |  N   |  3.00  | 3.00
		 * |S * 1      |  Y   |  N   |  2.00  | 2.00
		 * |D * 5      |  Y   |  N   |  7.50  | 7.50
		 * |s * 100    |  Y   |  N   |  100.00| 100.00
		 * |(AB)*(XCB) |  N   |  Y   | UNABLE TO COMPUTE, NEED
		 * |						 | TO MAKE INT ONLY NOT CHAR
		 * -----------------------------------------------------
		 */
		// ---JComboBox-----//
		JComboBox combo_box_drinks = new JComboBox();
		combo_box_drinks.setModel(new DefaultComboBoxModel(new String[] {"Select Soda", "Coke", "Diet Coke", "Sprite", "Seltzer"}));
		combo_box_drinks.setBounds(25, 56, 184, 56);
		frame.getContentPane().add(combo_box_drinks);
		// ---//
		JButton Generate = new JButton("GENERATE");
		Generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Drinks = Double.parseDouble(input_qty.getText());
				double Coke = PRICE_Coke * Drinks;
				double Diet_Coke = PRICE_Diet_Coke * Drinks;
				double Sprite = PRICE_Sprite * Drinks;
				double Seltzer = PRICE_Seltzer * Drinks;
				double Select_Soda = 0 * Drinks;
		
				if (combo_box_drinks.getSelectedItem().equals("Coke"))
				{
					String cCoke = String.format("%.2f", Coke);
					Jlbl_Total_Cost.setText(cCoke);
				}
				
				if (combo_box_drinks.getSelectedItem().equals("Diet Coke"))
				{	
					String dCoke = String.format("%.2f", Diet_Coke);
					Jlbl_Total_Cost.setText(dCoke);
				}
				if (combo_box_drinks.getSelectedItem().equals("Sprite"))
				{	
					String sprite = String.format("%.2f", Sprite);
					Jlbl_Total_Cost.setText(sprite);
				}
				
				if (combo_box_drinks.getSelectedItem().equals("Seltzer"))
				{	
					String selz = String.format("%.2f", Seltzer);
					Jlbl_Total_Cost.setText(selz);
				}
				
				if (combo_box_drinks.getSelectedItem().equals("Select Soda"))
				{	
					String nada = String.format("%.2f", Select_Soda);
					Jlbl_Total_Cost.setText(nada);
				}	
				
			}
			
		});
		Generate.setBounds(0, 227, 175, 29);
		frame.getContentPane().add(Generate);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combo_box_drinks.setSelectedIndex(0);
				Jlbl_Total_Cost.setText("0");
				input_qty.setText(null);
				
			}
		});
		btnReset.setBounds(231, 227, 175, 29);
		frame.getContentPane().add(btnReset);

	}
}
