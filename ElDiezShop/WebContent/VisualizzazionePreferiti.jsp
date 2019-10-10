<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="model.DAOS.*"%>
<%@page import="model.beans.*"%>
<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>


<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.DAOS.*"%>

<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
<!--  <link rel="stylesheet" type="text/css" href="STILI/bootstrap.min.css">-->
    <link rel="stylesheet" type="text/css" href="STILI/articolo.css">
    <meta charset="UTF-8">
	<title>PRODOTTI PREFERITI DI<%Utente ut=(Utente)session.getAttribute("Utente");
	out.println(ut.getNome().toUpperCase());%></title>
</head>

<body>
<%@ include file="barra.jsp"%>
    
     <% ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("Preferiti"); 
     %>
    
    <br>
    <h1 align="center">PRODOTTI PREFERITI DI <%
				Utente ute=(Utente)session.getAttribute("Utente");
	out.println(ute.getNome().toUpperCase());
			%>
</h1><br>
	<
    
     <div class="container">
		<div class="row">	
<%	if (products != null && products.size() != 0) 
		{
			 
		for(ProductBean p : products){ %>
		
		<div class = "col-md-4" id="cardColumn">
       	<form id="ViewForm" method="get" action="###dove voglio andare">
        	<div id="cardProdotti" class="card">
        	<a href="servletProdotto?Codice=<%=p.getCodice() %>"><div id="picc">
        	<%if(p.getSconto()>0){ %>
          		    <h4><span class="badge badge-secondary" id="SALE"><h5 id="saletesto">Sale</h5></span></h4>
          		    <%} %>
          			<img id="prodottoPic" src="<%=request.getContextPath()+"/foto/"+p.getImg()%>" class="card-img-top img-responsive" alt="...">
          		</div>
			</a>
			
			  <div class="card-body" id="cards">
			  <h5 class="card-title"><%=p.getNome()%></h5>
			    <%if(p.getSconto()>0){%>
			  	<div class="card-bottom">
			  		<h4><del id="cancellato">&#8364 <%=p.getPrezzoAtt()%></del></h4><h3>&#8364 <%=p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto())%></h3>
			 		 <hr>
                     <input type="hidden" id="hidden" name="vedi" value=<%=p.getCodice()%>>
                   	<a href="servletEliminaPreferiti?Codice=<%=p.getCodice() %>" class="btn btn-primary mybutton btn-danger">Elimina dai preferiti</a>
			  	</div>
			  	<%}else{ %>
			  	<div class="card-bottom">
			  		<h3>&#8364 <%=p.getPrezzoAtt()%></h3>
			 		 <hr>
                     <input type="hidden" id="hidden" name="vedi" value=<%=p.getCodice()%>>
                   	<a href="servletEliminaPreferiti?Codice=<%=p.getCodice() %>" class="btn btn-primary mybutton btn-danger">Elimina dai preferiti</a>
			  	</div>
			  	<%} %>
			</div>
			
		    </div>
		 </form>
        </div>
        

			
		<%}%>
	<%} %>	
		

 		
 	    </div>
 	    <br><br>
 	    <hr>
</div>
     

<%@ include file="footer.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



































