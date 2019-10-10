package model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Conn;
import database.DriverMaagerConnectionPool;
import database.Record;
import database.Table;
import model.beans.Preferiti;
import model.beans.ProductBean;
import model.beans.Utente;

public class PreferitiDAO {

	public static Preferiti doRetrieve(Utente ut, String codice) throws SQLException {
		/*Preferiti pref = new Preferiti();
		Conn c = Conn.hold();

		
		Table t = c.query("SELECT *\r\n" + 
				"FROM prodotto \r\n" + 
				"WHERE Codice in (select codiceProdotto\r\n" + 
				"				from desideri\r\n" + 
				"                where usernameUtente= ?)", ut.getUsername());
		if (t.count() == 0) {
			return null;
		}
		Conn.release(c);
		pref.setUtente(ut);
		for(int i=0; i<t.count();i++)
		{
			Record r = t.get(i);
			try{
				ProductBean p = (ProductBean) r.get(0);
			if(!(presente(pref.getProducts(),p)))
				pref.addProduct(p);
			}catch(Exception e) {System.out.println(e.getMessage());};
		}
		
		return pref;
	}
	
	public static void doSave(Utente ut, ProductBean prod) throws SQLException  {
		Conn c = Conn.hold();
				
		c.insertPreferiti("INSERT INTO preferiti (usernameUtente, sizeProdotto, codiceProdotto) VALUES (?,?,?);",ut.getUsername(),prod.getSize(), prod.getCodice());
		
		Conn.release(c);
	}
	*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> list =new ArrayList<ProductBean>();

		String selectSQL = "SELECT *\r\n" + 
				"FROM prodotto \r\n" + 
				"WHERE Codice in (select codiceProdotto\r\n" + 
				"				from desideri\r\n" + 
				"                where usernameUtente= ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, ut.getUsername());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setSize(rs.getString("Size"));
				bean.setCodice(rs.getString("Codice"));
				bean.setNostalgia(rs.getString("Nostalgia"));
				bean.setSconto(rs.getInt("Sconto"));
				bean.setBrand(rs.getString("Brand"));
				bean.setPrezzoAtt(rs.getFloat("PrezzoAttuale"));
				bean.setIvaAtt(rs.getInt("IvaAttuale"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setPezzi(rs.getInt("Pezzi"));
				bean.setImg(rs.getString("Immagine"));
				bean.setTipo(rs.getString("tipo"));
				bean.setNome(rs.getString("Nome"));
				if(!(presente(list,bean)))
				                list.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		Preferiti pref = new Preferiti();
		pref.setProducts(list);
		return pref;
	}
	
	
	public static void doSave(Utente ut, String size, String codice) throws SQLException  {
		/*Conn c = Conn.hold();
				
		c.insertPreferiti("INSERT INTO preferiti (usernameUtente, sizeProdotto, codiceProdotto) VALUES (?,?,?);",ut.getUsername(),size,codice);
		
		Conn.release(c);*/
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO desideri (usernameUtente, sizeProdotto, codiceProdotto) VALUES (?,?,?);";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, ut.getUsername());
			preparedStatement.setString(2, size);
			preparedStatement.setString(3, codice);
			

			preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public static boolean presente(ArrayList<ProductBean> list,ProductBean x) {
		for(ProductBean prod : list) {
			if(   prod.getCodice().equalsIgnoreCase(x.getCodice())  )
			                  return true;
		}
		return false;
	}


	public static void doDelete(Utente ut, String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "DELETE FROM desideri WHERE (usernameUtente=? AND codiceProdotto=?);";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, ut.getUsername());
			preparedStatement.setString(2, codice);
			

			preparedStatement.executeUpdate();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}
}