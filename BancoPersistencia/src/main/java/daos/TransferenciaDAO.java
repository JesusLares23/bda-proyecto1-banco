
package daos;

import bancodominio.Transferencia;
import conexion.IConexionBD;
import dtos.TransferenciaDTO;
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
public class TransferenciaDAO implements ITransferenciaDAO {
    
    IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(TransferenciaDAO.class.getName());

    public TransferenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Transferencia agregarTransferencia(TransferenciaDTO transferencia) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Transferencias (id_cuenta_origen, id_cuenta_destino, "
                + "monto, fecha) "
                + "VALUES (?,?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setInt(1, transferencia.getId_cuenta_origen());
            comandoSQL.setInt(2, transferencia.getId_cuenta_destino());
            comandoSQL.setFloat(3, transferencia.getMonto());
            comandoSQL.setString(4, transferencia.getFecha());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", 
                    registrosModificados);
            
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();
            
            Transferencia transferenciaNueva = new Transferencia(
                    registroGenerado.getInt(1),
                    transferencia.getId_cuenta_origen(),
                    transferencia.getId_cuenta_destino(),
                    transferencia.getMonto(),
                    transferencia.getFecha()
                );
            
            return transferenciaNueva;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agrego con exito la transferencia", e);
            throw new PersistenciaException("No se pudo guardar la transferencia", e);
        }
    }

    @Override
    public Transferencia consultarTransferenciaPorID(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Transferencias WHERE id_transferencia = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setInt(1, id);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            Transferencia transferenciaConsultada = new Transferencia(
                    resultado.getInt("id_transferencia"),
                    resultado.getInt(2),
                    resultado.getInt(3),
                    resultado.getFloat(4),
                    resultado.getString(5)
            );
            
            return transferenciaConsultada;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontro la transferencia", e);
            throw new PersistenciaException("No se encontro la transferencia", e);
        }
    }

    @Override
    public List<Transferencia> consultarTodosTransferencias() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Transferencias";
        List<Transferencia> listaTransferencias = new ArrayList<>();
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()) {
                int idTransferencia = resultado.getInt("id_transferencia");
                int cuentaOrigen = resultado.getInt("id_cuenta_orgien");
                int cuentaDestino = resultado.getInt("id_cuenta_destino");
                float monto = resultado.getFloat("monto");
                String fecha = resultado.getString("fecha");
                Transferencia transferencia = new Transferencia(idTransferencia, 
                        cuentaOrigen, cuentaDestino, monto, fecha);
                listaTransferencias.add(transferencia); 
            }
            LOG.log(Level.INFO, "Se encontraron {0} transferencias ", 
                    listaTransferencias.size());
            
            return listaTransferencias;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron transfernecias", e);
            throw new PersistenciaException("No se encontraron transferencias", e);
        }
    }
}
