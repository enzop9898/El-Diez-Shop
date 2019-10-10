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
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="STILI/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="STILI/carrelloView.css">
    <script src="carrello.js"></script> 
    <meta charset="UTF-8">
	<title> Carrello </title>
</head>
<body>
<%@ include file="barra.jsp"%>
    
     <div class="container dark-grey-text">

      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-8 mb-4 div1">
        <%  Cart c = (Cart) request.getSession().getAttribute("cart");
            float totale=0;
        %>
    
    
<% 	if(c!=null && c.getProducts().size()>0){
   totale=c.getTotale();
   ArrayList<ProductBean> prodotti = c.getProducts(); 
       for(int i=0;i<prodotti.size();i++){
            ProductBean p= prodotti.get(i);
    	    //totale=totale+((p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto()))*p.getQuantitaCarrello());
   %>
   <br><br>
   <div class="card" id="carta">
       <table class="table table-hover shopping-cart-wrap">
           <thead class="text-muted"  id="tabella">
               <tr id="intestazione">
                     <th scope="col"><%=p.getNome()%>&nbsp&nbsp&nbsp&nbsp   Taglia:&nbsp<%=p.getSize().toUpperCase()%></th>
                      <th scope="col">
                          <form action="ServletVariaQuantita" method="post" onsubmit="return cambiaquantita(this)" name="variazione">
                              <input type="hidden" value="<%=p.getCodice()%>" id="codiceVariazione" name="codiceVariazione">                             
                              <input type="hidden" value="<%=p.getSize()%>" id="tagliaVariazione" name="tagliaVariazione">					  
  							  <input type="number" value="<%=p.getQuantitaCarrello()%>" name="quant" aria-label="Search" min="1" class="form-control" style="width: 60px" id="bordoquantita" onchange="javascript: cambiaquantita(this.form)">                  
                          </form>
                      </th>
               </tr>
           </thead>
           <tbody>
                <tr id="figura">
                   <td>
                       <figure class="media">
                           <div class="img-wrap"><img src="<%=request.getContextPath()+"/foto/"+p.getImg()%>" class="img-thumbnail img-sm" id="fotoprodotto"></div>
                               <figcaption class="media-body">
                                   <dl class="dlist-inline small">
                                         <dt>Codice: </dt>
                                         <dd><%=p.getCodice()%></dd>
                                   </dl>
                                   <dl class="dlist-inline small">
                                         <dt>Brand: </dt>
                                         <dd><%=p.getBrand()%></dd>
                                   </dl>
                               </figcaption>
                       </figure> 
               </td>				
               <td>
                   <div class="price-wrap"> 
                       <var class="price" id="singoloP">Al pezzo: &#8364  <%if(p.getSconto()>0){%><del><%=p.getPrezzoAtt()%></del><%} %>&nbsp&nbsp <%=p.getPrezzoAtt()-(p.getPrezzoAtt()/100*p.getSconto())%></var> 
                   </div> <!-- price-wrap .// -->                   
                   <div class="container">
                      <a href="ProductControl?id=<%=p.getCodice()%>&taglia=<%=p.getSize()%>&action=deleteC"><button type="button" class="btn btn-danger btn-lg float-right" id="elimina">Elimina</button></a> 
                   </div>
               </td>
           </tr>
       </tbody>
   
   </table>	
</div> <!-- card.// -->
<%}} else{		
   %>
       <br>
       <h6 id="noRes">Nessun elemento aggiunto al carrello fino ad ora.</h6>
       <br>
       
   <% } %>
        </div>
        <!--Grid column-->

        <!--Grid column-->
     <% 	if(c!=null && c.getProducts().size()>0){

     %>
        <div class="col-md-4 mb-4">
        <!--<div id="MIODIV">-->
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-12 mx-auto">
                                <div>
    <div class="row">
        <div class="col-md-12 mx-auto">
                <div class="card card-body" id="cartaRiepilogo" onclick="toglierrori()">
                    <h4 class="text-center mb-4">Riepilogo</h4>
                   <a href="ProductControl?action=deleteAllC" id="togliSottolineatura"> <input class="btn btn-lg btn-primary btn-block btn-danger" value="AZZERA" type="button"></a>
                    <hr>
                    
                    <form action="ServletAcquisto" method="post" onsubmit="return ACQUISTA(this)">
                        <h5>Hai un codice promozionale?</h5>
                        <input class="form-control input-lg" placeholder="XYZ-ABC-123" name="codice" value="" type="text" id="codProm" onblur="controllaCodice()">
                        <p id="messaggio"></p>
                        <br>
                        <input type="hidden" value="<%=totale%>" id="totaleInteroCarrello" name="totaleInteroCarrello">
                        <h5 id="TOTALECARRELLO">TOTALE &nbsp&nbsp € &nbsp<%=totale %></h5>
                        <br> 
                        
                        <input class="btn btn-lg btn-primary btn-block btn-dark" id="bottoneAcquisto" value="ACQUISTA" type="submit">
                        <br>
                        <p id="risultato"></p>
                    </form>
                </div>
        </div>
    </div>
</div>
                        </div>
        
        
                    </div>
                    <!--/row-->
        
                </div>
                <!--/col-->
            </div>
            <!--/row-->
        </div>
        <!--/container-->
      <!--</div>--> 
        </div>
        <% } %>
        <!--Grid column-->

      </div>
      <!--Grid row-->
      <hr>
</div>
    

<%@ include file="footer.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
