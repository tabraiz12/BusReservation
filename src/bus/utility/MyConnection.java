package bus.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {

	Connection con = null;

	public Connection getMyConnection() {
		System.out.println("testing connection");

		try {
			System.out.println("testing connection");
			Class.forName(SqlConstraints.DB_DRIVER);
			// "oracle.jdbc.driver.OracleDriver"
			con = DriverManager.getConnection(SqlConstraints.DB_URL,
					SqlConstraints.DB_USERNAME, SqlConstraints.DB_PASSWORD);
			// "jdbc:oracle:thin:@localhost:1521:XE"
			// "system"
			// "password"
			// Statement st= con.createStatement();

		} catch (Exception exception) {
			System.out.println(exception);
		}
		return con;
	}
}