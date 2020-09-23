/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.presentation.proveedor;

import factura.logic.Proveedor;
import factura.logic.TelefonoType;
import factura.logic.UbicacionType;
import factura.logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProveedorDatosController", urlPatterns = {"/presentation/proveedor/configuracion/show", "/presentation/proveedor/configuracion/update"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/proveedor/configuracion/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/proveedor/configuracion/update":
                viewUrl = this.update(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        factura.logic.Model domainModel = factura.logic.Model.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Proveedor proveedor;
        try {
            proveedor = domainModel.getServProveedor().obtenerProveedor(usuario.getIdentificacion()).get();
        } catch (Exception ex) {
            proveedor = null;
            System.err.printf("Exception: '%s'%n", ex.getMessage());
        }
        try {
            model.setCurrent(proveedor);
            return "/presentation/proveedor/configuracion/View.jsp";
        } catch (Exception ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
            return "";
        }
    }

    private String update(HttpServletRequest request) {
        try {
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.getCurrent().setUsuario(usuario);
            this.updateModel(request);
            return this.updateAction(request);
            
        } catch (Exception e) {
            System.err.printf("Exception: '%s'%n", e.getMessage());
            return "/presentation/proveedor/configuracion/show";
        }
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.getCurrent().getUsuario().setIdentificacion(usuario.getIdentificacion());
        model.getCurrent().getUsuario().setPassword(usuario.getPassword());
        model.getCurrent().getTelefono().setCodigoPais(Integer.valueOf(request.getParameter("codFld")));
        model.getCurrent().getTelefono().setNumTelefono(Integer.valueOf(request.getParameter("telFld")));
        model.getCurrent().getUbicacion().setProvincia(Integer.valueOf(request.getParameter("provinciaFld")));
        model.getCurrent().getUbicacion().setCanton(Integer.valueOf(request.getParameter("cantonFld")));
        model.getCurrent().getUbicacion().setDistrito(Integer.valueOf(request.getParameter("distritoFld")));
        model.getCurrent().getUbicacion().setOtrasSenas(request.getParameter("otrasSenasFld"));
        model.getCurrent().setNombre(request.getParameter("nombFld"));
        model.getCurrent().setNombreComercial(request.getParameter("nombComFld"));
        model.getCurrent().setCorreoElectronico(request.getParameter("emailFld"));
        
        request.setAttribute("model", model);
    }

    public String updateAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        factura.logic.Model domainModel = factura.logic.Model.instance();
        HttpSession session = request.getSession(true);
        try {
            session.setAttribute("proveedor", model.getCurrent());
            domainModel.getServProveedor().modificarProveedor(model.getCurrent());
            return "/presentation/Idle.jsp";
        } catch (Exception ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
            return "/presentation/proveedor/configuracion/View.jsp";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
