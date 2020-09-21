package factura.modelo.dao;

import factura.data.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import factura.logic.UbicacionType;

public class ServicioUbicacionType {

    public Optional<UbicacionType> obtenerUbicacionType(Integer identificacion) {
        Optional<UbicacionType> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_UbicacionType.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new UbicacionType(
                            (Integer) rs.getInt("id"),
                            (Integer) rs.getInt("provincia"),
                            (Integer) rs.getInt("canton"),
                            (Integer) rs.getInt("distrito"),
                            rs.getString("otrasSenas")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<UbicacionType> obtenerListaUbicacionTypes() {
        List<UbicacionType> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_UbicacionType.LISTAR.obtenerComando())) {
            while (rs.next()) {
                UbicacionType e = new UbicacionType(
                        (Integer) rs.getInt("id"),
                        (Integer) rs.getInt("provincia"),
                        (Integer) rs.getInt("canton"),
                        (Integer) rs.getInt("distrito"),
                        rs.getString("otrasSenas")
                );
                r.add(e);
            }
            if (cnx != null) {
                cnx.close();
            }
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }

    public static void main(String[] args) {
        ServicioUbicacionType se = new ServicioUbicacionType();

        List<UbicacionType> usuarios = se.obtenerListaUbicacionTypes();
        int i = 0;
        for (UbicacionType e : usuarios) {
            System.out.printf("%4d: %d  %n", ++i, e.getId());
        }
    }

}
