/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolabbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


/**
 *
 * @author andrehena
 */
public class Janela_Novo_Despesa extends javax.swing.JFrame {
    String tipo;
    String codEv;
    String numEd;
    String codDesp;
    Connection conexao;
    ResultSet resultado;

    public Janela_Novo_Despesa(Connection conexao, String tipo, String codEv, String numEd, String codDesp) {
        this(conexao, tipo);
        this.codEv = codEv;
        this.numEd = numEd;
        this.codDesp = codDesp;
        
        // Popula dados
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM ");
            if (resultado.next()){
                int tamanho = resultado.getInt("total");
                int i = 0;
                
                resultado = DBconnection.executeSQLSelect(conexao,"SELECT codEv, nomeEv, descricaoEv, websiteEv FROM evento WHERE codEv = " + this.codEv);
                
                String[][] dados = new String[tamanho][5];
                
                if (resultado.next()){
                    this.txtNome.setText(resultado.getString("nomeEv"));
                    this.txtDescricao.setText(resultado.getString("descricaoEv"));
                    this.txtSite.setText(resultado.getString("websiteEv"));
                    
                    i++;
                }
    }


    public Janela_Novo_Despesa(Connection conexao, String tipo) {
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
            
            resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_edicao ");
            if (resultado.next()){
                int tamanho = resultado.getInt("total");
                int i = 0;

                resultado = DBconnection.executeSQLSelect(conexao,"SELECT codEv, numEd, nomeEv, numEd, descricaoEd, dataInicioEd, dataFimEd, localEd, taxaEd, saldoFinanceiroEd, qtdArtigosApresentadosEd FROM busca_edicao ");


                String[][] dados = new String[tamanho][10];


                while (resultado.next()){
                    dados[i][0] = resultado.getString("nomeEv");
                    dados[i][1] = resultado.getString("numEd");
                    dados[i][2] = resultado.getString("descricaoEd");
                    dados[i][3] = resultado.getString("dataInicioEd");
                    dados[i][4] = resultado.getString("dataFimEd");
                    dados[i][5] = resultado.getString("localEd");
                    dados[i][6] = resultado.getString("taxaEd");
                    dados[i][7] = resultado.getString("saldoFinanceiroEd");
                    dados[i][8] = resultado.getString("qtdArtigosApresentadosEd");
                    dados[i][9] = resultado.getString("codEv");

                    i++;
                }

            String [] colunas = {
                "Nome Evento", "Número Edição","Descrição","Data início","Data Fim","Local","Taxa de Inscrição", "Saldo Financeiro","Total de Artigos Apresentados", "codEv"
            };

            this.tabelaEvento.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            this.tabelaEvento.removeColumn(tabelaEvento.getColumn("codEv"));

             }
            
            //Popula Tabela de Patrocinio
            
            resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_patrocinio ");
            if (resultado.next()){
                int tamanho = resultado.getInt("total");
                int i = 0;

                resultado = DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, codEv, numEd, valorPat, saldoPat, dataPat, nomeEv FROM busca_patrocinio ");

                String[][] dados = new String[tamanho][8];

                while (resultado.next()){
                    dados[i][0] = resultado.getString("cnpjPat");
                    dados[i][1] = resultado.getString("razaoSocialPat");
                    dados[i][2] = resultado.getString("nomeEv");
                    dados[i][3] = resultado.getString("numEd");
                    dados[i][4] = resultado.getString("valorPat");
                    dados[i][5] = resultado.getString("saldoPat");
                    dados[i][6] = resultado.getString("dataPat");
                    dados[i][7] = resultado.getString("codEv");
                    i++;
                }

                String [] colunas = {
                    "CNPJ", "Razão Social","Evento","Edição","Valor", "Saldo", "Data", "codEv"
                };

                this.tabelaPatrocinio.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));
                this.tabelaPatrocinio.removeColumn(tabelaPatrocinio.getColumn("codEv"));

            }
            
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
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPatrocinio = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEvento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Despesa");

        jLabel5.setText("Valor");

        jTextField1.setText("???");

        jLabel6.setText("Descrição");

        jLabel7.setText("Data");

        btn_salvar.setText("Salvar");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_salvar)
                            .addComponent(btn_cancela))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tabelaEvento;
    private javax.swing.JTable tabelaPatrocinio;
    // End of variables declaration//GEN-END:variables
}
