
package controlador_negocio;

import bancodominio.Cliente;
import bancodominio.Domicilio;
import controladores.IControladorPersistencia;
import dtos.ClienteDTO;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class ControladorNegocio {
    private IControladorPersistencia controlador;
    
    public Domicilio agregarDomicilio(DomicilioDTO domicilio) throws PersistenciaException {
        Domicilio domicilioAgregado = this.controlador.agregarDomicilio(domicilio);
        return domicilioAgregado;
    }

    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException {
        Domicilio domicilioConsultado = this.controlador.consultarDomicilioPorID(id);
        return domicilioConsultado;
    }

    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException {
        return this.controlador.consultarTodosDomicilios();
    }

    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = this.controlador.agregarCliente(cliente);
        return clienteAgregado;
    }

    public Cliente consultarClientePorID(int id) throws PersistenciaException {
        Cliente clienteConsultado = this.controlador.consultarClientePorID(id);
        return clienteConsultado;
    }

    public List<Cliente> consultarTodosClientes() throws PersistenciaException {
        return this.controlador.consultarTodosClientes();
    }
}
