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

import model.DAOS.ComposizioneModel;
import model.DAOS.ComposizioneModelDM;
import model.DAOS.ProductModel;
import model.DAOS.ProductModelDM;
import model.beans.ProductBean;

/**
 * Servlet implementation class amministratore
 */
@WebServlet("/amministratore")
public class amministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel model=new ProductModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public amministratore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		System.out.println(action);
		
		try{
			if(action!=null)
		{
			if(action.equalsIgnoreCase("DeleteProduct"))
			{
				String codice=request.getParameter("codice");
				boolean el=model.doDelete(codice);
				System.out.println(codice);
					request.setAttribute("done","Elemento correttamente rimosso dal catalogo!");
			}
		}
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/rim.jsp");
			dis.forward(request, response);
	}
		
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
