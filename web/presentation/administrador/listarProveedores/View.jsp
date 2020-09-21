<%-- 
    Document   : cuentas
    Author     : kevin
--%>
<%@page import="factura.presentation.administrador.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="factura.logic.Proveedor"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Proveedor> cuentas = model.getCuentas();
%>

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
        <link href="../../css/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Proveedores</title>
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>
        <div class="container-fluid">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Listado de <b>Proveedores</b></h2>
                            </div>
                            <div class="col-sm-6">				
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre de la Empresa</th>
                                <th>Nombre comercial</th>
                                <th>Email</th>
                                <th>Código</th>
                                <th>Teléfono</th>
                                <th>Provincia</th>
                                <th>Cantón</th>
                                <th>Distrito</th>
                                <th>Otras señas</th>
                                <th>Activo</th>  
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Proveedor c : cuentas) {%>

                            <tr>
                                <td><a href="/Guia/presentation/cliente/cuenta/show?numeroFld=<%=c.getUsuario().getIdentificacion()%>"><%=c.getUsuario().getIdentificacion()%></td>
                                <td><%= c.getNombre()%></td>
                                <td><%= c.getNombreComercial()%></td>
                                <td><%= c.getCorreoElectronico()%></td>
                                <td><%= c.getTelefono().getCodigoPais()%></td>
                                <td><%= c.getTelefono().getNumTelefono()%></td>
                                <td><%= c.getUbicacion().getProvincia()%></td>
                                <td><%= c.getUbicacion().getCanton()%></td>
                                <td><%= c.getUbicacion().getDistrito()%></td>
                                <td><%= c.getUbicacion().getOtrasSenas()%></td>
                                <td><%= c.getUsuario().getActivo()%></td>
                            </tr> 

                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
