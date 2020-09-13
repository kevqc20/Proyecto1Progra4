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
public class DetalleServicio implements java.io.Serializable {
   Servicio codigo;
   Integer numeroLinea;
   Double cantidad;
   Double montoTotal;
   Double subtotal;
   Double montoTotalLinea;

    public DetalleServicio(Servicio codigo, Integer numeroLinea, Double cantidad, Double montoTotal, Double subtotal, Double montoTotalLinea) {
        this.codigo = codigo;
        this.numeroLinea = numeroLinea;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.subtotal = subtotal;
        this.montoTotalLinea = montoTotalLinea;
    }

    public Servicio getCodigo() {
        return codigo;
    }

    public void setCodigo(Servicio codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMontoTotalLinea() {
        return montoTotalLinea;
    }

    public void setMontoTotalLinea(Double montoTotalLinea) {
        this.montoTotalLinea = montoTotalLinea;
    }

    @Override
    public String toString() {
        return "DetalleServicio{" + "codigo=" + codigo + ", numeroLinea=" + numeroLinea + ", cantidad=" + cantidad + ", montoTotal=" + montoTotal + ", subtotal=" + subtotal + ", montoTotalLinea=" + montoTotalLinea + '}';
    }
   
   
   
}
