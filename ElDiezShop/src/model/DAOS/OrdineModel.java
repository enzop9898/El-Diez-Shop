package model.DAOS;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.OrdineBean;

public interface OrdineModel {
	
	
	//funzione che prende un nome utente e caccia i suoi ordini
	public ArrayList<OrdineBean> doRetrieveByUser(String user) throws SQLException;

	void doSave(String id, Date dataoggi, float totale, String username) throws SQLException; 
	
	public ArrayList<OrdineBean> doRetriveByData(String da,String a) throws SQLException;
}

