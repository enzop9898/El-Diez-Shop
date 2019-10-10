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

@WebServlet("/servletProdotto")
public class servletProdotto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		ProductBean prod=null;
		ArrayList<ProductBean> simili=null;
		int i;
		
		try {
			String codice=request.getParameter("Codice");
			prod= ProductModelDM.doRetrieveByKey(codice);
			String categoria=prod.getTipo();
			simili=(ArrayList<ProductBean>) ProductModelDM.doRetrieveByCond("tipo", categoria);
			
			for(i=0;i<simili.size();i++){
				if(simili.get(i).getCodice().equalsIgnoreCase(codice))
					                 simili.remove(i);
			}
		}		
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		request.setAttribute("prodotto", prod);
		request.setAttribute("prodotti", simili);
		
		
		if(prod.getTipo().equalsIgnoreCase("scarpette")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/singoloProdottoScarpette.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/singoloProdotto.jsp");
			dispatcher.forward(request, response);
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        ProductBean prod=null;
		
		try {
			String codice=request.getParameter("Codice");
			prod= ProductModelDM.doRetrieveByKey(codice);		
		}		
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		request.setAttribute("prodotto", prod);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/singoloProdotto.jsp");
		dispatcher.forward(request, response);
    }
}
