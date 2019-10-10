package model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.ProductBean;

public interface ComposizioneModel {

	void doSave(String idOrdine, String sizeP, String codiceP, int iva, float prezzoP, int quantitaP)
			throws SQLException;

	ArrayList<ProductBean> doRetrieveAllProductByID(String ID) throws SQLException;
}

