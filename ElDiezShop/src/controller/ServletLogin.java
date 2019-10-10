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

@SuppressWarnings("serial")
@WebServlet("/servletLogin")
public class ServletLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usr = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();

		ErrorManager em = new ErrorManager();

		Utente u = UtenteDAO.doRetrieve(usr,pwd);
		
        if(u!=null && u.getTipo().equalsIgnoreCase("ADMIN")) {
        	HttpSession session = request.getSession();                  
			session.setMaxInactiveInterval(60*60*24);
			                                               
			/*UtenteDAO search=new UtenteDAO();
			ArrayList <Utente> result	= new ArrayList <Utente>();
			result=search.doRetrieveAll();
			
			request.setAttribute("listaUtenti", result);
			
			ProductModelDM search2 = new ProductModelDM();
			ArrayList <ProductBean> result2	= new ArrayList <ProductBean>();
			try {
				result2=search2.doRetrieveTuttiPROPRIOTUTTI();
			} catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
			
			request.setAttribute("listaProdotti", result2);*/
			
			session = request.getSession();
			session.setAttribute("Utente", u);
			
			response.sendRedirect("index.jsp");
        }
        else {
		
		if (u != null) {
			em.done("Login effettuato.");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*60*24);
			Preferiti pref = null;
			

			
			//Charts car = session.getAttribute(carrello);
			//session.invalidate();
			session = request.getSession();
			session.setAttribute("Utente", u);
			response.sendRedirect("index.jsp");
			return;
			//em.redirect("index.jsp");
		} else {
			em.message("Login fallito.");
		}

		response.sendRedirect("login.jsp");
	}
	}
}
