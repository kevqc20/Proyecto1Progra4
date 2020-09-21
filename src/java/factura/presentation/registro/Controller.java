/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.presentation.registro;

import factura.presentation.login.*;
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

/**
 *
 * @author kev
 */
@WebServlet(name = "RegistroController", urlPatterns = {"/presentation/registro/show"})
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
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

//    void updateModel(HttpServletRequest request) {
//        Model model = (Model) request.getAttribute("model");
//
//        model.getCurrent().setIdentificacion(request.getParameter("cedulaFld"));
//        model.getCurrent().setPassword(request.getParameter("claveFld"));
//    }

    public String loginAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        factura.logic.Model domainModel = factura.logic.Model.instance();
        HttpSession session = request.getSession(true);
        String aux = model.getCurrent().getIdentificacion();
        try {
            domainModel.getServUsuario().obtenerUsuario(aux)
                    .ifPresent(e -> request.setAttribute("usuario", (Usuario) e));
            Usuario real = (Usuario) request.getAttribute("usuario");
            String viewUrl = "";
            if (real.getPassword() == null ? request.getParameter("claveFld") == null : real.getPassword().equals(request.getParameter("claveFld"))) {
                switch (real.getTipoUsuario()) {
                    case 0:
                        viewUrl = "/presentation/administrador/listarProveedores/show";
                        break;
                    case 1:
                        viewUrl = "/presentation/proveedor/configuracion/View.jsp";
                        break;
                }
                session.setAttribute("usuario", real);
            } else {
                throw new Exception();
            }
            return viewUrl;
        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Usuario o clave incorrectos");
            errores.put("claveFld", "Usuario o clave incorrectos");
            return "/presentation/login/show";
        }
    }


    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setIdentificacion("");
        model.getCurrent().setPassword("");
        return "/presentation/Index.jsp";
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
