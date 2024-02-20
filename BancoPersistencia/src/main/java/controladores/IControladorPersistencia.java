
package controladores;

import bancodominio.Cliente;
import bancodominio.Cuenta;
import bancodominio.Domicilio;
import bancodominio.RetiroSinCuenta;
import bancodominio.Transferencia;
import dtos.ClienteDTO;
import dtos.CuentaDTO;
import dtos.DomicilioDTO;
import dtos.RetiroDTO;
import dtos.TransferenciaDTO;
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
    
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException;
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException;
    public List<Cuenta> consultarTodosCuentas() throws PersistenciaException;
    
    public Transferencia agregarTransferencia(TransferenciaDTO Transferencia) throws PersistenciaException;
    public Transferencia consultarTransferenciaPorID(int id) throws PersistenciaException;
    public List<Transferencia> consultarTodosTransferencias() throws PersistenciaException;
    
    public RetiroSinCuenta agregarRetiro(RetiroDTO Retiro) throws PersistenciaException;
    public RetiroSinCuenta consultarRetiroPorID(int id) throws PersistenciaException;
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException;
}
