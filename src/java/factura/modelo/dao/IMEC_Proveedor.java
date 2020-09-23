package factura.modelo.dao;

public enum IMEC_Proveedor {
    INSERTAR("INSERT INTO `proyecto1`.`proveedor`(`usuario_indentificacion`,`nombre`,`nombreComercial`,`correoElectronico`, `telefonoType_numTelefono`,`ubicacionType_id`) "
            + "VALUES(?,?,?,?,?,?);"),
    MODIFICAR("UPDATE `proyecto1`.`proveedor` SET `nombre` = ?, `nombreComercial` = ?, `correoElectronico` = ? WHERE (`usuario_indentificacion` = ?);"),
//    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT * FROM proveedor WHERE usuario_indentificacion=?; "),
    UBI_ID("SELECT LAST_INSERT_ID() AS ID;"),
    LISTAR("SELECT * FROM proveedor ORDER BY usuario_indentificacion; ");

    IMEC_Proveedor(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
