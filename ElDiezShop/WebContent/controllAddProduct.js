
function controllAdd(form)
{
	var codice=document.getElementById("codice").value;
	var w="";
	var ncod = codice.localeCompare(w);
	if(ncod==0){
		document.getElementById("errorcodice").innerHTML = "Non hai inserito il codice!";
		document.getElementById("errorcodice").style.color = "red";
		document.getElementById("codice").focus();
		return false;
	}
	if(codice.length>45)
		{
		document.getElementById("errorcodice").innerHTML = "Codice troppo lungo,devi inserire un codice con massimo 45 caratteri!!";
		document.getElementById("errorcodice").style.color = "red";
		document.getElementById("codice").focus();
		return false;
		}
	
	var size=document.getElementById("taglia").value;
	var w="";
	var ntag = size.localeCompare(w);
	if(ntag==0){
		document.getElementById("errortag").innerHTML = "Non hai inserito il codice!";
		document.getElementById("errortag").style.color = "red";
		document.getElementById("taglia").focus();
		return false;
	}
	
	var nostalgia=document.getElementById("nostalgia").value;
	var nnos = nostalgia.localeCompare(w);
	if(nnos==0){
		document.getElementById("errorNostalgia").innerHTML = "Questo prodotto è nostalgico?";
		document.getElementById("errorNostalgia").style.color = "red";
		document.getElementById("nostalgia").focus();
		return false;
	}
	
	var sconto=document.getElementById("sconto").value;
	var nsco = sconto.localeCompare(w);
	if(nsco==0){
		document.getElementById("errorSconto").innerHTML = "Non hai inserito lo sconto!!";
		document.getElementById("errorSconto").style.color = "red";
		document.getElementById("sconto").focus();
		return false;
	}
	
	var brand=document.getElementById("brand").value;
	var nbrand = brand.localeCompare(w);
	if(nbrand==0){
		document.getElementById("errorBrand").innerHTML = "Non hai inserito il Brand!!";
		document.getElementById("errorBrand").style.color = "red";
		document.getElementById("brand").focus();
		return false;
	}
	if(brand.length>45)
	{
	document.getElementById("errorBrand").innerHTML = "Brand troppo lungo,devi inserire un Brand con massimo 45 caratteri!!";
	document.getElementById("errorBrand").style.color = "red";
	document.getElementById("brand").focus();
	return false;
	}
	
	var prezzo=document.getElementById("prezzo").value;
	var npre = prezzo.localeCompare(w);
	if(npre==0){
		document.getElementById("errorPrezzo").innerHTML = "Non hai inserito il prezzo!!";
		document.getElementById("errorPrezzo").style.color = "red";
		document.getElementById("prezzo").focus();
		return false;
	}
	
	var iva=document.getElementById("iva").value;
	var niva = iva.localeCompare(w);
	if(niva==0){
		document.getElementById("errorIva").innerHTML = "Non hai inserito l'IVA!!";
		document.getElementById("errorIva").style.color = "red";
		document.getElementById("iva").focus();
		return false;
	}
	
	var des=document.getElementById("descrizione").value;
	var ndes = des.localeCompare(w);
	if(ndes==0){
		document.getElementById("errorDescrizione").innerHTML = "Non hai inserito la descrizione!!";
		document.getElementById("errorDescrizione").style.color = "red";
		document.getElementById("descrizione").focus();
		return false;
	}
	
	if(descrizione.length>1000)
	{
	document.getElementById("errorDescrizione").innerHTML = "Descrizione troppo lunga,devi inserire una descrizione con massimo 1000 caratteri!!";
	document.getElementById("errorDescrizione").style.color = "red";
	document.getElementById("descrizione").focus();
	return false;
	}
	
	var pzz=document.getElementById("pezzi").value;
	var npzz = pzz.localeCompare(w);
	if(npzz==0){
		document.getElementById("errorPezzi").innerHTML = "Non hai inserito la quantità di questo prodotto!!";
		document.getElementById("errorPezzi").style.color = "red";
		document.getElementById("pezzi").focus();
		return false;
	}
	
	var img=document.getElementById("immagine").value;
	var nimg = img.localeCompare(w);
	if(nimg==0){
		
		document.getElementById("errorImg").innerHTML = "Non hai inserito l'immagine per questo prodotto!!";
		document.getElementById("errorImg").style.color = "red";
		document.getElementById("immagine").focus();
		return false;
	}
	
	var tip=document.getElementById("tipo").value;
	var ntip = tip.localeCompare(w);
	if(ntip==0){
		
		document.getElementById("errorTipo").innerHTML = "Non hai inserito il tipo!!!";
		document.getElementById("errorTipo").style.color = "red";
		document.getElementById("tipo").focus();
		return false;
	}
	
	var nom=document.getElementById("nome").value;
	var nnom = nom.localeCompare(w);
	if(nnom==0){
		document.getElementById("errorNome").innerHTML = "Non hai inserito il nome del prodotto!!";
		document.getElementById("errorNome").style.color = "red";
		document.getElementById("nome").focus();
		return false;
	}
	
	if(nom.length>50)
	{
	document.getElementById("errorNome").innerHTML = "Nome prodotto troppo lungo,devi inserire un codice con massimo 50 caratteri!!";
	document.getElementById("errorNome").style.color = "red";
	document.getElementById("nome").focus();
	return false;
	}
}		
	
	function startCod(){
	   // $("#errorcodice").text('');
		document.getElementById("errorcodice").innerHTML = "";
		
}
	function starttag(){
		document.getElementById("errortaglia").innerHTML = "Scegli L,M,S,XS,XL";
	}
	function startnos(){
		document.getElementById("errorNostalgia").innerHTML = "Inserisci solo 'SI' o 'NO' ";
		document.getElementById("errorNostalgia").style.textAlign = "right";
		document.getElementById("errorNostalgia").style.color = "red";
	}
	function startnos1(){
		document.getElementById("errorNostalgia").innerHTML = "";
	}
	
	function startbra(){
		document.getElementById("errorBrand").innerHTML = "";
}
	function startpre(){
		document.getElementById("errorPrezzo").innerHTML = "";
}
	function startiva(){
		document.getElementById("errorIva").innerHTML = "";
}
	function startdes(){
		document.getElementById("errorDescrizione").innerHTML = "";
}
	function startpez(){
		document.getElementById("errorPezzi").innerHTML = "";
}
	function startimg(){
		document.getElementById("errorImg").innerHTML = "";
}
	function starttip(){
		document.getElementById("errorTipo").innerHTML = "Inserire un tipo che sia allenamento,divisa,polo,scarpette,tuta";
		document.getElementById("errorTipo").style.textAlign = "right";
		document.getElementById("errorTipo").style.color = "red";
	}
	function starttip1(){
		document.getElementById("errorTipo").innerHTML = "";
	}
	function startnom(){
		document.getElementById("errorNome").innerHTML = ""; 
}