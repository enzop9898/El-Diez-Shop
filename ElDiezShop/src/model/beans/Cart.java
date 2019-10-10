package model.beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private ArrayList<ProductBean> products;
	private float totale;
	
	public Cart() {
		products = new ArrayList<ProductBean>();
		totale=0;
	}
	
	public void addProduct(ProductBean product) {  //il chiamante aggiorna il totale
		products.add(product);
	}
	
	public void deleteProduct(String cod,String size) {
		int i=0;
		for(ProductBean prod : products) {
			if( prod.getCodice().equalsIgnoreCase(cod) && prod.getSize().equalsIgnoreCase(size)  ) {
				    float togliere= (prod.getPrezzoAtt()-(prod.getPrezzoAtt()/100*prod.getSconto()))*prod.getQuantitaCarrello();
				    this.aggiornaTotaleMeno(togliere);
           	 		products.remove(i);
           	 		break;
			}
		i++;
		}
 	}
	
	public ArrayList<ProductBean> getProducts() {
		return  products;
	}
	
	public float getTotale() {
		return  totale;
	}
	
	public void setTotale(float tot) {
		totale=tot;
	}
	
	public void aggiornaTotale(float som) {
		this.totale=this.totale+som;
	}
	
	public void aggiornaTotaleMeno(float som) {
		this.totale=this.totale-som;
	}
}

