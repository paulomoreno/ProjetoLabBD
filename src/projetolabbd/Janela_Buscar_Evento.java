/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolabbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author paulomoreno
 */
public class Janela_Buscar_Evento extends javax.swing.JFrame {
    Connection conexao;
    ResultSet resultado;
    
    private void Atualiza_Data_Model(String stmWhere) throws SQLException{
        Selects.selectFromEvento(conexao, stmWhere, tabelaEvento);
    }

    /**
     * Creates new form Janela_Buscar_Evento
     */
    public Janela_Buscar_Evento(Connection conexao) {
        initComponents();
        this.conexao = conexao;
        if (this.conexao != null){
            try {
                this.Atualiza_Data_Model("");
            } catch (SQLException ex) {
                Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else{
            System.out.println("Falha na conexao!");
        }
    }
    
    public Janela_Buscar_Evento() {
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

        txtNomeEvento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEvento = new javax.swing.JTable();
        btn_filtrar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNomeEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeEventoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("Busca por Evento");

        jLabel2.setText("Nome Evento");

        tabelaEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaEvento);

        btn_filtrar.setText("Filtrar");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        btn_remover.setText("Remover Selecionado");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar Selecionado");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_remover)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_filtrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_remover)
                    .addComponent(btn_editar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeEventoActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        // TODO add your handling code here:
        if (this.txtNomeEvento.getText().equals("")){
            try {
                this.Atualiza_Data_Model("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                this.Atualiza_Data_Model("WHERE nomeEv LIKE '%" + this.txtNomeEvento.getText() + "%'");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        // TODO add your handling code here:
        int index = tabelaEvento.getSelectedRow();
        if (index != -1){
            String cod = (String) tabelaEvento.getModel().getValueAt(index, 4);
            String nomeEv = (String) tabelaEvento.getModel().getValueAt(index, 0);

            int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem certeza que deseja excluir o evento " +  nomeEv + "?","Aviso",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){

                System.out.println("REMOÇÃO DO EVENTO " + cod);
                try {
                    resultado = DBconnection.executeSQLSelect(conexao,"DELETE FROM evento WHERE codEv = " + cod);
                    System.out.println(resultado);
                    this.btn_filtrar.doClick();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                }

            
            }
            
        }
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int index = tabelaEvento.getSelectedRow();
        if (index != -1){
            String cod = (String) tabelaEvento.getModel().getValueAt(index, 4);
            Janela_Novo_Evento updateEvento = new Janela_Novo_Evento(conexao, "update", cod, this);
            updateEvento.setVisible(true);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    public void atualizaTabela(){
        this.btn_filtrar.doClick();
    }
    
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
            java.util.logging.Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Buscar_Evento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEvento;
    private javax.swing.JTextField txtNomeEvento;
    // End of variables declaration//GEN-END:variables
}
