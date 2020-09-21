/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.logic;

/**
 *
 * @author Escinf
 */
public class Proveedor implements java.io.Serializable {
    Usuario usuario;
    String nombre;    
    String nombreComercial;   
    String correoElectronico;
    TelefonoType telefono;
    UbicacionType ubicacion;

    public Proveedor(Usuario usuario, String nombre, String nombreComercial, String correoElectronico, TelefonoType telefono, UbicacionType ubicacion) {
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

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TelefonoType getTelefono() {
        return telefono;
    }

    public void setTelefono(TelefonoType telefono) {
        this.telefono = telefono;
    }

    public UbicacionType getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionType ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "usuario=" + usuario.toString() + ", nombre=" + nombre + "\n nombreComercial=" + nombreComercial + ", correoElectronico=" + correoElectronico + "\n telefono=" + telefono.toString() + ", ubicacion=" + ubicacion.toString() + '}';
    }



    
}
