import views.JanelaLogin;
import controle.Login;
import java.awt.EventQueue;


/**
 * Classe principal que inicia a aplicação.
 */
public class App{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    var janelaLogin = new JanelaLogin();
                    var controleLogin = new Login(); 
                    
                    controleLogin.associarJanelaLogin(janelaLogin);
                    janelaLogin.associarControleLogin(controleLogin);
                    janelaLogin.setVisible(true);                	
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
