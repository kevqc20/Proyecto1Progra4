/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

import java.util.Objects;

/**
 *
 * @author Escinf
 */
public class Proveedor implements java.io.Serializable {
    Usuario usuario;
    String nombre;    
    String nombreComercial;   
    String correoElectronico;
    Integer telefono;
    String ubicacion;

    public Proveedor(Usuario usuario, String nombre, String nombreComercial, String correoElectronico, Integer telefono, String ubicacion) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.nombreComercial = nombreComercial;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        final Proveedor other = (Proveedor) obj;
        return Objects.equals(this.usuario.getIdentificacion(), other.usuario.getIdentificacion());
    }

    
}
