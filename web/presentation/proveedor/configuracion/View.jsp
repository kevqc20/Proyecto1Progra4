<%-- 
    Document   : View
    Author     : kevin
--%>

<%@page import="factura.presentation.proveedor.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="../../../css/default.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Perfil</title>
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>
        <% Model model = (Model) request.getAttribute("model");%>

        <div class="signup-form">
            <form action= "/Proyecto1/presentation/proveedor/configuracion/update" method="post">
                <h2>Perfil</h2>
                <div class="form-group">
                    <input type="text" class="form-control" name="identificacionFld" placeholder="Identificación" value="<%=model.getCurrent().getUsuario().getIdentificacion()%>" readonly="readonly">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="passwordFld" placeholder="Contraseña" required="required" value="<%=model.getCurrent().getUsuario().getPassword()%>" readonly="readonly">
                </div>    
                <div class="form-group">
                    <input type="text" class="form-control is-valid" name="nombFld" placeholder="Nombre de la empresa" required="required" value="<%=model.getCurrent().getNombre()%>">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control is-valid" name="nombComFld" placeholder="Nombre comercial de la empresa" value="<%=model.getCurrent().getNombreComercial()%>">
                </div>  
                <div class="form-group">
                    <input type="email" class="form-control is-valid" name="emailFld" placeholder="Correo electrónico" required="required" value="<%=model.getCurrent().getCorreoElectronico()%>">
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col"><input type="text" class="form-control" name="codFld" value="<%=model.getCurrent().getTelefono().getCodigoPais()%>" readonly="readonly">Codigo del país</div> 
                        <div class="col"><input type="text" class="form-control" name="telFld" value="<%=model.getCurrent().getTelefono().getNumTelefono()%>" readonly="readonly">Teléfono</div>

                    </div>        	
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col">
                            <div class="col"><input type="text" class="form-control" name="provinciaFld" value="<%=model.getCurrent().getUbicacion().getProvincia()%>" readonly="readonly">Provincia</div>
                        </div>
                        <div class="col">
                            <div class="col"><input type="text" class="form-control" name="cantonFld" value="<%=model.getCurrent().getUbicacion().getCanton()%>" readonly="readonly">Cantón</div>
                        </div>
                        <div class="col">
                            <div class="col"><input type="text" class="form-control" name="distritoFld" value="<%=model.getCurrent().getUbicacion().getDistrito()%>" readonly="readonly">Distrito</div>
                        </div>
                    </div> 
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="otrasSenasFld" placeholder="Otras Señas" value="<%=model.getCurrent().getUbicacion().getOtrasSenas()%>" readonly="readonly">
                </div>
                <div class="form-group">
                    <% System.out.println(request.getServletPath());%>
                    <button type="submit" class="btn btn-success btn-lg btn-block">Confirmar cambios</button>
                    <% System.out.println(request.getServletPath());%>
                </div>
            </form>
        </div>
    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>
