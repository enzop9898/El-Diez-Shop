package model.DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DriverMaagerConnectionPool;
import model.beans.OrdineBean;
import model.beans.ProductBean;

public class OrdineModelDM implements OrdineModel {
		
	
	
	public ArrayList<OrdineBean> doRetrieveByUser(String user) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<OrdineBean> ret=new ArrayList<OrdineBean>();
		String selectSQL = "select * from ordine where Username= ?";
       
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean=new OrdineBean();
				bean.setID(rs.getString("ID"));
				bean.setUsername(rs.getString("Username"));
				bean.setCostoTot(Float.parseFloat(rs.getString("CostoTot")));
				bean.setData(rs.getString("Data"));
				
				ret.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ret;
	}

	
	@Override
	public synchronized void doSave(String id,Date dataoggi,float totale,String username) throws SQLException {

		Connection connection = null;
		PreparedStatement prep = null;
		String nome="ordine";

		String insertSQL = "INSERT INTO " + nome
				+ " (ID,Data,CostoTot,Username) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			prep = connection.prepareStatement(insertSQL);
			prep.setString(1, id);
			prep.setDate(2, dataoggi);
			prep.setFloat(3,totale);
			prep.setString(4, username);
			
			prep.executeUpdate();

		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}


	@Override
	public ArrayList<OrdineBean> doRetriveByData(String da, String a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<OrdineBean> ret=new ArrayList<OrdineBean>();
		String selectSQL = "select * from ordine where Data between ? and ?";
       
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,da);
			preparedStatement.setString(2,a);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean=new OrdineBean();
				bean.toString();
				bean.setID(rs.getString("ID"));
				bean.setUsername(rs.getString("Username"));
				bean.setCostoTot(Float.parseFloat(rs.getString("CostoTot")));
				bean.setData(rs.getString("Data"));
				
				ret.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ret;
	}

	
}

