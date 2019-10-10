function control(form)
{
	var maiusc=false
	var number=false;
	
    $("#errorNome").text('');
    $("#errorCognome").text('');
    $("#errorU").text('Deve contenere almeno 5 caratteri e non piu di 40').css({"color":"grey"});
    $("#errorEmail").text('');
    $("#errorP1").text('La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
    $("#errorP2").text('');
    $("#error").text('');


	

	if ($("#nome").val()=="")
	{
    $("#errorNome").text('Non hai inserito il tuo nome').css({"color":"red"});
	 document.getElementById("nome").focus();
	 return(false);
	}

	 
	if ($("#cognome").val()=="")
	{
	 $("#errorCognome").text('Non hai inserito il tuo cognome').css({"color":"red"});
	 document.getElementById("cognome").focus();
	 return(false);
	}

	if ($("#username").val()=="")
	{
     $("#errorU").text('Non hai inserito il tuo username').css({"color":"red"});
	 document.getElementById("username").focus();
	 return(false);
	}	
	
	if ($("#username").val().length<5)
	{
		$("#errorU").text('Inserire una username con almeno 5 caratteri.').css({"color":"red"});
	 document.getElementById("username").focus();
	 return(false);
	}

	if ($("#username").val().length>40)
	{
		$("#errorU").text('Inserire una username con massimo 40 caratteri.').css({"color":"red"});
	 document.getElementById("password").focus();
	 return(false);
	}
	 
	if ($("#email").val()=="")
	{
     $("#errorEmail").text('Non hai inserito la tua e-mail').css({"color":"red"});
	 document.getElementById("email").focus();
	 return(false);
	}
	
	var regexEmail = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+$";
	if(!($("#email").val().match(regexEmail))) {
		$("#errorEmail").text('Non hai inserito una e-mail valida').css({"color":"red"});
		 document.getElementById("email").focus();
		 return(false);
	}

	
if ($("#password").val()=="")
{
	$("#errorP1").text('Inserire una password valida.').css({"color":"red"});
	document.getElementById("password").focus();
 return(false);
}

if ($("#password").val().length<8)
{
	$("#errorP1").text('Inserire una password con almeno 8 caratteri.').css({"color":"red"});
 document.getElementById("password").focus();
 return(false);
}

if ($("#password").val().length>16)
{
	$("#errorP1").text('Inserire una password con massimo 16 caratteri.').css({"color":"red"});
 document.getElementById("password").focus();
 return(false);
}

	for(var i=0; i<$("#password").val().length;i++)
	{
		var c=$("#password").val().charAt(i);
		 if(c.toUpperCase()==c)
		 {
			 maiusc=true;
		 }
	}

	if(maiusc==false) 
		{
		$("#errorP1").text('La password deve avere almeno un carattere maiuscolo.').css({"color":"red"});
		 document.getElementById("password").focus();
		 return(false);
		}
	
	for(var i=0; i<$("#password").val().length;i++)
	{
		
	var c=$("#password").val().charAt(i);
	if((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9'))
	 {
		 number=true;
	 }
	}
		if(number==false) 
			{
			$("#errorP1").text('La password deve avere almeno un numero.').css({"color":"red"});
				 document.getElementById("password").focus();
				 return(false);
			}
		
		if ($("#password2").val()=="")
		{
	    $("#errorP2").text('Devi confermare la tua password').css({"color":"red"});
		document.getElementById("password2").focus();
		 return(false);
		}

		var p = $("#password").val();
		var p2= $("#password2").val();

		if(!(p==p2))
		{
	     $("#errorP2").text('Le due password non corrispondono').css({"color":"red"});
		 document.getElementById("password2").focus();
		 return(false);
		}		
    
    
	$.post("servletRegister",$(form).serialize(),function(msg){
		var lunghezza=msg.length;         //non funzionava con il confronto normale della parola perche ci sarà qualche carattere vuoto in piu
		if(lunghezza == 10){
			window.location = 'login.jsp';
		}
		else{
		$("#error").text(msg).css({"color":"red"});			
		document.getElementById("username").focus();
		}
		
		});
	
	return(false);
}













function startNome(){
	    $("#errorNome").text('');
}

function startCognome(){
    $("#errorCognome").text('');
}

function startUsername(){
    $("#errorU").text('Deve contenere almeno 5 caratteri e non piu di 40').css({"color":"grey"});
}

function startEmail(){
    $("#errorEmail").text('');
}

function startPassword(){
    $("#errorP1").text('La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola').css({"color":"grey"});
}

function startPassword2(){
    $("#errorP2").text('');
}

