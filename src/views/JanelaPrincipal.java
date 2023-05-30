package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import controle.*;
import javax.swing.JButton;
import java.util.List;
import java.util.ArrayList;

public class JanelaPrincipal extends JFrame {

    private JPanel contentPane;
    public JLabel labelNomeUsuario;
    private PrincipalController controle;
    private int currentX = 10;
    private int currentY = 60; // Altera a posição inicial Y para 60
    
    public List<JButton> listaBotoesEditar;
    public List<JButton> listaBotoesJogar;

    public JanelaPrincipal() {
    	//Configurações da Janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 582, 444);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Define o layout absoluto
        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(scrollPane);
        
        //Criação das listas de botoes 
        this.listaBotoesEditar = new ArrayList<>();
		this.listaBotoesJogar = new ArrayList<>();
		
		//Criação da Label com o nome do usuário
        labelNomeUsuario = new JLabel("Nome do Usuário");
        labelNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labelNomeUsuario);
        labelNomeUsuario.setBounds(10, 10, 546, 30);

        setLocationRelativeTo(null);
    }
    /**
     * 
     * @param nomeBaralho
     * 
     * Método que cria cards que representam os baralhos de flashcards do usuário, cria dois 
     * botões em conjunto: Editar e Jogar, que acionaram chamadas de métodos callbacks controlados pela c
     * classe PrincipalController
     * 
     */
    public void addBaralhoComponent(String nomeBaralho){
    	
        JPanel baralhoPanel = new JPanel();
        baralhoPanel.setPreferredSize(new Dimension(125, 100)); // Define o tamanho máximo do painel do baralho
        baralhoPanel.setLayout(new BorderLayout());
        baralhoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextPane txtpnBaralho = new JTextPane();
        txtpnBaralho.setText(nomeBaralho);
        txtpnBaralho.setPreferredSize(new Dimension(125, 50)); // Altura reduzida para 50
        txtpnBaralho.setMaximumSize(new Dimension(125, 50)); // Define a altura máxima como 50
        txtpnBaralho.setEditable(false); // Torna o JTextPane não editável

        JButton btnEditar = new JButton("Editar");
        btnEditar.setMaximumSize(new Dimension(125, 20)); // Define a altura máxima do botão Editar como 20
        listaBotoesEditar.add(btnEditar);
        
        JButton btnJogar = new JButton("Jogar");
        btnJogar.setMaximumSize(new Dimension(125, 20)); // Define a altura máxima do botão Jogar como 20
        listaBotoesJogar.add(btnJogar);

        JPanel buttonsPanel = new JPanel(); // Painel para os botões
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        buttonsPanel.add(Box.createHorizontalGlue()); // Alterado para criar espaço horizontal entre o JTextPane e os botões
        buttonsPanel.add(btnEditar);
        buttonsPanel.add(btnJogar);

        baralhoPanel.add(txtpnBaralho, BorderLayout.NORTH);
        baralhoPanel.add(buttonsPanel, BorderLayout.CENTER);

        contentPane.add(baralhoPanel);
        baralhoPanel.setBounds(currentX, currentY, 125, 100);

        currentX += 145; // Atualiza a posição X para a próxima célula

        if (currentX + 125 > contentPane.getWidth()) {
            currentX = 10; // Reinicia a posição X se ultrapassar a largura da janela
            currentY += 110; // Atualiza a posição Y para a próxima linha
        }
        
        revalidate();
    }

    public void associarControle(PrincipalController controle) {
        this.controle = controle;
    }
}
