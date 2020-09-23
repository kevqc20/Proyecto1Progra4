<%-- 
    Document   : listarServicios
    Created on : Sep 23, 2020, 5:35:52 AM
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
        <div class="container-fluid">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Listado de <b>Servicios</b></h2>
                            </div>
                            <div class="col-sm-6">
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Detalle</th>
                                <th>Precio unitario</th> 
                                <th>Tipo Impuesto</th>
                                <th>Impuesto neto</th>
                                <th>Unidad de medida</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>123</td>
                                <td>Camisa</td>
                                <td>5000</td>
                                <td>Impuesto al valor agregado</td>
                                <td>500</td>
                                <td>Os</td>
                            </tr>
                            <tr>
                                <td>123</td>
                                <td>Pantalon</td>
                                <td>8000</td>
                                <td>Impuesto al valor agregado</td>
                                <td>800</td>
                                <td>Os</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>

    </body>
</html>
