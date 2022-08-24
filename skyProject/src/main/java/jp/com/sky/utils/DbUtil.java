package jp.com.sky.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DbUtil {

	private final static String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String USER = "c##sky123";
	private final static String PASS = "1111";

	public static Connection DbConnection() throws Exception {
		Connection con = null;
		PreparedStatement ps = null; // java와DB사이의 정보전달(information transfer)
		Class.forName(CLASS_NAME); // load driver

		con = DriverManager.getConnection(URL, USER, PASS); // create a connection object

		return con;

	}
}

//try {	
//}catch(Exception e) {
//throw new RuntimeException("Error");
//}
