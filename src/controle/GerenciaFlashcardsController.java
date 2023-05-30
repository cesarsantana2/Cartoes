package controle;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.JanelaEditar;
import views.JanelaCards;
import views.JanelaAdicionarFlashcard;
import modelos.Flashcard;
import modelos.Caixa;
import modelos.Colecao;
import javax.swing.JOptionPane;

public class GerenciaFlashcardsController {
    private JanelaEditar janela;
    private Caixa baralho;
    private List<JButton> listaBotoesExcluir;
    private JanelaAdicionarFlashcard janelaAdicionar;
    private JanelaCards janelaJogo;
    private Colecao colecao;

    // Construtor controle da JanelaEditar // Adiciona Flashcards e botões exluir
    
    public GerenciaFlashcardsController(JanelaEditar janela, Caixa baralho) {
    	
        this.janela = janela;
        this.baralho = baralho;
        listaBotoesExcluir = new ArrayList<>();
        
        configuraJanelaEditar();

        janela.btnAdicionarFlashcard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAdicionar = new JanelaAdicionarFlashcard();
                janelaAdicionar.setVisible(true);
            }
        });
    }
    
    public GerenciaFlashcardsController(JanelaAdicionarFlashcard janelaAdicionar, Caixa baralho) {
    	
    	janelaAdicionar.botaoAdicionar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String assunto = janelaAdicionar.campoAssunto.getText();
    			String pergunta = janelaAdicionar.campoPergunta.getText();
    			String resposta = janelaAdicionar.campoResposta.getText();
    			
    			Flashcard novoFlashcard = new Flashcard(assunto, pergunta, resposta);
    			baralho.adicionarFlashcard(novoFlashcard);
    		}
    	});
    	
    }
    // Construtor para controle da JanelaJogo // avançar e retroceder
    public GerenciaFlashcardsController(JanelaCards janela, Colecao colecao, Caixa baralho) {
    	
    	this.janelaJogo = janela;
    	this.colecao = colecao;
    	this.baralho = baralho;
    	adicionarActionListenerJanelaJogo();
    	
    }
    
    private void adicionarActionListenerJanelaJogo() {
    	
    	janelaJogo.btnLembrei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Atualiza a quantidade de flashcards lembrados
            	janelaJogo.qdtFlashcardsLembrados = janelaJogo.qdtFlashcardsLembrados + 1;
            	janelaJogo.labelQtdLembrados.setText("" + janelaJogo.qdtFlashcardsLembrados );
            	//Avança com um flashcard para a caixa (Baralho) seguinte
            	//Para isso, chama o método avancarFlashcard, passando o flashcard, correspondente ao índice
            	//atual da janelaJogo
            	colecao.avancarFlashcard(baralho.getFlashcards().get(janelaJogo.flashcardAtualIndex));
            	
            	
            }});
    	
    	janelaJogo.btnNaoLembrei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// Retrocede um flashcard para caixa (Baralho) anterior.
            	colecao.retrocederFlashcard(baralho.getFlashcards().get(janelaJogo.flashcardAtualIndex));
            	
            }});
    }

    private void configuraJanelaEditar() {
    	this.janela.tituloJanela.setText("Baralho"  );
        criarElementosJanelaEditar(baralho);
        adicionarActionListeners();
    }

    private void criarElementosJanelaEditar(Caixa baralho) {
        int row = 0;
        int col = 0;

        for (int i = 0; i < baralho.getTamanhoBaralho(); i++) {
            String nome = baralho.getFlashcards().get(i).getPergunta();

            JTextPane textPane = new JTextPane();
            textPane.setText(nome);
            janela.adicionarJTextPane(textPane, 37 + col * 168, 80 + row * 168);

            JButton btnExcluir = new JButton("Excluir");
            janela.adicionarBotaoExcluir(btnExcluir, 47 + col * 168, 204 + row * 168);
            listaBotoesExcluir.add(btnExcluir);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }
    
 
    private void adicionarActionListeners() {
        for (int i = 0; i < listaBotoesExcluir.size(); i++) {
            final int index = i; // Índice final para ser acessado no ActionListener

            JButton btnExcluir = listaBotoesExcluir.get(i);
            btnExcluir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    excluirFlashcard(index);
                }
            });
        }
    }

    private void excluirFlashcard(int index) {
        int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Flashcard", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            Flashcard flashcard = baralho.getFlashcards().get(index);
            baralho.removerFlashcard(flashcard);
        }
    }
}
