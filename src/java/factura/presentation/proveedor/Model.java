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

/**
 *
 * @author Escinf
 */
public class Model{
    Proveedor current;

    public Model() {
        this.current = new Proveedor(
                new Usuario("","",1,1), 
                "",
                "",
                "",
                new TelefonoType(0,0),
                new UbicacionType(0,0,0,"")
        );
    }

    
    public Proveedor getCurrent() {
        return current;
    }

    public void setCurrent(Proveedor current) {
        this.current = current;
    }
    
    
}
