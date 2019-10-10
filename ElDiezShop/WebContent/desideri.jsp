<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<%@	page import = "java.util.ArrayList" %>
<%@	page import = "java.util.Collection" %>
<%@	page import = "java.util.Iterator" %>
	<%ArrayList<ProductBean> lista = (ArrayList<ProductBean>) request.getAttribute("prodottiperOrdine");
	Utente ut=(Utente)session.getAttribute("Utente");
	String number=(String)request.getAttribute("id");
	String data=(String)request.getAttribute("data");
	float costo=Float.parseFloat((String)request.getAttribute("costo"));%>
<!DOCTYPE html>
<html >
<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta charset="UTF-8">
    
    
    <title>Ordine</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="STILI/carrelloView.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>

 	<%@ include file="barra.jsp" %>
 	<div class="container dark-grey-text">

      <!--Grid row-->
      <div class="row wow fadeIn">

        <!--Grid column-->
        <div class="col-md-12 mb-12 div1">         
	<%float tot=0;
	float iva=0;%>
<% 	if(lista.size()>0){
		for(int i=0;i<lista.size();i++){
	 		ProductBean p= lista.get(i);
	 		tot+=p.getPrezzoAtt()*p.getQuantitaCarrello();
	 		iva=iva+p.getIvaAtt();
	 		
	%>
                   <br><br>       
                   
   <div class="card" id="carta">
       <table class="table table-hover shopping-cart-wrap">
           <thead class="text-muted"  id="tabella">
               <tr id="intestazione">
                     <th scope="col"><%=p.getNome()%>&nbsp&nbsp&nbsp&nbsp   Taglia:&nbsp<%=p.getSize().toUpperCase()%>&nbsp&nbsp&nbsp&nbsp   Quantita:&nbsp<%=p.getQuantitaCarrello() %></th>
                     <th scope="col"></th>
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
                       <var class="price" id="singoloP">Costo: &#8364 <%=p.getPrezzoAtt()*p.getQuantitaCarrello() %></var> 
                   </div> <!-- price-wrap .// -->                   
               </td>
           </tr>
       </tbody>
   
   </table>	
</div> <!-- card.// -->   
<%}} else{		
	%>
		
		<h6 id="noRes">Nessun elemento negli ordini.</h6>
		
		
	
<%}%>
                    <br><br>
					<td style=" display: flex;
    justify-content: right;">
						<figure class="media">
								<figcaption>
									<h6 class="title text-truncate" style = "font-weight:bold; ">RIEPILOGO ORDINE</h6>
									<dl class="dlist-inline small">
									    <%if(costo==tot){ %>
			  							<dt>Totale ordine: </dt>
			  							<dd>€ <%=costo%></dd>
			  							<%} else{%>
			  							<dt>Totale ordine: </dt>
			  							<del><dd>€ <%=tot%></dd></del>
			  							<dd>€ <%=costo%>&nbsp&nbsp (Utilizzati buoni sconto)</dd>
			  							<%} %>
									</dl>
									<dl class="dlist-inline small">
			  							<dt>Iva ordine: </dt>
			  							<dd><%=iva/lista.size() %> %</dd>
									</dl>
									<%session.setAttribute("ordine", lista);%>
						<a href="Fattura.jsp?costo=<%=costo%>&ID=<%=number%>&Data=<%=data%>" class="btn btn-danger">Vedi fattura</a>
									
								</figcaption>
						</figure> 
				</td>
    </div>
    </div>
    <hr>
	</div>

 	<%@ include file="footer.jsp" %>
 
 
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
 
 </html>