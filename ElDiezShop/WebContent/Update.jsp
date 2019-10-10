<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="foto/logoDef.png" sizes="9x9">
<style>
input[type=text], select,input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: red;
}

div#muuu {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  }

</style>
<meta charset="UTF-8">
<title>Aggiunta Prodotto</title>
<script src="controllAddProduct.js">
</script>
</head>
<body>
<br> <br> <br> <br><br> <br>
<div id="muuu">
<form action="UpdateServlet" method="post" onsubmit="return controllAdd(this)">
<b>Codice: </b><input type="text" id="codice"  name="codice" value="<%=request.getParameter("codice") %>" onclick="startCod()" onkeyup="startCod()" readonly > <br>
<p id="errorcodice"></p>
 <% String x= request.getParameter("size");
    String t= request.getParameter("tipo");
    String n= request.getParameter("nostalgia");
    String d= request.getParameter("tipo");
    System.out.println(x); %>
<b>Taglia: </b> <select name="size" id="taglia">
    <%if(t.equalsIgnoreCase("scarpette")){ %>
          <option value=<%=x %>><%=x %></option>
          <option value="41">41</option>
    	  <option value="42">42</option>
          <option value="43">43</option>
    <%}else{ %>
          <option value=<%=x %>><%=x %></option>
          <option value="S">S</option>
    	  <option value="L">L</option>
    	  <option value="M">M</option>
    <%} %>
  </select>
  <p id="errortag"></p>
<b>Nostalgia? : </b><select name="nostalgia" id="nostalgia" readonly>
    <option value=<%=n %>><%=n %></option>
    <option value="no">NO</option>
    <option value="si">SI</option>
  </select>
  <p id="errorNostalgia"></p>
<b>Percentuale Sconto: </b><input onclick="startsco()" onkeyup="startsco()" value="<%=request.getParameter("sconto") %>" id="sconto" type="number" min="0" max="100"name="sconto" placeholder="Percentuale di sconto (decimale)"><br>
<p id="errorSconto"></p>
<b>Brand: </b><input onclick="startbra()" onkeyup="startbra()" id="brand" value="<%=request.getParameter("brand") %>" type="text" name="brand" placeholder="Inserire qui il brand del prodotto...(max 45 caratteri)"><br>
<p id="errorBrand"></p>
<b>Prezzo (€): </b><input onclick="startpre()" onkeyup="startpre()" value="<%=request.getParameter("prezzo") %>" id="prezzo" type="number" name="prezzo" placeholder="Inserire qui il prezzo del prodotto"><br>
<p id="errorPrezzo"></p>
<b>IVA (%): </b><input onclick="startiva()" onkeyup="startiva()" value="<%=request.getParameter("iva") %>" id="iva" type="number" min="1" max="100" name="iva" placeholder="Inserire qui l'iva attuale del prodotto"><br>
<p id="errorIva"></p>
<b>Descrizione: </b><input onclick="startdes()" onkeyup="startdes()" value="<%=request.getParameter("descrizione") %>" id="descrizione" type="text" name="descrizione" placeholder="Inserire qui la descrizione del prodotto...(max 1000 caratteri)"><br>
<p id="errorDescrizione"></p>
<b>Pezzi: </b><input onclick="startpez()" onkeyup="startpez()" value="<%=request.getParameter("pezzi") %>" id="pezzi" type="number" name="pezzi" placeholder="Inserire qui il numero di occorrenze di questo prodotto che si ha a disposizione nel magazzino"><br>
<p id="errorPezzi"></p>
<b>Immagine: </b><input onclick="startimg()" onkeyup="startimg()" value="<%=request.getParameter("immagine") %>" id="immagine" type="text" name="immagine" placeholder="Inserire qui il path relativo all'immagine del prodotto...(max 500 caratteri)" readonly><br>
<p id="errorImg"></p>
<b>Tipo: </b> <select name="tipo" id="tipo" readonly value="<%=request.getParameter("tipo") %>">
    <option value=<%=d %>><%=d %></option>
    <option value="divisa">Divisa</option>
    <option value="scarpette">Scarpette</option>
    <option value="allenamento">Allenamento</option>
    <option value="polo">Polo</option>
    <option value="tuta">Tuta</option>
  </select>
  <p id="errorTipo"></p>
<b>Nome: </b><input onclick="startnom()" onkeyup="startnom()" value="<%=request.getParameter("nome") %>" id="nome" type="text" name="nome" placeholder="Inserire qui il nome del prodotto...(max 50 caratteri)"><br><br><br>
<p id="errorNome"></p>
<input type="submit" value="INVIA!">
</form>
</div>


</body>
</html>