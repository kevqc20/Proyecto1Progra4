package factura.modelo.dao;

public enum IMEC_UbicacionType {
//    INSERTAR("INSERT INTO estudiante (id, apellidos, nombre) VALUES (?, ?, ?); "),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT * FROM ubicaciontype WHERE id=?; "),
    LISTAR("SELECT * FROM ubicaciontype ORDER BY id; ");

    IMEC_UbicacionType(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
