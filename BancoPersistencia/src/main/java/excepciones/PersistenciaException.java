/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author caarl
 */
public class PersistenciaException extends Exception {
    
    public PersistenciaException(){
    }
    
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
