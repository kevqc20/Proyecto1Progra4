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
    
    public void insertarUbicacionType(UbicacionType ubi) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_UbicacionType.INSERTAR.obtenerComando());) {
            stmt.clearParameters();
            stmt.setInt(1, ubi.getProvincia());
            stmt.setInt(2, ubi.getCanton());
            stmt.setInt(3, ubi.getDistrito());
            stmt.setString(4, ubi.getOtrasSenas());
            stmt.executeUpdate();
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

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
        UbicacionType e2 = new UbicacionType(2,2,2,"-");
        se.insertarUbicacionType(e2);
        System.out.println(e2.toString());

        List<UbicacionType> usuarios = se.obtenerListaUbicacionTypes();
        usuarios.forEach((es) -> {
            System.out.println(es.toString());
        });
    }

}
