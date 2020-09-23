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
import factura.logic.Proveedor;
import factura.logic.TelefonoType;
import factura.logic.UbicacionType;
import factura.logic.Usuario;

public class ServicioProveedor {

    public void modificarProveedor(Proveedor prov) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Proveedor.MODIFICAR.obtenerComando()) ){
            stmt.clearParameters();
            stmt.setString(1, prov.getNombre());
            stmt.setString(2, prov.getNombreComercial());
            stmt.setString(3, prov.getCorreoElectronico());
            stmt.setString(4, prov.getUsuario().getIdentificacion());
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void insertarProveedor(Proveedor prov) {
        try (
                Connection cnx = obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement(IMEC_Proveedor.INSERTAR.obtenerComando());
                PreparedStatement stmt2 = cnx.prepareStatement(IMEC_Usuario.INSERTARID.obtenerComando());
                PreparedStatement stmt3 = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());
                PreparedStatement stmt4 = cnx.prepareStatement(IMEC_TelefonoType.INSERTAR.obtenerComando());
                PreparedStatement stmt5 = cnx.prepareStatement(IMEC_UbicacionType.INSERTAR.obtenerComando());
                PreparedStatement stmt6 = cnx.prepareStatement(IMEC_Proveedor.UBI_ID.obtenerComando());) {

            // Creacion del ID
            stmt2.clearParameters();
            stmt2.setInt(1, Integer.valueOf(prov.getUsuario().getIdentificacion()));
            stmt2.setInt(2, prov.getUsuario().getTipoID());
            stmt2.executeUpdate();

            // Creacion del Usuario
            stmt3.clearParameters();
            stmt3.setInt(1, Integer.valueOf(prov.getUsuario().getIdentificacion()));
            stmt3.setString(2, prov.getUsuario().getPassword());
            stmt3.setInt(3, prov.getUsuario().getActivo());
            stmt3.setInt(4, prov.getUsuario().getTipoUsuario());
            stmt3.executeUpdate();

            // Creacion del TelefonoType
            stmt4.clearParameters();
            stmt4.setInt(1, prov.getTelefono().getNumTelefono());
            stmt4.setInt(2, prov.getTelefono().getCodigoPais());
            stmt4.executeUpdate();

            // Creacion de la UbicacionType
            stmt5.clearParameters();
            stmt5.setInt(1, prov.getUbicacion().getProvincia());
            stmt5.setInt(2, prov.getUbicacion().getCanton());
            stmt5.setInt(3, prov.getUbicacion().getDistrito());
            stmt5.setString(4, prov.getUbicacion().getOtrasSenas());
            stmt5.executeUpdate();

            int ubi_id = 0;
            try (ResultSet rs = stmt6.executeQuery()) {
                if (rs.next()) {
                    ubi_id = rs.getInt("ID");
                    prov.getUbicacion().setId(ubi_id);
                }
            }

            // Creacion del Proveedor
            stmt.clearParameters();
            stmt.setInt(1, Integer.valueOf(prov.getUsuario().getIdentificacion()));
            stmt.setString(2, prov.getNombre());
            stmt.setString(3, prov.getNombreComercial());
            stmt.setString(4, prov.getCorreoElectronico());
            stmt.setInt(5, prov.getTelefono().getNumTelefono());
            stmt.setInt(6, ubi_id);
            stmt.executeUpdate();

        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Optional<Proveedor> obtenerProveedor(String identificacion) {
        Optional<Proveedor> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Proveedor.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, identificacion);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    // Creacion del usuario para proveedor
                    Optional<Usuario> user = Optional.empty();
                    PreparedStatement stm2 = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());
                    {
                        stm2.clearParameters();
                        stm2.setString(1, rs.getString("usuario_indentificacion"));
                        try (ResultSet rs2 = stm2.executeQuery()) {
                            if (rs2.next()) {
                                user = Optional.of(new Usuario(
                                        rs2.getString("identificacion"),
                                        rs2.getString("password"),
                                        rs2.getInt("activo"),
                                        rs2.getInt("tipoUsuario")
                                ));
                            }
                        }
                    }

                    //Creacion del telefonoType para proveedor
                    Optional<TelefonoType> tel = Optional.empty();
                    PreparedStatement stm3 = cnx.prepareStatement(IMEC_TelefonoType.CONSULTAR.obtenerComando());
                    {
                        stm3.clearParameters();
                        stm3.setInt(1, rs.getInt("telefonoType_numTelefono"));
                        try (ResultSet rs3 = stm3.executeQuery()) {
                            if (rs3.next()) {
                                tel = Optional.of(new TelefonoType(
                                        rs3.getInt("numTelefono"),
                                        rs3.getInt("codigoPais")
                                ));
                            }
                        }
                    }

                    //Creacion de ubicacionType para proveedor
                    Optional<UbicacionType> ubi = Optional.empty();
                    PreparedStatement stm4 = cnx.prepareStatement(IMEC_UbicacionType.CONSULTAR.obtenerComando());
                    {
                        stm4.clearParameters();
                        stm4.setInt(1, rs.getInt("ubicacionType_id"));
                        try (ResultSet rs4 = stm4.executeQuery()) {
                            if (rs4.next()) {
                                ubi = Optional.of(new UbicacionType(
                                        (Integer) rs4.getInt("id"),
                                        (Integer) rs4.getInt("provincia"),
                                        (Integer) rs4.getInt("canton"),
                                        (Integer) rs4.getInt("distrito"),
                                        rs4.getString("otrasSenas")
                                ));
                            }
                        }
                    }

                    //Creacion del proveedor
                    r = Optional.of(new Proveedor(
                            user.get(),
                            rs.getString("nombre"),
                            rs.getString("nombreComercial"),
                            rs.getString("correoElectronico"),
                            tel.get(),
                            ubi.get()
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

    public List<Proveedor> obtenerListaProveedors() {
        List<Proveedor> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Proveedor.LISTAR.obtenerComando())) {
            while (rs.next()) {
                // Creacion del usuario para proveedor
                Optional<Usuario> user = Optional.empty();
                PreparedStatement stm2 = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());
                {
                    stm2.clearParameters();
                    stm2.setString(1, rs.getString("usuario_indentificacion"));
                    try (ResultSet rs2 = stm2.executeQuery()) {
                        if (rs2.next()) {
                            user = Optional.of(new Usuario(
                                    rs2.getString("identificacion"),
                                    rs2.getString("password"),
                                    rs2.getInt("activo"),
                                    rs2.getInt("tipoUsuario")
                            ));
                        }
                    }
                }

                //Creacion del telefonoType para proveedor
                Optional<TelefonoType> tel = Optional.empty();
                PreparedStatement stm3 = cnx.prepareStatement(IMEC_TelefonoType.CONSULTAR.obtenerComando());
                {
                    stm3.clearParameters();
                    stm3.setInt(1, rs.getInt("telefonoType_numTelefono"));
                    try (ResultSet rs3 = stm3.executeQuery()) {
                        if (rs3.next()) {
                            tel = Optional.of(new TelefonoType(
                                    rs3.getInt("numTelefono"),
                                    rs3.getInt("codigoPais")
                            ));
                        }
                    }
                }

                //Creacion de ubicacionType para proveedor
                Optional<UbicacionType> ubi = Optional.empty();
                PreparedStatement stm4 = cnx.prepareStatement(IMEC_UbicacionType.CONSULTAR.obtenerComando());
                {
                    stm4.clearParameters();
                    stm4.setInt(1, rs.getInt("ubicacionType_id"));
                    try (ResultSet rs4 = stm4.executeQuery()) {
                        if (rs4.next()) {
                            ubi = Optional.of(new UbicacionType(
                                    (Integer) rs4.getInt("id"),
                                    (Integer) rs4.getInt("provincia"),
                                    (Integer) rs4.getInt("canton"),
                                    (Integer) rs4.getInt("distrito"),
                                    rs4.getString("otrasSenas")
                            ));
                        }
                    }
                }

                //Creacion del proveedor
                Proveedor e = new Proveedor(
                        user.get(),
                        rs.getString("nombre"),
                        rs.getString("nombreComercial"),
                        rs.getString("correoElectronico"),
                        tel.get(),
                        ubi.get()
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
        ServicioProveedor se = new ServicioProveedor();

        Usuario user = new Usuario(
                "666",
                "666",
                0, 1
        );
        TelefonoType tel = new TelefonoType(
                6666,
                666
        );
        UbicacionType ubi = new UbicacionType(
                6,
                6,
                6,
                "hell"
        );
        Proveedor prov = new Proveedor(
                user,
                "sat",
                "baal",
                "sat@baal.com",
                tel,
                ubi
        );

        se.modificarProveedor(prov);

        List<Proveedor> usuarios = se.obtenerListaProveedors();
        usuarios.forEach((es) -> {
            System.out.println("--------------------------");
            System.out.println(es.toString());
        });
    }

}
