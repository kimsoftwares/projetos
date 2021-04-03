package br.com.kimsoftwares.sql;

import br.com.kimsoftwares.conexao.ConexaoDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutoIncremento {
    
    public int idUsuario(){
        int idTBUsuario = 1;
        
        Connection conexao = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        
        conexao = ConexaoDB.getConexao();
        //ConexaoDB conexao = new ConexaoDB();
        String sql = "SELECT MAX(idusuario) FROM tbusuarios";
        try {
           smt = conexao.prepareStatement(sql); 
           rs = smt.executeQuery();
           
           while(rs.next()){
               idTBUsuario = rs.getInt(1) + 1;   
           }
           
           ConexaoDB.close(conexao, smt, rs);
           
        }catch(SQLException e) {
            System.out.println("Erro no id do usuário " + e.getMessage()); 
            ConexaoDB.close(conexao, smt, rs);
        }
        return idTBUsuario;
    }
}
