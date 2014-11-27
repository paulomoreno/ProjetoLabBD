/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolabbd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
public class Janela_Novo_Artigo extends javax.swing.JFrame {
    String tipo;
    String idArt;
    Janela_Buscar_Artigo janela;
    Connection conexao;
    ResultSet resultado;
    MaskFormatter mfData;
    MaskFormatter mfHora;

    public Janela_Novo_Artigo(Connection conexao, String tipo, String idArt, Janela_Buscar_Artigo janela) {
        this(conexao, tipo);
        this.idArt = idArt;
        this.janela = janela;
        
          try {
            // Popula dados da despesa de acordo com a PK 
            resultado = Selects.selectFromArtigoWithPK(conexao, idArt);
            // Casa exista resultado
            if (resultado.next()){
                
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    DateFormat hf = new SimpleDateFormat("HH:mm");

                    Date dt = resultado.getDate("dataApresArt");
                    Time tm = resultado.getTime("horaApresArt");
                    
                    if (dt!=null){
                        this.txtData.setText(df.format(dt));
                    }
                    
                    if (tm !=null){
                        this.txtHora.setText(hf.format(tm));
                    }
                                    
                    //Coloca nos textfields os valores respectivos
                    this.txtTitulo.setText(resultado.getString("tituloArt"));
                    
                    //Seleciona tabela
                    int index = -1;
                    
                    //Percorre a tabela (já populada) de eventos/edições e encontra o indice cuja PK é a PK da despesa atual
                    for (int i = tabelaInscrito.getModel().getRowCount() - 1; i >= 0; --i) {
                        if (tabelaInscrito.getModel().getValueAt(i, 10).equals(resultado.getString("codEv")) &&
                              tabelaInscrito.getModel().getValueAt(i, 7).equals(resultado.getString("numEd"))  &&
                              tabelaInscrito.getModel().getValueAt(i, 11).equals(resultado.getString("idApr"))  
                                ) {
                            index = i;
                        }
                    }   
                    //Seleciona o evento/edição na tabela de evento/edição
                    tabelaInscrito.setRowSelectionInterval(index, index);
                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Novo_Auxilio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public Janela_Novo_Artigo(Connection conexao, String tipo) {
            // Inicia o código do MaskFormatter (para colocar a máscara de data)
        try {
            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            mfHora = new MaskFormatter("##:##");
            mfHora.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Janela_Buscar_Patrocinio.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {  
            initComponents();
            //Define que o usuário só pode selecionar uma linha das tabelas
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
    public Janela_Novo_Artigo() {
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
        jLabel4 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btn_cancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaInscrito = new javax.swing.JTable();
        txtData = new javax.swing.JFormattedTextField(mfData);
        txtHora = new javax.swing.JFormattedTextField(mfHora);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Artigo");

        jLabel2.setText("Título do Artigo");

        jLabel3.setText("Data de Apresentação");

        jLabel4.setText("Hora de Apresentação");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Apresentador");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
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

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(txtTitulo))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_cancela)
                .addGap(18, 18, 18)
                .addComponent(btn_salvar)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancela)
                    .addComponent(btn_salvar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //Obtem o indice das tabelas de evento/edição e patrocinio
        int insIndex = tabelaInscrito.getSelectedRow();
        String numEd = "", codEv = "", idApr = "", data = "NULL", hora="NULL";

        if (insIndex == -1){
            JOptionPane.showMessageDialog(null, "Preencher evento");
        //Se tem evento/edição selecionados:
        } else {
        
            //Se inscrito está selecionado, obtem seus dados
            idApr = (String) tabelaInscrito.getModel().getValueAt(insIndex, 11);
            codEv = (String) tabelaInscrito.getModel().getValueAt(insIndex, 10);
            numEd = (String) tabelaInscrito.getModel().getValueAt(insIndex, 7);

            
            //Verifica se a data está definida
            if (!this.txtData.getText().equals("__/__/____")){
                data = "TO_DATE('" + this.txtData.getText() + "','DD/MM/YYYY')";
            }
            
            if (!this.txtHora.getText().equals("__:__")){
                hora = "TO_DATE('" + this.txtHora.getText() + "','HH24:MI')";
            }
                        
            
            //Se é insert, realiza insert
           if (this.tipo.equals("insert")){
                try {
                    // código do insert
                    System.out.println("INSERT INTO artigo VALUES(SEQ_IDART_ARTIGO.NEXTVAL,'"+this.txtTitulo.getText()+"',"+data+","+hora+","+codEv+","+numEd+","+idApr+")");
                    resultado = DBconnection.executeSQLSelect(conexao, "INSERT INTO artigo VALUES(SEQ_IDART_ARTIGO.NEXTVAL,'"+this.txtTitulo.getText()+"',"+data+","+hora+","+codEv+","+numEd+","+idApr+")");
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
                    resultado = DBconnection.executeSQLSelect(conexao, "UPDATE artigo SET tituloArt = '"+this.txtTitulo.getText()+"', dataApresArt = "+data+", horaApresArt = "+hora+", codEv = "+codEv+", numEd = "+numEd+", idApr = "+idApr+" WHERE idArt = "+idArt);
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

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Novo_Artigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Artigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Artigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Novo_Artigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Novo_Artigo().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaInscrito;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
