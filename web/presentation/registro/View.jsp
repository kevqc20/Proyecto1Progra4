<%-- 
    Document   : View
    Author     : kevin
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="factura.presentation.registro.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="../../css/default.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Registro</title>
        <%@ include file="/presentation/Header.jsp" %>
    </head>
    <body>


        <% Model model = (Model) request.getAttribute("model"); %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>

        <div class="signup-form">
            <form action="/Proyecto1/presentation/registro/registro" method="post">
                <h2>Registro</h2>
                <div class="form-group">
                    <input type="text" class="<%=erroneo("identificacionFld", errores)%>" name="identificacionFld" placeholder="Identificación" required="required" value="<%=form.get("identificacionFld")[0]%>" title="<%=title("identificacionFld", errores)%>">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="passwordFld" placeholder="Contraseña" required="required">
                </div>    

                <div class="form-group">
                    <input type="text" class="form-control" name="nombFld" placeholder="Nombre de la empresa" required="required" value="<%=form.get("nombFld")[0]%>">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="nombComerFld" placeholder="Nombre comercial de la empresa" value="<%=form.get("nombComerFld")[0]%>" required="required">
                </div>  
                <div class="form-group">
                    <input type="email" class="form-control" name="emailFld" placeholder="Correo electrónico" required="required" value="<%=form.get("emailFld")[0]%> ">
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col"><input type="number" class="form-control" name="codigoFld" min='0' required="required">Codigo del país</div>
                        <div class="col"><input type="number" class="form-control" name="telFld" min='0' max='99999999999999999999' required="required">Teléfono</div>
                    </div>        	
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col">
                            <select class="custom-select" name="provinciaFld" >
                                <option selected value="0" >Provincia</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div class="col">
                            <select class="custom-select" name="cantonFld">
                                <option selected value="0">Cantón</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div class="col">
                            <select class="custom-select" name="distritoFld">
                                <option selected value="0">Distrito</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div> 
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="otrasSenasFld" placeholder="Otras Señas" value="<%=form.get("otrasSenasFld")[0]%>" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Registrarse</button>
                </div>
            </form>
            <div class="text-center">¿Ya tienes una cuenta? <a href="/Proyecto1/presentation/login/show">¡Inicia sesión!</a></div>
        </div>

    </body>
    <%@ include file="/presentation/Footer.jsp" %>
</html>


<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "form-control is-invalid";
        } else {
            return "form-control";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<>();
        if (model.getCurrent().getUsuario() != null) {
            values.put("identificacionFld", new String[]{model.getCurrent().getUsuario().getIdentificacion()});
            values.put("otrasSenasFld", new String[]{model.getCurrent().getUbicacion().getOtrasSenas()});
            values.put("nombFld", new String[]{model.getCurrent().getNombre()});
            values.put("nombComerFld", new String[]{model.getCurrent().getNombreComercial()});
            values.put("emailFld", new String[]{model.getCurrent().getCorreoElectronico()});
        } else {
            values.put("identificacionFld", new String[]{""});
            values.put("otrasSenasFld", new String[]{""});
            values.put("nombFld", new String[]{""});
            values.put("nombComerFld", new String[]{""});
            values.put("emailFld", new String[]{""});
        }
        return values;
    }
%> 