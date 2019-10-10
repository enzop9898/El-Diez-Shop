<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@	page import = "java.util.ArrayList" %>

<head>
<style type="text/css">
div#frm {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EL DIEZ SHOP</title>
    <link rel="icon" href="foto/logoDef.png" sizes="9x9">
    
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="STILI/style.css">
    <script src="controlliAdmin.js"></script>    
</head>
<body>
    
    <%Utente ut=(Utente)session.getAttribute("Utente");
    if(ut==null || !(ut.getTipo().equalsIgnoreCase("ADMIN"))){
        response.sendRedirect("./index.jsp");
        return;
    }
    %>
    <br><br>
    <div class="container">
        <div class="row m-y-2">
            <div class="col-lg-8 push-lg-4">
                <ul class="nav nav-tabs" id="contenitore_datatarget">
                    <li class="nav-item menu">
                        <a href="" data-target="#utenti" data-toggle="tab" class="nav-link menu  active">Utenti</a>
                    </li>
                    <li class="nav-item menu">
                        <a href="" data-target="#prodotti" data-toggle="tab" class="nav-link menu">Prodotti</a>
                    </li>
                    <li class="nav-item menu">
                        <a href="" data-target="#ordini" data-toggle="tab" class="nav-link menu">Ordini Per Data</a>
                    </li>
                    <li class="nav-item menu">
                        <a href="" data-target="#Log-Out" data-toggle="tab" class="nav-link menu">Log-out</a>
                    </li>
                </ul>
                <div class="tab-content  p-b-3">
                    <div class="tab-pane active" id="utenti">
                        <br>
                        <h4 class="m-y-2 prova">Utenti</h4>
                        <br>
                         <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Username</th>
                                            <th>E-mail</th>
                                            <th>Tipo Utente</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
 										ArrayList <Utente> result	= (ArrayList <Utente>) request.getAttribute("listaUtenti");

										for(Utente u : result){ %>
                                        <tr>
                                            <td><a href="#"><%=u.getUsername()%></a></td>
                                            <td><%=u.getEmail() %></td>
                                            <td><%if(u.getTipo().equalsIgnoreCase("ADMIN")) out.println("Admin") ; else out.println("Utente");%></td>
                                            <form method="post" action="HisOrder">
                                            <input type="hidden" name="utente" value="<%=u.getUsername()%>">
                                            <td><button type="submit" class="btn btn-danger">I suoi ordini</button></td>
                                            </form>
                                        </tr>
                                        <%} %>
                                        
                                    </tbody>
                                </table>     
                    </div>


                    <div class="tab-pane" id="prodotti">
                        <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Codice Prodotto</th>
                                            <th>Taglia</th>
                                            <th>Nome</th>
                                            <th>Pezzi</th>
                                            <th>Elimina</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
 										ArrayList <ProductBean> result2	= (ArrayList <ProductBean>) request.getAttribute("listaProdotti");

										for(ProductBean p2 : result2){ %>
                                    
                                    
                                        <tr>
                                            <td><%=p2.getCodice() %></td>
                                            <td><%=p2.getSize() %></td>
                                            <td><%=p2.getNome() %></td>
                                            <td><%=p2.getPezzi() %></td>
                                            <form method="post" action="amministratore">
                                            <td><button type="submit"  class="btn btn-danger">Elimina prodotto</button></td>
                                            <input type="hidden" name="codice" value="<%=p2.getCodice()%>">
                                            <input type="hidden" name="action" value="DeleteProduct">
                                            </form>
                                            
                                            <form method="post" action="Update.jsp">
                                            <td><button type="submit"  class="btn btn-danger">Modifica prodotto</button></td>
                                            <input type="hidden" name="codice" value="<%=p2.getCodice()%>">
                                            <input type="hidden" name="size" value="<%=p2.getSize()%>">
                                            <input type="hidden" name="nostalgia" value="<%=p2.getNostalgia()%>">
                                            <input type="hidden" name="sconto" value="<%=p2.getSconto()%>">
                                            <input type="hidden" name="brand" value="<%=p2.getBrand()%>">
                                            <input type="hidden" name="prezzo" value="<%=p2.getPrezzoAtt()%>">
                                            <input type="hidden" name="iva" value="<%=p2.getIvaAtt()%>">
                                            <input type="hidden" name="descrizione" value="<%=p2.getDescrizione()%>">
                                            <input type="hidden" name="pezzi" value="<%=p2.getPezzi()%>">
                                            <input type="hidden" name="immagine" value="<%=p2.getImg()%>">
                                            <input type="hidden" name="tipo" value="<%=p2.getTipo()%>">
                                            <input type="hidden" name="nome" value="<%=p2.getNome()%>">
                                            </form>
                                          
                                        </tr>
                                       <%} %>
                                    </tbody>
                                </table>
                                <button onclick="window.location.href='productAddition.jsp'" type="button" class="btn btn-primary">Aggiungi prodotto</button>
                    </div> 
                    
                    <div class="tab-pane" id="ordini">
                    <br><br><br> <br><br><br><br>
                    <div align="center"><h1>Ordini in un range di date:</h1></div> <br><br><br>
                    <div id=frm>
					<form action="ServletPerData" method="get">
					Da:<input type="date" name="da">
					A:<input type="date"  name="a">
					<input type="submit" value="INVIA!">
					</form>
					</div>
                    </div> 
                    
                </div>
            </div>
        </div>
    </div>
    
    <br><br>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

