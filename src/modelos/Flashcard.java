package modelos;

import java.io.Serializable;
public class Flashcard implements Serializable {
    private static final long serialVersionUID = 1L;
    private String assunto;
    private String pergunta;
    private String resposta;
    
    /**
     * Construtor da classe Flashcard.
     * @param assunto O assunto do flashcard.
     * @param pergunta A pergunta do flashcard.
     * @param resposta A resposta do flashcard.
     */
    public Flashcard(String assunto, String pergunta, String resposta) {
        this.assunto = assunto;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
    
    /**
     * Define o assunto do flashcard.
     * @param assunto O assunto a ser definido.
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    /**
     * Define a pergunta do flashcard.
     * @param pergunta A pergunta a ser definida.
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
    /**
     * Define a resposta do flashcard.
     * @param resposta A resposta a ser definida.
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    /**
     * Obtém o assunto do flashcard.
     * @return O assunto do flashcard.
     */
    public String getAssunto() {
        return this.assunto;
    }
    
    /**
     * Obtém a pergunta do flashcard.
     * @return A pergunta do flashcard.
     */
    public String getPergunta() {
        return this.pergunta;
    }
    
    /**
     * Obtém a resposta do flashcard.
     * @return A resposta do flashcard.
     */
    public String getResposta() {
        return this.resposta;
    }
}
