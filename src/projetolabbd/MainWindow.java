/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolabbd;

import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author paulomoreno
 */
public class MainWindow extends javax.swing.JFrame {
    
    Connection conexao;
    DBconnection dbconexao;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        this.setVisible(true);

        try {
            dbconexao = new DBconnection();
            conexao = dbconexao.getConexao(); 
            
            if (conexao == null) {
                JOptionPane.showMessageDialog(null,"Falha ao conectar com o banco");
                this.setVisible(false);
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Falha ao conectar com o banco");
            this.setVisible(false);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        mn_sair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mn_novo_evento = new javax.swing.JMenuItem();
        mn_nova_edicao = new javax.swing.JMenuItem();
        mn_nova_pessoa = new javax.swing.JMenuItem();
        mn_novo_inscrito = new javax.swing.JMenuItem();
        mn_novo_organizador = new javax.swing.JMenuItem();
        mn_novo_artigo = new javax.swing.JMenuItem();
        mn_novo_patrocinador = new javax.swing.JMenuItem();
        mn_novo_patrocinio = new javax.swing.JMenuItem();
        mn_nova_despesa = new javax.swing.JMenuItem();
        mn_novo_auxilio = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mn_busca_evento = new javax.swing.JMenuItem();
        mn_busca_edicao = new javax.swing.JMenuItem();
        mn_busca_pessoa = new javax.swing.JMenuItem();
        mn_busca_inscrito = new javax.swing.JMenuItem();
        mn_busca_organizador = new javax.swing.JMenuItem();
        mn_busca_artigo = new javax.swing.JMenuItem();
        mn_busca_patrocinador = new javax.swing.JMenuItem();
        mn_busca_patrocinio = new javax.swing.JMenuItem();
        mn_busca_despesa = new javax.swing.JMenuItem();
        mn_busca_auxilio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        jMenu2.setText("jMenu2");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem14.setText("jMenuItem14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jMenu6.setText("Editar");

        mn_sair.setText("Sair");
        mn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_sairActionPerformed(evt);
            }
        });
        jMenu6.add(mn_sair);

        jMenuBar1.add(jMenu6);

        jMenu1.setText("Novo");

        mn_novo_evento.setText("Evento");
        mn_novo_evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_eventoActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_evento);

        mn_nova_edicao.setText("Edição");
        mn_nova_edicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_nova_edicaoActionPerformed(evt);
            }
        });
        jMenu1.add(mn_nova_edicao);

        mn_nova_pessoa.setText("Pessoa");
        mn_nova_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_nova_pessoaActionPerformed(evt);
            }
        });
        jMenu1.add(mn_nova_pessoa);

        mn_novo_inscrito.setText("Inscrito");
        mn_novo_inscrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_inscritoActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_inscrito);

        mn_novo_organizador.setText("Organizador");
        mn_novo_organizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_organizadorActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_organizador);

        mn_novo_artigo.setText("Artigo");
        mn_novo_artigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_artigoActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_artigo);

        mn_novo_patrocinador.setText("Patrocinador");
        mn_novo_patrocinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_patrocinadorActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_patrocinador);

        mn_novo_patrocinio.setText("Patrocínio");
        mn_novo_patrocinio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_patrocinioActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_patrocinio);

        mn_nova_despesa.setText("Despesa");
        mn_nova_despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_nova_despesaActionPerformed(evt);
            }
        });
        jMenu1.add(mn_nova_despesa);

        mn_novo_auxilio.setText("Auxílio");
        mn_novo_auxilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_novo_auxilioActionPerformed(evt);
            }
        });
        jMenu1.add(mn_novo_auxilio);

        jMenuBar1.add(jMenu1);

        jMenu7.setText("Buscas");

        mn_busca_evento.setText("Evento");
        mn_busca_evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_eventoActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_evento);

        mn_busca_edicao.setText("Edição");
        mn_busca_edicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_edicaoActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_edicao);

        mn_busca_pessoa.setText("Pessoa");
        mn_busca_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_pessoaActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_pessoa);

        mn_busca_inscrito.setText("Inscrito");
        mn_busca_inscrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_inscritoActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_inscrito);

        mn_busca_organizador.setText("Organizador");
        mn_busca_organizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_organizadorActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_organizador);

        mn_busca_artigo.setText("Artigo");
        mn_busca_artigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_artigoActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_artigo);

        mn_busca_patrocinador.setText("Patrocinador");
        mn_busca_patrocinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_patrocinadorActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_patrocinador);

        mn_busca_patrocinio.setText("Patrocínio");
        mn_busca_patrocinio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_patrocinioActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_patrocinio);

        mn_busca_despesa.setText("Despesa");
        mn_busca_despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_despesaActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_despesa);

        mn_busca_auxilio.setText("Auxílio");
        mn_busca_auxilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_busca_auxilioActionPerformed(evt);
            }
        });
        jMenu7.add(mn_busca_auxilio);

        jMenuBar1.add(jMenu7);

        jMenu3.setText("Consultas");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Relatorios");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mn_nova_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_nova_pessoaActionPerformed
        Janela_Novo_Pessoa novoPessoa = new Janela_Novo_Pessoa(conexao,"insert");
        novoPessoa.setVisible(true);
    }//GEN-LAST:event_mn_nova_pessoaActionPerformed

    private void mn_novo_inscritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_inscritoActionPerformed
        Janela_Novo_Inscrito novoInscrito = new Janela_Novo_Inscrito(conexao,"insert");
        novoInscrito.setVisible(true);
    }//GEN-LAST:event_mn_novo_inscritoActionPerformed

    private void mn_novo_eventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_eventoActionPerformed
        Janela_Novo_Evento novoEvento = new Janela_Novo_Evento(conexao,"insert");
        novoEvento.setVisible(true);
    }//GEN-LAST:event_mn_novo_eventoActionPerformed

    private void mn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_sairActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_mn_sairActionPerformed

    private void mn_busca_eventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_eventoActionPerformed
        Janela_Buscar_Evento buscarEvento = new Janela_Buscar_Evento(this.conexao);
        buscarEvento.setVisible(true);
    }//GEN-LAST:event_mn_busca_eventoActionPerformed

    private void mn_busca_inscritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_inscritoActionPerformed
        Janela_Buscar_Inscrito buscarInscrito = new Janela_Buscar_Inscrito(conexao);
        buscarInscrito.setVisible(true);
    }//GEN-LAST:event_mn_busca_inscritoActionPerformed

    private void mn_busca_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_pessoaActionPerformed
        Janela_Buscar_Pessoa buscarPessoa = new Janela_Buscar_Pessoa("",conexao);
        buscarPessoa.setVisible(true);
    }//GEN-LAST:event_mn_busca_pessoaActionPerformed

    private void mn_busca_edicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_edicaoActionPerformed
        Janela_Buscar_Edicao buscarEdicao = new Janela_Buscar_Edicao(conexao);
        buscarEdicao.setVisible(true);
    }//GEN-LAST:event_mn_busca_edicaoActionPerformed

    private void mn_busca_artigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_artigoActionPerformed
        Janela_Buscar_Artigo buscarArtigo = new Janela_Buscar_Artigo(conexao);
        buscarArtigo.setVisible(true);
    }//GEN-LAST:event_mn_busca_artigoActionPerformed

    private void mn_busca_organizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_organizadorActionPerformed
        Janela_Buscar_Pessoa buscarPessoa = new Janela_Buscar_Pessoa("organizador", conexao);
        buscarPessoa.setVisible(true);
    }//GEN-LAST:event_mn_busca_organizadorActionPerformed

    private void mn_busca_patrocinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_patrocinadorActionPerformed
        Janela_Buscar_Patrocinador buscarPatrocinador = new Janela_Buscar_Patrocinador(conexao);
        buscarPatrocinador.setVisible(true);
    }//GEN-LAST:event_mn_busca_patrocinadorActionPerformed

    private void mn_busca_patrocinioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_patrocinioActionPerformed
        Janela_Buscar_Patrocinio buscarPatrocinio = new Janela_Buscar_Patrocinio(conexao);
        buscarPatrocinio.setVisible(true);
    }//GEN-LAST:event_mn_busca_patrocinioActionPerformed

    private void mn_busca_despesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_despesaActionPerformed
        Janela_Buscar_Despesa buscarDespesa = new Janela_Buscar_Despesa(conexao);
        buscarDespesa.setVisible(true);
    }//GEN-LAST:event_mn_busca_despesaActionPerformed

    private void mn_busca_auxilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_busca_auxilioActionPerformed
        Janela_Buscar_Auxilio buscarAuxilio = new Janela_Buscar_Auxilio(conexao);
        buscarAuxilio.setVisible(true);
    }//GEN-LAST:event_mn_busca_auxilioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            System.out.println("Desconectando conexão com o banco de dados");
            dbconexao.disconect(conexao);
            System.out.println("Conexão desconectada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void mn_novo_artigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_artigoActionPerformed
        Janela_Novo_Artigo novoArtigo = new Janela_Novo_Artigo(conexao,"insert");
        novoArtigo.setVisible(true);
    }//GEN-LAST:event_mn_novo_artigoActionPerformed

    private void mn_nova_edicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_nova_edicaoActionPerformed
        Janela_Novo_Edicao novoEdicao = new Janela_Novo_Edicao(conexao,"insert");
        novoEdicao.setVisible(true);
    }//GEN-LAST:event_mn_nova_edicaoActionPerformed

    private void mn_novo_organizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_organizadorActionPerformed
        Janela_Novo_Evento novoEvento = new Janela_Novo_Evento(conexao,"insert");
        novoEvento.setVisible(true);
    }//GEN-LAST:event_mn_novo_organizadorActionPerformed

    private void mn_novo_patrocinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_patrocinadorActionPerformed
        Janela_Novo_Patrocinador novoPatrocinador = new Janela_Novo_Patrocinador(conexao,"insert");
        novoPatrocinador.setVisible(true);
    }//GEN-LAST:event_mn_novo_patrocinadorActionPerformed

    private void mn_novo_patrocinioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_patrocinioActionPerformed
        Janela_Novo_Patrocinio novoPatrocinio = new Janela_Novo_Patrocinio(conexao,"insert");
        novoPatrocinio.setVisible(true);
    }//GEN-LAST:event_mn_novo_patrocinioActionPerformed

    private void mn_nova_despesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_nova_despesaActionPerformed
        Janela_Novo_Despesa novoDespesa = new Janela_Novo_Despesa(conexao,"insert");
        novoDespesa.setVisible(true);
    }//GEN-LAST:event_mn_nova_despesaActionPerformed

    private void mn_novo_auxilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_novo_auxilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mn_novo_auxilioActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mn_busca_artigo;
    private javax.swing.JMenuItem mn_busca_auxilio;
    private javax.swing.JMenuItem mn_busca_despesa;
    private javax.swing.JMenuItem mn_busca_edicao;
    private javax.swing.JMenuItem mn_busca_evento;
    private javax.swing.JMenuItem mn_busca_inscrito;
    private javax.swing.JMenuItem mn_busca_organizador;
    private javax.swing.JMenuItem mn_busca_patrocinador;
    private javax.swing.JMenuItem mn_busca_patrocinio;
    private javax.swing.JMenuItem mn_busca_pessoa;
    private javax.swing.JMenuItem mn_nova_despesa;
    private javax.swing.JMenuItem mn_nova_edicao;
    private javax.swing.JMenuItem mn_nova_pessoa;
    private javax.swing.JMenuItem mn_novo_artigo;
    private javax.swing.JMenuItem mn_novo_auxilio;
    private javax.swing.JMenuItem mn_novo_evento;
    private javax.swing.JMenuItem mn_novo_inscrito;
    private javax.swing.JMenuItem mn_novo_organizador;
    private javax.swing.JMenuItem mn_novo_patrocinador;
    private javax.swing.JMenuItem mn_novo_patrocinio;
    private javax.swing.JMenuItem mn_sair;
    // End of variables declaration//GEN-END:variables
}
