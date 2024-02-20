
package bancodominio;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class Transferencia {
    // Clase POJO de Domicilios
    private int id_transferencia;
    private int id_cuenta_origen;
    private int id_cuenta_destino;
    private float monto;
    private String fecha;

    public Transferencia() {
    }

    public Transferencia(int id_cuenta_origen, int id_cuenta_destino, 
            float monto, String fecha) {
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Transferencia(int id_transferencia, int id_cuenta_origen, 
            int id_cuenta_destino, float monto, String fecha) {
        this.id_transferencia = id_transferencia;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId_transferencia() {
        return id_transferencia;
    }
    public void setId_transferencia(int id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public int getId_cuenta_origen() {
        return id_cuenta_origen;
    }
    public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public int getId_cuenta_destino() {
        return id_cuenta_destino;
    }
    public void setId_cuenta_destino(int id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
