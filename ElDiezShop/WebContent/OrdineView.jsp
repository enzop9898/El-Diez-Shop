<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.DAOS.*"%>
<%@page import="model.beans.*"%>


<%	ArrayList<?> order = (ArrayList<?>) request.getAttribute("order"); 
    //Cart cart = (Cart) request.getAttribute("cart");  O CARRELL
%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.*"%>

<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>PROVA VISUALIZZAZIONE PRODOTTI</title>
</head>
<body><h2>ciao </h2>
	<a href="OrdineControl?action=AllOrderFromUser&user=DEBBO58">I miei ordini</a>
	<h1>ORDINI CHE HO ESEGUITO</h1>
	<%
	if (order!= null && order.size() != 0) {
				Iterator<?> it = order.iterator();
				while (it.hasNext())
				{
					OrdineBean bean = (OrdineBean)it.next();
					%><h5><a href="ProductForOrder?action=SearchProductFromOrder&ordernumber=<%=bean.getID()%>"><%out.println(bean.getID());%></a></h5>
				<%}
				}%>
	
	</body>