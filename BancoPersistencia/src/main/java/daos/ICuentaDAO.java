
package daos;

import bancodominio.Cuenta;
import dtos.CuentaDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface ICuentaDAO {
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException;
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException;
    public List<Cuenta> consultarTodosCuentas() throws PersistenciaException;
}
