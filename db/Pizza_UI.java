/*
 * Pizza POS Menu & Database
 * Alex Reyes - COMP 296
 * Captsone Project
 * Version 2.0
 * Updated: 5/10/18
 * Status: Completed
 */
package db;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
// --- import all swing and awt classes
// --- just incase something is missing
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Pizza_UI {

	private JFrame frmFiserPosSystems;
	private JTextField Jtxt_sideItem;
	private JTextField Jtxt_drink_qty;
	private JTextField Jtxt_toppings_qty;

	// BEGIN CONSTANTS FOR MENU ITEM PRICES
	final double PRICE_Small_Pizza = 11.00;
	final double PRICE_Medium_Pizza = 15.00;
	final double PRICE_Large_Pizza = 18.00;
	final double PRICE_XT_Large_Pizza = 20.00;
	final double PRICE_Small_Cold_Sub = 8.00;
	final double PRICE_Large_Cold_Sub = 10.00;
	final double PRICE_Small_Hot_Sub = 8.50;
	final double PRICE_Large_Hot_Sub = 11.00;
	final double PRICE_Hamburger = 5.00;
	final double PRICE_Cheeseburger = 6.00;
	final double PRICE_Double_Hamburger = 7.00;
	final double PRICE_Double_Cheeseburger = 8.00;
	final double PRICE_French_Fries = 2.50;
	final double PRICE_Dessert = 3.00;
	final double PRICE_Side_Item = 1.00;
	// PRICE CONSTANTS
	final double PRICE_Coke = 1.50;
	final double PRICE_Diet_Coke = 1.50;
	final double PRICE_Sprite = 1.50;
	final double PRICE_Diet_Sprite = 1.50;
	final double PRICE_Milk_Shake = 3.00;
	final double PRICE_Coffee = 1.00;
	final double PRICE_Tea = 1.00;
	final double PRICE_Water = 1.50;
	final double PRICE_Ice = 0.50;
	// TOPPING CONSTANTS
	final double PRICE_One_Topping = 1.00;
	final double PRICE_Two_Topping = 2.00;
	final double PRICE_Three_Topping = 3.00;
	// DELIVERY PRICE CONSTANTS
	final double PRICE_Delivery = 1.50;
	// TAX AMOUNT CONSTANTS
	// FINAL STATIC DOUBLE TO ENSURE WE CAN USE IN OUR TABLES GUI
	final static double tax = 0.07; // customize tax amount, per state taxes.
									// static mode to carry over into another
									// class

	// Receipt Viewer Strings

	// Menu Item Strings
	String Spcost; // Small Pizza Cost
	String Mpcost; // Medium Pizza Cost
	String Lpcost; // Large Pizza Cost
	String Xtpcost; // Extra Large Pizza Cost
	String Sscost; // Small Sub Cost
	String Lscost; // Large Cub Cost
	String Shscost; // Small Hot Sub Cost
	String Lhscost; // Large Hot Sub Cost
	String Hcost; // Hamburger Cost
	String Ccost; // Cheeseburger Cost
	String DHcost; // Double Hamburger Cost
	String DCcost; // Double Cheeseburger Cost
	String Dcost; // Dessert Cost
	String Scost; // Side Cost
	String fFcost; // French Fry Cost
	String totalcosts; // Sum of all total costs.
	// JTextField Var Names Declared Below
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField Jtxt_dessert;
	private JTextField Jtxt_fFry;
	private JTextField Jtxt_dbchburger;
	private JTextField Jtxt_dbburger;
	private JTextField Jtxt_chburger;
	private JTextField Jtxt_burger;
	private JTextField Jtxt_sSub;
	private JTextField Jtxt_lSub;
	private JTextField Jtxt_sHSub;
	private JTextField Jtxt_lHsub;
	private JTextField Jtxt_sPizza;
	private JTextField Jtxt_mPizza;
	private JTextField Jtxt_lPizza;
	private JTextField Jtxt_xtPizza;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField street_name;
	private JTextField city_name;
	private JTextField state_name;
	private JTextField zip_code;

	/**
	 * Launch the application.
	 */
	public static void Pizza_UI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza_UI window = new Pizza_UI();
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
	public Pizza_UI() {
		initialize(); // let the magic begin!
		connection = SQLiteTest.dbConnector();
		ResultSet rs = null;
		PreparedStatement pst = null;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFiserPosSystems = new JFrame();
		frmFiserPosSystems.setTitle("FESR POS SYSTEMS");
		frmFiserPosSystems.setResizable(false);
		frmFiserPosSystems.getContentPane().setBackground(new Color(165, 42, 42));
		frmFiserPosSystems.setBounds(100, 100, 503, 562);
		frmFiserPosSystems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFiserPosSystems.getContentPane().setLayout(null);
		// --- CREATE TITLE --- //
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(19, 25, 458, 12);
		frmFiserPosSystems.getContentPane().add(separator);

		JLabel lblRistoranteAlexPos = new JLabel("RISTORANTE ALEX ORDER MENU");
		lblRistoranteAlexPos.setBounds(110, 0, 291, 31);
		frmFiserPosSystems.getContentPane().add(lblRistoranteAlexPos);
		lblRistoranteAlexPos.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblRistoranteAlexPos.setForeground(new Color(255, 255, 255));

		// ------CREATE PANELS-----//
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(6, 5, 3, 3, (Color) new Color(255, 165, 0)));
		panel.setBounds(19, 49, 223, 280);
		frmFiserPosSystems.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSmallPizza = new JLabel("Small Pizza............11.00");
		lblSmallPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSmallPizza.setBounds(6, 16, 126, 16);
		panel.add(lblSmallPizza);

		JLabel lblMediumPizza = new JLabel("Medium Pizza........15.00");
		lblMediumPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMediumPizza.setBounds(6, 31, 131, 16);
		panel.add(lblMediumPizza);

		JLabel lblLargePizza = new JLabel("Large Pizza............18.00");
		lblLargePizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLargePizza.setBounds(6, 44, 125, 16);
		panel.add(lblLargePizza);

		JLabel lblXtLargePizza = new JLabel("XT Large Pizza.......20.00");
		lblXtLargePizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblXtLargePizza.setBounds(6, 59, 127, 16);
		panel.add(lblXtLargePizza);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(6, 72, 131, 12);
		panel.add(separator_1);

		JLabel lblSmColdSub = new JLabel("Sm Cold Sub............8.00");
		lblSmColdSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSmColdSub.setBounds(6, 82, 125, 16);
		panel.add(lblSmColdSub);

		JLabel lblLgColdSub = new JLabel("Lg Cold Sub............11.00");
		lblLgColdSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLgColdSub.setBounds(6, 96, 126, 16);
		panel.add(lblLgColdSub);

		JLabel lblLgHotSub = new JLabel("Lg Hot Sub..............11.00");
		lblLgHotSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLgHotSub.setBounds(6, 124, 128, 16);
		panel.add(lblLgHotSub);

		JLabel lblSmHotSub = new JLabel("Sm Hot Sub.............8.50");
		lblSmHotSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSmHotSub.setBounds(6, 110, 125, 16);
		panel.add(lblSmHotSub);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(6, 138, 131, 17);
		panel.add(separator_2);

		JLabel lblHamburger = new JLabel("Hamburger.............5.00");
		lblHamburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblHamburger.setBounds(6, 152, 129, 16);
		panel.add(lblHamburger);

		JLabel lblCheeseburger = new JLabel("Cheeseburger.........6.00");
		lblCheeseburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCheeseburger.setBounds(6, 167, 131, 16);
		panel.add(lblCheeseburger);

		JLabel lblDoubleChBurger = new JLabel("Dble Cheeseburger.8.00");
		lblDoubleChBurger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDoubleChBurger.setBounds(6, 195, 126, 16);
		panel.add(lblDoubleChBurger);

		JLabel lblDoubleCheeseburger = new JLabel("Double Burger.........7.00");
		lblDoubleCheeseburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDoubleCheeseburger.setBounds(6, 180, 126, 16);
		panel.add(lblDoubleCheeseburger);

		JLabel lblFrenchFries = new JLabel("French Fries.............2.50");
		lblFrenchFries.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblFrenchFries.setBounds(6, 210, 126, 16);
		panel.add(lblFrenchFries);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(6, 223, 211, 12);
		panel.add(separator_3);

		JLabel lblDessert = new JLabel("Dessert....................3.00");
		lblDessert.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDessert.setBounds(6, 238, 131, 16);
		panel.add(lblDessert);

		JLabel lblSideItem = new JLabel("Side Item..................1.00");
		lblSideItem.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSideItem.setBounds(6, 257, 123, 16);
		panel.add(lblSideItem);
		// --------Java FX INPUT panels -------///
		/*
		 * Method created below: KeyAdapter to call a KeyEvent to only allow
		 * integers in each text field. This method below will accomplish this
		 * for us: ---Begin code---// text_field_name.addKeyListener(new
		 * KeyAdapter() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) { char c = e.getKeyChar();
		 * if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c
		 * == KeyEvent.VK_DELETE))) { e.consume(); } } }); ----End Code---//
		 */
		Jtxt_sideItem = new JTextField();
		Jtxt_sideItem.setBackground(new Color(0, 0, 0));
		Jtxt_sideItem.setForeground(new Color(255, 255, 255));
		Jtxt_sideItem.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_sideItem.setColumns(10);
		Jtxt_sideItem.setBounds(137, 256, 80, 18);
		Jtxt_sideItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});

		panel.add(Jtxt_sideItem);

		Jtxt_dessert = new JTextField();
		Jtxt_dessert.setForeground(Color.WHITE);
		Jtxt_dessert.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_dessert.setColumns(10);
		Jtxt_dessert.setBackground(Color.BLACK);
		Jtxt_dessert.setBounds(137, 232, 80, 18);
		Jtxt_dessert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_dessert);

		Jtxt_fFry = new JTextField();
		Jtxt_fFry.setForeground(Color.WHITE);
		Jtxt_fFry.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_fFry.setColumns(10);
		Jtxt_fFry.setBackground(Color.BLACK);
		Jtxt_fFry.setBounds(137, 208, 80, 18);
		Jtxt_fFry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_fFry);

		Jtxt_dbchburger = new JTextField();
		Jtxt_dbchburger.setForeground(Color.WHITE);
		Jtxt_dbchburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_dbchburger.setColumns(10);
		Jtxt_dbchburger.setBackground(Color.BLACK);
		Jtxt_dbchburger.setBounds(137, 194, 80, 18);
		Jtxt_dbchburger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_dbchburger);

		Jtxt_dbburger = new JTextField();
		Jtxt_dbburger.setForeground(Color.WHITE);
		Jtxt_dbburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_dbburger.setColumns(10);
		Jtxt_dbburger.setBackground(Color.BLACK);
		Jtxt_dbburger.setBounds(137, 179, 80, 18);
		Jtxt_dbburger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_dbburger);

		Jtxt_chburger = new JTextField();
		Jtxt_chburger.setForeground(Color.WHITE);
		Jtxt_chburger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_chburger.setColumns(10);
		Jtxt_chburger.setBackground(Color.BLACK);
		Jtxt_chburger.setBounds(137, 162, 80, 18);
		Jtxt_chburger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_chburger);

		Jtxt_burger = new JTextField();
		Jtxt_burger.setForeground(Color.WHITE);
		Jtxt_burger.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_burger.setColumns(10);
		Jtxt_burger.setBackground(Color.BLACK);
		Jtxt_burger.setBounds(137, 146, 80, 18);
		Jtxt_burger.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_burger);

		Jtxt_sSub = new JTextField();
		Jtxt_sSub.setForeground(Color.WHITE);
		Jtxt_sSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_sSub.setColumns(10);
		Jtxt_sSub.setBackground(Color.BLACK);
		Jtxt_sSub.setBounds(137, 72, 80, 26);
		Jtxt_sSub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_sSub);

		Jtxt_lSub = new JTextField();
		Jtxt_lSub.setForeground(Color.WHITE);
		Jtxt_lSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_lSub.setColumns(10);
		Jtxt_lSub.setBackground(Color.BLACK);
		Jtxt_lSub.setBounds(137, 96, 80, 16);
		Jtxt_lSub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_lSub);

		Jtxt_sHSub = new JTextField();
		Jtxt_sHSub.setForeground(Color.WHITE);
		Jtxt_sHSub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_sHSub.setColumns(10);
		Jtxt_sHSub.setBackground(Color.BLACK);
		Jtxt_sHSub.setBounds(137, 112, 80, 16);
		Jtxt_sHSub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_sHSub);

		Jtxt_lHsub = new JTextField();
		Jtxt_lHsub.setForeground(Color.WHITE);
		Jtxt_lHsub.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_lHsub.setColumns(10);
		Jtxt_lHsub.setBackground(Color.BLACK);
		Jtxt_lHsub.setBounds(137, 128, 80, 18);
		Jtxt_lHsub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_lHsub);

		Jtxt_sPizza = new JTextField();

		Jtxt_sPizza.setForeground(Color.WHITE);
		Jtxt_sPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_sPizza.setColumns(10);
		Jtxt_sPizza.setBackground(Color.BLACK);
		Jtxt_sPizza.setBounds(137, 9, 80, 18);
		Jtxt_sPizza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_sPizza);

		Jtxt_mPizza = new JTextField();
		Jtxt_mPizza.setForeground(Color.WHITE);
		Jtxt_mPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_mPizza.setColumns(10);
		Jtxt_mPizza.setBackground(Color.BLACK);
		Jtxt_mPizza.setBounds(137, 25, 80, 18);
		Jtxt_mPizza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_mPizza);

		Jtxt_lPizza = new JTextField();
		Jtxt_lPizza.setForeground(Color.WHITE);
		Jtxt_lPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_lPizza.setColumns(10);
		Jtxt_lPizza.setBackground(Color.BLACK);
		Jtxt_lPizza.setBounds(137, 42, 80, 18);
		Jtxt_lPizza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_lPizza);

		Jtxt_xtPizza = new JTextField();
		Jtxt_xtPizza.setForeground(Color.WHITE);
		Jtxt_xtPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_xtPizza.setColumns(10);
		Jtxt_xtPizza.setBackground(Color.BLACK);
		Jtxt_xtPizza.setBounds(137, 57, 80, 18);
		Jtxt_xtPizza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel.add(Jtxt_xtPizza);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(6, 5, 3, 3, (Color) new Color(255, 165, 0)));
		panel_1.setBounds(19, 333, 458, 177);
		frmFiserPosSystems.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 446, 165);
		panel_1.add(tabbedPane);

		/// ---- end start over button

		// --- ADD TABS BELOW --- //
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Delivery", null, panel_7, null);
		panel_7.setLayout(null);

		first_name = new JTextField();
		first_name.setForeground(Color.WHITE);
		first_name.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		first_name.setColumns(10);
		first_name.setBackground(Color.BLACK);
		first_name.setBounds(80, 5, 100, 23);
		panel_7.add(first_name);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblFirstName.setBounds(6, 8, 68, 16);
		panel_7.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLastName.setBounds(6, 30, 68, 16);
		panel_7.add(lblLastName);

		last_name = new JTextField();
		last_name.setForeground(Color.WHITE);
		last_name.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		last_name.setColumns(10);
		last_name.setBackground(Color.BLACK);
		last_name.setBounds(80, 27, 100, 23);
		panel_7.add(last_name);

		JLabel lblStreetAddress = new JLabel("Street");
		lblStreetAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblStreetAddress.setBounds(183, 8, 79, 16);
		panel_7.add(lblStreetAddress);

		street_name = new JTextField();
		street_name.setForeground(Color.WHITE);
		street_name.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		street_name.setColumns(10);
		street_name.setBackground(Color.BLACK);
		street_name.setBounds(247, 5, 133, 23);
		panel_7.add(street_name);

		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCity.setBounds(183, 29, 79, 16);
		panel_7.add(lblCity);

		city_name = new JTextField();
		city_name.setForeground(Color.WHITE);
		city_name.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		city_name.setColumns(10);
		city_name.setBackground(Color.BLACK);
		city_name.setBounds(247, 27, 133, 23);
		panel_7.add(city_name);

		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblState.setBounds(183, 51, 79, 16);
		panel_7.add(lblState);

		state_name = new JTextField();
		state_name.setForeground(Color.WHITE);
		state_name.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		state_name.setColumns(10);
		state_name.setBackground(Color.BLACK);
		state_name.setBounds(247, 49, 43, 23);
		panel_7.add(state_name);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		lblZip.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblZip.setBounds(199, 73, 36, 16);
		panel_7.add(lblZip);

		zip_code = new JTextField();
		zip_code.setForeground(Color.WHITE);
		zip_code.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		zip_code.setColumns(10);
		zip_code.setBackground(Color.BLACK);
		zip_code.setBounds(247, 70, 43, 23);
		zip_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel_7.add(zip_code);
		// blank label
		JLabel lblverify = new JLabel("");
		lblverify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblverify.setForeground(Color.RED);
		lblverify.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblverify.setBounds(145, 101, 158, 16);
		panel_7.add(lblverify);
		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(192, 5, 12, 89);
		panel_7.add(separator_8);

		// --till tab
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Till", null, panel_3, null);
		panel_3.setLayout(null);
		// ----- begin Java FX JLabels -----//
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(6, 5, 3, 3, (Color) new Color(255, 165, 0)));
		panel_2.setBounds(254, 49, 223, 280);
		frmFiserPosSystems.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTotalCostDrinks = new JLabel("Total Cost Drinks:");
		lblTotalCostDrinks.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTotalCostDrinks.setBounds(6, 139, 99, 16);
		panel_2.add(lblTotalCostDrinks);

		JLabel lblTotalCostMeal = new JLabel("Total Cost Meal:");
		lblTotalCostMeal.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTotalCostMeal.setBounds(6, 159, 99, 16);
		panel_2.add(lblTotalCostMeal);

		JLabel lblDrinkC = new JLabel("");
		lblDrinkC.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lblDrinkC.setBounds(98, 138, 108, 16);
		lblDrinkC.setBackground(new Color(0, 0, 0));
		lblDrinkC.setForeground(Color.DARK_GRAY);
		lblDrinkC.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel_2.add(lblDrinkC);

		JLabel lblCostM = new JLabel("");
		lblCostM.setForeground(Color.DARK_GRAY);
		lblCostM.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCostM.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lblCostM.setBackground(Color.BLACK);
		lblCostM.setBounds(98, 158, 108, 16);
		panel_2.add(lblCostM);

		JLabel lblCostD = new JLabel("");
		lblCostD.setForeground(Color.DARK_GRAY);
		lblCostD.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCostD.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lblCostD.setBackground(Color.BLACK);
		lblCostD.setBounds(98, 183, 108, 16);
		panel_2.add(lblCostD);

		JLabel lblTotalToppingsCost = new JLabel("Total Topping Cst:");
		lblTotalToppingsCost.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTotalToppingsCost.setBounds(6, 117, 99, 16);
		panel_2.add(lblTotalToppingsCost);

		JLabel lblToppingC = new JLabel("");
		lblToppingC.setForeground(Color.DARK_GRAY);
		lblToppingC.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblToppingC.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lblToppingC.setBackground(Color.BLACK);
		lblToppingC.setBounds(98, 116, 108, 16);
		panel_2.add(lblToppingC);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(6, 198, 211, 12);
		panel_2.add(separator_4);

		JLabel lblFinalCost = new JLabel("Final Cost:");
		lblFinalCost.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblFinalCost.setBounds(6, 251, 99, 16);
		panel_2.add(lblFinalCost);

		JLabel lbl_finalcst = new JLabel("");
		lbl_finalcst.setForeground(Color.DARK_GRAY);
		lbl_finalcst.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lbl_finalcst.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lbl_finalcst.setBackground(Color.BLACK);
		lbl_finalcst.setBounds(98, 250, 108, 16);
		panel_2.add(lbl_finalcst);

		JLabel lbl_subt = new JLabel("");
		lbl_subt.setForeground(Color.DARK_GRAY);
		lbl_subt.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lbl_subt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lbl_subt.setBackground(Color.BLACK);
		lbl_subt.setBounds(98, 230, 108, 16);
		panel_2.add(lbl_subt);

		JLabel lblDeliveryAmt = new JLabel("Delivery Amt:");
		lblDeliveryAmt.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDeliveryAmt.setBounds(6, 183, 76, 16);
		panel_2.add(lblDeliveryAmt);
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSubTotal.setBounds(6, 231, 99, 16);
		panel_2.add(lblSubTotal);

		JLabel lblTax = new JLabel("Tax:");
		lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTax.setBounds(6, 211, 99, 16);
		panel_2.add(lblTax);

		JLabel lbl_tax = new JLabel("");
		lbl_tax.setForeground(Color.DARK_GRAY);
		lbl_tax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lbl_tax.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 165, 0)));
		lbl_tax.setBackground(Color.BLACK);
		lbl_tax.setBounds(98, 210, 108, 16);
		panel_2.add(lbl_tax);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(6, 98, 134, 12);
		panel_2.add(separator_5);
		// ---- Text_Area_Box ----//
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 11, 190, 102);
		panel_3.add(scrollPane);

		JTextArea Text_Area = new JTextArea();
		scrollPane.setViewportView(Text_Area);
		Text_Area.setFont(new Font("Courier", Font.PLAIN, 10));
		Text_Area.setEditable(false);
		// ---- check box object ---//
		JCheckBox chckbxDelivery = new JCheckBox("Delivery");
		chckbxDelivery.setBounds(122, 4, 89, 23);
		panel_3.add(chckbxDelivery);

		// ------------JCOMBO BOXES BELOW--------------//
		JComboBox JComboBox_Topping = new JComboBox();
		JComboBox_Topping.setMaximumRowCount(13);
		JComboBox_Topping.setModel(new DefaultComboBoxModel(
				new String[] { "Select Topping", "One Topping", "Two Toppings", "Three Toppings" }));
		JComboBox_Topping.setBounds(6, 52, 144, 53);
		panel_2.add(JComboBox_Topping);
		// --- combo box 2 --- //
		JComboBox JComboBox_Drink = new JComboBox();
		JComboBox_Drink.setModel(new DefaultComboBoxModel(new String[] { "Select Drink", "Coke", "Diet Coke", "Sprite",
				"Diet Sprite", "Milk Shake", "Coffee", "Tea", "Water", "Ice" }));
		JComboBox_Drink.setMaximumRowCount(10);
		JComboBox_Drink.setBounds(6, 29, 144, 27);
		panel_2.add(JComboBox_Drink);
		// ---- declare button - needs to initialize afterwards --//
		// --- Note to Self: comboBox.setSelectedIndex(int 0); had to be placed
		// to reset variables in combo boxes --//

		JButton btnTotalAmount = new JButton("Total Amount");
		btnTotalAmount.setEnabled(false);
		btnTotalAmount.addActionListener(new ActionListener() {
			// Append Text_Area first, this will draw our our till in the end
			public void actionPerformed(ActionEvent e) {
				// btnTotalAmount.setEnabled(false);
				Text_Area.append("Ristorante Alessandro's" + "\n" + "#1 Italian Risortante" + "\n"
						+ "---------------------------" + "\n" + "Contact Information:" + "\n" + "732-555-1234" + "\n"
						+ "123 ABC Drive" + "\n" + "Brookdale, NJ 07777" + "\n" + "---------------------------" + "\n"
						+ "Manager: Alex" + "\n" + "\n" + "--------ORDER HISTORY------" + "\n");

				/*
				 * --------------------------------------------------- Generate
				 * button logic & data flow explanation:
				 * --------------------------------------------------- Cache our
				 * input data from our double variable burger Set the price of x
				 * dollar value to the selected item Once decimal amount is
				 * inputed by end user, our cached data is stored. Cached data
				 * is stored with next items that are calculated. We use the
				 * same method as earlier stated.
				 *
				 * We add the cached data (variable name) to any other items
				 * that are present in this case. Cycle will loop each time the
				 * button is clicked, triggering the action to preform the
				 * methods below.
				 */
				// needs to throw exception if nothing is entered.
				// ---- SMALL PIZZA CALCULATION ---- //
				double sm_pizza_total;

				if (Jtxt_sPizza.getText().isEmpty()) {
					sm_pizza_total = 0;
				} else {
					sm_pizza_total = Double.parseDouble(Jtxt_sPizza.getText()) * PRICE_Small_Pizza;
					Text_Area.append("Sm. Pizza(s): " + Jtxt_sPizza.getText() + ".....$"
							+ String.format("%.2f", PRICE_Small_Pizza) + "\n");
				}
				Spcost = String.format("%.2f", sm_pizza_total); // user
																// string
																// format
																// %.2f

				// ---- MEDIUM PIZZA CALCULATION ---- //
				double md_pizza_total;

				if (Jtxt_mPizza.getText().isEmpty()) {
					md_pizza_total = 0;
				} else {
					md_pizza_total = Double.parseDouble(Jtxt_mPizza.getText()) * PRICE_Medium_Pizza;
					Text_Area.append("Md. Pizza(s): " + Jtxt_mPizza.getText() + ".....$"
							+ String.format("%.2f", PRICE_Medium_Pizza) + "\n");
				}
				Mpcost = String.format("%.2f", md_pizza_total);

				// ---- LARGE PIZZA CALCULATION ---- //

				double lg_pizza_total;

				if (Jtxt_lPizza.getText().isEmpty()) {
					lg_pizza_total = 0;
				} else {
					lg_pizza_total = Double.parseDouble(Jtxt_lPizza.getText()) * PRICE_Large_Pizza;
					Text_Area.append("Lg. Pizza(s): " + Jtxt_lPizza.getText() + ".....$"
							+ String.format("%.2f", PRICE_Large_Pizza) + "\n");
				}
				Lpcost = String.format("%.2f", lg_pizza_total);

				// ---- XT LARGE PIZZA CALCULATION ---- //

				double xt_pizza_total;

				if (Jtxt_xtPizza.getText().isEmpty()) {
					xt_pizza_total = 0;
				} else {
					xt_pizza_total = Double.parseDouble(Jtxt_xtPizza.getText()) * PRICE_XT_Large_Pizza;
					Text_Area.append("XtLg. Pizza(s): " + Jtxt_xtPizza.getText() + ".....$"
							+ String.format("%.2f", PRICE_XT_Large_Pizza) + "\n");
				}
				Xtpcost = String.format("%.2f", xt_pizza_total);

				// ---- SMALL COLD SUB CALCULATION ---- //
				double sm_sub_total;

				if (Jtxt_sSub.getText().isEmpty()) {
					sm_sub_total = 0;
				} else {
					sm_sub_total = Double.parseDouble(Jtxt_sSub.getText()) * PRICE_Small_Cold_Sub;
					Text_Area.append("Sm. Subs(s): " + Jtxt_sSub.getText() + ".....$"
							+ String.format("%.2f", PRICE_Small_Cold_Sub) + "\n");
				}
				Sscost = String.format("%.2f", sm_sub_total);

				// ---- LARGE COLD SUB CALCULATION ---- //
				double lg_sub_total;

				if (Jtxt_lSub.getText().isEmpty()) {
					lg_sub_total = 0;
				} else {
					lg_sub_total = Double.parseDouble(Jtxt_lSub.getText()) * PRICE_Large_Cold_Sub;
					Text_Area.append("Lg. Subs(s): " + Jtxt_lSub.getText() + ".....$"
							+ String.format("%.2f", PRICE_Large_Cold_Sub) + "\n");
				}
				Lscost = String.format("%.2f", lg_sub_total);

				// ---- SMALL HOT SUB CALCULATION ---- //
				double sm_hot_sub_total;
				if (Jtxt_sHSub.getText().isEmpty()) {
					sm_hot_sub_total = 0;
				} else {
					sm_hot_sub_total = Double.parseDouble(Jtxt_sHSub.getText()) * PRICE_Small_Hot_Sub;
					Text_Area.append("Sm. Hot Sub(s): " + Jtxt_sHSub.getText() + ".....$"
							+ String.format("%.2f", PRICE_Small_Hot_Sub) + "\n");
				}
				Shscost = String.format("%.2f", sm_hot_sub_total);

				// ---- LARGE HOT SUB CALCULATION ---- //
				double lg_hot_sub_total;
				if (Jtxt_lHsub.getText().isEmpty()) {
					lg_hot_sub_total = 0;
				} else {
					lg_hot_sub_total = Double.parseDouble(Jtxt_lHsub.getText()) * PRICE_Small_Hot_Sub;
					Text_Area.append("Lg. Hot Sub(s): " + Jtxt_lHsub.getText() + ".....$"
							+ String.format("%.2f", PRICE_Large_Hot_Sub) + "\n");
				}
				Lhscost = String.format("%.2f", lg_hot_sub_total);

				// ---- HAMBURGER CALCULATION ---- //
				double hamburger_total;
				if (Jtxt_burger.getText().isEmpty()) {
					hamburger_total = 0;
				} else {
					hamburger_total = Double.parseDouble(Jtxt_burger.getText()) * PRICE_Hamburger;
					Text_Area.append("Hamburger(s): " + Jtxt_burger.getText() + ".....$"
							+ String.format("%.2f", PRICE_Hamburger) + "\n");
				}
				Hcost = String.format("%.2f", hamburger_total);

				// ---- CHEESEBURGER CALCULATION ---- //
				double cheeseburger_total;
				if (Jtxt_chburger.getText().isEmpty()) {
					cheeseburger_total = 0;
				} else {
					cheeseburger_total = Double.parseDouble(Jtxt_chburger.getText()) * PRICE_Cheeseburger;
					Text_Area.append("Cheeseburger(s): " + Jtxt_chburger.getText() + ".....$"
							+ String.format("%.2f", PRICE_Cheeseburger) + "\n");
				}
				Ccost = String.format("%.2f", cheeseburger_total);

				// ---- DOUBLE HAMBURGER CALCULATION ---- //
				double dbl_burger_total;
				if (Jtxt_dbburger.getText().isEmpty()) {
					dbl_burger_total = 0;
				} else {
					dbl_burger_total = Double.parseDouble(Jtxt_dbburger.getText()) * PRICE_Double_Hamburger;
					Text_Area.append("Dbl Hamburger(s): " + Jtxt_dbburger.getText() + ".....$"
							+ String.format("%.2f", PRICE_Double_Hamburger) + "\n");
				}
				DHcost = String.format("%.2f", dbl_burger_total);

				// ---- DOUBLE CHEESEBURGER CALCULATION ---- //
				double dbl_cheesburger_total;
				if (Jtxt_dbchburger.getText().isEmpty()) {
					dbl_cheesburger_total = 0;
				} else {
					dbl_cheesburger_total = Double.parseDouble(Jtxt_dbchburger.getText()) * PRICE_Double_Cheeseburger;
					Text_Area.append("Dbl Cheeseburger(s): " + Jtxt_dbchburger.getText() + ".....$"
							+ String.format("%.2f", PRICE_Double_Cheeseburger) + "\n");
				}
				DCcost = String.format("%.2f", dbl_cheesburger_total);

				// ---- DESSERT CALCULATION ---- //
				double dessert_total;
				if (Jtxt_dessert.getText().isEmpty()) {
					dessert_total = 0;
				} else {
					dessert_total = Double.parseDouble(Jtxt_dessert.getText()) * PRICE_Dessert;
					Text_Area.append("Dessert(s): " + Jtxt_dessert.getText() + ".....$"
							+ String.format("%.2f", PRICE_Dessert) + "\n");
				}
				Dcost = String.format("%.2f", dessert_total);

				// ---- SIDE ITEM CALCULATION ---- //
				double side_total;
				if (Jtxt_sideItem.getText().isEmpty()) {
					side_total = 0;
				} else {
					side_total = Double.parseDouble(Jtxt_sideItem.getText()) * PRICE_Dessert;
					Text_Area.append("Side(s): " + Jtxt_sideItem.getText() + ".....$"
							+ String.format("%.2f", PRICE_Side_Item) + "\n");
				}
				Scost = String.format("%.2f", side_total);

				// ---- FRENCH FRY ITEM CALCULATION ---- //
				double ff_total;
				if (Jtxt_fFry.getText().isEmpty()) {
					ff_total = 0;
				} else {
					ff_total = Double.parseDouble(Jtxt_fFry.getText()) * PRICE_French_Fries;
					Text_Area.append("French Fries: " + Jtxt_fFry.getText() + ".....$"
							+ String.format("%.2f", PRICE_French_Fries) + "\n");
				}
				fFcost = String.format("%.2f", ff_total);

				totalcosts = String.format("%.2f",
						sm_pizza_total + md_pizza_total + lg_pizza_total + xt_pizza_total + sm_sub_total + lg_sub_total
								+ sm_hot_sub_total + lg_hot_sub_total + hamburger_total + cheeseburger_total
								+ dbl_burger_total + dbl_cheesburger_total + dessert_total + side_total + ff_total);
				lblCostM.setText(totalcosts);

				// Drink Selection Items //
				double Drinks;

				if (Jtxt_drink_qty.getText().isEmpty()) {
					Drinks = 0;
				} else {
					Drinks = Double.parseDouble(Jtxt_drink_qty.getText());
				}
				double Coke = PRICE_Coke * Drinks;
				double Diet_Coke = PRICE_Diet_Coke * Drinks;
				double Sprite = PRICE_Sprite * Drinks;
				double Diet_Sprite = PRICE_Diet_Sprite * Drinks;
				double Milk_Shake = PRICE_Milk_Shake * Drinks;
				double cCoffee = PRICE_Coffee * Drinks;
				double hTea = PRICE_Tea * Drinks;
				double H20 = PRICE_Water * Drinks;
				double Icee = PRICE_Ice * Drinks;
				double Select_Soda = 0 * Drinks;

				if (JComboBox_Drink.getSelectedItem().equals("Coke")) {
					String cCoke = String.format("%.2f", Coke);
					lblDrinkC.setText(cCoke);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Coke: " + ".....$"
							+ String.format("%.2f", PRICE_Coke) + " ea." + "\n");
				}

				if (JComboBox_Drink.getSelectedItem().equals("Diet Coke")) {
					String dCoke = String.format("%.2f", Diet_Coke);
					lblDrinkC.setText(dCoke);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Diet Coke: " + ".....$"
							+ String.format("%.2f", PRICE_Diet_Coke) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Sprite")) {
					String sprite = String.format("%.2f", Sprite);
					lblDrinkC.setText(sprite);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Sprite: " + ".....$"
							+ String.format("%.2f", PRICE_Sprite) + " ea." + "\n");
				}

				if (JComboBox_Drink.getSelectedItem().equals("Diet Sprite")) {
					String dsprite = String.format("%.2f", Diet_Sprite);
					lblDrinkC.setText(dsprite);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Diet Sprite: " + ".....$"
							+ String.format("%.2f", PRICE_Diet_Sprite) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Milk Shake")) {
					String mshake = String.format("%.2f", Milk_Shake);
					lblDrinkC.setText(mshake);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Milk Shake: " + ".....$"
							+ String.format("%.2f", PRICE_Milk_Shake) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Coffee")) {
					String cafe = String.format("%.2f", cCoffee);
					lblDrinkC.setText(cafe);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Coffee: " + ".....$"
							+ String.format("%.2f", PRICE_Coffee) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Tea")) {
					String hhtea = String.format("%.2f", hTea);
					lblDrinkC.setText(hhtea);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Tea: " + ".....$"
							+ String.format("%.2f", PRICE_Tea) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Ice")) {
					String sice = String.format("%.2f", Icee);
					lblDrinkC.setText(sice);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Ice: " + ".....$"
							+ String.format("%.2f", PRICE_Ice) + " ea." + "\n");
				}
				if (JComboBox_Drink.getSelectedItem().equals("Water")) {
					String agua = String.format("%.2f", H20);
					lblDrinkC.setText(agua);
					Text_Area.append(Jtxt_drink_qty.getText() + " " + "Water: " + ".....$"
							+ String.format("%.2f", PRICE_Water) + " ea." + "\n");
				}
				// last drink goes here:
				if (JComboBox_Drink.getSelectedItem().equals("Select Drink")) {
					String nada = String.format("%.2f", Select_Soda);
					lblDrinkC.setText(nada);
				}
				// Toppings Selection Item //
				double Toppings;

				if (Jtxt_toppings_qty.getText().isEmpty()) {
					Toppings = 0;
				} else {
					Toppings = Double.parseDouble(Jtxt_toppings_qty.getText());
				}

				double One = PRICE_One_Topping * Toppings;
				double Two = PRICE_Two_Topping * Toppings;
				double Three = PRICE_Three_Topping * Toppings;
				double Select_Topping = 0 * Toppings;

				if (JComboBox_Topping.getSelectedItem().equals("One Topping")) {
					String Uno = String.format("%.2f", One);
					lblToppingC.setText(Uno);
				}
				if (JComboBox_Topping.getSelectedItem().equals("Two Toppings")) {
					String Dos = String.format("%.2f", Two);
					lblToppingC.setText(Dos);
				}
				if (JComboBox_Topping.getSelectedItem().equals("Three Toppings")) {
					String Tres = String.format("%.2f", Three);
					lblToppingC.setText(Tres);
				}
				if (JComboBox_Topping.getSelectedItem().equals("Select Topping")) {
					String notop = String.format("%.2f", Select_Topping);
					lblToppingC.setText(notop);
				}
				if (Jtxt_toppings_qty.getText().isEmpty()) {
					Toppings = 0;
				} else {

					Text_Area.append(Jtxt_toppings_qty.getText() + " " + "Toppings total: " + ".....$"
							+ Double.parseDouble(Jtxt_toppings_qty.getText()) + "\n");
				}
				// ---- delivery check box ----//
				double delivery_charge = PRICE_Delivery;
				if (chckbxDelivery.isSelected()) {
					String Delcost = String.format("%.2f", delivery_charge); // user
																				// string
																				// format
																				// %.2f
					lblCostD.setText(Delcost);
					Text_Area.append("Delivery Cost: " + ".....$" + String.format("%.2f", delivery_charge) + "\n");
				} else {
					lblCostD.setText("0.00");
				}

				// Sub Total Information
				double sub_cost_meal = Double.parseDouble(lblCostM.getText());
				double sub_cost_drinks = Double.parseDouble(lblDrinkC.getText());
				double sub_cost_toppings = Double.parseDouble(lblToppingC.getText());
				double sub_cost_delivery = Double.parseDouble(lblCostD.getText());
				double sub_totals = (sub_cost_meal) + (sub_cost_drinks) + (sub_cost_toppings) + (sub_cost_delivery);

				String Stotal = String.format("%.2f", sub_totals);
				lbl_subt.setText(Stotal);
				// Tax Information

				double tax_totals = sub_totals * tax;

				String Tax = String.format("%.2f", tax_totals);
				lbl_tax.setText(Tax);

				// Total Information

				double amount_totals = (sub_totals) + (tax_totals) + (sub_cost_delivery);

				String final_total = String.format("%.2f", amount_totals);
				lbl_finalcst.setText(final_total);
				// Append receipet_viewer field.

				{
					// Reciept Viewer Calculations
					Text_Area.append("\n" + "---------------------------" + "\n" + "Your sub total amount: "
							+ sub_totals + "\n" + "Tax amount: " + String.format("%.2f", sub_totals * tax) + "\n"
							+ "Final cost: " + String.format("%.2f", amount_totals) + "\n"
							+ "---------------------------\n" + "Thank you for dining with" + "\n" + "us today!");

				}
				// BEGIN ALL SQL Statement Query Code

				// Create int variables so we can correctly increment 
				// our tables and columns. 
				int temp_customer_id = 0;
				int temp_order_id = 0;
				int temp_food_id = 0;
				try {
					String query = "SELECT Customer_ID FROM Customer WHERE First_Name = \'" + first_name.getText()
							+ "\' AND Last_Name = \'" + last_name.getText() + "\' AND Address = \'"
							+ street_name.getText() + "\' AND City = \'" + city_name.getText() + "\' AND State = \'"
							+ state_name.getText() + "\' AND Zip = \'" + zip_code.getText() + "\' LIMIT 1";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					temp_customer_id = rs.getInt("Customer_ID");
					pst.close();

					String query1 = "INSERT INTO Orders (amount, Customer_ID) VALUES (?,?)";
					PreparedStatement pst1 = connection.prepareStatement(query1);
					pst1.setString(1, lblCostM.getText());
					pst1.setInt(2, temp_customer_id);
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Dollar Amount Saved");
					pst1.close();
				} catch (Exception e1) {
					e1.printStackTrace();

				}
				// create subquery

				try {
					String query0 = "SELECT order_id FROM Orders WHERE Customer_ID =  " + temp_customer_id
							+ " AND order_date=(Select MAX(order_date) from Orders WHERE Customer_ID = "
							+ temp_customer_id + ") ";
					String query1 = "INSERT into Food (sm_pizza,md_pizza,lg_pizza,xt_pizza,sm_cold_sub,lg_cold_sub,sm_hot_sub,lg_hot_sub,hamburger,cheeseburger,double_burger,double_chburger,french_fries,dessert,side_item,food_amount,order_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

					PreparedStatement pst0 = connection.prepareStatement(query0);
					ResultSet rs = pst0.executeQuery();
					temp_order_id = rs.getInt("order_id");
					System.out.println("temp_order_id: " + temp_order_id); // debugging
																			// purpose
					pst0.close();

					PreparedStatement pst1 = connection.prepareStatement(query1);
					// variable
					pst1.setString(1, Jtxt_sPizza.getText());
					pst1.setString(2, Jtxt_mPizza.getText());
					pst1.setString(3, Jtxt_lPizza.getText());
					pst1.setString(4, Jtxt_xtPizza.getText());
					pst1.setString(5, Jtxt_sSub.getText());
					pst1.setString(6, Jtxt_lSub.getText());
					pst1.setString(7, Jtxt_sHSub.getText());
					pst1.setString(8, Jtxt_lHsub.getText());
					pst1.setString(9, Jtxt_burger.getText());
					pst1.setString(10, Jtxt_chburger.getText());
					pst1.setString(11, Jtxt_dbburger.getText());
					pst1.setString(12, Jtxt_dbchburger.getText());
					pst1.setString(13, Jtxt_fFry.getText());
					pst1.setString(14, Jtxt_dessert.getText());
					pst1.setString(15, Jtxt_sideItem.getText());
					pst1.setString(16, lblCostM.getText());
					pst1.setInt(17, temp_order_id);
					pst1.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Value Saved");
					pst1.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				// JComboBox Drinks SQLite Statements
				try {
					String query0 = "Select food_id from food WHERE order_id =" + temp_order_id;
					String query1 = "insert into Drink (drink_amount, drink_item, order_id, food_item) values (?,?,?,?)";
					PreparedStatement pst0 = connection.prepareStatement(query0);

					ResultSet rs = pst0.executeQuery();
					temp_food_id = rs.getInt("food_id");
					System.out.println("temp_food_id: " + temp_food_id); // debugging
																			// purpose
					pst0.close();
					PreparedStatement pst1 = connection.prepareStatement(query1); // pst
																					// =
																					// prepared
																					// statement
																					// variable
					pst1.setString(1, lblDrinkC.getText());
					String value = JComboBox_Drink.getSelectedItem().toString();
					pst1.setString(2, value);
					pst1.setInt(3, temp_order_id);
					System.out.println("temp_order_id: " + temp_order_id);
					pst1.setInt(4, temp_food_id);
					System.out.println("temp_food_id " + temp_food_id);
					pst1.execute(); // rs = result set variable
					// enable comment below for deubbuging purposes
					JOptionPane.showMessageDialog(null, "JComboxBox Saved!");
					pst1.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				// JCombobox Toppings SQLite Statements
				try {

					String query = "insert into Topping (amount, topping_item, order_id, food_ID) values (?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);

					pst.setString(1, lblToppingC.getText());
					String value = JComboBox_Topping.getSelectedItem().toString();
					pst.setString(2, value);
					pst.setInt(3, temp_order_id);
					pst.setInt(4, temp_food_id);

					pst.execute(); // rs = result set variable
					// enable comment below for deubbuging purposes
					JOptionPane.showMessageDialog(null, "JComboxBox Topping Saved!");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				// SQL COMMAND FOR DOLLAR AMOUNTS TO GET GENERATE INTO SQL TABLE

			}
		});

		btnTotalAmount.setBounds(6, 6, 117, 29);
		panel_3.add(btnTotalAmount);
		// ------------BUTTONS FOR DINE IN/ DELIVERY
		// ------------NOTE: NEEDS TO BE ADDED BELOW EVERYTHING TO WORK PROPERLY
		// WITH TILL BUTTON
		JButton btn_submit = new JButton("Submit Delivery");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// NOTE TO SELF UNCOMMENT WHEN READY TO START RUNNING SQL
				// QUERIES
				// NOTE TO SELF THIS SQL QUERY GOES ABOVE TEH ELSE STATEMENT!
				// NEED TO MOVE OVER
				try {
					String query = "insert into Customer (First_Name,Last_Name,Address,City,State,Zip) values (?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query); // pst
																				// =
																				// prepared
																				// statement
																				// variable
					pst.setString(1, first_name.getText());
					pst.setString(2, last_name.getText());
					pst.setString(3, street_name.getText());
					pst.setString(4, city_name.getText());
					pst.setString(5, state_name.getText());
					pst.setString(6, zip_code.getText());

					pst.execute(); // rs = result set variable

					JOptionPane.showMessageDialog(null, "Customer Input Saved");
					pst.close(); // terminate prepared statement

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Enter Missing Values");
				}

				btn_submit.setEnabled(false);
				btnTotalAmount.setEnabled(true);

				// btnTotalAmount.setEnabled(false); // placed false, in case
				// else statements trigger setEnabled(true)
				if ((first_name.getText() != null && !last_name.getText().isEmpty() && !city_name.getText().isEmpty()
						&& !street_name.getText().isEmpty() && !state_name.getText().isEmpty()
						&& !zip_code.getText().isEmpty())) {
					lblverify.setText("Submission sent!");

				} else {
					first_name.setForeground(Color.WHITE);
					first_name.setBackground(Color.RED);
					first_name.setText("Missing field");

					last_name.setForeground(Color.WHITE);
					last_name.setBackground(Color.RED);
					last_name.setText("Missing field");

					street_name.setForeground(Color.WHITE);
					street_name.setBackground(Color.RED);
					street_name.setText("Missing field");

					city_name.setForeground(Color.WHITE);
					city_name.setBackground(Color.RED);
					city_name.setText("Missing field");
					// set backgrounds red
					state_name.setBackground(Color.RED);
					zip_code.setBackground(Color.RED);
				}

			}
		});
		btn_submit.setBounds(6, 58, 143, 29);
		panel_7.add(btn_submit);

		JButton btnSubmitDineIn = new JButton("Dine In Only");
		btnSubmitDineIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// NOTE TO SELF; REMOVE COMMANDS ONCE COMPLETE
				first_name.setText("Dine In");
				last_name.setText("N/A");
				street_name.setText("N/A");
				city_name.setText("N/A");
				state_name.setText("N/A");
				zip_code.setText("N/A");

				btn_submit.setEnabled(false);
				btnSubmitDineIn.setEnabled(false);
				btnTotalAmount.setEnabled(true);
				lblverify.setText("Submission sent!");
			}
		});
		btnSubmitDineIn.setBounds(6, 84, 143, 29);
		panel_7.add(btnSubmitDineIn);
		JButton btn_clear_fields = new JButton("Reset");
		btn_clear_fields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_name.setForeground(Color.WHITE);
				first_name.setBackground(Color.BLACK);
				first_name.setText(null);

				last_name.setForeground(Color.WHITE);
				last_name.setBackground(Color.BLACK);
				last_name.setText(null);

				street_name.setForeground(Color.WHITE);
				street_name.setBackground(Color.BLACK);
				street_name.setText(null);

				city_name.setForeground(Color.WHITE);
				city_name.setBackground(Color.BLACK);
				city_name.setText(null);
				// set backgrounds red
				state_name.setBackground(Color.BLACK);
				state_name.setText(null);
				zip_code.setBackground(Color.BLACK);
				zip_code.setText(null);
				btn_submit.setEnabled(true);
				btnSubmitDineIn.setEnabled(true);
				btnTotalAmount.setEnabled(false);
				lblverify.setText(null);
				dispose();
				new Pizza_UI();
			}
		});
		btn_clear_fields.setBounds(302, 53, 117, 56);
		panel_7.add(btn_clear_fields);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set default exit code
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 84, 117, 29);
		panel_3.add(btnExit);
		JButton btnStartOver = new JButton("Start Over");
		btnStartOver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JComboBox_Topping.setSelectedIndex(0);
				JComboBox_Drink.setSelectedIndex(0);

				// --- actions preformed are for any item with a number resets
				// back to null
				Jtxt_sPizza.setText(null);
				Jtxt_mPizza.setText(null);
				Jtxt_lPizza.setText(null);
				Jtxt_xtPizza.setText(null);
				Jtxt_sSub.setText(null);
				Jtxt_lSub.setText(null);
				Jtxt_sHSub.setText(null);
				Jtxt_lHsub.setText(null);
				Jtxt_burger.setText(null);
				Jtxt_chburger.setText(null);
				Jtxt_dbburger.setText(null);
				Jtxt_dbchburger.setText(null);
				Jtxt_dessert.setText(null);
				Jtxt_sideItem.setText(null);
				Jtxt_fFry.setText(null);
				Text_Area.setText(null);
				Jtxt_drink_qty.setText(null);
				Jtxt_toppings_qty.setText(null);
				// --- JLabel Resets Below --- //
				lblToppingC.setText(null);
				lblDrinkC.setText(null);
				lblCostM.setText("0"); // -- set at 0 to identify program
										// functionality (once reset button
										// clicks).

				lblCostD.setText(null);
				lbl_tax.setText(null);
				lbl_subt.setText(null);
				lbl_finalcst.setText(null);
				// btnTotalAmount.setEnabled(true); // Enable function for
				// debugging purposes only.

			}
		});
		btnStartOver.setBounds(6, 47, 117, 29);
		panel_3.add(btnStartOver);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("About", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblRistoranteAlex = new JLabel("Ristorante Alex ");
		lblRistoranteAlex.setBounds(6, 6, 154, 16);
		panel_4.add(lblRistoranteAlex);

		JLabel lblAbcDrive = new JLabel("123 ABC Drive");
		lblAbcDrive.setBounds(6, 23, 154, 16);
		panel_4.add(lblAbcDrive);

		JLabel lblBrookdaleNj = new JLabel("Brookdale, NJ 07777");
		lblBrookdaleNj.setBounds(6, 42, 154, 16);
		panel_4.add(lblBrookdaleNj);

		JLabel lblContact = new JLabel("Contact: 732-555-5555");
		lblContact.setBounds(6, 60, 154, 16);
		panel_4.add(lblContact);

		JLabel lblFax = new JLabel("Email: Demo@website.com");
		lblFax.setBounds(6, 97, 176, 16);
		panel_4.add(lblFax);

		JLabel label_1 = new JLabel("Fax: 732-555-5555");
		label_1.setBounds(6, 79, 154, 16);
		panel_4.add(label_1);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(172, 6, 12, 107);
		panel_4.add(separator_7);

		JLabel lblFiserPosSystems_1 = new JLabel("FISER POS Systems");
		lblFiserPosSystems_1.setBounds(187, 6, 154, 16);
		panel_4.add(lblFiserPosSystems_1);

		JLabel lblCustomerSupport = new JLabel("Customer Support: 800-555-5555");
		lblCustomerSupport.setBounds(187, 42, 231, 16);
		panel_4.add(lblCustomerSupport);

		JLabel lblFiserWebsiteHttpwwwdemocom = new JLabel("FISER Website: http://demo.com");
		lblFiserWebsiteHttpwwwdemocom.setBounds(187, 60, 232, 16);
		panel_4.add(lblFiserWebsiteHttpwwwdemocom);

		JLabel lblFiserContactSupportdemocom = new JLabel("FISER Contact: Contact@demo.com");
		lblFiserContactSupportdemocom.setBounds(187, 79, 232, 16);
		panel_4.add(lblFiserContactSupportdemocom);

		JLabel lblFiserHelpSupportdemocom = new JLabel("FISER Help: Support@demo.com");
		lblFiserHelpSupportdemocom.setBounds(187, 97, 232, 16);
		panel_4.add(lblFiserHelpSupportdemocom);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(177, 23, 241, 17);
		panel_4.add(separator_9);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Admin", null, panel_5, null);
		panel_5.setLayout(null);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(83, 65, 167, 33);
		panel_5.add(txtPassword);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(16, 0, 280, 16);
		panel_5.add(separator_6);

		JLabel label = new JLabel("Username");
		label.setBounds(16, 28, 62, 16);
		panel_5.add(label);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(83, 20, 167, 33);
		panel_5.add(txtUsername);

		JButton bLogin = new JButton("Login");
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM login WHERE Username=? and Password=? ";

					PreparedStatement pst = connection.prepareStatement(query);

					pst.setString(1, txtUsername.getText());
					pst.setString(2, txtPassword.getText());

					ResultSet rs = pst.executeQuery();

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Username and password is correct!");
						// frame.dispose();
						Tables Tables_Gui = new Tables();
						Tables_Gui.Tables();

					} else {
						String message = "Username or Password Entered Incorrectly.";
						JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
					}
					rs.close();
					pst.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);

				}

			}
		});
		bLogin.setBounds(302, 0, 117, 29);
		panel_5.add(bLogin);

		JButton bReset = new JButton("Reset");
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null); // <---clears login field
				txtPassword.setText(null); // <---- clears password field
			}
		});
		bReset.setBounds(302, 44, 117, 29);
		panel_5.add(bReset);

		JButton bExit = new JButton("Exit");
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFiserPosSystems = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmFiserPosSystems, "Confirm you want to exit",
						"Ristorante Alex POS Version 1.0", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		bExit.setBounds(302, 85, 117, 28);
		panel_5.add(bExit);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(16, 73, 62, 16);
		panel_5.add(lblPassword);
		getClass();
		// END TABS BELOW
		// Buttons for
		// --- combo box -- //

		Jtxt_drink_qty = new JTextField();
		Jtxt_drink_qty.setHorizontalAlignment(SwingConstants.LEFT);
		Jtxt_drink_qty.setForeground(Color.WHITE);
		Jtxt_drink_qty.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_drink_qty.setColumns(10);
		Jtxt_drink_qty.setBackground(Color.BLACK);
		Jtxt_drink_qty.setBounds(151, 34, 66, 16);
		Jtxt_drink_qty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel_2.add(Jtxt_drink_qty);

		Jtxt_toppings_qty = new JTextField();
		Jtxt_toppings_qty.setHorizontalAlignment(SwingConstants.LEFT);
		Jtxt_toppings_qty.setForeground(Color.WHITE);
		Jtxt_toppings_qty.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Jtxt_toppings_qty.setColumns(10);
		Jtxt_toppings_qty.setBackground(Color.BLACK);
		Jtxt_toppings_qty.setBounds(151, 70, 66, 16);
		Jtxt_toppings_qty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		panel_2.add(Jtxt_toppings_qty);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblQuantity.setBounds(162, 16, 55, 16);
		panel_2.add(lblQuantity);

		JLabel lblFiserPosSystems = new JLabel("FESR POS SYSTEMS VERSION 2.0 - Copyright 2018");
		lblFiserPosSystems.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiserPosSystems.setForeground(Color.WHITE);
		lblFiserPosSystems.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblFiserPosSystems.setBounds(126, 518, 275, 16);
		frmFiserPosSystems.getContentPane().add(lblFiserPosSystems);

	}

	protected void dispose() {

	}
}
// END APPLICATION
