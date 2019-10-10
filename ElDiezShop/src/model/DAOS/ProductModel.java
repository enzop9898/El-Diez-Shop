package model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.beans.ProductBean;

public interface ProductModel {
	public void doSave(ProductBean product) throws SQLException;

	public boolean doDelete(String codice) throws SQLException;

	public static ArrayList<ProductBean> doRetrieveByCond(String nome,String valore) throws SQLException {
		return null;
	}
	
	public static ProductBean doRetrieveByKey(String codice) throws SQLException {
		return null;
	}
	
	public void DoUpdate(ProductBean nuovo) throws SQLException;
}
