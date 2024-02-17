
package daos;

import bancodominio.Domicilio;
import conexion.IConexionBD;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class DomicilioDAO implements IDomicilioDAO {
    
    IConexionBD conexionBD;
    
    private static final Logger LOG = Logger.getLogger(DomicilioDAO.class.getName());
    
    public DomicilioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Domicilio agregarDomicilio(DomicilioDTO domicilio) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Domicilios (calle, colonia, numero_exterior) "
                + "VALUES (?,?,?)";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, 
                        Statement.RETURN_GENERATED_KEYS);
                ) {
            comandoSQL.setString(1, domicilio.getCalle());
            comandoSQL.setString(2, domicilio.getColonia());
            comandoSQL.setString(3, domicilio.getNumero_exterior());
            
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con exito {0}", 
                    registrosModificados);
            
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();
            
            Domicilio domicilioNuevo = new Domicilio(
                    registroGenerado.getInt(1),
                    domicilio.getCalle(),
                    domicilio.getColonia(),
                    domicilio.getNumero_exterior()
                );
            
            return domicilioNuevo;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se agrego con exito el domicilio", e);
            throw new PersistenciaException("No se pudo guardar el domicilio", e);
        }
    }

    @Override
    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Domicilios WHERE id_domicilio = ?";
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            comandoSQL.setInt(1, id);
            
            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();
            
            Domicilio domicilioConsultado = new Domicilio(
                    resultado.getInt("id_domicilio"),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4)
            );
            
            return domicilioConsultado;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontro el domicilio", e);
            throw new PersistenciaException("No se encontro el domicilio", e);
        }
    }

    @Override
    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Domicilios";
        List<Domicilio> listaDomicilios = new ArrayList<>();
        
        try (
                Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
                ) {
            
            ResultSet resultado = comandoSQL.executeQuery();
            while(resultado.next()) {
                int id = resultado.getInt("id_domicilio");
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                String numExterior = resultado.getString("numero_exterior");
                Domicilio domicilio = new Domicilio(id, calle, colonia, 
                        numExterior);
                listaDomicilios.add(domicilio); 
            }
            LOG.log(Level.INFO, "Se encontraron {0} domicilios ", 
                    listaDomicilios.size());
            
            return listaDomicilios;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron domicilios", e);
            throw new PersistenciaException("No se encontraron domicilios", e);
        }
    }
}
