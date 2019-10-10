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

import model.DAOS.OrdineModel;
import model.DAOS.OrdineModelDM;
import model.DAOS.ProductModel;
import model.DAOS.ProductModelDM;
import model.beans.OrdineBean;

/**
 * Servlet implementation class ServletPerData
 */
@WebServlet("/ServletPerData")
public class ServletPerData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static OrdineModel model=new OrdineModelDM();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String da=(String)request.getParameter("da");
		String a=(String)request.getParameter("a");
		ArrayList<OrdineBean> result=new ArrayList<OrdineBean>();
		try {
			result=model.doRetriveByData(da, a);
			for(OrdineBean h:result)
			{
				System.out.println(h.getData());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		request.setAttribute("ordini", result);
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/perdata.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
