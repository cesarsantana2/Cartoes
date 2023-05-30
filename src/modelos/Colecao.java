package modelos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Colecao implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Caixa> baralhos; 
    public Colecao() {
        baralhos = new ArrayList<>();
    }
    public void adicionarBaralho(Caixa baralho) {
        baralhos.add(baralho);
    }
    public void removerBaralho(Caixa baralho) {
        baralhos.remove(baralho);
    }
    public List<Caixa> getBaralhos() {
        return baralhos;
    }
    public void retrocederFlashcard(Flashcard flashcard) {
        Caixa baralhoAtual = encontrarBaralhoComFlashcard(flashcard);
        int indexBaralhoAtual = baralhos.indexOf(baralhoAtual);
        
        if (indexBaralhoAtual > 0) {
            Caixa baralhoAnterior = baralhos.get(indexBaralhoAtual - 1);
            baralhoAtual.removerFlashcard(flashcard);
            baralhoAnterior.adicionarFlashcard(flashcard);
        }
    }
    
    public void avancarFlashcard(Flashcard flashcard) {
        Caixa baralhoAtual = encontrarBaralhoComFlashcard(flashcard);
        int indexBaralhoAtual = baralhos.indexOf(baralhoAtual);
        
        if (indexBaralhoAtual < baralhos.size() - 1) {
            Caixa baralhoSeguinte = baralhos.get(indexBaralhoAtual + 1);
            baralhoAtual.removerFlashcard(flashcard);
            baralhoSeguinte.adicionarFlashcard(flashcard);
        }
    }
    
    private Caixa encontrarBaralhoComFlashcard(Flashcard flashcard) {
        for (Caixa baralho : baralhos) {
            if (baralho.contemFlashcard(flashcard)) {
                return baralho;
            }
        }
        return null;
    }
	

}
