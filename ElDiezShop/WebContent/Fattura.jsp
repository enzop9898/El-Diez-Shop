<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="controller.*"%>  
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>
<%@page import="java.util.*" %>
<%@page import="java.lang.Math.*" %>
<%Utente ut=(Utente)session.getAttribute("Utente"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
<meta charset="UTF-8">
<title>Fattura Ordine</title>
<link rel="stylesheet" href="STILI/Fattura.css">
</head>
<body>
<h1 align="center"> Fattura Ordine</h1> <br> <br>
 <div id="head">
 	<span>
 		<img alt="" src="foto/logoDef.png"> <br> <br> <b>Indirizzo:</b> Salerno,Via Roma,156 <br>
 		<b>Email:</b> eldiez_shop@gmail.com <br>
 		<b>Telefono:</b> 089 89 32 63 <br>
 		<b>Cellulare:</b>+39 348 32 09 519 
 	</span>
 
  	<span> <b>Destinazione</b> <br> <br>
	<%=ut.getNome() %> <%=ut.getCognome() %>
	</span> 
 </div>
<table id="uno"> <tr><td class="siiiu"><b>Numero Documento</b></td>
<td class="siiiu"><b>Data Documento</b></td>
<td class="siiiu"><b>P.IVA</b></td>
<td class="siiiu"><b>Modalità di Pagamento</b></td>
</tr>
<tr>
<td class="siiiu"><%=request.getParameter("ID")%> </td>
<td class="siiiu"><%=request.getParameter("Data") %></td>
<td class="siiiu">36081484389</td>
<td class="siiiu">120 giorni fino mese</td><td> Pagina 1 di 1</td>
</tr>
</table>

<table id="due">
<tr>
<th>Codice</th>
<th>Taglia</th>
<th>Nome</th>
<th>Quantità</th>
<th>Prezzo</th>
<th>%Sconto applicata</th>
<th>IVA imposta</th>
</tr>
<%ArrayList<ProductBean> n=(ArrayList<ProductBean>)session.getAttribute("ordine");
int iva= n.get(0).getIvaAtt();
double totaleOrdine=Double.parseDouble((String)request.getParameter("costo"));
double imposta=(totaleOrdine/100)*iva;
for(ProductBean u:n)
	{
	%><tr>
	  <td class="siiiu" width="8%"><%=u.getCodice()%></td>
	  <td class="siiiu" width="8%"><%=u.getSize()%></td>
	  <td class="siiiu"><%=u.getNome() %></td>
	  <td class="siiiu" width="6%"><%=u.getQuantitaCarrello() %> pz</td>
	  <td class="siiiu" width="7%">€ <%=(u.getPrezzoAtt()*u.getQuantitaCarrello())%></td>
	  <td class="siiiu" width="8%"><%=u.getSconto() %> %</td>
	  <td class="siiiu" width="8%"><%=u.getIvaAtt() %> %</td>
	  </tr>
	  <%
	}%>

<tr id="qun" style="border:2px solid black;">
<td width="8%"><b>Totale imponibile:</b> <br>€<%=totaleOrdine-imposta %> <td>
<td width="8%"><b>Totale imposta: €</b><%=imposta%><td>
<td width="8%"><b>Totale Fattura: €</b><%=totaleOrdine%><td>
</tr>
</table>


</body>
</html>