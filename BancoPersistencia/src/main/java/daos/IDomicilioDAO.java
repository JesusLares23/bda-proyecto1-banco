
package daos;

import bancodominio.Domicilio;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IDomicilioDAO {
    public Domicilio agregarDomicilio(DomicilioDTO domicilio) throws PersistenciaException;
    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException;
    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException;
}
