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
 * Servlet implementation class OrdineControl
 */
@WebServlet("/OrdineControl")
public class OrdineControl extends HttpServlet {
	static OrdineModel model = new OrdineModelDM();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdineControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				if (action != null) {
					if (action.equalsIgnoreCase("AllOrderFromUser")) {
						Utente ut = (Utente) session.getAttribute("Utente");
						if (ut != null) {
							String user = ut.getUsername();
							ArrayList<OrdineBean> listor = (model.doRetrieveByUser(user));
							request.setAttribute("order", listor);
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UserArea.jsp");
							dispatcher.forward(request, response);
						}
					} /*
						 * else if(action.equalsIgnoreCase("SearchCategoria")) { String
						 * categoria=request.getParameter("categoria"); ArrayList<ProductBean>
						 * list=(model.doRetrieveByCond("tipo", categoria));
						 * request.setAttribute("prodotti", list);
						 * 
						 * RequestDispatcher dispatcher =
						 * getServletContext().getRequestDispatcher("/ProductView.jsp");
						 * dispatcher.forward(request, response); } else if
						 * (action.equalsIgnoreCase("addC")) { String cod=request.getParameter("id");
						 * cart.addProduct(model.doRetrieveByKey(cod));
						 * request.getSession().setAttribute("cart", cart); request.setAttribute("cart",
						 * cart); RequestDispatcher dispatcher =
						 * getServletContext().getRequestDispatcher("/ProductView.jsp");
						 * dispatcher.forward(request, response); } /else if
						 * (action.equalsIgnoreCase("deleteC")) { String cod=request.getParameter("id");
						 * cart.deleteProduct(model.doRetrieveByKey(cod));
						 * request.getSession().setAttribute("cart", cart); request.setAttribute("cart",
						 * cart); RequestDispatcher dispatcher =
						 * getServletContext().getRequestDispatcher("/ProductView.jsp");
						 * dispatcher.forward(request, response); } else if
						 * (action.equalsIgnoreCase("deleteAllC")) { Cart newCart= new Cart();
						 * request.getSession().setAttribute("cart", newCart);
						 * request.setAttribute("cart", newCart); RequestDispatcher dispatcher =
						 * getServletContext().getRequestDispatcher("/ProductView.jsp");
						 * dispatcher.forward(request, response);/*fine elim. prod. da car
						 */
				}
				// aggiungere qui le altre azione tipo aggiunta di un prodotto al carrello
				// ecct...

			} catch (SQLException e) {
				System.out.println("Error:" + e.getMessage());
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}