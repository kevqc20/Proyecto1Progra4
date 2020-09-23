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
        <title>Servicios</title>
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>
        <!-- Add Modal HTML -->
        <div class="signup-form">
            <form action="/Proyecto1/presentation/registro/registro" method="post">
                <h2>Registro servicio</h2>
                <div class="form-group">
                    <input type="text" class="form-control" name="codigo" placeholder="Código" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="detalle" placeholder="Detalle" required="required">
                </div>
                <div class="form-group">
                    <input type="number" step="0.00001" class="form-control" name="precio" placeholder="Precio Unitario">
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col">
                            <select class="custom-select">
                                <option selected>Tipo impuesto</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div class="col">
                            <input type="number" step="0.00001" class="form-control" name="impuestoN" placeholder="Impuesto Neto" disabled>
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col">
                            <select class="custom-select">
                                <option selected>Unidad de Medida</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div> 
                </div>        
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Registrarse</button>
                </div>
            </form>
        </div>                            
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
