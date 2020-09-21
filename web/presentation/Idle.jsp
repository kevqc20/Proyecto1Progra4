<%-- 
    Document   : Header
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,500|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>        
        <link href="../css/default.css" rel="stylesheet" type="text/css"/>
        <title>Página principal</title>    
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>
        <div class="login-form">
            <div class="btn-group-vertical">
                <a href="/Proyecto1/presentation/administrador/listarProveedores/View.jsp" class="btn btn-primary">Listado de proveedores</a>
                <a href="/Proyecto1/presentation/proveedor/configuracion/View.jsp" class="btn btn-primary">Perfil</a>
                <a href="/Proyecto1/presentation/proveedor/registroClientes/View.jsp" class="btn btn-primary">Clientes frecuentes</a>
                <a href="/Proyecto1/presentation/proveedor/registroServicios/View.jsp" class="btn btn-primary">Servicios</a>
                <a href="/Proyecto1/presentation/proveedor/listarFacturas/View.jsp" class="btn btn-primary">Listado de facturas</a>
                <a href="/Proyecto1/presentation/proveedor/facturar/View.jsp" class="btn btn-primary">Facturar</a>

            </div>
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
