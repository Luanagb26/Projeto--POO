package floricultura.app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySQL implements IConnectionDB{
	final String HOST_NAME = "localhost";
	final String PORT_NUMBER = "3306";
	final String USER_NAME = "root";
	final String PASSWORD = "luanaeraul333";
	final String DATABASE = "database";
	
	public Connection getConnection() {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://"+HOST_NAME+":"
						+PORT_NUMBER+"/"+DATABASE, USER_NAME, PASSWORD);
				return con;
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	}
}
