package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class JanelaEditar extends JFrame {
    private JPanel contentPane;
    private JScrollPane scrollPane;
    public JButton btnAdicionarFlashcard;
    public JLabel tituloJanela;
    
    /**
     * Create the frame.
     */
    public JanelaEditar() {
        setBounds(100, 100, 532, 456);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        scrollPane = new JScrollPane(contentPane);
        setContentPane(scrollPane);

        tituloJanela = new JLabel("Baralho 1");
        tituloJanela.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tituloJanela.setBounds(47, 30, 87, 34);
        contentPane.add(tituloJanela);

        btnAdicionarFlashcard = new JButton("Adicionar Flashcard");
        btnAdicionarFlashcard.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnAdicionarFlashcard.setBounds(335, 37, 147, 23);
        contentPane.add(btnAdicionarFlashcard);
        
    }

    public void adicionarJTextPane(JTextPane textPane, int x, int y) {
        contentPane.add(textPane);
        textPane.setBounds(x, y, 119, 113);
    }

    public void adicionarBotaoExcluir(JButton btnExcluir, int x, int y) {
        contentPane.add(btnExcluir);
        btnExcluir.setBounds(x, y, 89, 23);
    }
}
