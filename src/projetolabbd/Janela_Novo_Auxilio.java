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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author andrehena
 */
public class Janela_Novo_Auxilio extends javax.swing.JFrame {
    String tipo;
    String codEvApr;
    String numEdApr;
    String idApr;
    String tipoAux;
    Janela_Buscar_Auxilio janela;
    Connection conexao;
    ResultSet resultado;
    MaskFormatter mfData;

    /*
        Construtor que recebe a PK de despesa e a janela pai, no caso de ser uma edição
    */
    public Janela_Novo_Auxilio(Connection conexao, String tipo, String codEvApr, String numEdApr, String idApr, String tipoAux, Janela_Buscar_Auxilio buscarAuxilio) {
        // Chama o construtor normal (com o tipo que será "update")
        this(conexao, tipo);
        // Salva as informações de PK e janela pai
        this.codEvApr = codEvApr;
        this.numEdApr = numEdApr;
        this.idApr = idApr;
        this.tipoAux = tipoAux;
        this.janela = buscarAuxilio;
        
        try {
            // Popula dados da despesa de acordo com a PK 
            resultado = Selects.selectFromAuxilioWithPK(conexao, codEvApr, numEdApr, idApr, tipoAux); 
            // Casa exista resultado
            if (resultado.next()){

                    //Coloca nos textfields os valores respectivos
                    this.txtValor.setText(resultado.getString("valorAux"));
                    this.cmb_tipo.setSelectedItem(resultado.getString("tipoAux"));
                    
                    //this.txtData.setText(resultado.getString("dataAux"));
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    
                    if (resultado.getDate("dataAux")!=null){
                        this.txtData.setText(df.format(resultado.getDate("dataAux")));
                    }
                    
                    //Seleciona tabela
                    int index = -1;
                    
                    //Percorre a tabela (já populada) de eventos/edições e encontra o indice cuja PK é a PK da despesa atual
                    for (int i = tabelaInscrito.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaInscrito.getModel().getValueAt(i, 10).equals(codEvApr) &&
                              tabelaInscrito.getModel().getValueAt(i, 7).equals(numEdApr)  &&
                              tabelaInscrito.getModel().getValueAt(i, 11).equals(idApr)  
                                ) {
                            index = i;
                        }
                    }   
                    //Seleciona o evento/edição na tabela de evento/edição
                    tabelaInscrito.setRowSelectionInterval(index, index);

                    //PRocura o patrocinio correspondente desta despesa
                   for (int i = tabelaPatrocinio.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaPatrocinio.getModel().getValueAt(i, 0).equals(resultado.getString("cnpjPat")) &&
                              tabelaPatrocinio.getModel().getValueAt(i, 7).equals(resultado.getString("codEvPat")) &&
                              tabelaPatrocinio.getModel().getValueAt(i, 3).equals(resultado.getString("numEdPat")) 
                                
                                ) {
                            index = i;
                        }
                    }   
                    
                   //Seleciona este patrocinio
                    tabelaPatrocinio.setRowSelectionInterval(index, index);          
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public Janela_Novo_Auxilio(Connection conexao, String tipo) {
        // Inicia o código do MaskFormatter (para colocar a máscara de data)
        try {
            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Patrocinio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {  
            initComponents();
            //Define que o usuário só pode selecionar uma linha das tabelas
            this.tabelaPatrocinio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.tabelaInscrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //Inicia a coneão e o tipo
            this.conexao = conexao;
            this.tipo = tipo;
            if (this.conexao != null){
                /*try {
                this.Atualiza_Data_Model("");
                } catch (SQLException ex) {
                Logger.getLogger(Janela_Buscar_Despesa.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                //Deixa o botão cancelar invisivel
                if (tipo.equals("insert")){
                    this.btn_cancela.setVisible(false);
                } else if (tipo.equals("update")){
                    this.btn_cancela.setVisible(true);            
                }
                
            } else{
                System.out.println("Falha na conexao!");
            }
            
            //Popula Tabela de Patrocinio com todos os patrocinios
            Selects.selectFromPatrocinio(conexao, "", tabelaPatrocinio);
            
            //Popula Tabela de Inscrito com todos os inscritos
            Selects.selectFromInscrito(conexao, "", tabelaInscrito);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Creates new form Janela_Novo_Evento
     */
    public Janela_Novo_Auxilio() {
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
        jLabel7 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaInscrito = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPatrocinio = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField(mfData);
        cmb_tipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Despesa");

        jLabel5.setText("Valor");

        jLabel6.setText("Tipo");

        jLabel7.setText("Data");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancela.setText("Cancelar");

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
        jScrollPane2.setViewportView(tabelaInscrito);

        jLabel9.setText("Patrocinio");

        jLabel10.setText("Inscrito");

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
        jScrollPane3.setViewportView(tabelaPatrocinio);

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "hospedagem", "alimentação", "transporte", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(4, 4, 4)))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 52, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                    .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //Obtem o indice das tabelas de evento/edição e patrocinio
        int insIndex = tabelaInscrito.getSelectedRow();
        int patIndex = tabelaPatrocinio.getSelectedRow();
        String numEdApr = "", codEvApr = "", idApr = "", cnpjPat="", codEvPat="", numEdPat = "", data = "NULL";

        if (insIndex == -1){
            JOptionPane.showMessageDialog(null, "Preencher evento");
        //Se tem evento/edição selecionados:
        } else {
        
            //Se inscrito está selecionado, obtem seus dados
            idApr = (String) tabelaInscrito.getModel().getValueAt(insIndex, 11);
            codEvApr = (String) tabelaInscrito.getModel().getValueAt(insIndex, 10);
            numEdApr = (String) tabelaInscrito.getModel().getValueAt(insIndex, 7);
            
            //Se patrocinios está selecionado, obtem seus dados
            if (patIndex != -1){
                cnpjPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 0);
                codEvPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 7);
                numEdPat = (String) tabelaPatrocinio.getModel().getValueAt(patIndex, 3);
            }
            
            //Verifica se a data está definida
            if (!this.txtData.getText().equals("__/__/____")){
                data = "TO_DATE('" + this.txtData + "','DD/MM/YYYY')";
            }
            
            //Se é insert, realiza insert
           if (this.tipo.equals("insert")){
                try {
                    // código do insert
                   //  resultado = DBconnection.executeSQLSelect(conexao,"INSERT INTO despesa VALUES(SEQ_CODDESP_DESPESA.NEXTVAL," + codEv + "," + numEd + "," + cnpjPat+","+ codEvPat + "," + numEdPat + ", " + data + ","+ this.txtValor.getText()+", '"+ this.txtDescricao.getText()+"')");
                   resultado = DBconnection.executeSQLSelect(conexao, "INSERT INTO auxilio VALUES('"+cnpjPat+"', "+codEvPat+", "+numEdPat+", "+codEvApr+", "+numEdApr+", "+idApr+", "+this.txtValor.getText()+", "+data+",'"+this.cmb_tipo.getSelectedItem().toString().toLowerCase()+"')");
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
                try {
                    //Código SQL do update
                    resultado = DBconnection.executeSQLSelect(conexao, "UPDATE auxilio SET cnpjPat = '"+cnpjPat+"', codEvPat = "+codEvPat+", numEdPat = "+numEdPat+", valorAux = "+this.txtValor.getText()+", dataAux = "+data + " WHERE  codEvApr = "+codEvApr+" AND numEdApr = "+numEdApr+" AND idApr = "+idApr+" AND tipoAux = '" + tipoAux.toLowerCase()+"'");
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
            java.util.logging.Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Novo_Auxilio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox cmb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaInscrito;
    private javax.swing.JTable tabelaPatrocinio;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
