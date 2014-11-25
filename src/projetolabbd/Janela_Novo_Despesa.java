/*
 * To change this template, choose Tools | Templates
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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author andrehena
 */
public class Janela_Novo_Despesa extends javax.swing.JFrame {
    String tipo;
    String codEv;
    String numEd;
    String codDesp;
    Janela_Buscar_Despesa janela;
    Connection conexao;
    ResultSet resultado;
    MaskFormatter mfData;

    public Janela_Novo_Despesa(Connection conexao, String tipo, String codEv, String numEd, String codDesp, Janela_Buscar_Despesa buscarDespesa) {
        this(conexao, tipo);
        this.codEv = codEv;
        this.numEd = numEd;
        this.codDesp = codDesp;
        this.janela = buscarDespesa;
        
        try {
            // Popula dados
            resultado = Selects.selectFromDespesaWithPK(conexao, codEv, numEd, codDesp);
            if (resultado.next()){

                    this.txtValor.setText(resultado.getString("valorDesp"));
                    this.txtDescricao.setText(resultado.getString("descricaoDesp"));
                    this.txtData.setText(resultado.getString("dataDesp"));
                    
                    //Seleciona tabela
                    int index = -1;
                    
                    for (int i = tabelaEvento.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaEvento.getModel().getValueAt(i, 9).equals(codEv) &&
                              tabelaEvento.getModel().getValueAt(i, 1).equals(numEd)  
                                ) {
                            index = i;
                        }
                    }   
                    
                    tabelaEvento.setRowSelectionInterval(index, index);

                    
                   for (int i = tabelaPatrocinio.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaPatrocinio.getModel().getValueAt(i, 0).equals(resultado.getString("cnpjPat")) &&
                              tabelaPatrocinio.getModel().getValueAt(i, 7).equals(resultado.getString("codEvPat")) &&
                              tabelaPatrocinio.getModel().getValueAt(i, 3).equals(resultado.getString("numEdPat")) 
                                
                                ) {
                            index = i;
                        }
                    }   
                    
                    tabelaPatrocinio.setRowSelectionInterval(index, index);          
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public Janela_Novo_Despesa(Connection conexao, String tipo) {
        try {
            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Patrocinio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {  
            initComponents();
            this.tabelaEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.tabelaPatrocinio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.conexao = conexao;
            this.tipo = tipo;
            if (this.conexao != null){
                /*try {
                this.Atualiza_Data_Model("");
                } catch (SQLException ex) {
                Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                if (tipo.equals("insert")){
                    this.btn_cancela.setVisible(false);
                } else if (tipo.equals("update")){
                    this.btn_cancela.setVisible(true);            
                }
                
            } else{
                System.out.println("Falha na conexao!");
            }
            
            //Popula tabela de eventos
            Selects.selectFromEdicao(conexao, "", tabelaEvento);

            //Popula Tabela de Patrocinio
            
            Selects.selectFromPatrocinio(conexao, "", tabelaPatrocinio);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Creates new form Janela_Novo_Evento
     */
    public Janela_Novo_Despesa() {
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
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPatrocinio = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEvento = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField(mfData);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Despesa");

        jLabel5.setText("Valor");

        jLabel6.setText("Descrição");

        jLabel7.setText("Data");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancela.setText("Cancelar");

        tabelaPatrocinio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaPatrocinio);

        jLabel9.setText("Evento / Edição");

        jLabel10.setText("Patrocínio");

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
        jScrollPane3.setViewportView(tabelaEvento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_cancela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_salvar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(348, 348, 348))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtValor)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_salvar)
                            .addComponent(btn_cancela))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        
        int evIndex = tabelaEvento.getSelectedRow();
        int patIndex = tabelaPatrocinio.getSelectedRow();
        String numEd = "", codEv = "", cnpjPat="", codEvPat="", numEdPat = "", data = "NULL";

        if (evIndex == -1){
            JOptionPane.showMessageDialog(null, "Preencher evento");
        } else {
        
            codEv = (String) tabelaEvento.getModel().getValueAt(evIndex, 9);
            numEd = (String) tabelaEvento.getModel().getValueAt(evIndex, 1);
            
            if (patIndex != -1){
                cnpjPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 0);
                codEvPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 7);
                numEdPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 3);
            }
            
            if (!this.txtData.getText().equals("__/__/____")){
                data = "TO_DATE('" + this.txtData + "','DD/MM/YYYY')";
            }
            
           if (this.tipo.equals("insert")){
                try {

                     resultado = DBconnection.executeSQLSelect(conexao,"INSERT INTO despesa VALUES(SEQ_CODDESP_DESPESA.NEXTVAL," + codEv + "," + numEd + "," + cnpjPat+","+ codEvPat + "," + numEdPat + ", " + data + ","+ this.txtValor.getText()+", '"+ this.txtDescricao.getText()+"')");
                     System.out.println(resultado);
                     this.setVisible(false);
                     this.dispose();
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex.getMessage());
                     Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                 }

            }else if (this.tipo.equals("update")){
                //SQL DE UPDATE
                //
                System.out.println("UPDATE DO EVENTO " + codEv);
                try {
                    System.out.println("UPDATE despesa SET cnpjPat = " + cnpjPat + ", codEvPat = " + codEvPat + ", numEdPat = " + numEdPat + ", dataDesp = " + data + ",valorDesp = " + this.txtValor.getText() + ", descricaoDesp = '" + this.txtDescricao.getText() + "' WHERE codDesp = " + codDesp + " AND codEv = " + codEv + " AND numEd = " + numEd
);
                    resultado = DBconnection.executeSQLSelect(conexao,"UPDATE despesa SET cnpjPat = " + cnpjPat + ", codEvPat = " + codEvPat + ", numEdPat = " + numEdPat + ", dataDesp = " + data + ",valorDesp = " + this.txtValor.getText() + ", descricaoDesp = '" + this.txtDescricao.getText() + "' WHERE codDesp = " + codDesp + " AND codEv = " + codEv + " AND numEd = " + numEd
);
                     System.out.println(resultado);
                     this.janela.atualizaTabela();
                     this.setVisible(false);
                     this.dispose();
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex.getMessage());
                     Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }

    }//GEN-LAST:event_btn_salvarActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Novo_Despesa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaEvento;
    private javax.swing.JTable tabelaPatrocinio;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
