package infoman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data_Connection {
	public static Connection getConnection(){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/products", "root", "");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return con;
	}

}
