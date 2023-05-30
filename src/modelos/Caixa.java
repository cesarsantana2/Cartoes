package modelos;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Caixa  implements Serializable {
	private static final long serialVersionUID = 1L;
private List<Flashcard> flashcards;
    
    public Caixa() {
        flashcards = new ArrayList<>();
    }
    
    public void adicionarFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }
    
    public void removerFlashcard(Flashcard flashcard) {
        flashcards.remove(flashcard);
    }
    
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }
    
    public boolean contemFlashcard(Flashcard flashcard) {
        return flashcards.contains(flashcard);
    }
    
    public int getTamanhoBaralho() {
    	return flashcards.size();
    }

}
