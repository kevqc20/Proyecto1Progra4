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
        <title>Facturas</title>
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
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Clave</th>
                                <th>Código de actividad</th>
                                <th>Fecha de emisión</th> 
                                <th>Proveedor ID</th>
                                <th>Cliente ID</th> 
                                <th>Monto total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>01</td>
                                <td>15/09/2020</td>
                                <td>111</td>
                                <td>123</td>
                                <td>8000</td>
                                <td>
                                    <a href="#editFacturaModal" class="edit" data-toggle="modal" title="Ver detalles"><i class="material-icons">&#xE5C8;</i></a>
                                    <a href="#deleteFacturaModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Borrar">&#xE872;</i></a>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>02</td>
                                <td>15/09/2020</td>
                                <td>111</td>
                                <td>456</td>
                                <td>5000</td>
                                <td>
                                    <a href="#editFacturaModal" class="edit" data-toggle="modal" title="Ver detalles"><i class="material-icons">&#xE5C8;</i></a>
                                    <a href="#deleteFacturaModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Borrar">&#xE872;</i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>
        <!-- Edit Modal HTML -->
        <div id="editFacturaModal" class="modal fade">
            <div class="modal-dialog mw-100 w-75">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Factura</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					

                            <h3>Datos de la factura</h3>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <input type="text" class="form-control" name="clave" placeholder="Clave" disabled>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select" disabled>
                                            <option selected >Código de Actividad</option>
                                            <option value="1" >One</option>
                                            <option value="2" >Two</option>
                                            <option value="3" >Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <input type="date" class="form-control" name="fecha" required="required" disabled> Fecha
                                    </div>  
                                </div>
                            </div>

                            <h3>Cliente</h3>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <input type="text" class="form-control" name="identificacion" placeholder="Identificación" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <input type="text" class="form-control" name="nombre" placeholder="Nombre completo" disabled>
                                    </div>
                                    <div class="col">
                                        <input type="email" class="form-control" name="email" placeholder="Correo electrónico" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col"><input type="number" class="form-control" name="areaCode" min='0' disabled>Codigo del país</div>
                                    <div class="col"><input type="number" class="form-control" name="tel" min='0' max='99999999999999999999' disabled>Teléfono</div>
                                </div>        	
                            </div>

                            <h3>Detalle</h3>

                            <div class="container-fluid">
                                <div class="table-responsive">
                                    <div class="table-wrapper">
                                        <div class="table-title">
                                            <div class="row">
                                            </div>
                                        </div>
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Línea</th>
                                                    <th>Código</th>
                                                    <th>Detalle</th>
                                                    <th>Precio unitario</th> 
                                                    <th>Cantidad</th>
                                                    <th>Total</th>                                        
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>123</td>
                                                    <td>Camisa</td>
                                                    <td>8000</td>
                                                    <td><input type="text" placeholder="1" disabled></td>
                                                    <td>8500</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>123</td>
                                                    <td>Pantalon</td>
                                                    <td>8000</td>
                                                    <td><input type="text" placeholder="1" disabled></td>
                                                    <td>8500</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>        
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <h3>Total </h3> 
                                    </div>
                                    <div class="col">
                                        <input type="number" class="form-control" name="total" disabled>
                                    </div>
                                </div>
                            </div>

                            <h3>Pago</h3> 

                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <select class="custom-select" disabled>
                                            <option selected >Condición de Venta</option>
                                            <option value="1" >One</option>
                                            <option value="2" >Two</option>
                                            <option value="3" >Three</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select" disabled>
                                            <option selected >Plazo</option>
                                            <option value="1" >3 Meses</option>
                                            <option value="2" >6 Meses</option>
                                            <option value="3" >12 Meses</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select class="custom-select" disabled>
                                            <option selected >Medio de pago</option>
                                            <option value="1" >One</option>
                                            <option value="2" >Two</option>
                                            <option value="3" >Three</option>
                                        </select>
                                    </div>
                                </div>


                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-info" value="Exportar a PDF">
                            <input type="submit" class="btn btn-info" value="Exportar a XML">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteFacturaModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Borrar Factura</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>¿Seguro/a que desea eliminar los registros de la factura?</p>
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
