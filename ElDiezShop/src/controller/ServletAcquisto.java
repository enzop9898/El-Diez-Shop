package controller;   

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

import model.DAOS.CodiceModel;
import model.DAOS.CodiceModelDM;
import model.DAOS.ComposizioneModelDM;
import model.DAOS.OrdineModelDM;
import model.DAOS.ProductModel;
import model.DAOS.ProductModelDM;
import model.beans.Cart;
import model.beans.CodiceBean;
import model.beans.ProductBean;
import model.beans.Utente;


@WebServlet("/ServletAcquisto")
public class ServletAcquisto extends HttpServlet {
	
	Random generator=new Random();
	int casuale=generator.nextInt(100);
	int casuale2=generator.nextInt(100);
	int casuale3=generator.nextInt(100);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Utente ute=(Utente)request.getSession().getAttribute("Utente");
		if(ute==null)
		{
			response.getWriter().println("NOLOGIN");
		}
		else
		{
		
		Cart c=(Cart) request.getSession().getAttribute("cart");
		ProductBean p = null;
		try {
			p = verifica(c);               //verifica che i prodotti nel carrello siano disponibili in magazzino
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		if(p==null) {    //tutto apposto
			String codS=request.getParameter("codice");
			if(codS!=null) {
				try {
					CodiceModelDM model=new CodiceModelDM();
					CodiceBean cod =model.doRetrieveByKey(codS);
					if(!(cod.getSequenza().equalsIgnoreCase(""))  &&  !(cod.getUsato().equalsIgnoreCase("si")) )
					{
						int sconto=cod.getSconto();
						c.setTotale(c.getTotale()-(c.getTotale()/100*sconto));
						/*setto a true l attributo usato di questo codice sconto*/
						      CodiceModelDM cm=new CodiceModelDM();
						      cm.settaUsato(cod.getSequenza());
						/*FINE*/
					}
				}		
				catch (SQLException e) {
					System.out.println("Error:" + e.getMessage());
				}                    
			}
			
			
			Utente ut= (Utente) request.getSession().getAttribute("Utente");
			try {
				acquista(c,ut);
				Cart newC = new Cart();                        
			    request.getSession().removeAttribute("cart");							//AZZERAMENTO CARRELLO
				request.getSession().setAttribute("cart", newC);
			} catch (SQLException e) {
				e.printStackTrace();
			}  //FARE
			response.getWriter().println("Acquisto effettuato con successo");
			
		}
		else {   //in p ho il primo productBean di cui non ho abbastanza taglie
			response.getWriter().println("ERRORE: in magazzino abbiamo solo "+p.getPezzi()+" pezzi di "+p.getNome()+" di taglia "+p.getSize());
		}
		
		}
	}

	private void acquista(Cart c,Utente ut) throws SQLException {
		/*INSERIMENTO ORDINE*/
		  GregorianCalendar gc = new GregorianCalendar();

	   		int ggoggi= gc.get(Calendar.DAY_OF_MONTH);
	   		int mmoggi= gc.get(Calendar.MONTH);
	   		int aaoggi = gc.get(Calendar.YEAR)-1900;
	   		
	   		Date dataoggi = new Date(aaoggi,mmoggi,ggoggi);
	   		
	   		float tot=c.getTotale();   //gia è stato abbassato in caso di sconti
	   		
	   		
	   		//seq statica e univoca la trasformo in stringa
	   		String s=""+casuale+casuale2+casuale3;
	   		
	   		OrdineModelDM m=new OrdineModelDM();
	   		m.doSave(s, dataoggi, tot, ut.getUsername());
	   		
	   		casuale++;casuale2++;casuale3++;
	   	 /*FINE INSERIMENTO ORDINE*/
	   	 
	   	 /*INSERIMENTO COMPOSIZIONI*/
	   		ComposizioneModelDM compModel=new ComposizioneModelDM();
	   		for(ProductBean p: c.getProducts()) {
	   			compModel.doSave(s, p.getSize(), p.getCodice(), 22, p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()), p.getQuantitaCarrello());
	   		}
	   	 /*FINE INSERIMENTO COMPOSIZIONI*/
	   		
	   	 /*AGGIORNAMENTO QUANTITA PRODOTTI*/
	   		ProductModelDM prodModel=new ProductModelDM();
	   		for(ProductBean p: c.getProducts()) {
	   			ProductBean prod=ProductModelDM.doRetrieveByCODICEeTAGLIA(p.getCodice(), p.getSize());
	   			System.out.println(prod.getPezzi());
	   			System.out.println(p.getQuantitaCarrello());
	   			ProductModelDM.aggiornaQuantita(prod.getCodice(), prod.getSize(), prod.getPezzi(), p.getQuantitaCarrello());
	   		}
	   	 /*FINE AGGIORNAMENTO QUANTITA PRODOTTO*/
	}

	private ProductBean verifica(Cart c) throws SQLException {
		ProductBean prod=null;
		
		ProductModelDM model=new ProductModelDM();
		
		for(ProductBean p: c.getProducts()) {
			prod=ProductModelDM.doRetrieveByCODICEeTAGLIA(p.getCodice(),p.getSize()); //prod è quello nel DB BUONO ATTUALISSIMO
			if(p.getQuantitaCarrello()>prod.getPezzi())
				         return prod;
		} 	    
		return null;        //va tutto bene
	}
}



