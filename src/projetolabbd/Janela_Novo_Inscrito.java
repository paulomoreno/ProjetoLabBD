/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolabbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author andrehena
 */
public class Janela_Novo_Inscrito extends javax.swing.JFrame {
    String tipo;
    String codEv;
    String numEd;
    String idPart;
    Janela_Buscar_Inscrito janela;
    Connection conexao;
    ResultSet resultado;
    MaskFormatter mfData;

    public Janela_Novo_Inscrito(Connection conexao, String tipo, String codEv, String numEd, String idPart, Janela_Buscar_Inscrito buscarInscrito) {
        this(conexao, tipo);
        this.codEv = codEv;
        this.numEd = numEd;
        this.idPart = idPart;
        this.janela = buscarInscrito;
        
        try {
            // Popula dados da inscrição de acordo com a PK 
            resultado = Selects.selectFromInscritoWithPK(conexao, codEv, numEd, idPart);
            // Casa exista resultado
            if (resultado.next()){

                    //Coloca nos textfields os valores respectivos
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    
                    if (resultado.getDate("dataInsc")!=null){
                        this.txtData.setText(df.format(resultado.getDate("dataInsc")));
                    }
                    
                    //Seleciona tabela
                    int index = -1;
                    
                    //Percorre a tabela (já populada) de eventos/edições e encontra o indice cuja PK é a PK do inscritoatual
                    for (int i = tabelaEvento.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaEvento.getModel().getValueAt(i, 9).equals(codEv) &&
                              tabelaEvento.getModel().getValueAt(i, 1).equals(numEd)  
                                ) {
                            index = i;
                        }
                    }   
                    //Seleciona o evento/edição na tabela de evento/edição
                    tabelaEvento.setRowSelectionInterval(index, index);

                    //Procura a PESSOAcorrespondente de INSCRITO
                   for (int i = tabelaParticipante.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaParticipante.getModel().getValueAt(i, 7).equals(idPart)) {
                            index = i;
                        }
                    }   
                    
                   //Seleciona este patrocinio
                    tabelaParticipante.setRowSelectionInterval(index, index);          
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


    public Janela_Novo_Inscrito(Connection conexao, String tipo) {
        
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
            this.tabelaParticipante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
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
        
            //Popula tabela de eventos com todos eventos/edições
            Selects.selectFromEdicao(conexao, "", tabelaEvento);

            //Popula Tabela de Patrocinio com todos os patrocinios
            Selects.selectFromPessoa(conexao, "", tabelaParticipante);
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
    /**
     * Creates new form Janela_Novo_Evento
     */
    public Janela_Novo_Inscrito() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField(mfData);
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEvento = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaParticipante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Inscrito");

        jLabel2.setText("Evento / Edição");

        jLabel4.setText("Participante");

        jLabel5.setText("Data de Inscrição");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancela.setText("Cancelar");
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });

        txtData.setText("jFormattedTextField1");

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

        tabelaParticipante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelaParticipante);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(70, 70, 70)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cancela)))
                .addGap(18, 18, 18)
                .addComponent(btn_salvar)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancela))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
            //Obtem o indice das tabelas de evento/edição e patrocinio
        int evIndex = tabelaEvento.getSelectedRow();
        int parIndex = tabelaParticipante.getSelectedRow();
        String numEd = "", codEv = "", cnpjPat="", codEvPat="", numEdPat = "", data = "NULL";

        if (evIndex == -1){
            JOptionPane.showMessageDialog(null, "Preencher evento");
        //Se tem evento/edição selecionados:
        } //else if (parIndex == -1){
            //JOptionPane.showMessageDialog(null, "Preencher participante"); }
        else {
        
            //Obtem os campos codEv e numEd da tabela evento/edição
            //Vale notar que 9 e 1 são os indices de coluna, definidos em SELECTS - não é o ideal
            // mas não tive tempo de bolar um jeitpo mais prático
            codEv = (String) tabelaEvento.getModel().getValueAt(evIndex, 9);
            numEd = (String) tabelaEvento.getModel().getValueAt(evIndex, 1);
            //obtém o
           // idPart = (String) tabelaParticipante.getModel().getValueAt(parIndex, 7);
            
            
            //Se participante está selecionado, obtem seus dados
            if (parIndex != -1){
              //  cnpjPat = (String) tabelaParticipante.getModel().getValueAt(parIndex, 0);
                idPart = (String) tabelaParticipante.getModel().getValueAt(parIndex, 7);
               // numEdPat = (String) tabelaParticipante.getModel().getValueAt(parIndex, 3);
            }
            
            //Verifica se a data está definida
            if (!this.txtData.getText().equals("__/__/____")){
                data = "TO_DATE('" + this.txtData.getText() + "','DD/MM/YYYY')";
            }
            
            //Se é insert, realiza insert
           if (this.tipo.equals("insert")){
                try {
                    // código do insert
                    //System.out.println("INSERT INTO inscrito VALUES(" + codEv + "," + numEd + "," + idPart + "," + data + ", 0)");
                    resultado = DBconnection.executeSQLSelect(conexao,"INSERT INTO inscrito VALUES(" + codEv + "," + numEd + "," + idPart + "," + data + ", 0)");
                    System.out.println(resultado);
                     
                     //Fecha a janela
                     this.setVisible(false);
                     this.dispose();
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex.getMessage());
                     Logger.getLogger(Janela_Buscar_Evento.class.getName()).log(Level.SEVERE, null, ex);
                 }

            // Se é update, realiza um update
            }else if (this.tipo.equals("update")){
                //SQL DE UPDATE
                System.out.println("UPDATE DO EVENTO " + codEv);
                try {
                    //Código SQL do update                    
                     resultado = DBconnection.executeSQLSelect(conexao,"UPDATE inscrito SET codEv = " + codEv + ", numEd = " + numEd + ", idPart = " + idPart + ", dataInsc = " + data + " WHERE idPart = " + idPart + " AND codEv = " + codEv + " AND numEd = " + numEd);
                     System.out.println(resultado);
                     
                     //FEcha a janela
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

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btn_cancelaActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Inscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Novo_Inscrito().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaEvento;
    private javax.swing.JTable tabelaParticipante;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
