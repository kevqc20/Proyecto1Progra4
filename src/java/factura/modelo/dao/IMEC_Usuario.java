package factura.modelo.dao;

public enum IMEC_Usuario {
//    INSERTAR("INSERT INTO estudiante (id, apellidos, nombre) VALUES (?, ?, ?); "),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT * FROM usuario WHERE identificacion=?; "),
    LISTAR("SELECT * FROM usuario ORDER BY identificacion; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
