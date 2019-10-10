<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>EL DIEZ SHOP</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="STILI/UserArea.css">
<script src="controlliCambioPassword.js"></script>


</head>
<body>

	<%
		Utente utq = (Utente) session.getAttribute("Utente");
		if (utq == null) {
			response.sendRedirect("./index.jsp");
			return;
		}
	%>

	<%@ include file="barra.jsp"%>

	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row m-y-2">
			<div class="col-lg-8 push-lg-4">
				<ul class="nav nav-tabs" id="contenitore_datatarget">
					<li class="nav-item menu"><a
						href="OrdineControl?action=AllOrderFromUser&user=<%=utq.getUsername()%>"
						data-target="#ordini" data-toggle="tab"
						class="nav-link menu active">I miei ordini</a></li>
					<li class="nav-item menu"><a href="" data-target="#profilo"
						data-toggle="tab" class="nav-link menu">Info Personali</a></li>
					<li class="nav-item menu"><a href="" data-target="#password"
						data-toggle="tab" class="nav-link menu">Cambia Password</a></li>
				</ul>
				<div class="tab-content  p-b-3">
					<div class="tab-pane" id="profilo">
						<br>
						<h4 class="m-y-2 prova">Profilo Utente</h4>
						<br>
						<div class="row">
							<div class="col-md-6" id="distanziatore">
								<span class="titpar">Nome : </span><span><%=utq.getNome()%></span>
								<br> <br> <span class="titpar">Cognome : </span><span><%=utq.getCognome()%></span>
							</div>
							<div class="col-md-6">
								<span class="titpar">Username : </span><span><%=utq.getUsername()%></span>
								<br> <br> <span class="titpar">E-mail : </span><span><%=utq.getEmail()%></span>
							</div>
						</div>
						<!--/row-->
					</div>


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



					<div class="tab-pane" id="password">
						<br>
						<h4 class="m-y-2 prova">Cambio Password</h4>
						<br>



						<form action="servletCambioPassword" method="post"
							onsubmit="return controlCambio(this)">
							<p id="messaggio"></p>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label titpar">Vecchia
									password</label>
								<div class="col-lg-9">
									<input class="form-control" name="passwordVecchia"
										id="passwordVecchia" type="password" value=""
										onclick="start1()" onkeyup="start1()">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label titpar">Nuova
									password</label>

								<div class="col-lg-9">
									<input class="form-control" name="passwordNuova"
										id="passwordNuova" type="password" value="" onclick="start2()"
										onkeyup="start2()">
								</div>
								<p id="error">La password deve avere almeno 8 caratteri,
									massimo 16 caratteri e deve contenere un valore numerico e una
									lettera maiuscola</p>

							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" class="btn btn-secondary" id="resetbottone"
										value="Cancel"> <input type="submit"
										class="btn btn-danger" id="inviobottone" value="Save Changes">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>

	<%@ include file="footer.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>