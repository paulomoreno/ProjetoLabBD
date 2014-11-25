/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolabbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author paulomoreno
 */
public class Selects {
        
    public static void selectFromEvento(Connection conexao, String stmWhere, JTable tabelaEvento) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM evento " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT codEv, nomeEv, descricaoEv, websiteEv, totalArtigosApresentadosEv FROM evento " + stmWhere);

            String[][] dados = new String[tamanho][5];

            while (resultado.next()){
                dados[i][0] = resultado.getString("nomeEv");
                dados[i][1] = resultado.getString("descricaoEv");
                dados[i][2] = resultado.getString("websiteEv");
                dados[i][3] = resultado.getString("totalArtigosApresentadosEv");
                dados[i][4] = resultado.getString("codEv");

                                System.out.println(dados[i][0]);
                i++;
                System.out.println("i:"+i);

            }
            
            System.out.println(dados);

            String [] colunas = {
                "Nome", "Descrição","Site","Total de Artigos Apresentados", "Codigo"
            };
            
            System.out.println("lalalalala");
            System.out.println(tabelaEvento.hashCode());

            tabelaEvento.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaEvento.removeColumn(tabelaEvento.getColumn("Codigo"));
        }
    }
    
    public static ResultSet selectFromEventoWithPK(Connection conexao, String codEv) throws SQLException{
        return DBconnection.executeSQLSelect(conexao,"SELECT codEv, nomeEv, descricaoEv, websiteEv FROM evento WHERE codEv = " + codEv);
    }
    
    public static void selectFromEdicao(Connection conexao, String stmWhere, JTable tabelaEdicao) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_edicao " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT codEv, numEd, nomeEv, numEd, descricaoEd, dataInicioEd, dataFimEd, localEd, taxaEd, saldoFinanceiroEd, qtdArtigosApresentadosEd FROM busca_edicao " + stmWhere);


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
                "Nome Evento", "Número Edição","Descrição","Data início","DAta Fim","Local","Taxa de Inscrição", "Saldo Financeiro","Total de Artigos Apresentados", "codEv"
            };

            tabelaEdicao.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaEdicao.removeColumn(tabelaEdicao.getColumn("codEv"));

        }
    }
    
    public static ResultSet selectFromEdicaoWithPK(Connection conexao, String codEv, String numEd) throws SQLException{
        return DBconnection.executeSQLSelect(conexao,"SELECT nomeEv, descricaoEd, dataInicioEd, dataFimEd, localEd, taxaEd, saldoFinanceiroEd, qtdArtigosApresentadosEd FROM busca_edicao WHERE codEv = " + codEv + " AND numEd = " + numEd);
    }
   
    public static void selectFromPessoa(Connection conexao, String stmWhere, JTable tabelaPessoa) throws SQLException{
        ResultSet resultado;

        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM pessoa " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe, enderecoPe, tipoOrganizador, tipoParticipante, tipoAutor FROM pessoa " + stmWhere);


            String[][] dados = new String[tamanho][8];
            String virgula;


            while (resultado.next()){
                dados[i][0] = resultado.getString("nomePe");
                dados[i][1] = resultado.getString("emailPe");
                dados[i][2] = resultado.getString("instituicaoPe");
                dados[i][3] = resultado.getString("telefonePe");
                dados[i][4] = resultado.getString("nacionalidadePe");
                dados[i][5] = resultado.getString("enderecoPe");
                dados[i][6] = "";
                virgula = "";
                
                if (resultado.getString("tipoOrganizador").equals("1")){
                    dados[i][6] += "Organizador";
                    virgula = ", ";
                }
                if (resultado.getString("tipoParticipante").equals("1")){
                    dados[i][6] += virgula + "Participante";
                    virgula = ", ";
                }
                if (resultado.getString("tipoAutor").equals("1")){
                    dados[i][6] += virgula + "Autor";
                }     
                dados[i][7] = resultado.getString("idPe");
                i++;
            }

            String [] colunas = {
                "Nome", "Email","Instituição","Telefone","Nacionalidade","Endereço","Tipo","idPe"
            };

            tabelaPessoa.setModel(new javax.swing.table.DefaultTableModel(dados,colunas)); 
            tabelaPessoa.removeColumn(tabelaPessoa.getColumn("idPe"));

        }    }
    
    public static ResultSet selectFromPessoaWithPK(Connection conexao, String idPe) throws SQLException{
        return DBconnection.executeSQLSelect(conexao,"SELECT idPe, nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe, enderecoPe, tipoOrganizador, tipoParticipante, tipoAutor FROM pessoa " + idPe);
    }
    
    public static void selectFromInscrito(Connection conexao, String stmWhere, JTable tabelaInscrito) throws SQLException{
        ResultSet resultado;
         
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

            tabelaInscrito.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaInscrito.removeColumn(tabelaInscrito.getColumn("codEv"));
            tabelaInscrito.removeColumn(tabelaInscrito.getColumn("idPart"));

        }
    }
    
    public static ResultSet selectFromInscritoWithPK(Connection conexao, String codEv, String numEd, String idPart) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT nomePe, emailPe, instituicaoPe, telefonePe, nacionalidadePe, enderecoPe, nomeEv, dataInsc, tipoApresentador \n" +
"FROM busca_inscrito WHERE codEv = " + codEv + " AND numEd = " + numEd + " AND idPart = " + idPart);    
    }    

    public static void selectFromArtigo(Connection conexao, String stmWhere, JTable tabelaArtigo) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_artigo " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT idArt, tituloArt, dataApresArt, horaApresArt, nomeEv, numEd, nomePe FROM busca_artigo " + stmWhere);


            String[][] dados = new String[tamanho][7];
            String virgula;


            while (resultado.next()){
                dados[i][0] = resultado.getString("tituloArt");
                dados[i][1] = resultado.getString("dataApresArt");
                dados[i][2] = resultado.getString("horaApresArt");
                dados[i][3] = resultado.getString("nomeEv");
                dados[i][4] = resultado.getString("numEd");
                dados[i][5] = resultado.getString("nomePe");
                dados[i][6] = resultado.getString("idArt");
                i++;
            }

            String [] colunas = {
                "Título", "Data Apresentação","Hora Apresentação","Evento","Edição","Apresentador", "idArt"
            };

            tabelaArtigo.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaArtigo.removeColumn(tabelaArtigo.getColumn("idArt"));
        }
    }
    
    public static ResultSet selectFromArtigoWithPK(Connection conexao, String idArt) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT idArt, tituloArt, dataApresArt, horaApresArt, nomeEv, numEd, nomePe FROM busca_artigo WHERE idArt = " + idArt);
    }    

    public static void selectFromPatrocinador(Connection conexao, String stmWhere, JTable tabelaPatrocinador) throws SQLException{
        ResultSet resultado;
         
       resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM patrocinador " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, telefonePat, enderecoPat FROM patrocinador " + stmWhere);


            String[][] dados = new String[tamanho][4];
            String virgula;


            while (resultado.next()){
                dados[i][0] = resultado.getString("cnpjPat");
                dados[i][1] = resultado.getString("razaoSocialPat");
                dados[i][2] = resultado.getString("telefonePat");
                dados[i][3] = resultado.getString("enderecoPat");
                i++;
            }

            String [] colunas = {
                "CNPJ", "Razão Social","Telefone","Endereço"
            };

            tabelaPatrocinador.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
        }
    }
    
    public static ResultSet selectFromPatrocinadorWithPK(Connection conexao, String cnpjPat) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, telefonePat, enderecoPat FROM patrocinador WHERE cnpjPat = " + cnpjPat);
    }    

    public static void selectFromPatrocinio(Connection conexao, String stmWhere, JTable tabelaPatrocinio) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_patrocinio " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, codEv, numEd, valorPat, saldoPat, dataPat, nomeEv FROM busca_patrocinio " + stmWhere);

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

            tabelaPatrocinio.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));
            tabelaPatrocinio.removeColumn(tabelaPatrocinio.getColumn("codEv"));    
        }
    }
    
    public static ResultSet selectFromPatrocinioWithPK(Connection conexao, String codEv, String numEd, String cnpjPat) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, codEv, numEd, valorPat, saldoPat, dataPat, nomeEv FROM busca_patrocinio WHERE cnpjPat = " + cnpjPat + " AND codEv = " + codEv + " AND numEd = " + numEd );
    }    

    public static void selectFromDespesa(Connection conexao, String stmWhere, JTable tabelaDespesa) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_despesa " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT codDesp, codEv, nomeEv, numEd, cnpjPat, razaoSocialPat, codEvPat, numEdPat, dataDesp, valorDesp, descricaoDesp, nomeEvPat FROM busca_despesa " + stmWhere);


            String[][] dados = new String[tamanho][12];
            String virgula;

            while (resultado.next()){
                dados[i][0] = resultado.getString("codDesp");
                dados[i][1] = resultado.getString("codEv");
                
                dados[i][2] = resultado.getString("nomeEv");
                dados[i][3] = resultado.getString("numEd");
                dados[i][4] = resultado.getString("cnpjPat");
                
                dados[i][5] = resultado.getString("razaoSocialPat");
                dados[i][6] = resultado.getString("nomeEvPat");
                dados[i][7] = resultado.getString("codEvPat");
                dados[i][8] = resultado.getString("numEdPat");
                
                dados[i][9] = resultado.getString("dataDesp");
                dados[i][10] = resultado.getString("valorDesp");
                dados[i][11] = resultado.getString("descricaoDesp");

                i++;
            }

            String [] colunas = {
                "codDesp","codEv","Evento","Edição", "CNPJ", "Patrocinador", "Evento Patorcinio" ,"codEvPat" ,"Edição Patrocinio","Data","Valor","Descrição"
            };

            tabelaDespesa.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaDespesa.removeColumn(tabelaDespesa.getColumn("codDesp"));
            tabelaDespesa.removeColumn(tabelaDespesa.getColumn("codEvPat"));
            tabelaDespesa.removeColumn(tabelaDespesa.getColumn("codEv"));

        }
    }
    
    public static ResultSet selectFromDespesaWithPK(Connection conexao, String codEv, String numEd, String codDesp) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT nomeEv, cnpjPat, razaoSocialPat, codEvPat, numEdPat, dataDesp, valorDesp, descricaoDesp, nomeEvPat FROM busca_despesa WHERE codDesp = " + codDesp + " AND codEv = " + codEv + " AND numEd = " + numEd);
    }    

    public static void selectFromAuxilio(Connection conexao, String stmWhere, JTable tabelaAuxilio) throws SQLException{
        ResultSet resultado;
         
        resultado = DBconnection.executeSQLSelect(conexao,"SELECT count(*) as total FROM busca_auxilio " + stmWhere);
        if (resultado.next()){
            int tamanho = resultado.getInt("total");
            int i = 0;

            resultado = DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, codEvPat, numEdPat, codEvApr, numEdApr, idApr, valorAux, dataAux, tipoAux, nomeEvApr, nomeEvPat, nomePe FROM busca_auxilio " + stmWhere);


            String[][] dados = new String[tamanho][13];
            String virgula;


            while (resultado.next()){
                dados[i][0] = resultado.getString("cnpjPat");
                dados[i][1] = resultado.getString("razaoSocialPat");
                
                dados[i][2] = resultado.getString("nomeEvPat");
                dados[i][3] = resultado.getString("codEvPat");
                dados[i][4] = resultado.getString("numEdPat");
                
                dados[i][5] = resultado.getString("nomeEvApr");
                dados[i][6] = resultado.getString("codEvApr");
                dados[i][7] = resultado.getString("numEdApr");
                
                dados[i][8] = resultado.getString("idApr");
                dados[i][9] = resultado.getString("nomePe");
                dados[i][10] = resultado.getString("valorAux");
                dados[i][11] = resultado.getString("dataAux");
                dados[i][12] = resultado.getString("tipoAux");
                i++;
            }

            String [] colunas = {
                "CNPJ","Razão Social","Evento Patrocinio","codEvPat","Edição Patrocinio","Evento Apresentador","codEvApr","Edição Patrocinio","idApr","Apresentador","Valor","Data","Tipo"
            };

            tabelaAuxilio.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaAuxilio.removeColumn(tabelaAuxilio.getColumn("codEvPat"));
            tabelaAuxilio.removeColumn(tabelaAuxilio.getColumn("codEvApr"));
            tabelaAuxilio.removeColumn(tabelaAuxilio.getColumn("idApr"));

        }    }
    
    public static ResultSet selectFromAuxilioWithPK(Connection conexao, String codEvApr,String numEdApr,String idApr,String tipoAux) throws SQLException{
            return DBconnection.executeSQLSelect(conexao,"SELECT cnpjPat, razaoSocialPat, codEvPat, numEdPat, codEvApr, numEdApr, idApr, valorAux, dataAux, tipoAux, nomeEvApr, nomeEvPat, nomePe \n"
                    +"FROM busca_auxilio WHERE codEvApr = "+codEvApr+" AND numEdApr = "+numEdApr+" AND idApr = "+idApr+" AND tipoAux = '"+tipoAux+"'");
    }    
   
    
    
    
    public static int getRowByValue(JTable tabela, String column, Object value) {
        int j = tabela. getColumn(column).getModelIndex();
        TableModel model = tabela.getModel();
        
        for (int i = model.getRowCount() - 1; i >= 0; --i) {
            
           if (model.getValueAt(i, j).equals(value)) {
                    // what if value is not unique?
                    return i;
            }
        }   
        return -1;
    }

}
