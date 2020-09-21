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
                                <a href="#addProveedorModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Añadir</span></a>						
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
                                <th></th>
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
                                <td>
                                    <a href="#editProveedorModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                </td>
                            </tr> 

                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>
        <!-- Edit Modal HTML -->
        <div id="addProveedorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">						
                        <h4 class="modal-title">Registrar Proveedor</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <input type="text" class="form-control" name="identificacion" placeholder="Identificación" required="required">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                            </div>    

                            <div class="form-group">
                                <input type="text" class="form-control" name="nombre" placeholder="Nombre de la empresa" required="required">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="nombreComercial" placeholder="Nombre comercial de la empresa">
                            </div>  
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" placeholder="Correo electrónico" required="required">
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col"><input type="number" class="form-control" name="areaCode" min='0'>Codigo del país</div>
                                    <div class="col"><input type="number" class="form-control" name="tel" min='0' max='99999999999999999999'>Teléfono</div>
                                </div>        	
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Provincia</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Cantón</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Distrito</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div> 
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="otrasSenas" placeholder="Otras Señas">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                                <input type="submit" class="btn btn-success" value="Añadir">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editProveedorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Editar Proveedor</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <input type="text" class="form-control" name="identificacion" placeholder="Identificación" disabled>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="nombre" placeholder="Nombre de la empresa" required="required">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="nombreComercial" placeholder="Nombre comercial de la empresa">
                            </div>  
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" placeholder="Correo electrónico" required="required">
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col"><input type="number" class="form-control" name="areaCode" min='0'>Codigo del país</div>
                                    <div class="col"><input type="number" class="form-control" name="tel" min='0' max='99999999999999999999'>Teléfono</div>
                                </div>        	
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Provincia</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Cantón</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select">
                                            <option selected>Distrito</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div> 
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="otrasSenas" placeholder="Otras Señas">
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">Activo</div>
                                    <div class="col">
                                        <span class="input-group-text">
                                            <input type="checkbox">
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-info" value="Guardar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
