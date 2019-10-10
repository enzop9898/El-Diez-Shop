function cambioTaglia41(){
	$("#b1").css("background-color","rgb(71, 69, 69)");
	
	$("#b2").css("background-color","black");
	$("#b3").css("background-color","black");
	
	$("#flag").text('41');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('41');
}

function cambioTaglia42(){
	$("#b2").css("background-color","rgb(71, 69, 69)");
	
	$("#b1").css("background-color","black");
	$("#b3").css("background-color","black");
	
	$("#flag").text('42');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('42');
}

function cambioTaglia43(){
	$("#b3").css("background-color","rgb(71, 69, 69)");
	
	$("#b1").css("background-color","black");
	$("#b2").css("background-color","black");
	
	$("#flag").text('43');
	$("#flag").hide();
	
	$("#errore").text('');
	
	$("#tagl").val('43');
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



