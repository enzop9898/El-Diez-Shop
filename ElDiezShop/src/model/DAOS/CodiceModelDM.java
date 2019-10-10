package model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DriverMaagerConnectionPool;
import model.beans.CodiceBean;

public class CodiceModelDM implements CodiceModel {
	
	private static PreparedStatement ps;


	public void doSave(CodiceBean cod) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO codice (sequenza,sconto,usato) VALUES (?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, cod.getSequenza());
			preparedStatement.setInt(2, cod.getSconto());
			preparedStatement.setString(3, cod.getUsato());
			
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}
    
	public void doUsed(String seq) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL = "UPDATE codice SET usato='si' WHERE sequenza = ?";
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1,seq);
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
	
	public CodiceBean doRetrieveByKey(String seq) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		CodiceBean bean = new CodiceBean();

		String selectSQL = "SELECT * FROM codice WHERE sequenza = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, seq);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setSequenza(rs.getString("sequenza"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setUsato(rs.getString("usato"));
	
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
	
	
	public synchronized static void  settaUsato(String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		
		String updateSQL="UPDATE `el_diez_shop`.`codice` SET `usato` = 'si' WHERE (`sequenza` = ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			ps = connection.prepareStatement(updateSQL);
            System.out.println(codice);
			ps.setString(1, codice);
			
			
			ps.executeUpdate();
			
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}
}
