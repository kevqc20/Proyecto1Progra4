/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

import java.util.Objects;

/**
 *
 * @author kevin
 */
public class Servicio implements java.io.Serializable{
    String codigo;
    String detalle;
    Double precioUnitario;
    Double impuestoNeto;
    Integer impuesto;
    String unidadMedida;
    Proveedor proveedor;

    public Servicio(String codigo, String detalle, Double precioUnitario, Double impuestoNeto, Integer impuesto, String unidadMedida, Proveedor proveedor) {
        this.codigo = codigo;
        this.detalle = detalle;
        this.precioUnitario = precioUnitario;
        this.impuestoNeto = impuestoNeto;
        this.impuesto = impuesto;
        this.unidadMedida = unidadMedida;
        this.proveedor = proveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getImpuestoNeto() {
        return impuestoNeto;
    }

    public void setImpuestoNeto(Double impuestoNeto) {
        this.impuestoNeto = impuestoNeto;
    }

    public Integer getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Integer impuesto) {
        this.impuesto = impuesto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codigo=" + codigo + ", detalle=" + detalle + ", precioUnitario=" + precioUnitario + ", impuestoNeto=" + impuestoNeto + ", impuesto=" + impuesto + ", unidadMedida=" + unidadMedida + ", proveedor=" + proveedor + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servicio other = (Servicio) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
    
    
}
