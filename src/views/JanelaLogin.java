package views;

import controle.Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class JanelaLogin extends JFrame {
	
    public JPasswordField campoSenha;
    public JTextField campoUsuario;
    public JButton botaoEntrar;
    public JButton botaoCadastro;
    
    public JanelaLogin() {
        inicializarUI();
    }
    
    private void inicializarUI() {
        // Configurações gerais da janela
        setBounds(100, 100, 470, 331);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Rótulo do título
        JLabel tituloLabel = new JLabel("Flashcards");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloLabel.setBounds(155, 21, 143, 56);
        getContentPane().add(tituloLabel);

        // Rótulo e campo de usuário
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usuarioLabel.setBounds(77, 92, 50, 26);
        getContentPane().add(usuarioLabel);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(150, 94, 210, 27);
        getContentPane().add(campoUsuario);

        // Rótulo e campo de senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        senhaLabel.setBounds(77, 154, 46, 14);
        getContentPane().add(senhaLabel);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(150, 149, 210, 29);
        getContentPane().add(campoSenha);

        // Botão de entrar
        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBounds(257, 187, 103, 26);
        getContentPane().add(botaoEntrar);
        
        botaoCadastro = new JButton("Cadastre-se");
        botaoCadastro.setBounds(155, 189, 91, 23);
        getContentPane().add(botaoCadastro);
    }
    
    public void associarControleLogin(Login loginControle) {
    	botaoEntrar.addActionListener(loginControle);
    	
    }
   
}
