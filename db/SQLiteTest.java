package db;
/***************************************************************************
 * Generic SQLite Code														*
 * Source: http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/	*
 * 											*
 * 																			*
 ***************************************************************************/
import java.sql.*; // import all SQL libraries 
import javax.swing.*;

public class SQLiteTest {

		Connection conn = null;
		public static Connection dbConnector()
		{
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn=DriverManager.getConnection("jdbc:sqlite://Users//Aquinas//Documents//School//2017//Programming II//Pizza_UI//src//pizza_UI//PizzaDB.sqlite");
					
				JOptionPane.showMessageDialog(null, "Connection successful!");
				return conn;
			} catch(Exception e)
			{
				String message = "ERROR: DATABASE LOCATION UKNOWN" + "\n" + "UNABLE TO CONNECT!" ;
			    JOptionPane.showMessageDialog(new JFrame(), message, "Database Connection Error",
			        JOptionPane.ERROR_MESSAGE);
			    return null;
			    
			}
		}
	
	
}
