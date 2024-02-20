
package daos;

import bancodominio.Transferencia;
import dtos.TransferenciaDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface ITransferenciaDAO {
    public Transferencia agregarTransferencia(TransferenciaDTO Transferencia) throws PersistenciaException;
    public Transferencia consultarTransferenciaPorID(int id) throws PersistenciaException;
    public List<Transferencia> consultarTodosTransferencias() throws PersistenciaException;
}
