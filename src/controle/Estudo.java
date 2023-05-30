package controle;

import modelos.Caixa;
import views.JanelaCards;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Estudo {

	private JanelaCards janela;
	private Caixa baralho;

	public Estudo(JanelaCards janela, Caixa baralho) {
		this.baralho = baralho;
		this.janela = janela;
		inicializar();
		// adiciona métodos callbacks aos botões Sortear, Virar, e Próximo da JanelaJogo

		if (janela.qtdTotalFlashcards > 0) {
			configurarBotaoSortear();
			configurarBotaoVirar();
			configurarBotaoProximo();

		}

	}

	private void configurarBotaoSortear() {
		janela.btnSortear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Index máximo do baralho = quantidade total de flashcards - 1
				int max = baralho.getTamanhoBaralho() - 1;
				int flashcardAtualIndex = sortearNumero(0, max);
				String pergunta = baralho.getFlashcards().get(flashcardAtualIndex).getPergunta();
				janela.flashcardText.setText(pergunta);

			}
		});
	}

	private void configurarBotaoVirar() {
		janela.btnVirar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resposta = baralho.getFlashcards().get(janela.flashcardAtualIndex).getResposta();
				janela.flashcardText.setText(resposta);
			}
		});
	}

	private void configurarBotaoProximo() {
		janela.btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TESTAR
				if (janela.qtdTotalFlashcards > 0 && janela.flashcardAtualIndex < baralho.getTamanhoBaralho()) {
					janela.flashcardAtualIndex++;
					String pergunta = baralho.getFlashcards().get(janela.flashcardAtualIndex).getPergunta();
					janela.flashcardText.setText(pergunta);
					janela.qtdTotalFlashcards--;
					janela.labelQtdRestante.setText("" + janela.qtdTotalFlashcards);
				}

			}
		});
	}

	private void inicializar() {
		// Inicia as variáveis de estado
		janela.flashcardAtualIndex = 0;
		janela.qtdTotalFlashcards = baralho.getTamanhoBaralho();

		if (janela.qtdTotalFlashcards > 0) {
			String pergunta = baralho.getFlashcards().get(janela.flashcardAtualIndex).getPergunta();

			// Gerencia a janela com valores iniciais das variáveis de estado.
			janela.tituloJanela.setText("Baralho");
			janela.labelQtdLembrados.setText("" + janela.qdtFlashcardsLembrados);
			janela.labelQtdRestante.setText("" + janela.qtdTotalFlashcards);
			janela.flashcardText.setText(pergunta);

		}

	}

	private int sortearNumero(int min, int max) {

		Random random = new Random();

		int diferenca = max - min;

		// Gera um número aleatório dentro do intervalo (0, diferenca)
		int numeroAleatorio = random.nextInt(diferenca + 1);

		// Soma o número aleatório ao mínimo para obter um número dentro do intervalo
		// (min, max)
		int numeroSorteado = numeroAleatorio + min;

		return numeroSorteado;
	}
}
