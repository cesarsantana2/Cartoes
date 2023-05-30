package controle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.JanelaCadastro;
import modelos.*;
import modelos.Flashcard;
import modelos.Caixa;

public class CadastroController implements ActionListener{
	JanelaCadastro janelaCadastro;
	Flashcard flashcard = new Flashcard("Laboratório de Modelagem Algoritmica","No paradigma de objetos computação são impmentadas por ...", "Métodos.");
	Flashcard flashcard2 = new Flashcard("Laboratório de Modelagem Algoritmica","O que significa UML?", "Linguagem de Modelagem Unificada.");
	Flashcard flashcard3 = new Flashcard("Laboratório de Modelagem Algoritmica","Unidade fundamental de construção de um programa é uma instrução-comando ou uma ...", "instrução-expressão.");
	Flashcard flashcard4 = new Flashcard("Laboratório de Modelagem Algoritmica","A relação fundamental entre programa e computação é de ...", "descrição.");
	Flashcard flashcard5 = new Flashcard("Laboratório de Modelagem Algoritmica","O resultado de uma computação pode ser um efeito colateral ou um ...", "");
	Flashcard flashcard6 = new Flashcard("Laboratório de Modelagem Algoritmica","O passo atômico de uma computação é conhecida por ...", "ação.");
	Flashcard flashcard7 = new Flashcard("Laboratório de Modelagem Algoritmica","Uma entidade é uma coisa que existe, deve ser lembrada e ...", "é distinguível.");
	Flashcard flashcard8 = new Flashcard("Arquitetura de Software","O propósito de uma interface de módulo é de definir ...", "as suas entradas e saídas.");
	Flashcard flashcard9 = new Flashcard("Arquitetura de Software","Acoplamento e coesão são propriedades fundamentais no contexto ...", "arquitetural. ");
	Flashcard flashcard10 = new Flashcard("Arquitetura de Software"," Uma forma de módulo que existe apenas em tempo de execução chama-se?", "Componente");
	Caixa baralho = new Caixa();
	
    Colecao colecao = new Colecao();
	void associarJanela(JanelaCadastro janela) {
		janelaCadastro = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		String nome = janelaCadastro.campoNome.getText();
		String email = janelaCadastro.campoEmail.getText();
		String senha = janelaCadastro.campoSenha.getText();
		String confirmaSenha = janelaCadastro.campoConfirmarSenha.getText();
		
		if(senha.equals(confirmaSenha)) {
			
			baralho.adicionarFlashcard(flashcard);
			baralho.adicionarFlashcard(flashcard2);
			baralho.adicionarFlashcard(flashcard3);
			baralho.adicionarFlashcard(flashcard4);
			baralho.adicionarFlashcard(flashcard5);
			baralho.adicionarFlashcard(flashcard6);
			baralho.adicionarFlashcard(flashcard7);
			baralho.adicionarFlashcard(flashcard8);
			baralho.adicionarFlashcard(flashcard9);
			baralho.adicionarFlashcard(flashcard10);
			
			colecao.adicionarBaralho(baralho);
			colecao.adicionarBaralho(new Caixa());
			colecao.adicionarBaralho(new Caixa());
			
			Aprendiz usuario = new Aprendiz(2,nome, email, senha, colecao);
			UsuarioDAO.salvarUsuario(usuario);
			
		}
	}

}
