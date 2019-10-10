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

@WebServlet("/AltreRicerche")
public class AltreRicerche extends HttpServlet {
	private static final long serialVersionUID = 7L;

	ProductModel model=new ProductModelDM();
	
	
	public AltreRicerche() {   
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

		if(action!=null) {
			if(action.equalsIgnoreCase("SearchNostalgia")) {						
				ArrayList<ProductBean> list=new ArrayList<ProductBean>();
				try {
					list = (ProductModelDM.doRetrieveByCond("Nostalgia", "si"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("prodotti", list);
				request.setAttribute("action",action) ;
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
				dispatcher.forward(request, response);
			}
			else if(action.equalsIgnoreCase("SearchSales")) {
				ArrayList<ProductBean> ls=new ArrayList<ProductBean>();
				try {
					ls = (ProductModelDM.doRetrieveTutti());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ArrayList<ProductBean>  list=new ArrayList<ProductBean>();
				   for(ProductBean p : ls) {
					  if(p.getSconto()>0) {
						        list.add(p);
					  }
				   }
				request.setAttribute("prodotti", list);
				request.setAttribute("action",action) ;
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
				dispatcher.forward(request, response);
			}
             else if(action.equalsIgnoreCase("SearchNome")) {
				ArrayList<ProductBean> l=new ArrayList<ProductBean>();
				try {
					l = (ProductModelDM.doRetrieveTutti());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String daCercare=(String) request.getParameter("daCercare");
				ArrayList<ProductBean>  list=new ArrayList<ProductBean>();
				if(daCercare!=null && !(daCercare.equalsIgnoreCase(""))) {
					for(ProductBean p : l) {
						if(containsIgnoreCase(p.getNome(),daCercare)) {
						//if(p.getNome().contains(daCercare)  ||   p.getNome().contains(daCercare.toUpperCase())   ) {
			                  list.add(p);
			             }
			        }
	            }
			request.setAttribute("action",action) ;
			request.setAttribute("prodotti", list);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
			dispatcher.forward(request, response);
            }
		}

	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static boolean containsIgnoreCase(String str, String searchStr)     {
	    if(str == null || searchStr == null) return false;

	    final int length = searchStr.length();
	    if (length == 0)
	        return true;

	    for (int i = str.length() - length; i >= 0; i--) {
	        if (str.regionMatches(true, i, searchStr, 0, length))
	            return true;
	    }
	    return false;
	}
	
}
