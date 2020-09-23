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

/**
 *
 * @author kev
 */
public class Model {
    Usuario user;
    TelefonoType tel;
    UbicacionType ubi;
    Proveedor current = null;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Proveedor());        
    }
    
    public Proveedor getCurrent() {
        return current;
    }

    public void setCurrent(Proveedor current) {
        this.current = current;
    }
   
}
