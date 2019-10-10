 package model.DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DriverMaagerConnectionPool;
import model.beans.ComposizioneBean;
import model.beans.ProductBean;

public class ComposizioneModelDM implements ComposizioneModel {
		

	@Override
	public ArrayList<ProductBean> doRetrieveAllProductByID(String ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<ComposizioneBean> composizioni=new ArrayList<ComposizioneBean>();
		ArrayList<ProductBean> ret=new ArrayList<ProductBean>();
		String selectSQL = "select * from composizione where ID = ?";
        try {
        	connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,ID);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ComposizioneBean  bean=new ComposizioneBean();
				bean.setID(rs.getString("ID"));
				bean.setSize(rs.getString("Size"));
				bean.setCodProd(rs.getString("CodiceComp"));
				bean.setIVA(rs.getInt("IVA"));
                bean.setPrice(rs.getFloat("Prezzo"));
                bean.setQuantità(rs.getInt("Quantità"));
				composizioni.add(bean);
			}
        }
	    finally {
		       try {
			       if (preparedStatement != null)
				   preparedStatement.close();
		       } finally {
			       DriverMaagerConnectionPool.releaseConnection(connection);
		       }
	    }
		
        if(composizioni.size()>0) {
        	for(int i=0;i<composizioni.size();i++) {
        		     ProductBean prod=new ProductBean();
        		     prod= ProductModelDM.doRetrieveByCODICEeTAGLIA(composizioni.get(i).getCodProd(), composizioni.get(i).getSize());
        		     prod.setPrezzoAtt(composizioni.get(i).getPrice());
        		     prod.setQuantitaCarrello(composizioni.get(i).getQuantità());
        		     prod.setIvaAtt(composizioni.get(i).getIVA());
        		     ret.add(prod);
        	}
    		
        }
        
	return ret;
	}

	@Override
	public synchronized void doSave(String idOrdine,String sizeP,String codiceP,int iva,float prezzoP,int quantitaP) throws SQLException {

		Connection connection = null;
		PreparedStatement pre = null;
		String nome="composizione";

		String insertSQL = "INSERT INTO " + nome
				+ " (ID,Size,CodiceComp,IVA,Prezzo,Quantità) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			pre = connection.prepareStatement(insertSQL);
			pre.setString(1, idOrdine);
			pre.setString(2, sizeP);
			pre.setString(3, codiceP);
			pre.setInt(4, iva);
			pre.setFloat(5,prezzoP);
			pre.setInt(6,quantitaP);
			
			pre.executeUpdate();

		} finally {
			try {
				if (pre != null)
					pre.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	
	}
