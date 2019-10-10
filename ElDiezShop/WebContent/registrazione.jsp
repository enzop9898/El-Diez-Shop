<%@page import="controller.*"%>
<%@page import="database.*"%>
<%@page import="model.*"%>
<%@page import="model.beans.*"%>
<%@page import="model.DAOS.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
	<link rel="icon" href="foto/logoDef.png" sizes="9x9">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EL DIEZ SHOP</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="STILI/registrazione.css">
    <script src="controlli.js"></script>
</head>
<body>

    <%@ include file="barra.jsp"%><br>

  <!--<div id="MIODIV">-->
    <div class="container py-5">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 mx-auto">
    
                        <!-- form card login -->
                        <div class="card rounded-0 CDtot" id="contenitoreTotale">
                            <div class="card-header carta1">
                                <h3 class="mb-0">REGISTRATI</h3>
                            </div>
                            <div class="card-body">
                         
                            <p id="error">
		                    </p> 
                                  <form action="servletRegister" method="post" onsubmit="return control(this)">                                    
                                  <div class="form-group">
                                        <label  class="grassetto">&nbspNome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="nome" id="nome" onclick="startNome()" onkeyup="startNome()">
                                        <p id="errorNome"></p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto">&nbspCognome</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="cognome" id="cognome" onclick="startCognome()" onkeyup="startCognome()">
                                        <p id="errorCognome"></p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/ominoLogin.png" alt="">&nbspUsername</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="username" id="username" onclick="startUsername()" onkeyup="startUsername()">
                                        <p id="errorU" class="suggerimento">Deve contenere almeno 5 caratteri e non piu di 40</p>
                                    </div>
                                    <div class="form-group">
                                        <label  class="grassetto"><img src="foto/email.png" alt="">&nbspE-mail</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="email" id="email" onclick="startEmail()" onkeyup="startEmail()">
                                         <p id="errorEmail"></p>
                                    </div>
                                       <p id="errorE"></p>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.png" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password" id="password" onclick="startPassword()" onkeyup="startPassword()">
                                         <p id="errorP1" class="suggerimento">La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.png" alt="">&nbspRipeti&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password2" id="password2" onclick="startPassword2()" onkeyup="startPassword2()">
                                        <p id="errorP2" class="suggerimento"><p>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Crea il tuo Account</button>
                                    <div>
                                     <p>Hai gia un account? <a id="linkReg" href="#">Accedi</a> </p> 
                                    </div>
                                </form>
                            </div>
                            <!--/card-block-->
                        </div>
                        <!-- /form card login -->
    
                    </div>
    
    
                </div>
                <!--/row-->
    
            </div>
            <!--/col-->
        </div>
        <!--/row-->
    </div>
    <!--/container-->
  <!--</div>--> 

   <%@ include file="footer.jsp"%>
     
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
</body>

