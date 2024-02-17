
package bancodominio;

/**
 *
 * @author caarl
 */
public class Domicilio {
    // Clase POJO de Domicilios
    private int id_domicilio;
    private String calle;
    private String colonia;
    private String numero_exterior;

    public Domicilio(){
    }

    public Domicilio(String calle, String colonia, String numero_exterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero_exterior = numero_exterior;
    }

    public Domicilio(int id_domicilio, String calle, String colonia, String numero_exterior) {
        this.id_domicilio = id_domicilio;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_exterior = numero_exterior;
    }
    
    public long getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
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
