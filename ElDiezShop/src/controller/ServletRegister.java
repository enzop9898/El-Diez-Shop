package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlli.Controlli;
import model.beans.Utente;
import model.DAOS.UtenteDAOReg;

@SuppressWarnings("serial")
@WebServlet("/servletRegister")
public class ServletRegister extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ErrorManager em = new ErrorManager();

	
		String usr = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		String pwd2 = request.getParameter("password2").trim();
		String nome = request.getParameter("nome").trim();
		String cognome = request.getParameter("cognome").trim();
		String email = request.getParameter("email").trim();
		String tipo = "Utente";
		
		
		
		Utente u = null;
		try {
			u = UtenteDAOReg.doSave(usr,pwd,nome,cognome,tipo,email);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		if (u != null) {
			response.getWriter().println("successo");
		} else {
			response.getWriter().println("REGISTRAZIONE NON EFFETTUATA: email e username gia presente");
		}


	}

}