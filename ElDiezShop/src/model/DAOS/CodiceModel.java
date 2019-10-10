package model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.CodiceBean;

public interface CodiceModel {
	public void doSave(CodiceBean cod) throws SQLException;

	public void doUsed(String seq) throws SQLException;
	
	public CodiceBean doRetrieveByKey(String seq) throws SQLException;
}

