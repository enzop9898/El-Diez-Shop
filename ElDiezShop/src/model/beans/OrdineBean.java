package model.beans;

import java.io.Serializable;

public class OrdineBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ID,Username;
	private float costoTot;
	private String data;
	
	public OrdineBean() {
		ID="";
		Username="";
		costoTot=0;
		data=null;
	}

	public OrdineBean(String iD, String username, int costoTot, String data) {
		super();
		ID = iD;
		Username = username;
		this.costoTot = costoTot;
		this.data = data;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setCostoTot(float costoTot) {
		this.costoTot = costoTot;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getID() {
		return ID;
	}

	public String getUsername() {
		return Username;
	}

	public float getCostoTot() {
		return costoTot;
	}

	public String getData() {
		return data;
	}
	
}