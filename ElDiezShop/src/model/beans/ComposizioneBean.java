package model.beans;

import java.io.Serializable;

public class ComposizioneBean implements Serializable {

	private String ID,size,CodProd;
	private int IVA,quantit�;
	private float price;
	
	public ComposizioneBean(String iD, String size, String codProd, int iVA, int quantit�, float price) {
		super();
		ID = iD;
		this.size = size;
		CodProd = codProd;
		IVA = iVA;
		this.quantit� = quantit�;
		this.price = price;
	}

	public ComposizioneBean() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCodProd() {
		return CodProd;
	}

	public void setCodProd(String codProd) {
		CodProd = codProd;
	}

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int iVA) {
		IVA = iVA;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
}
