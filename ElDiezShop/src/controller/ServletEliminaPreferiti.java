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

import controlli.Controlli;
import model.beans.Preferiti;
import model.beans.ProductBean;
import model.beans.Utente;
import model.DAOS.PreferitiDAO;
import model.DAOS.UtenteDAOReg;

@SuppressWarnings("serial")
@WebServlet("/servletEliminaPreferiti")
public class ServletEliminaPreferiti extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ErrorManager em = new ErrorManager();

		Utente ut=(Utente)request.getSession().getAttribute("Utente");
		//ProductBean prod= (ProductBean)request.getParameter("Prodotto");
		//String size = request.getParameter("Size");
		String codice = request.getParameter("Codice");

		
		Preferiti preferiti = null;
		try {
			
			PreferitiDAO.doDelete(ut,codice);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		Preferiti pref = null;
		try {
			System.out.println(codice);
			pref = PreferitiDAO.doRetrieve(ut,codice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ProductBean> prodotti = pref.getProducts();
		
		//Preferiti pref = (Preferiti) session.getAttribute("Preferiti");
		
		request.setAttribute("Preferiti", prodotti);

		//request.setAttribute("prodotti", prodotti);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzazionePreferiti.jsp");
		dispatcher.forward(request, response);
		
		//em.apply(response, "preferiti.jsp");
		
		/*if (u != null) {
			em.done("Registrazione effettuata.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);	
		} else {
			em.message("Registrazione fallita.");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);		
		}*/
		}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ErrorManager em = new ErrorManager();

		Utente ut=(Utente)request.getSession().getAttribute("Utente");
		//ProductBean prod= (ProductBean)request.getParameter("Prodotto");
		//String size = request.getParameter("Size");
		String codice = request.getParameter("Codice");

		
		Preferiti preferiti = null;
		try {
			
			PreferitiDAO.doSave(ut,"L",codice);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		Preferiti pref = null;
		try {
			pref = PreferitiDAO.doRetrieve(ut,codice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ProductBean> prodotti = pref.getProducts();
		
		//Preferiti pref = (Preferiti) session.getAttribute("Preferiti");
		
		request.getSession().setAttribute("Preferiti", prodotti);

		//request.setAttribute("prodotti", prodotti);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VisualizzazionePreferiti.jsp");
		dispatcher.forward(request, response);
		
		//em.apply(response, "preferiti.jsp");
		
		/*if (u != null) {
			em.done("Registrazione effettuata.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);	
		} else {
			em.message("Registrazione fallita.");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);		
		}*/
		}
	}



