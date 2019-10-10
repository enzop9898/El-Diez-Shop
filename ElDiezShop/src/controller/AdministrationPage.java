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

import model.DAOS.ProductModelDM;
import model.DAOS.UtenteDAO;
import model.beans.ProductBean;
import model.beans.Utente;

/**
 * Servlet implementation class AdministrationPage
 */
@WebServlet("/AdministrationPage")
public class AdministrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtenteDAO search=new UtenteDAO();
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
		
		request.setAttribute("listaProdotti", result2);
		RequestDispatcher disp=request.getRequestDispatcher("/amministratore.jsp");
		disp.forward(request, response);
    }
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
