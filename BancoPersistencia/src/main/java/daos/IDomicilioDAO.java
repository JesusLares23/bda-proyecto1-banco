
package daos;

import com.mycompany.bancopersistencia.exception.BancoPersistenciaException;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IDomicilioDAO {
    
    public Domicilio agregarDomicilio(Domicilio domicilio) throws BancoPersistenciaException;
}
