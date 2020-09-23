<%-- 
    Document   : cuentas
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link href="../../../css/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Registro cliente frecuente</title>
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>

        <div class="signup-form">
            <form action="/Proyecto1/presentation/registro/registro" method="post">
                <h2>Registro cliente frecuente</h2>
                <div class="form-group">
                    <input type="text" class="form-control" name="identificacion" placeholder="Identificación" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="nombre" placeholder="Nombre completo" required="required">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="Correo electrónico">
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col"><input type="number" class="form-control" name="areaCode" min='0'>Codigo del país</div>
                        <div class="col"><input type="number" class="form-control" name="tel" min='0' max='99999999999999999999'>Teléfono</div>
                    </div>        	
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Añadir</button>
                </div>
            </form>
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
