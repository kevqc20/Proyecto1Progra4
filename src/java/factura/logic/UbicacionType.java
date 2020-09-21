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
public class UbicacionType {

    Integer id;
    Integer provincia;
    Integer canton;
    Integer distrito;
    String otrasSenas;

    public UbicacionType(Integer id, Integer provincia, Integer canton, Integer distrito, String otrasSenas) {
        this.id = id;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.otrasSenas = otrasSenas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvincia() {
        return provincia;
    }

    public void setProvincia(Integer provincia) {
        this.provincia = provincia;
    }

    public Integer getCanton() {
        return canton;
    }

    public void setCanton(Integer canton) {
        this.canton = canton;
    }

    public Integer getDistrito() {
        return distrito;
    }

    public void setDistrito(Integer distrito) {
        this.distrito = distrito;
    }

    public String getOtrasSenas() {
        return otrasSenas;
    }

    public void setOtrasSenas(String otrasSenas) {
        this.otrasSenas = otrasSenas;
    }

    @Override
    public String toString() {
        return "UbicacionType{" + "id=" + id + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", otrasSenas=" + otrasSenas + '}';
    }

    
}
