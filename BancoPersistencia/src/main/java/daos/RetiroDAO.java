
package daos;

import bancodominio.RetiroSinCuenta;
import conexion.IConexionBD;
import dtos.RetiroDTO;
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
public class RetiroDAO implements IRetiroDAO {

    IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(RetiroDAO.class.getName());

    public RetiroDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public RetiroSinCuenta agregarRetiro(RetiroDTO retiro) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Retiros (id_cuenta_origen, folio, contra, "
                + "monto, fecha, cobrado) "
                + "VALUES (?,?,?,?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setInt(1, retiro.getId_cuenta_origen());
            comandoSQL.setInt(2, retiro.getFolio());
            comandoSQL.setString(3, retiro.getContra());
            comandoSQL.setFloat(4, retiro.getMonto());
            comandoSQL.setString(0, retiro.getFecha());
            comandoSQL.setBoolean(6, retiro.isCobrado());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", 
                    registrosModificados);
            
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();
            
            RetiroSinCuenta retiroNuevo = new RetiroSinCuenta(
                    registroGenerado.getInt(1),
                    retiro.getId_cuenta_origen(),
                    retiro.getFolio(),
                    retiro.getContra(),
                    retiro.getMonto(),
                    retiro.getFecha(),
                    retiro.isCobrado()
                );
            
            return retiroNuevo;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agrego con exito el tetiro", e);
            throw new PersistenciaException("No se pudo guardar el tetiro", e);
        }
    }

    @Override
    public RetiroSinCuenta consultarRetiroPorID(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Retiros WHERE id_retiro = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setInt(1, id);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            RetiroSinCuenta retiroConsultado = new RetiroSinCuenta(
                    resultado.getInt("id_retiro"),
                    resultado.getInt(2),
                    resultado.getString(3),
                    resultado.getFloat(4),
                    resultado.getString(5),
                    resultado.getBoolean(6)
            );
            
            return retiroConsultado;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontro el retiro", e);
            throw new PersistenciaException("No se encontro el retiro", e);
        }
    }

    @Override
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Retiros";
        List<RetiroSinCuenta> listaRetiros = new ArrayList<>();
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()) {
                int idRetiro = resultado.getInt("id_retiro");
                int cuentaOrigen = resultado.getInt("id_cuenta_orgien");
                int folio = resultado.getInt("folio");
                String contra = resultado.getString("contrasena");
                float monto = resultado.getFloat("monto");
                String fecha = resultado.getString("fecha");
                boolean cobrado = resultado.getBoolean("cobrado");
                RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta(idRetiro, 
                        cuentaOrigen, folio, contra, monto, fecha, cobrado);
                listaRetiros.add(retiroSinCuenta); 
            }
            LOG.log(Level.INFO, "Se encontraron {0} transferencias ", 
                    listaRetiros.size());
            
            return listaRetiros;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron retiros", e);
            throw new PersistenciaException("No se encontraron retiros", e);
        }
    }
    
}
