
package controladores;

import bancodominio.Cliente;
import bancodominio.Domicilio;
import dtos.ClienteDTO;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public interface IControladorPersistencia {
    
    public Domicilio agregarDomicilio(DomicilioDTO domicilio) throws PersistenciaException;
    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException;
    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException;
    
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    public Cliente consultarClientePorID(int id) throws PersistenciaException;
    public List<Cliente> consultarTodosClientes() throws PersistenciaException;
}
