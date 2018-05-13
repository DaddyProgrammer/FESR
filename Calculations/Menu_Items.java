package Calculations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Items {

	private JFrame frame;
	private JTextField BURGER;
	private JTextField CH_BURGER;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Items window = new Menu_Items();
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
	public Menu_Items() {
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
		
	
		
		JLabel lblCost = new JLabel("");
		lblCost.setForeground(Color.DARK_GRAY);
		lblCost.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCost.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lblCost.setBackground(Color.BLACK);
		lblCost.setBounds(231, 180, 175, 57);
		frame.getContentPane().add(lblCost);
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblTotalCost.setBounds(25, 180, 194, 57);
		frame.getContentPane().add(lblTotalCost);
		
		JLabel lblHamburger = new JLabel("Hamburger");
		lblHamburger.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblHamburger.setBounds(25, 23, 194, 57);
		frame.getContentPane().add(lblHamburger);
		
		JLabel lblCheeseburger = new JLabel("Cheeseburger");
		lblCheeseburger.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCheeseburger.setBounds(25, 90, 194, 57);
		frame.getContentPane().add(lblCheeseburger);
		
		BURGER = new JTextField();
		BURGER.setBounds(231, 28, 175, 56);
		frame.getContentPane().add(BURGER);
		BURGER.setColumns(10);
		
		CH_BURGER = new JTextField();
		CH_BURGER.setColumns(10);
		CH_BURGER.setBounds(231, 95, 175, 56);
		frame.getContentPane().add(CH_BURGER);
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* ---------------------------------------------------
				 * Generate button logic & data flow explanation:
				 * ---------------------------------------------------
				 * Cache our input data from our double variable burger
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
				 * |B =BURGER  |  x   |  x   |  N/A   |
				 * |CH=CHBURGER|  x   |  x   |  N/A   |
				 * |(2B)*(2CH) |  Y   |  N   |  12.00 | 12.00
				 * |(0B)*(0B)  |  Y   |  N   |  00.00 | 00.00
				 * |(6B)*(10CB)|  Y   |  N   |  52.00 | 52.00
				 * |(AB)*(XCB) |  N   |  Y   | UNABLE TO COMPUTE, NEED
				 * |						 | TO MAKE INT ONLY NOT CHAR
				 * -----------------------------------------------------
				 */
				double HAMBURGER = Double.parseDouble(BURGER.getText());
				double HAMBURGER_PRICE = 2.00;
				double BURGER; 
			
				BURGER = (HAMBURGER * HAMBURGER_PRICE);
				String Hcost = String.format("%.2f", BURGER);
				lblCost.setText(Hcost );
				
				double CHBURGER = Double.parseDouble(CH_BURGER.getText());
				double CHEESEBURGER_PRICE = 4.00;
				double CH_BURGER;
				
				CH_BURGER = (CHBURGER * CHEESEBURGER_PRICE);
				String Ccost = String.format("%.2f", BURGER + CH_BURGER);  // user string format %.2f 
				lblCost.setText(Ccost );
				
				
			}
		});
		btnGenerate.setBounds(0, 249, 450, 29);
		frame.getContentPane().add(btnGenerate);
	}

}
