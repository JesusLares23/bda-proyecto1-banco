
package daos;

import bancodominio.Cliente;
import conexion.IConexionBD;
import dtos.ClienteDTO;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class ClienteDAO implements IClienteDAO {

    IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Clientes (nombres, apellido_paterno, "
                + "apellido_materno, fecha_nacimiento, id_domicilio) "
                + "VALUES (?,?,?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setString(1, cliente.getNombres());
            comandoSQL.setString(2, cliente.getApellido_paterno());
            comandoSQL.setString(3, cliente.getApellido_materno());
            comandoSQL.setString(4, cliente.getFecha_nacimiento());
            comandoSQL.setInt(5, cliente.getId_domicilio());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", 
                    registrosModificados);
            
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();
            
            Cliente clienteNuevo = new Cliente(
                    registroGenerado.getInt(1),
                    cliente.getNombres(),
                    cliente.getApellido_paterno(),
                    cliente.getApellido_materno(),
                    cliente.getFecha_nacimiento(),
                    cliente.getId_domicilio()
                );
            
            return clienteNuevo;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se agrego con exito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente", e);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "UPDATE CLIENTES SET nombres = ?, apellido_paterno = ?, "
                + "apellido_materno = ?, fecha_nacimiento = ?, id_domicilio = ? "
                + "WHERE id_cliente = ?";

        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setString(1, cliente.getNombres());
            comandoSQL.setString(2, cliente.getApellido_paterno());
            comandoSQL.setString(3, cliente.getApellido_materno());
            comandoSQL.setInt(4, cliente.getId_domicilio());
            comandoSQL.setInt(5, cliente.getId_cliente());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se actualizó con éxito {0} ", registrosModificados);
            
            return consultarClientePorID(cliente.getId_cliente());
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new PersistenciaException("No se pudo actualizar el cliente ", e);
        }
    }    
    
    @Override
    public Cliente consultarClientePorID(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE id_cliente = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setInt(1, id);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            Cliente clienteConsultado = new Cliente(
                    resultado.getInt("id_cliente"),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5),
                    resultado.getInt(6)
            );
            
            return clienteConsultado;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontro el cliente", e);
            throw new PersistenciaException("No se encontro el cliente", e);
        }
    }

    @Override
    public List<Cliente> consultarTodosClientes() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes";
        List<Cliente> listaClientes = new ArrayList<>();
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()) {
                int idCliente = resultado.getInt("id_cliente");
                String nombres = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                String fechaNacimiento = resultado.getString("fecha_nacimiento");
                int idDomicilio = resultado.getInt("id_domicilio");
                Cliente cliente = new Cliente(idCliente, nombres, 
                        apellidoPaterno, apellidoMaterno, 
                        fechaNacimiento, idDomicilio);
                listaClientes.add(cliente); 
            }
            LOG.log(Level.INFO, "Se encontraron {0} clientes ", 
                    listaClientes.size());
            
            return listaClientes;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron clientes", e);
            throw new PersistenciaException("No se encontraron clientes", e);
        }
    }

}
