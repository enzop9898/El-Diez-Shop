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

import model.beans.*;
import model.DAOS.*;
import controller.*;

/**
 * Servlet implementation class HisOrder
 */
@WebServlet("/HisOrder")
public class HisOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static OrdineModel model = new OrdineModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HisOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("utente");
		ArrayList<OrdineBean> listor=new ArrayList<OrdineBean>();
		try {
			listor = (model.doRetrieveByUser(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("order", listor);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ordiniPerUtenteAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
