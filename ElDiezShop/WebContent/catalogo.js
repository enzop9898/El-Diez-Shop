function cambioTagliaS(){
	$("#b1").css("background-color","rgb(71, 69, 69)");
	
	$("#b2").css("background-color","black");
	$("#b3").css("background-color","black");
	
	$("#flag").text('s');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('s');
}

function cambioTagliaM(){
	$("#b2").css("background-color","rgb(71, 69, 69)");
	
	$("#b1").css("background-color","black");
	$("#b3").css("background-color","black");
	
	$("#flag").text('m');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('m');
}

function cambioTagliaL(){
	$("#b3").css("background-color","rgb(71, 69, 69)");
	
	$("#b1").css("background-color","black");
	$("#b2").css("background-color","black");
	
	$("#flag").text('l');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('l');
}



function controlloTaglia(){
	if ($("#flag").text()=="")
	{
		$("#errore").text('Devi selezionare una taglia!').css({"color":"red"});
		return(false);
	}
	else
	{
		return(true);
	}
}



