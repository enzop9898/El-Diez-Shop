package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conn {

	private static ArrayList<Conn> cs = new ArrayList<>();

	public synchronized static Conn hold() {
		if (cs.size() == 0) {
			try {
				cs.add(new Conn("127.0.0.1", 3306, "root", "Juventus98!", "el_diez_shop"));
			} catch (SQLException ignored) {
			}
		}
		Conn conn = cs.get(0);
		cs.remove(0);
		return conn;
	}

	public synchronized static void release(Conn conn) {
		if (conn != null) {
			cs.add(conn);
		}
	}

//	public static Table query(String sql, Object... data) throws RuntimeException {
//		Conn database = hold();
//		Table t = database.query(sql, data);
//		release(database);
//		return t;
//	}

	private Connection conn;

	private Conn(String url, int port, String usr, String pwd, String db) throws SQLException {
		conn = DriverManager.getConnection(makeURI(url, port, db), usr, pwd);
		if (conn == null) {
			throw new SQLException("Unable to connect to " + url);
		}
	}

	private String makeURI(String url, int port, String db) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ignored) {
		}
		String configs = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
				+ "useLegacyDatetimeCode=false&serverTimezone=UTC";
		return "jdbc:mysql://" + url + ":" + port + "/" + db + configs;
	}

	public Table query(String query, Object... data) {
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			int i = 1;
			for (Object d : data) {
				stmt.setString(i++, d.toString());
			}
			ResultSet rs = stmt.executeQuery();
			return new Table(rs);
		} catch (SQLException e) {
			System.out.println(			e.getMessage());
			throw new RuntimeException();
		}
	}

	public void update(String query, String password, String username) throws SQLException {
		/*Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);*/
		
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, password);
		prepared.setString(2, username);
		prepared.executeUpdate();
	}

	public void insertUtente(String query, String username, String password, String nome, String cognome, String tipo, String email) throws SQLException
	{
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, username);
		prepared.setString(2,password);
		prepared.setString(3,nome);
		prepared.setString(4,cognome);
		prepared.setString(5,tipo);
		prepared.setString(6,email);
		prepared.executeUpdate();
	}
	
	public void deleteUtente(String query,String username) throws SQLException
	{
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, username);
		prepared.executeUpdate();
	}
	
	public void insertPreferiti(String query, String username, String size, String codice) throws SQLException
	{
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, username);
		prepared.setString(2,size);
		prepared.setString(3,codice);
		prepared.executeUpdate();
	}
}