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
import factura.logic.TelefonoType;
import java.util.NoSuchElementException;

public class ServicioTelefonoType {

    public void insertarTelefonoType(TelefonoType tel) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_TelefonoType.INSERTAR.obtenerComando());) {
            stmt.clearParameters();
            stmt.setInt(1, tel.getNumTelefono());
            stmt.setInt(2, tel.getCodigoPais());
            stmt.executeUpdate();
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<TelefonoType> obtenerTelefonoType(Integer identificacion) {
        Optional<TelefonoType> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_TelefonoType.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new TelefonoType(
                            rs.getInt("numTelefono"),
                            rs.getInt("codigoPais")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | NoSuchElementException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<TelefonoType> obtenerListaTelefonoTypes() {
        List<TelefonoType> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_TelefonoType.LISTAR.obtenerComando())) {
            while (rs.next()) {
                TelefonoType e = new TelefonoType(
                        rs.getInt("numTelefono"),
                        rs.getInt("codigoPais")
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
        ServicioTelefonoType se = new ServicioTelefonoType();
        TelefonoType e2 = new TelefonoType(123, 123);
        se.insertarTelefonoType(e2);
        System.out.println(e2.toString());

        List<TelefonoType> usuarios = se.obtenerListaTelefonoTypes();
        usuarios.forEach((es) -> {
            System.out.println(es.toString());
        });
    }

}
