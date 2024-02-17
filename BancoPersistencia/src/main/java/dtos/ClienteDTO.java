
package dtos;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class ClienteDTO {
    
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;
    private int id_domicilio;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombres, String apellido_paterno, String apellido_materno, 
            String fecha_nacimiento, int id_domicilio) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_domicilio = id_domicilio;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }
    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }
    
    
    
}
