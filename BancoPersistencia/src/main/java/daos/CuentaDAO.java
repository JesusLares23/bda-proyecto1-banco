
package daos;

import bancodominio.Cuenta;
import conexion.IConexionBD;
import dtos.CuentaDTO;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class CuentaDAO implements ICuentaDAO {

    IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Cuentas (num_cuenta, apertura, "
                + "saldo, estado, id_cliente) "
                + "VALUES (?,?,?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setInt(1, cuenta.getNum_cuenta());
            comandoSQL.setString(2, cuenta.getApertura());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getEstado());
            comandoSQL.setInt(5, cuenta.getId_cliente());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", 
                    registrosModificados);
            
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();
            
            Cuenta cuentaNueva = new Cuenta(
                    registroGenerado.getInt(1),
                    cuenta.getNum_cuenta(),
                    cuenta.getApertura(),
                    cuenta.getSaldo(),
                    cuenta.getEstado(),
                    cuenta.getId_cliente()
                );
            
            return cuentaNueva;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agrego con exito la cuenta", e);
            throw new PersistenciaException("No se pudo guardar el cliente", e);
        }
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Cuentas SET numero_cuenta = ?, fecha_apertura = ?, "
                + "saldo = ?, estado = ?, id_cliente = ? "
                + "WHERE id_cuenta = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ){
            comandoSQL.setInt(1, cuenta.getNum_cuenta());
            comandoSQL.setString(2, cuenta.getApertura());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getEstado());
            comandoSQL.setInt(5, cuenta.getId_cliente());
            comandoSQL.setInt(6, cuenta.getId_cuenta());
                    
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se actualizó con éxito {0} ", registrosModificados);
            
            return consultarCuentaPorID(registrosModificados);
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new PersistenciaException("No se pudo actualizar el cliente ", e);
        }
    }

    @Override
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Cuentas WHERE id_cuenta = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setInt(1, id);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            Cuenta cuentaConsultada = new Cuenta(
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
    public List<Cuenta> consultarTodosCuentas() throws PersistenciaException {
    }
    
}
