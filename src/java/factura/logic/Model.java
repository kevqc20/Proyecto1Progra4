/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

import factura.modelo.dao.ServicioProveedor;
import factura.modelo.dao.ServicioTelefonoType;
import factura.modelo.dao.ServicioUbicacionType;
import factura.modelo.dao.ServicioUsuario;

/**
 *
 * @author Escinf
 */
public class Model {
    private static Model uniqueInstance;
    private final ServicioUsuario servUsuario;
    private final ServicioProveedor servProveedor;
    private final ServicioTelefonoType servTelType;
    private final ServicioUbicacionType servUbiType;
    
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }
    
    private Model(){
        this.servUsuario = new ServicioUsuario();
        this.servProveedor = new ServicioProveedor();
        this.servTelType = new ServicioTelefonoType();
        this.servUbiType = new ServicioUbicacionType();
    }

    public ServicioProveedor getServProveedor() {
        return servProveedor;
    }

    public ServicioTelefonoType getServTelType() {
        return servTelType;
    }

    public ServicioUbicacionType getServUbiType() {
        return servUbiType;
    }

    public ServicioUsuario getServUsuario() {
        return servUsuario;
    }

    
}
