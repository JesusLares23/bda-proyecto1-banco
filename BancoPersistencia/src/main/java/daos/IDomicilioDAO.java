
package daos;

import bancodominio.Domicilio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IDomicilioDAO {
    // Cambiar Domicilio a DomicilioDTO
    public Domicilio agregarDomicilio(Domicilio domicilio) throws PersistenciaException;
    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException;
    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException;
}
