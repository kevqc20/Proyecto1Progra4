<%-- 
    Document   : Header
    Author     : kevin
--%>
<%@page import="factura.logic.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");  %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3">
        <div class="container-fluid">
            <a class="navbar-brand mr-3">Factura Electrónica</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav">
                    <a href="#" class="nav-item nav-link">Acerca de</a>
                    <a href="#" class="nav-item nav-link">Contacto</a>
                    
                    <% if (usuario != null && usuario.getTipoUsuario() == 0) { %>
                    <a href= "/Proyecto1/presentation/administrador/listarProveedores/show" class="nav-item nav-link">Listado de proveedores</a>
                    </div>
                    <div class="navbar-nav ml-auto">
                    <a href= "/Proyecto1/presentation/login/logout" class="nav-item nav-link" >Logout</a>
                    </div>
                    <% } %>
                    
                    <% if (usuario != null && usuario.getTipoUsuario() == 1 && usuario.getActivo() == 1) { %>
                    <a href="/Proyecto1/presentation/proveedor/configuracion/show" class="nav-item nav-link">Perfil</a>
                    <a href="/Proyecto1/presentation/proveedor/registroClientes/View.jsp" class="nav-item nav-link">Clientes frecuentes</a>
                    <a href="/Proyecto1/presentation/proveedor/registroServicios/View.jsp" class="nav-item nav-link">Servicios</a>
                    <a href="/Proyecto1/presentation/proveedor/listarFacturas/View.jsp" class="nav-item nav-link">Listado de facturas</a>
                    <a href="/Proyecto1/presentation/proveedor/facturar/View.jsp" class="nav-item nav-link">Facturar</a>
                    </div>
                    <div class="navbar-nav ml-auto">
                    <a href="/Proyecto1/presentation/login/logout" class="nav-item nav-link" >Logout</a>
                    </div>
                    <% } %>
                    </div>
                    <% if (usuario == null || usuario.getActivo() == 0) {%>
                    <div class="navbar-nav ml-auto">
                        <a href="/Proyecto1/presentation/registro/show" class="nav-item nav-link">Registro</a>
                        <a href="/Proyecto1/presentation/login/show" class="nav-item nav-link">Iniciar sesión</a>
                    </div>
                    <% }%> 
    </nav>
</header>