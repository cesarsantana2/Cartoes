package modelos;

public class Teste {
	
	Caixa baralho = new Caixa();
	Colecao colecao = new Colecao();
	Aprendiz usuario;
	
	public Teste() {
		for(int i = 0; i < 10; i++) {
			baralho.adicionarFlashcard(new Flashcard("Assunto", "Pergunta", "Resposta"));
	}
		colecao.adicionarBaralho(baralho);
		colecao.adicionarBaralho(new Caixa());
		colecao.adicionarBaralho(new Caixa());
		
		usuario = new Aprendiz(2, "Fubã", "fuba@gmail.com", "1234", colecao);
		UsuarioDAO.salvarUsuario(usuario);
		
}
	
}

