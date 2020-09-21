package factura.modelo.dao;

public enum IMEC_Proveedor {
//    INSERTAR("INSERT INTO estudiante (id, apellidos, nombre) VALUES (?, ?, ?); "),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT * FROM proveedor WHERE usuario_indentificacion=?; "),
    LISTAR("SELECT * FROM proveedor ORDER BY usuario_indentificacion; ");

    IMEC_Proveedor(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
