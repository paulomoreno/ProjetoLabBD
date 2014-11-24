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

/**
 *
 * @author paulomoreno
 */
public class Janela_Buscar_Inscrito extends javax.swing.JFrame {
    Connection conexao;
    ResultSet resultado;
    
    private void Atualiza_Data_Model(String stmWhere) throws SQLException{
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_inscrito " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT codEv, idPart, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe, enderecoPe, nomeEv, numEd, dataInsc, tipoApresentador \n" +
"FROM busca_inscrito " + stmWhere);


            String[][] dados = new String[tamanho][13];
            String virgula;


            while (resultado.next()){
                dados[i][0] = resultado.getString("nomePe");
                dados[i][1] = resultado.getString("emailPe");
                dados[i][2] = resultado.getString("instituicaoPe");
                dados[i][3] = resultado.getString("telefonePe");
                dados[i][4] = resultado.getString("nacionalidadePe");
                dados[i][5] = resultado.getString("enderecoPe");
                
                dados[i][6] = resultado.getString("nomeEv");
                dados[i][7] = resultado.getString("numEd");
                dados[i][8] = resultado.getString("dataInsc");
                if (resultado.getString("tipoApresentador").equals("1")){
                    dados[i][9] = "Sim";
                } else{
                    dados[i][9] = "Não";
                }
                dados[i][10] = resultado.getString("codEv");
                dados[i][11] = resultado.getString("idPart");
                i++;
            }

            String [] colunas = {
                "Nome", "Email","Instituição","Telefone","Nacionalidade","Endereço", "Evento", "Edição", "Data de Inscrição", "Apresentador", "codEv", "idPart"
            };

            this.tabelaInscrito.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            this.tabelaInscrito.removeColumn(tabelaInscrito.getColumn("codEv"));
            this.tabelaInscrito.removeColumn(tabelaInscrito.getColumn("idPart"));

        }
    }    
    
    public Janela_Buscar_Inscrito(Connection conexao) {
        initComponents();
        
        this.conexao = conexao;
        if (this.conexao != null){
            try {
                this.Atualiza_Data_Model("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Buscar_Inscrito.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            System.out.println("Falha na conexao!");
        }
        
    }
    
    /**
     * Creates new form Janela_Buscar_Inscrito
     */
    public Janela_Buscar_Inscrito() {
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

        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaInscrito = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btn_filtrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNacionalidade = new javax.swing.JTextField();
        chk_apresentador = new javax.swing.JCheckBox();
        btn_remover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("Busca por Inscrito");

        jLabel2.setText("Nome");

        tabelaInscrito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaInscrito);

        jLabel3.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btn_filtrar.setText("Filtrar");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nacionalidade");

        txtNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadeActionPerformed(evt);
            }
        });

        chk_apresentador.setText("Tipo Apresentador");
        chk_apresentador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_apresentadorActionPerformed(evt);
            }
        });

        btn_remover.setText("Remover Selecionado");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(97, 97, 97)
                                .addComponent(chk_apresentador)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_remover)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(chk_apresentador))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_filtrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_remover))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed

        
        String and="",where="WHERE", stm="";
        
        if (!this.txtNome.getText().equals("")) {
            stm = stm + where + " nomePe LIKE '%" + txtNome.getText() + "%'"; 
            where = "";
            and = " AND";
        } 
         
        if (!this.txtEmail.getText().equals("")) {
            stm = stm + where + and + " emailPe LIKE '%" + txtEmail.getText() + "%'"; 
            where = "";
            and = " AND";
        } 
        
        
        if (!this.txtNacionalidade.getText().equals("")) {
            stm = stm + where + and + " nacionalidadePe LIKE '%" + txtNacionalidade.getText() + "%'"; 
            where = "";
            and = " AND";
        } 
                
        if (this.chk_apresentador.isSelected()) {
            stm = stm + where + and + " tipoApresentador = 1"; 
        }         
                        
        try {
            this.Atualiza_Data_Model(stm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void txtNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadeActionPerformed

    private void chk_apresentadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_apresentadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_apresentadorActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
       int index = tabelaInscrito.getSelectedRow();
        if (index != -1){
            String codEv = (String) tabelaInscrito.getModel().getValueAt(index, 10);
            String numEd = (String) tabelaInscrito.getModel().getValueAt(index, 7);
            String idPe = (String) tabelaInscrito.getModel().getValueAt(index, 11);

            String nome = (String) tabelaInscrito.getModel().getValueAt(index, 0);
            String email = (String) tabelaInscrito.getModel().getValueAt(index, 1);
            String nomeEv = (String) tabelaInscrito.getModel().getValueAt(index, 6);

            int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem certeza que deseja excluir " + nome + " com email " +  email + " como inscrito da " + numEd + "ª Edição do Evento " + nomeEv + "?","Aviso",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){

                System.out.println("REMOÇÃO DO INSCRITO " + idPe + "Ed:" + codEv + " - " + numEd);
                try {
                    resultado = DBconnection.executeSQLSelect(conexao,"DELETE FROM inscrito WHERE idPart = " + idPe + " AND codEv = " + codEv + " AND numEd = " + numEd);
                    System.out.println(resultado);
                    this.btn_filtrar.doClick();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                }

            
            }
            
        }
    }//GEN-LAST:event_btn_removerActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Buscar_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Buscar_Inscrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JCheckBox chk_apresentador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaInscrito;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNacionalidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
