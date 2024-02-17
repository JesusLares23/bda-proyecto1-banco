
package daos;

import bancodominio.Domicilio;
import excepciones.PersistenciaException;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IDomicilioDAO {
    
    public Domicilio agregarDomicilio(Domicilio domicilio) throws PersistenciaException;
}
