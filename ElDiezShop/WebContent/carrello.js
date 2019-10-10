function cambiaquantita(form){

	$("#risultato").text("");
    $.post("ServletVariaQuantita",$(form).serialize(),function(msg){
    	$("#TOTALECARRELLO").text("TOTALE €"+msg);
	});
    
   
   return(false);
}            

   
function controllaCodice(){
	
	$("#risultato").text("");
	var cod= $("#codProm").val();
	$.get("ServletControllaCodice",{ codSconto:cod},function(msg){
    	  if(msg.length==13){
    		   $("#messaggio").text("Codice Inesistente").css({"color":"red"});
    	  }
    	  else if(msg.length==7){
    		  $("#messaggio").text("Codice già usato").css({"color":"red"});
    	  }
    	  else{
    		  var codice=JSON.parse(msg);
    		  var sconto=codice.sconto;//CAMBIO TOTALE GRAFICO CARRELLO
    		  $("#messaggio").text("Codice valido").css({"color":"green"});
    		  $("#codProm").hide("slow");
    		  var x=$("#totaleInteroCarrello").val();
    		  var VecchioCosto=parseFloat(x);
    		  var nuovoCosto=VecchioCosto- VecchioCosto/100*sconto;
    		  $("#TOTALECARRELLO").text("TOTALE €"+nuovoCosto);
    		  }
	});
}


function  ACQUISTA(form){
	$("#risultato").text("");
	
	$.post("ServletAcquisto",$(form).serialize(),function(msg){
		if(msg.length==9){
			window.location = 'login.jsp';
		}
		else
		if(msg.length==34){
			window.location = 'carrello.jsp';
		}
		else{
			$("#risultato").text(msg).css({"color":"red"});
		}
	}); 
   return(false);
}

function toglierrori(){
	$("#risultato").text("");
}






