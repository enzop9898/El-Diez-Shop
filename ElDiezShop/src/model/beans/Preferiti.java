package model.beans;

import java.util.ArrayList;
import java.util.List;

public class Preferiti {

	private ArrayList<ProductBean> products;
	private Utente utente;
	
	public Preferiti() {
		products = new ArrayList<ProductBean>();
		utente = new Utente();
	}
	
	public void addProduct(ProductBean product) {
		products.add(product);
	}
	
	public void deleteProduct(ProductBean product) {
		for(ProductBean prod : products) {
			if(  prod.getCodice().equalsIgnoreCase(product.getCodice())  ) {
				products.remove(prod);
				break;
			}
		}
 	}
	
	public ArrayList<ProductBean> getProducts() {
		return  products;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setProducts(ArrayList<ProductBean> products) {
		this.products = products;
	}
	
	
}

