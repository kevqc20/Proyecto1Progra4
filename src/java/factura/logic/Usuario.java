package factura.logic;

import java.util.Objects;

public class Usuario  implements java.io.Serializable {


     private String identificacion;
     private String password;
     private Integer tipoUsuario;
     private Integer activo;

    public Usuario() {
    }

	
    public Usuario(String cedula) {
        this.identificacion = cedula;
    }
    public Usuario(String cedula, String clave, Integer tipo) {
       this.identificacion = cedula;
       this.password = clave;
       this.tipoUsuario = tipo;
    }
   
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.identificacion, other.identificacion);
    }
    
    

}


