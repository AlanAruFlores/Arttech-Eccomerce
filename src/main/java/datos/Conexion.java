package datos;
import java.sql.*;
public class Conexion {
	private static String JDBC_USER="root";
	private static String JDBC_PASSWORD="root1234";
	private static String JDBC_URL="jdbc:mysql://localhost:3306/ecommerce";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	}
	
	public static void closeConnections(ResultSet rs, PreparedStatement stmt, Connection conn)
	throws SQLException{
		rs.close();
		stmt.close();
		conn.close();
	}
	public static void closeConnections(PreparedStatement stmt, Connection conn) throws SQLException{
		stmt.close();
		conn.close();
	}
	
}