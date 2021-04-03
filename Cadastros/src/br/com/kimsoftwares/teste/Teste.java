package br.com.kimsoftwares.teste;

import br.com.kimsoftwares.dados.DadosUsuarios;
import br.com.kimsoftwares.sql.AutoIncremento;
import br.com.kimsoftwares.sql.UsuariosSQL;
import java.util.List;


public class Teste {
    public static void main(String[] args) {
         /**INSERIR DADOS NA TABELA USUARIO
        AutoIncremento id = new AutoIncremento();
        
        DadosUsuarios usuario = new DadosUsuarios();
        usuario.setIdUsuario(id.idUsuario());
        usuario.setNomeUsuario("Giovana Oliveira de Souza");
        usuario.setCpfUsuario("48959258890");
        usuario.setLoginUsuario("Giovana");
        usuario.setSenhaUsuario("1234");
        usuario.setPerfilUsuario("Cliente");
        
        UsuariosSQL add = new UsuariosSQL();
        add.adicionar(usuario);
        **/
        
        /** ALTERAR DADOS DA TABELA USUARIOS  
        DadosUsuarios usuario = new DadosUsuarios();
        usuario.setIdUsuario(1);
        usuario.setNomeUsuario("Elmar Oliveira de Souza");
        usuario.setCpfUsuario("03198951658");
        usuario.setLoginUsuario("Elmar");
        usuario.setSenhaUsuario("1234");
        usuario.setPerfilUsuario("Adminstrador");
        
        UsuariosSQL add = new UsuariosSQL();
        add.alterar(usuario);
        **/
       
        /**DELETA DADOS DA TABELA USUARIOS   
        DadosUsuarios usuario = new DadosUsuarios();
        usuario.setIdUsuario(1);
        
        UsuariosSQL add = new UsuariosSQL();
        add.deletar(usuario);
        **/
        
        //EXIBE OS DADOS DA TABELA
        UsuariosSQL usuarios = new UsuariosSQL();
        List<DadosUsuarios> usuario = usuarios.getList();
        
        if(usuarios != null){
            System.out.println("DADOS DA TABELA USUARIOS");
            for(int x = 0; x < usuario.size(); x++){
                usuario.get(x).mostraUsuarios();
            }
        }else{
            System.out.println("Lista Nula");
        }
        
    }
}    