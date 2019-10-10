<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.DAOS.*"%>
<%@page import="model.beans.*"%>
<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.DAOS.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
<style>
table#tab {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
<meta charset="UTF-8">
<title>Ordini Per Data</title>
</head>
<body>
<%ArrayList <OrdineBean> result=(ArrayList<OrdineBean>)request.getAttribute("ordini");%>

<table id="tab">
<tr>
<th>  ID </th>
<th> Username</th>
<th> Costo </th>
<th> Data </th>
<%for(OrdineBean t:result){%>
	<tr>
	<td><%=t.getID() %></td>
	<td><%=t.getUsername() %></td>
	<td><%=t.getCostoTot() %></td>
	<td><%=t.getData() %></td>	
	</tr>
	<%} %>
</tr>



</table>
   
<br><br> <br><br> <br><br>
<a href="index.jsp">Torna alla pagina principale>></a>
</body>
</html>