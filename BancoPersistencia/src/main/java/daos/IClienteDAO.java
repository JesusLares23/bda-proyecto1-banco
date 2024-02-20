
package daos;

import bancodominio.Cliente;
import dtos.ClienteDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IClienteDAO {
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;
    public Cliente consultarClientePorID(int id) throws PersistenciaException;
    public List<Cliente> consultarTodosClientes() throws PersistenciaException;
}
