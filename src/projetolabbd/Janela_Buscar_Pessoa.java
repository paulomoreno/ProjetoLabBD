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
public class Janela_Buscar_Pessoa extends javax.swing.JFrame {
    String tipo;
    Connection conexao;
    ResultSet resultado;
    
    private void Atualiza_Data_Model(String stmWhere) throws SQLException{
        if(this.tipo.equals("organizador")){
            Selects.selectFromOrganiza(conexao, stmWhere, tabelaPessoa);
        }else{
            Selects.selectFromPessoa(conexao, stmWhere, tabelaPessoa);
        }
    }    
    
    public Janela_Buscar_Pessoa(String tipo, Connection conexao) {
        initComponents();
        this.tipo = tipo;

        String where = "";
        
        if (tipo.equals("organizador")){
            this.chk_organizador.setSelected(true);
            this.chk_organizador.setEnabled(false);
            this.lbl_titulo.setText("Busca por Organizador");
            where = "WHERE tipoOrganizador = 1";
        } 
        
        this.conexao = conexao;
        if (this.conexao != null){
            try {
                this.Atualiza_Data_Model(where);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            System.out.println("Falha na conexao!");
        }
        
    }
    
    /**
     * Creates new form Janela_Buscar_Evento
     */
    public Janela_Buscar_Pessoa() {
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
        lbl_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoa = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btn_filtrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNacionalidade = new javax.swing.JTextField();
        chk_autor = new javax.swing.JCheckBox();
        chk_participante = new javax.swing.JCheckBox();
        chk_organizador = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btn_remover = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lbl_titulo.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        lbl_titulo.setText("Busca por Pessoa");

        jLabel2.setText("Nome");

        tabelaPessoa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaPessoa);

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

        chk_autor.setText("Autor");
        chk_autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_autorActionPerformed(evt);
            }
        });

        chk_participante.setText("Participante");
        chk_participante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_participanteActionPerformed(evt);
            }
        });

        chk_organizador.setText("Organizador");

        jLabel5.setText("Tipo Pessoa:");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
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
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chk_organizador)
                                    .addComponent(chk_participante)
                                    .addComponent(chk_autor))))
                        .addGap(0, 132, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_filtrar))
                    .addComponent(chk_organizador)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(chk_participante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_autor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_remover)
                    .addComponent(btn_editar))
                .addContainerGap())
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
        
        if (this.chk_organizador.isSelected()) {
            stm = stm + where + and + " tipoOrganizador = 1"; 
            where = "";
            and = " AND";
        } 
       
        if (this.chk_participante.isSelected()) {
            stm = stm + where + and + " tipoParticipante = 1"; 
            where = "";
            and = " AND";
        } 
        
        if (this.chk_autor.isSelected()) {
            stm = stm + where + and + " tipoAutor = 1"; 
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

    private void chk_autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_autorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_autorActionPerformed

    private void chk_participanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_participanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_participanteActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
    
        if(this.tipo.equals("organizador")){
            int index = tabelaPessoa.getSelectedRow();
            if (index != -1){
                String nome = (String) tabelaPessoa.getModel().getValueAt(index, 0);
                String email = (String) tabelaPessoa.getModel().getValueAt(index, 1);
                String codEv = (String) tabelaPessoa.getModel().getValueAt(index, 9);
                String numEd = (String) tabelaPessoa.getModel().getValueAt(index, 7);
                String idOrg = (String) tabelaPessoa.getModel().getValueAt(index, 10);
                
                int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem certeza que deseja excluir " + nome + " com email " +  email + "?","Aviso",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){

                    try {
                        resultado = DBconnection.executeSQLSelect(conexao,"CALL remove.removeOrganiza("+codEv+", "+numEd+", "+idOrg+")");
                        System.out.println(resultado);
                        this.btn_filtrar.doClick();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }

            }
        }else{
            int index = tabelaPessoa.getSelectedRow();
            if (index != -1){
                String idPe = (String) tabelaPessoa.getModel().getValueAt(index, 7);
                String nome = (String) tabelaPessoa.getModel().getValueAt(index, 0);
                String email = (String) tabelaPessoa.getModel().getValueAt(index, 1);

                int dialogResult = JOptionPane.showConfirmDialog (null, "Você tem certeza que deseja excluir " + nome + " com email " +  email + "?","Aviso",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){

                    System.out.println("REMOÇÃO DA PESSAO " + idPe);
                    try {
                        resultado = DBconnection.executeSQLSelect(conexao,"DELETE FROM pessoa WHERE idPe = " + idPe );
                        System.out.println(resultado);
                        this.btn_filtrar.doClick();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }

            }
        }
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        if(this.tipo.equals("organizador")){
            int index = tabelaPessoa.getSelectedRow();                
            if (index != -1){     

                String codEv = (String) tabelaPessoa.getModel().getValueAt(index, 9);
                String numEd = (String) tabelaPessoa.getModel().getValueAt(index, 7);
                String idOrg = (String) tabelaPessoa.getModel().getValueAt(index, 10);
                
                //Janela_Novo_Organiza updateOrganizador = new Janela_Novo_Organiza(conexao, "update", codEv, numEd, idOrg,this);
                //updateOrganizador.setVisible(true);
            }
        }else{
            int index = tabelaPessoa.getSelectedRow();
            if (index != -1){     
                String idPe = (String) tabelaPessoa.getModel().getValueAt(index, 7);
                Janela_Novo_Pessoa updatePessoa = new Janela_Novo_Pessoa(conexao, "update", idPe, this);
                updatePessoa.setVisible(true);
            }
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
            java.util.logging.Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Buscar_Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Buscar_Pessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JCheckBox chk_autor;
    private javax.swing.JCheckBox chk_organizador;
    private javax.swing.JCheckBox chk_participante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable tabelaPessoa;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNacionalidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
