/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

/**
 *
 * @author kevin
 */
public class TelefonoType {
    Integer numTelefono;
    Integer codigoPais;

    public TelefonoType(Integer numTelefono, Integer codigoPais) {
        this.numTelefono = numTelefono;
        this.codigoPais = codigoPais;
    }

    public Integer getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Integer numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Integer getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Integer codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public String toString() {
        return "TelefonoType{" + "numTelefono=" + numTelefono + ", codigoPais=" + codigoPais + '}';
    }
    
    
}
