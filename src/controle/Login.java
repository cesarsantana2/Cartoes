package controle;

import modelos.Aprendiz;
import modelos.UsuarioDAO;
import views.JanelaCadastro;
import views.JanelaLogin;
import views.JanelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login  implements ActionListener{
	
	JanelaLogin janela;
	Aprendiz usuario;
	
	public void associarJanelaLogin(JanelaLogin janelaLogin){
		janela = janelaLogin;
		
		janelaLogin.botaoCadastro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		var janelaCadastro = new JanelaCadastro();
        		var controleCadastro = new CadastroController();
        		controleCadastro.associarJanela(janelaCadastro);
        		janelaCadastro.botaoCadastrar.addActionListener(controleCadastro);
        		janelaCadastro.setVisible(true);
        	}
        });
	}
	
	public void actionPerformed(ActionEvent e) {
		
	String email = janela.campoUsuario.getText();
	String senha = new String(janela.campoSenha.getPassword());
	
	usuario = UsuarioDAO.logarUsuario(email, senha);
	
	if(usuario != null){
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        

        janelaPrincipal.setVisible(true);
        janela.dispose();
		
	} else {
		// Tratar erro no Login
	}
			
	}
}
