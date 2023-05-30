package views;

import modelos.Caixa;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JanelaCards extends JFrame {

	private JPanel contentPane;
	public JButton btnSortear;
	public JButton btnNaoLembrei;
	public JButton btnLembrei;
	public JButton btnProximo;
	public JButton btnVirar;
	public JLabel tituloJanela;
	public JTextPane flashcardText;
	public JLabel labelQtdLembrados;
	public JLabel labelQtdRestante;
	
	public int flashcardAtualIndex;
	public int qdtFlashcardsLembrados;
	public int qtdTotalFlashcards;
	
	
	public JanelaCards() {
		
		setBounds(100, 100, 349, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelQdtFlashcard = new JLabel("Flashcards restantes:");
		labelQdtFlashcard.setBounds(10, 55, 109, 14);
		contentPane.add(labelQdtFlashcard);
		
		tituloJanela = new JLabel("Baralho 1");
		tituloJanela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloJanela.setBounds(10, 22, 94, 14);
		contentPane.add(tituloJanela);
		
		JLabel labelFlashcardLembrados = new JLabel("Flashcards lembrados :");
		labelFlashcardLembrados.setBounds(186, 55, 116, 14);
		contentPane.add(labelFlashcardLembrados);
		
		flashcardText = new JTextPane();
		flashcardText.setEditable(false);
		flashcardText.setText("Qual é a pergunta?");
		flashcardText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		flashcardText.setBounds(65, 99, 202, 187);
		contentPane.add(flashcardText);
		
		btnSortear = new JButton("Sortear");
		btnSortear.setBounds(241, 20, 71, 23);
		contentPane.add(btnSortear);
		
		btnNaoLembrei = new JButton("Não lembrei");
		btnNaoLembrei.setBounds(69, 331, 94, 31);
		contentPane.add(btnNaoLembrei);
		
		btnLembrei = new JButton("Lembrei");
		btnLembrei.setBounds(173, 331, 94, 31);
		contentPane.add(btnLembrei);
		
		btnProximo = new JButton(">>");
		btnProximo.setBounds(277, 200, 49, 23);
		contentPane.add(btnProximo);
		
		btnVirar = new JButton("Virar");
		btnVirar.setBounds(139, 297, 61, 23);
		contentPane.add(btnVirar);
		
		labelQtdLembrados = new JLabel("0");
		labelQtdLembrados.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdLembrados.setBounds(300, 55, 23, 14);
		contentPane.add(labelQtdLembrados);
		
		labelQtdRestante = new JLabel("0");
		labelQtdRestante.setHorizontalAlignment(SwingConstants.CENTER);
		labelQtdRestante.setBounds(112, 55, 23, 14);
		contentPane.add(labelQtdRestante);
	}
}
