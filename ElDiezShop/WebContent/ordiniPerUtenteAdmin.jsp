<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="STILI/UserArea.css">
</head>
<body>
<div class="tab-pane active" id="ordini">
						<br>
							<h4 class="m-y-2 prova">Lista ordini</h4>
					 <br>
						<table id="tabl">
							<tr>
								<th>Ordine</th>
								<th>Data</th>
								<th>Totale</th>
								<th></th>
							</tr>
							<%
								ArrayList<?> order = (ArrayList<?>) request.getAttribute("order");
								//Cart cart = (Cart) request.getAttribute("cart");  O CARRELL
								if (order != null && order.size() != 0) {
									Iterator<?> it = order.iterator();
									while (it.hasNext()) {
							%>
							<tr>
								<%
									OrdineBean bean = (OrdineBean) it.next();
								%>
								<td id="td">Ordine <%=bean.getID()%></td>
								<td id="td"><%=bean.getData()%></td>
								<td id="td">€<%=bean.getCostoTot()%></td>
								<td id="tdv"><a id="anc"
									href="ProductForOrder?action=SearchProductFromOrder&costo=<%=bean.getCostoTot()%>&ordernumber=<%=bean.getID()%>&data=<%=bean.getData()%>">Visualizza
										Ordine>></a></td>
							</tr>
							<%
								}
								}
							%>
						</table>
						<br>
					</div>
</body>
</html>