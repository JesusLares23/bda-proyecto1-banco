
package daos;

import bancodominio.Cliente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IClienteDAO {
    // Cambiar Cliente a ClienteDTO
    public Cliente agregarCliente(Cliente cliente) throws PersistenciaException;
    public Cliente consultarClientePorID(int id) throws PersistenciaException;
    public List<Cliente> consultarTodosClientes() throws PersistenciaException;
}