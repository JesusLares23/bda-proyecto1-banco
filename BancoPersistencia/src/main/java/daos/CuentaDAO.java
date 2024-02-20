
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
import java.util.ArrayList;
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
                + "saldo, contra, estado, id_cliente) "
                + "VALUES (?,?,?,?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setInt(1, cuenta.getNum_cuenta());
            comandoSQL.setString(2, cuenta.getApertura());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getContra());
            comandoSQL.setString(5, cuenta.getEstado());
            comandoSQL.setInt(6, cuenta.getId_cliente());
            
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
                    cuenta.getContra(),
                    cuenta.getEstado(),
                    cuenta.getId_cliente()
                );
            
            return cuentaNueva;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agrego con exito la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta", e);
        }
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Cuentas SET numero_cuenta = ?, fecha_apertura = ?, "
                + "saldo = ?, contra = ?, estado = ?, id_cliente = ? "
                + "WHERE id_cuenta = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ){
            comandoSQL.setInt(1, cuenta.getNum_cuenta());
            comandoSQL.setString(2, cuenta.getApertura());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getContra());
            comandoSQL.setString(5, cuenta.getEstado());
            comandoSQL.setInt(6, cuenta.getId_cliente());
            comandoSQL.setInt(7, cuenta.getId_cuenta());
                    
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se actualizó con éxito {0} ", registrosModificados);
            
            return consultarCuentaPorID(registrosModificados);
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar la cuenta", e);
            throw new PersistenciaException("No se pudo actualizar la cuenta", e);
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
                    resultado.getInt("id_cuenta"),
                    resultado.getInt(2),
                    resultado.getString(3),
                    resultado.getFloat(4),
                    resultado.getString(5),
                    resultado.getString(6),
                    resultado.getInt(7)
            );
            
            return cuentaConsultada;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontro la cuenta", e);
            throw new PersistenciaException("No se encontro la cuenta", e);
        }
    }

    @Override
    public List<Cuenta> consultarTodosCuentas() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Cuentas";
        List<Cuenta> listaCuentas = new ArrayList<>();
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()) {
                int id_cuenta = resultado.getInt("id_cuenta");
                int num_cuenta = resultado.getInt("numero_cuenta");
                String fecha_apertura = resultado.getString("fecha_apertura");
                float saldo = resultado.getFloat("saldo");
                String contra = resultado.getString("contra");
                String estado = resultado.getString("estado");
                int id_cliente = resultado.getInt("id_cliente");
                Cuenta cuenta = new Cuenta(id_cuenta, num_cuenta, estado, 
                        saldo, estado, estado, id_cliente);
                listaCuentas.add(cuenta); 
            }
            LOG.log(Level.INFO, "Se encontraron {0} cuentas ", 
                    listaCuentas.size());
            
            return listaCuentas;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron cuentas", e);
            throw new PersistenciaException("No se encontraron cuentas", e);
        }
    }
    
}
