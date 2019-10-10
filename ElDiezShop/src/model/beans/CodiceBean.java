package model.beans;

import java.io.Serializable;

public class CodiceBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sequenza,usato;
	private int sconto;
	
	public CodiceBean() {
		sequenza="";
		usato="";
		sconto=0;
	}

	public String getSequenza() {
		return sequenza;
	}

	public void setSequenza(String sequenza) {
		this.sequenza = sequenza;
	}

	public String getUsato() {
		return usato;
	}

	public void setUsato(String usato) {
		this.usato = usato;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
}
