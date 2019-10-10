package model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import database.DriverMaagerConnectionPool;
import model.beans.ProductBean;


public class ProductModelDM implements ProductModel {

	private static final String TABLE_NAME = "prodotto";
	private static PreparedStatement p;

	@Override
	public synchronized void doSave(ProductBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME
				+ " (Size, Codice, Nostalgia, Sconto, Brand, PrezzoAttuale, IvaAttuale, Descrizione, Pezzi, Immagine, tipo, Nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getSize());
			preparedStatement.setString(2, product.getCodice());
			preparedStatement.setString(3, product.getNostalgia());
			preparedStatement.setInt(4, product.getSconto());
			preparedStatement.setString(5, product.getBrand());
			preparedStatement.setFloat(6, product.getPrezzoAtt());
			preparedStatement.setInt(7, product.getIvaAtt());
			preparedStatement.setString(8, product.getDescrizione());
			preparedStatement.setInt(9, product.getPezzi());
			preparedStatement.setString(10, product.getImg());
			preparedStatement.setString(11, product.getTipo());
			preparedStatement.setString(12, product.getNome());
			

			preparedStatement.execute();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	
	
    public synchronized static  ProductBean doRetrieveByKey(String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductBean bean = new ProductBean();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE Codice = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
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
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
    
    
    public synchronized static  ProductBean doRetrieveByCODICEeTAGLIA(String codice,String taglia) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductBean bean = new ProductBean();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE (Codice = ? AND Size=?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice);
			preparedStatement.setString(2, taglia);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
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
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	
	
	public synchronized static ArrayList<ProductBean> doRetrieveByCond(String nome,String valore) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> list =new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE "+nome+" = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, valore);

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
		return list;
	}

	public synchronized static ArrayList<ProductBean> doRetrieveTutti() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> list =new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

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
		return list;
	}
	
	public synchronized static ArrayList<ProductBean> doRetrieveTuttiPROPRIOTUTTI() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> list =new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

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
				if (!(bean.getSize().equalsIgnoreCase("X")))
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
		return list;
	}
	
	@Override
	public synchronized boolean doDelete(String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE Codice = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1,codice);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
	public static boolean presente(ArrayList<ProductBean> list,ProductBean x) {
		for(ProductBean prod : list) {
			if(   prod.getCodice().equalsIgnoreCase(x.getCodice())  )
			                  return true;
		}
		return false;
	}

	
	public synchronized static void aggiornaQuantita(String codice,String taglia,int pezziVecchi,int pezziAcquistati) throws SQLException {
		Connection connection = null;
		PreparedStatement p = null;

		String updateSQL= "UPDATE prodotto SET Pezzi = ? WHERE (Size = ?) and (Codice = ?)";
		
		connection = DriverMaagerConnectionPool.getConnection();
		p = connection.prepareStatement(updateSQL);
		
		int dif=pezziVecchi-pezziAcquistati;
		p.setInt(1, dif);
		p.setString(2, taglia);
		p.setString(3, codice);
		
		p.executeUpdate();
		try {
			
		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}


	@Override
	public void DoUpdate(ProductBean nuovo) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL= "UPDATE prodotto SET Size = ?, Nostalgia = ?, Sconto = ?, Brand = ?, PrezzoAttuale = ?, IvaAttuale = ?, Descrizione = ?, Pezzi = ?, Immagine = ?, Tipo = ?, Nome = ?  WHERE (Codice = ? AND Size = ?);";
		
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nuovo.getSize());
			preparedStatement.setString(2, nuovo.getNostalgia());
			preparedStatement.setInt(3, nuovo.getSconto());
			preparedStatement.setString(4, nuovo.getBrand());
			preparedStatement.setFloat(5, nuovo.getPrezzoAtt());
			preparedStatement.setInt(6, nuovo.getIvaAtt());
			preparedStatement.setString(7, nuovo.getDescrizione());
			preparedStatement.setInt(8, nuovo.getPezzi());
			preparedStatement.setString(9, nuovo.getImg());
			preparedStatement.setString(10, nuovo.getTipo());
			preparedStatement.setString(11, nuovo.getNome());
			preparedStatement.setString(12, nuovo.getCodice());
			preparedStatement.setString(13, nuovo.getSize());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		
	}
		
	}

