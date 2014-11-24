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

                i++;
            }

            String [] colunas = {
                "Nome", "Descrição","Site","Total de Artigos Apresentados", "Codigo"
            };

            tabelaEvento.setModel(new javax.swing.table.DefaultTableModel(dados,colunas));  
            tabelaEvento.removeColumn(tabelaEvento.getColumn("Codigo"));
        }
    }
    
    
    
}
