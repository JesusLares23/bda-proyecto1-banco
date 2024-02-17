
package controladores;

import bancodominio.Cliente;
import bancodominio.Domicilio;
import conexion.ConexionBD;
import conexion.IConexionBD;
import daos.ClienteDAO;
import daos.DomicilioDAO;
import daos.IClienteDAO;
import daos.IDomicilioDAO;
import dtos.ClienteDTO;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class ControladorPersistencia implements IControladorPersistencia {

    String cadenaConexion = "root@127.0.0.1:3306";
    String usuario = "root";
    String contra = "chapeto23";
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
    IDomicilioDAO domicilioDAO = new DomicilioDAO(conexionBD);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    
    @Override
    public Domicilio agregarDomicilio(DomicilioDTO domicilio) throws PersistenciaException {
        Domicilio domicilioAgregado = this.domicilioDAO.agregarDomicilio(domicilio);
        return domicilioAgregado;
    }

    @Override
    public Domicilio consultarDomicilioPorID(int id) throws PersistenciaException {
        Domicilio domicilioConsultado = this.domicilioDAO.consultarDomicilioPorID(id);
        return domicilioConsultado;
    }

    @Override
    public List<Domicilio> consultarTodosDomicilios() throws PersistenciaException {
        return this.domicilioDAO.consultarTodosDomicilios();
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(cliente);
        return clienteAgregado;
    }

    @Override
    public Cliente consultarClientePorID(int id) throws PersistenciaException {
        Cliente clienteConsultado = this.clienteDAO.consultarClientePorID(id);
        return clienteConsultado;
    }

    @Override
    public List<Cliente> consultarTodosClientes() throws PersistenciaException {
        return this.clienteDAO.consultarTodosClientes();
    }
    
}
