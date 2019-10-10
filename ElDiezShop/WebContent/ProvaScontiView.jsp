<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prova sconti view</title>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
</head>
<body>
      <%float prezzoProva=100;%>
      <form action="CodiceControl" method="get">
      HAI UN CODICE DI SCONTO?
      <input type="text" name="codSconto" placeholder="Inserisci qui il tuo codice">
      <input type="submit" value="verifica">
      </form>
      <%int percSconto=0;
        if(request.getAttribute("sconto") != null)
                         percSconto=(int)request.getAttribute("sconto");
        String frase=(String)request.getAttribute("messaggio");
      %>
      <h3>CostoTotale</h3>
      <%
        out.println(prezzoProva-(prezzoProva/100*percSconto));
        if(frase!=null)
              out.println(frase);
      %>     
</body>
</html>