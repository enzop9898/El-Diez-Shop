package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOS.ProductModel;
import model.DAOS.ProductModelDM;
import model.beans.ProductBean;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductModel model=new ProductModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBean bean=new ProductBean();
		System.out.println(request.getParameter("codice"));
		bean.setCodice((String)request.getParameter("codice"));
		bean.setSize("X");
		bean.setNostalgia((String)request.getParameter("nostalgia"));
		bean.setSconto(Integer.parseInt((String)request.getParameter("sconto")));
		bean.setBrand((String)request.getParameter("brand"));
		bean.setPrezzoAtt(Float.parseFloat((String)request.getParameter("prezzo")));
		bean.setIvaAtt(Integer.parseInt((String)request.getParameter("iva")));
		bean.setDescrizione((String)request.getParameter("descrizione"));
		bean.setPezzi(Integer.parseInt((String)request.getParameter("pezzi")));
		bean.setImg((String)request.getParameter("immagine"));
		bean.setTipo((String)request.getParameter("tipo"));
		bean.setNome((String)request.getParameter("nome"));
		System.out.println(request.getParameter("sconto"));
		try {
			model.doSave(bean);
			if(bean.getTipo().equalsIgnoreCase("scarpette")) {
				bean.setSize("41");
				model.doSave(bean);
				bean.setSize("42");
				model.doSave(bean);
				bean.setSize("43");
				model.doSave(bean);
			}
			else
			{
				bean.setSize("S");
				model.doSave(bean);
				bean.setSize("M");
				model.doSave(bean);
				bean.setSize("L");
				model.doSave(bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			System.out.println(e.getMessage());
			request.setAttribute("add","Aggiunta fallita,qualcosa è andato storto!");
		}
		request.setAttribute("add","Aggiunta prodotto al Catalogo avvenuta con successo!");
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/aggiunta.jsp");
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
