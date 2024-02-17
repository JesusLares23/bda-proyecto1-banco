
package controlador_dominio;

import bancodominio.Cliente;
import bancodominio.Domicilio;
import controladores.ControladorPersistencia;
import dtos.ClienteDTO;
import dtos.DomicilioDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class ControladorDominio {
    
    ControladorPersistencia controlPersistencia = new ControladorPersistencia();
    
    public Domicilio agregarDomicilio(String calle, String colonia, String numero_exterior) 
            throws DominioException {
        DomicilioDTO domicilioDTO = new DomicilioDTO(calle, colonia, numero_exterior);
        Domicilio domicilioAgregado;
        
        try {
            domicilioAgregado = controlPersistencia.agregarDomicilio(domicilioDTO);
            return domicilioAgregado;
        } catch (PersistenciaException e) {
            Logger.getLogger(ControladorDominio.class.getName()).log(Level.SEVERE, null, e);
            throw  new DominioException("No se agrego el domicilio", e);
        }
    }
    
    public Cliente agregarCliente(String nombres, String apellido_paterno, 
            String apellido_materno, String fecha_nacimiento, int id_direccion) 
            throws DominioException {
        ClienteDTO clienteDTO = new ClienteDTO(nombres, apellido_paterno, 
                apellido_materno, fecha_nacimiento, id_direccion);
        Cliente clienteAgregado;
        
        try {
            clienteAgregado = controlPersistencia.agregarCliente(clienteDTO);
            return clienteAgregado;
        } catch (PersistenciaException e) {
            Logger.getLogger(ControladorDominio.class.getName()).log(Level.SEVERE, null, e);
            throw  new DominioException("No se agrego el cliente", e);
        }
    }
    
}
