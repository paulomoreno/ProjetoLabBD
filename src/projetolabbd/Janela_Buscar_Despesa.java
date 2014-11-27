/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolabbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author paulomoreno
 */
public class Janela_Buscar_Despesa extends javax.swing.JFrame {
   Connection conexao;
   ResultSet resultado;
   MaskFormatter mfData;

    private void Atualiza_Data_Model(String stmWhere) throws SQLException{
        Selects.selectFromDespesa(conexao, stmWhere, tabelaDespesa);
    }    
    
    public Janela_Buscar_Despesa(Connection conexao) {
        try {
            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Patrocinio.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        
        this.conexao = conexao;
        if (this.conexao != null){
            try {
                this.Atualiza_Data_Model("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            System.out.println("Falha na conexao!");
        }
        
    }    
    
    /**
     * Creates new form Janela_Buscar_Evento
     */
    public Janela_Buscar_Despesa() {
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

        lbl_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDespesa = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btn_filtrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btn_remover = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField(mfData);
        btn_editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_titulo.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        lbl_titulo.setText("Busca por Despesa");

        jLabel2.setText("Descrição");

        tabelaDespesa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaDespesa);

        jLabel3.setText("Valor");

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        btn_filtrar.setText("Filtrar");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Data");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
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
                            .addComponent(lbl_titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 334, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_filtrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_remover)
                    .addComponent(btn_editar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed

     String and="",where="WHERE", stm="";
        
        if (!this.txtDescricao.getText().equals("")) {
            stm = stm + where + and + " descricaoDesp LIKE '%" + txtDescricao.getText() + "%'"; 
            where = "";
            and = " AND";
        } 

        if (!this.txtValor.getText().equals("")) {
            stm = stm + where + and + " valorDesp LIKE '%" + txtValor.getText() + "%'"; 
            where = "";
            and = " AND";
        } 
             
        if (!this.txtData.getText().equals("__/__/____")) {
            stm = stm + where + and + " dataDesp = TO_DATE('" + txtData.getText() + "','DD/MM/YYYY')"; 
            //where = "";
            //and = " AND";
        }  
        
        System.out.println(stm);
                                
        try {
            this.Atualiza_Data_Model(stm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
    
        int index = tabelaDespesa.getSelectedRow();
        if (index != -1){
            String codDesp = (String) tabelaDespesa.getModel().getValueAt(index, 0);
            String codEv = (String) tabelaDespesa.getModel().getValueAt(index, 1);
            String numEd = (String) tabelaDespesa.getModel().getValueAt(index, 3);
            String descricao = (String) tabelaDespesa.getModel().getValueAt(index, 11);
            String data = (String) tabelaDespesa.getModel().getValueAt(index, 9);

            int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem certeza que deseja excluir a despesa " + descricao + " da data " + data + "?","Aviso",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){

                System.out.println("REMOÇÃO DA DESPESA " + codDesp + " - " + codEv + " - " + numEd);
                try {
                    //resultado = DBconnection.executeSQLSelect(conexao,"DELETE FROM despesa WHERE codDesp = " + codDesp + " AND codEv = "  + codEv + " AND numEd = " + numEd );
                    resultado = DBconnection.executeSQLSelect(conexao,"CALL remove.removeDespesa("  + codEv + ", " + numEd + ", " + codDesp + ")");
                    System.out.println(resultado);
                    this.btn_filtrar.doClick();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            
            }
            
        }

    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int index = tabelaDespesa.getSelectedRow();
        if (index != -1){
            String codEv = (String) tabelaDespesa.getModel().getValueAt(index, 1);
            String numEd = (String) tabelaDespesa.getModel().getValueAt(index, 3);
            String codDesp = (String) tabelaDespesa.getModel().getValueAt(index, 0);
            Janela_Novo_Despesa updateDespesa = new Janela_Novo_Despesa(conexao, "update", codEv, numEd, codDesp, this);
            updateDespesa.setVisible(true);
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
            java.util.logging.Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Buscar_Despesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable tabelaDespesa;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
