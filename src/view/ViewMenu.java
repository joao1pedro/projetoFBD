/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
/**
 *
 * @author joao
 */
public class ViewMenu extends javax.swing.JFrame {
    
    /**
     * Creates new form Menu
     */
    public ViewMenu() {
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

        jLabel1 = new javax.swing.JLabel();
        jBTCadastrarProduto = new javax.swing.JButton();
        jBTConsultarProduto = new javax.swing.JButton();
        jBTCadastrarCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBTvendas = new javax.swing.JButton();
        jBTrelatorioVendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU");

        jBTCadastrarProduto.setText("CADASTRAR PRODUTO");
        jBTCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTCadastrarProdutoActionPerformed(evt);
            }
        });

        jBTConsultarProduto.setText("CONSULTAR PRODUTO");
        jBTConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTConsultarProdutoActionPerformed(evt);
            }
        });

        jBTCadastrarCliente.setText("CADASTRAR CLIENTE");
        jBTCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTCadastrarClienteActionPerformed(evt);
            }
        });

        jButton1.setText("CONSULTAR CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBTvendas.setText("VENDAS");
        jBTvendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTvendasActionPerformed(evt);
            }
        });

        jBTrelatorioVendas.setText("RELATÓRIO DE VENDAS");
        jBTrelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTrelatorioVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBTrelatorioVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBTvendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBTCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBTConsultarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBTCadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jBTCadastrarProduto)
                .addGap(18, 18, 18)
                .addComponent(jBTConsultarProduto)
                .addGap(18, 18, 18)
                .addComponent(jBTCadastrarCliente)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jBTvendas)
                .addGap(18, 18, 18)
                .addComponent(jBTrelatorioVendas)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTCadastrarProdutoActionPerformed
        // TODO add your handling code here:
        ViewCadastrarProduto c = new ViewCadastrarProduto();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTCadastrarProdutoActionPerformed

    private void jBTConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTConsultarProdutoActionPerformed
        // TODO add your handling code here:
        ViewConsultarProduto c = new ViewConsultarProduto();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTConsultarProdutoActionPerformed

    private void jBTCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTCadastrarClienteActionPerformed
        // TODO add your handling code here:
        ViewCadastrarCliente v = new ViewCadastrarCliente();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTCadastrarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ViewConsultarCliente m = new ViewConsultarCliente();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBTvendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTvendasActionPerformed
        ViewVendas vv = new ViewVendas();
        vv.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTvendasActionPerformed

    private void jBTrelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTrelatorioVendasActionPerformed
        ViewRelatorioVendas vr = new ViewRelatorioVendas();
        vr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBTrelatorioVendasActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTCadastrarCliente;
    private javax.swing.JButton jBTCadastrarProduto;
    private javax.swing.JButton jBTConsultarProduto;
    private javax.swing.JButton jBTrelatorioVendas;
    private javax.swing.JButton jBTvendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
