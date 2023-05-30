package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JanelaCadastro extends JFrame {

	private JPanel container;
	public JTextField campoEmail;
	public JTextField campoNome;
	public JTextField campoSenha;
	public JTextField campoConfirmarSenha;
	public JButton botaoCadastrar;

	public JanelaCadastro() {
		
		setBounds(100, 100, 457, 368);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(container);
		container.setLayout(null);
		
		JLabel tituloJanela = new JLabel("Cadastrar Usuário");
		tituloJanela.setHorizontalAlignment(SwingConstants.CENTER);
		tituloJanela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloJanela.setBounds(155, 32, 150, 14);
		container.add(tituloJanela);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNome.setBounds(80, 79, 46, 14);
		container.add(labelNome);
		
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(80, 124, 46, 14);
		container.add(labelEmail);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSenha.setBounds(80, 170, 46, 14);
		container.add(labelSenha);
		
		JLabel labelConfirmarSenha = new JLabel("Confirmar Senha:");
		labelConfirmarSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		labelConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConfirmarSenha.setBounds(10, 213, 116, 14);
		container.add(labelConfirmarSenha);
		
		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrar.setBounds(274, 256, 89, 27);
		container.add(botaoCadastrar);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoEmail.setBounds(136, 119, 227, 27);
		container.add(campoEmail);
		campoEmail.setColumns(10);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoNome.setColumns(10);
		campoNome.setBounds(136, 74, 227, 27);
		container.add(campoNome);
		
		campoSenha = new JTextField();
		campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoSenha.setColumns(10);
		campoSenha.setBounds(136, 165, 227, 27);
		container.add(campoSenha);
		
		campoConfirmarSenha = new JTextField();
		campoConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoConfirmarSenha.setColumns(10);
		campoConfirmarSenha.setBounds(136, 208, 227, 27);
		container.add(campoConfirmarSenha);
	}

}
