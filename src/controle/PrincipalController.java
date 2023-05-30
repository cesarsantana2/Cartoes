package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import views.JanelaPrincipal;
import modelos.Aprendiz;
import views.JanelaEditar;
import views.JanelaCards;


public class PrincipalController {
	
	private JanelaPrincipal janela;
	private Aprendiz usuario;
	
	public PrincipalController(JanelaPrincipal janela, Aprendiz usuario) {
		this.janela = janela;
		this.usuario = usuario;
		iniciarUI();
	}
	
	/**
	 * Método que configura a Janela Principal, insere o nome do usuario e 
	 * chamada o método adicionarBaralhos, que criará um card para cada baralho do usuário
	 */
	private void iniciarUI() {
		
		janela.labelNomeUsuario.setText(usuario.getNome());
		int tamanhoBaralho = usuario.getColecao().getBaralhos().size();
		adicionarBaralhos(tamanhoBaralho);
		
	}
	/**
	 * 
	 * @param qtdBaralhos
	 * Método que adiciona um card na janela para cada baralho do usuário.
	 * Manipulando o método addBaralhoComponent da instância janela. 
	 * 
	 */
	private void adicionarBaralhos(int qtdBaralhos) {	
        for (int i = 0; i < qtdBaralhos; i++) {
        	janela.addBaralhoComponent("Baralho " + (i + 1));
        	
        	JButton botaoEditar = janela.listaBotoesEditar.get(i);
        	JButton botaoJogar = janela.listaBotoesJogar.get(i);
        	
        	final int index = i; // Índice capturado para uso dentro das funções de callback
        	
        	botaoEditar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnEditarClicado(index);
				}
			});
        	
        	botaoJogar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnJogarClicado(index);
				}
			});
        }
	}
	
	/**
	 * 
	 * @param index
	 * Método que será acionado quando o botão Editar for clicado na tela principal.
	 * Cria uma instancia da JanelaEditar, associa o controller GerenciaFlashcardController.
	 * O parâmetro index representa o índice do baralho que será carregado na JanelaEditar. 
	 * 
	 */
	
	private void btnEditarClicado(int index) {
		// Lógica a ser executada quando um botão de edição for clicado (com base no índice)
		
		var janelaEditar = new JanelaEditar();
		
		janelaEditar.setVisible(true);
					
	}
	/**
	 * 
	 * @param index
	 * Método que será acionado quando o botão Jogar for clicado na tela principal.
	 * Cria uma instancia da JanelaJogo, associa o controller GerenciaFlashcardController.
	 * O parâmetro index representa o índice do baralho que será carregado na JanelaJogo. 
	 * 
	 */
	private void btnJogarClicado(int index) {
		var janelaJogo  = new JanelaCards();
		janelaJogo.setVisible(true);
	}
}
