package controller;
import model.DAOS.*;
import model.beans.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductForOrder
 */
@WebServlet("/ProductForOrder")
public class ProductForOrder extends HttpServlet {
	private static final long serialVersionUID = 10L;
	static ComposizioneModel model=new ComposizioneModelDM();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductForOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		try{
			if(action!=null)
		{
			if(action.equalsIgnoreCase("SearchProductFromOrder"))
			{
				String orderNumber=request.getParameter("ordernumber");
				ArrayList<ProductBean> m= model.doRetrieveAllProductByID(orderNumber);
				request.setAttribute("prodottiperOrdine",m);
				request.setAttribute("id",orderNumber);
				request.setAttribute("data",request.getParameter("data"));
				request.setAttribute("costo",request.getParameter("costo"));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/desideri.jsp");
				dispatcher.forward(request, response);
			}
		}
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