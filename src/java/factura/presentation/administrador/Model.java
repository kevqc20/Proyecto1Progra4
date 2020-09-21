/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.presentation.administrador;

import factura.logic.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Model{
    List<Proveedor> cuentas;
    Proveedor seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Proveedor> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setCuentas(rows);
    }
    
    public void setCuentas(List<Proveedor> cuentas){
        this.cuentas =cuentas;    
    }

     public List<Proveedor> getCuentas() {
        return cuentas;
    }

    public Proveedor getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proveedor seleccionado) {
        this.seleccionado = seleccionado;
    }
}
