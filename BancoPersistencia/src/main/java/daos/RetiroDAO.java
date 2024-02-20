
package daos;

import bancodominio.RetiroSinCuenta;
import conexion.IConexionBD;
import dtos.RetiroDTO;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
            LOG.log(Level.SEVERE, "No se agrego con exito la tetiro", e);
            throw new PersistenciaException("No se pudo guardar la tetiro", e);
        }
    }

    @Override
    public RetiroSinCuenta consultarRetiroPorID(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
