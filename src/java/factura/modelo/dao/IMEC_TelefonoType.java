package factura.modelo.dao;

public enum IMEC_TelefonoType {
    INSERTAR("INSERT INTO `proyecto1`.`telefonotype`(`numTelefono`,`codigoPais`)VALUES(?, ?);"),
//    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT * FROM telefonotype WHERE numTelefono=?; "),
    LISTAR("SELECT * FROM telefonotype ORDER BY numTelefono; ");

    IMEC_TelefonoType(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
