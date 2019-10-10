package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Cart;
import model.beans.CodiceBean;
import model.beans.Preferiti;
import model.beans.ProductBean;
import model.beans.Utente;
import model.DAOS.PreferitiDAO;
import model.DAOS.ProductModelDM;
import model.DAOS.UtenteDAO;

import database.Conn;
import database.Record;
import database.Table;
import model.beans.Preferiti;
import model.beans.ProductBean;
import model.beans.Utente;

@WebServlet("/ServletVariaQuantita")
public class Servletvariaquantita extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
             
             String cod=request.getParameter("codiceVariazione");
             String taglia=request.getParameter("tagliaVariazione");
             String quantit=request.getParameter("quant");
             int quantita=Integer.parseInt(quantit);
             
             Cart c=(Cart) request.getSession().getAttribute("cart");
             
             ProductBean p = dammiProdotto(c,cod,taglia);
             if(p!=null) {
            	 float totPerQuelProdottoVecchio=(p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*p.getQuantitaCarrello();
            	 settaquantita(c,cod,taglia,quantita);
            	 float totPerQuelProdottoNuovo=(p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*quantita;
            	 
            	 c.aggiornaTotaleMeno(totPerQuelProdottoVecchio); //tolgo il precedente costo
            	 c.aggiornaTotale(totPerQuelProdottoNuovo);   //aggiungo il nuovo
            	 float TOTALE= dammiTotale(c);
 				 response.getWriter().println(TOTALE);
             }            
    }
	
	private float dammiTotale(Cart c) {
		float tot=0;
		for(ProductBean p : c.getProducts()) {
			 tot=tot+((p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*p.getQuantitaCarrello());
		 }
		return tot;
	}

	private ProductBean dammiProdotto(Cart c, String cod, String taglia) {
		for(ProductBean p : c.getProducts()) {
			 if(p.getCodice().equalsIgnoreCase(cod)  &&   p.getSize().equalsIgnoreCase(taglia))
                            return p;
		 }
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		   doGet(request,response);
	}
	
	
	private void settaquantita(Cart cart,String cod, String taglia, int quantita) {
		 for(ProductBean p : cart.getProducts()) {
			 if(p.getCodice().equalsIgnoreCase(cod)  &&   p.getSize().equalsIgnoreCase(taglia)) 
                             p.setQuantitaCarrello(quantita);

		 }
	}
}
