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
    <link rel="stylesheet" type="text/css" href="STILI/articoloSpecifico.css">
    <script src="catalogo.js"></script> 
    <meta charset="UTF-8">
	<title>Dettagli Prodotto</title>
</head>
<body>
<%@ include file="barra.jsp"%>
   <%ProductBean p=(ProductBean)request.getAttribute("prodotto");
     ArrayList<ProductBean> simili = (ArrayList<ProductBean>) request.getAttribute("prodotti");
   %>
   
   <!--Main layout-->
  <main class="mt-0 pt-0">
    <div class="container dark-grey-text mt-5">

      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-4 mb-4 div1">
          <h1 id="titl"><%=p.getNome()%></h1><br>
          <div id="muu">
          <img src="<%=request.getContextPath()+"/foto/"+p.getImg()%>" class="img-fluid" alt="">
          </div>
        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-md-8 mb-4">

          <!--Content-->
          <div class="p-4">

            <div class="mb-3">
                <span class="badge badge-secondary" id="cat"><%=p.getTipo()%></span>
                <span class="badge badge-secondary" id="br"><%=p.getBrand()%></span>
                <%if(p.getNostalgia().equalsIgnoreCase("si")){ %>
                          <span class="badge badge-secondary" id="nost">Nostalgia</span>
                <%} %>
                <%if(p.getSconto()!=0){ %>
                          <span class="badge badge-secondary" id="sal">Sales %<%=p.getSconto()%></span>
                <%} %>
            </div>

            <p class="lead">
            <%if(p.getSconto()!=0){ %>
                   <span class="mr-1" id="prezzofinto">
                   <del>€<%=p.getPrezzoAtt()%></del>
                   </span>
            <%} %>
              <span id="prezzovero">€<%=p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto())%></span>
            </p>

            <p class="font-weight-bold">Descrizione</p>

            <p><%=p.getDescrizione()%></p>
            <br>
            <h3><p>-<%=p.getCodice()%></p></h3>
            <br>
            <form action="ProductControl" method="get" onsubmit="return controlloTaglia()">
              <div class="d-flex justify-content-left">
                  <p id="selezionataglie">Selezione taglia:</p>
                  <button type="button" class="btn btn-dark taglie" id="b1" onclick="cambioTagliaS()">S</button>
                  <button type="button" class="btn btn-dark taglie" id="b2" onclick="cambioTagliaM()">M</button>
                  <button type="button" class="btn btn-dark taglie" id="b3" onclick="cambioTagliaL()">L</button>
                  <p id="errore"></p>
                  <p id="flag"></p> <br><br>
                  
				  <input type="hidden" name="action" value="addC" />

				  <input type="hidden" name="id" value="<%=p.getCodice()%>" />

				  <input type="hidden" id="tagl" name="taglia" value="" />


              </div> 
              <br>
                                <p> <b>Non sei sicuro della taglia giusta per te? </b> <br> Tranquillo,abbiamo pensato anche a quello,visita la nostra <a href="taglia home.html">Tabella delle Taglie</a> </p>
              
              <br>
              <div class="d-flex justify-content-left">
              <input type="number" value="1" aria-label="Search" min="1" class="form-control" style="width: 60px" id="bordoquantita" name="quant">
              <button type="submit" class="btn btn-danger" id="carrell">Aggiungi al carrello  &nbsp&nbsp<img src="foto/carrello.PNG"></button>
              </div>
            </form>
          </div>
          <!--Content-->

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->

      <hr>

        
          <h4 class="my-4 h4">Prodotti Simili</h4>
          
          <%
		if (simili != null && simili.size() != 0) 
		{
			
		%><p>Abbiamo selezionato per te dei prodotti che potrebbero interessarti,se ti fa piacere dagli un'occhiata.

          </p>
        <div class="container">
		<div class="row">	
          
        <%
		int i=0;
		for(ProductBean pr : simili){ if(i==3) break; %>
		<div class = "col-md-4" id="cardColumn">
       	<form id="ViewForm" method="get" action="###dove voglio andare">
        	<div id="cardProdotti" class="card">
          		<a href="servletProdotto?Codice=<%=pr.getCodice() %>"><div id="picc">
          		    <%if(pr.getSconto()>0){ %>
          		    <h4><span class="badge badge-secondary" id="SALE"><h5 id="saletesto">Sale</h5></span></h4>
          		    <%} %>
          			<img id="prodottoPic" src="<%=request.getContextPath()+"/foto/"+pr.getImg()%>" class="card-img-top img-responsive" alt="...">
          		</div>
          		</a>
			
			<div class="card-body" id="cards">
			  <h5 class="card-title"><%=pr.getNome()%></h5>
			    <%if(pr.getSconto()>0){%>
			  	<div class="card-bottom">
			  		<h4><del id="cancellato">&#8364 <%=pr.getPrezzoAtt()%></del></h4><h3>&#8364 <%=pr.getPrezzoAtt()-(pr.getPrezzoAtt()/100*pr.getSconto())%></h3>
			 		 <hr>
			  		<a href="servletPreferiti?Codice=<%=pr.getCodice() %>" class="btn btn-primary mybutton btn-danger">Aggiungi ai preferiti</a>
			  	</div>
			  	<%}else{ %>
			  	<div class="card-bottom">
			  		<h3>&#8364 <%=pr.getPrezzoAtt()%></h3>
			 		 <hr>
			  		<a href="servletPreferiti?Codice=<%=pr.getCodice() %>" class="btn btn-primary mybutton btn-danger">Aggiungi ai preferiti</a>
			  	</div>
			  	<%} %>
			</div>
		    </div>
		 </form>
        </div>
			
		<%i++;
		} %> 
		</div></div>
		<%} %>
       <br>
        <hr>
  </main>
  <!--Main layout-->
  
  

<%@ include file="footer.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>