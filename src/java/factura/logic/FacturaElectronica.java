/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author kevin
 */
public class FacturaElectronica implements java.io.Serializable  {
    Integer clave;
    LocalDate fechaEmision;
    Integer plazoCredito;
    Integer medioPago;
    Cliente cliente;
    Proveedor proveedor;
    List<DetalleServicio> listServicios;
    Integer codigoActividad;
    Integer condicionVenta;

    public FacturaElectronica(Integer clave, LocalDate fechaEmision, Integer medioPago, Cliente cliente, Proveedor proveedor, List<DetalleServicio> listServicios, Integer codigoActividad, Integer condicionVenta) {
        this.clave = clave;
        this.fechaEmision = fechaEmision;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.proveedor = proveedor;
        this.listServicios = listServicios;
        this.codigoActividad = codigoActividad;
        this.condicionVenta = condicionVenta;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getPlazoCredito() {
        return plazoCredito;
    }

    public void setPlazoCredito(Integer plazoCredito) {
        this.plazoCredito = plazoCredito;
    }

    public Integer getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(Integer medioPago) {
        this.medioPago = medioPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleServicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<DetalleServicio> listServicios) {
        this.listServicios = listServicios;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(Integer condicionVenta) {
        this.condicionVenta = condicionVenta;
    }
    
    
}
