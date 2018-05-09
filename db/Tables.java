/* Control Panel Database SQL Table GUI
 * Alex Reyes - COMP 296
 * April 18th 2018
 * Database Tutorial & Reference: 
 * https://helpstoprogramming.blogspot.com/p/database-connection-with-java.html
 * 
 * Dev notes: Need to add auto-refresh for admin tables.
 * Also, need to finish implmenting till table.
 * 
 * Known bugs:
 * Need to edit admin privledges under "edit" button for admin users
 * Need to fix customer edit and delete button
 * Display menu tiems
 */

package db;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tables {
	Connection connection = null;
	private JFrame frmFesrDatabaseVersion;
	private JTextField txtfName;
	private JTextField txtfUsername;
	private JTextField txtfLastName;
	private JTextField txtfPassword;
	private JTable table;
	private JTextField txtfEMPID;
	private JTable customer_table;
	private JTextField txtf_cname;
	private JTextField txtf_clname;
	private JTextField txtf_street;
	private JTextField txtf_city;
	private JTextField txtf_zip;
	private JTextField txtf_state;
	private JTextField txtf_cid;
	private JTable menu_table;
	private JTable till_table;
	private JTable EMP_table;
	private JTextField EMP_NAME;
	private JTextField EMP_UNAME;
	private JTextField EMP_LASTNAME;
	private JTextField EMP_ID;
	// Radio Button Fields
	private int Admin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable menu_table1;
	private JTable menu_table2;
	private JTable drinks_table;
	private JTable toppings_table;
	private JTable food_amt_table;
	private JTable food_till;
	private JTextField searchBar;
	private JTextField searchBarFood;
	private JTable total_amt_table;

	// ---- START CUSTOM TABLE REFRESH METHODS ---- //
	public void refreshCustomer() // refresh method for Customer Table
	{
		try {
			String query = "select * from Login";
			PreparedStatement pst = connection.prepareStatement(query); // pst
																		// =
																		// prepared
																		// statement
																		// variable
			ResultSet rs = pst.executeQuery(); // rs = result set
												// variable
			customer_table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// --- Space ;
	public void refreshAddressTable() // refresh method for Customer Table
	{
		try {
			String query = "select * from Customer";
			PreparedStatement pst = connection.prepareStatement(query); // pst
																		// =
																		// prepared
																		// statement
																		// variable
			ResultSet rs = pst.executeQuery(); // rs = result set
												// variable
			customer_table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}

	// --- Space ;
	public void refreshEmployeeTable() // refresh method for Customer Table
	{
		try {
			String query = "select * from Employee";
			PreparedStatement pst = connection.prepareStatement(query); // pst
																		// =
																		// prepared
																		// statement
																		// variable
			ResultSet rs = pst.executeQuery(); // rs = result set
												// variable
			EMP_table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}

	/**
	 * Launch the application.
	 */
	public static void Tables() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tables window = new Tables();
					window.frmFesrDatabaseVersion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tables() {
		initialize();
		connection = SQLiteTest.dbConnector();
	}

	// ---- END CUSTOM TABLE REFRESH METHODS ---- //

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFesrDatabaseVersion = new JFrame();
		frmFesrDatabaseVersion.setType(Type.UTILITY);
		frmFesrDatabaseVersion.setTitle("FESR Database Version 1.0");
		frmFesrDatabaseVersion.setResizable(false);
		frmFesrDatabaseVersion.setBounds(100, 100, 806, 486);
		frmFesrDatabaseVersion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFesrDatabaseVersion.getContentPane().setLayout(null);

		JLabel lblDatabaseTableQuery = new JLabel("Database Table Query - FESR Version 2.0");
		lblDatabaseTableQuery.setBounds(226, 6, 331, 27);
		lblDatabaseTableQuery.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		frmFesrDatabaseVersion.getContentPane().add(lblDatabaseTableQuery);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 36, 778, 422);
		frmFesrDatabaseVersion.getContentPane().add(tabbedPane);

		JPanel EmpTable = new JPanel();
		tabbedPane.addTab("Admin Users", null, EmpTable, null);
		EmpTable.setLayout(null);

		JLabel lblDatabaseTableQuery_1 = new JLabel("Admins Table Query - Add / Remove / Edit Content");
		lblDatabaseTableQuery_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblDatabaseTableQuery_1.setBounds(28, 6, 443, 27);
		EmpTable.add(lblDatabaseTableQuery_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(6, 145, 745, 181);
		EmpTable.add(panel);

		JLabel lblFirstName_1 = new JLabel("First Name:");
		lblFirstName_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblFirstName_1.setBounds(125, 6, 143, 27);
		panel.add(lblFirstName_1);

		JLabel label_3 = new JLabel("Last Name:");
		label_3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_3.setBounds(390, 6, 92, 27);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Username:");
		label_4.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_4.setBounds(586, 6, 92, 27);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_5.setBounds(586, 74, 92, 27);
		panel.add(label_5);

		txtfName = new JTextField();
		txtfName.setColumns(10);
		txtfName.setBounds(125, 34, 188, 35);
		panel.add(txtfName);

		txtfUsername = new JTextField();
		txtfUsername.setColumns(10);
		txtfUsername.setBounds(585, 34, 154, 35);
		panel.add(txtfUsername);

		txtfLastName = new JTextField();
		txtfLastName.setColumns(10);
		txtfLastName.setBounds(385, 34, 188, 35);
		panel.add(txtfLastName);

		txtfPassword = new JTextField();
		txtfPassword.setColumns(10);
		txtfPassword.setBounds(586, 113, 153, 35);
		panel.add(txtfPassword);

		JButton button = new JButton("Display Users");
		button.setBounds(6, 99, 116, 29);
		panel.add(button);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "insert into Login (PID,Name,Username,Password,Last_Name) values (?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, txtfEMPID.getText());
					pst.setString(2, txtfName.getText());
					pst.setString(3, txtfUsername.getText());
					pst.setString(4, txtfPassword.getText());
					pst.setString(5, txtfLastName.getText());

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}

				refreshCustomer();
			}
		});
		btnAddUser.setBounds(217, 99, 92, 29);
		panel.add(btnAddUser);

		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "delete from Login where PID='" + txtfEMPID.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Data Successfully Deleted!");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}

				refreshCustomer();
			}
		});
		btnRemoveUser.setBounds(416, 99, 109, 29);
		panel.add(btnRemoveUser);

		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "Update Login set PID='" + txtfEMPID.getText() + "' , Name='" + txtfName.getText()
							+ "' , Username='" + txtfUsername.getText() + "' , Password='" + txtfPassword.getText()
							+ "' , Last_Name='" + txtfLastName.getText() + "' where PID='" + txtfEMPID.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}

				refreshCustomer();
			}
		});
		btnEditUser.setBounds(303, 99, 109, 29);
		panel.add(btnEditUser);

		JLabel lblEmpId = new JLabel("PID:");
		lblEmpId.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEmpId.setBounds(6, 6, 79, 27);
		panel.add(lblEmpId);

		txtfEMPID = new JTextField();
		txtfEMPID.setColumns(10);
		txtfEMPID.setBounds(6, 34, 92, 35);
		panel.add(txtfEMPID);

		JButton btnResetFields = new JButton("Reset Fields");
		btnResetFields.setBounds(119, 99, 103, 29);
		panel.add(btnResetFields);
		btnResetFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtfEMPID.setText(null);
				txtfName.setText(null);
				txtfLastName.setText(null);
				txtfUsername.setText(null);
				txtfPassword.setText(null);
				// call DefaultTableModle libraries
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				// set model row count to 0; hence, reset.
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from Login";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 34, 745, 103);
		EmpTable.add(scrollPane);

		table = new JTable();
		table.setForeground(Color.GREEN);
		table.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Employees", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblEmployeesTableQuery = new JLabel("Employees Table Query - Add / Remove / Edit Content");
		lblEmployeesTableQuery.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEmployeesTableQuery.setBounds(173, 6, 443, 27);
		panel_1.add(lblEmployeesTableQuery);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(6, 34, 734, 124);
		panel_1.add(scrollPane_4);

		EMP_table = new JTable();
		EMP_table.setForeground(Color.GREEN);
		EMP_table.setBackground(Color.DARK_GRAY);
		scrollPane_4.setViewportView(EMP_table);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(6, 170, 734, 181);
		panel_1.add(panel_2);

		JLabel lblEMPName = new JLabel("First Name:");
		lblEMPName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEMPName.setBounds(125, 6, 133, 27);
		panel_2.add(lblEMPName);

		JLabel lblEMPLastName = new JLabel("Last Name:");
		lblEMPLastName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEMPLastName.setBounds(356, 6, 92, 27);
		panel_2.add(lblEMPLastName);

		JLabel lblEMPUsername = new JLabel("Username:");
		lblEMPUsername.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEMPUsername.setBounds(572, 6, 92, 27);
		panel_2.add(lblEMPUsername);

		JLabel lblEMPAdmin = new JLabel("Admin Privledges:");
		lblEMPAdmin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEMPAdmin.setBounds(52, 69, 148, 27);
		panel_2.add(lblEMPAdmin);

		EMP_NAME = new JTextField();
		EMP_NAME.setColumns(10);
		EMP_NAME.setBounds(125, 34, 204, 35);
		panel_2.add(EMP_NAME);

		EMP_UNAME = new JTextField();
		EMP_UNAME.setColumns(10);
		EMP_UNAME.setBounds(572, 34, 156, 35);
		panel_2.add(EMP_UNAME);

		EMP_LASTNAME = new JTextField();
		EMP_LASTNAME.setColumns(10);
		EMP_LASTNAME.setBounds(356, 34, 204, 35);
		panel_2.add(EMP_LASTNAME);

		JButton btnDisplayEmp = new JButton("Display Users");
		btnDisplayEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from Employee";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					EMP_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
			}
		});
		btnDisplayEmp.setBounds(212, 95, 116, 29);
		panel_2.add(btnDisplayEmp);

		JButton btnEmpAdd = new JButton("Add User");
		btnEmpAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into Employee (EMPID,First_Name,Last_Name,Admin,Login) values (?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, EMP_ID.getText());
					pst.setString(2, EMP_NAME.getText());
					pst.setString(3, EMP_LASTNAME.getText());
					pst.setString(4, Integer.toString(Admin));
					pst.setString(5, EMP_UNAME.getText());

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}

				refreshEmployeeTable();
			}
		});
		btnEmpAdd.setBounds(428, 95, 92, 29);
		panel_2.add(btnEmpAdd);

		JButton btnRemoveEmp = new JButton("Remove User");
		btnRemoveEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "delete from Employee where EMPID='" + EMP_ID.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Data Successfully Deleted!");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();
					String message = "Invalid EMPID!." + "\n" + "Please Try Again";
				    JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
				        JOptionPane.WARNING_MESSAGE);
				}

				refreshEmployeeTable();
			}
		});
		btnRemoveEmp.setBounds(619, 95, 109, 29);
		panel_2.add(btnRemoveEmp);

		JButton btnEditEmp = new JButton("Edit User");
		btnEditEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update Employee set EMPID='" + EMP_ID.getText() + "' , First_Name='"
							+ EMP_NAME.getText() + "' , Last_Name='" + EMP_LASTNAME.getText() + "' , Admin="
							+ Integer.toString(Admin) + " , Login='" + EMP_UNAME.getText() + "' where EMPID='"
							+ EMP_ID.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}

				refreshEmployeeTable();

			}
		});
		btnEditEmp.setBounds(518, 95, 103, 29);
		panel_2.add(btnEditEmp);

		JLabel lblEMPID = new JLabel("EMP ID:");
		lblEMPID.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEMPID.setBounds(6, 6, 79, 27);
		panel_2.add(lblEMPID);

		EMP_ID = new JTextField();
		EMP_ID.setColumns(10);
		EMP_ID.setBounds(6, 34, 92, 35);
		panel_2.add(EMP_ID);

		JRadioButton rdbtnTrue = new JRadioButton("TRUE = 1");
		buttonGroup.add(rdbtnTrue);
		rdbtnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Admin = 1;

			}

		});
		rdbtnTrue.setBounds(16, 96, 103, 23);
		panel_2.add(rdbtnTrue);

		JRadioButton rdbtnFalse = new JRadioButton("FALSE = 0");
		buttonGroup.add(rdbtnFalse);
		rdbtnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin = 0;
			}
		});
		rdbtnFalse.setBounds(112, 96, 103, 23);
		panel_2.add(rdbtnFalse);

		JButton button_3 = new JButton("Reset Fields");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EMP_NAME.setText(null);
				EMP_UNAME.setText(null);
				EMP_LASTNAME.setText(null);
				EMP_ID.setText(null);
				buttonGroup.clearSelection();
				// rdbtnFalse.setSelected(false);
				// rdbtnTrue.setSelected(false);
				// call DefaultTableModle libraries
				DefaultTableModel model = (DefaultTableModel) EMP_table.getModel();
				model.setRowCount(0);
				// set model row count to 0; hence, reset.
			}
		});
		button_3.setBounds(328, 95, 103, 29);
		panel_2.add(button_3);

		JPanel CustomerTable = new JPanel();
		tabbedPane.addTab("Customer", null, CustomerTable, null);
		CustomerTable.setLayout(null);

		JLabel lblCustomerTableQuery = new JLabel("Customer Table Query - Add / Remove / Edit Content");
		lblCustomerTableQuery.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblCustomerTableQuery.setBounds(17, 6, 443, 27);
		CustomerTable.add(lblCustomerTableQuery);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 34, 708, 114);
		CustomerTable.add(scrollPane_1);

		customer_table = new JTable();
		customer_table.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		customer_table.setForeground(Color.GREEN);
		customer_table.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(customer_table);

		txtf_cname = new JTextField();
		txtf_cname.setColumns(10);
		txtf_cname.setBounds(17, 188, 278, 35);
		CustomerTable.add(txtf_cname);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblFirstName.setBounds(17, 160, 108, 27);
		CustomerTable.add(lblFirstName);

		txtf_clname = new JTextField();
		txtf_clname.setColumns(10);
		txtf_clname.setBounds(17, 249, 278, 35);
		CustomerTable.add(txtf_clname);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblLastName.setBounds(17, 221, 108, 27);
		CustomerTable.add(lblLastName);

		JLabel lblStreetAddress = new JLabel("Street Address:");
		lblStreetAddress.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblStreetAddress.setBounds(17, 284, 138, 27);
		CustomerTable.add(lblStreetAddress);

		txtf_street = new JTextField();
		txtf_street.setColumns(10);
		txtf_street.setBounds(17, 312, 278, 35);
		CustomerTable.add(txtf_street);

		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblCity.setBounds(343, 160, 138, 27);
		CustomerTable.add(lblCity);

		txtf_city = new JTextField();
		txtf_city.setColumns(10);
		txtf_city.setBounds(343, 188, 138, 35);
		CustomerTable.add(txtf_city);

		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblZipCode.setBounds(343, 221, 138, 27);
		CustomerTable.add(lblZipCode);

		txtf_zip = new JTextField();
		txtf_zip.setColumns(10);
		txtf_zip.setBounds(343, 249, 138, 35);
		CustomerTable.add(txtf_zip);

		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblState.setBounds(343, 284, 48, 27);
		CustomerTable.add(lblState);

		txtf_state = new JTextField();
		txtf_state.setColumns(10);
		txtf_state.setBounds(343, 312, 48, 35);
		CustomerTable.add(txtf_state);

		JButton btnDisplay = new JButton("Display Customer");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from Customer";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					customer_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		btnDisplay.setBounds(569, 178, 146, 29);
		CustomerTable.add(btnDisplay);

		JButton button_1 = new JButton("Add Customer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "insert into Customer (First_Name,Last_Name,Address,City,State,Zip) values (?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, txtf_cname.getText());
					pst.setString(2, txtf_clname.getText());
					pst.setString(3, txtf_street.getText());
					pst.setString(4, txtf_city.getText());
					pst.setString(5, txtf_state.getText());
					pst.setString(6, txtf_zip.getText());

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				refreshAddressTable();

			}
		});
		button_1.setBounds(569, 219, 146, 29);
		CustomerTable.add(button_1);

		JButton btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "Update Customer set Customer_ID='" + txtf_cid.getText() + "', First_Name='"
							+ txtf_cname.getText() + "' , Last_Name='" + txtf_clname.getText() + "' , Address='"
							+ txtf_street.getText() + "' , City='" + txtf_city.getText() + "' , State='"
							+ txtf_state.getText() + "' where Customer_ID='" + txtf_cid.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				refreshAddressTable();
			}
		});
		btnEditCustomer.setBounds(569, 259, 146, 29);
		CustomerTable.add(btnEditCustomer);

		JButton button_2 = new JButton("Delete Customer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "delete from Customer where Customer_ID='" + txtf_cid.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Customer Information Successfully Deleted!");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {

					e1.printStackTrace();
					String message = "Invalid ID!" + "\n" + "Please Try Again";
				    JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
				        JOptionPane.WARNING_MESSAGE);
				}
				refreshAddressTable();

			}
		});
		button_2.setBounds(569, 300, 146, 29);
		CustomerTable.add(button_2);

		JButton btnResetFields_1 = new JButton("Reset Fields");
		btnResetFields_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtf_cname.setText(null);
				txtf_clname.setText(null);
				txtf_street.setText(null);
				txtf_city.setText(null);
				txtf_state.setText(null);
				txtf_zip.setText(null);
				txtf_cid.setText(null);
				// call DefaultTableModle libraries
				DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
				model.setRowCount(0);
				// set model row count to 0; hence, reset.

			}
		});
		btnResetFields_1.setBounds(569, 341, 146, 29);
		CustomerTable.add(btnResetFields_1);

		JLabel lbl_cid = new JLabel("ID:");
		lbl_cid.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cid.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_cid.setBounds(430, 284, 30, 27);
		CustomerTable.add(lbl_cid);

		txtf_cid = new JTextField();
		txtf_cid.setColumns(10);
		txtf_cid.setBounds(433, 312, 48, 35);
		CustomerTable.add(txtf_cid);

		JPanel MenuTables = new JPanel();
		tabbedPane.addTab("Menu Items", null, MenuTables, null);
		MenuTables.setLayout(null);

		JLabel lblMenuTableQuery = new JLabel("Menu Table Query - Menu Items / Drink Items / Topping Items");
		lblMenuTableQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuTableQuery.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMenuTableQuery.setBounds(146, 6, 465, 27);
		MenuTables.add(lblMenuTableQuery);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 35, 745, 59);
		MenuTables.add(scrollPane_2);

		menu_table = new JTable();
		menu_table.setBackground(Color.DARK_GRAY);
		menu_table.setForeground(Color.GREEN);
		scrollPane_2.setViewportView(menu_table);

		JButton btnDisplayMenuItem = new JButton("Display");
		btnDisplayMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// note to self, use * to select all from table, use select
				// "name","name" for multiple uses
				try {
					String query = "select food_id, sm_pizza, md_pizza, lg_pizza, xt_pizza, sm_cold_sub from Food";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					menu_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}

				// begin query menu table 2
				try {
					String query = "select food_id, lg_cold_sub, sm_hot_sub, lg_hot_sub, hamburger, cheeseburger from Food";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					menu_table1.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
				// begin query menu table 3
				try {
					String query = "select food_id, double_burger, double_chburger, french_fries, dessert, side_item from Food";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					menu_table2.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
				// begin query menu table amount
				try {
					String query = "select food_id, food_amount from Food";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					food_amt_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
				// drinks SQL query
				try {
					String query = "select * from Drink";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					drinks_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
				// toppings SQL query
				try {
					String query = "select * from Topping";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					toppings_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}
			}
		});
		btnDisplayMenuItem.setBounds(587, 288, 117, 29);
		MenuTables.add(btnDisplayMenuItem);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(6, 95, 745, 59);
		MenuTables.add(scrollPane_5);

		menu_table1 = new JTable();
		menu_table1.setBackground(Color.DARK_GRAY);
		menu_table1.setForeground(Color.GREEN);
		scrollPane_5.setViewportView(menu_table1);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(6, 155, 745, 59);
		MenuTables.add(scrollPane_6);

		menu_table2 = new JTable();
		menu_table2.setForeground(Color.GREEN);
		menu_table2.setBackground(Color.DARK_GRAY);
		scrollPane_6.setViewportView(menu_table2);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(353, 217, 398, 59);
		MenuTables.add(scrollPane_7);

		drinks_table = new JTable();
		scrollPane_7.setViewportView(drinks_table);
		drinks_table.setForeground(Color.GREEN);
		drinks_table.setBackground(Color.DARK_GRAY);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(6, 288, 346, 82);
		MenuTables.add(scrollPane_8);

		toppings_table = new JTable();
		toppings_table.setForeground(Color.GREEN);
		toppings_table.setBackground(Color.DARK_GRAY);
		scrollPane_8.setViewportView(toppings_table);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(6, 217, 346, 59);
		MenuTables.add(scrollPane_9);

		food_amt_table = new JTable();
		food_amt_table.setForeground(Color.GREEN);
		food_amt_table.setBackground(Color.DARK_GRAY);
		scrollPane_9.setViewportView(food_amt_table);

		JLabel lblInstructions = new JLabel("Click \"Display\" to generate");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblInstructions.setBounds(353, 305, 179, 16);
		MenuTables.add(lblInstructions);

		JLabel lblInstructions2 = new JLabel("table reports for each menu items.");
		lblInstructions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblInstructions2.setBounds(377, 323, 169, 16);
		MenuTables.add(lblInstructions2);

		JLabel lblmain_instructions = new JLabel("INSTRUCTIONS:");
		lblmain_instructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblmain_instructions.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		lblmain_instructions.setBounds(353, 288, 163, 16);
		MenuTables.add(lblmain_instructions);

		JPanel TillsTable = new JPanel();
		tabbedPane.addTab("Till Items", null, TillsTable, null);
		TillsTable.setLayout(null);

		JLabel lblTillQuery = new JLabel("Till Query - View & Delete Tills");
		lblTillQuery.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblTillQuery.setBounds(239, 6, 274, 27);
		TillsTable.add(lblTillQuery);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(6, 32, 745, 118);
		TillsTable.add(scrollPane_3);

		till_table = new JTable();
		till_table.setForeground(Color.GREEN);
		till_table.setBackground(Color.DARK_GRAY);
		scrollPane_3.setViewportView(till_table);

		JButton btnDisplay_1 = new JButton("Display");
		btnDisplay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// example of join
				// select * from Orders join customer on
				// Orders.Customer_ID=customer.Customer_ID
				try {
					String query = "select * from Orders join customer on Orders.Customer_ID=customer.Customer_ID";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					till_table.setModel(DbUtils.resultSetToTableModel(rs));
					// till_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					till_table.getColumnModel().getColumn(1).setWidth(100);

				} catch (Exception e2) {
					e2.printStackTrace();

				}
				// orders join food table
				try {
					String query = "SELECT * FROM Orders JOIN Food ON Orders.order_id = Food.order_id JOIN Drink ON Orders.order_id = Drink.order_id AND Food.food_id = Drink.food_item JOIN Topping ON  Topping.order_id = Orders.order_id AND Topping.food_ID = Food.food_id";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					food_till.setModel(DbUtils.resultSetToTableModel(rs));

					food_till.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					food_till.getColumnModel().getColumn(1).setWidth(1000); // set
																			// width
																			// 1000
																			// so
																			// it
																			// will
																			// display
																			// values
																			// correctlly
																			// and
																			// fully.

				} catch (Exception e2) {
					e2.printStackTrace();

				}

				try {
					String query = "SELECT order_id, ROUND(amount + amount*" + Pizza_UI.tax
							+ ", 2) as 'Final Amount' FROM Orders";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					ResultSet rs = pst.executeQuery(); // rs = result set
														// variable
					total_amt_table.setModel(DbUtils.resultSetToTableModel(rs));
					// total_amt_table.getColumnModel().getColumn(1).setWidth(1000);

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		btnDisplay_1.setBounds(530, 302, 91, 60);
		TillsTable.add(btnDisplay_1);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(6, 156, 745, 118);
		TillsTable.add(scrollPane_10);

		food_till = new JTable();
		food_till.setForeground(Color.GREEN);
		food_till.setBackground(Color.DARK_GRAY);
		scrollPane_10.setViewportView(food_till);

		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String query = "select * from Orders join customer on Orders.Customer_ID=customer.Customer_ID where First_Name=?";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, searchBar.getText());
					ResultSet rs = pst.executeQuery();

					till_table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		searchBar.setBounds(6, 312, 108, 39);
		TillsTable.add(searchBar);
		searchBar.setColumns(10);

		JButton voidTill = new JButton("Void Till");
		voidTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				String query0 = "SELECT ROUND(amount+amount*" + Pizza_UI.tax + " , 2) AS \"Final Amount\"  FROM Orders WHERE order_id=" + searchBarFood.getText();
				String query1 = "DELETE FROM Topping WHERE order_id= " + searchBarFood.getText(); // toppings
				String query2 = "DELETE FROM Drink WHERE order_id= " + searchBarFood.getText();  // drinks
				String query3 = "DELETE FROM Food WHERE order_id= " + searchBarFood.getText() ;	    // food
				String query4 = "DELETE FROM Orders WHERE order_id= " + searchBarFood.getText();      // order
				
				PreparedStatement pst0 = connection.prepareStatement(query0); // pst
				PreparedStatement pst1 = connection.prepareStatement(query1); // pst
				PreparedStatement pst2 = connection.prepareStatement(query2); // pst
				PreparedStatement pst3 = connection.prepareStatement(query3); // pst
				PreparedStatement pst4 = connection.prepareStatement(query4); // pst
				
				ResultSet rs = pst0.executeQuery();
				String temp = rs.getString("Final Amount");
				pst1.execute();
				pst2.execute();
				pst3.execute();
				pst4.execute();
				JOptionPane.showMessageDialog(null, "Till Voided Successfully!" + "\n" + "Amount Refunded: " + temp);
				
			} 
				
				catch (Exception e2) {
				e2.printStackTrace();
				String message = "Invalid Order ID!" + "\n" + "Please Try Again";
			    JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
			        JOptionPane.WARNING_MESSAGE);
				

			}
		}
		});
		voidTill.setBounds(633, 302, 96, 60);
		TillsTable.add(voidTill);

		searchBarFood = new JTextField();
		searchBarFood.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        e.consume();
			      }
			    }
			public void keyReleased(KeyEvent e) {

				try {
					String query = "SELECT * FROM Orders JOIN Food ON Orders.order_id = Food.order_id JOIN Drink ON Orders.order_id = Drink.order_id AND Food.food_id = Drink.food_item JOIN Topping ON Topping.order_id = Orders.order_id AND Topping.food_ID = Food.food_id where Orders.order_id=?";

					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, searchBarFood.getText());
					ResultSet rs = pst.executeQuery();

					food_till.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					e2.printStackTrace();

				}

			}
		});
		searchBarFood.setColumns(10);
		searchBarFood.setBounds(170, 312, 65, 39);
		TillsTable.add(searchBarFood);

		JLabel CustName = new JLabel("Customer Name:");
		CustName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		CustName.setBounds(6, 286, 133, 27);
		TillsTable.add(CustName);

		JLabel FoodLabel = new JLabel("Order ID:");
		FoodLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		FoodLabel.setBounds(170, 286, 133, 27);
		TillsTable.add(FoodLabel);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(257, 301, 256, 69);
		TillsTable.add(scrollPane_11);

		total_amt_table = new JTable();
		total_amt_table.setBackground(Color.DARK_GRAY);
		total_amt_table.setForeground(Color.GREEN);
		scrollPane_11.setViewportView(total_amt_table);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(686, 7, 103, 29);
		frmFesrDatabaseVersion.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFesrDatabaseVersion.dispose();
			}
		});
	}
}
