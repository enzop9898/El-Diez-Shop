package model.beans;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String size,codice,nostalgia,brand,descrizione,img,tipo,nome;
    private int sconto,pezzi,ivaAtt,quantitacarrello;
    private float prezzoAtt;

	public ProductBean() {
		size="";
		codice = "";
		nostalgia="";
		brand="";
		descrizione = "";
		img="";
		tipo="";
		nome = "";
		sconto=0;
		pezzi = 0;
		prezzoAtt=0;
		ivaAtt=0;
		quantitacarrello=0;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNostalgia() {
		return nostalgia;
	}

	public void setNostalgia(String nostalgia) {
		this.nostalgia = nostalgia;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public int getPezzi() {
		return pezzi;
	}

	public void setPezzi(int pezzi) {
		this.pezzi = pezzi;
	}

	public int getQuantitaCarrello() {
		return quantitacarrello;
	}

	public void setQuantitaCarrello(int pezzi) {
		this.quantitacarrello = pezzi;
	}
	
	public float getPrezzoAtt() {
		return prezzoAtt;
	}

	public void setPrezzoAtt(float prezzoAtt) {
		this.prezzoAtt = prezzoAtt;
	}

	public int getIvaAtt() {
		return ivaAtt;
	}

	public void setIvaAtt(int ivaAtt) {
		this.ivaAtt = ivaAtt;
	}
	
}
