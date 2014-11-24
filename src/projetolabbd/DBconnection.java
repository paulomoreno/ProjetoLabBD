/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolabbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** *
 * @author felipeaa
 */
public class DBconnection {
    private static Connection con = null;
    public DBconnection() throws Exception{
    }
    /**
     * Método para fechar a conexão com o banco de dados
     *
     * @param con
     * @throws SQLException
     */
    public void disconect(Connection con) throws SQLException{
        con.close();
}
    /**
     * Metodo para efetuar o commit no banco
     *
     *
     * @param con
     * @throws SQLException
     */
    public void commit(Connection con) throws SQLException{
        con.commit();
}
    /**
     * Método para efetuar o rollback no banco
     *
     * @param con
     * @throws SQLException
     */
    public void rollback(Connection con) throws SQLException{
con.rollback();
    }
    
    public static ResultSet executeSQLSelect(Connection con, String str) throws SQLException{
        Statement stmt = con.createStatement();
        return stmt.executeQuery(str);        
    }
    
/** *
     * Efetua a conexão com o banco de dados
     *
     * @return
     */
    public static Connection getConexao(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
                    System.out.println("Classe "+e);
}
try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@grad.icmc.usp.br:15214:orcl14","a7704943","a7704943");
            return con;
        }catch(Exception e){
            System.out.println("conectar"+e);
            return null;
        }
}
}


