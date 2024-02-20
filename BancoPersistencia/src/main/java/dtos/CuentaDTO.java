
package dtos;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class CuentaDTO {
    private int num_cuenta;
    private String apertura;
    private float saldo;
    private String estado;
    private int id_cliente;
    
    public enum Estado {
        ACTIVO,
        INACTIVO,
        PENDIENTE
    }

    public CuentaDTO() {
    }

    public CuentaDTO(int num_cuenta, String apertura, float saldo, String estado, 
            int id_cliente) {
        this.num_cuenta = num_cuenta;
        this.apertura = apertura;
        this.saldo = saldo;
        this.estado = estado;
        this.id_cliente = id_cliente;
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
