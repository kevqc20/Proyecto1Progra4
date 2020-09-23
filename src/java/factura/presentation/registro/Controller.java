/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.presentation.registro;

import factura.logic.Proveedor;
import factura.logic.TelefonoType;
import factura.logic.UbicacionType;
import factura.logic.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kev
 */
@WebServlet(name = "RegistroController", urlPatterns = {"/presentation/registro/show", "/presentation/registro/registro"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/registro/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/registro/registro":
                viewUrl = this.register(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("identificacionFld").isEmpty()) {
            errores.put("identificacionFld", "Identificacion requerida");
        }
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Proveedor prov = new Proveedor();

        Usuario user = new Usuario(
                request.getParameter("identificacionFld"),
                request.getParameter("passwordFld"),
                0, 1
        );
        TelefonoType tel = new TelefonoType(
                Integer.valueOf(request.getParameter("codigoFld")),
                Integer.valueOf(request.getParameter("telFld"))
        );
        UbicacionType ubi = new UbicacionType(
                Integer.valueOf(request.getParameter("provinciaFld")),
                Integer.valueOf(request.getParameter("cantonFld")),
                Integer.valueOf(request.getParameter("distritoFld")),
                request.getParameter("otrasSenasFld")
        );
        prov = new Proveedor(
                user,
                request.getParameter("nombFld"),
                request.getParameter("nombComerFld"),
                request.getParameter("emailFld"),
                tel,
                ubi
        );

        model.setCurrent(prov);

    }

    private String register(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.registerAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/registro/View.jsp";
            }
        } catch (Exception e) {
            return "/presentation/registro/View.jsp";
        }
    }

    public String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        factura.logic.Model domainModel = factura.logic.Model.instance();
        Proveedor aux = model.getCurrent();
        try {
            Usuario id = null;
            TelefonoType tel = null;
            try {
                id = domainModel.getServUsuario().obtenerUsuario(aux.getUsuario().getIdentificacion()).get();
            } catch (Exception ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
            try {
                tel = domainModel.getServTelType().obtenerTelefonoType(aux.getTelefono().getNumTelefono()).get();
            } catch (Exception ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }

            if (id == null && tel == null) {
                domainModel.getServProveedor().insertarProveedor(aux);
                return "/presentation/registro/Completed.jsp";
            } else {
                throw new Exception();
            }
        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("identificacionFld", "Usuario o Telefono existente");
            errores.put("telFld", "Usuario o Telefono existente");
            return "/presentation/registro/show";
        }
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Proveedor aux = new Proveedor();
        model.setCurrent(aux);

        return "/presentation/registro/View.jsp";
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
