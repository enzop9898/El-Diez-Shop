<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.DAOS.*"%>
<%@page import="model.beans.*"%>
<%	ArrayList<?> product = (ArrayList<?>) request.getAttribute("prodottiperOrdine"); 
    //Cart cart = (Cart) request.getAttribute("cart");  O CARRELL
%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.*"%>

<head>
	<link rel="icon" href="foto/logoDef.png" sizes="9x9">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>PROVA VISUALIZZAZIONE PRODOTTI PER ORDINE</title>
</head>
<body><h2>PRODOTTI DELL'ORDINE CHE HAI SCELTO</h2>
	<%
	if (product!= null && product.size() != 0) {
				Iterator<?> it = product.iterator();
				while (it.hasNext())
				{
					ProductBean bean = (ProductBean)it.next();
					%><h5><%out.println(bean.getCodice());
					out.println(bean.getBrand());
					out.println(bean.getDescrizione());
					out.println(bean.getIvaAtt());
					out.println(bean.getNome());
					out.println(bean.getTipo());
					out.println(bean.getSize());
					out.println(" ");
					%></h5> <br> <br> <br>
				<%}
				}%>
	
	</body>