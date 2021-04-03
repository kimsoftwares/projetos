package br.com.kimsoftwares.dados;

public class DadosUsuarios {
    private int idUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String perfilUsuario;
    
    public DadosUsuarios() {
    }

    public DadosUsuarios(int idUsuario, String nomeUsuario, String cpfUsuario, String loginUsuario, String senhaUsuario, String perfilUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.perfilUsuario = perfilUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }  
    
    public void mostraUsuarios(){
        System.out.println("ID: " + getIdUsuario());
        System.out.println("Nome: " + getNomeUsuario());
        System.out.println("CPF: " + getCpfUsuario());
        System.out.println("Login: " + getLoginUsuario());
        System.out.println("Senha: " + getSenhaUsuario());
        System.out.println("Perfil: " + getPerfilUsuario());
        System.out.println("----------------------------------------------------");
    }
}