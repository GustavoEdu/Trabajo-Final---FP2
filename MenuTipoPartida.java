/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class MenuTipoPartida extends javax.swing.JFrame {

    /**
     * Creates new form MenuTipoPartida
     */
    public MenuTipoPartida() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        rapida = new javax.swing.JButton();
        normal = new javax.swing.JButton();
        avanzada = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel3.setText("Seleccione el Tipo de Partida:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 530, 70));

        rapida.setBackground(new java.awt.Color(0, 29, 61));
        rapida.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rapida.setForeground(new java.awt.Color(255, 255, 0));
        rapida.setText("Partida Rápida");
        rapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapidaActionPerformed(evt);
            }
        });
        getContentPane().add(rapida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 340, 70));

        normal.setBackground(new java.awt.Color(0, 29, 61));
        normal.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        normal.setForeground(new java.awt.Color(255, 255, 0));
        normal.setText("Partida Normal");
        normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalActionPerformed(evt);
            }
        });
        getContentPane().add(normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 340, 70));

        avanzada.setBackground(new java.awt.Color(0, 29, 61));
        avanzada.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        avanzada.setForeground(new java.awt.Color(255, 255, 0));
        avanzada.setText("Partida Avanzada");
        avanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzadaActionPerformed(evt);
            }
        });
        getContentPane().add(avanzada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 340, 70));

        jButton4.setText("jButton1");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programita/fondoMenuTipoPartida.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapidaActionPerformed
        Random rand = new Random();
        new Campo(rand.nextInt(3) + 10);
        setVisible(false);
    }//GEN-LAST:event_rapidaActionPerformed

    private void normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalActionPerformed
        Random rand = new Random();
        new Campo(rand.nextInt(2) + 13);
        setVisible(false);
    }//GEN-LAST:event_normalActionPerformed

    private void avanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzadaActionPerformed
        Random rand = new Random();
        new Campo(rand.nextInt(2) + 15);
        setVisible(false);
    }//GEN-LAST:event_avanzadaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuTipoPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTipoPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTipoPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTipoPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuTipoPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avanzada;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton normal;
    private javax.swing.JButton rapida;
    // End of variables declaration//GEN-END:variables
}