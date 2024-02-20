
package controladores;

import bancodominio.Cliente;
import bancodominio.Cuenta;
import bancodominio.Domicilio;
import bancodominio.RetiroSinCuenta;
import bancodominio.Transferencia;
import conexion.ConexionBD;
import conexion.IConexionBD;
import daos.ClienteDAO;
import daos.DomicilioDAO;
import daos.IClienteDAO;
import daos.ICuentaDAO;
import daos.IDomicilioDAO;
import daos.CuentaDAO;
import daos.IRetiroDAO;
import daos.ITransferenciaDAO;
import daos.RetiroDAO;
import daos.TransferenciaDAO;
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
public class ControladorPersistencia implements IControladorPersistencia {

    String cadenaConexion = "root@127.0.0.1:3306";
    String usuario = "root";
    String contra = "chapeto23";
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
    IDomicilioDAO domicilioDAO = new DomicilioDAO(conexionBD);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
    ITransferenciaDAO transferenciaDAO = new TransferenciaDAO(conexionBD);
    IRetiroDAO retiroDAO = new RetiroDAO(conexionBD);
    
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

    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        Cuenta cuentaAgregada = this.cuentaDAO.agregarCuenta(cuenta);
        return cuentaAgregada;
    }
    @Override
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException {
        Cuenta cuentaActualizada = this.cuentaDAO.actualizar(cuenta);
        return cuentaActualizada;
    }
    @Override
    public Cuenta consultarCuentaPorID(int id) throws PersistenciaException {
        Cuenta cuentaConsultada = this.cuentaDAO.consultarCuentaPorID(id);
        return cuentaConsultada;
    }
    @Override
    public List<Cuenta> consultarTodosCuentas() throws PersistenciaException {
        return this.cuentaDAO.consultarTodosCuentas();
    }

    @Override
    public Transferencia agregarTransferencia(TransferenciaDTO Transferencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transferencia consultarTransferenciaPorID(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transferencia> consultarTodosTransferencias() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RetiroSinCuenta agregarRetiro(RetiroDTO Retiro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RetiroSinCuenta consultarRetiroPorID(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
