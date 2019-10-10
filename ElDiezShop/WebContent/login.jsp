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
    <link rel="stylesheet" href="STILI/login.css">
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
                        <div class="card rounded-0 CDtot">
                            <div class="card-header carta1">
                                <h3 class="mb-0">Login</h3>
                            </div>
                            <div class="card-body">
                            <h7 id="errore"><%ErrorParser ep=new ErrorParser(request);
                            out.println(ep.parse(response));
                            %>
                            </h7>
                                <form class="form" action="servletLogin" method="POST">
                                    <div class="form-group">
                                        <label for="uname1" class="grassetto"><img src="foto/ominoLogin.png" alt="">&nbspUsername</label>
                                        <input type="text" class="form-control form-control-lg rounded-0 BORDONERO" name="username" id="username" required="">
                                    </div>
                                    <div class="form-group">
                                        <label class="grassetto"><img src="foto/chiave.png" alt="">&nbspPassword</label>
                                        <input type="password" class="form-control form-control-lg rounded-0 BORDONERO" name="password" id="password" required="" autocomplete="new-password">
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-lg float-right btn-mio" id="btnLogin">Accedi</button>
                                    <div>
                                     <p>Non hai un Account? <a id="linkReg" href="registrazione.jsp">Registrati</a> </p> 
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

