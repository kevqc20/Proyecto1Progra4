/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.presentation.proveedor;

import factura.logic.Cliente;
import factura.logic.Proveedor;

/**
 *
 * @author Escinf
 */
public class Model{
    Proveedor current;

    public Model() {
        //current = new Proveedor("",0.0,null);
    }

    public Proveedor getCurrent() {
        return current;
    }

    public void setCurrent(Proveedor current) {
        this.current = current;
    }

}
