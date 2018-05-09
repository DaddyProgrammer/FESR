package db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.*;
import javax.swing.*;
import db.SQLiteTest;

import java.sql.*;

public class Login_S {

	private JFrame frmFiserPosSystems;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frmFiserPosSystems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
		connection = SQLiteTest.dbConnector();
		ResultSet rs = null;
		PreparedStatement pst = null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFiserPosSystems = new JFrame();
		frmFiserPosSystems.setTitle("Fesr POS Systems Login Window");
		frmFiserPosSystems.setResizable(false);
		frmFiserPosSystems.setBounds(200, 200, 440, 300);
		frmFiserPosSystems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFiserPosSystems.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("Please Enter Username Below:");
		lblUserName.setBounds(131, 104, 191, 16);
		frmFiserPosSystems.getContentPane().add(lblUserName);

		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(142, 132, 167, 33);
		frmFiserPosSystems.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "SELECT * FROM Employee WHERE Login=?";

					PreparedStatement pst = connection.prepareStatement(query);

					pst.setString(1, txtUsername.getText());

					ResultSet rs = pst.executeQuery();

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful!");
						frmFiserPosSystems.dispose();
						Pizza_UI Menu_Gui = new Pizza_UI();
						Menu_Gui.Pizza_UI();

					} else {
						String message = "Username Is Entered Incorrectly." + "\n" + "Please Try Again";
						    JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
						        JOptionPane.WARNING_MESSAGE);
					}
					rs.close();
					pst.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);

				}

			}
		});
		btnNewButton.setBounds(53, 177, 117, 29);
		frmFiserPosSystems.getContentPane().add(btnNewButton);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null); // <---clears login field
				
			}
		});
		btnReset.setBounds(175, 177, 117, 29);
		frmFiserPosSystems.getContentPane().add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFiserPosSystems = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmFiserPosSystems, "Confirm you want to exit", "Ristorante Alex POS Version 1.0",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(293, 177, 117, 29);
		frmFiserPosSystems.getContentPane().add(btnExit);

		JSeparator separator = new JSeparator();
		separator.setBounds(53, 75, 357, 16);
		frmFiserPosSystems.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(113, 256, 221, 16);
		frmFiserPosSystems.getContentPane().add(separator_1);

		JLabel lblFiserPosSystems = new JLabel("FESR POS SYSTEMS");
		lblFiserPosSystems.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		lblFiserPosSystems.setBounds(56, 17, 357, 46);
		frmFiserPosSystems.getContentPane().add(lblFiserPosSystems);

		JLabel lblCopyrightc = new JLabel("Copyright © 2018 - Version 2.0");
		lblCopyrightc.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCopyrightc.setBounds(109, 234, 228, 16);
		frmFiserPosSystems.getContentPane().add(lblCopyrightc);
	}
}
