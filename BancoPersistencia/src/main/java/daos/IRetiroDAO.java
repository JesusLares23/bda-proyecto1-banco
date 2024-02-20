
package daos;

import bancodominio.RetiroSinCuenta;
import dtos.RetiroDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IRetiroDAO {
    public RetiroSinCuenta agregarRetiro(RetiroDTO Retiro) throws PersistenciaException;
    public RetiroSinCuenta consultarRetiroPorID(int id) throws PersistenciaException;
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException;
}
