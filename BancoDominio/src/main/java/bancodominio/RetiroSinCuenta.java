
package bancodominio;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class RetiroSinCuenta {
    private int id_retiro;
    private Cuenta id_cuenta_origen;
    private String folio;
    private String contra;
    private float monto;
    private String fecha;
    private boolean cobrado;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Cuenta id_cuenta_origen, String folio, String contra, 
            float monto, String fecha, boolean cobrado) {
        this.id_cuenta_origen = id_cuenta_origen;
        this.folio = folio;
        this.contra = contra;
        this.monto = monto;
        this.fecha = fecha;
        this.cobrado = cobrado;
    }

    public RetiroSinCuenta(int id_retiro, Cuenta id_cuenta_origen, String folio, 
            String contra, float monto, String fecha, boolean cobrado) {
        this.id_retiro = id_retiro;
        this.id_cuenta_origen = id_cuenta_origen;
        this.folio = folio;
        this.contra = contra;
        this.monto = monto;
        this.fecha = fecha;
        this.cobrado = cobrado;
    }

    public int getId_retiro() {
        return id_retiro;
    }
    public void setId_retiro(int id_retiro) {
        this.id_retiro = id_retiro;
    }

    public Cuenta getId_cuenta_origen() {
        return id_cuenta_origen;
    }
    public void setId_cuenta_origen(Cuenta id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public String getFolio() {
        return folio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
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

    public boolean isCobrado() {
        return cobrado;
    }
    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }
}
