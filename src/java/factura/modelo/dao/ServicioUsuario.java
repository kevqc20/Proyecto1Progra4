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
import factura.logic.Usuario;
import java.sql.CallableStatement;
import java.util.NoSuchElementException;

public class ServicioUsuario {

    public void insertarUsuario(Usuario user) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());
                PreparedStatement stmt2 = cnx.prepareStatement(IMEC_Usuario.INSERTARID.obtenerComando());) {
            stmt2.clearParameters();
            stmt2.setInt(1, Integer.valueOf(user.getIdentificacion()));
            stmt2.setInt(2, user.getTipoID());
            stmt2.executeUpdate();
            stmt.clearParameters();
            stmt.setInt(1, Integer.valueOf(user.getIdentificacion()));
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getActivo());
            stmt.setInt(4, user.getTipoUsuario());
            stmt.executeUpdate();
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Usuario> obtenerUsuario(String identificacion) {
        Optional<Usuario> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Usuario(
                            rs.getString("identificacion"),
                            rs.getString("password"),
                            rs.getInt("activo"),
                            rs.getInt("tipoUsuario")
                    ));
                }
            }
        } catch (IOException
                | NoSuchElementException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<Usuario> obtenerListaUsuarios() {
        List<Usuario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Usuario e = new Usuario(
                        rs.getString("identificacion"),
                        rs.getString("password"),
                        rs.getInt("activo"),
                        rs.getInt("tipoUsuario")
                );
                r.add(e);
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
        ServicioUsuario se = new ServicioUsuario();
        Usuario e = se.obtenerUsuario("111").get();
        Usuario e2 = new Usuario("333", "333", 1, 1);
        se.insertarUsuario(e2);
        System.out.println(e2.toString());

        List<Usuario> usuarios = se.obtenerListaUsuarios();
        usuarios.forEach((es) -> {
            System.out.println(es.toString());
        });
    }

}
