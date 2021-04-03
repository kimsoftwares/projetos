package br.com.kimsoftwares.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexaoDB {

    public static Connection getConexao() {
        //java.sql.Connection conexao = null;
        //A linha a baixo chama o drive de conexão com o banco de dados.
        //Armazenando informações referente a conexão com banco de dados.
        String conector = "jdbc";
        String bancodedados = "mysql";
        String ip = "127.0.0.1";
        String porta = "3309";
        String nomedobanco = "dbcadastros";
        String usuario = "root";
        //String senha = "E@j#l$g%23071977";
        String senha = "chk5368wja";
        String url = conector + ":" + bancodedados + "://" + ip + ":" + porta + "/" + nomedobanco;

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.getMessage();  
        }
        return null;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public static void close(Connection connection, Statement smt){
        close(connection);
        try {
            if (smt != null) {
                smt.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public static void close(Connection connection, Statement stmt, ResultSet rs){
        close(connection);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}