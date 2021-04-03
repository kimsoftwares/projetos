package br.com.kimsoftwares.sql;
import br.com.kimsoftwares.conexao.ConexaoDB;
import br.com.kimsoftwares.dados.DadosUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosSQL { 
    
    //ADICIONA DADOS NA TABELA
    public void adicionar(DadosUsuarios usuario) {
        
        Connection conexao = ConexaoDB.getConexao();
        
        String sql = "INSERT INTO tbusuarios(idusuario, nomeusuario, cpfusuario, loginusuario, senhausuario, perfilusuario) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement smt = conexao.prepareStatement(sql);
            smt.setInt(1, usuario.getIdUsuario());
            smt.setString(2, usuario.getNomeUsuario());
            smt.setString(3, usuario.getCpfUsuario());
            smt.setString(4, usuario.getLoginUsuario());
            smt.setString(5, usuario.getSenhaUsuario());
            smt.setString(6, usuario.getPerfilUsuario());
            smt.execute();
            
            ConexaoDB.close(conexao, smt);   
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosSQL.class.getName()).log(Level.SEVERE, null, ex); 
            
            ConexaoDB.close(conexao);
        }
    }
    
    //ALTERA DADOS DA TABELA
    public void alterar(DadosUsuarios usuario) {
        
        Connection conexao = ConexaoDB.getConexao();
        
        String sql = "UPDATE tbusuarios SET nomeusuario = ?, cpfusuario = ?, loginusuario = ?, senhausuario = ?, perfilusuario = ? WHERE idusuario = ?";
        
        try {
            PreparedStatement smt = conexao.prepareStatement(sql);
            smt.setString(1, usuario.getNomeUsuario());
            smt.setString(2, usuario.getCpfUsuario());
            smt.setString(3, usuario.getLoginUsuario());
            smt.setString(4, usuario.getSenhaUsuario());
            smt.setString(5, usuario.getPerfilUsuario());
            smt.setInt(6, usuario.getIdUsuario());
            smt.execute();
            
            ConexaoDB.close(conexao, smt);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosSQL.class.getName()).log(Level.SEVERE, null, ex);   
            
            ConexaoDB.close(conexao);
        }
    } 
    
     //DELETA DADOS DA TABELA
     public void deletar(DadosUsuarios usuario) {
         
        Connection conexao = ConexaoDB.getConexao();
        
        String sql = "DELETE FROM tbusuarios WHERE idusuario=?";
        
        try {
            PreparedStatement smt = conexao.prepareStatement(sql);
            smt.setInt(1, usuario.getIdUsuario());
            smt.execute();
            
            ConexaoDB.close(conexao, smt);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosSQL.class.getName()).log(Level.SEVERE, null, ex);
            
            ConexaoDB.close(conexao);
        }
    } 
     
     public List<DadosUsuarios> getList(){
         List<DadosUsuarios> usuarios = new ArrayList<>();
         
         Connection conexao = ConexaoDB.getConexao();
         String sql = "SELECT * FROM tbusuarios";
         
         try {
            PreparedStatement smt = conexao.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();  
            
            while(rs.next()){
               DadosUsuarios usuario = new DadosUsuarios();
               usuario.setIdUsuario(rs.getInt("idusuario")); //essa string por parametro no nome da coluna na tabela
               usuario.setNomeUsuario(rs.getString("nomeusuario"));
               usuario.setCpfUsuario(rs.getString("cpfusuario"));
               usuario.setLoginUsuario(rs.getString("loginusuario"));
               usuario.setSenhaUsuario(rs.getString("senhausuario"));
               usuario.setPerfilUsuario(rs.getString("perfilusuario"));
               usuarios.add(usuario);
            }
            ConexaoDB.close(conexao, smt, rs);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! A lista não foi retornada"); 
            return null;
        }
        return usuarios;
     }
}