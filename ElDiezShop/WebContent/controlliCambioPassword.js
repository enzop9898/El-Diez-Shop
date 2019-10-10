
function controlCambio(form)
{
    $("#messaggio").text('');
    $("#error").text('La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
	
	var maiusc=false
	var number=false;
	var pass= document.getElementById("passwordNuova").value;
	
	
if ($("#passwordNuova").val()=="")
{
	$("#error").text('Inserire una password valida.').css({"color":"red"});
	document.getElementById("passwordNuova").focus();
    return(false);
}

if ($("#passwordNuova").val().length<8)
{
	$("#error").text('Inserire una password con almeno 8 caratteri.').css({"color":"red"});
 document.getElementById("passwordNuova").focus();
 return(false);
}

if ($("#passwordNuova").val().length>16)
{
	$("#error").text('Inserire una password con massimo 16 caratteri.').css({"color":"red"});
 document.getElementById("passwordNuova").focus();
 return(false);
}

	for(var i=0; i<$("#passwordNuova").val().length;i++)
	{
		var c=$("#passwordNuova").val().charAt(i);
		 if(c.toUpperCase()==c)
		 {
			 maiusc=true;
		 }
	}

	if(maiusc==false) 
		{
		$("#error").text('La password deve avere almeno un carattere maiuscolo.').css({"color":"red"});
		 document.getElementById("passwordNuova").focus();
		 return(false);
		}
	
	for(var i=0; i<$("#passwordNuova").val().length;i++)
	{
		
	var c=$("#passwordNuova").val().charAt(i);
	if((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9'))
	 {
		 number=true;
	 }
	}
	if(number==false) 
	{
		$("#error").text('La password deve avere almeno un numero.').css({"color":"red"});
		  document.getElementById("passwordNuova").focus();
		return(false);
	}
	else  //TUTTO CORRETTO
	{
		$.post("servletCambioPassword",$(form).serialize(),function(msg){
			var lunghezza=msg.length;
	        
			if(lunghezza == 33){
				$("#messaggio").text(msg).css({"color":"green"});
			}
			else{
				$("#messaggio").text(msg).css({"color":"red"});
			}
		});
		
		return(false);
	}	
}




function start1(){
	$("#messaggio").text('').css({"color":"grey"});
}



function start2(){
	$("#messaggio").text('').css({"color":"grey"});
    $("#error").text('La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});	
}




