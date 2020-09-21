package factura.logic;

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
    public Usuario(String cedula, String clave,Integer activo, Integer tipo) {
       this.identificacion = cedula;
       this.password = clave;
       this.tipoUsuario = tipo;
       this.activo = activo;
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

}


