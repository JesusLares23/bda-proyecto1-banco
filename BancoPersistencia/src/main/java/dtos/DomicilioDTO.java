
package dtos;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class DomicilioDTO {
    
    private int id_domicilio;
    private String calle;
    private String colonia;
    private String numero_exterior;

    public DomicilioDTO() {
    }

    public DomicilioDTO(String calle, String colonia, String numero_exterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero_exterior = numero_exterior;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }
    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }
    
}
