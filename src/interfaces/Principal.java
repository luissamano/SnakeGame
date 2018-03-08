/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Helpers.Tiempo;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marti
 */
public class Principal extends javax.swing.JDialog {

    AreaMovimiento am = new AreaMovimiento(this);
    Tiempo tmp = new Tiempo(am,this);
    /**
     * Creates new form Principal
     */
    public Principal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        try {
            initComponents();
            this.add(am, BorderLayout.CENTER);
            tmp.iniciarProceso();
            int x = this.am.vidas;
            lives.setText(""+x);            
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArriba = new javax.swing.JButton();
        btnAbajo = new javax.swing.JButton();
        btnDer = new javax.swing.JButton();
        btnIzq = new javax.swing.JButton();
        sldVelocidad = new javax.swing.JSlider();
        btnReiniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lives = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(153, 255, 102), new java.awt.Color(0, 255, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnArriba.setText("^");
        btnArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArribaActionPerformed(evt);
            }
        });
        jPanel1.add(btnArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnAbajo.setText("^");
        btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbajoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        btnDer.setText(">");
        btnDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerActionPerformed(evt);
            }
        });
        jPanel1.add(btnDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 39, -1, -1));

        btnIzq.setText("<");
        btnIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzqActionPerformed(evt);
            }
        });
        jPanel1.add(btnIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, -1));

        sldVelocidad.setForeground(new java.awt.Color(204, 255, 255));
        sldVelocidad.setMaximum(10);
        sldVelocidad.setMinorTickSpacing(1);
        sldVelocidad.setPaintLabels(true);
        sldVelocidad.setPaintTicks(true);
        sldVelocidad.setToolTipText("");
        sldVelocidad.setValue(0);
        sldVelocidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldVelocidadStateChanged(evt);
            }
        });
        jPanel1.add(sldVelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 210, -1));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vidas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        lives.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(lives, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Tiempo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 30, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        setBounds(0, 0, 499, 593);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArribaActionPerformed
        // TODO add your handling code here:
        this.am.setDireccion("arriba");   
        this.am.avion = new ImageIcon(getClass().getResource("/img/arriba.png")).getImage()
                    .getScaledInstance(100, -100, Image.SCALE_DEFAULT);
    }//GEN-LAST:event_btnArribaActionPerformed

    private void btnAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbajoActionPerformed
        // TODO add your handling code here:
        this.am.setDireccion("abajo");
        this.am.avion = new ImageIcon(getClass().getResource("/img/abajo.png")).getImage()
                    .getScaledInstance(100, -100, Image.SCALE_DEFAULT);
    }//GEN-LAST:event_btnAbajoActionPerformed

    private void btnDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerActionPerformed
        // TODO add your handling code here:
        this.am.setDireccion("derecha");
        this.am.avion = new ImageIcon(getClass().getResource("/img/der.png")).getImage()
                    .getScaledInstance(100, -100, Image.SCALE_DEFAULT);
    }//GEN-LAST:event_btnDerActionPerformed

    private void btnIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzqActionPerformed
        // TODO add your handling code here:
        this.am.setDireccion("izqierda");  
        this.am.avion = new ImageIcon(getClass().getResource("/img/izq.png")).getImage()
                    .getScaledInstance(100, -100, Image.SCALE_DEFAULT);
    }//GEN-LAST:event_btnIzqActionPerformed

    private void sldVelocidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldVelocidadStateChanged
        // TODO add your handling code here:
        int vel = 1000 - this.sldVelocidad.getValue() * 100;
        
        vel = (vel == 0 ? 50: vel);
        this.am.setVelocidad(vel);
    }//GEN-LAST:event_sldVelocidadStateChanged

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        //am.iniciarProceso();
        //tmp.reiniciarProceso();
    }//GEN-LAST:event_btnReiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal dialog = new Principal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnDer;
    private javax.swing.JButton btnIzq;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lives;
    private javax.swing.JSlider sldVelocidad;
    public javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
