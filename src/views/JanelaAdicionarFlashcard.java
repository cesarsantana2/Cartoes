package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaAdicionarFlashcard extends JFrame {

	private JPanel contentPane;
	public  JTextField campoAssunto;
	public JTextArea campoPergunta;
	public JButton botaoAdicionar;
	public JTextArea campoResposta;
	
	

	/**
	 * Create the frame.
	 */
	public JanelaAdicionarFlashcard() {
		setBounds(100, 100, 380, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPergunta = new JLabel("Pergunta:");
		labelPergunta.setHorizontalAlignment(SwingConstants.LEFT);
		labelPergunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPergunta.setBounds(23, 128, 70, 14);
		contentPane.add(labelPergunta);
		
		JLabel tituloJanela = new JLabel("Adicionar Flashcard");
		tituloJanela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloJanela.setBounds(105, 26, 156, 26);
		tituloJanela.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloJanela);
		
		JLabel labelAssunto = new JLabel("Assunto:");
		labelAssunto.setHorizontalAlignment(SwingConstants.LEFT);
		labelAssunto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAssunto.setBounds(23, 72, 55, 14);
		contentPane.add(labelAssunto);
		
		JLabel labelResposta = new JLabel("Resposta:");
		labelResposta.setHorizontalAlignment(SwingConstants.LEFT);
		labelResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelResposta.setBounds(23, 238, 70, 14);
		contentPane.add(labelResposta);
		
		campoPergunta = new JTextArea();
		campoPergunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoPergunta.setBounds(23, 153, 316, 74);
		contentPane.add(campoPergunta);
		
		campoResposta = new JTextArea();
		campoResposta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoResposta.setBounds(23, 263, 316, 81);
		contentPane.add(campoResposta);
		
		campoAssunto = new JTextField();
		campoAssunto.setBounds(23, 91, 316, 26);
		contentPane.add(campoAssunto);
		campoAssunto.setColumns(10);
		
		botaoAdicionar = new JButton("Adicionar Flashcard");
		botaoAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoAdicionar.setBounds(183, 366, 156, 33);
		contentPane.add(botaoAdicionar);
	}
}
