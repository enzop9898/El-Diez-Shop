package controller;   

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//import com.google.gson.Gson;

import model.DAOS.CodiceModel;
import model.DAOS.CodiceModelDM;
import model.beans.CodiceBean;


@WebServlet("/ServletControllaCodice")
public class CodiceControl extends HttpServlet {
	private static final long serialVersionUID = 2L;

	// usa il DriverManager	
	
	static CodiceModel model=new CodiceModelDM();
	
	
	public CodiceControl() { 
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String frase=null;
		int sconto=0;;

		String codSconto = request.getParameter("codSconto");

		try {
			CodiceBean cod =model.doRetrieveByKey(codSconto);
			if(cod.getSequenza().equalsIgnoreCase(""))
			{
				response.getWriter().println("INESISTENTE");
			}
			else if(cod.getUsato().equalsIgnoreCase("si")){
				response.getWriter().println("USATO");
			}
			else {
				Gson gson = new Gson();
		        String strJson = gson.toJson(cod);
		        System.out.println(strJson);
		        response.getWriter().println(strJson);
		        //NON CAMBIO TOTALE CARRELLO PERCHE NON è DETTO CHE L ACQUISTO VADA A NUON FINE
			}
		}	
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

