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
        <div class="container-fluid">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Listado de <b>Servicios</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addProveedorModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Añadir</span></a>	
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
                                <th></th>
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
                                <td>
                                    <a href="#editProveedorModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                            <tr>
                                <td>123</td>
                                <td>Pantalon</td>
                                <td>8000</td>
                                <td>Impuesto al valor agregado</td>
                                <td>800</td>
                                <td>Os</td>
                                <td>
                                    <a href="#editProveedorModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>
        <!-- Add Modal HTML -->
        <div id="addProveedorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">						
                        <h4 class="modal-title">Registrar Servicio</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form>
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
                        </form>
                    </div>                            
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                        <input type="submit" class="btn btn-success" value="Añadir">
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
                            <h4 class="modal-title">Editar Servicio</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
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
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-info" value="Guardar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Borrar Servicio</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>¿Seguro/a que desea eliminar los registros del servicio?</p>
                            <p class="text-warning"><small>Esta acción no puede ser revertida!</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-danger" value="Borrar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
