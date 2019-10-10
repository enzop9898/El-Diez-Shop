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

import model.DAOS.ProductModel;
import model.DAOS.ProductModelDM;
import model.beans.Cart;
import model.beans.ProductBean;

@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDM usa il DriverManager	

	
	static ProductModel model=new ProductModelDM();
	
	
	public ProductControl() {   
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String brand=request.getParameter("brand");

		/*CARRELLO*/Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}/*CARRELLO*/
		
		String action = request.getParameter("action");

		try {
			if(action!=null) {
				if(action.equalsIgnoreCase("SearchBrand")) {
					
					ArrayList<ProductBean> list=(ProductModelDM.doRetrieveByCond("Brand", brand));
					request.setAttribute("prodotti", list);
					request.setAttribute("marca",brand);
					request.setAttribute("action",action) ;
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					dispatcher.forward(request, response);
				}
				else if(action.equalsIgnoreCase("SearchCategoria")) {
					String categoria=request.getParameter("categoria");
					ArrayList<ProductBean> list=(ProductModelDM.doRetrieveByCond("tipo", categoria));
					request.setAttribute("prodotti", list);
					request.setAttribute("marca",brand);
					request.setAttribute("cat",categoria);
					request.setAttribute("action",action) ;
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					dispatcher.forward(request, response);
				}
/*carrello*/     else if (action.equalsIgnoreCase("addC")) {
	                String cod=request.getParameter("id");
	                String taglia=request.getParameter("taglia");
	                int quantita=Integer.parseInt(request.getParameter("quant"));  //OKKKKK
	                if(!(presentegia(cart,cod,taglia)))
	                {
	                	ProductBean p=ProductModelDM.doRetrieveByKey(cod);
	                	 float aggiunta=(p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*quantita;
	                	 cart.aggiornaTotale(aggiunta);
	                	 
	                	p.setSize(taglia);
	                	p.setQuantitaCarrello(quantita);
	                	cart.addProduct(p);
	                }                             
	                else
	                {
	                	aumentaquantita(cart,cod,taglia,quantita); //dentro verrà aumentato anche il totale
	                }
					request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);
	
					response.sendRedirect("carrello.jsp");
			    }
/*elim. prod. da car*/else if (action.equalsIgnoreCase("deleteC")) {
				String cod=request.getParameter("id");
				String taglia=request.getParameter("taglia");
				
	            cart.deleteProduct(cod,taglia);   //modifica anche il totale
	            
	            request.getSession().setAttribute("cart", cart);
				request.setAttribute("cart", cart);
				
				response.sendRedirect("carrello.jsp");
				}
/*elim. prod. da car*/else if (action.equalsIgnoreCase("deleteAllC")) {
				Cart newCart= new Cart();
				request.getSession().setAttribute("cart", newCart); //carta nuova --> totale=0
				request.setAttribute("cart", newCart);
				
				response.sendRedirect("carrello.jsp");
				}
			//aggiungere qui le altre azione tipo aggiunta di un prodotto al carrello ecct...			
		     } 		
		}
		catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

	private void aumentaquantita(Cart cart,String cod, String taglia, int quantita) {
		 for(ProductBean p : cart.getProducts()) {
			 if(p.getCodice().equalsIgnoreCase(cod)  &&   p.getSize().equalsIgnoreCase(taglia)) {
				              
				 				float aggiunta=(p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*quantita;
				 				cart.aggiornaTotale(aggiunta);
				 
                                p.setQuantitaCarrello(p.getQuantitaCarrello()+quantita);
                              }
		 }
	}

	private boolean presentegia(Cart cart, String cod, String taglia) {
		 for(ProductBean p : cart.getProducts()) {
			 if(p.getCodice().equalsIgnoreCase(cod)  &&   p.getSize().equalsIgnoreCase(taglia))
				            return true;
		 }
		 return false;
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
