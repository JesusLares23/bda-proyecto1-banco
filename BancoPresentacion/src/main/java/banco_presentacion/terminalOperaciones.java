/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banco_presentacion;

/**
 *
 * @author caarl
 */
public class terminalOperaciones extends javax.swing.JFrame {

    /**
     * Creates new form terminalOperaciones
     */
    public terminalOperaciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_terminaldeOperaciones1 = new javax.swing.JButton();
        btn_transferencia = new javax.swing.JButton();
        btn_deposito = new javax.swing.JButton();
        btn_retiro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();

        btn_terminaldeOperaciones1.setText("Retiro");
        btn_terminaldeOperaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminaldeOperaciones1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_transferencia.setText("Transferencia");
        btn_transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferenciaActionPerformed(evt);
            }
        });

        btn_deposito.setText("Deposito");
        btn_deposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositoActionPerformed(evt);
            }
        });

        btn_retiro.setText("Retiro");
        btn_retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retiroActionPerformed(evt);
            }
        });

        jLabel1.setText("Terminal de operaciones");

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_deposito, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btn_transferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btn_retiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btn_transferencia)
                .addGap(18, 18, 18)
                .addComponent(btn_deposito)
                .addGap(18, 18, 18)
                .addComponent(btn_retiro)
                .addGap(33, 33, 33)
                .addComponent(btn_salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferenciaActionPerformed
        // Creas una instancia de RegistroClienteFrm
       terminalTransferencia terminalTransferencia = new terminalTransferencia();
        // Haces visible RegistroClienteFrm
        terminalTransferencia.setVisible(true);
        // Ocultas el frame principal
        this.setVisible(false);
    }//GEN-LAST:event_btn_transferenciaActionPerformed

    private void btn_depositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositoActionPerformed
        // Creas una instancia de RegistrarCuentaFrm
        terminalDeposito terminalDeposito = new terminalDeposito();
        // Haces visible RegistrarCuentaFrm
        terminalDeposito.setVisible(true);
        // Ocultas el frame principal
        this.setVisible(false);
    }//GEN-LAST:event_btn_depositoActionPerformed

    private void btn_retiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retiroActionPerformed
        // Creas una instancia de RegistrarCuentaFrm
        terminalRetiro terminalRetiro = new terminalRetiro();
        // Haces visible RegistrarCuentaFrm
        terminalRetiro.setVisible(true);
        // Ocultas el frame principal
        this.setVisible(false);
    }//GEN-LAST:event_btn_retiroActionPerformed

    private void btn_terminaldeOperaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminaldeOperaciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_terminaldeOperaciones1ActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
       bancoAdmin bancoAdmin = new bancoAdmin();
        // Haces visible RegistrarCuentaFrm
        bancoAdmin.setVisible(true);
        // Ocultas el frame principal
        this.setVisible(false);
    }//GEN-LAST:event_btn_salirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(terminalOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(terminalOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(terminalOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(terminalOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new terminalOperaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deposito;
    private javax.swing.JButton btn_retiro;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_terminaldeOperaciones1;
    private javax.swing.JButton btn_transferencia;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
