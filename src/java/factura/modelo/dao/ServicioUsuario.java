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

public class ServicioUsuario {

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
        System.out.printf("%s | %s  %n", e.getIdentificacion(), e.getPassword());
//     
//        List<Usuario> usuarios = se.obtenerListaUsuarios();
//        int i = 0;
//        for (Usuario e : usuarios) {
//            System.out.printf("%4d: %s | %s  %n", ++i, e.getIdentificacion(), e.getPassword());
//        }
    }

}
