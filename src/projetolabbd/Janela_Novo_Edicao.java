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
public class Janela_Novo_Edicao extends javax.swing.JFrame {
    String tipo;
    String codEv;
    String numEd;
    Janela_Buscar_Edicao janela;
    Connection conexao;
    ResultSet resultado;
    MaskFormatter mfData;

    public Janela_Novo_Edicao(Connection conexao, String tipo, String codEv, String numEd, Janela_Buscar_Edicao janela) {
        this(conexao, tipo);
        this.codEv = codEv;
        this.numEd = numEd;
        this.janela = janela;
        
        try {
            // Popula dados da despesa de acordo com a PK 
            resultado = Selects.selectFromEdicaoWithPK(conexao, codEv, numEd);
            // Casa exista resultado
            if (resultado.next()){

                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    
                    if (resultado.getDate("dataInicioEd")!=null){
                        this.txtDataInicio.setText(df.format(resultado.getDate("dataInicioEd")));
                    }
                    if (resultado.getDate("dataFimEd")!=null){
                        this.txtDataTermino.setText(df.format(resultado.getDate("dataFimEd")));
                    }
                    //Coloca nos textfields os valores respectivos
                    this.txtDescricao.setText(resultado.getString("descricaoEd"));
                    this.txtLocal.setText(resultado.getString("localEd"));
                    this.txtTaxa.setText(resultado.getString("taxaEd"));
                    
                    //Seleciona tabela
                    int index = -1;
                    
                    //Percorre a tabela (já populada) de eventos/edições e encontra o indice cuja PK é a PK da despesa atual
                    for (int i = tabelaEvento.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaEvento.getModel().getValueAt(i, 4).equals(codEv)
                                ) {
                            index = i;
                        }
                    }   
                    //Seleciona o evento/edição na tabela de evento/edição
                    tabelaEvento.setRowSelectionInterval(index, index);
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }


    public Janela_Novo_Edicao(Connection conexao, String tipo) {
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
            this.tabelaEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //Inicia a coneão e o tipo
            this.conexao = conexao;
            this.tipo = tipo;
            
            if (this.conexao != null){
                
                //Deixa o botão cancelar invisivel
                if (tipo.equals("insert")){
                    this.btn_cancela.setVisible(false);
                } else if (tipo.equals("update")){
                    this.btn_cancela.setVisible(true);            
                }
                
            } else{
                System.out.println("Falha na conexao!");
            }
            
            //Popula tabela de eventos com todos eventos/edições
            Selects.selectFromEvento(conexao, "", this.tabelaEvento);
            System.out.println("teste");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    /**
     * Creates new form Janela_Novo_Evento
     */
    public Janela_Novo_Edicao() {
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
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTaxa = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEvento = new javax.swing.JTable();
        txtDataInicio = new javax.swing.JFormattedTextField(mfData);
        txtDataTermino = new javax.swing.JFormattedTextField(mfData);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Edição");

        jLabel2.setText("Evento");

        jLabel3.setText("Descrição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Data de Início");

        jLabel5.setText("Data de Término");

        jLabel6.setText("Local");

        jLabel7.setText("Taxa");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancela.setText("Cancelar");

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

        txtDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioActionPerformed(evt);
            }
        });

        txtDataTermino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataTerminoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cancela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(284, 284, 284))
                            .addComponent(txtLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void txtDataTerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataTerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataTerminoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

        //Obtem o indice das tabelas de evento/edição e patrocinio
        int evIndex = tabelaEvento.getSelectedRow();
        String codEv = "", dataIn = "NULL", dataFim = "NULL";

        if (evIndex == -1){
            JOptionPane.showMessageDialog(null, "Preencher evento");
        //Se tem evento/edição selecionados:
        } else {
        
            //Obtem os campos codEv da tabela evento
            //Vale notar que 9 e 1 são os indices de coluna, definidos em SELECTS - não é o ideal
            // mas não tive tempo de bolar um jeitpo mais prático
            codEv = (String) tabelaEvento.getModel().getValueAt(evIndex, 4);
            
            //Verifica se a data está definida
            if (!this.txtDataInicio.getText().equals("__/__/____")){
                dataIn = "TO_DATE('" + this.txtDataInicio.getText() + "','DD/MM/YYYY')";
            }

            if (!this.txtDataTermino.getText().equals("__/__/____")){
                dataFim = "TO_DATE('" + this.txtDataTermino.getText() + "','DD/MM/YYYY')";
            }
            
            //Se é insert, realiza insert
           if (this.tipo.equals("insert")){
                try {
                    // código do insert
                    resultado = DBconnection.executeSQLSelect(conexao,"INSERT INTO edicao VALUES(" + codEv + ", SEQ_NUMED_EDICAO.NEXTVAL, '" + txtDescricao.getText() + "' ," + dataIn +","+ dataFim + ", '" + txtLocal.getText() + "' , " + txtTaxa.getText() + ", 0, 0)");
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
                     resultado = DBconnection.executeSQLSelect(conexao,"UPDATE edicao SET descricaoEd = '"+txtDescricao.getText()+"', dataInicioEd = "+dataIn+", dataFimEd = "+dataIn+", localEd = '"+txtLocal.getText()+"', taxaEd = "+txtTaxa.getText()+" WHERE codEV = "+ codEv +" AND numEd = "+numEd);
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
            java.util.logging.Logger.getLogger(Janela_Novo_Edicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Edicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Edicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Edicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Novo_Edicao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEvento;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtDataTermino;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTaxa;
    // End of variables declaration//GEN-END:variables
}
