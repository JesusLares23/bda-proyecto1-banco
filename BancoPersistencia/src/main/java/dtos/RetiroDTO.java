
package dtos;

import bancodominio.Cuenta;

/**
 *
 * @author Jesús Pedro Lares Valencia - 00000233383
 */
public class RetiroDTO {
    private int id_cuenta_origen;
    private int folio;
    private String contra;
    private float monto;
    private String fecha;
    private boolean cobrado;

    public RetiroDTO() {
    }

    public RetiroDTO(int id_cuenta_origen, int folio, String contra, 
            float monto, String fecha, boolean cobrado) {
        this.id_cuenta_origen = id_cuenta_origen;
        this.folio = folio;
        this.contra = contra;
        this.monto = monto;
        this.fecha = fecha;
        this.cobrado = cobrado;
    }

    public int getId_cuenta_origen() {
        return id_cuenta_origen;
    }
    public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public int getFolio() {
        return folio;
    }
    public void setFolio(int folio) {
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
