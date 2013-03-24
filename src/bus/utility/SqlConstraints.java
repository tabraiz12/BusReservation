package bus.utility;

public class SqlConstraints {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/reg";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root";
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String BUS_SEARCH = "SELECT * FROM SEARCHBUS where source=? and distination=?";
	public static final String GET_SEATS = "SELECT ? FROM ?";

	
}
