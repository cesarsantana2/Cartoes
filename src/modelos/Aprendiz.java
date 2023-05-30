package modelos;

import java.io.Serializable;

public class Aprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String email;
    private String nome;
    private Colecao colecao;
    private String senha;
    
    public Aprendiz(int idUsuario, String nome, String email, String senha, Colecao colecao){
 
            setIdUsuario(idUsuario);
            setNome(nome);
            setEmail(email);
            setSenha(senha);
            setColecao(colecao);
        }
  
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }
 

    public String getEmail() {
        return email;
    }

    public Colecao getColecao() {
        return colecao;
    }

    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
    private void setSenha(String senha) {
    	this.senha = senha;
    }
    
    protected void setEmail(String email) {
        this.email = email;
    }
    
    protected void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }
    
    protected boolean compararSenha(String senha) {
    	return senha.equals(this.senha);
    }
}
