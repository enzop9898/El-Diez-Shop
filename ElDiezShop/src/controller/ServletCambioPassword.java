package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Utente;
import model.DAOS.UtenteDAO;
import model.DAOS.UtenteDAOCambioPass;


@SuppressWarnings("serial")
@WebServlet("/servletCambioPassword")
public class ServletCambioPassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pwdV = request.getParameter("passwordVecchia").trim();
		String pwdN = request.getParameter("passwordNuova").trim();
		Utente ut=(Utente)request.getSession().getAttribute("Utente");

		ErrorManager em = new ErrorManager();
		if(pwdV.equals(ut.getPassword()))
		{
			ut.setPassword(pwdN);
			
			try {
//cambia nel db
				ut = UtenteDAOCambioPass.doRetrieve(ut.getUsername(),ut.getPassword(),ut.getNome(),ut.getCognome(),ut.getTipo(),ut.getEmail());
			} catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
			
			if((ut!=null))
			{
				response.getWriter().println("Password cambiata con successo.");
			}
			else 
			{
				response.getWriter().println("Impossibile cambiare la password, hai sbagliato l'attuale.");
			}
		}
		else 
		{
			response.getWriter().println("Impossibile cambiare la password, hai sbagliato l'attuale.");
		}
	  }
}