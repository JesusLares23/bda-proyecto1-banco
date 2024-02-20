
package bancodominio;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class Cuenta {
    // Clase POJO de Cuentas
    
    private int id_cuenta;
    private int num_cuenta;
    private String apertura;
    private float saldo;
    private String contra;
    private String estado;
    private int id_cliente;
    
    public enum Estado {
        ACTIVO,
        INACTIVO,
        PENDIENTE
    }

    public Cuenta() {
    }

    public Cuenta(int num_cuenta, String apertura, float saldo, String contra, String estado, 
            int id_cliente) {
        this.num_cuenta = num_cuenta;
        this.apertura = apertura;
        this.saldo = saldo;
        this.contra = contra;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Cuenta(int id_cuenta, int num_cuenta, String apertura, float saldo, 
            String contra, String estado, int id_cliente) {
        this.id_cuenta = id_cuenta;
        this.num_cuenta = num_cuenta;
        this.apertura = apertura;
        this.saldo = saldo;
        this.contra = contra;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }
    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    
    public String getApertura() {
        return apertura;
    }
    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}
